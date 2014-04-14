/**
 * 
 */
package com.amnon.picdiy.entity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.amnon.picdiy.R;
import com.amnon.picdiy.main.CommonActivity;

/**
 * @author Administrator
 *
 */
public class AuthorActivity extends CommonActivity {
    
    public static final String TAG = "AuthorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        ImageButton back;
        back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AuthorActivity.this, InfoActivity.class);
                AuthorActivity.this.startActivity(back);  
                AuthorActivity.this.finish();
            }
        });
        
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
}
