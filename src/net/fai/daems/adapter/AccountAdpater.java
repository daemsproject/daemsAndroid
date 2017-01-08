package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.AccountItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AccountAdpater extends DaemsAdapter<AccountItem>  {

	public AccountAdpater(Context context, List<AccountItem> items) {
		super(context);
		this.setItems(items);
	}
	
	static class ViewHolder {
		public TextView name;
		public TextView date;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		AccountItem entity = this.getItem(position);
		if (entity == null) {
			// TODO 异常处理
			entity = new AccountItem("error", "error");
		}
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.account_item, parent, false);
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

}