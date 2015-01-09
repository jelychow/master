package com.sec.hidinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sec.hidinner.bills.OrderPickedActivity;
import com.sec.hidinner.bills.PeronalActivity;
import com.sec.hidinner.bills.SetupBonus;
import com.sec.hidinner.location.LocationDemo;
import com.sec.hidinner.shop.ShopMain;
import com.sec.hidinner.sociation.CourierSetup;

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
                try {
                    Intent intent = new Intent(MainActivity.this,
                          CourierSetup.class);
                    startActivity(intent);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HiDinnerMain.class);
                startActivity(intent);
            }

        });
    }

}
