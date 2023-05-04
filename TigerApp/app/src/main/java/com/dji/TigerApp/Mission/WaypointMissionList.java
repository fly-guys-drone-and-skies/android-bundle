package com.dji.TigerApp.Mission;

import com.dji.TigerApp.MissionStatus;

import dji.common.error.DJIError;
import dji.common.mission.waypoint.WaypointMission;
import dji.sdk.mission.waypoint.WaypointMissionOperator;

import java.util.ArrayList;

public class WaypointMissionList {
    private int currentMissionIndex;
    private boolean isComplete;
    private ArrayList<WaypointMission> missionList;


    public WaypointMissionList(ArrayList<WaypointMission> missionList) {
        this.missionList = missionList;
        currentMissionIndex = 0;
        isComplete = false;
    }

    public WaypointMissionList() {
        this.missionList = new ArrayList<>();
        currentMissionIndex = 0;
        isComplete = false;
    }

    public void addMission(WaypointMission mission) {
        missionList.add(mission);
    }

    public WaypointMission nextMission() {
        WaypointMission mission = missionList.get(currentMissionIndex);
        MissionStatus.sendDebug(mission.toString());
        MissionStatus.sendDebug(String.valueOf(isComplete));
        currentMissionIndex++;

        if (currentMissionIndex + 1 > missionList.size()) {
            isComplete = true;
        }
        MissionStatus.sendDebug("return mission");
        MissionStatus.sendDebug(String.valueOf(mission.getWaypointCount()));

        return mission;
    }

    public DJIError loadNextMission(WaypointMissionOperator operator) {
        MissionStatus.sendDebug("loading next");

        WaypointMission mission = nextMission();
        MissionStatus.sendDebug(String.valueOf(mission.getWaypointCount()));

        DJIError loadError = operator.loadMission(mission);
        return loadError;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
