package com.tencent.liteav.basic.d;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

@TargetApi(17)
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f31265a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final String f31266b = "c";
    private static int[] k;
    private static int[] l;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f31267c = EGL14.EGL_NO_DISPLAY;

    /* renamed from: d  reason: collision with root package name */
    private EGLContext f31268d = EGL14.EGL_NO_CONTEXT;

    /* renamed from: e  reason: collision with root package name */
    private EGLConfig f31269e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f31270f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f31271g = 0;
    private boolean h;
    private EGLSurface i;
    private int j = -1;

    public static c a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i2, int i3) {
        c cVar = new c();
        cVar.f31270f = i2;
        cVar.f31271g = i3;
        if (cVar.a(eGLConfig, eGLContext, surface)) {
            return cVar;
        }
        return null;
    }

    public void a() {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            String str = f31266b;
            Log.e(str, "EGL error:" + eglGetError);
            throw new RuntimeException(": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public void b() {
        if (this.f31267c != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f31267c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f31267c, this.i);
            EGL14.eglDestroyContext(this.f31267c, this.f31268d);
            this.f31268d = EGL14.EGL_NO_CONTEXT;
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f31267c);
        }
        this.f31267c = EGL14.EGL_NO_DISPLAY;
    }

    public boolean c() {
        return EGL14.eglSwapBuffers(this.f31267c, this.i);
    }

    private boolean a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        EGLContext eGLContext2;
        EGLConfig eGLConfig2 = eGLConfig;
        Surface surface2 = surface;
        this.f31267c = EGL14.eglGetDisplay(0);
        if (this.f31267c != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f31267c, iArr, 0, iArr, 1)) {
                if (eGLConfig2 != null) {
                    this.f31269e = eGLConfig2;
                } else {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (!EGL14.eglChooseConfig(this.f31267c, surface2 == null ? l : k, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                        return false;
                    }
                    this.f31269e = eGLConfigArr[0];
                }
                if (eGLContext != null) {
                    this.h = true;
                    eGLContext2 = eGLContext;
                } else {
                    eGLContext2 = EGL14.EGL_NO_CONTEXT;
                }
                this.f31268d = EGL14.eglCreateContext(this.f31267c, this.f31269e, eGLContext2, new int[]{12440, f31265a, 12344}, 0);
                int[] iArr2 = {12344};
                if (this.f31268d == EGL14.EGL_NO_CONTEXT) {
                    a();
                    return false;
                }
                if (surface2 == null) {
                    this.i = EGL14.eglCreatePbufferSurface(this.f31267c, this.f31269e, new int[]{12375, this.f31270f, 12374, this.f31271g, 12344}, 0);
                } else {
                    this.i = EGL14.eglCreateWindowSurface(this.f31267c, this.f31269e, surface2, iArr2, 0);
                }
                a();
                EGLDisplay eGLDisplay = this.f31267c;
                EGLSurface eGLSurface = this.i;
                if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f31268d)) {
                    return true;
                }
                a();
                return false;
            }
            this.f31267c = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void a(long j2) {
        EGLExt.eglPresentationTimeANDROID(this.f31267c, this.i, j2);
    }

    static {
        int[] iArr = new int[17];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        int i2 = 4;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12325;
        iArr[9] = 0;
        iArr[10] = 12326;
        iArr[11] = 0;
        iArr[12] = 12352;
        iArr[13] = f31265a == 2 ? 4 : 68;
        iArr[14] = 12610;
        iArr[15] = 1;
        iArr[16] = 12344;
        k = iArr;
        int[] iArr2 = new int[19];
        iArr2[0] = 12339;
        iArr2[1] = 1;
        iArr2[2] = 12324;
        iArr2[3] = 8;
        iArr2[4] = 12323;
        iArr2[5] = 8;
        iArr2[6] = 12322;
        iArr2[7] = 8;
        iArr2[8] = 12321;
        iArr2[9] = 8;
        iArr2[10] = 12325;
        iArr2[11] = 0;
        iArr2[12] = 12326;
        iArr2[13] = 0;
        iArr2[14] = 12352;
        if (f31265a != 2) {
            i2 = 68;
        }
        iArr2[15] = i2;
        iArr2[16] = 12610;
        iArr2[17] = 1;
        iArr2[18] = 12344;
        l = iArr2;
    }
}
