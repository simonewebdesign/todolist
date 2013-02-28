package com.example.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	private Context activity;
	private int layoutId;
	private ArrayList<ToDoRow> rows;
	
	public MyAdapter(Context ctx, int layoutResourceId, ArrayList<ToDoRow> theRows) {
		super();
		activity = ctx;
		layoutId = layoutResourceId;
		rows = theRows;
	}
	
	@Override
	public int getCount() {
		return this.rows.size();
	}

	@Override
	public Object getItem(int position) {
		if (this.rows != null) {
			return this.rows.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (rows != null && activity != null)
		{
			View itemView;
			
			if (convertView == null) {
				
				itemView = new ItemView(this.activity, null);
			}
			else {
				itemView = (ItemView) convertView;
			}
			
			ToDoRow currentRow = rows.get(position);
			
			((ItemView)itemView).loadEntity(currentRow);
			
			return itemView;
		}
		return null;
	}

}
