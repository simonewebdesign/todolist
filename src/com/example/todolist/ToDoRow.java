package com.example.todolist;

public class ToDoRow {
	private String task;
	private boolean checked;

	public ToDoRow(String aTask) {
		setTask(aTask);
	}

	public ToDoRow(String aTask, boolean isChecked) {
		setTask(aTask);
		checked = isChecked;
	}

	/* getters */
	public boolean isChecked() {
		return checked;
	}
	public String getTask() {
		return task;
	}
	
	/* setters */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public void setTask(String task) {
		this.task = task;
	}
}
