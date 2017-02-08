package net.fai.daems;

import java.lang.reflect.Field;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import net.fai.daems.constant.Daems;
import net.fai.daems.constant.ViewId;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Base Activity
 * @author Administrator
 *
 */
public abstract class DaemsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		beforeSetContentView();
		int viewId = getContentView();
		if (viewId != Daems.View.NONE_VIEW) {
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			ViewGroup layout = (ViewGroup) inflater.inflate(viewId, null);
			if (isTintSystgemBar()) {
				layout.setFitsSystemWindows(true);
				initSystemBar(this);
			}
			setContentView(layout);
		}
		try {
			initComponentViews();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		onCreateActivity(savedInstanceState);
	}
	
	public void beforeSetContentView() {}
	
	public abstract int getContentView();
	
	/**
	 * 是否需要沉浸式系统状态栏
	 * @return
	 */
	public boolean isTintSystgemBar() {
		return true;
	}
	
	public abstract void onCreateActivity(Bundle savedInstanceState);
	
	/**
	 * 初始化Activity上的组件
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private void initComponentViews() throws IllegalAccessException, IllegalArgumentException {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(ViewId.class)) {
				int componentViewId = field.getAnnotation(ViewId.class).value();
				View view = findViewById(componentViewId);
				field.setAccessible(true);
				field.set(this, view);
			}
		}
	}
	
	/**
	 * 沉浸式系统状态栏
	 * @param activity
	 */
	public static void initSystemBar(Activity activity) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(activity, true);
		}
		SystemBarTintManager tintManager = new SystemBarTintManager(activity);
		tintManager.setStatusBarTintEnabled(true);
		// 使用颜色资源
		tintManager.setStatusBarTintResource(R.color.background);

	}
	
	@TargetApi(19)
	private static void setTranslucentStatus(Activity activity, boolean on) {
		Window win = activity.getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
	
	

}
