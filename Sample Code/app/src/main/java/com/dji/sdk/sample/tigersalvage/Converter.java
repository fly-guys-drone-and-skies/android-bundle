package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Command;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Event;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.GeoLocation3D;

import dji.common.flightcontroller.LocationCoordinate3D;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.mission.MissionControl;

public class Converter {
    public static class Pair {
        public final Command command;
        public final Event event;
        public final String operation;

        public Pair (Command command, Event event, String operation) {
            this.command = command;
            this.event = event;
            this.operation = operation;

        }
    }

    public static Pair parse (byte[] chars, MissionControl mission, FlightController flight) {
        try {
            Command command = Command.parseFrom(chars);
            LocationCoordinate3D pos = flight.getState().getAircraftLocation();
            if (command.getCommandCase() == Command.CommandCase.GETPOSITION) {
                return new Pair(command,
                        Event.newBuilder().
                                setCommandUUID(command.getUuid()).
                                setPositionStatus(
                                        Event.PositionStatusEvent.newBuilder().
                                                setLocation(
                                                        GeoLocation3D.newBuilder().
                                                                setLatitude(pos.getLatitude()).
                                                                setLongitude(pos.getLongitude()).
                                                                setAltitudeMeters(pos.getAltitude()).
                                                                build()).
                                                build()).
                                build()
                ,"Get position");
            }
            if (command.getCommandCase() == Command.CommandCase.TAKEOFF) {
                mission.startTimeline();
                return new Pair(command,
                        Event.newBuilder().
                                setCommandUUID(command.getUuid()).
                                setCommandCompleted(
                                        Event.CommandCompletedEvent.
                                                newBuilder().build()
                                ).build()
                ,"Takeoff!");
            }
            if (command.getCommandCase() == Command.CommandCase.MOVEGIMBAL) {
                return new Pair(command,
                        Event.newBuilder().setCommandUUID(command.getUuid()).
                                setCommandCompleted(
                                        Event.CommandCompletedEvent.
                                                newBuilder().build()
                                ).build()
                        ,"Gimbal move request ignored.");
            }
            if (command.getCommandCase() == Command.CommandCase.CHANGEZOOMLEVEL) {
                return new Pair(command,
                        Event.newBuilder().setCommandUUID(command.getUuid()).
                                setCommandCompleted(
                                        Event.CommandCompletedEvent.
                                                newBuilder().build()
                                ).build()
                        ,"Zoom level change request ignored.");
            }
            if (command.getCommandCase() == Command.CommandCase.MOVETO) {
                return new Pair(command,
                        Event.newBuilder().setCommandUUID(command.getUuid()).
                                setCommandCompleted(
                                        Event.CommandCompletedEvent.
                                                newBuilder().build()
                                ).build()
                        ,"Move to request ignored.");
            }
            if (command.getCommandCase() == Command.CommandCase.LAND) {
                //Or ignore...?
                //mission.stopTimeline();
                return new Pair(command,
                        Event.newBuilder().setCommandUUID(command.getUuid()).
                                setCommandCompleted(
                                        Event.CommandCompletedEvent.
                                                newBuilder().build()
                                ).build()
                        ,"Land ignored.");
            }

            return new Pair(Command.newBuilder().build(), Event.newBuilder().build(),"Unknown: " + command.getCommandCase());


        } catch (Exception e) {
            e.printStackTrace();
            return new Pair(Command.newBuilder().build(), Event.newBuilder().build(), "Unknown, parsing error");
        }
    }
}
