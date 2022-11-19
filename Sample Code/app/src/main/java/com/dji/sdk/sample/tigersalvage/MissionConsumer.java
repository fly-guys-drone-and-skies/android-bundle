package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.internal.utils.ToastUtils;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.zip.InflaterOutputStream;

import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.RoutePoint;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.RouteArray;

public class MissionConsumer extends Thread{
    
    Channel channel;
    String queue;
    MissionHandler handler;
    public MissionConsumer(Connection connection) throws IOException {
        this.channel = connection.createChannel();
        this.queue = "app";
        handler = MissionHandler.getInstance();
    }

    public void run() {
        try {
            consume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void consume() throws IOException, TimeoutException {
        
        channel.basicConsume("mission-app", true, (consumerTag, message) -> {

            String type = message.getProperties().getType();
            ToastUtils.setResultToToast(type);
            //TODO
            //String id = message.getProps.get Something
            //If id == app id, continue. Else drop 

            switch (type) {
                case "dune":
                    byte[] body = inflate(message.getBody());
                    ToastUtils.setResultToToast("body");
                    RouteArray arr = RouteArray.newBuilder().mergeFrom(body).build();
                    ToastUtils.setResultToToast("Built");
                    handler.routeProcessor(arr);
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
    }

    public byte[] inflate(byte[] message) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterStream = new InflaterOutputStream(byteStream);
        inflaterStream.write(message, 0, message.length);
        inflaterStream.finish();
    
        return byteStream.toByteArray();
    }
}
