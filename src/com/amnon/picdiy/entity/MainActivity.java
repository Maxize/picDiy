package com.amnon.picdiy.entity;

import com.amnon.picdiy.R;
import com.amnon.picdiy.main.CommonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MainActivity extends CommonActivity implements OnClickListener {

    public static final String TAG = "MainActivity";
    
    private ImageButton img_btn_info = null;
    private ImageButton img_btn_wechat = null;
    private ImageButton img_btn_play = null;
    private ImageButton img_btn_music = null;
    private ImageButton img_btn_fkcg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    public int findView(){
        img_btn_info = (ImageButton) findViewById(R.id.btn_info);
        img_btn_wechat = (ImageButton) findViewById(R.id.btn_wechat);
        img_btn_play = (ImageButton) findViewById(R.id.btn_play);
        img_btn_music = (ImageButton) findViewById(R.id.btn_music);
        img_btn_fkcg = (ImageButton) findViewById(R.id.btn_fkcg);
        img_btn_info.setOnClickListener(this);
        img_btn_wechat.setOnClickListener(this);
        img_btn_play.setOnClickListener(this);
        img_btn_music.setOnClickListener(this);
        img_btn_fkcg.setOnClickListener(this);
        return 1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_info:
                Intent infoIntent = new Intent(MainActivity.this, InfoActivity.class);
                MainActivity.this.startActivity(infoIntent);  
//                MainActivity.this.finish();
                break;
            case R.id.btn_wechat:
                
                break;
            case R.id.btn_play:
                Intent playIntent = new Intent(MainActivity.this, MapActivity.class);
                MainActivity.this.startActivity(playIntent);
                break;
            case R.id.btn_music:

                break;
            case R.id.btn_fkcg:

                break;
            default:
                break;
        }
    }

}
