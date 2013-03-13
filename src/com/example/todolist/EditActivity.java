package com.example.todolist;

import java.io.IOException;
import java.util.ArrayList;

import com.example.todolist.utils.JsonUtil;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class EditActivity extends Activity {
	private Button cancelButton = null;
	private Button updateButton = null;
	private final String TAG = "EditActivity";
	private ArrayList<ToDoRow> todoRows = null;
	private ToDoRow todoRow;
	private EditText myEditText = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		cancelButton = (Button) findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(cancelListener);
		updateButton = (Button) findViewById(R.id.updateButton);
		updateButton.setOnClickListener(updateListener);
		myEditText = (EditText) findViewById(R.id.myEditText2);
		// Show the Up button in the action bar.
		// getActionBar().setDisplayHomeAsUpEnabled(true);
		this.todoRow = MainActivity.getRowToEdit();
		myEditText.setText(todoRow.getTask());
		todoRows = new ArrayList<ToDoRow>();
		todoRows = MainActivity.getTodoRows();

	}

	

	private OnClickListener cancelListener = new OnClickListener() {

		public void onClick(View v) {

			Log.v(TAG, "Cancel clicked!");

			EditActivity.this.finish();

		}
	};
	private OnClickListener updateListener = new OnClickListener() {

		public void onClick(View v) {

			Log.v(TAG, "Update clicked!");
			todoRow.setTask(myEditText.getText().toString());
			saveData();
			EditActivity.this.finish();

		}
	};

	public void saveData() {

		try {
			JsonUtil.writeJSON(todoRows, MainActivity.FILENAME, this);
		} catch (IOException e) {

			Log.e(TAG, "JSON writing failed.");
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_edit, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
