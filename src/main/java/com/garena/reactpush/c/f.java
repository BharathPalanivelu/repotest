package com.garena.reactpush.c;

import android.os.Handler;
import android.os.Looper;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f8358a;

    public static void a(Runnable runnable) {
        synchronized (f.class) {
            if (f8358a == null) {
                f8358a = new Handler(Looper.getMainLooper());
            }
        }
        f8358a.post(runnable);
    }
}
