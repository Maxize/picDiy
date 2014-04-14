/**
 * 
 */
package com.amnon.picdiy.entity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.amnon.picdiy.R;
import com.amnon.picdiy.main.CommonActivity;


/**
 * @author Administrator
 *
 */
public class MapActivity extends CommonActivity implements OnClickListener{
    
    private MapActivity m_context;
    
    private ScrollView m_sv;
    private LinearLayout m_ll_mainContent;
    private ImageButton m_btn_back;
    private ImageButton m_btn_rank;
    private TextView m_tx_rank;
    
//    private 

    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        m_context = this;
        findView();
        initLinker();
        
        
    }
    
    
    /**
     * @return 1表示正常，其他为不正常
     */
    private int initLinker() {
        
        
        return 1;
    }

    /**
     *  
     * @return 1表示正常，其他为不正常
     */
    public int findView(){
        m_sv = (ScrollView) findViewById(R.id.sv_map);
        m_ll_mainContent = (LinearLayout) findViewById(R.id.ll_mainContent);
        m_btn_back = (ImageButton) findViewById(R.id.btn_back);
        m_btn_rank = (ImageButton) findViewById(R.id.btn_rank);
        m_btn_back.setOnClickListener(this);
        m_btn_rank.setOnClickListener(this);
        m_tx_rank = (TextView) findViewById(R.id.tx_rank);
        
        return 1;
    }

    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onResume()
     */
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onStop()
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent backIntent = new Intent(MapActivity.this, MainActivity.class);
                MapActivity.this.startActivity(backIntent);
                MapActivity.this.finish();
                break;
            case R.id.btn_rank:
                Intent rankIntent = new Intent(MapActivity.this, RankActivity.class);
                MapActivity.this.startActivity(rankIntent);
//                MapActivity.this.finish();
                break;

            default:
                break;
        }
    }
    
}
