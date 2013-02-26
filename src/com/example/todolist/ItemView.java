package com.example.todolist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ItemView extends RelativeLayout {

	private static final String TAG = "ItemView";
	private View layout = null;
	
	public ItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
//      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//      inflater.inflate(R.layout.item_view, this);
	}
	
//	public ItemView(Context context) {
//		super(context);
//		LayoutInflater inflater = context.getLayoutInflater();
//		Log.v(TAG, "Inflating ItemView...");
//		layout = inflater.inflate(R.layout.item_view, this);
//		Log.v(TAG, "ItemView XML layout inflated successfully.");
//	}
	
//	private void setMessage(String message) {
//		View textView = layout.findViewById(R.id.aTextView);
//		textView.setContentDescription(message);
//	}
}
