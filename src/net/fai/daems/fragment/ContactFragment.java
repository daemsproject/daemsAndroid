package net.fai.daems.fragment;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.ChatActivity;
import net.fai.daems.R;
import net.fai.daems.adapter.ContactAdapter;
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

public class ContactFragment extends DaemsFragment implements OnItemClickListener {
	ListView lvContact;

	public ContactFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.contact_fragment, container, false);
		lvContact = (ListView) view.findViewById(R.id.lvContact);
		lvContact.setAdapter(new ContactAdapter(context, getContactItems(0)));
		lvContact.setOnItemClickListener(this);
		return view;
	}

	private List<ContactItem> getContactItems(int which) {
		List<ContactItem> items = new ArrayList<ContactItem>();
		for (int i = 0; i < 10; i++) {
			items.add(new ContactItem(R.drawable.ic_launcher, " 联系人" + i));
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
