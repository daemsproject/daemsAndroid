package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.ChatItem;
import net.fai.daems.utils.FontHelper;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatAdapter extends DaemsAdapter<ChatItem> {
	
	public ChatAdapter(Context context, List<ChatItem> items) {
		super(context);
		this.setItems(items);
	}
	
	public class ViewHolder {
		public ImageView image;
		public TextView name;
		public TextView date;
		public TextView info;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.chat_item, parent, false);
			FontHelper.applyFont(view);
			viewHolder.image = (ImageView) view.findViewById(R.id.ivAvatar);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.date = (TextView) view.findViewById(R.id.tvDate);
			viewHolder.info = (TextView) view.findViewById(R.id.tvInfo);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		ChatItem item = this.getItem(position);
		viewHolder.image.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		viewHolder.info.setText(item.info);
		viewHolder.date.setText(item.date);
		return view;
	}

}
