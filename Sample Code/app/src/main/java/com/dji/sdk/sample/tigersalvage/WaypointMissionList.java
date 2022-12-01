package com.dji.sdk.sample.tigersalvage;

import dji.common.mission.waypoint.WaypointMission;

import java.util.ArrayList;

public class WaypointMissionList {
    private int currentMissionIndex;
    private boolean isComplete;
    private ArrayList<WaypointMission> missionList;


    public WaypointMissionList(ArrayList<WaypointMission> missionList) {
        missionList = this.missionList;
        currentMissionIndex = 0;
        isComplete = false;
    }

    public WaypointMission nextMission() {
        WaypointMission mission = missionList.get(currentMissionIndex);
        currentMissionIndex++;

        if (currentMissionIndex > missionList.size()) {
            isComplete = true;
        }

        return mission;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
