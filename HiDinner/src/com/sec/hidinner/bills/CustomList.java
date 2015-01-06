package com. sec.hidinner.bills;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.sec.hidinner.R;



public class CustomList extends Activity implements OnClickListener {
	
	private ListView mListView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customer_list);
	    mListView = (ListView) findViewById(R.id.customers);
	    
	    //mListView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		}
	}
}
