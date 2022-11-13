package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.internal.utils.ToastUtils;
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
        factory.setHost("98.11.194.141");
        Connection connection = factory.newConnection();
        ToastUtils.setResultToToast(connection.toString());

        Sender.setChannel(connection);

        new MissionConsumer(connection).start();
    }
}
