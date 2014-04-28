package com.cic.forcealarm;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Home extends Activity{

	private static final int MY_NOTIFICATION_ID = 1;
	private final CharSequence notification = "Hey force alarm is ready to force you on  ";
	private final CharSequence contentText = "You've Been Notified!";
	private final CharSequence notificationTitle = "Alarm Set";
	private long[] mVibratePattern = { 0, 200, 200, 300 };
	static int n = 0,h,m;
	Time dtNow = new Time();
	
	int hours ,hour;
	int Min,min;
	int Sec;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		
		Button go = (Button)findViewById(R.id.button1);
		
		go.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi") @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TimePicker time = (TimePicker)findViewById(R.id.tpTime);
				time.clearFocus();
				h=time.getCurrentHour();
				m=time.getCurrentMinute();
				
				dtNow.setToNow();
				hours=dtNow.hour;
				Min=dtNow.minute;
				Sec=dtNow.second;
				if(h < hours){

					 hour= 24 - hours + h;
					 min=m-Min;	
					
				}else
				{hour=h-hours;
				 min=m-Min;		
				}
				n=hour*3600+min*60-Sec;
				
				Notification.Builder notificationBuilder = new Notification.Builder(
						getApplicationContext())
						.setTicker(notification)
						.setSmallIcon(R.drawable.bellicon)
						.setAutoCancel(true)
						.setContentTitle(notificationTitle)
						.setContentText("hey force alarm is ready to force you")
						.setVibrate(mVibratePattern);

				// Pass the Notification to the NotificationManager:
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(MY_NOTIFICATION_ID,
						notificationBuilder.build());
				
				Intent go = new Intent("com.cic.forcealarm.Alarmset");
				startActivity(go);
				finish();
			}
		});
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.about:
		DialogFragment aboutD = new aboutDialog();
		aboutD.show(getFragmentManager(), "ABOUT_DIALOG");
		return true;
		
		
		case R.id.share:
			Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
		    sharingIntent.setType("text/plain");
		    String shareBody = "This app will definitely wake you up by forcing you to solve a mathematical problem to stop alarm! Sounds good !. You can install it from here : https://github.com/pa1pal/ForceAlarm/blob/master/bin/ForceAlarm.apk .(open in browser and click on view raw) Thanks! \nsent via Force Alarm ";
		    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Force Alarm android app");
		    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
		startActivity(Intent.createChooser(sharingIntent, "Share via"));
		Home.this.overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.bounce_interpolator);
		return true;
		
		
		case R.id.rate:
			Intent rate = new Intent(android.content.Intent.ACTION_VIEW);
            rate.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.cic.forcealarm"));
                startActivity(rate);
        		Home.this.overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
              return true;
		default:
		  
		}
		return true;
	}
	
	
	
}
