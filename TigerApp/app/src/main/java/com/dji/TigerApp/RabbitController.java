package com.dji.TigerApp;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class RabbitController extends Thread {
    public static boolean rabbitStatus = false;
    public static final String RABBIT_IP = "192.168.0.168";
    public static final String VEHICLE_UUID = java.util.UUID.randomUUID().toString();

    public void run() {
        try {
            initRabbit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initRabbit() throws InterruptedException, IOException {
        MissionConsumer r = null;
        Connection connection = null;
        while (!rabbitStatus) {
            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost(RABBIT_IP);
                connection = factory.newConnection();
                new MissionStatus(connection);
                MissionStatus.send(VEHICLE_UUID.getBytes(StandardCharsets.UTF_8), "ui-exchange", "status", "handshake");

                r = new MissionConsumer(connection);
                r.consume();

                rabbitStatus = true;
            } catch (Exception e) {
                System.out.println(e.toString());
                Thread.sleep(3000);
                //wait and retry //TODO this is probably not ideal since we will keep remaking connections, if for example, the ip is wrong, but this also may be fine

            } // need to think about ^
        }



    }

    public static boolean rabbitStatus() {
        return rabbitStatus;
    }

    public String getRabbitIp() {
        return RABBIT_IP;
    }

}
