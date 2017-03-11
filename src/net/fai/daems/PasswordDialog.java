package net.fai.daems;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PasswordDialog extends Dialog {
    
    private static int default_width = 160; //默认宽度
    private static int default_height = 160;//默认高度
    
    public PasswordDialog(Context context, View layout, int style) {
        this(context, default_width, default_height, layout, style);
    }
    
    public PasswordDialog(Context context, int width, int height, View layout, int style) {
        super(context, style);
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        params.width = width;
        params.height = height;
        window.setAttributes(params);
    }
    
}