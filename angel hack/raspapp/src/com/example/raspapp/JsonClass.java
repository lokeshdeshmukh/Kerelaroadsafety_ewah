package com.example.raspapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class JsonClass extends Activity{

	String urlUltraSound;
	RequestQueue mRequestQueue;
	String parsedData;
	Handler mHandler = new Handler();

	 private TextToSpeech myTTS;
     //status check code
     private int MY_DATA_CHECK_CODE = 0;
     
     public static EditText listner1;
     public void listner()
     {
    	 listner1=new EditText(this);
    	 listner1.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), listner1.getText(), Toast.LENGTH_SHORT).show();
			String[] data=listner1.getText().toString().split(",");
			
			TextView h=(TextView)findViewById(R.id.textView2);
			TextView h1=(TextView)findViewById(R.id.textView4);
			TextView h2=(TextView)findViewById(R.id.textView6);
			TextView h3=(TextView)findViewById(R.id.textView8);
			TextView h4=(TextView)findViewById(R.id.textView10);
			TextView h5=(TextView)findViewById(R.id.textView12);

			h.setText(data[0]);
			h1.setText(data[1]);
			h2.setText(data[2]);
			h3.setText(data[3]);
			h4.setText(data[4]);
			h5.setText(data[5]);
			
			
			
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
listner();
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		System.out.println("Reached JsonClass");
new getdatetimeday(this).execute("76.87985","8.55761","112233");
		RequestQueue mRequestQueue;

		// Instantiate the cache
		Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

		// Set up the network to use HttpURLConnection as the HTTP client.
		BasicNetwork network = new BasicNetwork(new HurlStack());

		// Instantiate the RequestQueue with the cache and network.
		mRequestQueue = new RequestQueue(cache, network);
		
		// Start the queue
		mRequestQueue.start();
		new Thread(new Runnable() {
	        @Override
	        public void run() {
	            // TODO Auto-generated method stub
	            while (true) {
	                try {
	                    Thread.sleep(10000);
	                    mHandler.post(new Runnable() {

	                        @Override
	                        public void run() {
	                            // TODO Auto-generated method stub
	                            // Write your code here to update the UI.
	                        	
	                        	MyTask task = new MyTask();
	                    		task.execute();
	                        }
	                    });
	                } catch (Exception e) {
	                    // TODO: handle exception
	                }
	            }
	        }
	    }).start();
		

	}

	public String parse(String jsonLine) throws JSONException {

		System.out.println("the parsed data is" + parsedData);
		JSONArray myListsAll = new JSONArray(parsedData);
		for (int i = 0; i < myListsAll.length(); i++) {
			JSONObject jsonobject = (JSONObject) myListsAll.get(i);
			String id = jsonobject.optString("level");
			String value1 = jsonobject.optString("long");
			String value2 = jsonobject.optString("lat");
			System.out.println("nid=" + id);
			System.out.println("value1=" + value1);
			System.out.println("value2=" + value2);
		}

		return "hii";
	}

	public String read() {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		String id=ParseUser.getCurrentUser().getString("raspid");
		urlUltraSound = "http://cchat.in/hack/getultrasound.php?id="+id;
		HttpGet httpGet = new HttpGet(urlUltraSound);

		try {
			HttpResponse response = client.execute(httpGet);
			System.out.println("the response 1 is" + response.toString());

			parsedData = response.toString();
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
				System.out.println("the line is" + line);
			} else {
				// Log.e(ParseJSON.class.toString(), "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			System.out.println(e);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return builder.toString();
		
		
		
	}
	

	
	
	
	private class MyTask extends AsyncTask<Void, Void, Void> {

		private Exception exception;

		
		protected void onPostExecute(Void feed) {
             
			// receiveUltraSound();
			try {
				parse(parsedData);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			System.out.println("the response 2 is" + read());
			String[] data = read().split(",");

			
			for (int y = 0; y < data.length; y++) {
				System.out.println(data[y]);

				if (y == 0) {
					try
					{

						

					if (Integer.parseInt(data[0].trim()) < 100) {
						System.out.println("Collision");
						final MediaPlayer mp = new MediaPlayer();
						 if(mp.isPlaying())
					        {  
					            mp.stop();
					        } 

					        try {
					            mp.reset();
					            AssetFileDescriptor afd;
					            afd = getAssets().openFd("accident.mp3");
					            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
					            mp.prepare();
					            mp.start();
					        } catch (IllegalStateException e) {
					            e.printStackTrace();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
					        
					        try
					        {
					        	
					        	double i=8.5656;
					        	double j=76.8747;
					        	// Create a Uri from an intent string. Use the result to create an Intent.
					        	Uri gmmIntentUri = Uri.parse("geo:<data[1]>,<data[2]>?z=17");

					        	// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
					        	Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
					        	// Make the Intent explicit by setting the Google Maps package
					        	mapIntent.setPackage("com.google.android.apps.maps");

					        	// Attempt to start an activity that can handle the Intent
					        	startActivity(mapIntent);
					        }
					        catch(Exception e)
					        {
					        	
					        }
					        
						String realraspid = ParseUser.getCurrentUser()
								.getString("raspid");
						String emregrn1 = "c"+ParseUser.getCurrentUser().getString(
								"Emer_contact1");
						String emregrn2 = "c"+ParseUser.getCurrentUser().getString(
								"Emer_contact2");
						String emregrn3 = "c"+ParseUser.getCurrentUser().getString(
								"Emer_contact3");
						String contact = "c"+ParseUser.getCurrentUser().getString(
								"Contact");

						
						ParseInstallation installation = ParseInstallation
								.getCurrentInstallation();
						System.out.println("The contact is"+contact);
						System.out.println("The emergency contact is"+emregrn1);
						String x = "accident";
						installation.add("channels", contact);
						System.out.println("2");
						// String username =
						// ParseUser.getCurrentUser().getString("L_G");
						installation.saveInBackground();
						ParsePush parsePush = new ParsePush();
						ParseQuery pQuery = ParseInstallation.getQuery();
						pQuery.whereEqualTo("channels", emregrn1);
						//speakWords("Accident happened nearby");
						parsePush.sendMessageInBackground(
								"This user had an accident  "
										+ ParseUser.getCurrentUser().getString("username"), pQuery);
						
						pQuery.whereEqualTo("channels", emregrn2);
						parsePush.sendMessageInBackground(
								"This user had an accident  "
										+ ParseUser.getCurrentUser().getString("username"), pQuery);
						
						pQuery.whereEqualTo("channels", emregrn3);
						parsePush.sendMessageInBackground(
								"This user had an accident  "
										+ ParseUser.getCurrentUser().getString("username"), pQuery);

						// ParseQuery.getQuery("userdetails1").whereEqualTo("Contact",
						// ParseUser.getCurrentUser()).

						// ParsePush push=

					}
					}
					catch(Exception e)
					{
					return null;	
					}
				}
			}
			

			// parsedData=readBugzilla();
			return null;
		}
	}
	
	private class MyTask1 extends AsyncTask<Void, Void, Void> {

		private Exception exception;

		ProgressDialog dia = ProgressDialog.show(JsonClass.this, null,
				"Loading Please wait...");

		protected void onPostExecute(Void feed) {
             dia.dismiss();
			// receiveUltraSound();
			try {
				parse(parsedData);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			String id=ParseUser.getCurrentUser().getString("raspid");
			String url="cchat.in/hack/info.php?id=raspid";
			System.out.println("the response 2 is" + read());
			String[] data = read().split(",");

			for (int y = 0; y < data.length; y++) {
				System.out.println(data[y]);

				if (y == 1) {
					
					
					MyTask task = new MyTask();
            		task.execute();

					
				}
				if(y==1)
				{
					
				}
			}
			
			// parsedData=readBugzilla();
			return null;
		}
	}
	
	
	
	
}
