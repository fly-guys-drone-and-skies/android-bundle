package com.dji.TigerApp.Mission;

public class RouteParser {
    public static WaypointMissionList buildMissionList(RouteArray route) {
        WaypointMission.Builder waypointMissionBuilder = new WaypointMission.Builder();
        ArrayList<WaypointMission> missionList = new ArrayList<>();
        WaypointMissionList missionList = new WaypointMissionList();

        for(List<Waypoint> waypointList : buildWaypointListArray(route)) {
            WaypointMission mission = waypointMissionBuilder.
                headingMode(mHeadingMode).
                autoFlightSpeed(2.5f).
                maxFlightSpeed(15f).
                headingMode(WaypointMissionHeadingMode.AUTO).
                finishedAction(WaypointMissionFinishedAction.NO_ACTION).
                setExitMissionOnRCSignalLostEnabled(true).
                flightPathMode(WaypointMissionFlightPathMode.CURVED).
                gotoFirstWaypointMode(WaypointMissionGotoWaypointMode.POINT_TO_POINT).
                waypointCount(waypointList.size()).
                waypointList(waypointList).
                build();
            missionList.add(mission);
        }

        return missionList;
    }

    private List<Waypoint> buildWaypointArray(List<RoutePoint> waypointList){
        List<Waypoint> waypointList = new ArrayList<>();

        for (RoutePoint routePoint : waypointList){
            Waypoint waypoint = new Waypoint(routePoint.getLocation().getLat(), routePoint.getLocation().getLong(), routePoint.getLocation().getAlt());
            waypoint.speed = routePoint.getSpeed();
            waypoint.cornerRadiusInMeters = .2f;

            waypointList.add(waypoint);
        }

        return waypointList;
    }

    private ArrayList<List<Waypoint>> buildWaypointListArray(RouteArray route) {
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
