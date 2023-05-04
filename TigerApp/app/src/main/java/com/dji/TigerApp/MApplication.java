package com.dji.TigerApp;

import android.app.Application;
import android.content.Context;

import com.secneo.sdk.Helper;

public class MApplication extends Application {
    public static final String DRONE_ID = "Drone 1";

    private TigerAppApplication TigerAppApplication;
    @Override
    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        Helper.install(MApplication.this);
        if (TigerAppApplication == null) {
            TigerAppApplication = new TigerAppApplication();
            TigerAppApplication.setContext(this);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TigerAppApplication.onCreate();
    }
}
