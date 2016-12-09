package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

import net.fai.daems.adapter.ChatMsgViewAdpater;
import net.fai.daems.adapter.item.ChatMsg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class ChatActivity extends Activity implements OnClickListener, OnTouchListener, OnItemClickListener, OnFocusChangeListener {
	
	@Bind(R.id.tvName) TextView tvName;
	@Bind(R.id.btn_send) Button btnSend;
	@Bind(R.id.ibtn_back) ImageButton iBtnBack;
	@Bind(R.id.etInput) EditText etInput;
	@Bind(R.id.lvChatRecord) ListView lvChatRecord;
	private InputMethodManager mInputMethodManager;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		ButterKnife.bind(this);
		mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		tvName.setText(name);
		btnSend.setOnClickListener(this);
		lvChatRecord.setOnItemClickListener(this);
		lvChatRecord.setOnFocusChangeListener(this);
		lvChatRecord.setOnTouchListener(this);
		lvChatRecord.setAdapter(new ChatMsgViewAdpater(ChatActivity.this, new ArrayList<ChatMsg>()));
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
}
