package com.amnon.picdiy.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

public class CommonActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setFullScreen(true);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    /**
     * 设置是否全屏
     * 
     * @param fullScreen true 全屏 false 不全屏
     */
    public void setFullScreen(boolean fullScreen) {
        if (fullScreen) {
            // 不显示工具栏
            Window win = this.getWindow();
            // 设置无标题
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            win.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // 显示工具栏
            Window win = this.getWindow();
            win.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            win.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        
    }
    
}
