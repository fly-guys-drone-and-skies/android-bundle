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
        Thread.sleep(10000);
        String message = "";
        while (true){
            if (MissionHandler.getInstance() != null)  {
                 message = MissionHandler.getStatus();
            }
            else {
                message = "No mission uploaded";
            }

            Sender.send(message.getBytes(StandardCharsets.UTF_8), "ui-exchange", "ui", "csda");
            Thread.sleep(1000);
        }

    }
}
