package com.sec.hidinner.product;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.sec.hidinner.R;
import com.sec.hidinner.bills.OrderPickedActivity;

public class ShoppingCart extends Activity implements OnClickListener {
    private ArrayList<ProductBean> mList;
    private ListView mListView;
    private List<ArrayList<ProductBean>> list;
    private CheckBox allChecked;
    private int checkNum;
    private Button pay;
    ShoppingCartListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.shopping_car_activity);
            initView();
            adapter = new ShoppingCartListAdapter(this, mList);
            mListView = (ListView) findViewById(R.id.lv_car_list);
            mListView.setAdapter(adapter);

            allChecked = (CheckBox) findViewById(R.id.cb_all_check);
            pay = (Button) findViewById(R.id.btn_pay);
            pay.setOnClickListener(this);
            allChecked.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (allChecked.isChecked()) {
                        adapter.configCheckMap(true);
                    } else {
                        adapter.configCheckMap(false);
                    }
                   
                    dataChanged();
                }
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void initView() {
        mList = new ArrayList<ProductBean>();
        list = new ArrayList<ArrayList<ProductBean>>();
        ArrayList<ProductBean> mList1 = new ArrayList<ProductBean>();
        ArrayList<ProductBean> mList2 = new ArrayList<ProductBean>();
        ProductBean p1 = new ProductBean();
        p1.setShopname("非常好吃的牛肉拉面");
        p1.setProductname("特级牛排");
        p1.setNum("X5");
        p1.setPrice("5元");
        ProductBean p2 = new ProductBean();
        // p2.setNum("X2");
        p2.setShopname("非常好吃的牛肉拉面");
        p2.setProductname("特级牛排");
        p2.setPrice("5元");
        p2.setNum("X2");
        ProductBean p3 = new ProductBean();
        p3.setShopname("非常好吃的牛肉拉面2");
        p3.setProductname("特级牛排");
        p3.setPrice("5元");
        p3.setNum("X3");
        ProductBean p4 = new ProductBean();
        p4.setShopname("非常好吃的牛肉拉面");
        p4.setProductname("特级牛排");
        p4.setPrice("5元");
        p4.setNum("X4");
        mList.add(p1);
        mList.add(p2);
        mList.add(p3);
        mList.add(p4);
        // mList1.add(p1);
        mList1.add(p2);
        mList1.add(p3);
        mList2.add(p4);
        list.add(mList);
        list.add(mList1);
        list.add(mList2);
        //syscStatus();
    }

    public void syscStatus(){
        for (int i =0;i<mList.size()-1;i++){
            CheckBox cb =(CheckBox) adapter.getView(i, mListView, null).findViewById(R.id.checkBox1);
            Boolean flag = cb.getText().equals(mList.get(i+1).getShopname());
            if (flag&&(cb.isChecked())) {
                ShoppingCartListAdapter.isCheckMap.put(i+1, true);
                adapter.notifyDataSetChanged();
            }
        }
    }
    private void dataChanged() {
        // 通知listView刷新
        adapter.notifyDataSetChanged();
        // TextView显示最新的选中数目
        // tv_show.setText("已选中" + checkNum + "项");
    }

    @Override
    public void onClick(View v) {
       Intent intent = new Intent(ShoppingCart.this,OrderPickedActivity.class);
       startActivity(intent);

    };

}
