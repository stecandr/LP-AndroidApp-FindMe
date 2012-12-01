package com.example.findme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ActivityConfigura extends Activity {
	
	EditText oldpswrd;
	EditText newpswrd;
	EditText newpswrdconf;
	EditText email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityconfigura);
        oldpswrd= (EditText) findViewById(R.id.eTOldPswrd);
        newpswrd= (EditText) findViewById(R.id.eTNewPswrd);
        newpswrdconf= (EditText) findViewById(R.id.eTConfirmNewPswrd);
        email= (EditText) findViewById(R.id.eTEmail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onClickCancelar(View v){
    	finish();    	
    }
    
    public void onSaveClick(View v){
    	if(newpswrd.getText().toString().equals(newpswrdconf.getText().toString())){
    		if(email.getText().toString().contains("@")){
		    	Intent guardar=new Intent(this,Activity2.class);
		    	startActivity(guardar);
		    	finish();
		    }else{
		    	
		    }
	    }else{}
    }
}