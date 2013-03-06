package com.example.todolist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.todolist.utils.JsonUtil;
import com.example.todolist.utils.JsonUtil.*;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private Context context = null;

	private ArrayList<ToDoRow> todoRows = null;
	private MyAdapter adapter = null;

	private ListView myListView = null;
	private EditText myEditText = null;
	private final String FILENAME = "/sdcard/f.txt";

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
//		todoRows.add(new ToDoRow("Feed the dog", true));
//		todoRows.add(new ToDoRow("Go to walk", false));
//		todoRows.add(new ToDoRow("Learn Android development", true));

		// Create the adapter
		adapter = new MyAdapter(this, todoRows);

		// Bind the array adapter to the ListView
		myListView.setAdapter(adapter);

		// Bind the event handler to the button
		Button b = (Button) findViewById(R.id.myButton);
		b.setOnClickListener(buttonListener);
		
		readJsonData();
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
			} else {
				int index = 0;
				todoRows.add(index, new ToDoRow(task));
				adapter.notifyDataSetChanged();
				myEditText.setText("");
			}
		}
	};

	
	public void persistJsonDataArray() 
	{
	   
		File file = new File(FILENAME);
		
	    
			if (!file.exists()) {
				try {
					file.createNewFile();

				} catch (IOException e) {
					Log.e("MainActivity",e.getMessage());
				}
			}
		
		
		try{  
		
		
		JsonUtil.writeJSONArray(todoRows, new FileWriter(file)	);
		 
		} catch (IOException e){Log.e("MainActivity",e.getMessage());}
	
		 Log.v(TAG, "Data has been persisted");
    }
	
	

	protected void readJsonData() {
		  StringBuffer strContent = new StringBuffer("");
		  int ch;
		try {

			File file = new File(FILENAME);
			if (file.exists()) {

				FileInputStream fis = new FileInputStream(file);
				
				
				 while( (ch = fis.read()) != -1)
				        strContent.append((char)ch);
				

				try {

					JsonUtil.readJSONArray(todoRows, strContent.toString());
				} finally {
					fis.close();
				}

				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy called!");

	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG, "onPause called!");
		persistJsonDataArray();
		
		writeJSON();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.v(TAG, "onResume called!");
	    readJsonData();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.v(TAG, "onStop called!");
		
	}
	
	public String writeJSON() {
		
	  JSONArray json = new JSONArray();
	  
	  try {
		  
		for (ToDoRow row : todoRows) {
	
			JSONObject o = new JSONObject();
			o.put("task", row.getTask());
			o.put("checked", row.isChecked());
			json.put(o);
		}
		
		Log.v(TAG + " writeJSON()", json.toString());
		
	  } catch (JSONException e) {
		  e.printStackTrace();
	  }
	  return json.toString();
	}
}
