package com.sec.hidinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sec.hidinner.bills.OrderListActivity;
import com.sec.hidinner.bills.OrderListFragment;
import com.sec.hidinner.found.FragmentFound;
import com.sec.hidinner.index.FragmentIndex;
import com.sec.hidinner.setting.SettingsActivity;
import com.sec.hidinner.shop.ShopMain;
import com.sec.hidinner.user.UserCenterActivity;
import com.sec.hidinner.R;
import com.zxing.activity.CaptureActivity;

public class HiDinnerMain extends Activity implements OnItemClickListener,
		OnClickListener,OnPageChangeListener {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ArrayList<String> menuLists;
	private ArrayAdapter<String> adapter;
	@SuppressWarnings("deprecation")
	private ActionBarDrawerToggle mDrawerToggle;
	private String mTitle;
	private ViewPager mViewPager;
	private Button mIndex;
	private Button mOrderMill;
	private Button mGetOrder;
	private Button mMessages;
	private Button mOther;
	private MainPagerAdapter pageAdapter;
	private ArrayList<Fragment>fragments;
	FragmentManager fragmentManager = getFragmentManager();
	FragmentTransaction transaction = fragmentManager
			.beginTransaction();

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hi_dinner_main);
		 mViewPager = (ViewPager) findViewById(R.id.viewPager);
		 fragments = new ArrayList<Fragment>();
		 fragments.add(new FragmentIndex());
		 fragments.add(new OrderFragment());
		 fragments.add(new FragmentFound());
		 fragments.add(new OrderListFragment());
		
		 
		InitView();
		mTitle = (String) getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		menuLists = new ArrayList<String>();
		//menuLists.add("我的账户");
		
		menuLists.add("个人主页");
		menuLists.add("扫描二维码");
		menuLists.add("设置");
		menuLists.add("登录");
		menuLists.add("订单记录");
		menuLists.add("好友");
		menuLists.add("信息");
		
		
		
		pageAdapter= new MainPagerAdapter(fragmentManager, fragments);
		mViewPager.setAdapter(pageAdapter);
		mViewPager.setCurrentItem(0);
		mViewPager.setOnPageChangeListener(this);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menuLists);
		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(this);
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

	void InitView() {
		mIndex = (Button) findViewById(R.id.btn_index);
		mIndex.setOnClickListener(this);
		mOrderMill = (Button) findViewById(R.id.btn_order_mill);
		mOrderMill.setOnClickListener(this);
		mGetOrder = (Button) findViewById(R.id.btn_get_order);
		mGetOrder.setOnClickListener(this);
		mMessages = (Button) findViewById(R.id.btn_my);
		mMessages.setOnClickListener(this);
		 mOther =  (Button) findViewById(R.id.others);
		 mOther .setOnClickListener(this);
		// 默认显示 资讯 标签页
//		transaction.replace(R.id.content, OrderFragment.newInstance())
//				.commit();
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
	public void onItemClick(AdapterView<?> v1, View v, int position, long arg3) {
		TextView tv1 = (TextView) v.findViewById(android.R.id.text1);
		if (tv1.getText().equals("扫描二维码")) {
			 try {
				Intent intent = new Intent(HiDinnerMain.this,CaptureActivity.class);
				 startActivity(intent);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (tv1.getText().equals("个人主页")) {
			Intent intent = new Intent(HiDinnerMain.this,
					UserCenterActivity.class);
			startActivity(intent);
		}
		else if (tv1.getText().equals("设置")) {
			Intent intent = new Intent(HiDinnerMain.this,
					SettingsActivity.class);
			startActivity(intent);
		}
		else if (tv1.getText().equals("登录")) {
			Intent intent = new Intent(HiDinnerMain.this,
					LoginActivity.class);
			startActivity(intent);
		}
		// 动态插入一个Fragment到FrameLayout当中
//		Fragment contentFragment = new ContentFragment();
//		Bundle args = new Bundle();
//		args.putString("text", menuLists.get(position));
//		contentFragment.setArguments(args);
//
//		FragmentManager fm = getFragmentManager();
//		fm.beginTransaction().replace(R.id.content_frame, contentFragment)
//				.commit();

		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {

		case R.id.btn_get_order:
			mViewPager.setCurrentItem(3);
			mGetOrder.setTextColor(getResources().getColor(R.color.red));
			mIndex.setTextColor(getResources().getColor(R.color.black));
			mOrderMill.setTextColor(getResources().getColor(R.color.black));
			mOther.setTextColor(getResources().getColor(R.color.black));
			
			break;

		case R.id.btn_index:
			mViewPager.setCurrentItem(0);
			mGetOrder.setTextColor(getResources().getColor(R.color.black));
			mIndex.setTextColor(getResources().getColor(R.color.red));
			mOrderMill.setTextColor(getResources().getColor(R.color.black));
			mOther.setTextColor(getResources().getColor(R.color.black));
			break;
		case R.id.btn_order_mill:
			mViewPager.setCurrentItem(1);
			mGetOrder.setTextColor(getResources().getColor(R.color.black));
			mIndex.setTextColor(getResources().getColor(R.color.black));
			mOrderMill.setTextColor(getResources().getColor(R.color.red));
			mOther.setTextColor(getResources().getColor(R.color.black));
			break;
		case R.id.others:
			mViewPager.setCurrentItem(2);
			mGetOrder.setTextColor(getResources().getColor(R.color.black));
			mIndex.setTextColor(getResources().getColor(R.color.black));
			mOrderMill.setTextColor(getResources().getColor(R.color.black));
			mOther.setTextColor(getResources().getColor(R.color.red));
			break;
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		mViewPager.setCurrentItem(arg0);
		switch(arg0){
		case 0:
			
			break;
		case 1:
			//mOrderMill.setTextColor(getResources().getColor(R.color.call_log_missed_call_highlight_color));
			//mOrderMill.setBackgroundResource(getResources().getColor(R.color.background_dialer_light));
			//mOrderMill.setTextColor(007200);
			
			break;
		case 2:
			
			break;
		case 3:
		//	mGetOrder.setTextColor(getResources().getColor(R.color.call_log_missed_call_highlight_color));
			break;
			
		}
		
	}

}
