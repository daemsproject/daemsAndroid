package net.fai.daems;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.fai.daems.ActionSheet.OnActionSheetSelected;
import net.fai.daems.adapter.ExpirationAdapter;
import net.fai.daems.adapter.item.ExpirationItem;
import net.fai.daems.constant.ViewId;
import net.fai.daems.utils.DipPxUtils;
import net.fai.daems.utils.QRCodeUtil;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 流量币Activity
 * @author Administrator
 *
 */
public class FlowCoinDetailActivity extends DaemsActivity implements OnClickListener, OnCancelListener, OnActionSheetSelected {
	
	@ViewId(R.id.btn_back)
	Button btnBack;
	@ViewId(R.id.trans_record)
	Button btnTransRecord;
	@ViewId(R.id.imgQRCode)
	ImageView imgQRCode;
	@ViewId(R.id.lvExpiration)
	ListView lvExpiration;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private int copyedPosition = -1;
	private  ExpirationAdapter adapter;

	@Override
	public int getContentView() {
		return R.layout.flow_coin_detail;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		btnTransRecord.setOnClickListener(this);
		adapter = new ExpirationAdapter(FlowCoinDetailActivity.this, getExpiration());
		lvExpiration.setAdapter(adapter);
		lvExpiration.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ActionSheet.showFlowCoinSheet(FlowCoinDetailActivity.this, FlowCoinDetailActivity.this, FlowCoinDetailActivity.this);
			}
		});
		
		final String filePath = QRCodeUtil.getFileRoot(FlowCoinDetailActivity.this) + File.separator
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
		case R.id.trans_record:
			Intent intent1 = new Intent(FlowCoinDetailActivity.this,
					FlowCoinTransRecordActivity.class);
			startActivity(intent1);
			break;
			default:
		}
	}
	
	private List<ExpirationItem> getExpiration() {
		List<ExpirationItem> items = new ArrayList<ExpirationItem>();
		items.add(new ExpirationItem("1小时内失效", "8888"));
		items.add(new ExpirationItem("2小时失效", "8888"));
		items.add(new ExpirationItem("3小时失效", "8888"));
		items.add(new ExpirationItem("4小时失效", "8888"));
		return items;
	}

	@Override
	public void onClick(int whichButton) {
		switch (whichButton) {
		case R.id.trans:
			Intent intent1 = new Intent(FlowCoinDetailActivity.this,
					FlowCoinTransActivity.class);
			startActivity(intent1);
			break;
		case R.id.donate:
			Intent intent2 = new Intent(FlowCoinDetailActivity.this,
					FlowCoinDonateActivity.class);
			startActivity(intent2);
			break;
		case R.id.action_cancel:
			break;
		
		}
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		// TODO Auto-generated method stub
		
	}
}
