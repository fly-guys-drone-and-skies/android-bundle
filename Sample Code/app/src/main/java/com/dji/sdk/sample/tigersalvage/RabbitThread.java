package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Stack;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

public class RabbitThread extends Thread {
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("98.11.194.141");
        String message = "test message";
        System.out.println("hi\n\n\n\n");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicPublish("", "Test-Queue", null, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
