/**
 *WeiboAdapter.java
 *2011-9-29 下午08:18:26
 *Touch Android
 *http://bbs.droidstouch.com
 */
package com.sec.hidinner.index;

import java.util.List;

import com.sec.hidinner.R;
import com.sec.hidinner.adpater.OrderListAdapter.ViewHolder;


import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 */
public class IndexAdapter extends BaseAdapter
{

	
	private List<MessageNear> list;
	private Context context;
	
	
	
	public IndexAdapter(Context context,List<MessageNear> MessageNear) 
	{
		
		this.list = MessageNear;
		this.context = context;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		
		
		    WeiboHolder holder = null;;
	        final int location = position;
	        if (convertView == null) {
			
		    holder = new WeiboHolder();
			
			//MessageNear s = list.get(position);
			
		    convertView   = LayoutInflater.from(context).inflate(R.layout.index_item_template, null);
			
			holder.txt_wb_item_uname = (TextView) convertView .findViewById(R.id.txt_wb_item_uname);
//			holder.txt_wb_item_content= (TextView) view.findViewById(R.id.txt_wb_item_content);
//			
//			holder.txt_wb_item_from= (TextView) view.findViewById(R.id.txt_wb_item_from);
//			holder.txt_wb_item_from.setMovementMethod(LinkMovementMethod.getInstance());
//			
//			holder.txt_wb_item_uname.setText(s.getUser().getName());
//			holder.txt_wb_item_content.setText(s.getText());
//			
//			holder.txt_wb_item_from.setText("来着:"+Html.fromHtml(s.getSource()));
//			
			
			
			
			
//			//判断是否通过认证
//			if(s.getUser().isVerified())
//			{
//				holder.img_wb_item_V = (ImageView) view.findViewById(R.id.img_wb_item_V);
//				holder.img_wb_item_V.setVisibility(View.VISIBLE);
//			}
//			
//			//判断微博中是否含有图片
//			if(!StringUtil.isEmpty(s.getThumbnail_pic()))
//			{
//				holder.img_wb_item_content_pic = (ImageView) view.findViewById(R.id.img_wb_item_content_pic);
//				holder.img_wb_item_content_pic.setVisibility(View.VISIBLE);
//			}
//			
//			// 判断使用又转发
//			if(s.getRetweeted_list()!=null)
//			{
//				holder.lyt_wb_item_sublayout = (LinearLayout) view.findViewById(R.id.lyt_wb_item_sublayout);
//				
//				holder.lyt_wb_item_sublayout.setVisibility(View.VISIBLE);
//				
//				
//				holder.txt_wb_item_subcontent = (TextView) view.findViewById(R.id.txt_wb_item_subcontent);
//				holder.txt_wb_item_subcontent.setText(s.getRetweeted_list().getText());
//				
//				
//				//判断微博中是否含有图片
//				if(!StringUtil.isEmpty(s.getRetweeted_list().getThumbnail_pic()))
//				{
//					holder.img_wb_item_content_subpic = (ImageView) view.findViewById(R.id.img_wb_item_content_subpic);
//					holder.img_wb_item_content_subpic.setVisibility(View.VISIBLE);
//				}
//				
//			}
//			
//			
			//对view的操作应在循环外面，避免复用对象的时候直接复用隐藏的对象，导致显示重复；
			//holder.txt_wb_item_uname.setText(list.get(location).getName());
			Log.i("NUM", ""+position);
			convertView .setTag(holder);
		} else {
			holder=(WeiboHolder) convertView .getTag();
		}
	    holder.txt_wb_item_uname.setText(list.get(location).getName());
		return convertView ;
	}

	
	private static class WeiboHolder
	{
		
		ImageView img_wb_item_head;
		
		TextView txt_wb_item_uname;
		
		ImageView img_wb_item_V;
		
		TextView txt_wb_item_time;
		
		TextView txt_wb_item_content;
		
		ImageView img_wb_item_content_pic;
		
		LinearLayout lyt_wb_item_sublayout;
		
		TextView txt_wb_item_subcontent;
		
		ImageView img_wb_item_content_subpic;
		
		TextView txt_wb_item_from;
		
		TextView txt_wb_item_redirect;
		
		TextView txt_wb_item_comment;
		
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
	
	
	
}
