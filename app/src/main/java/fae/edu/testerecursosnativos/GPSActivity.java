package fae.edu.testerecursosnativos;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import edu.fae.util.Utils;

public class GPSActivity extends ActionBarActivity implements LocationListener {
	private LocationManager locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		
		//Objeto que podemos acessar o servi�o de localiza��o do dispositivo
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		Utils.setTextViewText(this, R.id.textViewGps, "Buscando localiza��o....");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		//Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		long time = 1000; //milisegundos
		float minDistance = 5; //metros
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, time, minDistance, this);
	}
	@Override
	protected void onPause() {
		locationManager.removeUpdates(this);
		super.onPause();
	}

	@Override
	public void onLocationChanged(Location location) {
		String text = "Latitude: "+location.getLatitude() + "\n";
		text+="Longitude: "+location.getLongitude() + "\n";
		text+="Precis�o: "+location.getAccuracy() + " metros";

		Utils.setTextEditText(this, R.id.textViewGps, text);
	}

	@Override
	public void onProviderDisabled(String provider) {
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}



}
