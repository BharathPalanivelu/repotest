package com.google.zxing.c.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class a {
    public static int a(float f2) {
        return (int) (f2 + (f2 < BitmapDescriptorFactory.HUE_RED ? -0.5f : 0.5f));
    }

    public static float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    public static float a(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((double) ((i5 * i5) + (i6 * i6)));
    }
}
