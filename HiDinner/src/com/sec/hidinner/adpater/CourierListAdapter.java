package com.sec.hidinner.adpater;

import java.util.ArrayList;

import com.sec.hidinner.R;
import com.sec.hidinner.shop.MealSet;
import com.sec.hidinner.shop.SubAdapter.ViewHolder;
import com.sec.hidinner.sociation.Courier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourierListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Courier> courierList;

    public CourierListAdapter(Context context, ArrayList<Courier> courierlist) {
        this.context = context;
        this.courierList = courierlist;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return courierList.size();
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
            convertView = layoutInflater.inflate(R.layout.courier_item, null);
            viewHolder = new ViewHolder();
            viewHolder.latout = (FrameLayout) convertView
                    .findViewById(R.id.courier_setting);
            viewHolder.photo = (ImageView) convertView
                    .findViewById(R.id.im_photo);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.age = (TextView) convertView.findViewById(R.id.tv_age);
            viewHolder.gendar = (TextView) convertView
                    .findViewById(R.id.tv_gendar);
            viewHolder.signature = (TextView) convertView
                    .findViewById(R.id.tv_signature);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText((courierList.get(location).getName()));
        viewHolder.age.setText(courierList.get(location).getAge());
        viewHolder.gendar.setText(courierList.get(location).getGendar());
        viewHolder.signature.setText(courierList.get(location)
                .getCharacterSignature());
        return convertView;
    }

    public static class ViewHolder {
        public ImageView photo;;
        public TextView name;
        public TextView gendar;
        public TextView age;
        public TextView signature;
        public FrameLayout latout;
    }

}
