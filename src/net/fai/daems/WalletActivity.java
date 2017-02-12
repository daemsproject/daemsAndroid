package net.fai.daems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.fai.daems.ActionSheet.OnActionSheetSelected;
import net.fai.daems.adapter.AccountAdpater;
import net.fai.daems.adapter.item.AccountItem;
import net.fai.daems.app.DaemsApplication;
import net.fai.daems.constant.ViewId;
import net.fai.daems.data.DataAccessor;
import net.fai.daems.data.DummyAccessor;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 钱包Activity
 * @author Administrator
 *
 */
public class WalletActivity extends DaemsActivity implements OnActionSheetSelected, OnCancelListener, OnClickListener {
	
	@ViewId(R.id.btnAdd)
	Button btnAdd;
	@ViewId(R.id.btn_back)
	Button btnBack;
	@ViewId(R.id.btnChatCoinAddress)
	Button btnChatCoinAddress;
	@ViewId(R.id.btnFlowCoinAddress)
	Button btnFlowCoinAddress;
	
	DataAccessor accessor = new DummyAccessor();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int copyedPosition = -1;
	private  AccountAdpater adapter;

	@Override
	public int getContentView() {
		return R.layout.activity_wallet;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		adapter = new AccountAdpater(WalletActivity.this, getAccount());
	}
	

	@Override
	public void beforeSetContentView() {
		if (accessor.getUserPassword() == null) {
			final EditText t = new EditText(this);
			t.setHint("密码设置至少为6位");
			new AlertDialog.Builder(this).setTitle("请设置密码")
					.setView(t).setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							String text = t.getText().toString();
							if (!"".equals(text.trim())) {
								accessor.setUserPassword(t.getText().toString());
							} else {
								WalletActivity.this.finish();
							}
						}
					})
					.setNegativeButton("取消", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					})
					.setOnCancelListener(new OnCancelListener() {
						@Override
						public void onCancel(DialogInterface dialog) {
							if (accessor.getUserPassword() == null) {
								WalletActivity.this.finish();
							}
						}
					}).show();
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			this.finish();
			break;
		case R.id.btnChatCoinAddress:
			DaemsApplication.getInstance().copy(btnChatCoinAddress.getText());
			Toast.makeText(this, "聊天币钱包地址已复制", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btnFlowCoinAddress:
			DaemsApplication.getInstance().copy(btnFlowCoinAddress.getText());
			Toast.makeText(this, "流量币钱包地址已复制", Toast.LENGTH_SHORT).show();
			break;
		case R.id.ly_chat_coin:
			Intent intent1 = new Intent(WalletActivity.this,
					ChatCoinDetailActivity.class);
			startActivity(intent1);
		case R.id.ly_flow_coin:
			Toast.makeText(this, "流量详细", Toast.LENGTH_SHORT).show();
//			Intent intent2 = new Intent(WalletActivity.this,
//					ContactAddActivity.class);
//			startActivity(intent2);
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
