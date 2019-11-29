package com.airpay.paysdk.base.d;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3802a = {"android.permission.READ_PHONE_STATE"};

    public static void a(Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = 1.0f;
        window.setAttributes(attributes);
    }
}
