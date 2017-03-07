package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.ExpirationItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ExpirationAdapter extends DaemsAdapter<ExpirationItem> {
	
	public ExpirationAdapter(Context context, List<ExpirationItem> items) {
		super(context);
		this.setItems(items);
	}
	
	public class ViewHolder {
		public TextView description;
		public Button amount;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.layout_expiration_item, parent, false);
			viewHolder.description = (TextView) view.findViewById(R.id.tvDescription);
			viewHolder.amount = (Button) view.findViewById(R.id.btnAmount);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		ExpirationItem item = this.getItem(position);
		viewHolder.description.setText(item.description);
		viewHolder.amount.setText(item.amount);
		return view;
	}
}
