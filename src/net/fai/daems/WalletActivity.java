package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.fai.daems.ActionSheet.OnActionSheetSelected;
import net.fai.daems.adapter.AccountAdpater;
import net.fai.daems.adapter.item.AccountItem;
import net.fai.daems.app.DaemsApplication;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 钱包Activity
 * @author Administrator
 *
 */
public class WalletActivity extends Activity implements OnActionSheetSelected, OnCancelListener, OnClickListener {
	
	Button btnAdd;
	Button btnBack;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int copyedPosition = -1;
	private  AccountAdpater adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallet);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnBack = (Button) findViewById(R.id.btn_back);
		btnBack.setOnClickListener(this);
		adapter = new AccountAdpater(WalletActivity.this, getAccount());
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			this.finish();
			break;
			default:
		}
	}
	
	private List<AccountItem> getAccount() {
		List<AccountItem> accounts = new ArrayList<AccountItem>();
		accounts.add(new AccountItem("c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date())));
		accounts.add(new AccountItem("d3b9c726b4430e1d8f09e2b0130996b40ca726ad", sdf.format(new Date())));
		accounts.add(new AccountItem("a9e62497cc516e908d179c5fc6590b92ac67416e", sdf.format(new Date())));
		accounts.add(new AccountItem("51417e732c29917818659a8a7ef67a04cd3401ba", sdf.format(new Date())));
		accounts.add(new AccountItem("48f6f9d86167fd7e7c15b9f3faf3031b7f051312", sdf.format(new Date())));
		return accounts;
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(int whichButton) {
		switch (whichButton) {
		case R.id.action_copy:
			DaemsApplication.getInstance().copy(adapter.getItem(copyedPosition).getKey());
			Toast.makeText(WalletActivity.this, "账号已复制", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_delete:
			adapter.deleteItem(copyedPosition);
			break;
		case R.id.action_cancel:
			break;
		
		}
	}
}