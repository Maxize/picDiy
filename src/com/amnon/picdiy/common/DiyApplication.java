package com.amnon.picdiy.common;

import android.app.Application;
import android.util.DisplayMetrics;

public class DiyApplication extends Application {

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        // 初始化屏幕信息
        initScreenInfo();
    }


    /**
     * 初始化设备屏幕的分辨率信息
     */
    public void initScreenInfo() {
        DisplayMetrics dm = new DisplayMetrics();  
        dm = getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        GameConfig.setScreenWidthHeight(screenWidth, screenHeight);
        float ditity = dm.density;
        GameConfig.setRatio(ditity);
    }

}
