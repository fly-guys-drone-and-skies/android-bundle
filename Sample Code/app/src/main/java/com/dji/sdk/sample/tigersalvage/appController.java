package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import dji.sdk.sdkmanager.DJISDKManager;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.dji.sdk.sample.tigersalvage.Sender;

public class appController {

    public appController(){
        try {
            initMessaging();
        } catch(IOException | TimeoutException e) {
            System.out.println(e.getMessage());
        }
        initSDK();
    }

    private void initSDK() {
        return; // Should be used to initisialize SDK by itself.
    }

    void initMessaging() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Sender.setChannel(connection);
        //mission
        new missionConsumer(connection);
    }
}
