package com.sec.hidinner.user;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sec.hidinner.R;

public class UserDataActivity extends FragmentActivity {
	private Context mContext;
	
	private HorizontalScrollView mImageContainer;
	private GridViewAdapter mGridViewAdapter;
	private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_activity);
        mGridView = (GridView) findViewById(R.id.image_grid_view);
        mImageContainer = (HorizontalScrollView) findViewById(R.id.image_grid_view_container);
        
        mContext = getApplicationContext();
    	mGridViewAdapter = new GridViewAdapter();
		mGridView.setAdapter(mGridViewAdapter);
     
		refreshImageGridview();
    }
    
    private List<Bitmap> getEditingBitmaps(){
		List<Bitmap> images = new ArrayList<Bitmap>();
		for(int i=0; i < 10; i++){
			images.add(BitmapFactory.decodeResource(getResources(), R.drawable.test2));
		}
		return images;
	}
    
    private void refreshImageGridview() {
		mImageContainer.setVisibility(View.VISIBLE);
		List<Bitmap> images = getEditingBitmaps();
		int imageSize =  images.size();
		mGridViewAdapter.setBitmaps(images);
		
		int rowNum = 2; // set how many row by yourself
		int gridItemWidth = getResources().getDimensionPixelSize(R.dimen.image_gridview_width);
		int gridItemHeight = getResources().getDimensionPixelSize(R.dimen.image_gridview_width);
		int gap = getResources().getDimensionPixelSize(R.dimen.image_gridview_gap);

		// get how many columns
		int columnNum = imageSize / rowNum;
		if (columnNum % rowNum != 0) {
			columnNum++;
		}

		// get GridView's height and width
		int gridViewWidth = (gridItemWidth + gap) * columnNum;
		int gridViewHeight = (gridItemHeight + gap) * rowNum;
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridViewWidth, gridViewHeight);
		mGridView.setLayoutParams(params);
		mGridView.setColumnWidth(gridItemWidth);
		mGridView.setHorizontalSpacing(gap);
		mGridView.setVerticalSpacing(gap);
		mGridView.setStretchMode(GridView.NO_STRETCH);
		mGridView.setNumColumns(columnNum);
	}

    private class GridViewAdapter extends BaseAdapter {
		private List<Bitmap> mBitmaps = new ArrayList<Bitmap>();
		private ViewHolder mViewHolder;
		
		public void setBitmaps(List<Bitmap> images){
			mBitmaps = images;
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return mBitmaps != null ? mBitmaps.size() : 0;
		}

		@Override
		public Object getItem(int position) {
			return mBitmaps != null ? mBitmaps.get(position) : null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item, parent, false);
				mViewHolder = new ViewHolder();
				mViewHolder.mImageView = (ImageView) convertView.findViewById(R.id.image_view);
				convertView.setTag(mViewHolder);
			}else{
				mViewHolder = (ViewHolder) convertView.getTag();	
			}
			
			mViewHolder.mImageView.setImageBitmap(mBitmaps.get(position));
			return convertView;
		}
		
		public class ViewHolder{
			public ImageView mImageView;
		}
	}
}
