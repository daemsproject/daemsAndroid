package net.fai.daems;

import java.nio.charset.Charset;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import net.fai.daems.constant.ViewId;
import net.fai.daems.fragment.ChatFragment;
import net.fai.daems.fragment.ContactFragment;
import net.fai.daems.fragment.MeFragment;
import net.fai.daems.message.ChatMessage;
import net.fai.daems.message.DaemsMessage;
import net.fai.daems.utils.HexUtils;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends MessageListenActivity implements
		RadioGroup.OnCheckedChangeListener {
	
	private ChatFragment chatFragment;
	private ContactFragment contactFragment;
	private MeFragment myFragment;

	@ViewId(R.id.rd_group)
	RadioGroup rpTab;
	@ViewId(R.id.rd_menu_chat)
	RadioButton rbChat;
	@ViewId(R.id.txt_topbar)
	TextView tvTopbar;
	@ViewId(R.id.btn_topbar)
	ImageButton btnTopbar;
	
	@Override
	public int getContentView() {
		return R.layout.activity_main;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		rpTab.setOnCheckedChangeListener(this);
		rbChat.setChecked(true);
        if (!BoundaryReceiver.isRunning) {
        	startService(new Intent(MainActivity.this, BoundaryReceiver.class));
        }
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	public void hideAllFragment(FragmentTransaction transaction) {
		if (chatFragment != null) {
			transaction.hide(chatFragment);
		}
		if (contactFragment != null) {
			transaction.hide(contactFragment);
		}
		if (myFragment != null) {
			transaction.hide(myFragment);
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		hideAllFragment(transaction);
		switch (checkedId) {
		case R.id.rd_menu_chat:
			tvTopbar.setText(R.string.chat);
			btnTopbar.setVisibility(View.INVISIBLE);
			if (chatFragment == null) {
				chatFragment = new ChatFragment(MainActivity.this);
				transaction.add(R.id.fragment_container, chatFragment);
			} else {
				transaction.show(chatFragment);
			}
			break;
		case R.id.rd_menu_contact:
			tvTopbar.setText(R.string.contact);
			btnTopbar.setVisibility(View.VISIBLE);
			btnTopbar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity.this,
							ContactAddActivity.class);
					startActivity(intent);
				}
			});
			if (contactFragment == null) {
				contactFragment = new ContactFragment(MainActivity.this);
				transaction.add(R.id.fragment_container, contactFragment);
			} else {
				transaction.show(contactFragment);
			}
			break;
		case R.id.rd_menu_me:
			tvTopbar.setText(R.string.me);
			btnTopbar.setVisibility(View.INVISIBLE);
			if (myFragment == null) {
				myFragment = new MeFragment(MainActivity.this);
				transaction.add(R.id.fragment_container, myFragment);
			} else {
				transaction.show(myFragment);
			}
			break;
		}
		transaction.commit();
	}
	
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onMessage(ChatMessage message) {
		tvTopbar.setText(new String(HexUtils.hexStringToBytes(message.getData()), Charset.forName("UTF-8")));
	}
	
	/** NDK Demo Below **/
	
	public native String NDKTestFromJNI();
	
	static {
		System.loadLibrary("daems");
	}
	
	public void callback(String msg)  
    {  
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
