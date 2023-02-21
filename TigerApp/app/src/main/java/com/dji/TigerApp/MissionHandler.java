package com.dji.TigerApp;

import static android.os.SystemClock.sleep;

import android.location.Location;

//import com.dji.sdk.sample.internal.controller.DJISampleApplication;
//import com.dji.sdk.sample.internal.utils.ToastUtils;
//import com.dji.TigerApp.schemas.generated.Route;
//import com.dji.sdk.sample.tigersalvage.Sender;

import com.dji.TigerApp.schemas.generated.RoutePoint;
import com.dji.TigerApp.schemas.generated.RouteArray;

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

    private FlightController mFlightController;
    private static WaypointMissionOperator operator;
    private WaypointV2MissionTypes.MissionFinishedAction mFinishedAction = WaypointV2MissionTypes.MissionFinishedAction.NO_ACTION;
    private WaypointMissionHeadingMode mHeadingMode = WaypointMissionHeadingMode.AUTO;
    private WaypointV2MissionTypes.MissionGotoWaypointMode firstMode = WaypointV2MissionTypes.MissionGotoWaypointMode.SAFELY;
    private List<WaypointV2Action> v2Actions;
    private boolean canUploadAction;
    private boolean canStartMission;
    private float mSpeed = 10.0f;
    private CompletionCallback completionCallback;
    public State flightState = State.WAITING;
    enum State {
        WAITING,
        UPLOADING,
        READY,
        FLYING,
        PAUSED,
        RESUMING,
        FINISHED,
        ERROR
    }

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
                System.out.println(err);
            }
        };
    }

    public List<Waypoint> BuildWaypointArray(RouteArray route){
        List<Waypoint> waypointList = new ArrayList<>();
        for (RoutePoint routePoint : route.getWaypointsList()){
            Waypoint waypoint = new Waypoint(routePoint.getLat(), routePoint.getLong(), routePoint.getAlt());
            waypoint.speed = 10;
            waypoint.removeAllAction();
            waypoint.actionTimeoutInSeconds = 0;
            waypoint.cornerRadiusInMeters = 0.5f; //TODO
            waypointList.add(waypoint);
        }
        return waypointList;
    }

    public void routeProcessor(RouteArray route) {
        try {

            waypointMissionBuilder = new WaypointMission.Builder();

            this.flightState = State.UPLOADING;

            List<Waypoint> tmp = BuildWaypointArray(route);

            WaypointMission mission = waypointMissionBuilder.
                    headingMode(mHeadingMode).
                    autoFlightSpeed(10f). //TODO
                            maxFlightSpeed(15f). //TODO
                            finishedAction(WaypointMissionFinishedAction.GO_HOME).
                    setExitMissionOnRCSignalLostEnabled(true).
                    flightPathMode(WaypointMissionFlightPathMode.CURVED).
                    waypointCount(tmp.size()).
                    waypointList(tmp).
                    build();


            mFlightController = TigerAppApplication.getAircraftInstance().getFlightController();
            FlightControllerState flightControllerState = mFlightController.getState();
            //flightControllerState.
            /*LocationCoordinate3D home3D = flightControllerState.getAircraftLocation();
            LocationCoordinate2D home = new LocationCoordinate2D(home3D.getLatitude(), home3D.getLongitude());
            mFlightController.setHomeLocation(home, completionCallback);*/
            DJIError mEr = mission.checkParameters();


            //run check params but dont know where that is - might be redundant
            DJIError loadError = operator.loadMission(mission);


            //at this state, mission operator is verifying mission
            //once operator.getCurrentState().equals(WaypointV2MissionState.READY_TO_UPLOAD)
            //upload flight by operator.uploadmission()
            // once operator.getCurrentState().equals(WaypointV2MissionState.READY_TO_EXECUTE)
            // start mission by operator.startMission `startMission`
            mFlightController.setHomeLocationUsingAircraftCurrentLocation(completionCallback);
            operator.uploadMission(completionCallback);

            this.flightState = State.READY;
            //TODO
            //Call function in Mission Sender to send this route for approval since upload was successful
        }
        catch (Exception e){
            waypointMissionBuilder = null;
            this.flightState = State.ERROR;
        }
    }

    public static String getStatus(){
        return operator.getCurrentState().toString();
    }

    public State getState(){
        return flightState;
    }

    public void startFlight(){
        try {
            flightState = State.FLYING;
            mFlightController.startTakeoff(completionCallback);
            operator.startMission(completionCallback);
        }
        catch (Exception e){
            this.flightState = State.ERROR;
        }
    }

    public void endFlight(){
        try{
            flightState = State.FINISHED;
            operator.stopMission(completionCallback);
        }
        catch (Exception e){
            this.flightState = State.ERROR;
        }
    }

    public void pauseFlight(){
        try{
            flightState = State.PAUSED;
            operator.pauseMission(completionCallback);
        }
        catch (Exception e){
            this.flightState = State.ERROR;
        }

    }

    public void resumeFlight(){
        try{
            flightState = State.RESUMING;
            operator.resumeMission(completionCallback);
        }
        catch (Exception e){
            this.flightState = State.ERROR;
        }
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
