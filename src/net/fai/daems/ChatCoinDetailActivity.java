package net.fai.daems;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.fai.daems.adapter.TransAdapter;
import net.fai.daems.adapter.item.TransItem;
import net.fai.daems.constant.ViewId;
import net.fai.daems.utils.DipPxUtils;
import net.fai.daems.utils.QRCodeUtil;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 钱包Activity
 * @author Administrator
 *
 */
public class ChatCoinDetailActivity extends DaemsActivity implements OnClickListener {
	
	@ViewId(R.id.btn_back)
	Button btnBack;
	@ViewId(R.id.btnChatCoinSend)
	Button btnChatCoinSend;
	@ViewId(R.id.imgQRCode)
	ImageView imgQRCode;
	@ViewId(R.id.chatCoinTrans)
	ListView chatCoinTrans;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int copyedPosition = -1;
	private  TransAdapter adapter;

	@Override
	public int getContentView() {
		return R.layout.chat_coin_detail;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		adapter = new TransAdapter(ChatCoinDetailActivity.this, getTrans());
		chatCoinTrans.setAdapter(adapter);
		
		final String filePath = QRCodeUtil.getFileRoot(ChatCoinDetailActivity.this) + File.separator
                + "qr_" + System.currentTimeMillis() + ".jpg";
		
		final int edgeWidth = DipPxUtils.dip2px(this, 100f);

		boolean success = QRCodeUtil.createQRImage("1DQe9F3agsDcr4qoTZ3Sush4e88Nv9tNxa", edgeWidth, edgeWidth,
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_menu_chat_off), filePath);

        if (success) {
        	imgQRCode.setImageBitmap(BitmapFactory.decodeFile(filePath));
        }
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			this.finish();
			break;
		case R.id.btnChatCoinSend:
			break;
			default:
		}
	}
	
	private List<TransItem> getTrans() {
		List<TransItem> items = new ArrayList<TransItem>();
		items.add(new TransItem(R.drawable.ic_launcher, "c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date()), true, "0.71"));
		items.add(new TransItem(R.drawable.ic_launcher, "d3b9c726b4430e1d8f09e2b0130996b40ca726ad", sdf.format(new Date()), true, "1.56"));
		items.add(new TransItem(R.drawable.ic_launcher, "a9e62497cc516e908d179c5fc6590b92ac67416e", sdf.format(new Date()), false, "1.06"));
		items.add(new TransItem(R.drawable.ic_launcher, "51417e732c29917818659a8a7ef67a04cd3401ba", sdf.format(new Date()), true, "1.56"));
		items.add(new TransItem(R.drawable.ic_launcher, "48f6f9d86167fd7e7c15b9f3faf3031b7f051312", sdf.format(new Date()), false, "3.00"));
		return items;
	}
}
