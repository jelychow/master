package com.sec.hidinner;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

public class HiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
    }

}