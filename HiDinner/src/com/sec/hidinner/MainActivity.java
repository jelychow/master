package com.sec.hidinner;

import com.sec.hidinner.bills.Peronal_activity;
import com.sec.hidinner.bills.SetupBonus;
import com.sec.hidinner.location.MyLocation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,Peronal_activity.class);
				startActivity(intent);
				
			}
		});
        
        findViewById(R.id.button2).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SetupBonus.class);
				startActivity(intent);
			}
        	
        });
    }


}
