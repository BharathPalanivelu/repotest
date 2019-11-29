package com.beetalk.sdk.f;

import android.os.Handler;
import android.os.Looper;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f5429a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f5430b = new Handler(Looper.getMainLooper());

    private d() {
    }

    public static d a() {
        if (f5429a == null) {
            f5429a = new d();
        }
        return f5429a;
    }

    public void a(Runnable runnable) {
        this.f5430b.post(runnable);
    }

    public void a(Runnable runnable, int i) {
        this.f5430b.postDelayed(runnable, (long) i);
    }
}
