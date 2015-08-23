package com.amrita.help2emergency.models;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference {

	SharedPreferences preferences;
	SharedPreferences.Editor editor;

	String LAT_KEY = "lat_key";
	String LON_KEY = "lon_key";

	String defaultLatitiude = "0";
	String defaultLongitude = "0";

	public MyPreference(Context context) {
		preferences = context.getSharedPreferences("location",
				Context.MODE_PRIVATE);

	}

	public void setLatitude(String latitude) {
		editor = preferences.edit();
		editor.putString(LAT_KEY, latitude);
		editor.commit();
	}

	public String getLatitude() {
		return preferences.getString(LAT_KEY, defaultLatitiude);
	}

	public void setLongitude(String longitude) {
		editor = preferences.edit();
		editor.putString(LON_KEY, longitude);
		editor.commit();
	}

	public String getLongitude() {
		return preferences.getString(LON_KEY, defaultLatitiude);
	}
}
