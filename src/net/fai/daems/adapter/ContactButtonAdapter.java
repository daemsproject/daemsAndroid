package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.ContactButtonItem;
import net.fai.daems.utils.DipPxUtils;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactButtonAdapter extends DaemsAdapter<ContactButtonItem> {
	
	public ContactButtonAdapter(Context context, List<ContactButtonItem> items) {
		super(context);
		this.setItems(items);
	}
	class ViewHolder {
		public ImageView icon;
		public TextView name;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.contact_button_item, parent, false);
			viewHolder.icon = (ImageView) view.findViewById(R.id.ivIcon);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		ContactButtonItem item = this.getItem(position);
		viewHolder.icon.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		return view;
	}

}
