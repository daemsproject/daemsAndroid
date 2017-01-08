package net.fai.daems.adapter;

import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.item.ChatMsgItem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChatMsgViewAdpater extends DaemsAdapter<ChatMsgItem> {

	// ListView视图的内容由IMsgViewType决定
	public static interface IMsgViewType {
		// 对方发来的信息
		int IMVT_COM_MSG = 0;
		// 自己发出的信息
		int IMVT_TO_MSG = 1;
	}

	public ChatMsgViewAdpater(Context context, List<ChatMsgItem> items) {
		super(context);
		this.setItems(items);
	}

	// 获取项的类型
	public int getItemViewType(int position) {
		ChatMsgItem entity = this.getItem(position);
		if (entity.getMsgType()) {
			return IMsgViewType.IMVT_COM_MSG;
		} else {
			return IMsgViewType.IMVT_TO_MSG;
		}
	}

	// 通过ViewHolder显示项的内容
	static class ViewHolder {
		public TextView tvSendTime;
		public TextView tvUserName;
		public TextView tvContent;
		public boolean isComMsg = true;
	}

	@Override
	public View getAdapterView(int position, View view, ViewGroup parent) {
		ChatMsgItem entity = this.getItem(position);
		boolean isComMsg = entity.getMsgType();

		ViewHolder viewHolder = null;
		if (view == null) {
			if (isComMsg) {
				// 如果是对方发来的消息，则显示的是左气泡
				view = this.getInflater().inflate(
						R.layout.chatting_item_msg_text_left, null);
			} else {
				// 如果是自己发出的消息，则显示的是右气泡
				view = this.getInflater().inflate(
						R.layout.chatting_item_msg_text_right, null);
			}

			viewHolder = new ViewHolder();
			viewHolder.tvSendTime = (TextView) view
					.findViewById(R.id.tv_sendtime);
			viewHolder.tvUserName = (TextView) view
					.findViewById(R.id.tv_username);
			viewHolder.tvContent = (TextView) view
					.findViewById(R.id.tv_chatcontent);
			viewHolder.isComMsg = isComMsg;

			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.tvSendTime.setText(entity.getDate());
		viewHolder.tvUserName.setText(entity.getName());
		viewHolder.tvContent.setText(entity.getText());

		return view;
	}

}