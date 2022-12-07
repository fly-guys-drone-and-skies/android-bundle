package com.dji.sdk.sample.tigersalvage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dji.sdk.sample.tigersalvage.WaypointMissionList;
import com.dji.sdk.sample.tigersalvage.proto.generated.Location;

import com.dji.sdk.sample.internal.controller.DJISampleApplication;
import com.dji.sdk.sample.internal.utils.ToastUtils;
import dji.common.error.DJIError;
import dji.common.flightcontroller.Attitude;
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
    private WaypointMissionOperator operator;
    private CompletionCallback completionCallback;
    private WaypointMissionList missionList;
    private FlightControllerState flightControllerState;

    public OperatorListener(WaypointMissionOperator operator, CompletionCallback completionCallback, WaypointMissionList missionList) {
        this.operator = operator;
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
            operator.startMission(completionCallback);
        }
    }

    public void onDownloadUpdate(@NonNull WaypointMissionDownloadEvent waypointMissionDownloadEvent) {
        return;
    }

    public void onUploadUpdate(@NonNull WaypointMissionUploadEvent waypointMissionUploadEvent) {
        return;
    }

    public void onExecutionUpdate(@NonNull WaypointMissionExecutionEvent waypointMissionExecutionEvent) {
        LocationCoordinate3D location = flightControllerState.getAircraftLocation();
        Attitude attitude = flightControllerState.getAttitude();
        float[] velocityXYZ = {
            flightControllerState.getVelocityX(),
            flightControllerState.getVelocityY(),
            flightControllerState.getVelocityZ(),
        };
    }

    private void sendStatusMessage(LocationCoordinate3D location, Attitude attitude, float[] velocityXYZ) {
        Location.newBuilder().
                setLat(location.getLatitude()).
                setLong(location.getLongitude()).
                setAlt(location.getAltitude()).
                build();
    }

    public void onExecutionStart() {
        // Preload next mission
        loadNextMission();
        operator.uploadMission(
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
        DJIError loadError = operator.loadMission(missionList.nextMission());

        if (loadError != null) {
            ToastUtils.setResultToToast("LOAD ERROR");
            ToastUtils.setResultToToast(loadError.getDescription());
        }
        else {
            ToastUtils.setResultToToast("LOAD SUCCESS");
            ToastUtils.setResultToToast(operator.getLoadedMission().getWaypointList().toString());
        }
    }
}
