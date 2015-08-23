package com.amrita.help4emergency.activities;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amrita.help2emergency.models.Constants;
import com.amrita.help2emergency.models.Hospital;
import com.amrita.help2emergency.models.MyPreference;
import com.amrita.help2emergency.models.Notifier;
import com.amrita.help2emergency.models.WebserviceAsync;
import com.amrita.help4emergency.R;

public class MapActivity extends Activity implements Notifier,
		LocationListener {

	protected LocationManager locationManager;
	protected LocationListener locationListener;
	Criteria criteria;
	ListView _hospitalList;
	TextView _waiting;
	ArrayAdapter<String> adapter;
	List<Hospital> hospitals;
	MyPreference pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(Constants.TAG, "Reached onCreate");
		setContentView(R.layout.activity_main);
		pref = new MyPreference(this);
		_hospitalList = (ListView) findViewById(R.id.lv_hospitals);
		_waiting = (TextView) findViewById(R.id.tv_waiting);

		/*
		 * locationManager = (LocationManager)
		 * getSystemService(Context.LOCATION_SERVICE);
		 * locationManager.requestLocationUpdates(
		 * LocationManager.PASSIVE_PROVIDER, 0, 0, this);
		 */

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String provider = locationManager.getBestProvider(criteria, true);
		Location mostRecentLocation = locationManager
				.getLastKnownLocation(provider);

		if (mostRecentLocation != null) {
			pref.setLatitude(Double.toString(mostRecentLocation.getLatitude()));
			pref.setLongitude(Double.toString(mostRecentLocation.getLongitude()));

		}
		/*locationManager
				.requestLocationUpdates(provider, 1, 0, locationListener);*/
		locationManager.requestLocationUpdates(
				  LocationManager.PASSIVE_PROVIDER, 0, 0, this);
		
		if (!pref.getLatitude().equals("0") && !pref.getLongitude().equals("0")) {
			generateRequest(pref.getLatitude(),
					pref.getLongitude());
		}

		_hospitalList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// Cursor cursor = (Cursor)
				// ListView.getItemAtPosition(position);
				// dbo.getAllhospitals().get(Position);
				Intent x = new Intent(MapActivity.this, MapMainActivity.class);
				x.putExtra("icon", hospitals.get(position).getIcon());
				x.putExtra("name", hospitals.get(position).getName());
				x.putExtra("Address", hospitals.get(position).getAddress());
				x.putExtra("lat", hospitals.get(position).getLatitude());
				x.putExtra("long", hospitals.get(position).getLongitude());
				
				startActivity(x);
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.action_refresh) {
			generateRequest(pref.getLatitude(), pref.getLongitude());
		}
		return super.onMenuItemSelected(featureId, item);
	}

	public void generateRequest(String latitude, String longitude) {
		String key = "AIzaSyD1VJVW1xj-KvWpe-kZAmEFAY7Sf2C36Ao";
		// String trial
		// ="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=hospital&sensor=false&key="+key;
		String trial = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
				+ latitude
				+ ","
				+ longitude
				+ "&radius=5000&types=hospital&sensor=false&key=" + key;
		new WebserviceAsync(MapActivity.this).execute(trial);
	}


	@Override
	public void onHospitalResults(JSONObject json) {
		// TODO Auto-generated method stub
		Log.i(Constants.TAG, "Response:" + json.toString());
		/*
		 * Hospital hos1 = new Hospital(); hos1.setAddress("grvgv");
		 * hos1.setLatitude("gvkvn");
		 */
		
		hospitals = new ArrayList<Hospital>();

		try {
			JSONArray array = json.getJSONArray("results");
			for (int i = 0; i < array.length(); i++) {
				Hospital hospital = new Hospital();
				JSONObject singleHospital = array.getJSONObject(i);
				hospital.setIcon(singleHospital.getString("icon"));
				hospital.setName(singleHospital.getString("name"));
				hospital.setAddress(singleHospital.getString("vicinity"));
				JSONObject geometry = singleHospital.getJSONObject("geometry");
				JSONObject location = geometry.getJSONObject("location");
				hospital.setLatitude(location.getString("lat"));
				hospital.setLongitude(location.getString("lng"));
				Log.i(Constants.TAG, "Hospital Name:" + json);
				Log.i(Constants.TAG, "Hospital Name:" + hospital.getName());
				Log.i(Constants.TAG, "Address:" + hospital.getAddress());
				Log.i(Constants.TAG, "Lat: " + hospital.getLatitude()
						+ " Long: " + hospital.getLongitude());
				hospitals.add(hospital);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e(Constants.TAG, "JSONException", e);
		}

		List<String> names = new ArrayList<String>();
		for (int x = 0; x < hospitals.size(); x++)
			names.add(hospitals.get(x).getName());

		adapter = new ArrayAdapter<String>(MapActivity.this,
				android.R.layout.simple_list_item_1, names)
				{ @Override
			        public View getView(int position, View convertView,
			                ViewGroup parent) {
			            View view =super.getView(position, convertView, parent);

			            TextView textView=(TextView) view.findViewById(android.R.id.text1);

			            /*YOUR CHOICE OF COLOR*/
			            textView.setTextColor(Color.WHITE);

			            return view;
			        }
			    };
			  
		_hospitalList.setAdapter(adapter);
		_waiting.setVisibility(View.GONE);
		adapter.notifyDataSetChanged();

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if (pref.getLatitude().equals("0") && pref.getLongitude().equals("0")) {
			generateRequest(Double.toString(location.getLatitude()),
					Double.toString(location.getLongitude()));
			// generateRequest(Constants.currenyLat, Constants.currenyLong);
		}
		pref.setLatitude(Double.toString(location.getLatitude()));
		pref.setLongitude(Double.toString(location.getLongitude()));

		Log.i(Constants.TAG,
				"Location Changed : Lat:" + location.getLatitude() + " Long:"
						+ location.getLongitude() + "Constants: "
						+ pref.getLatitude() + "," + pref.getLongitude());
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
