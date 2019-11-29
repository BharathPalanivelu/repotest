package com.modiface.mfemakeupkit.utils;

import android.opengl.EGLContext;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EGLContext f15363a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f15364b;

    g(m mVar, EGLContext eGLContext) {
        this.f15364b = mVar;
        this.f15363a = eGLContext;
    }

    public void run() {
        this.f15364b.a(this.f15363a);
    }
}
