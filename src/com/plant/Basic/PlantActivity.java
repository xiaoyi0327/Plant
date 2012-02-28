package com.plant.Basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PlantActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Thread logoTimer = new Thread(){
        	public void run(){
        		try{
        			int logoTimer = 0;
        			while(logoTimer < 5000){
        				sleep(10);
        				logoTimer = logoTimer + 100;
        			}
        			startActivity(new Intent("com.plant.Basic.CLEARSCREEN"));
        		}
        		catch(InterruptedException e){
        			e.printStackTrace();
        		}
        		finally{
        			finish();
        		}
        	}
        };
        logoTimer.start();
    }

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
    
    
}