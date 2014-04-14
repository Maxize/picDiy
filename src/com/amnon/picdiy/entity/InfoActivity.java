/**
 * 
 */
package com.amnon.picdiy.entity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.amnon.picdiy.R;
import com.amnon.picdiy.main.CommonActivity;

/**
 * @author Administrator
 *
 */
public class InfoActivity extends CommonActivity implements OnClickListener{
    
    public static final String TAG = "InfoActivity";

    private ImageButton img_btn_back;
    private ImageButton img_btn_wechat;
    private ImageButton img_btn_author;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        
        
        img_btn_back = (ImageButton)findViewById(R.id.back);
        img_btn_wechat = (ImageButton)findViewById(R.id.btn_wechat);
        img_btn_author = (ImageButton)findViewById(R.id.btn_creater);
        
        img_btn_back.setOnClickListener(this);
        img_btn_wechat.setOnClickListener(this);
        img_btn_author.setOnClickListener(this);
        
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.back:
                Intent back = new Intent(InfoActivity.this, MainActivity.class);
                InfoActivity.this.startActivity(back);  
                InfoActivity.this.finish();
                break;
            case R.id.btn_wechat:
//                Intent back = new Intent(InfoActivity.this, MainActivity.class);
//                InfoActivity.this.startActivity(back);  
//                InfoActivity.this.finish();
                Log.i(TAG, "btn_wechat is onclick!!!");
                break;
            case R.id.btn_creater:
                Intent createrIntent = new Intent(InfoActivity.this, AuthorActivity.class);
                InfoActivity.this.startActivity(createrIntent);  
//                InfoActivity.this.finish();
                
                break;
            default:
                break;
        }
        
    }
    
}
