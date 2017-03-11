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
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 流量币交易记录
 * @author Administrator
 *
 */
public class FlowCoinTransRecordActivity extends DaemsActivity implements OnClickListener {
	
	@ViewId(R.id.btn_back)
	Button btnBack;
	@ViewId(R.id.flowCoinTrans)
	ListView flowCoinTrans;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private  TransAdapter adapter;

	@Override
	public int getContentView() {
		return R.layout.flow_coin_trans_record;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		adapter = new TransAdapter(FlowCoinTransRecordActivity.this, getTrans());
		flowCoinTrans.setAdapter(adapter);
	}

	
	private List<TransItem> getTrans() {
		List<TransItem> items = new ArrayList<TransItem>();
		items.add(new TransItem(R.drawable.avatar1, "c380c8e6a0c8acda2381d4c9465acff8ec203ce6", sdf.format(new Date()), true, "0.71", false));
		items.add(new TransItem(R.drawable.avatar2, "d3b9c726b4430e1d8f09e2b0130996b40ca726ad", sdf.format(new Date()), true, "1.56", true));
		items.add(new TransItem(R.drawable.avatar3, "a9e62497cc516e908d179c5fc6590b92ac67416e", sdf.format(new Date()), false, "1.06", true));
		items.add(new TransItem(R.drawable.avatar4, "51417e732c29917818659a8a7ef67a04cd3401ba", sdf.format(new Date()), true, "1.56", false));
		items.add(new TransItem(R.drawable.avatar5, "48f6f9d86167fd7e7c15b9f3faf3031b7f051312", sdf.format(new Date()), false, "3.00", false));
		return items;
	}

	@Override
	public void onClick(View v) {
		this.finish();
	}
}
