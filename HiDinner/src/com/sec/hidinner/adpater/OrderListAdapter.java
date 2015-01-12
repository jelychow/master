package com.sec.hidinner.adpater;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sec.hidinner.R;
import com.sec.hidinner.bills.OrderBean;

public class OrderListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<OrderBean>  mList;

    public OrderListAdapter(Context context, ArrayList<OrderBean> mList) {
        this.context = context;
        this.mList = mList;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder viewHolder = null;
        final int location = position;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.order_picked_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.fromTo = (TextView) convertView.findViewById(R.id.tv_from_to);
            viewHolder.bonus= (TextView) convertView
                    .findViewById(R.id.tv_order_bonus);
            viewHolder.last = (TextView) convertView.findViewById(R.id.tv_last);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText((mList.get(location).getName()));
        viewHolder.fromTo.setText(mList.get(location).getFromTo());
        viewHolder.bonus.setText(mList.get(location).getBonus());
        viewHolder.last.setText((mList.get(location).getLast()));
        return convertView;
    }

    public static class ViewHolder {
        public TextView name;
        public TextView fromTo;
        public TextView bonus;
        public TextView last;
    }

}
