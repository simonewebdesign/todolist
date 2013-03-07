package com.example.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.content.DialogInterface;
import android.os.Bundle;

public class ItemViewDialogFragment extends DialogFragment {
	
	private final String TAG = "ItemViewDialogFragment";
    // Use this instance of the interface to deliver action events
    private ItemViewDialogListener mListener;
	
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setItems(R.array.actions_array, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	            	   Log.v(TAG, "an action has been selected");

                       // Send the positive button event back to the host activity
	            	   if (which == 0) {
	                       mListener.onDialogEditClick(ItemViewDialogFragment.this);            		   
	            	   } else
	            	   if (which == 1) {
		            	   mListener.onDialogDeleteClick(ItemViewDialogFragment.this);	            		   
	            	   }
	               }               
	           });
		
		// Create the AlertDialog object and return it
		return builder.create();
	}
	
    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface ItemViewDialogListener {
        public void onDialogEditClick(DialogFragment dialog);
        public void onDialogDeleteClick(DialogFragment dialog);
    }
    

    
    // Override the Fragment.onAttach() method to instantiate the ItemViewDialogListener, which is an interface.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (ItemViewDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement ItemViewDialogListener");
        }
    }
	
	
	
}
