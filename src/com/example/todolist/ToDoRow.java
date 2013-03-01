package com.example.todolist;

public class ToDoRow {
	private String task;
	private boolean checked;

	public ToDoRow(String aTask) {
		setTask(aTask);
		setChecked(false);
	}

	public ToDoRow(String aTask, boolean aCheck) {
		setTask(aTask);
		setChecked(aCheck);
	}

	/* getters */
	public String getTask() {
		return task;
	}
	public boolean isChecked() {
		return checked;
	}
	
	/* setters */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public void setTask(String task) {
		this.task = task;
	}
}
