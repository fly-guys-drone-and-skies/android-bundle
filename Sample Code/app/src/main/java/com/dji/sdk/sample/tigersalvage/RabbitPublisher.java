package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class RabbitPublisher extends Thread {
    private final String rabbitServerIP;
    private final String queueName;

    private Channel channel;

    public RabbitPublisher(String rabbitServerIP, String queueName) {
        this.rabbitServerIP = rabbitServerIP;
        this.queueName = queueName;
    }

    public void run() {
        try {
            runPublisher();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runPublisher() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitServerIP);
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
    }

    public void sendMessage(String msg) {
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }
}
