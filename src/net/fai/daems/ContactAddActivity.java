package net.fai.daems;

import butterknife.Bind;
import butterknife.ButterKnife;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactAddActivity extends Activity implements OnClickListener {
	
	@Bind(R.id.btnAdd) Button btnAdd;
	@Bind(R.id.etInput) EditText etInput;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 先去除应用程序标题栏 注意：一定要在setContentView之前
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 将我们定义的窗口设置为默认视图
		setContentView(R.layout.add_contact);
		ButterKnife.bind(this);
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
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
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
