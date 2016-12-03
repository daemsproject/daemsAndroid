package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.fai.daems.adapter.AccountAdpater;
import net.fai.daems.adapter.ChatMsgViewAdpater;
import net.fai.daems.adapter.item.Account;
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

public class AccountActivity extends Activity implements OnClickListener {
	
	private Button btnAdd;
	private ImageButton btnBack;
	private ListView lvAccount;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);
		btnBack = (ImageButton) findViewById(R.id.ibtn_back);
		btnBack.setOnClickListener(this);
		lvAccount = (ListView) findViewById(R.id.lvAccount);
		lvAccount.setAdapter(new AccountAdpater(AccountActivity.this, getAccount()));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAdd:
			((AccountAdpater) lvAccount.getAdapter()).appendAccount(new Account("c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date())));
			break;
		case R.id.ibtn_back:
			this.finish();
			break;
			default:
		}
	}
	
	private List<Account> getAccount() {
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date())));
		accounts.add(new Account("d3b9c726b4430e1d8f09e2b0130996b40ca726ad", sdf.format(new Date())));
		accounts.add(new Account("a9e62497cc516e908d179c5fc6590b92ac67416e", sdf.format(new Date())));
		accounts.add(new Account("51417e732c29917818659a8a7ef67a04cd3401ba", sdf.format(new Date())));
		accounts.add(new Account("48f6f9d86167fd7e7c15b9f3faf3031b7f051312", sdf.format(new Date())));
		return accounts;
	}
}
