package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.fai.daems.adapter.ChatMsgViewAdpater;
import net.fai.daems.adapter.item.ChatMsg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Activity implements OnClickListener, OnItemClickListener, OnFocusChangeListener {
	
	private TextView tvName;
	private Button btnSend;
	private ImageButton iBtnBack;
	private EditText etInput;
	private InputMethodManager mInputMethodManager;
	private ListView lvChatRecord;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		tvName = (TextView) findViewById(R.id.tvName);
		tvName.setText(name);
		btnSend = (Button) findViewById(R.id.btn_send);
		btnSend.setOnClickListener(this);
		etInput = (EditText) findViewById(R.id.etInput);
		lvChatRecord = (ListView) findViewById(R.id.lvChatRecord);
		lvChatRecord.setOnItemClickListener(this);
		lvChatRecord.setOnFocusChangeListener(this);
		lvChatRecord.setAdapter(new ChatMsgViewAdpater(ChatActivity.this, new ArrayList<ChatMsg>()));
		iBtnBack = (ImageButton) findViewById(R.id.ibtn_back);
		iBtnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_send:
			mInputMethodManager.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
			etInput.clearFocus();
			sendMessage(etInput.getText().toString());
			etInput.setText("");
			break;
		case R.id.ibtn_back:
			this.finish();
			break;
			default:
		}
	}
	
	private void sendMessage(String text) {
		ChatMsg msg1 = new ChatMsg();
		msg1.setName("我");
		msg1.setDate(sdf.format(new Date()));
		msg1.setMsgType(false);
		msg1.setText(text);
		((ChatMsgViewAdpater)lvChatRecord.getAdapter()).appendMsg(msg1);
		
		ChatMsg msg2 = new ChatMsg();
		msg2.setName(name);
		msg2.setDate(sdf.format(new Date()));
		msg2.setMsgType(true);
		msg2.setText("哈哈");
		((ChatMsgViewAdpater)lvChatRecord.getAdapter()).appendMsg(msg2);
		
		lvChatRecord.setSelection(lvChatRecord.getCount() - 1);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		mInputMethodManager.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
		etInput.clearFocus();
	}

	@Override
	public void onFocusChange(View arg0, boolean arg1) {
		if (arg1) {
			mInputMethodManager.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
			etInput.clearFocus();
		}
	}
}
