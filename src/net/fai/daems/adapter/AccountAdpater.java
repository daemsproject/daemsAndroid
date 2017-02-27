package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.AccountItem;
import net.fai.daems.utils.FontHelper;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountAdpater extends DaemsAdapter<AccountItem>  {

	public AccountAdpater(Context context, List<AccountItem> items) {
		super(context);
		this.setItems(items);
	}
	
	static class ViewHolder {
		public ImageView image;
		public TextView name;
		public TextView date;
		public TextView info;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		AccountItem item = this.getItem(position);
		if (item == null) {
			// TODO 异常处理
			item = new AccountItem(R.drawable.ic_launcher, "error", "", "");
		}
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.account_item, parent, false);
			FontHelper.applyFont(view);
			viewHolder.image = (ImageView) view.findViewById(R.id.ivAvatar);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.date = (TextView) view.findViewById(R.id.tvDate);
			viewHolder.info = (TextView) view.findViewById(R.id.tvInfo);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.image.setImageResource(item.imageId);
		viewHolder.name.setText(item.abbr);
		viewHolder.info.setText(item.info);
		viewHolder.date.setText(item.date);
		return view;
	}

}