package com.sec.hidinner.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sec.hidinner.R;
import com.sec.hidinner.adpater.ShoppingCartItemAdapter;

public class ShopCartAdapter extends BaseAdapter {
	List<ArrayList<ProductBean>> list;
	Context context;
	LayoutInflater layoutInflater;
	ArrayList<ProductBean> mList;
	private int selectedPosition = -1;
	CheckBox cbShop;
	BaseAdapter adapter;
	private int checkNum;
	private static HashMap<Integer, Boolean> isSelected;

	public ShopCartAdapter(Context context, List<ArrayList<ProductBean>> list) {
		this.context = context;
		this.list = list;
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		isSelected = new HashMap<Integer, Boolean>();
		// 初始化数据
		initDate();
	}

	private void initDate() {
		for (int i = 0; i < list.size(); i++) {
			getIsSelected().put(i, false);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
			ViewHolder viewHolder = null;
			final int location = position;
			if (convertView == null) {
				convertView = layoutInflater.inflate(
						R.layout.shopping_car_listitem, null);
				viewHolder = new ViewHolder();
				viewHolder.name = (TextView) convertView
						.findViewById(R.id.tv_shopname);
				ListView listview = viewHolder.shoplist = (ListView) convertView
						.findViewById(R.id.lv_shop);
				cbShop = viewHolder.cb = (CheckBox) convertView
						.findViewById(R.id.checkBox1);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			// 店铺名称
			viewHolder.name.setText((list.get(location).get(0).getShopname()));
			viewHolder.cb.setChecked(getIsSelected().get(position));
			// viewHolder.shoplist.setText((list.get(location).get(0).getShopname()));
			// 实例化店铺的adapter
			adapter = new ShoppingCartItemAdapter(context, list.get(location));
			System.out.println(location);
			System.out.println(ShoppingCartItemAdapter.getIsSelected());
			viewHolder.shoplist.setAdapter(adapter);
			if (cbShop.isChecked()){
				for (int i = 0; i < list.get(location).size(); i++) {
					
					ShoppingCartItemAdapter.getIsSelected().put(i, true);
				}
				// 数量设为list的长度
				checkNum = list.get(location).size();
				// 刷新listview和TextView的显示
				dataChanged();
			} else {
				for (int i = 0; i < list.get(location).size(); i++) {
					ShoppingCartItemAdapter.getIsSelected().put(i, false);
				}
				// 数量设为list的长度
				checkNum = list.get(location).size();
				// 刷新listview和TextView的显示
				dataChanged();
			}
			try {
				cbShop.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						if (cbShop.isChecked()){
//							cbShop.setChecked(false);
//							
							//adapter.notifyDataSetChanged();
							for (int i = 0; i < list.get(location).size(); i++) {
								((ShoppingCartItemAdapter) adapter).getIsSelected().put(i, true);
							}
							 //数量设为list的长度
							checkNum = list.get(location).size();
							System.out.println(checkNum+"CHECKNUM");
							// 刷新listview和TextView的显示
							cbShop.invalidate();
							dataChanged();
						} else {
							for (int i = 0; i < list.get(location).size(); i++) {
								if (((ShoppingCartItemAdapter) adapter).getIsSelected().get(i)) {
									((ShoppingCartItemAdapter) adapter).getIsSelected().put(i, false);
									checkNum--;
								} else {
									ShopCartAdapter.getIsSelected().put(i, true);
									checkNum++;
								}
							}
							cbShop.invalidate();
							cbShop.setChecked(true);
							adapter.notifyDataSetChanged();
							// 刷新listview和TextView的显示
							dataChanged();
						}
						
					}});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return convertView;
	}

	public static class ViewHolder {
		public TextView name;
		public ListView shoplist;
		CheckBox cb;
	}

	public void setSelectedPosition(int position) {
		selectedPosition = position;
	}

	public static HashMap<Integer, Boolean> getIsSelected() {
		return isSelected;
	}

	public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
		ShopCartAdapter.isSelected = isSelected;
	}

	private void dataChanged() {
		// 通知listView刷新
		adapter.notifyDataSetChanged();
		// TextView显示最新的选中数目
		// tv_show.setText("已选中" + checkNum + "项");
	};

}
