package it.simoli.todolist;

import android.content.Context;
import android.widget.Toast;

public class Util {

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}
	
	public static void showToast(Context context, String message) {
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, message, duration);
		toast.show();		
	}
}
