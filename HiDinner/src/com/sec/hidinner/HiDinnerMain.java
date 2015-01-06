package com.sec.hidinner;

import java.util.ArrayList;
import java.util.List;

import com.sec.hidinner.adpater.ShopListAdapter;
import com.sec.hidinner.shop.ShopBean;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class HiDinnerMain extends Activity implements OnItemClickListener {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mTitle;
    private List<ShopBean> mShopList = new ArrayList<ShopBean> ();
    ShopBean shop = new ShopBean();
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hi_dinner_main);
        
        shop.setDelividerTime("36min");
        shop.setDelividerType("null");
        shop.setDiscount("20-8");
        shop.setName("KFC");
        shop.setNewCustomerActivity("30-2");
        shop.setSaleLimit("at lease 10$");
        shop.setSaleNum("888");
        mShopList.add(shop);
        
        
        mTitle = (String) getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        menuLists = new ArrayList<String>();
        menuLists.add("我的账户");
        menuLists.add("我的记录");
        menuLists.add("个人主页");
        menuLists.add("好友");
        menuLists.add("信息");
        menuLists.add("设置");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menuLists);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);
        
        ListView shopList = (ListView) findViewById(R.id.shop_list);
        BaseAdapter baseAdapter = new ShopListAdapter(this,mShopList,shopList);
        try {
            shopList.setAdapter(baseAdapter);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("请选择");
                invalidateOptionsMenu(); // Call onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // 开启ActionBar上APP ICON的功能
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean isDrawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!isDrawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 将ActionBar上的图标与Drawer结合起来
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
        case R.id.action_websearch:
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri uri = Uri.parse("http://www.baidu.com");
            intent.setData(uri);
            startActivity(intent);
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // 需要将ActionDrawerToggle与DrawerLayout的状态同步
        // 将ActionBarDrawerToggle中的drawer图标，设置为ActionBar中的Home-Button的Icon
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position,
            long arg3) {
        // 动态插入一个Fragment到FrameLayout当中
        Fragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuLists.get(position));
        contentFragment.setArguments(args);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, contentFragment)
                .commit();

        mDrawerLayout.closeDrawer(mDrawerList);
    }

}
