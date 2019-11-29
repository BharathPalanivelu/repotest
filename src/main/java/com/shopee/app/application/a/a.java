package com.shopee.app.application.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final b f15810a;

    /* renamed from: b  reason: collision with root package name */
    private int f15811b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15812c = true;

    a(b bVar) {
        super(Looper.getMainLooper());
        this.f15810a = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity) {
        if (this.f15811b == 0) {
            this.f15812c = false;
            this.f15810a.g(activity);
        }
        this.f15811b++;
    }

    /* access modifiers changed from: package-private */
    public void b(Activity activity) {
        this.f15811b--;
        if (this.f15811b == 0) {
            this.f15812c = true;
            this.f15810a.h(activity);
        }
    }
}
