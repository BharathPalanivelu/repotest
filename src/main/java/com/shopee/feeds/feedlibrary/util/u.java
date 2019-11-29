package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.widget.Toast;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f28392a;

    public static void a(Context context, String str) {
        Toast toast = f28392a;
        if (toast == null) {
            f28392a = Toast.makeText(context.getApplicationContext(), str, 0);
        } else {
            toast.setText(str);
        }
        f28392a.show();
    }

    public static void b(Context context, String str) {
        Toast toast = f28392a;
        if (toast == null) {
            f28392a = Toast.makeText(context.getApplicationContext(), str, 1);
        } else {
            toast.setText(str);
        }
        f28392a.show();
    }
}
