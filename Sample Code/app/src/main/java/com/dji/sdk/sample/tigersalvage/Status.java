package com.dji.sdk.sample.tigersalvage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Status extends Thread {
    public void run(){
        try {
            sendStatus();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendStatus() throws InterruptedException {
        sleep(10000);
        while (true){
            String message = MissionHandler.getStatus();

            Sender.send(message.getBytes(StandardCharsets.UTF_8), "ui-exchange", "ui", "csda");
            sleep(1000);
        }

    }
}
