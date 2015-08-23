package com.example.raspapp;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainClass extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		
		if(ParseUser.getCurrentUser()==null)
		{
			Intent i=new Intent("android.intent.action.REGISTER");
			startActivity(i);
		}
		
		if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser()))
		{
			
			System.out.println("going to register class");
			
			
			
		}
		else
		{
			ParseUser currentUser=ParseUser.getCurrentUser();
			if(currentUser!=null)
			{
				System.out.println("going to home  class");
				Intent i=new Intent("android.intent.action.HOMECLASS");
				startActivity(i);
			}
			//Intent i=new Intent("android.intent.action.REGISTER");
			//startActivity(i);
		}
	}

}
