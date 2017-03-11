package net.fai.daems;

import net.fai.daems.constant.ViewId;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 流量币捐赠Activity
 * @author Administrator
 *
 */
public class FlowCoinDonateActivity extends DaemsActivity implements OnClickListener {
	
	@ViewId(R.id.btn_back)
	Button btnBack;
	
	@ViewId(R.id.etAddress)
	EditText etAddress;
	
	@Override
	public int getContentView() {
		return R.layout.layout_flow_coin_donate;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
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
}
