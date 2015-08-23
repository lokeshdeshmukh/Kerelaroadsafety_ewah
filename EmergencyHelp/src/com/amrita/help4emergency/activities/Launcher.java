package com.amrita.help4emergency.activities;

import java.util.Timer;
import java.util.TimerTask;

import com.amrita.help4emergency.Navbar;
import com.amrita.help4emergency.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Launcher extends Activity{
	
	protected boolean _active = true;
    protected int _splashTime = 2000; // time to display the splash screen in ms 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher2);
        Thread splashTread = new Thread() {
                @SuppressWarnings("deprecation")
				@Override
                public void run() {
                    try {
                        int waited = 0;
                        while(_active && (waited < _splashTime)) {
                            sleep(100);
                            if(_active) {
                                waited += 100;
                            }
                        }
                    } catch(InterruptedException e) {
                        // do nothing
                    } finally {
                        finish();
                        
                        Intent in = new Intent(Launcher.this,Navbar.class);
                       startActivity(in);
                        //stop();
                    }
                }
            };
            splashTread.start();
    }

	
}