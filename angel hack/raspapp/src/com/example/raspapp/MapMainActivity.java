package com.example.raspapp;



import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.GeolocationPermissions;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MapMainActivity extends Activity implements LocationListener {
public static String hospital2;
protected LocationManager locationManager;
protected LocationListener locationListener;
public static EditText listner1;
		Criteria criteria;
	static String lat;
	static String longitude;
	public void generateRequest(String latitude, String longitude) {
		String key = "AIzaSyD1VJVW1xj-KvWpe-kZAmEFAY7Sf2C36Ao";
		// String trial
		// ="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=hospital&sensor=false&key="+key;
		String trial = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
				+ latitude
				+ ","
				+ longitude
				+ "&radius=5000&types=hospital&sensor=false&key=" + key;
		//new WebserviceAsync(MapMainActivity.this).execute(trial);
	}
public void listner()
{
	listner1=new EditText(this);
	listner1.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}
	});
}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	listner();	
		
		//hospital2 = getIntent().getExtras().getString("name");
		
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String provider = locationManager.getBestProvider(criteria, true);
		Location mostRecentLocation = locationManager
				.getLastKnownLocation(provider);

		
		 lat=Double.toString(mostRecentLocation.getLatitude());
		 longitude=Double.toString(mostRecentLocation.getLongitude());

		
		/*locationManager
				.requestLocationUpdates(provider, 1, 0, locationListener);*/
		locationManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 0, 0, this);
		Toast.makeText(this, lat, Toast.LENGTH_LONG).show();
		//new getdatetimeday(this).execute(pref.getLatitude(),pref.getLongitude());
		/*if (!pref.getLatitude().equals("0") && !pref.getLongitude().equals("0")) {
			generateRequest(pref.getLatitude(),
					pref.getLongitude());
		}*/
		Button b1=(Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(new OnClickListener() {

			@Override
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+lat+longitude);
				/*String url = "http://maps.google.com/maps?saddr="
						+ pref.getLatitude() + "," + pref.getLongitude()
						+ "&daddr=" + getIntent().getExtras().getString("lat")
						+ "," + getIntent().getExtras().getString("long")
						+ "&mode=driving";*/
				String url = "http://maps.google.com/maps?saddr="
						+ lat + "," + longitude
						+ "&daddr=" + lat
						+ "," +longitude
						+ "&mode=driving";

				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
						Uri.parse(url));
				intent.setClassName("com.google.android.apps.maps",
						"com.google.android.maps.MapsActivity");
				startActivity(intent);

			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		/*getMenuInflater().inflate(R.menu, menu);*/
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}

