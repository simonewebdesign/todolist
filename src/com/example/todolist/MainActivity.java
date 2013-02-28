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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private EditText myEditText;
	private ArrayAdapter<String> aa;
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
		
		MyAdapter adapter = new MyAdapter(this, R.id.myListView, todoRows);

		// Bind the array adapter to the listview.
		myListView.setAdapter(adapter);

       // Restore preferences		
		storage = getPreferences(MODE_PRIVATE);
		
		for (Map.Entry<String, ?> entry : storage.getAll().entrySet()) {
			Log.v(TAG, entry.getKey() + ": " + entry.getValue());
			aa.add((String)entry.getValue());
			aa.notifyDataSetChanged();
		}
	}
	
	public void sendMessage(View view) { // onClick

//		int index = 0;
//		String message = myEditText.getText().toString();
//		ItemView item = new ItemView(this);
		
//		if (Util.isNullOrEmpty(message)) {

//			CharSequence text = "You cannot leave it blank.";
//			int duration = Toast.LENGTH_LONG;
//			Toast toast = Toast.makeText(context, text, duration);
//			toast.show();
//		} else {
//			todoRows.add(index, item);
//			aa.notifyDataSetChanged();
///			myEditText.setText("");
//		}
	}
/*
	private void saveData() {
		Editor editor = this.storage.edit();
		int counter = 1;
		for (String item : todoItems) {
			editor.putString("item"+counter, item);
			Log.v(TAG, "Item "+ counter + " " + item + " added to storage");
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
