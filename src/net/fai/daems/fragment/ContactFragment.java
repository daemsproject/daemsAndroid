package net.fai.daems.fragment;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.ChatActivity;
import net.fai.daems.ContactAddActivity;
import net.fai.daems.R;
import net.fai.daems.adapter.ContactAdapter;
import net.fai.daems.adapter.ContactButtonAdapter;
import net.fai.daems.adapter.item.ContactButtonItem;
import net.fai.daems.adapter.item.ContactItem;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.common.collect.Lists;

public class ContactFragment extends DaemsFragment implements OnItemClickListener {
	ListView lvContact;
	ListView lvContactButton;

	public ContactFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.contact_fragment, container, false);
		
		lvContactButton = (ListView) view.findViewById(R.id.lvContactButton);
		lvContactButton.setAdapter(new ContactButtonAdapter(context, getButtonItems()));
		lvContactButton.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(context, ContactAddActivity.class);
				startActivity(intent);
			}
		});
		
		lvContact = (ListView) view.findViewById(R.id.lvContact);
		lvContact.setAdapter(new ContactAdapter(context, getContactItems()));
		lvContact.setOnItemClickListener(this);
		return view;
	}
	
	private List<ContactButtonItem> getButtonItems() {
		List<ContactButtonItem> items = Lists.newArrayList();
		ContactButtonItem add = new ContactButtonItem(R.drawable.add_friend, "添加新朋友");
		items.add(add);
		return items;
	}

	private List<ContactItem> getContactItems() {
		List<ContactItem> items = new ArrayList<ContactItem>();
		for (int i = 0; i < 5; i++) {
			int index = i % 5;
			items.add(new ContactItem(getResource("avatar" + (index + 1)), " 联系人" + i));
		}
		return items;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		 Intent intent = new Intent(context, ChatActivity.class);
		 ContactItem item = (ContactItem) lvContact.getItemAtPosition(arg2);
		 intent.putExtra("name", item.name);
         //启动Intent
         startActivity(intent);
	}
}
