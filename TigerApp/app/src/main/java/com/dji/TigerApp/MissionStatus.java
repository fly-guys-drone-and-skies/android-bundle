package com.dji.TigerApp;


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

public class MissionStatus extends Thread{

    private static Channel channel;
    private FlightControllerState flightControllerState;

    public MissionStatus(Connection connection) throws IOException {
        MissionStatus.channel = connection.createChannel();
        this.flightControllerState = TigerAppApplication.getAircraftInstance().getFlightController().getState();
        //get controller
    }

    public void run(){
        while(true) {
            try {
                // if drone status == flying
                if (MissionHandler.getFlightState() == MissionHandler.State.FLYING){
                    //create and send flying messages //TODO
                    // message = new toMessage
                }

                // if else{
                    // send appropriate message based on drone.status
                    // ex message = uploading

                //Send(message)
                Thread.sleep(900);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Converts to VehicleStatus protobuf message
    public VehicleStatus toMessage(LocationCoordinate3D location, Attitude attitude, float[] velocityXYZ, String status) {
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
}
