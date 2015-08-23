package com.example.raspapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		if (ParseUser.getCurrentUser() != null) {
			Intent i = new Intent("android.intent.action.MAINCLASS");
			startActivity(i);
		}
		final EditText name = (EditText) findViewById(R.id.uname);
		final EditText contact = (EditText) findViewById(R.id.ucontact);
		final EditText emercot1 = (EditText) findViewById(R.id.uemergennum1);
		final EditText emercot2 = (EditText) findViewById(R.id.uemergennum2);
		final EditText emercot3 = (EditText) findViewById(R.id.uemergennum3);
		final EditText vehicleno = (EditText) findViewById(R.id.uvehiclenum);

		final EditText address = (EditText) findViewById(R.id.uaddress);
		final EditText rasberripiid = (EditText) findViewById(R.id.uraspid);
		// final EditText cnfrmpassword = (EditText)
		// findViewById(R.id.ucnfrmpassword);

		Button register = (Button) findViewById(R.id.regbutton);

		register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				System.out.println("button clicked");
				setContentView(R.layout.register);
				String uname = name.getText().toString();
				String ucontact = contact.getText().toString();
				String uemercot1 = emercot1.getText().toString();
				String uemercot2 = emercot2.getText().toString();
				String uemercot3 = emercot3.getText().toString();

				String uvehicleno = vehicleno.getText().toString();

				String uaddress = address.getText().toString();
				String uraspid = rasberripiid.getText().toString();
				// final String ucnfrmpassword =
				// cnfrmpassword.getText().toString();
				//System.out.println("the password is " + password);

				ParseUser pu = new ParseUser();
				pu.setUsername(uname);
				pu.setPassword("password");
				pu.put("raspid", uraspid);
				pu.put("Contact", ucontact);
				pu.put("Emer_contact1", uemercot1);
				pu.put("Emer_contact2", uemercot2);
				pu.put("Emer_contact3", uemercot3);
				pu.put("Address", uaddress);
				pu.put("vehicleno", uvehicleno);
				//pu.put("raspid",uraspid);
				ParseObject po = new ParseObject("userdetails1");
				po.put("Name", uname);
				po.put("Contact", ucontact);
				po.put("Emer_contact1", uemercot1);
				po.put("Emer_contact2", uemercot2);
				po.put("Emer_contact3", uemercot3);
				po.put("Address", uaddress);
				po.put("vehicleno", uvehicleno);
				po.put("raspid",uraspid);

				final ProgressDialog dia = ProgressDialog.show(Register.this,
						null, "Loading Please wait...");

				po.saveEventually(new SaveCallback() {

					@Override
					public void done(ParseException exception) {
						// TODO Auto-generated method stub

						if (exception != null) {
							Toast.makeText(getApplicationContext(),
									"Operation Failed", Toast.LENGTH_LONG);
							dia.dismiss();
						}

						if (exception == null) {

						}

					}
				});
				pu.signUpInBackground(new SignUpCallback() {

					@Override
					public void done(ParseException exception) {
						// TODO Auto-generated method stub

						if (exception != null) {
							Toast.makeText(getApplicationContext(),
									"Operation Failed", Toast.LENGTH_LONG);
						}

						if (exception == null) {

							dia.dismiss();

							Intent i = new Intent("android.intent.action.HOMECLASS");
							startActivity(i);

							System.out.println("This worked");
						}
					}
				});

				// po.put("Name", )

			}
		});

	}
}
