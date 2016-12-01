package net.fai.daems;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements
		RadioGroup.OnCheckedChangeListener {

	private RadioGroup rpTab;
	private RadioButton rbChat, rbContact, rbDynamic, rbMe;
	private ChatFragment chatFragment;
	private ContactFragment contactFragment;
	private MyFragment fg3, fg4;
	private TextView tvTopbar;
	private ImageButton btnTopbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bindView();
	}

	private void bindView() {
		tvTopbar = (TextView) findViewById(R.id.txt_topbar);
		btnTopbar = (ImageButton) findViewById(R.id.btn_topbar);
		rpTab = (RadioGroup) findViewById(R.id.rd_group);
		rpTab.setOnCheckedChangeListener(this);

		rbChat = (RadioButton) findViewById(R.id.rd_menu_chat);
		rbContact = (RadioButton) findViewById(R.id.rd_menu_contact);
		rbMe = (RadioButton) findViewById(R.id.rd_menu_me);

		rbChat.setChecked(true);
	}
	
	public void hideAllFragment(FragmentTransaction transaction) {
		if (chatFragment != null) {
			transaction.hide(chatFragment);
		}
		if (contactFragment != null) {
			transaction.hide(contactFragment);
		}
		if (fg3 != null) {
			transaction.hide(fg3);
		}
		if (fg4 != null) {
			transaction.hide(fg4);
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
			btnTopbar.setVisibility(View.VISIBLE);
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
			if (fg4 == null) {
				fg4 = new MyFragment("Œ“");
				transaction.add(R.id.fragment_container, fg4);
			} else {
				transaction.show(fg4);
			}
			break;
		}
		transaction.commit();
	}
}
