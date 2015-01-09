package com.sec.hidinner.sociation;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.sec.hidinner.MainActivity;
import com.sec.hidinner.R;
import com.sec.hidinner.adpater.CourierListAdapter;
import com.sec.hidinner.bills.OrderPickedActivity;

public class CourierSetup extends Activity {

    MapView mMapView = null;
    private ListView courierList;
    private ArrayList<Courier> mCourerList;
    private CourierListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // 在使用SDK各组件之前初始化context信息，传入ApplicationContext
            // 注意该方法要再setContentView方法之前实现
            setContentView(R.layout.courier_pick);
            // 获取地图控件引用
            mMapView = (MapView) findViewById(R.id.bmapView);
            courierList = (ListView) findViewById(R.id.courier_lis);
            Courier a =new Courier();
            a.setAge("22");
            a.setCharacterSignature("无个性，不签名！");
            a.setGendar("male");
            a.setName("guess");
//            Courier b =new Courier();
//            b.setAge("22");
//            b.setCharacterSignature("无个性，不签名！");
//            b.setGendar("male");
//            b.setName("guess");
            mCourerList = new ArrayList<Courier>();
            mCourerList.add(a); // mCourerList.add(b);
            adapter = new CourierListAdapter(CourierSetup.this,mCourerList);
            courierList.setAdapter(adapter);
            findViewById(R.id.btn_confirm).setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(CourierSetup.this,
                            OrderPickedActivity.class);
                      startActivity(intent);
                }
                
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
