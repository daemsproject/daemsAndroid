package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AccountAdpater extends BaseAdapter {

	private static final String TAG = AccountAdpater.class.getSimpleName();
	private List<Account> data;
	private Context context;
	private LayoutInflater mInflater;

	public AccountAdpater(Context context, List<Account> data) {
		this.context = context;
		this.data = data;
		mInflater = LayoutInflater.from(context);
	}
	
	public void appendAccount(Account account) {
		data.add(account);
		this.notifyDataSetChanged();
	}

	// 获取ListView的项个数
	public int getCount() {
		return data.size();
	}

	// 获取项
	public Object getItem(int position) {
		return data.get(position);
	}

	// 获取项的ID
	public long getItemId(int position) {
		return position;
	}

	// 获取View
	public View getView(int position, View view, ViewGroup parent) {
		Account entity = data.get(position);
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = mInflater.inflate(R.layout.account_item, parent, false);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.date = (TextView) view.findViewById(R.id.tvDate);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.name.setText(entity.getAbbr());
		viewHolder.date.setText(entity.getDate());

		return view;
	}

	static class ViewHolder {
		public TextView name;
		public TextView date;
	}

}