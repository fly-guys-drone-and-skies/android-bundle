package handlers;

import com.greeting.Greet;
import org.apache.commons.io.output.ByteArrayOutputStream;
import sender.Sender;

import java.io.IOException;
import java.util.zip.InflaterOutputStream;
import dji.common.error.DJIError;
import dji.common.error.DJIWaypointV2Error;
import dji.common.flightcontroller.FlightControllerState;
import dji.common.flightcontroller.RTKState;
import dji.common.mission.waypoint.WaypointMissionHeadingMode;
import dji.common.mission.waypointv2.Action.WaypointV2Action;
import dji.common.mission.waypointv2.WaypointV2;
import dji.common.mission.waypointv2.WaypointV2Mission;
import dji.common.mission.waypointv2.WaypointV2MissionDownloadEvent;
import dji.common.mission.waypointv2.WaypointV2MissionExecutionEvent;
import dji.common.mission.waypointv2.WaypointV2MissionState;
import dji.common.mission.waypointv2.WaypointV2MissionTypes;
import dji.common.mission.waypointv2.WaypointV2MissionUploadEvent;
import dji.common.model.LocationCoordinate2D;
import dji.common.useraccount.UserAccountState;
import dji.common.util.CommonCallbacks;
import dji.sdk.base.BaseProduct;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.flightcontroller.RTK;
import dji.sdk.mission.MissionControl;
import dji.sdk.mission.waypoint.WaypointV2MissionOperator;
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
    //private
    public List<WaypointV2> waypointList = new ArrayList<>();

    public static WaypointV2Mission.Builder waypointMissionBuilder;

    private FlightController mFlightController;
    private WaypointV2MissionOperator operator;
    private WaypointV2MissionTypes.MissionFinishedAction mFinishedAction = WaypointV2MissionTypes.MissionFinishedAction.NO_ACTION;
    private WaypointMissionHeadingMode mHeadingMode = WaypointMissionHeadingMode.AUTO;
    private WaypointV2MissionTypes.MissionGotoWaypointMode firstMode = WaypointV2MissionTypes.MissionGotoWaypointMode.SAFELY;
    private WaypointV2ActionDialog mActionDialog;
    private List<WaypointV2Action> v2Actions;
    private boolean canUploadAction;
    private boolean canStartMission;
    private float mSpeed = 10.0f;


    public MissionHandler() {
        //create mission control

    }

    public void BuildWaypointArray(RouteArray route){
        List<WaypointV2> waypointList = new ArrayList<>();

        for (Route r : route.getWaypointsList()){
            //lat long alt speed
            //TODO add settings like auto heading and soft turns
            WaypointV2 curr = new WaypointV2.Builder()
            .setAltitude(r.getAlt())
            .setCoordinate(new LocationCoordinate2D(r.getLat(), r.getLong()))
            //.setFlightPathMode(WaypointV2MissionTypes.WaypointV2FlightPathMode.GOTO_POINT_STRAIGHT_LINE_AND_STOP)
            //.setHeadingMode(WaypointV2MissionTypes.WaypointV2HeadingMode.AUTO)
            //
            .setAutoFlightSpeed(r.getSpeed())
            .build();

            this.waypointList.add(curr);
        }
    }

    public void RouteProcessor(RouteArray route) {
        this.waypointList = BuildWaypointArray(route);

        if (waypointMissionBuilder == null) {
            waypointMissionBuilder = new WaypointMission.Builder()
                .headingMode(mHeadingMode)
                .autoFlightSpeed(mSpeed)
                .maxFlightSpeed(mSpeed)
                .waypointList(waypointList)
                .build();
            
                //might need to make new waypoint mission and build into that var 
        } //else new flight is being uploaded - handle it 

        //run check params but dont know where that is - might be redundant 
        operator.loadMission(waypointMissionBuilder);
        
        //at this state, mission operator is verifying mission
        //once operator.getCurrentState().equals(WaypointV2MissionState.READY_TO_UPLOAD)
        //upload flight by operator.uploadmission()
        // once operator.getCurrentState().equals(WaypointV2MissionState.READY_TO_EXECUTE)
        // start mission by operator.startMission `startMission`
        
        //todo need to add listeners for status
    }



    public void startFlight(){
        //operator.startMission()
    }

    public void endFlight(){
        //operator.stopMission()
    }

    public void pauseFlight(){
        //if executing, 
        //operator.interruptMission()
    }

    public void resumeFlight(){
        //operator.recoverMission()
    }


    public void Send() {
        try {
            Sender.send(compress(greeting.toByteArray()), "bae-exchange", "mission", "greeting");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //TODO add to interface or add to sender class
    public static byte[] compress(byte[] message) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterStream = new InflaterOutputStream(byteStream);
        inflaterStream.write(message, 0, message.length);
        inflaterStream.finish();

        return byteStream.toByteArray();
    }


}
