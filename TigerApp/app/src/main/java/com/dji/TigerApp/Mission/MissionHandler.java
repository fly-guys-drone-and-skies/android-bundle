package com.dji.TigerApp.Mission;

import com.dji.TigerApp.MissionStatus;
import com.dji.TigerApp.OperatorListener;
import com.dji.TigerApp.TigerAppApplication;
import com.dji.TigerApp.protobuf.RouteArray;

import dji.common.error.DJIError;
import dji.common.flightcontroller.FlightControllerState;
import dji.common.mission.waypoint.WaypointMission;
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
            }
        };
    }

    // public void debug() {
    //     MissionStatus.send(new byte[1], "ui-exchange", "status", "ui");
    // }

    public void startNewMission(RouteArray route) {
        WaypointMissionList missionList = RouteParser.buildMissionList(route);
        operator.addListener(new OperatorListener(missionList, flightController.getState()));
        uploadMission(missionList);
        startFlight();
    }

    private void uploadMission(WaypointMissionList missionList) {
        flightController.setHomeLocationUsingAircraftCurrentLocation(completionCallback);
        missionList.loadNextMission(operator);
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
            flightController.startTakeoff(completionCallback);
            operator.startMission(completionCallback);
        }
        catch (Exception e){
            MissionHandler.flightState = State.ERROR;
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
