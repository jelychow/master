package com.sec.hidinner;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

public class HiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 鍦ㄤ娇鐢�SDK 鍚勭粍闂翠箣鍓嶅垵濮嬪寲 context 淇℃伅锛屼紶鍏�ApplicationContext
        SDKInitializer.initialize(this);
    }

}