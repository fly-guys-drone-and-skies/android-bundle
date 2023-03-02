package com.dji.TigerApp.Mission;

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
        currentMissionIndex++;

        if (currentMissionIndex > missionList.size()) {
            isComplete = true;
        }

        return mission;
    }

    public void loadNextMission(WaypointMissionOperator operator) {
        WaypointMission mission = nextMission();
        DJIError loadError = operator.loadMission(mission);
    }

    public boolean isComplete() {
        return isComplete;
    }
}
