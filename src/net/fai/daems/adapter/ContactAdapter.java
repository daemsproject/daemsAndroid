package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.ContactItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends DaemsAdapter<ContactItem> {
	
	public ContactAdapter(Context context, List<ContactItem> items) {
		super(context);
		this.setItems(items);
	}
	
	class ViewHolder {
		public ImageView image;
		public TextView name;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.contact_item, parent, false);
			viewHolder.image = (ImageView) view.findViewById(R.id.ivAvatar);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		ContactItem item = this.getItem(position);
		viewHolder.image.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		return view;
	}
}
