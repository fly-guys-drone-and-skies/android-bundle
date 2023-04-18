package com.dji.TigerApp.Mission;

import com.dji.TigerApp.MissionStatus;
import com.dji.TigerApp.protobuf.RouteArray;
import com.dji.TigerApp.protobuf.RoutePoint;

import java.util.ArrayList;
import java.util.List;

import dji.common.flightcontroller.FlightControllerState;
import dji.common.mission.waypoint.Waypoint;
import dji.common.mission.waypoint.WaypointMission;
import dji.common.mission.waypoint.WaypointMissionFinishedAction;
import dji.common.mission.waypoint.WaypointMissionFlightPathMode;
import dji.common.mission.waypoint.WaypointMissionGotoWaypointMode;
import dji.common.mission.waypoint.WaypointMissionHeadingMode;

public class RouteParser {
    public static WaypointMissionList buildMissionList(RouteArray route) {
        WaypointMission.Builder waypointMissionBuilder = new WaypointMission.Builder();
        WaypointMissionList missionList = new WaypointMissionList();
        try {
            for(List<Waypoint> waypointList : buildWaypointListArray(route)) {
                WaypointMission mission = waypointMissionBuilder.
                    autoFlightSpeed(15f).
                    maxFlightSpeed(15f).
                    headingMode(WaypointMissionHeadingMode.AUTO).
                    finishedAction(WaypointMissionFinishedAction.NO_ACTION).
                    setExitMissionOnRCSignalLostEnabled(true).
                    flightPathMode(WaypointMissionFlightPathMode.CURVED).
                    gotoFirstWaypointMode(WaypointMissionGotoWaypointMode.POINT_TO_POINT).
                    waypointCount(waypointList.size()).
                    waypointList(waypointList).
                    build();
                missionList.addMission(mission);
            }
        } catch(Exception e) {
            MissionStatus.sendDebug("mission list fail");
            waypointMissionBuilder = null;
            MissionHandler.flightState = MissionHandler.State.ERROR;
        }

        return missionList;
    }

    private static List<Waypoint> buildWaypointArray(List<RoutePoint> routePointList){
        List<Waypoint> waypointList = new ArrayList<>();

        for (RoutePoint routePoint : routePointList){
            Waypoint waypoint = new Waypoint(routePoint.getLocation().getLat(), routePoint.getLocation().getLong(), routePoint.getLocation().getAlt());
            waypoint.speed = routePoint.getSpeed();
            waypoint.cornerRadiusInMeters = .2f;

            waypointList.add(waypoint);
        }

        return waypointList;
    }

    private static ArrayList<List<Waypoint>> buildWaypointListArray(RouteArray route) {
        List<Waypoint> waypointList = buildWaypointArray(route.getWaypointsList());
        ArrayList<List<Waypoint>> waypointListArray = new ArrayList<>();

        // 99 is maximum number of waypoints in mission.
        for (int i = 0; i < waypointList.size(); i += 99) { // there has to be a better way...
            if ((waypointList.size() - i) < 99) {
                waypointListArray.add(new ArrayList(waypointList.subList(i, waypointList.size() - 1)));
            }
            else {
                waypointListArray.add(new ArrayList(waypointList.subList(i, i + 99)));
            }
        }
        return waypointListArray;
    }

}
