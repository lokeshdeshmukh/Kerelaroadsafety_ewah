package com.example.raspapp;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		final EditText username=(EditText)findViewById(R.id.logusername);
		final EditText password=(EditText)findViewById(R.id.logpasswd);
		Button login= (Button)findViewById(R.id.loginbutton);
		Button register=(Button)findViewById(R.id.logregbtn);
		
		final ParseUser pu=new ParseUser();
		Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
		//pu.setUsername(empid.toString());
		//pu.setPassword(password.toString());
		//Intent i=new Intent("android.intent.action.USERLIST");
		//startActivity(i);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String uusername=username.getText().toString();
				String upass=password.getText().toString();
				System.out.print(uusername);
				System.out.println(upass);
				final ProgressDialog dia = ProgressDialog.show(Login.this, null,
						"Loading Please wait...");		
				
				ParseUser.logInInBackground(uusername,upass,new LogInCallback() {
					
					@Override
					public void done(ParseUser arg0, ParseException arg1) {
						// TODO Auto-generated method stub
						if(arg0!=null)
						{
							System.out.print("Login Successful");
							Toast.makeText(getApplicationContext(), "LOgin SUccess",Toast.LENGTH_LONG ).show();
							dia.dismiss();
							Intent i=new Intent("android.intent.action.REGISTER");
							startActivity(i);
							
						}
						else
						{
							System.out.print("Login Unsuccessful");
							Toast.makeText(getApplicationContext(), "LOgin failed",Toast.LENGTH_LONG ).show();
							System.out.println(arg1);
						}
						
						
					}
				});
				
			}
		});
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				startActivity(new Intent(Login.this,Register.class));
				
			}
		});
		
		
		
		
		
		
	}

	
}
