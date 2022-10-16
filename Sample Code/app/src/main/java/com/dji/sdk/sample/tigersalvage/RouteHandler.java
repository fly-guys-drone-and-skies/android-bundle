package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Command;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Event;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.GeoLocation3D;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Orientation;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.RouteOuterClass;
import com.google.protobuf.ByteString;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import dji.common.gimbal.Attitude;
import dji.common.model.LocationCoordinate2D;
import dji.sdk.mission.MissionControl;
import dji.sdk.mission.timeline.TimelineElement;
import dji.sdk.mission.timeline.actions.GimbalAttitudeAction;
import dji.sdk.mission.timeline.actions.GoToAction;
import dji.sdk.mission.timeline.actions.LandAction;
import dji.sdk.mission.timeline.actions.TakeOffAction;

public class RouteHandler {
    private static final String routeUUID = "58e0a7d7-eebc-11d8-9669-0800200c9a66";
    public static class RouteSet {
        public final Event event;
        public final String operation;

        public RouteSet (Event event, String operation) {
            this.event = event;
            this.operation = operation;
        }
    }
    public static RouteSet buildTimelineIfRoute (byte[] chars, MissionControl mission) {
        try {
            RouteOuterClass.Route route = RouteOuterClass.Route.parseFrom(chars);
            List<Command> commands = route.getActionsList();
            List<TimelineElement> actions = new ArrayList<>();
            actions.add(new TakeOffAction());
            for (Command cmd: commands) {
                switch (cmd.getCommandCase()) {
                    case MOVETO:
                        GeoLocation3D coord = cmd.getMoveTo().getToLocation();
                        GoToAction goTo = new GoToAction(new LocationCoordinate2D(coord.getLatitude(), coord.getLongitude()), (float) coord.getAltitudeMeters());
                        actions.add(goTo);
                        break;
                    case MOVEGIMBAL:
                        Orientation orientation = cmd.getMoveGimbal().getToOrientation();
                        Attitude attitude = new Attitude((float) orientation.getPitchDegrees(), (float) orientation.getRollDegrees(), (float) orientation.getYawDegrees());
                        GimbalAttitudeAction gimbalAction = new GimbalAttitudeAction(attitude);
                        //actions.add(gimbalAction);

                        break;
                    case CHANGEZOOMLEVEL:
                        double level = cmd.getChangeZoomLevel().getZoomLevel();
                        //Not supported?  I don't know how to do this as a timeline event, I hope 1 is good.

                }
            }
            actions.add(new LandAction());
            mission.scheduleElements(actions);
            //Might give us trouble with the other side.  Currently ignored UUID and just accepting any weird one as route UUID.
            return new RouteSet(
                    Event.newBuilder().setCommandUUID(ByteString.copyFrom(routeUUID, StandardCharsets.UTF_16)).
                            setCommandCompleted(
                                    Event.CommandCompletedEvent.
                                            newBuilder().build()
                            ).build()
                    ,"Route request acknowledged.");
        } catch (Exception e) {
            //Not a route object, that's just fine!
            return null;
        }
    }
}
