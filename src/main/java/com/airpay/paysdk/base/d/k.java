package com.airpay.paysdk.base.d;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.a.f;
import com.airpay.paysdk.c;

public class k {
    public static Typeface a(Context context, int i) {
        return f.a(context, a(i));
    }

    private static int a(int i) {
        switch (i) {
            case 1:
                return c.e.roboto_thin;
            case 2:
                return c.e.roboto_light;
            case 3:
                return c.e.roboto_regular;
            case 4:
                return c.e.roboto_medium;
            case 5:
                return c.e.roboto_bold;
            case 6:
                return c.e.roboto_black;
            default:
                return c.e.roboto_regular;
        }
    }
}
