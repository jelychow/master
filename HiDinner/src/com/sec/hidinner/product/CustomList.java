package com.sec.hidinner.product;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class CustomList  extends ListView { 
	public CustomList(Context context) { 
		super(context); 
	} 
	public CustomList(Context context, AttributeSet attrs) { 
		super(context, attrs); 
	}

	@Override 
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST); 
		super.onMeasure(widthMeasureSpec, expandSpec); 
	}
}