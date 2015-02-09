package com.sec.hidinner.setting;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.sec.hidinner.R;

public class SettingsActivity extends Activity implements OnClickListener{
    
	private TextView modify_add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.settings);
	     getActionBar().setDisplayHomeAsUpEnabled(true);
	     modify_add = (TextView) findViewById(R.id.id_modify_add);
	     modify_add.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()){
		
		case R.id.btn_back:
			break;
		case R.id.btn_start:
//			intent = new Intent(OrderDetailActivity.this,OrderGetSuccessActivity.class);
//			startActivity(intent);
			
		case R.id.id_modify_add:
			try {
				intent = new Intent(SettingsActivity.this,AddressActivity.class);
				startActivity(intent);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		default:
			break;
		}
		
	}
    

}
