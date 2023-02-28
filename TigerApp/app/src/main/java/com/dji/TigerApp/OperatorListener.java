package com.dji.TigerApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dji.TigerApp.MissionHandler;
import com.dji.TigerApp.protobuf.Location;
import com.dji.TigerApp.protobuf.VehicleAttitude;

import com.dji.sdk.sample.internal.controller.DJISampleApplication;
import com.dji.sdk.sample.internal.utils.ToastUtils;
import dji.common.error.DJIError;
import dji.common.flightcontroller.Attitude;
import dji.common.mission.waypoint.WaypointMissionState;
import dji.sdk.flightcontroller.FlightController;
import dji.common.flightcontroller.FlightControllerState;
import dji.common.flightcontroller.LocationCoordinate3D;
import dji.common.mission.waypoint.WaypointMission;
import dji.common.mission.waypoint.WaypointMissionDownloadEvent;
import dji.common.mission.waypoint.WaypointMissionExecutionEvent;
import dji.common.mission.waypoint.WaypointMissionUploadEvent;
import dji.common.util.CommonCallbacks.CompletionCallback;
import dji.sdk.mission.waypoint.WaypointMissionOperator;
import dji.sdk.mission.waypoint.WaypointMissionOperatorListener;

import java.util.ArrayList;

public class OperatorListener implements WaypointMissionOperatorListener {
    private CompletionCallback completionCallback;
    private WaypointMissionList missionList;
    private FlightControllerState flightControllerState;

    public OperatorListener(CompletionCallback completionCallback, WaypointMissionList missionList) {
        this.completionCallback = completionCallback;
        this.missionList = missionList;
        this.flightControllerState = DJISampleApplication.getAircraftInstance().getFlightController().getState();
    }

    public void onExecutionFinish(DJIError error) {
        if (error != null) {
            ToastUtils.setResultToToast("Execution Finish error");
            ToastUtils.setResultToToast(error.getDescription());
        }
        else {
            ToastUtils.setResultToToast("current mission finished");
            MissionHandler.operator.startMission(completionCallback);
        }
    }

    public void onDownloadUpdate(@NonNull WaypointMissionDownloadEvent waypointMissionDownloadEvent) {
        return;
    }

    public void onUploadUpdate(@NonNull WaypointMissionUploadEvent waypointMissionUploadEvent) {
        return;
    }

    public void onExecutionUpdate(@NonNull WaypointMissionExecutionEvent waypointMissionExecutionEvent) {
        Status status = new Status(
            flightControllerState.getAircraftLocation(),
            flightControllerState.getAttitude(),
            new float[] {
                    flightControllerState.getVelocityX(),
                    flightControllerState.getVelocityY(),
                    flightControllerState.getVelocityZ(),
            },
            MissionHandler.operator.getCurrentState().toString()
        );

        Sender.send(status.toMessage().toByteArray(), "ui-exchange", "status", "ui");
    }

    public void onExecutionStart() {
        if (missionList.isComplete()) {
            return;
        }
        // Preload next mission
        loadNextMission();
        MissionHandler.operator.uploadMission(
            (DJIError uploadError) -> {
                if (uploadError != null) { // TODO Make this generic?
                    ToastUtils.setResultToToast("Upload mission error");

                    ToastUtils.setResultToToast(uploadError.getDescription());
                    System.out.println(uploadError.getDescription());
                }
                else {
                    ToastUtils.setResultToToast("Upload Success");
                    loadNextMission();
                }
            }
        );
    }

    private void loadNextMission() { // TODO Move this so it's not duplicated. Maybe a mission manager?
        DJIError loadError = MissionHandler.operator.loadMission(missionList.nextMission());

        if (loadError != null) {
            ToastUtils.setResultToToast("LOAD ERROR");
            ToastUtils.setResultToToast(loadError.getDescription());
        }
        else {
            ToastUtils.setResultToToast("LOAD SUCCESS");
            ToastUtils.setResultToToast(MissionHandler.operator.getLoadedMission().getWaypointList().toString());
        }
    }
}
