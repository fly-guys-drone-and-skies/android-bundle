package com.dji.sdk.sample.tigersalvage;

import static android.os.SystemClock.sleep;

import android.location.Location;

import com.dji.sdk.sample.internal.controller.DJISampleApplication;
import com.dji.sdk.sample.internal.utils.ToastUtils;
import com.dji.sdk.sample.tigersalvage.proto.generated.Route;
import com.dji.sdk.sample.tigersalvage.Sender;
import com.dji.sdk.sample.tigersalvage.WaypointMissionList;
import com.dji.sdk.sample.tigersalvage.OperatorListener;

import com.dji.sdk.sample.tigersalvage.proto.generated.RoutePoint;
import com.dji.sdk.sample.tigersalvage.proto.generated.RouteArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.InflaterOutputStream;
import dji.common.error.DJIError;
import dji.common.error.DJIWaypointV2Error;
import dji.common.flightcontroller.FlightControllerState;
import dji.common.flightcontroller.LocationCoordinate3D;
import dji.common.flightcontroller.RTKState;
import dji.common.mission.waypoint.WaypointMission;
import dji.common.mission.waypoint.Waypoint;
import dji.common.mission.waypoint.WaypointMissionFlightPathMode;
import dji.common.mission.waypoint.WaypointMissionFinishedAction;
import dji.common.mission.waypoint.WaypointMissionHeadingMode;
import dji.common.mission.waypointv2.Action.WaypointV2Action;
import dji.common.mission.waypointv2.WaypointV2Mission;
import dji.common.mission.waypointv2.WaypointV2MissionDownloadEvent;
import dji.common.mission.waypointv2.WaypointV2MissionExecutionEvent;
import dji.common.mission.waypointv2.WaypointV2MissionState;
import dji.common.mission.waypointv2.WaypointV2MissionTypes;
import dji.common.mission.waypointv2.WaypointV2MissionUploadEvent;
import dji.common.model.LocationCoordinate2D;
import dji.common.useraccount.UserAccountState;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.sdk.base.BaseProduct;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.flightcontroller.RTK;
import dji.sdk.mission.MissionControl;
import dji.sdk.mission.waypoint.WaypointMissionOperator;
import dji.sdk.mission.waypoint.WaypointV2MissionOperatorListener;
import dji.sdk.products.Aircraft;
import dji.sdk.sdkmanager.DJISDKManager;
import dji.sdk.useraccount.UserAccountManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

    //https://github.com/DJI-Mobile-SDK-Tutorials/Android-GSDemo-GoogleMap/blob/382aea5db4601499aa225477b0a44297314563b4/GSDemo/app/src/main/java/com/dji/GSDemo/GoogleMap/Waypoint2Activity.java

    /**
     * ## Waypoint Mission Overview

You can create and execute a waypoint mission using the waypoint mission operator by following these steps.

- First create an instance of `WaypointMission` using the builder interface, adding your waypoints, actions and change any custom settings as before. After `WaypointMission` is constructed with the builder, it is immutable so as to distinguish between a waypoint mission that is actively being created and modified, and the in progress immutable waypoint mission that is returned by the mission operator.
- Run `checkParameters` to make sure the internal state of the mission plan is valid.
- Load the mission into the operator for validation by calling `loadMission`
- Upload the mission  to the product by calling `uploadMission`
- After the upload completes, start the mission by calling `startMission`

## Next Steps
You can read more about [Mission Operators](./API_Reference/Components/WaypointMission/DJIWaypointMission_DJIWaypointMissionOperator.html) and [Mission Control](./API_Reference/Components/MissionControl/DJIMissionControl.html) in their class documentation. You can also take a look at the sample app to learn how to use the new missions interfaces.
     */

public class MissionHandler {
    private static MissionHandler missionHandler;

    public static WaypointMission.Builder waypointMissionBuilder;

    private static WaypointMissionOperator operator;
    private WaypointV2MissionTypes.MissionFinishedAction mFinishedAction = WaypointV2MissionTypes.MissionFinishedAction.NO_ACTION;
    private WaypointMissionHeadingMode mHeadingMode = WaypointMissionHeadingMode.AUTO;
    private WaypointV2MissionTypes.MissionGotoWaypointMode firstMode = WaypointV2MissionTypes.MissionGotoWaypointMode.SAFELY;
    //private WaypointV2ActionDialog mActionDialog;
    private List<WaypointV2Action> v2Actions;
    private boolean canUploadAction;
    private boolean canStartMission;
    private float mSpeed = 10.0f;

    private CompletionCallback completionCallback;

    private WaypointMissionList waypointMissionList;

    public static MissionHandler getInstance() {
        if (missionHandler == null) {
            missionHandler = new MissionHandler();
        }

        return missionHandler;
    }

    private MissionHandler() {
        //create mission control here and set to global
        operator = MissionControl.getInstance().getWaypointMissionOperator();
        completionCallback = (DJIError err) -> {
            if (err != null) {
                ToastUtils.setResultToToast(err.toString());
                System.out.println(err);
            }
        };
    }

