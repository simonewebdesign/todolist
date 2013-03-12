package com.example.todolist;

import android.os.Parcel;
import android.os.Parcelable;

public class ToDoRow implements Parcelable{
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringArray(new String[] {this.task,
                this.checked?"true":"false"});
		
	}
}
