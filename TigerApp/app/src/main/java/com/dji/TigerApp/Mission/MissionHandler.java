package com.dji.TigerApp.Mission;

import com.dji.TigerApp.MissionStatus;
import com.dji.TigerApp.OperatorListener;
import com.dji.TigerApp.TigerAppApplication;
import com.dji.TigerApp.protobuf.RouteArray;

import dji.common.error.DJIError;
import dji.common.flightcontroller.FlightControllerState;
import dji.common.mission.waypoint.WaypointMission;
import dji.common.mission.waypoint.WaypointMissionState;
import dji.common.util.CommonCallbacks;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.mission.MissionControl;
import dji.sdk.mission.waypoint.WaypointMissionOperator;
import dji.sdk.products.Aircraft;

public class MissionHandler {
    private static MissionHandler missionHandler;

    private WaypointMission.Builder waypointMissionBuilder;
    private WaypointMissionOperator operator;
    private CommonCallbacks.CompletionCallback completionCallback; // Generic callback function for certain SDK calls.
    private FlightController flightController;

    public static State flightState = State.WAITING;

    public enum State {
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
        flightController = TigerAppApplication.getAircraftInstance().getFlightController(); // I don't think there's a case where we won't need this.
        completionCallback = (DJIError err) -> {
            if (err != null) {
                System.out.println(err);
                MissionStatus.sendDebug(err.getDescription());
            }
        };
    }

    // public void debug() {
    //     MissionStatus.send(new byte[1], "ui-exchange", "status", "ui");
    // }

    public void startNewMission(RouteArray route) {
        WaypointMissionList missionList = RouteParser.buildMissionList(route);
        MissionStatus.sendDebug("built mission list");
        operator.addListener(new OperatorListener(missionList, flightController.getState()));
        MissionStatus.sendDebug("added listener");
        uploadMission(missionList);
        MissionStatus.sendDebug("uploaded mission");
        startFlight();
    }

    private void uploadMission(WaypointMissionList missionList) {
        MissionStatus.sendDebug("uploading");
        flightController.setHomeLocationUsingAircraftCurrentLocation(completionCallback);
        MissionStatus.sendDebug("home location set");
        DJIError loadError = missionList.loadNextMission(operator);
        if(loadError != null) {
            MissionStatus.sendDebug(loadError.getDescription());
        }
        else {
            MissionStatus.sendDebug("all good");
        }
        MissionHandler.flightState = State.UPLOADING;
        operator.uploadMission(completionCallback);
        MissionHandler.flightState = State.READY;
    }

    public static State getFlightState(){
        return flightState;
    }

    public void startFlight(){
        try {
            flightState = State.FLYING;
            Thread.sleep(10000);
            flightController.startTakeoff(completionCallback);
            while(operator.getCurrentState() != WaypointMissionState.READY_TO_EXECUTE && !flightController.getState().isFlying()); // wait while it takes off and prepares the mission.
            operator.startMission(completionCallback);
        }
        catch (Exception e){
            MissionHandler.flightState = State.ERROR;
            MissionStatus.sendDebug(e.getMessage());
        }
    }

    public void endFlight(){
        try{
            flightState = State.FINISHED;
            operator.stopMission(completionCallback);
        }
        catch (Exception e){
            MissionHandler.flightState = State.ERROR;
        }
    }

    public void pauseFlight(){
        try{
            flightState = State.PAUSED;
            operator.pauseMission(completionCallback);
        }
        catch (Exception e){
            MissionHandler.flightState = State.ERROR;
        }

    }

    public void resumeFlight(){
        try{
            flightState = State.RESUMING;
            operator.resumeMission(completionCallback);
        }
        catch (Exception e){
            MissionHandler.flightState = State.ERROR;
        }
    }

}
