package net.fai.daems;

import org.greenrobot.eventbus.EventBus;

import net.fai.daems.constant.Daems;
import net.fai.daems.message.ChatMessage;
import net.fai.daems.message.DaemsMessage;
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
		//TODO parse msg to Daems message
		DaemsMessage message = new DaemsMessage();
		ChatMessage cm = new ChatMessage();
		cm.setData("你好EventBus," + msg);
		message.setPayload(cm);
		EventBus.getDefault().post(message);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	private int count = 0;

	@Override
	public void onCreate() {
		super.onCreate();
		isRunning = true;
		register();
		
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
