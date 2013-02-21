package com.example.todolist;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.prefs.Preferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
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
	private ArrayList<String> todoItems;

	private SharedPreferences storage = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Get references to UI widgets
		ListView myListView = (ListView) findViewById(R.id.myListView);
		myEditText = (EditText) findViewById(R.id.myEditText);

		// Create the array list of to do items
		todoItems = new ArrayList<String>();
		
		// Create the array adapter to bind the array to the listview
		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, todoItems);
		
		// Bind the array adapter to the listview.
		myListView.setAdapter(aa);

       // Restore preferences
		storage = getPreferences(MODE_PRIVATE);
		
		for (Map.Entry<String, ?> entry : storage.getAll().entrySet()) {
			Log.v(TAG, entry.getKey() + ": " + entry.getValue());
			aa.add((String)entry.getValue());
			aa.notifyDataSetChanged();
		}

		// ---------------------------------------------------------
		// ---------------------------------------------------------

		//
		// myEditText.setKeyListener(new KeyListener() {
		// public boolean onKey(View v, int keyCode, KeyEvent event) {
		// if (event.getAction() == KeyEvent.ACTION_DOWN)
		// if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
		// todoItems.add(0, myEditText.getText().toString());
		// aa.notifyDataSetChanged();
		// myEditText.setText("");
		// return true;
		// }
		// return false;
		// }
		//
		// @Override
		// public void clearMetaKeyState(View arg0, Editable arg1, int arg2) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public int getInputType() {
		// // TODO Auto-generated method stub
		// return 0;
		// }
		//
		// @Override
		// public boolean onKeyDown(View view, Editable text, int keyCode,
		// KeyEvent event) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		//
		// @Override
		// public boolean onKeyOther(View view, Editable text,
		// KeyEvent event) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		//
		// @Override
		// public boolean onKeyUp(View view, Editable text, int keyCode,
		// KeyEvent event) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		// });
		//
		// ---------------------------------------------------------------------
		// ---------------------------------------------------------------------

	}

	public void sendMessage(View view) { // onClick

		int index = 0;
		String message = myEditText.getText().toString();

		if (Util.isNullOrEmpty(message)) {

			Context context = getApplicationContext();
			CharSequence text = "You cannot leave it blank.";
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		} else {
			todoItems.add(index, message);
			aa.notifyDataSetChanged();
			myEditText.setText("");
		}
	}

	public void saveData() {
		Editor editor = this.storage.edit();
		int counter = 1;
		for (String item : todoItems) {
			editor.putString("item"+counter, item);
			Log.v(TAG, "item"+counter+ " has been successfully added to storage");
			counter++;
		}
		editor.commit();
		Log.v(TAG, "Data saved successfully");
	}
	

	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    saveData();
	    Log.v(TAG, "onDestroy called!");
	}

	@Override
	protected void onPause() {
	    super.onPause();
	    saveData();
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
	    saveData();
	    Log.v(TAG, "onStop called!");
	}
	
	
	
}
