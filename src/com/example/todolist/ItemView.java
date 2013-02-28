package com.example.todolist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemView extends RelativeLayout {

	private ToDoRow rowEntity = null;
	private static final String TAG = "ItemView";
	
	
	public ItemView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater inflater;
		inflater = (LayoutInflater) getContext().getSystemService(infService);
		inflater.inflate(R.layout.item_view, this, true);
		
		rowEntity = new ToDoRow("pippo");
//		final LayoutInflater inflater = ((Activity) activity).getLayoutInflater();
//		itemView = inflater.inflate(R.layout.item_view, null);
		//itemView = View.inflate(activity, R.layout.item_view, null);		
	}
	
	
	public void loadEntity(ToDoRow rowEntity) {
		
		this.rowEntity = rowEntity;
		
		final TextView text = (TextView) findViewById(R.id.task);
		final CheckBox check = (CheckBox) findViewById(R.id.checked);
		
		text.setText(rowEntity.getTask());
		check.setChecked(rowEntity.isChecked());
	}
	
	
	public void toggleTask(View view) { // onCheck
		
		CheckBox checkBox = (CheckBox) view;
		this.rowEntity.setChecked(checkBox.isChecked());
	}
	
	
	private OnClickListener myListener = new OnClickListener() {
		
	    public void onClick(View v) {
	      toggleTask(v);
	      Log.v(TAG, "OnClickListener called!");
	    }
	};
	
}
