package com.example.todolist;

import java.util.ArrayList;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private EditText myEditText;
	private MyAdapter adapter;
	private ArrayList<ToDoRow> todoRows;
	private Context context = null;
	private SharedPreferences storage = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		context = getApplicationContext();		
		setContentView(R.layout.activity_main);
		// Get references to UI widgets
		ListView myListView = (ListView) findViewById(R.id.myListView);
		myEditText = (EditText) findViewById(R.id.myEditText);

		// Create the array list of to do items
		todoRows = new ArrayList<ToDoRow>();
		
		todoRows.add(new ToDoRow("fai questo", true));
		todoRows.add(new ToDoRow("fai quest altro", false));
		
		adapter = new MyAdapter(this, R.id.myListView, todoRows);

		// Bind the array adapter to the listview.
		myListView.setAdapter(adapter);

		storage = getPreferences(MODE_PRIVATE);
		
		for (Map.Entry<String, ?> entry : storage.getAll().entrySet()) {
			Log.v(TAG, entry.getKey() + ": " + entry.getValue());
//			adapter.add(entry.getValue());
//			adapter.notifyDataSetChanged();
		}
	}
	
	public void addTask(View view) { // onClick

		String task = myEditText.getText().toString();
		ToDoRow row = new ToDoRow(task);
	
		if (Util.isNullOrEmpty(task)) { // task is empty; show toast
			CharSequence text = "You cannot leave it blank.";
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
		else { // add task
			int index = 0;			
			todoRows.add(index, row);
			Log.v(TAG, "New task added: " + row.getTask());
			adapter.notifyDataSetChanged();
			myEditText.setText("");
		}
	}	
	
/*	
	private void saveData() {
		
		Editor editor = this.storage.edit();
		Integer counter = 1;
		for (ToDoRow row : todoRows) {
			editor.putStringSet(counter.toString(),  )(counter.toString(), row);
			Log.v(TAG, "Item "+ counter + " " + row + " added to storage");
			counter++;
		}
		editor.commit();
		Log.v(TAG, "Data saved successfully");
	}
*/

	@Override
	protected void onDestroy() {
	    super.onDestroy();
//	    saveData();
	    Log.v(TAG, "onDestroy called!");
	}

	@Override
	protected void onPause() {
	    super.onPause();
//	    saveData();
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
//	    saveData();
	    Log.v(TAG, "onStop called!");
	}
}
