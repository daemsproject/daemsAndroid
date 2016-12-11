package net.fai.daems.app;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;

public class DaemsApplication extends Application {
	private static DaemsApplication mApplication;

	public synchronized static DaemsApplication getInstance() {
		return mApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
	}
	
	public NotificationManager getNotificationManager() {
		return (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); 
	}
}
