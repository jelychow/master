package com.sec.hidinner.bills;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.sec.hidinner.MainActivity;
import com.sec.hidinner.R;

public class SetupBonus extends Activity implements OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_up_bonus);
        findViewById(R.id.btn_confirm).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // int id =0;
        switch (v.getId()) {
        case R.id.btn_confirm:
            new AlertDialog.Builder(SetupBonus.this)
                    .setTitle("确认订单吗？")
                    .setMessage("您的订单将被提交")
                    .setPositiveButton(
                            "确定",
                            new android.content.DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(
                                        android.content.DialogInterface dialog,
                                        int which) {
                                    Intent intent = new Intent(SetupBonus.this,
                                            OrderStandby.class);
                                    startActivity(intent);
                                }

                            })
                    .setNegativeButton(
                            "取消",
                            new android.content.DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(
                                        android.content.DialogInterface dialog,
                                        int which) {

                                }
                            }).show();
            break;
        case R.id.btn_cancel:
            break;
        default:
            return;
        }

    }
}
