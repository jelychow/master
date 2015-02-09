package com.sec.hidinner.shop;

import java.util.ArrayList;

import com.sec.hidinner.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<MealSet> mealSets ;
    public int foodpoition;

    public SubAdapter(Context context, ArrayList<MealSet> mealSets) {
        this.context = context;
        this.mealSets = mealSets;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mealSets.size();
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
        ViewHolder viewHolder = null;
        final int location = position;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.sublist_item, null);
            viewHolder = new ViewHolder();
            viewHolder.subItem = ( FrameLayout) convertView
                    .findViewById(R.id.sub_item);
            viewHolder.orderName = (TextView ) convertView
                    .findViewById(R.id.tv_name);
            viewHolder.saleNum = (TextView) convertView
                    .findViewById(R.id.tv_num);
            viewHolder.saleDetail = (TextView) convertView
                    .findViewById(R.id.tv_details);
            viewHolder.salePrice = (TextView) convertView
                    .findViewById(R.id.tv_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.orderName.setText(((MealSet) mealSets.get(location)).getOrderName());
        viewHolder.saleNum.setText(mealSets.get(location).getSaleNum()); 
        viewHolder.saleDetail.setText(mealSets.get(location).getSaleDetail()); 
        viewHolder.salePrice .setText(mealSets.get(location).getSalePrice());
        return convertView;
    }

    public static class ViewHolder {
        public FrameLayout subItem;;
        public TextView orderName;
        public TextView saleNum;
        public TextView saleDetail;
        public TextView salePrice;
    }

}
