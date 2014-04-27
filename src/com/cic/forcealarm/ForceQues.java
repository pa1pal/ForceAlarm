package com.cic.forcealarm;


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForceQues extends Activity{

	public static Boolean click = false;
	public static int a ,b, c, d ,e, r,n;
	Random ram=new Random();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forceques);
		Button giveques = (Button)findViewById(R.id.givemeques);
		final TextView ques = (TextView)findViewById(R.id.textView1);
		final EditText ans = (EditText)findViewById(R.id.editText1);
		Button snooz = (Button)findViewById(R.id.snooze);
		TextView text = (TextView)findViewById(R.id.textView1);
		a=ram.nextInt(10);
		b=ram.nextInt(10);
		c=ram.nextInt(10);
		d=ram.nextInt(10);
		e=ram.nextInt(10);
		String str= Integer.toString(a)+'*'+Integer.toString(b)+'+'+Integer.toString(c)+'*'+Integer.toString(d)+'+'+Integer.toString(e);
		text.setText(str);
	
		r = result(a, b, c, d, e);
		giveques.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText answer = (EditText)findViewById(R.id.editText1);
				n = Integer.parseInt(answer.getText().toString());
				if(r == n){
				AlarmReceive.mMediaPlayer.stop();
                finish();
				}else{
					Toast.makeText(getApplicationContext(), "wrong answer wake up dude !",
							   Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		snooz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				// TODO Auto-generated method stub
				EditText answer = (EditText)findViewById(R.id.editText1);
				n = Integer.parseInt(answer.getText().toString());
			if (r == n){
				
				AlarmReceive.mMediaPlayer.stop();
			Intent sn = new Intent("com.cic.forcealarm.Snooze");
			startActivity(sn);
			finish();
			}else{
				Toast.makeText(getApplicationContext(), "wrong answer wake up dude !",
						   Toast.LENGTH_LONG).show();
			}
				
			}
		});
	}

	public int result (int a, int b, int c, int d, int e)
	{
		int re;
		re = a+b+c*d+e ;
		return re;
		
	}
	
}
