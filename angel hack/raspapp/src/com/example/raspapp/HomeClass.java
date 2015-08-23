package com.example.raspapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class HomeClass extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("reached home class");
		setContentView(R.layout.homepage);
		Button startTravel=(Button)findViewById(R.id.bstarttravel);
		//Button logout=(Button)findViewById(R.id.blogout);
		startTravel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			       
				Intent i=new Intent("android.intent.action.JSONCLASS");
				startActivity(i);
				
				
			}
		});
		
		
	}

	
	
	
}
