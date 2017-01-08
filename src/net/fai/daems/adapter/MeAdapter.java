package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.MeItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class MeAdapter extends DaemsAdapter<MeItem> {
	
	public MeAdapter(Context context, List<MeItem> items) {
		super(context);
		this.setItems(items);
	}
	class ViewHolder {
		public ImageView icon;
		public TextView name;
		public View view;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.me_item, parent, false);
			viewHolder.icon = (ImageView) view.findViewById(R.id.ivIcon);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.view = (View) view.findViewById(R.id.separator);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		MeItem item = this.getItem(position);
		viewHolder.icon.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		LayoutParams lp = viewHolder.view.getLayoutParams();
		lp.height = item.dividerHeight;
		viewHolder.view.setLayoutParams(lp);
		return view;
	}

}
