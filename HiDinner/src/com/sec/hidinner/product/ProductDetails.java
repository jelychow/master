package com.sec.hidinner.product;

import com.sec.hidinner.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ProductDetails  extends Activity{
	
	private TextView btnCart;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_detail_activity);
		btnCart = (TextView) findViewById(R.id.textPutIntoShopcar);
		btnCart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent = new Intent(ProductDetails.this,ShoppingCart.class);
				startActivity(intent);
			}
		});
	}

}
