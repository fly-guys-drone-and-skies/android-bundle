package com.dji.sdk.sample.tigersalvage;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import dji.sdk.sdkmanager.DJISDKManager;

import com.dji.sdk.sample.tigersalvage.Messenger;

import java.util.ArrayList;
import java.util.List;

public class appController {

    public appController(){
        initSDK();
        //new Status().start();
        new Messenger().start();

    }

    private void initSDK() {

    }

}
