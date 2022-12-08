package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.tigersalvage.proto.generated.Location;
import com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude;
import com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus;
import com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

import dji.common.flightcontroller.Attitude;
import dji.common.flightcontroller.LocationCoordinate3D;

public class Sender {
    private static Channel channel;

    public static void setChannel(Connection connection) throws IOException {
        Sender.channel = connection.createChannel();
    }

    public static void send(byte[] message, String exchange, String key, String type) { // add exceptions
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DeflaterOutputStream outputStream = new DeflaterOutputStream(byteStream);
        try {
            outputStream.write(message, 0, message.length);
            outputStream.finish();
            BasicProperties props = new BasicProperties();
            props = props.builder().type(type).build();
            channel.basicPublish(exchange, key, props, byteStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendStatusMessage(LocationCoordinate3D location, Attitude attitude, float[] velocityXYZ) {
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
            build();

        Sender.send(vehicleStatus.toByteArray(), "ui-exchange", "status", "ui");
    }

}
