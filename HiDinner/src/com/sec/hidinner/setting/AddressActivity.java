package com.sec.hidinner.setting;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.sec.hidinner.R;
import com.sec.hidinner.adpater.AddressAdapter;
import com.sec.hidinner.customview.FilpperListvew;

public class AddressActivity extends Activity  {
	private ImageView button;
	private FilpperListvew listView;
	private AddressAdapter adapter;
private int width;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baida.swipeback.SwipeBackActivity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("CommitPrefEdits")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_address);
		
		button = (ImageView) findViewById(R.id.add_address);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(AddressActivity.this,
						AddAddressActivity.class);
				startActivity(intent);
			}
		});
		
	}
	
//	private void init() {
//		// TODO Auto-generated method stub
////		if (new AddressManage().getaddresss(getApplicationContext(), null)
////				.size() > 0) {
//			listView = (FilpperListvew) findViewById(R.id.address_listview);
////			adapter = new AddressAdapter(getApplicationContext(),
////					new AddressManage().getaddresss(getApplicationContext(),
////							null));
//			listView.setAdapter(adapter);
//			listView.setOnItemClickListener(new OnItemClickListener() {
//
//				@Override
//				public void onItemClick(AdapterView<?> arg0, View arg1,
//						int arg2, long arg3) {
//					// TODO Auto-generated method stub
//					Intent intent = new Intent(FragmentAddressActivity.this,
//							AddressDetailActivity.class);
//					ListUtil.address = new AddressManage().getaddresss(getApplicationContext(), null);
//					intent.putExtra("index", arg2);
//					startActivity(intent);
//				}
//				
//			});
//			listView.setFilpperDeleteListener(new FilpperDeleteListener() {
//				
//				@Override
//				public void filpperDelete(float xPosition, float yPosition) {
//					// listview锟斤拷要锟斤拷item锟斤拷锟斤拷锟津返伙拷
//					if (listView.getChildCount() == 0)
//						return;
//					// 锟斤拷锟斤拷锟斤拷锟矫伙拷锟斤拷删锟斤拷锟絠tem锟斤拷index
//					final int index = listView.pointToPosition((int) xPosition,
//							(int) yPosition);
//					// 一锟斤拷锟斤拷锟斤拷锟角伙拷酶锟斤拷锟侥匡拷锟斤拷锟侥伙拷锟绞撅拷械锟斤拷锟斤拷位锟矫ｏ拷直锟接革拷锟絠ndex删锟斤拷锟斤拷指锟斤拷斐ｏ拷锟斤拷锟轿猯istview锟叫碉拷child只锟叫碉拷前锟斤拷锟斤拷幕锟斤拷锟斤拷示锟侥才诧拷锟斤拷为锟斤拷
//					int firstVisiblePostion = listView.getFirstVisiblePosition();
//					View view = listView.getChildAt(index - firstVisiblePostion);
//
//					TranslateAnimation tranAnimation = new TranslateAnimation(0,
//							width, 0, 0);
//					tranAnimation.setDuration(500);
//					tranAnimation.setFillAfter(true);
//					view.startAnimation(tranAnimation);
//					// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷虾锟缴撅拷锟斤拷锟津不伙拷锟斤拷侄锟斤拷锟叫э拷锟斤拷约锟斤拷锟斤拷锟侥ｏ拷锟斤拷
//					tranAnimation.setAnimationListener(new AnimationListener() {
//						@Override
//						public void onAnimationStart(Animation animation) {
//							// TODO Auto-generated method stub
//
//						}
//
//						@Override
//						public void onAnimationRepeat(Animation animation) {
//							// TODO Auto-generated method stub
//
//						}
//
//						@Override
//						public void onAnimationEnd(Animation animation) {
//							// TODO Auto-generated method stub
//							
//						}
//
//					});
//
//				}
//			});
//		}
//	}
}
	

	/**
 * 
 */
	
