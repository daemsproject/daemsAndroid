package net.fai.daems.fragment;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.AccountActivity;
import net.fai.daems.R;
import net.fai.daems.WalletActivity;
import net.fai.daems.adapter.MeAdapter;
import net.fai.daems.adapter.item.MeItem;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MeFragment extends DaemsFragment implements OnItemClickListener {
	ListView lvMe;

	public MeFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.me_fragment, container, false);
		lvMe = (ListView) view.findViewById(R.id.lvMe);
		lvMe.setAdapter(new MeAdapter(context, getMeItems()));
		lvMe.setOnItemClickListener(this);
		return view;
	}

	private List<MeItem> getMeItems() {
		List<MeItem> items = new ArrayList<MeItem>();
		items.add(new MeItem(R.drawable.me_account, "账号", 13));
		items.add(new MeItem(R.drawable.me_wallet, "钱包", 1));
		items.add(new MeItem(R.drawable.me_network, "网络", 24));
		return items;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if (arg2 == 0) {
			Intent intent = new Intent(context, AccountActivity.class);
			startActivity(intent);
		} else if (arg2 == 1) {
			Intent intent = new Intent(context, WalletActivity.class);
			startActivity(intent);
		}
	}
}
