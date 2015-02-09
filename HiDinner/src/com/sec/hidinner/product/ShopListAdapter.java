package com.sec.hidinner.product;

import java.util.ArrayList;
import java.util.List;

import com.sec.hidinner.R;
import com.sec.hidinner.shop.ShopBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ShopListAdapter extends BaseAdapter {
    
    private Context context;
    private List<ShopBean> shopList;//= new ArrayList<ShopBean> ();
    private ListView lsitview;
    
    public ShopListAdapter(Context context, List<ShopBean> shopList,
            ListView lsitview) {
        super();
        this.context = context;
        this.shopList = shopList;
        this.lsitview = lsitview;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return shopList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return shopList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public ShopListAdapter(Context context, List<ShopBean> shopList) {
        super();
        this.context = context;
        this.shopList = shopList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(inflater);
//        shop.setDelividerTime("36min");
//        shop.setDelividerType("null");
//        shop.setDiscount("20-8");
//        shop.setName("KFC");
//        shop.setNewCustomerActivity("30-2");
//        shop.setSaleLimit("at lease 10$");
//        shop.setSaleNum("888");
        //shop.setType(type)
        ShopBean shop = shopList.get(position);
        LinearLayout linearLayout = null;
        linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.restaurant_item, null);
        ImageView shopIcon = (ImageView) linearLayout.findViewById(R.id.shop_icon);
        TextView shopName = (TextView) linearLayout.findViewById(R.id.shop_name);
        ImageView reputation = (ImageView) linearLayout.findViewById(R.id.shop_reputation);
        TextView commentNum = (TextView) linearLayout.findViewById(R.id.comment_number);
        TextView saleNum = (TextView) linearLayout.findViewById(R.id.shop_sale_number);
        TextView saleLimit = (TextView) linearLayout.findViewById(R.id.shop_order_limit);
        TextView orderTime = (TextView) linearLayout.findViewById(R.id.shop_order_time);
        shop = shopList.get(position);
        shopName.setText(shop.getName());saleNum.setText(shop.getSaleNum());
        commentNum.setText(shop.getCommentNum());saleLimit.setText(shop.getSaleLimit());
        orderTime.setText(shop.getDelividerTime());
        return linearLayout;
    }

}
