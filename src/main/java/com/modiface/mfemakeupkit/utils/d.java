package com.modiface.mfemakeupkit.utils;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15356a = "MFEEGLSurface";

    /* renamed from: b  reason: collision with root package name */
    private EGLDisplay f15357b;

    /* renamed from: c  reason: collision with root package name */
    private EGLSurface f15358c;

    public d() {
        this((Object) null);
    }

    public void a() {
        EGLDisplay eGLDisplay = this.f15357b;
        if (eGLDisplay != null && eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = this.f15358c;
            if (!(eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                this.f15358c = EGL14.EGL_NO_SURFACE;
            }
            EGL14.eglTerminate(this.f15357b);
            this.f15357b = EGL14.EGL_NO_DISPLAY;
        }
    }

    public EGLSurface b() {
        return this.f15358c;
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public d(Object obj) {
        this(obj, false);
    }

    public d(Object obj, boolean z) {
        this.f15357b = EGL14.EGL_NO_DISPLAY;
        this.f15358c = EGL14.EGL_NO_SURFACE;
        this.f15357b = EGL14.eglGetDisplay(0);
        EGLDisplay eGLDisplay = this.f15357b;
        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            Log.e(f15356a, "failed to initialize egl surface: eglGetDisplay failed");
        } else if (!EGL14.eglInitialize(eGLDisplay, new int[1], 0, new int[1], 0)) {
            Log.e(f15356a, "failed to initialize egl surface: eglInitialize failed");
        } else {
            int[] iArr = z ? new int[]{12352, 4, 12339, 1, 12322, 8, 12323, 8, 12324, 8, 12610, 1, 12344} : new int[]{12352, 4, 12339, 1, 12322, 8, 12323, 8, 12324, 8, 12344};
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.f15357b, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                Log.e(f15356a, "failed to initialize egl surface: eglChooseConfig failed");
                return;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (obj != null) {
                try {
                    this.f15358c = EGL14.eglCreateWindowSurface(this.f15357b, eGLConfig, obj, new int[]{12344}, 0);
                    EGLSurface eGLSurface = this.f15358c;
                    if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
                        int eglGetError = EGL14.eglGetError();
                        Log.e(f15356a, "failed to initialize egl surface: eglCreateWindowSurface failed with error: " + eglGetError);
                    }
                } catch (IllegalArgumentException e2) {
                    Log.e(f15356a, "failed to initialize egl surface: eglCreateWindowSurface failed ", e2);
                }
            } else {
                try {
                    this.f15358c = EGL14.eglCreatePbufferSurface(this.f15357b, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
                    EGLSurface eGLSurface2 = this.f15358c;
                    if (eGLSurface2 == null || eGLSurface2 == EGL14.EGL_NO_SURFACE) {
                        int eglGetError2 = EGL14.eglGetError();
                        Log.e(f15356a, "failed to initialize egl surface: eglCreatePbufferSurface failed with error: " + eglGetError2);
                    }
                } catch (IllegalArgumentException e3) {
                    Log.e(f15356a, "failed to initialize egl surface: eglCreatePbufferSurface failed", e3);
                }
            }
        }
    }
}
