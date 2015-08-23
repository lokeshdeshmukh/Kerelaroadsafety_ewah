package com.amrita.help4emergency;

import com.amrita.help4emergency.activities.GeocodingActivity;
import com.amrita.help4emergency.activities.GeocodingLocation;
import com.amrita.help4emergency.activities.MainActivity;
import com.amrita.help4emergency.activities.SpeakingActivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Navbar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navbar);
Button b1=(Button)findViewById(R.id.buttonmap);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GeocodingLocation gl=new GeocodingLocation();
				String lat=gl.getlat();
				String longitude=gl.getlong();
				
				
				Intent intent = new Intent(Navbar.this,GeocodingActivity.class);
				
				startActivity(intent);

			}
		});
		
Button b2=(Button)findViewById(R.id.buttonhosp);
		
		b2.setOnClickListener(new OnClickListener() {

			@Override
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GeocodingLocation gl=new GeocodingLocation();
				String lat=gl.getlat();
				String longitude=gl.getlong();
				
				
				Intent intent = new Intent(Navbar.this,MainActivity.class	);
			
				startActivity(intent);

			}
		});
		
Button b3=(Button)findViewById(R.id.buttontext);
		
		b3.setOnClickListener(new OnClickListener() {

			@Override
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GeocodingLocation gl=new GeocodingLocation();
				String lat=gl.getlat();
				String longitude=gl.getlong();
				
				
				Intent intent = new Intent(Navbar.this,SpeakingActivity.class	);
			
				startActivity(intent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navbar, menu);
		return true;
	}

}
