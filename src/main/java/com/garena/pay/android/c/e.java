package com.garena.pay.android.c;

import android.os.Handler;
import android.os.Looper;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f8180a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f8181b = new Handler(Looper.getMainLooper());

    private e() {
    }

    public static e a() {
        if (f8180a == null) {
            f8180a = new e();
        }
        return f8180a;
    }

    public void a(Runnable runnable, int i) {
        this.f8181b.postDelayed(runnable, (long) i);
    }

    public void a(Runnable runnable) {
        this.f8181b.removeCallbacks(runnable);
    }
}
