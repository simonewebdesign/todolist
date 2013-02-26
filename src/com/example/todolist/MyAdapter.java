package com.example.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Activity activity;
	private Context context;
	private int layoutId;
	private ArrayList<ToDoRow> rows;
	
	
	public MyAdapter(Context ctx, int layoutResourceId, ArrayList<ToDoRow> theRows) {
		super();
		context = ctx;
		layoutId = layoutResourceId;
		rows = theRows;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO check that convertView is not null and of the appropriate type
		final LayoutInflater inflater = activity.getLayoutInflater();
		final View itemView = inflater.inflate(R.layout.item_view, null);
		final TextView text = (TextView) itemView.findViewById(R.id.task);
		final CheckBox check = (CheckBox) itemView.findViewById(R.id.checked);
		return itemView;
	}

}
