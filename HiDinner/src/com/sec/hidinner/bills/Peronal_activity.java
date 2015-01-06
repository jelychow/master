package com.sec.hidinner.bills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.sec.hidinner.R;

public class Peronal_activity extends Activity implements OnClickListener{
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.personal_activity);
	        findViewById(R.id.btn_lightening_order).setOnClickListener(this);
	        
	    }
	 
	 public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_lightening_order:
				Intent intent = new Intent(Peronal_activity.this,CustomList.class);
				startActivity(intent);
				break;
			}
		}
}
