package com.dji.TigerApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.dji.TigerApp.Mission.MissionHandler;
import com.dji.TigerApp.Mission.WaypointMissionList;

import dji.common.error.DJIError;

import dji.common.flightcontroller.FlightControllerState;
import dji.common.mission.waypoint.WaypointMissionDownloadEvent;
import dji.common.mission.waypoint.WaypointMissionExecutionEvent;
import dji.common.mission.waypoint.WaypointMissionState;
import dji.common.mission.waypoint.WaypointMissionUploadEvent;
import dji.common.util.CommonCallbacks;
import dji.sdk.mission.waypoint.WaypointMissionOperator;
import dji.sdk.mission.waypoint.WaypointMissionOperatorListener;

public class OperatorListener implements WaypointMissionOperatorListener {
    private WaypointMissionList missionList;
    private FlightControllerState flightControllerState;
    private WaypointMissionOperator operator;

    public OperatorListener(WaypointMissionList missionList, FlightControllerState flightControllerState, WaypointMissionOperator operator) {
        this.missionList = missionList;
        this.flightControllerState = flightControllerState;
        this.operator = operator;
    }

    public void onExecutionFinish(DJIError error) {
        if (error == null) {
            operator.startMission((DJIError err) -> {
                if (err != null) {
                    System.out.println(err);
//                MissionStatus.sendDebug(err.getDescription());
                }
            });
        }
    }

    public void onDownloadUpdate(@NonNull WaypointMissionDownloadEvent waypointMissionDownloadEvent) {
        return;
    }

    public void onUploadUpdate(@NonNull WaypointMissionUploadEvent waypointMissionUploadEvent) {
        return;
    }

    public void onExecutionUpdate(@NonNull WaypointMissionExecutionEvent waypointMissionExecutionEvent) {
        try {
            MissionStatus.send(
                    MissionStatus.toMessage(
                            flightControllerState.getAircraftLocation(),
                            flightControllerState.getAttitude(),
                            new float[]{
                                    flightControllerState.getVelocityX(),
                                    flightControllerState.getVelocityY(),
                                    flightControllerState.getVelocityZ(),
                            },
                            operator.getCurrentState().toString()
                    ).toByteArray(),
                    "ui-exchange",
                    "status",
                    "status"
            );
        } catch (Exception e) {
            MissionStatus.sendDebug("exec update" + e.getMessage());
        }
        //Sender.send(status.toMessage().toByteArray(), "ui-exchange", "status", "ui");
    }

    public void onExecutionStart() {
        if(missionList.isComplete()) {
            return;
        }
//        DJIError loadError = missionList.loadNextMission(operator);
//        if(loadError != null) {
//            MissionStatus.sendDebug(loadError.getDescription());
//        }
//        else {
//            MissionStatus.sendDebug("all good");
//        }
        MissionHandler.flightState = MissionHandler.State.UPLOADING;
//        MissionStatus.sendDebug(operator.getCurrentState().toString());

//        while(operator.getCurrentState() != WaypointMissionState.READY_TO_UPLOAD);
        // Should already have next mission loaded at this point.
//        operator.uploadMission(
//            (DJIError uploadError) -> {
//                if (uploadError != null) { // TODO Make this generic?
//                    System.out.println(uploadError.getDescription());
//                }
//                else {
//                    missionList.loadNextMission(operator);
//                }
//            }
//        );
    }
}
