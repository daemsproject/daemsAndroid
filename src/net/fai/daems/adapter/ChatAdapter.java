package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.ChatItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatAdapter extends BaseAdapter {
	
	private List<ChatItem> data;
	private LayoutInflater inflater;
	
	public ChatAdapter(Context context, List<ChatItem> data) {
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
			view = inflater.inflate(R.layout.chat_item, viewGroup, false);
			viewHolder.image = (ImageView) view.findViewById(R.id.ivAvatar);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.date = (TextView) view.findViewById(R.id.tvDate);
			viewHolder.info = (TextView) view.findViewById(R.id.tvInfo);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		ChatItem item = data.get(pos);
		viewHolder.image.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		viewHolder.info.setText(item.info);
		viewHolder.date.setText(item.date);
		return view;
	}
	
	public class ViewHolder {
		public ImageView image;
		public TextView name;
		public TextView date;
		public TextView info;
	}

}
