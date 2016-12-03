package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.MeItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MeAdapter extends BaseAdapter {
	
	private List<MeItem> data;
	private LayoutInflater inflater;
	
	public MeAdapter(Context context, List<MeItem> data) {
		this.data = data;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int pos) {
		return data.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View view, ViewGroup viewGroup) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = inflater.inflate(R.layout.me_item, viewGroup, false);
			viewHolder.icon = (ImageView) view.findViewById(R.id.ivIcon);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.view = (View) view.findViewById(R.id.separator);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		MeItem item = data.get(pos);
		viewHolder.icon.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		LayoutParams lp = viewHolder.view.getLayoutParams();
		lp.height = item.dividerHeight;
		viewHolder.view.setLayoutParams(lp);
		return view;
	}
	
	class ViewHolder {
		public ImageView icon;
		public TextView name;
		public View view;
	}

}
