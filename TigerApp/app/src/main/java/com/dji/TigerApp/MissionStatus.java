package com.dji.TigerApp;


import com.dji.TigerApp.protobuf.Debug;
import com.dji.TigerApp.protobuf.DebugMessage;
import com.dji.TigerApp.protobuf.Location;
import com.dji.TigerApp.protobuf.VehicleAttitude;
import com.dji.TigerApp.protobuf.VehicleStatus;
import com.dji.TigerApp.protobuf.VehicleVelocity;
import com.dji.TigerApp.Mission.MissionHandler;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import org.bouncycastle.jcajce.provider.digest.Tiger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

import dji.common.flightcontroller.Attitude;
import dji.common.flightcontroller.FlightControllerState;
import dji.common.flightcontroller.LocationCoordinate3D;

public class MissionStatus {

    private static Channel channel;
    private FlightControllerState flightControllerState;

    public MissionStatus(Connection connection) throws IOException {
        MissionStatus.channel = connection.createChannel();
    }

    // Converts to VehicleStatus protobuf message
    public static VehicleStatus toMessage(LocationCoordinate3D location, Attitude attitude, float[] velocityXYZ, String status) {
        Location locationMessage = Location.newBuilder().
                setLat(location.getLatitude()).
                setLong(location.getLongitude()).
                setAlt(location.getAltitude()).
                build();
        VehicleAttitude attitudeMessage = VehicleAttitude.newBuilder().
                setPitch(attitude.pitch).
                setYaw(attitude.yaw).
                setRoll(attitude.roll).
                build();
        VehicleVelocity velocityMessage = VehicleVelocity.newBuilder().
                setX(velocityXYZ[0]).
                setY(velocityXYZ[1]).
                setZ(velocityXYZ[2]).
                build();

        VehicleStatus vehicleStatus = VehicleStatus.newBuilder().
                setLocation(locationMessage).
                setVelocityXYZ(velocityMessage).
                setAttitude(attitudeMessage).
                setStatus(status).
                setTime(System.currentTimeMillis()).
                build();

        return vehicleStatus;
    }

    public static void send(byte[] message, String exchange, String key, String type) { // add exceptions
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DeflaterOutputStream outputStream = new DeflaterOutputStream(byteStream);
        try {
            outputStream.write(message, 0, message.length);
            outputStream.finish();
            BasicProperties props = new BasicProperties();
            props = props.builder().type(type).build();
            channel.basicPublish(exchange, key, props, byteStream.toByteArray()); //TODO only sending to 1 exchange, so hardcode ?
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendDebug(String message) {
        send(
                DebugMessage.
                        newBuilder().
                        setMsg(message).
                        build().toByteArray(),
                "ui-exchange",
                "status",
                "debug"
        );
    }
}

