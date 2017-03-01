package net.fai.daems.fragment;

import org.greenrobot.eventbus.EventBus;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

public abstract class DaemsFragment extends Fragment {
	
	protected Context context;
	
	public DaemsFragment(Context context) {
		this.context = context;
	}
	
	@Override
	final public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
//		if (hidden) {
//			EventBus.getDefault().unregister(this);
//		} else {
//			EventBus.getDefault().register(this);
//		}
	}

	@Override
	final public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		EventBus.getDefault().register(this);
	}

	@Override
	final public void onDestroy() {
		super.onDestroy();
//		EventBus.getDefault().unregister(this);
	}
	
	protected int getResource(String imageName) {
		int resId = getResources().getIdentifier(imageName, "drawable",
				context.getPackageName());
		return resId;
	}
}
