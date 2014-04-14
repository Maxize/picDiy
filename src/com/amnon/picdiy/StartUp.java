package com.amnon.picdiy;

import com.amnon.picdiy.entity.MainActivity;
import com.amnon.picdiy.main.CommonActivity;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.os.Build;

public class StartUp extends CommonActivity {
    
    private ImageView secondImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        secondImg = (ImageView) findViewById(R.id.secondScreenImg);
        new Handler().postDelayed(new Runnable(){  
            @Override  
            public void run() {
                secondImg.setVisibility(View.VISIBLE);
                showSecondImg();
            }  
        }, 1000);//2000 毫秒后切换
    }
    
    public void showSecondImg(){
        new Handler().postDelayed(new Runnable(){  
            @Override  
            public void run() {
                Intent mainIntent = new Intent(StartUp.this, MainActivity.class);  
                StartUp.this.startActivity(mainIntent);  
                StartUp.this.finish();  
            }  
        }, 1500);//1500 毫秒后切换
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_start_up, container, false);
            return rootView;
        }
    }

}
