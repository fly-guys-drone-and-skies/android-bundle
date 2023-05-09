package com.dji.TigerApp;


import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.zip.InflaterOutputStream;

import com.dji.TigerApp.protobuf.RoutePoint;
import com.dji.TigerApp.protobuf.RouteArray;
import com.dji.TigerApp.Mission.MissionHandler;
import com.dji.TigerApp.MainActivity;

public class MissionConsumer{

    Channel channel;
    String queue;
    MissionHandler handler;

    public MissionConsumer(Connection connection)  {
        try {
            this.channel = connection.createChannel();
            this.queue = "app";
            handler = MissionHandler.getInstance();
        }
        catch (Exception e) {

        }
    }


    public void consume() {
        try {
            channel.basicConsume("mission-app2", true, (consumerTag, message) -> {
//                if(!message.getProperties().getHeaders().isEmpty()) {
//                    MissionStatus.sendDebug(message.getProperties().getHeaders().get("vehicleId").toString());
//                }
                String type = message.getProperties().getType();
                //TODO for multiple drones
                //String id = message.getProps.get Something
                //If id == app id, continue. Else drop

                switch (type) {
                    case "dune":
                        MissionStatus.sendDebug("app msg received");
                        byte[] body = inflate(message.getBody());
                        RouteArray arr = RouteArray.newBuilder().mergeFrom(body).build();
                        handler.startNewMission(arr);
                        break;
                    case "start":
                        handler.startFlight();
                        break;
                    case "kill":
                        handler.endFlight();
                        break;
                    case "pause":
                        handler.pauseFlight();
                        break;
                    case "resume":
                        handler.resumeFlight();
                        break;
                }

            }, consumerTag -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] inflate(byte[] message) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterStream = new InflaterOutputStream(byteStream);
        inflaterStream.write(message, 0, message.length);
        inflaterStream.finish();

        return byteStream.toByteArray();
    }
}

