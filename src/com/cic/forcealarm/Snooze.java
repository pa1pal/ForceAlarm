package com.cic.forcealarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Snooze extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.snooze);
		final EditText tim = (EditText)findViewById(R.id.editText1);
		Button sno = (Button)findViewById(R.id.button1);
		sno.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Home.n= (Integer.parseInt(tim.getText().toString()))*60;
				Intent sn = new Intent("com.cic.forcealarm.Alarmset");
				startActivity(sn);
				finish();
			}
		});
	}

	
}
