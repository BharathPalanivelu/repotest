package com.modiface.mfemakeupkit.utils;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.util.Log;
import java.util.HashSet;

class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15391a = "MFESharedEGLContext";

    /* renamed from: b  reason: collision with root package name */
    private EGLDisplay f15392b = EGL14.EGL_NO_DISPLAY;

    /* renamed from: c  reason: collision with root package name */
    private EGLContext f15393c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Object f15394d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private HashSet<m> f15395e = new HashSet<>();

    r() {
    }

    /* access modifiers changed from: package-private */
    public EGLContext a(m mVar) {
        EGLContext eGLContext;
        if (mVar != null) {
            synchronized (this.f15394d) {
                if (this.f15393c == null || this.f15393c == EGL14.EGL_NO_CONTEXT) {
                    this.f15395e.clear();
                    a();
                }
                this.f15395e.add(mVar);
                eGLContext = this.f15393c;
            }
            return eGLContext;
        }
        throw new IllegalArgumentException("cannot have null calling thread in getContext() of SharedEGLContext");
    }

    /* access modifiers changed from: package-private */
    public void b(m mVar) {
        if (mVar != null) {
            synchronized (this.f15394d) {
                this.f15395e.remove(mVar);
                if (this.f15395e.isEmpty()) {
                    b();
                }
            }
            return;
        }
        throw new IllegalArgumentException("cannot have null calling thread in onThreadContextReleased() of SharedEGLContext");
    }

    public void finalize() throws Throwable {
        synchronized (this.f15394d) {
            this.f15395e.clear();
            b();
        }
        super.finalize();
    }

    private void b() {
        EGLDisplay eGLDisplay = this.f15392b;
        EGLContext eGLContext = this.f15393c;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        this.f15392b = eGLDisplay2;
        this.f15393c = null;
        if (eGLDisplay != null && eGLDisplay != eGLDisplay2) {
            if (!(eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT || EGL14.eglDestroyContext(eGLDisplay, eGLContext))) {
                Log.e(f15391a, "eglDestroyContext failed with error: " + EGL14.eglGetError() + ", display:" + eGLDisplay + ", context: " + eGLContext);
            }
            EGL14.eglTerminate(eGLDisplay);
        }
    }

    private void a() {
        this.f15392b = EGL14.eglGetDisplay(0);
        EGLDisplay eGLDisplay = this.f15392b;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            Log.e(f15391a, "failed to initialize gl context: eglGetDisplay failed");
        } else if (!EGL14.eglInitialize(eGLDisplay, new int[1], 0, new int[1], 0)) {
            Log.e(f15391a, "failed to initialize gl context: eglInitialize failed");
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.f15392b, new int[]{12352, 4, 12339, 1, 12322, 8, 12323, 8, 12324, 8, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                Log.e(f15391a, "failed to initialize shared gl context: eglChooseConfig failed");
                return;
            }
            this.f15393c = EGL14.eglCreateContext(this.f15392b, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        }
    }
}
