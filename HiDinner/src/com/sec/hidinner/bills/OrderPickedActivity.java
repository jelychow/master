package com.sec.hidinner.bills;

import java.util.ArrayList;

import com.sec.hidinner.MainActivity;
import com.sec.hidinner.R;
import com.sec.hidinner.adpater.OrderPickedListAdapter;
import com.sec.hidinner.sociation.CourierSetup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class OrderPickedActivity extends Activity {
    private ListView pickedList;
    private ArrayList<OrderPickedBean> arraylist;
    private OrderPickedListAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_picked);
        pickedList = (ListView) findViewById(R.id.ls_picked);
        arraylist = new ArrayList<OrderPickedBean>();
        OrderPickedBean o1 = new OrderPickedBean();
        o1.setCost("118");
        o1.setName("noodles");
        o1.setNum("X1");
        OrderPickedBean o2 = new OrderPickedBean();
        o2.setCost("118");
        o2.setName("noodles");
        o2.setNum("X1");
        arraylist.add(o2);
        arraylist.add(o1);
        adapter = new OrderPickedListAdapter(this,arraylist);
        pickedList.setAdapter(adapter);
        findViewById(R.id.btn_order_confirm).setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPickedActivity.this,
                       LighteningList.class);
                  startActivity(intent);
            }
            
        });
    }

}
