package com.modiface.mfemakeupkit.utils;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class m extends x {

    /* renamed from: d  reason: collision with root package name */
    private static final String f15377d = "MFEGLThread";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f15378e = EGL14.EGL_NO_DISPLAY;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f15379f = EGL14.EGL_NO_CONTEXT;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EGLConfig f15380g = null;
    /* access modifiers changed from: private */
    public EGLSurface h;
    /* access modifiers changed from: private */
    public EGLSurface i;
    /* access modifiers changed from: private */
    public boolean j;
    private final boolean k;
    protected boolean l;

    private final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f15381a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f15382b;

        /* synthetic */ a(m mVar, Runnable runnable, g gVar) {
            this(runnable);
        }

        public void run() {
            if (m.this.l) {
                this.f15382b.run();
                this.f15381a = true;
            }
        }

        private a(Runnable runnable) {
            this.f15381a = false;
            this.f15382b = runnable;
        }
    }

    public m(String str, EGLContext eGLContext, boolean z) {
        super(str);
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        this.h = eGLSurface;
        this.i = eGLSurface;
        this.j = true;
        this.l = false;
        this.k = z;
        this.f15407c.postAtFrontOfQueue(new g(this, eGLContext));
    }

    public void e() {
        if (this.l) {
            EGLSurface eGLSurface = this.i;
            if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglSwapBuffers(this.f15378e, eGLSurface);
            }
        }
    }

    public void c(Runnable runnable) {
        b(new i(this, runnable), true);
    }

    public boolean d() {
        return this.l;
    }

    public void b(EGLContext eGLContext) {
        Handler handler = this.f15407c;
        if (handler != null) {
            handler.postAtFrontOfQueue(new j(this, eGLContext));
        }
    }

    public boolean c(Runnable runnable, boolean z) {
        return a(runnable, (Runnable) null, z);
    }

    public boolean d(Runnable runnable) {
        return a(runnable, (Runnable) null, false);
    }

    public boolean e(Runnable runnable) {
        if (runnable != null) {
            a aVar = new a(this, runnable, (g) null);
            return b(aVar) && aVar.f15381a;
        }
        throw new IllegalArgumentException("cannot run null runnable in runOnGLThreadSync in MFEGLThread");
    }

    public void a() {
        b(new h(this));
        super.a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.l = false;
        EGLDisplay eGLDisplay = this.f15378e;
        if (eGLDisplay != null && eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
            this.i = eGLSurface2;
            this.j = true;
            EGLSurface eGLSurface3 = this.h;
            if (!(eGLSurface3 == null || eGLSurface3 == eGLSurface2)) {
                EGL14.eglDestroySurface(this.f15378e, eGLSurface3);
                this.h = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f15379f;
            if (!(eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT)) {
                if (!EGL14.eglDestroyContext(this.f15378e, eGLContext)) {
                    Log.e(f15377d, "eglDestroyContext failed with error: " + EGL14.eglGetError() + ", display:" + this.f15378e + ", context: " + this.f15379f);
                }
                this.f15379f = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglTerminate(this.f15378e);
            this.f15378e = EGL14.EGL_NO_DISPLAY;
        }
    }

    public boolean a(Object obj, ArrayList<Throwable> arrayList) {
        if (obj == null || (obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            b(new k(this, arrayList, obj, atomicBoolean));
            return atomicBoolean.get();
        }
        throw new IllegalArgumentException("cannot set surface with an non-null surface that is not instance of android.view.Surface or android.graphics.SurfaceTexture in MFEGLThread");
    }

    public boolean a(EGLSurface eGLSurface, boolean z) {
        boolean z2;
        boolean z3;
        if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
            eGLSurface = this.h;
            z2 = true;
            z3 = true;
        } else {
            z3 = z;
            z2 = false;
        }
        EGLDisplay eGLDisplay = this.f15378e;
        if (!(eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY)) {
            EGLContext eGLContext = this.f15379f;
            if (!(eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT)) {
                if (this.i == eGLSurface) {
                    return !z2;
                }
                this.l = EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
                if (!this.l) {
                    Log.e(f15377d, "failed to make current in makeCurrent() in MFEGLThread");
                    this.i = EGL14.EGL_NO_SURFACE;
                    this.j = true;
                    return false;
                }
                this.i = eGLSurface;
                this.j = z3;
                return !z2;
            }
        }
        return false;
    }

    public void a(long j2) {
        EGLSurface eGLSurface = this.i;
        if (eGLSurface != EGL14.EGL_NO_SURFACE && !this.j) {
            EGLExt.eglPresentationTimeANDROID(this.f15378e, eGLSurface, j2);
        }
    }

    public boolean a(Runnable runnable, Runnable runnable2) {
        return a(runnable, runnable2, false);
    }

    public boolean a(Runnable runnable, Runnable runnable2, boolean z) {
        if (runnable != null) {
            return a(new l(this, runnable, runnable2), z);
        }
        throw new IllegalArgumentException("cannot run null runnable in runOnGLThreadAsync in MFEGLThread");
    }

    /* access modifiers changed from: protected */
    public void a(EGLContext eGLContext) {
        if (!this.l) {
            this.f15378e = EGL14.eglGetDisplay(0);
            EGLDisplay eGLDisplay = this.f15378e;
            if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
                Log.e(f15377d, "failed to initialize gl thread: eglGetDisplay failed");
            } else if (!EGL14.eglInitialize(eGLDisplay, new int[1], 0, new int[1], 0)) {
                Log.e(f15377d, "failed to initialize gl thread: eglInitialize failed");
            } else {
                int[] iArr = {12352, 4, 12339, 1, 12322, 8, 12323, 8, 12324, 8, 12344};
                if (this.k) {
                    iArr = new int[]{12352, 4, 12339, 1, 12322, 8, 12323, 8, 12324, 8, 12610, 1, 12344};
                }
                int[] iArr2 = iArr;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!EGL14.eglChooseConfig(this.f15378e, iArr2, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    Log.e(f15377d, "failed to initialize gl thread: eglChooseConfig failed");
                    return;
                }
                this.f15380g = eGLConfigArr[0];
                int[] iArr3 = {12440, 2, 12344};
                EGLDisplay eGLDisplay2 = this.f15378e;
                EGLConfig eGLConfig = this.f15380g;
                if (eGLContext == null) {
                    eGLContext = EGL14.EGL_NO_CONTEXT;
                }
                this.f15379f = EGL14.eglCreateContext(eGLDisplay2, eGLConfig, eGLContext, iArr3, 0);
                EGLContext eGLContext2 = this.f15379f;
                if (eGLContext2 == null || eGLContext2 == EGL14.EGL_NO_CONTEXT) {
                    Log.e(f15377d, "failed to initialize gl thread: eglCreateContext failed");
                    return;
                }
                try {
                    this.h = EGL14.eglCreatePbufferSurface(this.f15378e, this.f15380g, new int[]{12375, 1, 12374, 1, 12344}, 0);
                    EGLSurface eGLSurface = this.h;
                    if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
                        int eglGetError = EGL14.eglGetError();
                        Log.e(f15377d, "failed to initialize gl thread, createWindowSurface failed with error: " + eglGetError);
                        return;
                    }
                    this.l = EGL14.eglMakeCurrent(this.f15378e, eGLSurface, eGLSurface, this.f15379f);
                    if (!this.l) {
                        Log.e(f15377d, "failed to initialize gl thread: eglMakeCurrent failed");
                        this.i = EGL14.EGL_NO_SURFACE;
                        this.j = true;
                        return;
                    }
                    this.i = this.h;
                    this.j = true;
                } catch (IllegalArgumentException e2) {
                    Log.e(f15377d, "failed to initialize gl thread, eglCreatePbufferSurface failed with exception: ", e2);
                }
            }
        }
    }
}
