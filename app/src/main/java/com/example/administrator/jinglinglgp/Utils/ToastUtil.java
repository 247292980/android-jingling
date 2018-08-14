package com.example.administrator.jinglinglgp.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/6/30.
 */


public class ToastUtil {
    private static Toast toast;

    public static void toastShort(Context ctx, String text) {
        if (toast == null) {
            toast = Toast.makeText(ctx, "", Toast.LENGTH_SHORT);
        }

        toast.setText(text);
        toast.show();
    }
}
