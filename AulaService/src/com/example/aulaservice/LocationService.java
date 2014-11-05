package com.example.aulaservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class LocationService extends Service implements LocationListener{

	private LocationManager lManager;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Log.i("teste", "SERVIÇO INICIADO");
		
		lManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this);
		
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Log.i("teste", "SERVIÇO DESTRUIDO");
		lManager.removeUpdates(this);
		lManager = null;
		
		super.onDestroy();
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.i("teste", "Lat:" + location.getLatitude() + 
				" - Lng:" + location.getLongitude() + 
				" - Acc:" + location.getAccuracy());
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
