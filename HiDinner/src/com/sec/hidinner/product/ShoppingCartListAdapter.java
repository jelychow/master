package com.sec.hidinner.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sec.hidinner.R;

public class ShoppingCartListAdapter extends BaseAdapter {
    List<ProductBean> list;
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<ProductBean> mList;
    CheckBox cbShop;
    BaseAdapter adapter;
    public static Map<Integer, Boolean> isCheckMap = new HashMap<Integer, Boolean>();

    public ShoppingCartListAdapter(Context context, List<ProductBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // isSelected = new HashMap<Integer, Boolean>();
        // 初始化数据
        configCheckMap(false);
    }

    public void configCheckMap(boolean bool) {

        for (int i = 0; i < list.size(); i++) {
            isCheckMap.put(i, bool);
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
    public View getView( int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewHolder = null;
        final int location = position;
        if (convertView == null) {
            convertView = layoutInflater.inflate(
                    R.layout.shopping_car_listitem, null);
            viewHolder = new ViewHolder();
            viewHolder.shopname = (TextView) convertView
                    .findViewById(R.id.tv_shopname);
            viewHolder.linearlayout = (LinearLayout) convertView
                    .findViewById(R.id.layout_title);
            viewHolder.productname = (TextView) convertView
                    .findViewById(R.id.item_name);
            viewHolder.cost = (TextView) convertView.findViewById(R.id.tv_cost);
            viewHolder.num = (TextView) convertView.findViewById(R.id.tv_num);
            CheckBox cb1 =viewHolder.cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
            viewHolder.cbItem = (CheckBox) convertView.findViewById(R.id.checkBox2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 店铺名称
        // viewHolder.shopname.setText((list.get(location).getShopname()));
        viewHolder.productname.setText((list.get(location).getProductname()));
        viewHolder.cost.setText(list.get(location).getPrice());
        viewHolder.num.setText((list.get(location).getNum()));
        // viewHolder.shoplist.setText((list.get(location).get(0).getShopname()));
        // 实例化店铺的adapter
        if ((location > 0)
                && (list.get(location).getShopname().equals(list.get(
                        location - 1).getShopname()))) {
            viewHolder.linearlayout.setVisibility(View.GONE);
        } else {
            viewHolder.linearlayout.setVisibility(View.VISIBLE);
            viewHolder.cb.setText((list.get(location).getShopname()));
            viewHolder.cb
                    .setOnCheckedChangeListener(new OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView,
                                boolean isChecked) {
                            /*
                             * 将选择项加载到map里面寄存
                             */
                            isCheckMap.put(location, isChecked);
                        }
                    });
            
//            viewHolder.cb.setOnClickListener(new OnClickListener(){
//
//                @Override
//                public void onClick(View v) {
//                    for (int i=0;i<mList.size();i++){
//                        if (mList.get(i).getShopname().equals(mList.get(i+1).getShopname())){
//                            
//                        }
//                    }
//                }
//                
//            });
        }
        
        viewHolder.cbItem.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                    boolean isChecked) {
                isCheckMap.put(location, isChecked);
            }
        });
        
        viewHolder.cb.setChecked(isCheckMap.get(position));
        if ( viewHolder.cb.isChecked()){
            
        }
        viewHolder.cbItem.setChecked(isCheckMap.get(position));
        
        return convertView;
    }

    public static class ViewHolder {
        public TextView shopname;
        public TextView productname;
        public TextView cost;
        public TextView num;
        public LinearLayout linearlayout;
        CheckBox cb;
        CheckBox cbItem;
    }

    public Map<Integer, Boolean> getCheckMap() {
        return this.isCheckMap;
    }

    private void dataChanged() {
        // 通知listView刷新
        adapter.notifyDataSetChanged();
        // TextView显示最新的选中数目
        // tv_show.setText("已选中" + checkNum + "项");
    };

}
