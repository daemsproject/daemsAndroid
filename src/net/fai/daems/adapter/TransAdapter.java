package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.TransItem;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TransAdapter extends DaemsAdapter<TransItem> {
	
	public TransAdapter(Context context, List<TransItem> items) {
		super(context);
		this.setItems(items);
	}
	
	public class ViewHolder {
		public ImageView image;
		public TextView name;
		public TextView date;
		public Button info;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ViewHolder viewHolder;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = this.getInflater().inflate(R.layout.trans_item, parent, false);
			viewHolder.image = (ImageView) view.findViewById(R.id.ivAvatar);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			viewHolder.date = (TextView) view.findViewById(R.id.tvDate);
			viewHolder.info = (Button) view.findViewById(R.id.btnInfo);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		TransItem item = this.getItem(position);
		viewHolder.image.setImageResource(item.imageId);
		viewHolder.name.setText(item.name.substring(0, 3) + "...");
		viewHolder.date.setText(item.date);
		Drawable transIcon;
		String amount;
		if (item.income) {
		    transIcon = getResources().getDrawable(R.drawable.ic_launcher);
		    viewHolder.info.setTextColor(getResources().getColor(R.color.green));
		    amount = "+" + item.amount;
		} else {
			transIcon = getResources().getDrawable(R.drawable.campus_info);
			viewHolder.info.setTextColor(getResources().getColor(R.color.red));
			amount = "-" + item.amount;
		}
		transIcon.setBounds(0, 0, transIcon.getMinimumWidth(), transIcon.getMinimumHeight());  
	    viewHolder.info.setCompoundDrawables(transIcon, null, null, null);  
		viewHolder.info.setText(amount);
		return view;
	}

}
