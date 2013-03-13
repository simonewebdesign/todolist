package com.example.todolist.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.example.todolist.ToDoRow;

public class JsonUtil {

	private static final String TAG = "JsonUtil";

	public static String getJSON(ArrayList<ToDoRow> todoRows)
			throws IOException {

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

	public static void writeJSON(ArrayList<ToDoRow> todoRows, String fileName,
			Context ctx) throws IOException {

		try {

			FileOutputStream fos = ctx.openFileOutput(fileName,
					Context.MODE_PRIVATE);
			fos.write(getJSON(todoRows).getBytes());
			fos.close();

		} catch (IOException e) {

			Log.e(TAG + " writeJSON()", e.getMessage());
		}
	}

	public static String readJSON(String fileName, Context ctx)
			throws FileNotFoundException, IOException {

		// Constructs a new StringBuffer containing an empty String
		StringBuffer fileContent = new StringBuffer("");

		try {

			FileInputStream fis = ctx.openFileInput(fileName);

			byte[] buffer = new byte[1024];
			/*
			 * Reads a single byte from this stream and returns it as an integer
			 * in the range from 0 to 255. Returns -1 if the end of the stream
			 * has been reached. Blocks until one byte has been read, the end of
			 * the source stream is detected or an exception is thrown.
			 */
			while (fis.read(buffer) != -1) {
				fileContent.append(new String(buffer));
			}
			fis.close();

		} catch (IOException e) {
			// could be IOException or FileNotFoundException
			e.printStackTrace();
		}
		return fileContent.toString();
	}

	public static void restoreDataFromJSON(String json,
			ArrayList<ToDoRow> todoRows) {

		todoRows.clear();

		try {

			JSONArray data = new JSONArray(json);

			for (int i = 0; i < data.length(); i++) {

				JSONObject o = data.getJSONObject(i);

				String task = o.getString("task");
				boolean checked = o.getBoolean("checked");

				ToDoRow row = new ToDoRow(task, checked);
				todoRows.add(row);
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
	}
}
