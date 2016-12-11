package net.fai.daems;

import net.fai.daems.BindService.MyBinder;
import net.fai.daems.fragment.ChatFragment;
import net.fai.daems.fragment.ContactFragment;
import net.fai.daems.fragment.MeFragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements
		RadioGroup.OnCheckedChangeListener {
	
	private ChatFragment chatFragment;
	private ContactFragment contactFragment;
	private MeFragment myFragment;

	@Bind(R.id.rd_group) RadioGroup rpTab;
	@Bind(R.id.rd_menu_chat) RadioButton rbChat;
	@Bind(R.id.txt_topbar) TextView tvTopbar;
	@Bind(R.id.btn_topbar) ImageButton btnTopbar;
	
	private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            MyBinder binder = (MyBinder)service;
            BindService bindService = binder.getService();
            bindService.MyMethod();
        }
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		rpTab.setOnCheckedChangeListener(this);
		rbChat.setChecked(true);
		Intent intent = new Intent(MainActivity.this,BindService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
//        if (!BoundaryReceiver.isRunning) {
//        	startService(new Intent(MainActivity.this, BoundaryReceiver.class));
//        }
	}
	
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unbindService(conn);
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
			tvTopbar.setText(NDKTestFromJNI());
//			tvTopbar.setText(R.string.contact);
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
	
	public native String NDKTestFromJNI();
	
	static {
		System.loadLibrary("daems");
	}
	
	public void callback(String msg)  
    {  
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
