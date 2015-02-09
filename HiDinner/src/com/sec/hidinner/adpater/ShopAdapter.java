package com.sec.hidinner.adpater;

import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sec.hidinner.R;
import com.sec.hidinner.shop.ShopBean;

public class ShopAdapter extends BaseAdapter {
    
    private Context context;
    private List<ShopBean> shopList;//= new ArrayList<ShopBean> ();
    private ListView lsitview;
    
    public ShopAdapter(Context context, List<ShopBean> shopList,
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

    public ShopAdapter(Context context, List<ShopBean> shopList) {
        super();
        this.context = context;
        this.shopList = shopList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(inflater);
        ShopBean shop = shopList.get(position);
        FrameLayout linearLayout = null;
        linearLayout = (FrameLayout) layoutInflater.inflate(R.layout.shop_item, null);
       // ImageView shopIcon = (ImageView) linearLayout.findViewById(R.id.shop_icon);
        TextView shopName = (TextView) linearLayout.findViewById(R.id.tv_name);
      //  ImageView reputation = (ImageView) linearLayout.findViewById(R.id.shop_reputation);
        TextView distance = (TextView) linearLayout.findViewById(R.id.tv_distance);
        TextView main = (TextView) linearLayout.findViewById(R.id.tv_type);
        TextView grade = (TextView) linearLayout.findViewById(R.id.tv_grade);
        shop = shopList.get(position);
        shopName.setText(shop.getName());distance.setText(shop.getDistance());
        main.setText(shop.getType());grade.setText(shop.getGrade());
        return linearLayout;
    }

	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
		
	}

}
