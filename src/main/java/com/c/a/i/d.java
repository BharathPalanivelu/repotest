package com.c.a.i;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final double f6248a;

    static {
        double d2 = 1.0d;
        if (17 <= Build.VERSION.SDK_INT) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f6248a = d2;
    }

    @TargetApi(17)
    public static long a() {
        if (17 <= Build.VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double a(long j) {
        double a2 = (double) (a() - j);
        double d2 = f6248a;
        Double.isNaN(a2);
        return a2 * d2;
    }
}
