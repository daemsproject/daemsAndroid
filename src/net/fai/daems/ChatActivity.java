package net.fai.daems;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ChatActivity extends Activity implements OnClickListener, OnItemClickListener, OnFocusChangeListener {
	
	private TextView tvName;
	private Button btnSend;
	private ImageButton iBtnBack;
	private EditText etInput;
	private InputMethodManager mInputMethodManager;
	private ListView lvChatRecord;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		tvName = (TextView) findViewById(R.id.tvName);
		tvName.setText(name);
		btnSend = (Button) findViewById(R.id.btn_send);
		btnSend.setOnClickListener(this);
		etInput = (EditText) findViewById(R.id.etInput);
		lvChatRecord = (ListView) findViewById(R.id.lvChatRecord);
		lvChatRecord.setOnItemClickListener(this);
		lvChatRecord.setOnFocusChangeListener(this);
		iBtnBack = (ImageButton) findViewById(R.id.ibtn_back);
		iBtnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_send:
			mInputMethodManager.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
			etInput.clearFocus();
			etInput.setText("");
			break;
		case R.id.ibtn_back:
			this.finish();
			break;
			default:
		}
	}
	
	private void sendMessage() {
		
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
