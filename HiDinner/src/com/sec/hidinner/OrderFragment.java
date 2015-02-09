package com.sec.hidinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.sec.hidinner.adpater.ShopAdapter;
import com.sec.hidinner.shop.ShopBean;
import com.sec.hidinner.shop.ShopDetailsActivity;

public class OrderFragment extends Fragment {
	
	private ArrayList<ShopBean> mShopList;
	private ShopBean shop;
	private ShopAdapter mAdapter;
	Handler handler;
	ListView list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.hi_dinner_order, container,false);
		shop = new ShopBean();
		mShopList = new ArrayList<ShopBean>();
		shop.setDelividerTime("36min");
		shop.setDelividerType("null");
		shop.setDiscount("20-8");
		shop.setName("KFC1");
		shop.setNewCustomerActivity("30-2");
		shop.setSaleLimit("at lease 10$");
		shop.setSaleNum("888");
		shop.setGrade("网友评分"+"4.7");
		shop.setDistance("5千米以内");
		shop.setType("西餐");
		 mShopList.add(shop);
		ShopBean shop1 = new ShopBean();
		shop1.setDelividerTime("36min");
		shop1.setDelividerType("null");
		shop1.setDiscount("20-8");
		shop1.setName("KFC2");
		shop1.setNewCustomerActivity("30-2");
		shop1.setSaleLimit("at lease 10$");
		shop1.setSaleNum("888");
		shop1.setGrade("网友评分"+"4.7");
		shop1.setDistance("5千米以内");
		shop1.setType("西餐");
		mShopList.add(shop1);
		ShopBean shop2= new ShopBean();
		shop2.setDelividerTime("36min");
		shop2.setDelividerType("null");
		shop2.setDiscount("20-8");
		shop2.setName("KFC3");
		shop2.setNewCustomerActivity("30-2");
		shop2.setSaleLimit("at lease 10$");
		shop2.setSaleNum("888");
		shop2.setGrade("网友评分"+"4.7");
		shop2.setDistance("5千米以内");
		shop2.setType("西餐");
		mShopList.add(shop2);
		ShopBean shop3= new ShopBean();
		shop3.setDelividerTime("36min");
		shop3.setDelividerType("null");
		shop3.setDiscount("20-8");
		shop3.setName("KF4C");
		shop3.setNewCustomerActivity("30-2");
		shop3.setSaleLimit("at lease 10$");
		shop3.setSaleNum("888");
		shop3.setGrade("网友评分"+"4.7");
		shop3.setDistance("5千米以内");
		shop3.setType("西餐");
		mShopList.add(shop3);
		ShopBean shop4=new ShopBean();
		shop4.setDelividerTime("36min");
		shop4.setDelividerType("null");
		shop4.setDiscount("20-8");
		shop4.setName("KFC5");
		shop4.setNewCustomerActivity("30-2");
		shop4.setSaleLimit("at lease 10$");
		shop4.setSaleNum("888");
		shop4.setGrade("网友评分"+"4.7");
		shop4.setDistance("5千米以内");
		shop4.setType("西餐");
		mShopList.add(shop4);
		
		list = (ListView) view.findViewById(R.id.shop_list);
		mAdapter =new ShopAdapter(getActivity(), mShopList);
		list.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
		//list.setAdapter(mAdapter);
//		list.setOnItemClickListener(new OnItemClickListener(){
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				Intent intent = new Intent(getActivity(),ShopDetailsActivity.class);
//				startActivity(intent);
//			}
//			
//		});
		//之前的fragmentlist数据不能显示是因为重复inflator所致，所以记住不能重复绘制，这样会导致数据无法正常的显示。
		return view;
	}

	 public static OrderFragment newInstance() {
         OrderFragment fragment = new OrderFragment();
         return fragment;
     }
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	//所有点击事件放入此方法中执行。
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(),ShopDetailsActivity.class);
				startActivity(intent);
			}
			
		});
	}

	  
	
}
