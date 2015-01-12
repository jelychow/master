package com.sec.hidinner.bills;


import java.util.ArrayList;

import com.sec.hidinner.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class OrderDetailActivity extends Activity implements OnClickListener{
    
   private Button back;
   private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);
        back = (Button) findViewById(R.id.btn_back);
        back.setOnClickListener(this);
        start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()){
		
		case R.id.btn_back:
			break;
		case R.id.btn_start:
			intent = new Intent(OrderDetailActivity.this,OrderGetSuccessActivity.class);
			startActivity(intent);
		break;
		default:
			break;
		}
		
	}
    

}
