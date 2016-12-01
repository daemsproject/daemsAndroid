package net.fai.daems;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.adapter.ChatAdapter;
import net.fai.daems.bean.ChatItem;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ChatFragment extends Fragment {
	private Context context;
	private ListView lvChat;

	public ChatFragment(Context context) {
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.chat_fragment, container, false);
		lvChat = (ListView) view.findViewById(R.id.lvChat);
		lvChat.setAdapter(new ChatAdapter(context, getChatItems()));
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
}
