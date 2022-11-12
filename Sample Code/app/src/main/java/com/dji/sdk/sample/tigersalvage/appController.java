package com.dji.sdk.sample.tigersalvage;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import dji.sdk.sdkmanager.DJISDKManager;

import com.dji.sdk.sample.tigersalvage.Messenger;

public class appController {

    public appController(){
        //new Messenger().start();
        initSDK();
    }

    private void initSDK() {
        return; // Should be used to initisialize SDK by itself.
    }

}
