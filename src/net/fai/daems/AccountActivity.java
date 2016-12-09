package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.fai.daems.adapter.AccountAdpater;
import net.fai.daems.adapter.item.Account;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountActivity extends Activity {
	
	@Bind(R.id.btnAdd) Button btnAdd;
	@Bind(R.id.ibtn_back) ImageButton btnBack;
	@Bind(R.id.lvAccount) ListView lvAccount;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		ButterKnife.bind(this);
		lvAccount.setAdapter(new AccountAdpater(AccountActivity.this, getAccount()));
	}

	@OnClick({R.id.btnAdd, R.id.ibtn_back})
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
