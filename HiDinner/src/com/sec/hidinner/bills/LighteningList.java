package com.sec.hidinner.bills;

import com.sec.hidinner.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class LighteningList extends Activity {
    private  Handler mHandler = new Handler() {
    
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 001) {
            }

        }

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lightening_list);
        mHandler.sendEmptyMessageAtTime(001, 2000);
        mHandler.postDelayed(new Runnable(){

            @Override
            public void run() {
                new AlertDialog.Builder(LighteningList.this)
                .setTitle("有人抢单，抢单成功").setMessage("接头暗号，天王盖地虎，小鸡炖蘑菇")
                .setPositiveButton("知道了", null).show();

            }
            
        },3000);

    }
}