package net.fai.daems.app;

import net.fai.daems.utils.FontHelper;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class DaemsApplication extends Application {
	private static DaemsApplication mApplication;
	public static int version;

	public synchronized static DaemsApplication getInstance() {
		return mApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
		// TODO query version
		version = 1001;
		FontHelper.initCustomTypeface(this, "fonts/AdobeHeitiStd-Regular.otf");
	}
	
	public NotificationManager getNotificationManager() {
		return (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); 
	}
	
	public ClipboardManager getClipboardManager() {
		return (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
	}
	
	public void copy(CharSequence text) {
		ClipboardManager cm = getClipboardManager();
		cm.setPrimaryClip(ClipData.newPlainText("text", text));
	}
}
