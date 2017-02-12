package net.fai.daems;

import java.nio.charset.Charset;

import net.fai.daems.constant.Daems;
import net.fai.daems.message.DaemsMessage;
import net.fai.daems.message.DaemsMessageParser;
import net.fai.daems.utils.HexUtils;

import org.greenrobot.eventbus.EventBus;

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
		StringBuffer test = new StringBuffer();
		test.append("{");
		test.append("\"header\": {");
		test.append("\"SendingTime\": 1486887952,");
		test.append(" \"CommandId\": 1,");
		test.append(" \"AppId\": 1,");
		test.append("\"MessageId\": 1,");
		test.append("\"Version\": 1001");
		test.append("},");
		test.append("\"EventId\": 100861,");
		test.append("\"Sender\": \"1DQe9F3agsDcr4qoTZ3Sush4e88Nv9tNxa\",");
		test.append("\"Recipient\": \"5DQe9F3agsDcr4qoTZ3Sush4e88Nv9tNxa\",");
		test.append("\"ContentType\": 1,");
		test.append("\"PackageSeq\": 1,");
		test.append("\"TotalPackage\": 1,");
		test.append("\"data\": \"" + HexUtils.bytesToHexString("你好, Daems".getBytes(Charset.forName("UTF-8"))) + "\"");
		test.append("}");
		
		DaemsMessage message = DaemsMessageParser.parse(test.toString());
		EventBus.getDefault().post(message);
//		//TODO parse msg to Daems message
//		DaemsMessage message = new DaemsMessage();
//		ChatMessage cm = new ChatMessage();
//		cm.setData("你好EventBus," + msg);
//		message.setPayload(cm);
//		EventBus.getDefault().post(message);
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
