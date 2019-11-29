package com.airpay.paysdk.base.d;

import android.content.Context;

public class l {
    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int a(Context context, float f2) {
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }
}
