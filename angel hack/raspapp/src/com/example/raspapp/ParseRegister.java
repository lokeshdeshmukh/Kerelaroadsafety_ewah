package com.example.raspapp;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;
import android.text.TextUtils;

public class ParseRegister extends Application{

	public static final String TAG = Controller.class.getSimpleName();
	  
    private RequestQueue mRequestQueue;
  
    private static ParseRegister mInstance;
	
	public void onCreate()
	{
		
		super.onCreate();
		 mInstance = this;
		System.out.println("coming to register class successfully");
		//ParseObject.registerSubclass(ParseRegister.class);
		System.out.println("coming to initialization class successfully");
		Parse.initialize(this, "C0ZvRSbcIIY4Y5MNZdf2GJ9iU05vTuIGFLbCZ6WU",
				"YyHQYLFv0ubXct8DzPSA5o5ZZJNor7Y4gWTpDUWz");
	}
	public static synchronized ParseRegister getInstance() {
        return mInstance;
    }
  
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
  
        return mRequestQueue;
    }
  
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
  
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
  
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
