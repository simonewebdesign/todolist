package com.example.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.content.DialogInterface;
import android.os.Bundle;

public class ItemViewDialogFragment extends DialogFragment {
	
	private final String TAG = "ItemViewDialogFragment";
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setItems(R.array.actions_array, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	            	   Log.v(TAG, "ITS OVER 9000!!!!!!!!!!!!!!11");
	               }               
	           });
		
		// Create the AlertDialog object and return it
		return builder.create();
	}
}
