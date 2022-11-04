package com.dji.sdk.sample.tigersalvage.messaging;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Route;
import com.dji.sdk.sample.tigersalvage.messaging.RouteParser;

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

        consumeMessages(channel);
    }

    private void consumeMessages(Channel channel) {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            RouteParser.parseRoute(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
