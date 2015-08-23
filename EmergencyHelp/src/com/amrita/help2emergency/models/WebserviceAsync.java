package com.amrita.help2emergency.models;

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class WebserviceAsync extends AsyncTask<String, String, JSONObject>{

	JSONParser jParser;
	JSONObject json;
	Notifier notifier;
	ProgressDialog progress;
	
	public WebserviceAsync(Context context){
		jParser = new JSONParser();
		notifier = (Notifier) context;
		progress = new ProgressDialog(context);
		progress.setCancelable(false);
		progress.setMessage("Fetching results");
	}
	
	@Override
	protected JSONObject doInBackground(String... params) {
		// TODO Auto-generated method stub
		json = jParser.getJSONFromUrl(params[0]);
		Log.i(Constants.TAG, "RequestURL:" + params[0]);
		
		json = jParser.getJSONFromUrl(params[0]);

			
		return json;
	}

	@Override
	protected void onPostExecute(JSONObject result) {
		// TODO Auto-generated method stub
		progress.dismiss();
		super.onPostExecute(result);
		notifier.onHospitalResults(result);
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		progress.show();
		super.onPreExecute();
	}

	@Override
	protected void onCancelled() {
		// TODO Auto-generated method stub
		progress.dismiss();
		super.onCancelled();
	}
	
	

	
	
}
