package com.example.findme;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class Activity2 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
    
    public void onAboutClick(View v){
    	Intent acercade=new Intent(this,ActivityAcercade.class);
    	startActivity(acercade);
    }
    
    public void onConfigurarClick(View v){
    	Intent configura=new Intent(this,ActivityConfigura.class);
    	startActivity(configura);
    }
}