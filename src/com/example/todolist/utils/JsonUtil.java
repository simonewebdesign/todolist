package com.example.todolist.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.todolist.ToDoRow;

import android.util.Log;

public class JsonUtil {

	public static void writeJSONArray(List<ToDoRow> todorows, Writer out)
			throws IOException {

		if (todorows == null) {
			out.write("null");
			return;
		}
		boolean first = true;

		Iterator iter = todorows.iterator();
		out.write("{ \"list\": ");
		out.write('[');
		while (iter.hasNext()) {

			if (first)
				first = false;
			else
				out.write(',');

			Object value = iter.next();
			if (value == null) {
				out.write("null");
				continue;
			}

			out.write("{");
			out.write(("\"task\": "));
			out.write(("\"" + ((ToDoRow) value).getTask() + "\""));

			out.write(",");

			out.write(("\"checked\": "));
			out.write((((ToDoRow) value).isChecked() ? "\"true\"" : "\"false\""));
			out.write("}");
		}
		out.write(']');
		out.write("}");
		out.flush();
	}

	public static void readJSONArray(List<ToDoRow> todorows, String data) {

		try {

			todorows.clear();
			JSONObject o = new JSONObject(data);

			JSONArray jArray = o.getJSONArray("list");

			for (int i = 0; i < jArray.length(); i++) {

				JSONObject json_data = jArray.getJSONObject(i);

				boolean check = json_data.getString("checked").equals("true") ? true
						: false;
				ToDoRow todorow = new ToDoRow(json_data.getString("task"),
						check);
				todorows.add(todorow);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
