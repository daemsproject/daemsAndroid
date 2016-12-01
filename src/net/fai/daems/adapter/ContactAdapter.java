package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.bean.ContactItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter {
	
	private List<ContactItem> data;
	private LayoutInflater inflater;
	
	public ContactAdapter(Context context, List<ContactItem> data) {
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
			view = inflater.inflate(R.layout.contact_item, viewGroup, false);
			viewHolder.image = (ImageView) view.findViewById(R.id.ivAvatar);
			viewHolder.name = (TextView) view.findViewById(R.id.tvName);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		ContactItem item = data.get(pos);
		viewHolder.image.setImageResource(item.imageId);
		viewHolder.name.setText(item.name);
		return view;
	}
	
	class ViewHolder {
		public ImageView image;
		public TextView name;
	}

	public void setData(List<ContactItem> data) {
		this.data = data;
	}
}
