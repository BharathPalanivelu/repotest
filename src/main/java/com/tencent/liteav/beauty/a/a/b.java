package com.tencent.liteav.beauty.a.a;

import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f31446a;

    /* renamed from: b  reason: collision with root package name */
    private EGLSurface f31447b = EGL11.EGL_NO_SURFACE;

    /* renamed from: c  reason: collision with root package name */
    private int f31448c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f31449d = -1;

    protected b(a aVar) {
        this.f31446a = aVar;
    }

    public void a(int i, int i2) {
        if (this.f31447b == EGL11.EGL_NO_SURFACE) {
            this.f31447b = this.f31446a.a(i, i2);
            this.f31448c = i;
            this.f31449d = i2;
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void a() {
        this.f31446a.a(this.f31447b);
        this.f31447b = EGL11.EGL_NO_SURFACE;
        this.f31449d = -1;
        this.f31448c = -1;
    }

    public void b() {
        this.f31446a.b(this.f31447b);
    }
}
