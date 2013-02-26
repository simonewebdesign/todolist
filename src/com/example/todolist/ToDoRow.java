package com.example.todolist;

import android.widget.CheckBox;
import android.widget.TextView;

public class ToDoRow {
	private String task;
	private boolean checked;
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public ToDoRow(String aTask, boolean isChecked) {
		setTask(aTask);
		checked = isChecked;
	}

	private String getTask() {
		return task;
	}

	private void setTask(String task) {
		this.task = task;
	}
}
