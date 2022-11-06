package com.dji.sdk.sample.tigersalvage;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class appController {

    public appController(){

    }

    void init() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Sender.setChannel(connection);
        //mission
        new missionConsumer(connection);
    }
}
