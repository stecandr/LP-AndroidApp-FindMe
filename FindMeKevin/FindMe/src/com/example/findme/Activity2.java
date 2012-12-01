package com.example.findme;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.app.Activity;
import android.content.Context;



public class Activity2 extends Activity {

	private ToggleButton botonImg;
	private Button botonConf;
	private Button botonAcerca;
	private TextView lblEstado;
	
	private LocationManager locManager;
	private LocationListener locListener;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        
        botonConf = (Button)findViewById(R.id.botonConf);
    	botonAcerca = (Button)findViewById(R.id.botonAcercaD);
    	lblEstado = (TextView)findViewById(R.id.lblestado);
    	
        
        
        botonImg.setOnClickListener(new OnClickListener() {
        	        	
			public void onClick(View v) {
				if(botonImg.isActivated()){
					comenzarLocalizacion();
				}else{
				
				}
				
			}
		});
       
        
    }
    
    
    private void comenzarLocalizacion()
    {
    	//Obtenemos una referencia al LocationManager
    	locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	
    	//Obtenemos la última posición conocida
    	Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	
    	//Mostramos la última posición conocida     	
    	enviarPosicion(loc);
    	
    	//Nos registramos para recibir actualizaciones de la posición
    	locListener = new LocationListener() {
	    	public void onLocationChanged(Location location) {
	    		enviarPosicion(location);
	    	}
	    	public void onProviderDisabled(String provider){
	    		lblEstado.setText("GPS Desactivado");
	    	}
	    	public void onProviderEnabled(String provider){
	    		lblEstado.setText("GPS Activado");
	    	}
			public void onStatusChanged(String provider, int status,Bundle extras) {
				// TODO Auto-generated method stub
				
			}
	    	
    	};
    	
    	locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 300000, 0, locListener);
    }
    
    private void enviarPosicion(Location loc) {
    	/*if(loc != null)
    	{
    		lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
    		lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
    		lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
    		Log.i("", String.valueOf(loc.getLatitude() + " - " + String.valueOf(loc.getLongitude())));
    	}
    	else
    	{
    		lblLatitud.setText("Latitud: (sin_datos)");
    		lblLongitud.setText("Longitud: (sin_datos)");
    		lblPrecision.setText("Precision: (sin_datos)");
    	}*/
    }
    
}