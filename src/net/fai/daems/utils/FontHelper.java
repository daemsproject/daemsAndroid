package net.fai.daems.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontHelper {
	
	public static Typeface typeface;
	
	public static void initCustomTypeface(Context context, String fontPath) {
		typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
	}
	
	public static void applyFont(final View root) {
		try {
			if (root instanceof ViewGroup) {
				ViewGroup viewGroup = (ViewGroup) root;
				int childCount = viewGroup.getChildCount();
				for (int i = 0; i < childCount; i++)
					applyFont(viewGroup.getChildAt(i));
			} else if (root instanceof TextView)
				((TextView) root).setTypeface(typeface);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
