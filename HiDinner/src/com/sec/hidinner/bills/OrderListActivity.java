package com.sec.hidinner.bills;

import java.util.ArrayList;

import com.sec.hidinner.R;
import com.sec.hidinner.adpater.OrderListAdapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class OrderListActivity extends Activity implements OnItemClickListener{
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 001) {
            }

        }

    };

    private ArrayList<OrderBean> arrayList;
    private ListView mListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list_activity);
        arrayList = new ArrayList<OrderBean>();
        OrderBean o1 = new OrderBean();
        o1.setBonus("赏金：$3");
        o1.setFromTo("从南京到北京");
        o1.setLast("30s");
        o1.setName("NiMa");
        
        OrderBean o2 = new OrderBean();
        o2.setBonus("赏金：$3");
        o2.setFromTo("从南京到北京");
        o2.setLast("30s");
        o2.setName("NiMa");
        
        OrderBean o3 = new OrderBean();
        o3.setBonus("赏金：$3");
        o3.setFromTo("从南京到北京");
        o3.setLast("30s");
        o3.setName("NiMa");
        
        arrayList.add(o1);arrayList.add(o2);arrayList.add(o3);
        mListView = (ListView) findViewById(R.id.get_list);
        BaseAdapter adapter = new OrderListAdapter(this,arrayList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                Intent intent = new Intent(OrderListActivity.this,OrderDetailActivity.class);
                startActivity(intent);
                
            }
            
        });
        mHandler.sendEmptyMessageAtTime(001, 2000);
//        mHandler.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                new AlertDialog.Builder(OrderListActivity.this)
//                        .setTitle("有人抢单，抢单成功").setMessage("接头暗号，天王盖地虎，小鸡炖蘑菇")
//                        .setPositiveButton("知道了", null).show();
//
//            }
//
//        }, 3000);

    }

    @Override
    public void onItemClick(AdapterView<?> v1, View view, int position,
            long id) {
        
    }
}