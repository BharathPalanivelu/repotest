package com.airpay.paysdk.base.ui.weidget;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class d {
    public static void a(View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                try {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                } catch (Exception unused) {
                    inputMethodManager.toggleSoftInput(1, 2);
                }
            }
        }
    }

    public static void b(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public static void a(Activity activity) {
        if (activity != null) {
            activity.getWindow().setSoftInputMode(3);
            a(activity.getCurrentFocus());
        }
    }
}
