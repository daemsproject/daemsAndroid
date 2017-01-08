package net.fai.daems;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionSheet {

	public interface OnActionSheetSelected {
		void onClick(int whichButton);
	}

	private ActionSheet() {
	}

	public static Dialog showSheet(Context context, final OnActionSheetSelected actionSheetSelected,
			OnCancelListener cancelListener) {
		final Dialog dlg = new Dialog(context, R.style.ActionSheet);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.actionsheet, null);
		final int cFullFillWidth = 10000;
		layout.setMinimumWidth(cFullFillWidth);

		TextView mCopy = (TextView) layout.findViewById(R.id.action_copy);
		TextView mDelete = (TextView) layout.findViewById(R.id.action_delete);
		TextView mCancel = (TextView) layout.findViewById(R.id.action_cancel);
		
		mCopy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				actionSheetSelected.onClick(R.id.action_copy);
				dlg.dismiss();
			}
		});

		mDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				actionSheetSelected.onClick(R.id.action_delete);
				dlg.dismiss();
			}
		});

		mCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				actionSheetSelected.onClick(R.id.action_cancel);
				dlg.dismiss();
			}
		});

		Window w = dlg.getWindow();
		WindowManager.LayoutParams lp = w.getAttributes();
		lp.x = 0;
		final int cMakeBottom = -1000;
		lp.y = cMakeBottom;
		lp.gravity = Gravity.BOTTOM;
		dlg.onWindowAttributesChanged(lp);
		dlg.setCanceledOnTouchOutside(false);
		if (cancelListener != null)
			dlg.setOnCancelListener(cancelListener);

		dlg.setContentView(layout);
		dlg.show();

		return dlg;
	}

}