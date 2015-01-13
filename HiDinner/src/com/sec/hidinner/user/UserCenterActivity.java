package com.sec.hidinner.user;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sec.hidinner.R;

public class UserCenterActivity  extends Activity{

	private ListView mListView;
	private String[]items;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.user_center);
	        mListView = (ListView) findViewById(R.id.lv_user_center_list);
	        items = new String[]{
	        	"我的订单","我的好友","最近来访","我的收藏","我的相册","","","分享","邀请好友","意见反馈","检查更新","关于我们"	
	        };
	        ArrayAdapter adapter = new  ArrayAdapter (this, android.R.layout.simple_list_item_1, items);
	        mListView.setAdapter(adapter);
	    }
}