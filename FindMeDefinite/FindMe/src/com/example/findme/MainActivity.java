package com.example.findme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText pswrd;
	EditText pswrdcon;
	EditText email;
	Button finalizar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email= (EditText) findViewById(R.id.eTEmail);
        pswrd= (EditText) findViewById(R.id.eTPswrd);
        pswrdcon= (EditText) findViewById(R.id.eTPswrdC);
        finalizar = (Button) findViewById(R.id.btnfin);
        
        finalizar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String correo = email.getText().toString();
	        	String pass = pswrd.getText().toString();
	        	String ConfPass = pswrdcon.getText().toString();
	        	
          		if(correo.equals("")){ 
					CuadroDialog("Falta Ingresar El Correo").show();
				}else if(pass.equals("") || ConfPass.equals("")){
					CuadroDialog("Falta Ingresar La Contraseña").show();
				}else if(!pass.equals(ConfPass)){
					CuadroDialog("Las Contraseñas Son Distintas..!").show();
					
					//textPass.setText(" ");
					//textConfirmPass.setText(" ");
				}else{
					Intent pantPrinc = new Intent(MainActivity.this,Activity2.class);
					Bundle bundle = new Bundle();
					String[] valoresIngresados = {correo,pass,ConfPass};
					bundle.putStringArray("VALORES", valoresIngresados);
					pantPrinc.putExtras(bundle);
					startActivity(pantPrinc);
				}
			}
        });  
    }
    
    public AlertDialog CuadroDialog (String texto){
    	// 1. Instantiate an AlertDialog.Builder with its constructor
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(texto);
        builder.setTitle("Error");

        // Add the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
                       // User clicked OK button
            }
          });
         // 3. Get the AlertDialog from create()
         AlertDialog dialog = builder.create();
         return dialog;
		// dialog.show();
    }
  
    	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /*
    public void continuar(View v){
    	Intent siguiente=new Intent(MainActivity.this,Activity2.class); 		
    	startActivity(siguiente);
    }
    */
}