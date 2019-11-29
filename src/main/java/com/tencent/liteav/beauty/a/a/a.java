package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private EGL10 f31441a;

    /* renamed from: b  reason: collision with root package name */
    private final EGLContext f31442b;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f31443c;

    /* renamed from: d  reason: collision with root package name */
    private EGLConfig f31444d;

    /* renamed from: e  reason: collision with root package name */
    private EGLSurface f31445e;

    public a() {
        this((EGLConfig) null);
    }

    public a(EGLConfig eGLConfig) {
        this.f31441a = (EGL10) EGLContext.getEGL();
        this.f31443c = this.f31441a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f31443c != EGL10.EGL_NO_DISPLAY) {
            if (this.f31441a.eglInitialize(this.f31443c, new int[2])) {
                if (eGLConfig != null) {
                    this.f31444d = eGLConfig;
                } else {
                    this.f31444d = b();
                }
                this.f31442b = this.f31441a.eglCreateContext(this.f31443c, this.f31444d, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                return;
            }
            this.f31443c = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        throw new RuntimeException("unable to get EGL10 display");
    }

    private EGLConfig b() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.f31441a.eglChooseConfig(this.f31443c, new int[]{12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, eGLConfigArr, eGLConfigArr.length, new int[1])) {
            return eGLConfigArr[0];
        }
        TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
        return null;
    }

    public void a() {
        this.f31441a.eglMakeCurrent(this.f31443c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.f31441a.eglDestroyContext(this.f31443c, this.f31442b);
        this.f31441a.eglTerminate(this.f31443c);
    }

    public void a(EGLSurface eGLSurface) {
        this.f31441a.eglDestroySurface(this.f31443c, eGLSurface);
    }

    public EGLSurface a(int i, int i2) {
        this.f31445e = this.f31441a.eglCreatePbufferSurface(this.f31443c, this.f31444d, new int[]{12375, i, 12374, i2, 12344});
        a("eglCreatePbufferSurface");
        EGLSurface eGLSurface = this.f31445e;
        if (eGLSurface != null) {
            return eGLSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void b(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = this.f31443c;
        if (eGLDisplay == EGL11.EGL_NO_DISPLAY) {
            TXCLog.d("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (!this.f31441a.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f31442b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    private void a(String str) {
        int eglGetError = this.f31441a.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
