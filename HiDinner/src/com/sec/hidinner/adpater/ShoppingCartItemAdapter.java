package com.sec.hidinner.adpater;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sec.hidinner.R;
import com.sec.hidinner.product.ProductBean;

public class ShoppingCartItemAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<ProductBean>  mList;
    private static HashMap<Integer, Boolean> isSelected;  
    public ShoppingCartItemAdapter(Context context, ArrayList<ProductBean> mList) {
        this.context = context;
        this.mList = mList;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        isSelected = new HashMap<Integer, Boolean>();  
        // 初始化数据  
        initDate(); 
    }
    
    private void initDate() {  
        for (int i = 0; i < mList.size(); i++) {  
            getIsSelected().put(i, false);  
        }  
    }  
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        try {
			ViewHolder viewHolder = null;
			final int location = position;
			if (convertView == null) {
			    convertView = layoutInflater.inflate(R.layout.shopping_cart_item, null);
			    viewHolder = new ViewHolder();
			    viewHolder.name = (TextView) convertView.findViewById(R.id.item_name);
			    viewHolder.cost = (TextView) convertView.findViewById(R.id.tv_cost);
			    viewHolder.num = (TextView) convertView.findViewById(R.id.tv_num);
			    convertView.setTag(viewHolder);
			} else {
			    viewHolder = (ViewHolder) convertView.getTag();
			}
			viewHolder.name.setText((mList.get(location).getProductname()));
			viewHolder.cost.setText(mList.get(location).getPrice());
			viewHolder.num.setText((mList.get(location).getNum()));
			CheckBox cbItem = viewHolder.cb = (CheckBox) convertView.findViewById(R.id.checkBox2);
			if (getIsSelected().get(position)!=null){
				viewHolder.cb.setChecked(getIsSelected().get(location));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return convertView;
    }

    
    @Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return super.areAllItemsEnabled();
	}
    
    public static HashMap<Integer, Boolean> getIsSelected() {  
        return isSelected;  
    }  
  
    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {  
        ShoppingCartItemAdapter.isSelected = isSelected;  
    }  
  

	public static class ViewHolder {
        public TextView name;
        public TextView cost;
        public TextView num;
        CheckBox cb; 
    }

}
