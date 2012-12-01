package com.example.findme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ActivityAcercade extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityacerca);
    }
    
    public void onRegresarClick(View v){
    	finish();
    }
}