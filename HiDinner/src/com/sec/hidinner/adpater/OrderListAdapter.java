package com.sec.hidinner.adpater;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;
import com.sec.hidinner.R;
import com.sec.hidinner.bills.OrderBean;

public class OrderListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<OrderBean>  mList;
    private ImageLoader mImageLoader;  

    public OrderListAdapter(Context context, ArrayList<OrderBean> mList) {
        this.context = context;
        this.mList = mList;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        RequestQueue mQueue = Volley.newRequestQueue(context);    
        mImageLoader = new ImageLoader(mQueue, new BitmapCache()); 
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        final int location = position;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.order_picked_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.fromTo = (TextView) convertView.findViewById(R.id.tv_from_to);
            viewHolder.bonus= (TextView) convertView
                    .findViewById(R.id.tv_order_bonus);
            viewHolder.imageShop = (ImageView) convertView.findViewById(R.id.im_photo);
            viewHolder.last = (TextView) convertView.findViewById(R.id.tv_last);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText((mList.get(location).getName()));
        viewHolder.fromTo.setText(mList.get(location).getFromTo());
        viewHolder.bonus.setText(mList.get(location).getBonus());
        viewHolder.last.setText((mList.get(location).getLast()));
        ImageListener listener = ImageLoader.getImageListener(viewHolder.imageShop, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);    
        String url = "http://preview.quanjing.com/chineseview044/east-ep-a51-1118363.jpg";
		mImageLoader.get(url, listener);
        return convertView;
    }

    public static class ViewHolder {
        public TextView name;
        public TextView fromTo;
        public TextView bonus;
        public TextView last;
        public ImageView imageShop;
    }
    
    public class BitmapCache implements ImageCache {    
        private LruCache<String, Bitmap> mCache;    
            
        public BitmapCache() {    
            int maxSize = 10 * 1024 * 1024;    
            mCache = new LruCache<String, Bitmap>(maxSize) {    
                @Override    
                protected int sizeOf(String key, Bitmap value) {    
                    return value.getRowBytes() * value.getHeight();    
                }    
                    
            };    
        }    
        
        @Override    
        public Bitmap getBitmap(String url) {    
            return mCache.get(url);    
        }    
        
        @Override    
        public void putBitmap(String url, Bitmap bitmap) {    
            mCache.put(url, bitmap);    
        }    
        
    }    

}
