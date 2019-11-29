package com.google.android.libraries.places.internal;

import android.os.Build;
import android.os.SystemClock;

public final class c implements a {
    private static boolean b() {
        try {
            if (Build.VERSION.SDK_INT < 17) {
                return false;
            }
            SystemClock.elapsedRealtimeNanos();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    static {
        b();
    }
}
