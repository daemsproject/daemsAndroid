package net.fai.daems.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontHelper {
	
	public static void applyFont(final Context context, final View root, final String fontPath) {
		try {
			if (root instanceof ViewGroup) {
				ViewGroup viewGroup = (ViewGroup) root;
				int childCount = viewGroup.getChildCount();
				for (int i = 0; i < childCount; i++)
					applyFont(context, viewGroup.getChildAt(i), fontPath);
			} else if (root instanceof TextView)
				((TextView) root).setTypeface(Typeface.createFromAsset(context.getAssets(), fontPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
