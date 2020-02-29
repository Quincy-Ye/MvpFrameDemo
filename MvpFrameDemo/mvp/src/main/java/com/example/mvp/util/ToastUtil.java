package com.example.mvp.util;

import android.widget.Toast;

import com.example.mvp.app.MyApp;

/**
 * @author Quincy
 * @Date 2020/2/16
 * @Description
 */

public class ToastUtil {
    private static Toast toast;
    public static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApp.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}
