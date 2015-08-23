package com.amrita.help4emergency.activities;

import com.amrita.help2emergency.models.MyPreference;
import com.amrita.help4emergency.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.GeolocationPermissions;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HospitalDetails extends Activity {
public static String hospital2;
	
	MyPreference pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		pref = new MyPreference(this);
		setContentView(R.layout.activity_hospital_details);
		hospital2 = getIntent().getExtras().getString("name");
		Button b1=(Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GeocodingLocation gl=new GeocodingLocation();
				String lat=gl.getlat();
				String longitude=gl.getlong();
				
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+lat+longitude);
				String url = "http://maps.google.com/maps?saddr="
						+ pref.getLatitude() + "," + pref.getLongitude()
						+ "&daddr=" + getIntent().getExtras().getString("lat")
						+ "," + getIntent().getExtras().getString("long")
						+ "&mode=driving";
				/*String url = "http://maps.google.com/maps?saddr="
						+ pref.getLatitude() + "," + pref.getLongitude()
						+ "&daddr=" + lat
						+ "," +longitude
						+ "&mode=driving";*/

				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
						Uri.parse(url));
				intent.setClassName("com.google.android.apps.maps",
						"com.google.android.maps.MapsActivity");
				startActivity(intent);

			}
		});
		TextView tv=(TextView)findViewById(R.id.hname);
		TextView tv1=(TextView) findViewById(R.id.address);
		tv.setText(hospital2);
		tv1.setText(getIntent().getExtras().getString("Address"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		/*getMenuInflater().inflate(R.menu, menu);*/
		return true;
	}

}
