package com.example.todolist;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	private Context context = null;

	private ArrayList<ToDoRow> todoRows = null;	
	private MyAdapter adapter = null;

	private ListView myListView = null;
	private EditText myEditText = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		context = getApplicationContext();		
		setContentView(R.layout.activity_main);
		
		// Get references to UI widgets
		myListView = (ListView) findViewById(R.id.myListView);
		myEditText = (EditText) findViewById(R.id.myEditText);	

		// Create the array list of to do items
		todoRows = new ArrayList<ToDoRow>();
		
		// Create mock tasks
		todoRows.add(new ToDoRow("Feed the dog", true));
		todoRows.add(new ToDoRow("Go to walk", false));
		todoRows.add(new ToDoRow("Learn Android development", true));
		
		// Create the adapter
		adapter = new MyAdapter(this, todoRows);

		// Bind the array adapter to the ListView
		myListView.setAdapter(adapter);
		
		// Bind the event handler to the button
		Button b = (Button) findViewById(R.id.myButton);
		b.setOnClickListener(buttonListener);	
	}

	
	private OnClickListener buttonListener = new OnClickListener() {
		
	    public void onClick(View v) {
	    	
	        // do something when the button is clicked
		    Log.v(TAG, "Button clicked!");
		    
		    // add a new task
			String task = myEditText.getText().toString();
			
			if (Util.isNullOrEmpty(task)) {
				
				// task is empty; show toast
				Util.showToast(context, "You cannot leave it blank.");
			}
			else {
				int index = 0;
				todoRows.add(index, new ToDoRow(task));
				adapter.notifyDataSetChanged();
				myEditText.setText("");
			}
	    }
	};
	
	// TODO implement persistent storage
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    Log.v(TAG, "onDestroy called!");
	}
	@Override
	protected void onPause() {
	    super.onPause();
	    Log.v(TAG, "onPause called!");
	}	
	@Override
	protected void onResume() {
	    super.onResume();
	    Log.v(TAG, "onResume called!");
	}		
	@Override
	protected void onStop() {
	    super.onStop();
	    Log.v(TAG, "onStop called!");
	}
}
