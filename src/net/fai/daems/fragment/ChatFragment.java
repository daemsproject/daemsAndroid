package net.fai.daems.fragment;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.ChatActivity;
import net.fai.daems.R;
import net.fai.daems.adapter.ChatAdapter;
import net.fai.daems.adapter.item.ChatItem;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChatFragment extends DaemsFragment implements OnItemClickListener {
	ListView lvChat;

	public ChatFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.chat_fragment, container, false);
		lvChat = (ListView) view.findViewById(R.id.lvChat);
		lvChat.setAdapter(new ChatAdapter(context, getChatItems()));
		lvChat.setOnItemClickListener(this);
		return view;
	}
	
	private List<ChatItem> getChatItems() {
		List<ChatItem> items = new ArrayList<ChatItem>();
		for (int i = 0; i < 20; i++) {
			items.add(new ChatItem(R.drawable.ic_launcher, "Daems" + i,
					"明早几点起床", "11月" + i + "日"));
		}
		return items;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		 Intent intent = new Intent(context, ChatActivity.class);
		 ChatItem item = (ChatItem) lvChat.getItemAtPosition(arg2);
		 intent.putExtra("name", item.name);
         //启动Intent
         startActivity(intent);
	}
}
