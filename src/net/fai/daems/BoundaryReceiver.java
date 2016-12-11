package net.fai.daems;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BoundaryReceiver extends Service {
	
	public static boolean isRunning = false;

	public native void register();

	static {
		System.loadLibrary("daems");
	}

	public void onReceive(String msg) {
		Intent intent = new Intent();
		intent.setAction(Actions.MESSAGE_IN);
		intent.putExtra("count", ++count);
		intent.putExtra("msg", msg);
		sendBroadcast(intent);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	private int count = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		register();
		isRunning = true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		isRunning = false;
		Intent intent = new Intent();
		intent.setAction(Actions.SERVICE_DESTROY);
		sendBroadcast(intent);
	}

}
