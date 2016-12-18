package net.fai.daems;

import java.util.ArrayList;

import net.fai.daems.app.DaemsApplication;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

public class DaemsMessageReceiver extends BroadcastReceiver {
	
	public static ArrayList<EventHandler> ehList = new ArrayList<EventHandler>();

	public static abstract interface EventHandler {
		public abstract void onMessage(Message message);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (Actions.BOOT_COMPLETED.equals(action)) {
			context.startService(new Intent(context, BoundaryReceiver.class));
		} else if (Actions.SERVICE_DESTROY.equals(action)) {
			context.startService(new Intent(context, BoundaryReceiver.class));
		} else if (Actions.MESSAGE_IN.equals(action)) {
			int count = intent.getIntExtra("count", 0);
			String content = intent.getStringExtra("msg");
			if (ehList.isEmpty()) {
				NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);  
				PendingIntent pendingIntent3 = PendingIntent.getActivity(context, 0, new Intent(DaemsApplication.getInstance(), MainActivity.class), 0);
	            Notification notify3 = new Notification.Builder(DaemsApplication.getInstance())  
	                    .setSmallIcon(R.drawable.campus_info)  
	                    .setTicker(count + ":" + content)  
	                    .setContentTitle("Notification Title")  
	                    .setContentText("This is the notification message")  
	                    .setContentIntent(pendingIntent3).setNumber(1).build();
	            notify3.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。  
	            manager.notify(1, notify3);
			} else {
				for (EventHandler handler : ehList) {
					Message msg = new Message();
					Bundle data = new Bundle();
					data.putString("content", content);
					msg.setData(data);
					handler.onMessage(msg);
				}
			}
		}
	}
}