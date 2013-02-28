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

	/* getters (public) */
	public boolean isChecked() {
		return checked;
	}
	public String getTask() {
		return task;
	}
	
	/* setters (private) */
	private void setChecked(boolean checked) {
		this.checked = checked;
	}
	private void setTask(String task) {
		this.task = task;
	}
}
