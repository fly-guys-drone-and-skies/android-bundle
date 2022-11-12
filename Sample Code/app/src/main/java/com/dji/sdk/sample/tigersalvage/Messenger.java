package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import com.dji.sdk.sample.tigersalvage.Sender;
import com.dji.sdk.sample.tigersalvage.MissionConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Messenger extends Thread {
    public void run() {
        try {
            initMessaging();
        } catch(IOException | TimeoutException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initMessaging() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Sender.setChannel(connection);
        //mission
        new MissionConsumer(connection).start();
    }
}
