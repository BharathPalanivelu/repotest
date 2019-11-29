package com.tencent.liteav.basic.d;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31258a = "b";
    private static int[] l = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
    private static int[] m = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: b  reason: collision with root package name */
    private EGL10 f31259b;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f31260c;

    /* renamed from: d  reason: collision with root package name */
    private EGLConfig f31261d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31262e;

    /* renamed from: f  reason: collision with root package name */
    private EGLContext f31263f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31264g;
    private EGLSurface h;
    private int i = 0;
    private int j = 0;
    private int[] k = new int[2];

    private b() {
    }

    public static b a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i2, int i3) {
        b bVar = new b();
        bVar.i = i2;
        bVar.j = i3;
        if (bVar.a(eGLConfig, eGLContext, surface)) {
            return bVar;
        }
        return null;
    }

    public boolean a() {
        boolean eglSwapBuffers = this.f31259b.eglSwapBuffers(this.f31260c, this.h);
        d();
        return eglSwapBuffers;
    }

    public void b() {
        this.f31259b.eglMakeCurrent(this.f31260c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        EGLSurface eGLSurface = this.h;
        if (eGLSurface != null) {
            this.f31259b.eglDestroySurface(this.f31260c, eGLSurface);
        }
        EGLContext eGLContext = this.f31263f;
        if (eGLContext != null) {
            this.f31259b.eglDestroyContext(this.f31260c, eGLContext);
        }
        this.f31259b.eglTerminate(this.f31260c);
        d();
        this.f31260c = null;
        this.h = null;
        this.f31260c = null;
    }

    private boolean a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        this.f31259b = (EGL10) EGLContext.getEGL();
        this.f31260c = this.f31259b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f31259b.eglInitialize(this.f31260c, this.k);
        if (eGLConfig == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            this.f31259b.eglChooseConfig(this.f31260c, surface == null ? l : m, eGLConfigArr, 1, new int[1]);
            this.f31261d = eGLConfigArr[0];
            this.f31262e = true;
        } else {
            this.f31261d = eGLConfig;
        }
        int[] iArr = {12440, 2, 12344};
        if (eGLContext == null) {
            this.f31263f = this.f31259b.eglCreateContext(this.f31260c, this.f31261d, EGL10.EGL_NO_CONTEXT, iArr);
        } else {
            this.f31263f = this.f31259b.eglCreateContext(this.f31260c, this.f31261d, eGLContext, iArr);
            this.f31264g = true;
        }
        if (this.f31263f == EGL10.EGL_NO_CONTEXT) {
            d();
            return false;
        }
        int[] iArr2 = {12375, this.i, 12374, this.j, 12344};
        if (surface == null) {
            this.h = this.f31259b.eglCreatePbufferSurface(this.f31260c, this.f31261d, iArr2);
        } else {
            this.h = this.f31259b.eglCreateWindowSurface(this.f31260c, this.f31261d, surface, (int[]) null);
        }
        if (this.h == EGL10.EGL_NO_SURFACE) {
            d();
            return false;
        }
        EGL10 egl10 = this.f31259b;
        EGLDisplay eGLDisplay = this.f31260c;
        EGLSurface eGLSurface = this.h;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f31263f)) {
            return true;
        }
        d();
        return false;
    }

    public EGLContext c() {
        return this.f31263f;
    }

    public void d() {
        int eglGetError = this.f31259b.eglGetError();
        if (eglGetError != 12288) {
            String str = f31258a;
            TXCLog.e(str, "EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
