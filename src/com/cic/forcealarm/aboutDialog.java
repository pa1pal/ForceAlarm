package com.cic.forcealarm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class aboutDialog extends DialogFragment{

	public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Developed By :  Pawan Pal\n\t\t\t\t\t\t \nThis app is for those who always shut down their alarm and late for there school, college or office. This app will definitely wake you up by forcing you to solve a simple mathematics problem to stop this alarm.\n The only other way to stop this to throw your phone in front wall :)\nThis app is open source you can find code on my github profile #pa1pal")
               .setTitle("About")
               .setPositiveButton("My github profile", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                     
                 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pa1pal/ForceAlarm"));
                 startActivity(browserIntent);
                   }
               })
               .setNeutralButton("My Facebook Profile", new DialogInterface.OnClickListener(){
            	   public void onClick(DialogInterface dialog, int id) {
                       
                       Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pa1.pal"));
                       startActivity(browserIntent);
                         }
               })
               .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
