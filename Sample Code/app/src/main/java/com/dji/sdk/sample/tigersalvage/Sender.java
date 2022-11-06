package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.apache.commons.io.output.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class Sender {
    private static Channel channel;

    public static void setChannel(Connection connection) throws IOException {
        Sender.channel = connection.createChannel();
    }

    public static void send(byte[] message, String exchange, String key, String type) { // add exceptions
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DeflaterOutputStream outputStream = new DeflaterOutputStream(byteStream);
        try {
            outputStream.write(message, 0, message.length);
            outputStream.finish();
            BasicProperties props = new BasicProperties();
            props = props.builder().type(type).build();
            channel.basicPublish(exchange, key, props, byteStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
