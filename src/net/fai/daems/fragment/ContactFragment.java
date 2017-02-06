package net.fai.daems.fragment;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.ChatActivity;
import net.fai.daems.R;
import net.fai.daems.adapter.ContactAdapter;
import net.fai.daems.adapter.item.ContactItem;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ContactFragment extends Fragment implements OnClickListener, OnItemClickListener {
	private Context context;
	ListView lvContact;
	Button btnSwitch;

	public ContactFragment(Context context) {
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.contact_fragment, container, false);
		lvContact = (ListView) view.findViewById(R.id.lvContact);
		btnSwitch = (Button) view.findViewById(R.id.btnSwitch);
		btnSwitch.setOnClickListener(this);
		lvContact.setAdapter(new ContactAdapter(context, getContactItems(0)));
		lvContact.setOnItemClickListener(this);
		return view;
	}

	private List<ContactItem> getContactItems(int which) {
		String prefix = getAccounts()[which];
		List<ContactItem> items = new ArrayList<ContactItem>();
		for (int i = 0; i < 10; i++) {
			items.add(new ContactItem(R.drawable.ic_launcher, prefix + " 联系人" + i));
		}
		return items;
	}

	@Override
	public void onClick(View v) {
		String[] items = getAccounts();
		AlertDialog dialog = new AlertDialog.Builder(context)
			.setTitle("切换联系人").setIcon(R.drawable.ic_launcher)
			.setItems(items, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					ContactAdapter adapter = (ContactAdapter)lvContact.getAdapter();
					adapter.setItems(getContactItems(which));
					adapter.notifyDataSetChanged();
				}
			}).create();
		dialog.show();
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		 Intent intent = new Intent(context, ChatActivity.class);
		 ContactItem item = (ContactItem) lvContact.getItemAtPosition(arg2);
		 intent.putExtra("name", item.name);
         //启动Intent
         startActivity(intent);
	}
	
	private String[] getAccounts() {
		return new String[] { "账号1", "账号2", "账号3" };
	}
}
