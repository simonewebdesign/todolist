package com.example.todolist;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemView extends RelativeLayout {

	private static final String TAG = "ItemView";	
	private ToDoRow rowEntity = null;
	private ArrayList<ToDoRow> rows;
	
	public ItemView(Context context, AttributeSet attr, ArrayList<ToDoRow> _rows) {
		
		super(context, attr);
		rows = _rows;
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater inflater;
		inflater = (LayoutInflater) getContext().getSystemService(infService);
		inflater.inflate(R.layout.item_view, this, true);
		
//		final LayoutInflater inflater = ((Activity) activity).getLayoutInflater();
//		itemView = inflater.inflate(R.layout.item_view, null);
//		itemView = View.inflate(activity, R.layout.item_view, null);
		
		CheckBox c = (CheckBox) findViewById(R.id.checked);
		c.setOnClickListener(checkBoxListener);
		
		this.setOnLongClickListener(longClickListener);
	}
	
	
	public void loadEntity(ToDoRow entity) {
		
		rowEntity = entity;
		
		final TextView text = (TextView) findViewById(R.id.task);
		final CheckBox check = (CheckBox) findViewById(R.id.checked);
		
		text.setText(rowEntity.getTask());
		check.setChecked(rowEntity.isChecked());
	}
	
	
	private OnClickListener checkBoxListener = new OnClickListener() {
		
	    public void onClick(View v) {
	    	
	        // do something when the check is clicked
		    Log.v(TAG, "CheckBox clicked!");
			rowEntity.setChecked(((CheckBox) v).isChecked());
	    }
	};
	
	private OnLongClickListener longClickListener = new OnLongClickListener() {
		
		public boolean onLongClick(View v) {
			itemViewDialog itvd = new itemViewDialog();
			
			// do something when the ItemView is longClicked
			Log.v(TAG, "ItemView has been longClicked!");
			return false;
		}
	};
}
