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
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class AccountActivity extends DaemsActivity implements OnActionSheetSelected, OnCancelListener, OnClickListener {
	
	@ViewId(R.id.btnAdd)
	Button btnAdd;
	@ViewId(R.id.ibtn_back)
	Button btnBack;
	@ViewId(R.id.lvAccount)
	ListView lvAccount;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int copyedPosition = -1;
	private  AccountAdpater adapter;
	
	@Override
	public int getContentView() {
		return R.layout.activity_account;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		btnAdd.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		adapter = new AccountAdpater(AccountActivity.this, getAccount());
		lvAccount.setAdapter(adapter);
		lvAccount.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				copyedPosition = position;
				ActionSheet.showSheet(AccountActivity.this, AccountActivity.this, AccountActivity.this);
			}
		});
//		lvAccount.setOnItemLongClickListener(new OnItemLongClickListener() {
//			@Override
//			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//					int position, long arg3) {
//				copyedPosition = position;
//				ActionSheet.showSheet(AccountActivity.this, AccountActivity.this, AccountActivity.this);
//				return true;
//			}
//		});
	}
	
	@Override
	public void onDestroyActivity() {
		
	}

	private List<AccountItem> getAccount() {
		List<AccountItem> accounts = new ArrayList<AccountItem>();
		//AccountItem(int imageId, String name, String info, String date)
		accounts.add(new AccountItem(R.drawable.avatar1, "c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date()), ""));
		accounts.add(new AccountItem(R.drawable.avatar2,"d3b9c726b4430e1d8f09e2b0130996b40ca726ad", sdf.format(new Date()), ""));
		accounts.add(new AccountItem(R.drawable.avatar3,"a9e62497cc516e908d179c5fc6590b92ac67416e", sdf.format(new Date()), ""));
		accounts.add(new AccountItem(R.drawable.avatar4,"51417e732c29917818659a8a7ef67a04cd3401ba", sdf.format(new Date()), ""));
		accounts.add(new AccountItem(R.drawable.avatar5,"48f6f9d86167fd7e7c15b9f3faf3031b7f051312", sdf.format(new Date()), ""));
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
			DaemsApplication.getInstance().copy(adapter.getItem(copyedPosition).name);
			Toast.makeText(AccountActivity.this, "账号已复制", Toast.LENGTH_SHORT).show();
			break;
		case R.id.action_delete:
			adapter.deleteItem(copyedPosition);
			break;
		case R.id.action_cancel:
			break;
		
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAdd:
			((AccountAdpater) lvAccount.getAdapter()).appendItem(new AccountItem(R.drawable.avatar6, "c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date()), ""));
			break;
		case R.id.ibtn_back:
			this.finish();
			break;
			default:
		}
	}
	
}
