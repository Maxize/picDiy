/**
 * 
 */
package com.amnon.picdiy.entity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.amnon.picdiy.R;
import com.amnon.picdiy.main.CommonActivity;

/**
 * @author Administrator
 *
 */
public class RankActivity extends CommonActivity {
    
    private ImageButton m_btn_back;

    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        
        m_btn_back = (ImageButton) findViewById(R.id.btn_back);
        m_btn_back.setOnClickListener(this);
    }

    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
    
    /* (non-Javadoc)
     * @see com.amnon.picdiy.main.CommonActivity#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
//                Intent backIntent = new Intent(RankActivity.this, MapActivity.class);
//                RankActivity.this.startActivity(backIntent);
                RankActivity.this.finish();
                break;

            default:
                break;
        }
    }
    
    
    
}
