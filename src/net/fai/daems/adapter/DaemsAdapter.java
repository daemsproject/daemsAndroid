package net.fai.daems.adapter;

import java.util.List;

import com.google.common.collect.Lists;

import net.fai.daems.adapter.item.DaemsItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class DaemsAdapter<E extends DaemsItem> extends BaseAdapter {
	
	private Context context;
	private LayoutInflater inflater;
	private List<E> items = null;
	
	public DaemsAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
		items = Lists.newArrayList();
	}
	
	public Context getContext() {
		return context;
	}

	public LayoutInflater getInflater() {
		return inflater;
	}
	
	public void setItems(List<E> items) {
		this.items = items;
		this.notifyDataSetChanged();
	}
	
	public void preppendItem(E item) {
		this.items.add(0, item);
		this.notifyDataSetChanged();
	}
	
	public void appendItem(E item) {
		this.items.add(item);
		this.notifyDataSetChanged();
	}
	
	public E deleteItem(int position) {
		if (position >= this.items.size()) {
			// TODO add log
			return null;
		}
		E item = this.items.remove(position);
		this.notifyDataSetChanged();
		return item;
	}
	
	@Override
	public E getItem(int position) {
		if (position >= this.items.size()) {
			return null;
		}
		return items.get(position);
	}

	@Override
	public int getCount() {
		return this.items.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		return this.getAdapterView(position, view, parent);
	}
	
	public abstract View getAdapterView(int position, View view, ViewGroup parent);

}
