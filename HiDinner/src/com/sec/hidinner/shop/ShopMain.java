package com.sec.hidinner.shop;

import java.util.ArrayList;

import com.sec.hidinner.R;
import com.sec.hidinner.sociation.CourierSetup;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ShopMain extends Activity {

    private MyListView listView;
    private MyListView subListView;
    private MyAdapter myAdapter;
    private SubAdapter subAdapter;
    private ArrayList<MealSet> mealSets;
    private  MealSet m1 ;
    String foods[] = new String[] { "全部频道", "美食", "休闲娱乐", "购物", "酒店", "丽人",
            "生活服务" };
    int images[] = new int[] { R.drawable.ic_category_0,
            R.drawable.ic_category_10, R.drawable.ic_category_30,
            R.drawable.ic_category_20, R.drawable.ic_category_60,
            R.drawable.ic_category_50, R.drawable.ic_category_45,
            R.drawable.ic_category_80 };

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                
                setContentView(R.layout.shop_main);
                getActionBar().setTitle("菠萝的海");
                init();
                myAdapter = new MyAdapter(getApplicationContext(), foods, images);
                listView.setAdapter(myAdapter);

                selectDefult();

                listView.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                            int position, long arg3) {
                        // TODO Auto-generated method stub
                        final int location = position;
                        myAdapter.setSelectedPosition(position);
                        myAdapter.notifyDataSetInvalidated();
                        subAdapter = new SubAdapter(getApplicationContext(), mealSets);
                        subListView.setAdapter(subAdapter);
                        subListView.setOnItemClickListener(new OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                                // TODO Auto-generated method stub
                                Toast.makeText(getApplicationContext(),
                                        mealSets.get(location).getOrderName(), Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                    }
                });

    }

    private void init() {
        mealSets = new ArrayList<MealSet>();
        m1 = new MealSet();
        m1.setOrderName("超级打肉排");
        m1.setSaleNum("已热销488");
        m1.setSaleDetail("汽水.牛排");
        m1.setSalePrice("588");
        Log.d("IFISNULL", (String) ((m1==null)?"true":"false"+""));
        mealSets.add(m1);
        MealSet m2 = new MealSet();
        m2.setOrderName("超级打肉排");
        m2.setSaleNum("已热销488");
        m2.setSaleDetail("汽水.牛排");
        m2.setSalePrice("1588");
        mealSets.add(m2);
        listView = (MyListView) findViewById(R.id.listView);
        subListView = (MyListView) findViewById(R.id.subListView);
        findViewById(R.id.tv_limit).setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopMain.this,CourierSetup.class);
                startActivity(intent);
            }
            
        });
    }

    public void PickMeal(){
        
    }
    private void selectDefult() {
        final int location = 0;
        myAdapter.setSelectedPosition(0);
        myAdapter.notifyDataSetInvalidated();
        subAdapter = new SubAdapter(getApplicationContext(), mealSets);
        subListView.setAdapter(subAdapter);
        subListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                    int position, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),
                        mealSets.get(location).getOrderName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
