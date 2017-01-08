package net.fai.daems;

import net.fai.daems.constant.Daems;
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
		intent.setAction(Daems.Action.MESSAGE_IN);
		intent.putExtra("count", ++count);
		intent.putExtra("msg", msg);
		sendBroadcast(intent);
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				while (true) {
//					Intent intent = new Intent();
//					intent.setAction(Actions.MESSAGE_IN);
//					intent.putExtra("count", ++count);
//					intent.putExtra("msg", "定時任務發送的消息:" + count);
//					sendBroadcast(intent);
//					try {
//						Thread.sleep(10000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		};
//		thread.start();
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
		intent.setAction(Daems.Action.SERVICE_DESTROY);
		sendBroadcast(intent);
	}

}
