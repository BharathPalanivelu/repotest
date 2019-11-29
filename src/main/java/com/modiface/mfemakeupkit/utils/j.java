package com.modiface.mfemakeupkit.utils;

import android.opengl.EGLContext;

class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EGLContext f15368a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f15369b;

    j(m mVar, EGLContext eGLContext) {
        this.f15369b = mVar;
        this.f15368a = eGLContext;
    }

    public void run() {
        this.f15369b.a(this.f15368a);
    }
}
