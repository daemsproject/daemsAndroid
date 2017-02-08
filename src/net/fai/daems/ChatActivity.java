package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.fai.daems.adapter.ChatMsgViewAdpater;
import net.fai.daems.adapter.item.ChatMsgItem;
import net.fai.daems.constant.ViewId;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends DaemsActivity implements OnClickListener, OnTouchListener, OnItemClickListener, OnFocusChangeListener, DaemsMessageReceiver.EventHandler {
	
	@ViewId(R.id.tvName)
	TextView tvName;
	@ViewId(R.id.btn_send)
	Button btnSend;
	@ViewId(R.id.ibtn_back)
	ImageButton iBtnBack;
	@ViewId(R.id.etInput)
	EditText etInput;
	@ViewId(R.id.lvChatRecord)
	ListView lvChatRecord;
	
	private InputMethodManager mInputMethodManager;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private String name;
	
	@Override
	public int getContentView() {
		return R.layout.chat;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		tvName.setText(name);
		btnSend.setOnClickListener(this);
		lvChatRecord.setOnItemClickListener(this);
		lvChatRecord.setOnFocusChangeListener(this);
		lvChatRecord.setOnTouchListener(this);
		lvChatRecord.setAdapter(new ChatMsgViewAdpater(ChatActivity.this, new ArrayList<ChatMsgItem>()));
		iBtnBack.setOnClickListener(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		DaemsMessageReceiver.ehList.add(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		DaemsMessageReceiver.ehList.remove(this);
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
		ChatMsgItem msg1 = new ChatMsgItem();
		msg1.setName("我");
		msg1.setDate(sdf.format(new Date()));
		msg1.setMsgType(false);
		msg1.setText(text);
		((ChatMsgViewAdpater)lvChatRecord.getAdapter()).appendItem(msg1);
		
		ChatMsgItem msg2 = new ChatMsgItem();
		msg2.setName(name);
		msg2.setDate(sdf.format(new Date()));
		msg2.setMsgType(true);
		msg2.setText("哈哈");
		((ChatMsgViewAdpater)lvChatRecord.getAdapter()).appendItem(msg2);
		
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (v.getId()) {
		case R.id.lvChatRecord:
			mInputMethodManager.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
			break;
		default:
            break;
		}
		return false;
	}

	@Override
	public void onMessage(Message message) {
		this.tvName.setText(message.arg1 + "");
		
	}
}
