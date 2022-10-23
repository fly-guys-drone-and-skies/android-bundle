package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitListener extends Thread {
    private final String rabbitServerIP;
    private final String queueName;

    public RabbitListener(String rabbitServerIP, String queueName) {
        this.rabbitServerIP = rabbitServerIP;
        this.queueName = queueName;
    }

    public void run() {
        try {
            runListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runListener() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitServerIP);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
