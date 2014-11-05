package com.example.aulabr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ConnReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		NetworkInfo info = (NetworkInfo)intent.getExtras()
				.get(ConnectivityManager.EXTRA_NETWORK_INFO);
		
		Log.i("teste", "" + info.isConnected());
	}

}
