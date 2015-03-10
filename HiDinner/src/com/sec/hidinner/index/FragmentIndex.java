package com.sec.hidinner.index;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.sec.hidinner.R;
import com.sec.hidinner.bills.OrderBean;
import com.sec.hidinner.bills.OrderDetailActivity;
import com.sec.hidinner.sociation.CourierSetup;

public class FragmentIndex  extends Fragment {

	private ArrayList<MessageNear> arrayList;
	private ListView mListView;
	private Context mContext;
	BaseAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_index, container,false);
		try {
			mListView = (ListView) view.findViewById(R.id.lv_index);
			arrayList = getdata();
			adapter = new IndexAdapter(getActivity(), arrayList);
			mListView.setAdapter(adapter);
			adapter.notifyDataSetChanged();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("NUM", ""+position);
				Intent intent = new Intent(getActivity(),
						CourierSetup.class);
				startActivity(intent);

			}

		});
		
	}

	private ArrayList<MessageNear> getdata() {
		int size;
		if (arrayList != null) {
			size = arrayList.size();
		}
		if (arrayList == null) {
			arrayList = new ArrayList<MessageNear>();
			MessageNear m1 = new MessageNear();
			MessageNear m2 = new MessageNear();
			MessageNear m3 = new MessageNear();
			m1.setName("李記大燒餅1");
			m2.setName("李記大燒餅2");
			m3.setName("李記大燒餅3");
			MessageNear m4 = new MessageNear();
			MessageNear m5 = new MessageNear();
			MessageNear m6 = new MessageNear();
			m4.setName("李記大燒餅4");
			m5.setName("李記大燒餅5");
			m6.setName("李記大燒餅6");
			arrayList.add(m3);arrayList.add(m2);arrayList.add(m1);
			arrayList.add(m4);arrayList.add(m5);arrayList.add(m6);
		}

		return arrayList;
	}



}
