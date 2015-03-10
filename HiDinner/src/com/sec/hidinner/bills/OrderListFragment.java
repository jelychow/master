package com.sec.hidinner.bills;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

import com.sec.hidinner.R;
import com.sec.hidinner.adpater.OrderListAdapter;
import com.sec.hidinner.sociation.Courier;
import com.sec.hidinner.sociation.CourierSetup;

public class OrderListFragment extends Fragment {

	private ArrayList<OrderBean> arrayList;
	private ListView mListView;
	private Context mContext;
	BaseAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.order_list_activity, container,
				false);
		try {
			mListView = (ListView) view.findViewById(R.id.get_list);
			arrayList = getdata();
			adapter = new OrderListAdapter(getActivity(), arrayList);
			mListView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			// listView滑动状态判断	

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(),
						CourierSetup.class);
				startActivity(intent);

			}

		});
		
//		mListView.setOnScrollListener(new OnScrollListener() {
//
//			@Override
//			public void onScrollStateChanged(AbsListView arg0, int arg1) {
//
//			}
//
//			@Override
//			public void onScroll(AbsListView arg0, int firstItem,
//					int visibleItemCount, int totalItemCount) {
//
//				// 到达底部
//				if (firstItem + visibleItemCount == totalItemCount) {
//					arrayList = getdata();
//					adapter.notifyDataSetChanged();
//				}
//			}
//		});
	}

	private ArrayList<OrderBean> getdata() {
		int size = 0;
		if (arrayList != null) {
			size = arrayList.size();
		}
		if (arrayList == null) {
			arrayList = new ArrayList<OrderBean>();
			OrderBean o1 = new OrderBean();
			o1.setBonus("赏金：$3");
			o1.setFromTo("从南京到北京1");
			o1.setLast("30s");
			o1.setName("NiMa");

			OrderBean o2 = new OrderBean();
			o2.setBonus("赏金：$3");
			o2.setFromTo("从南京到北京2");
			o2.setLast("30s");
			o2.setName("NiMa");

			OrderBean o3 = new OrderBean();
			o3.setBonus("赏金：$3");
			o3.setFromTo("从南京到北京3");
			o3.setLast("30s");
			o3.setName("NiMa");
			
			OrderBean o4 = new OrderBean();
			o4.setBonus("赏金：$3");
			o4.setFromTo("从南京到北京4");
			o4.setLast("30s");
			o4.setName("NiMa");

			OrderBean o5 = new OrderBean();
			o5.setBonus("赏金：$3");
			o5.setFromTo("从南京到北京5");
			o5.setLast("30s");
			o5.setName("NiMa");

			OrderBean o6 = new OrderBean();
			o6.setBonus("赏金：$6");
			o6.setFromTo("从南京到北京6");
			o6.setLast("60s");
			o6.setName("NiMa");
			

			OrderBean o7 = new OrderBean();
			o7.setBonus("赏金：$3");
			o7.setFromTo("从南京到北京7");
			o7.setLast("30s");
			o7.setName("NiMa");

			OrderBean o8 = new OrderBean();
			o8.setBonus("赏金：$8");
			o8.setFromTo("从南京到北京8");
			o8.setLast("80s");
			o8.setName("NiMa");
			
			OrderBean o9 = new OrderBean();
			o9.setBonus("赏金：$3");
			o9.setFromTo("从南京到北京9");
			o9.setLast("30s");
			o9.setName("NiMa");

			OrderBean o10 = new OrderBean();
			o10.setBonus("赏金：$10");
			o10.setFromTo("从南京到北京10");
			o10.setLast("100s");
			o10.setName("NiMa");
			arrayList.add(o1);
			arrayList.add(o2);
			arrayList.add(o3);
			arrayList.add(o4);
			arrayList.add(o5);
			arrayList.add(o6);
			arrayList.add(o7);
			arrayList.add(o8);
			arrayList.add(o9);
			arrayList.add(o10);
		}

		return arrayList;
	}



}
