package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.zip.InflaterOutputStream;

public class missionConsumer extends Thread{
    
    Channel channel;
    String ex;
    MissionHandler handler;
    public missionConsumer(Connection connection, String exch) {
        Channel channel = connection.createChannel();
        this.queueName = queueName;
        handler = new missionHandler();

    }

    public void run() {
        try {
            consume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void consume() throws IOException, TimeoutException {
        
        channel.basicConsume(ex, true, (consumerTag, message) -> {

            String type = message.getProperties().getType();
            //TODO
            //String id = message.getProps.get Something
            //If id == app id, continue. Else drop 

            switch (type) {
                case "route":
                    handler.routeProcessor(RouteArray.newBuilder().mergeFrom(inflate(message.getBody())).build());
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


         });
    }
    public byte[] inflate(byte[] message) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterStream = new InflaterOutputStream(byteStream);
        inflaterStream.write(message, 0, message.length);
        inflaterStream.finish();
    
        return byteStream.toByteArray();
    }


}
