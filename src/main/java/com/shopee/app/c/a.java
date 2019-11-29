package com.shopee.app.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.shopee.app.application.ar;

public class a {
    public static void a(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) ar.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (Exception unused) {
                inputMethodManager.toggleSoftInput(1, 2);
            }
        }
    }

    public static void b(View view) {
        view.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) ar.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public static void a(Context context) {
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus != null) {
                a(currentFocus);
            }
        }
    }
}
