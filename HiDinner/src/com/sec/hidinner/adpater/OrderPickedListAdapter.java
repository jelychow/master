package com.sec.hidinner.adpater;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sec.hidinner.R;
import com.sec.hidinner.bills.OrderPickedBean;

public class OrderPickedListAdapter extends BaseAdapter{

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<OrderPickedBean> pickedList;

    public OrderPickedListAdapter(Context context, ArrayList<OrderPickedBean> pickedList) {
        this.context = context;
        this.pickedList = pickedList;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return pickedList.size();
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
            convertView = layoutInflater.inflate(R.layout.picked_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_order_name);
            viewHolder.num = (TextView) convertView.findViewById(R.id.tv_order_num);
            viewHolder.cost = (TextView) convertView
                    .findViewById(R.id.tv_order_cost);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText((pickedList.get(location).getName()));
        viewHolder.num.setText(pickedList.get(location).getNum());
        viewHolder.cost.setText(pickedList.get(location).getCost());
        return convertView;
    }

    public static class ViewHolder {
        public TextView name;
        public TextView num;
        public TextView cost;
    }

}
