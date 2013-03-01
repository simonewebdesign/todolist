package com.example.todolist;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<ToDoRow> rows;
	
	public MyAdapter(Context ctx, ArrayList<ToDoRow> theRows) {
		
		super();
		context = ctx;
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

		if (rows != null && context != null)
		{
			View itemView;
			
			if (convertView == null) {
				
				itemView = new ItemView(this.context, null);
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
