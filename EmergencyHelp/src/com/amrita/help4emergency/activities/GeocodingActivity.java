package com.amrita.help4emergency.activities;

import java.util.List;

import com.amrita.help4emergency.R;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GeocodingActivity extends Activity {
    Button addressButton;
    TextView addressTV;
    TextView latLongTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocoding);


        addressTV = (TextView) findViewById(R.id.addressTV);
        latLongTV = (TextView) findViewById(R.id.latLongTV);

        addressButton = (Button) findViewById(R.id.addressButton);
        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                EditText editText = (EditText) findViewById(R.id.addressET);
                String address = editText.getText().toString();

                GeocodingLocation locationAddress = new GeocodingLocation();
                locationAddress.getAddressFromLocation(address,
                        getApplicationContext(), new GeocoderHandler());
                
            }
        });
        
        Button navButton = (Button) findViewById(R.id.buttonnav);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            	  Intent in = new Intent(GeocodingActivity.this,MapMainActivity.class);
            	GeocodingLocation gl=new GeocodingLocation();
            	
            	  System.out.println("^^^^^^^^^^^^>>>>>>>>>>>>>>"+GeocodingLocation.getlat()+GeocodingLocation.getlong());
                  startActivity(in);
               
               /* List<Address> foundGeocode = null;
                 find the addresses  by using getFromLocationName() method with the given address
                foundGeocode = new Geocoder(this).getFromLocationName("address here", 1);
                foundGeocode.get(0).getLatitude(); //getting latitude
                foundGeocode.get(0).getLongitude();*/
            }
        });

    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
           // latLongTV.setText(locationAddress);
            System.out.println("kkkkkkkkkkkkkkkkk"+locationAddress);
        }
    }
}