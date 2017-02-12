package net.fai.daems;

import net.fai.daems.constant.ViewId;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactAddActivity extends DaemsActivity implements OnClickListener {
	
	@ViewId(R.id.btnAdd)
	Button btnAdd;
	@ViewId(R.id.etInput)
	EditText etInput;
	
	@Override
	public int getContentView() {
		return R.layout.add_contact;
	}

	@Override
	public void beforeSetContentView() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	@Override
	public boolean isTintSystgemBar() {
		return false;
	}

	@Override
	public void onCreateActivity(Bundle savedInstanceState) {
		btnAdd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (!"".equals(etInput.getText())) {
			Toast.makeText(ContactAddActivity.this, etInput.getText(), Toast.LENGTH_SHORT).show();
		}
		this.finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
}