    public List<Waypoint> buildWaypointArray(RouteArray route){
        List<Waypoint> waypointList = new ArrayList<>();

        for (RoutePoint routePoint : route.getWaypointsList()){
            Waypoint waypoint = new Waypoint(routePoint.getLocation().getLat(), routePoint.getLocation().getLong(), routePoint.getLocation().getAlt());
            waypoint.speed = routePoint.getSpeed();

            waypointList.add(waypoint);
        }

        return waypointList;
    }

    private ArrayList<List<Waypoint>> buildWaypointListArray(RouteArray route) {
        List<Waypoint> waypointList = buildWaypointArray(route);
        ArrayList<List<Waypoint>> waypointListArray = new ArrayList<>();

        // 99 is maximum number of waypoints in mission.
        for (int i = 0; i < waypointList.size(); i += 99) { // there has to be a better way...
            if ((waypointList.size() - i) < 99) {
                waypointListArray.add(new ArrayList(waypointList.subList(i, waypointList.size() - 1)));
            }
            else {
                waypointListArray.add(new ArrayList(waypointList.subList(i, i + 99)));
            }
        }
        return waypointListArray;
    }

    public void routeProcessor(RouteArray route) {
        if (waypointMissionBuilder == null) {
            waypointMissionBuilder = new WaypointMission.Builder();
            //might need to make new waypoint mission and build into that var
        } //else new flight is being uploaded - handle it

        ArrayList<List<Waypoint>> waypointListArray = buildWaypointListArray(route);
        // ToastUtils.setResultToToast("waypoint count " + route.getWaypointsList().size());
        ArrayList<WaypointMission> missionList = new ArrayList<>();

        for (List<Waypoint> waypointList : waypointListArray) {
            WaypointMission mission = waypointMissionBuilder.
                    headingMode(mHeadingMode).
                    autoFlightSpeed(10f).
                    maxFlightSpeed(15f).
                    finishedAction(WaypointMissionFinishedAction.NO_ACTION).
                    setExitMissionOnRCSignalLostEnabled(true).
                    flightPathMode(WaypointMissionFlightPathMode.CURVED).
                    waypointCount(waypointList.size()).
                    waypointList(waypointList).
                    build();
            missionList.add(mission);
        }
        waypointMissionList = new WaypointMissionList(missionList);

        loadNextMission();

        ToastUtils.setResultToToast("Operator state");
        ToastUtils.setResultToToast(operator.getCurrentState().toString());


        ToastUtils.setResultToToast("GOGOGO");


        //at this state, mission operator is verifying mission
        //once operator.getCurrentState().equals(WaypointV2MissionState.READY_TO_UPLOAD)
        //upload flight by operator.uploadmission()
        // once operator.getCurrentState().equals(WaypointV2MissionState.READY_TO_EXECUTE)
        // start mission by operator.startMission `startMission`
        

    }

    private void loadNextMission() {
        WaypointMission mission = waypointMissionList.nextMission();
        ToastUtils.setResultToToast(mission.toString());
        DJIError loadError = operator.loadMission(mission);

        if (loadError != null) {
            ToastUtils.setResultToToast("LOAD ERROR");
            ToastUtils.setResultToToast(loadError.getDescription());
        }
        else {
            ToastUtils.setResultToToast("LOAD SUCCESS");
            ToastUtils.setResultToToast(operator.getLoadedMission().getWaypointList().toString());
        }
    }


    public void setupFlight() {
        FlightController mFlightController = DJISampleApplication.getAircraftInstance().getFlightController();
        mFlightController.setHomeLocationUsingAircraftCurrentLocation(completionCallback);
        mFlightController.startTakeoff(completionCallback);
    }

    public static String getStatus(){
        return operator.getCurrentState().toString();
    }


    public void startFlight(){
        operator.addListener(new OperatorListener(operator, completionCallback, waypointMissionList));

        operator.uploadMission(
            (DJIError uploadError) -> {
                if (uploadError != null) {
                    ToastUtils.setResultToToast("Upload mission error");

                    ToastUtils.setResultToToast(uploadError.getDescription());
                }
                else {
                    ToastUtils.setResultToToast("Upload mission success, going to start mission ");

                    ToastUtils.setResultToToast(operator.getCurrentState().toString());
                    operator.startMission(completionCallback);
                }
            }
        );


        ToastUtils.setResultToToast(operator.getCurrentState().toString());
    }

    public void endFlight(){
        operator.stopMission(completionCallback);
        ToastUtils.setResultToToast(operator.getCurrentState().toString());
    }

    public void pauseFlight(){
        //if executing, 
        operator.pauseMission(completionCallback);
        ToastUtils.setResultToToast(operator.getCurrentState().toString());
    }

    public void resumeFlight(){
        //operator.recoverMission()
    }


    /*public void Send() {
        try {
            Sender.send(compress(greeting.toByteArray()), "bae-exchange", "mission", "greeting");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    //TODO add to interface or add to sender class
    public static byte[] compress(byte[] message) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterStream = new InflaterOutputStream(byteStream);
        inflaterStream.write(message, 0, message.length);
        inflaterStream.finish();

        return byteStream.toByteArray();
        
    }
}
