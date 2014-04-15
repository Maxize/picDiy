package com.amnon.picdiy.common;

public class GameConfig {
    
    /** 屏幕长(pixel) */
    private static int screenWidth;
    /** 屏幕宽(pixel) */
    private static int screenHeight;
    
    private static int screenHalf_width;
    private static int screenHalf_height;
    
    private static float weightsX;
    private static float weightsY;
    // 缩放比例
    private static float ratio;

    public static void setScreenWidthHeight(int screenWidth, int screenHeight) {
        if (screenWidth < screenHeight) {
            GameConfig.screenWidth = screenHeight;
            GameConfig.screenHeight = screenWidth;
            GameConfig.weightsX = screenHeight / 800.0f;
            GameConfig.weightsY = screenWidth / 480.0f;
        } else {
            GameConfig.screenWidth = screenWidth;
            GameConfig.screenHeight = screenHeight;
            
            GameConfig.weightsX = screenWidth / 800.0f;
            GameConfig.weightsY = screenHeight / 480.0f;
        }
        
        GameConfig.screenHalf_width = GameConfig.screenWidth << 1;
        GameConfig.screenHalf_height = GameConfig.screenHeight << 1;
        
    }
    
    public static void setRatio(float ratio){
        if(ratio > 0.0f){
            GameConfig.ratio = ratio;
        }else{
            GameConfig.ratio = 1.0f;
        }
        
    }
    
    /**
     * @return the wEIGHTS_X
     */
    public static float getWeightsX() {
        return weightsX;
    }

    /**
     * @return the wEIGHTS_Y
     */
    public static float getWeightsY() {
        return weightsY;
    }

    public static final int getScreenWidth() {
        return screenWidth;
    }

    public static final int getScreenHeight() {
        return screenHeight;
    }
    
    public static int getScreenHalf_width() {
        return screenHalf_width;
    }

    public static int getScreenHalf_height() {
        return screenHalf_height;
    }

    public static float getRatio() {
        return ratio;
    }
}
