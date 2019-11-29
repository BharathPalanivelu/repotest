package com.shopee.arcatch.c.e.b;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import java.util.ArrayList;

public class f implements SurfaceTexture.OnFrameAvailableListener {
    private static int s = 10000;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<c> f26842a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f26843b;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f26844c;

    /* renamed from: d  reason: collision with root package name */
    private EGLContext f26845d;

    /* renamed from: e  reason: collision with root package name */
    private EGLContext f26846e;

    /* renamed from: f  reason: collision with root package name */
    private EGLSurface f26847f;

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f26848g;
    private Surface h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public Rect m;
    private int n;
    private int o;
    private boolean p = true;
    private b q;
    private long r;
    private boolean t;
    private boolean u;
    private long v = 0;
    private Object w = new Object();
    private Object x = new Object();
    private int y = 1;
    private long z = 0;

    public interface b {
        void a();
    }

    public void a(b bVar) {
        this.q = bVar;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Surface f26849a;

        /* renamed from: b  reason: collision with root package name */
        private int f26850b;

        /* renamed from: c  reason: collision with root package name */
        private int f26851c;

        /* renamed from: d  reason: collision with root package name */
        private int f26852d;

        /* renamed from: e  reason: collision with root package name */
        private int f26853e;

        /* renamed from: f  reason: collision with root package name */
        private Rect f26854f;

        /* renamed from: g  reason: collision with root package name */
        private int f26855g;

        public a a(Surface surface) {
            this.f26849a = surface;
            return this;
        }

        public a a(int i) {
            this.f26850b = i;
            return this;
        }

        public a b(int i) {
            this.f26851c = i;
            return this;
        }

        public a c(int i) {
            this.f26852d = i;
            return this;
        }

        public a d(int i) {
            this.f26853e = i;
            return this;
        }

        public a a(Rect rect) {
            this.f26854f = rect;
            return this;
        }

        public a e(int i) {
            this.f26855g = i;
            return this;
        }

        public f a() {
            f fVar = new f();
            int unused = fVar.i = this.f26850b;
            int unused2 = fVar.j = this.f26851c;
            int unused3 = fVar.k = this.f26852d;
            int unused4 = fVar.l = this.f26853e;
            Rect unused5 = fVar.m = this.f26854f;
            fVar.l();
            fVar.b(this.f26855g);
            fVar.a(this.f26849a);
            fVar.a();
            fVar.m();
            return fVar;
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    public void l() {
        this.f26844c = EGL14.EGL_NO_DISPLAY;
        this.f26845d = EGL14.EGL_NO_CONTEXT;
        this.f26846e = EGL14.EGL_NO_CONTEXT;
        this.f26847f = EGL14.EGL_NO_SURFACE;
        this.f26848g = EGL14.EGL_NO_SURFACE;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        this.n = i2;
        this.o = 1000 / i2;
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    public void a(Surface surface) {
        this.f26844c = EGL14.eglGetDisplay(0);
        if (this.f26844c != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f26844c, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.f26844c, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                    EGLConfig c2 = c(2);
                    int[] iArr2 = {12440, 2, 12344};
                    this.f26845d = EGL14.eglCreateContext(this.f26844c, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
                    a("eglCreateContext");
                    EGLContext eGLContext = this.f26845d;
                    if (eGLContext != null) {
                        this.f26846e = EGL14.eglCreateContext(this.f26844c, c2, eGLContext, iArr2, 0);
                        a("eglCreateContext");
                        if (this.f26846e != null) {
                            this.f26847f = EGL14.eglCreatePbufferSurface(this.f26844c, eGLConfigArr[0], new int[]{12375, this.k, 12374, this.l, 12344}, 0);
                            a("eglCreatePbufferSurface");
                            if (this.f26847f != null) {
                                this.f26848g = EGL14.eglCreateWindowSurface(this.f26844c, c2, surface, new int[]{12344}, 0);
                                a("eglCreateWindowSurface");
                                if (this.f26848g == null) {
                                    throw new RuntimeException("surface was null");
                                }
                                return;
                            }
                            throw new RuntimeException("surface was null");
                        }
                        throw new RuntimeException("null context2");
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.f26844c = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    @TargetApi(21)
    public void a() {
        EGLDisplay eGLDisplay = this.f26844c;
        EGLSurface eGLSurface = this.f26847f;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f26845d)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        this.f26842a = new ArrayList<>();
        d dVar = new d(this.i, this.j, this.m);
        dVar.b();
        this.f26843b = new SurfaceTexture(dVar.a());
        this.f26843b.setDefaultBufferSize(this.i, this.j);
        this.f26843b.setOnFrameAvailableListener(this);
        this.h = new Surface(this.f26843b);
        b bVar = new b();
        bVar.a();
        e eVar = new e();
        eVar.a();
        this.f26842a.add(bVar);
        this.f26842a.add(dVar);
        this.f26842a.add(eVar);
        this.u = true;
    }

    public Surface b() {
        return this.h;
    }

    @TargetApi(21)
    private EGLConfig c(int i2) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f26844c, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EncodeDecodeSurface", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    @TargetApi(21)
    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    @TargetApi(21)
    public void a(int i2) {
        if (i2 == 0) {
            EGLDisplay eGLDisplay = this.f26844c;
            EGLSurface eGLSurface = this.f26847f;
            if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f26845d)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        EGLDisplay eGLDisplay2 = this.f26844c;
        EGLSurface eGLSurface2 = this.f26848g;
        if (!EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, this.f26846e)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @TargetApi(21)
    public void a(long j2) {
        EGLExt.eglPresentationTimeANDROID(this.f26844c, this.f26848g, j2);
        a("eglPresentationTimeANDROID");
    }

    public void c() {
        synchronized (this.x) {
            while (!this.p) {
                try {
                    this.x.wait((long) s);
                    if (!this.p) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.p = false;
        }
        this.f26843b.updateTexImage();
    }

    @TargetApi(21)
    public boolean d() {
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.f26844c, this.f26848g);
        a("eglSwapBuffers");
        return eglSwapBuffers;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.x) {
            boolean z2 = this.p;
            this.p = true;
            try {
                this.x.notifyAll();
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public long e() {
        if (this.z != 0) {
            return System.nanoTime() - this.z;
        }
        this.z = System.nanoTime();
        return 0;
    }

    public void f() {
        int size = this.f26842a.size();
        int i2 = 0;
        while (i2 < size) {
            this.f26842a.get(i2).a(i2 == 0 && i2 < size + -1);
            i2++;
        }
    }

    public void g() {
        this.t = true;
        while (this.t) {
            if (this.u) {
                a(1);
                c();
                this.r = System.currentTimeMillis();
                if (this.r - this.v >= ((long) this.o)) {
                    f();
                    this.q.a();
                    a(e());
                    this.y++;
                    d();
                    this.v = this.r;
                }
            } else {
                try {
                    synchronized (this.w) {
                        this.w.wait();
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    public void h() {
        this.u = false;
    }

    public void i() {
        this.u = true;
        synchronized (this.w) {
            this.w.notify();
        }
    }

    public void j() {
        this.t = false;
        synchronized (this.w) {
            this.w.notify();
        }
    }

    @TargetApi(21)
    public void k() {
        SurfaceTexture surfaceTexture = this.f26843b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f26843b = null;
        }
        Surface surface = this.h;
        if (surface != null) {
            surface.release();
        }
        if (this.f26844c != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglDestroySurface(this.f26844c, this.f26847f);
            EGL14.eglDestroyContext(this.f26844c, this.f26845d);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f26844c);
        }
        this.f26844c = EGL14.EGL_NO_DISPLAY;
        this.f26845d = EGL14.EGL_NO_CONTEXT;
        this.f26847f = EGL14.EGL_NO_SURFACE;
        this.f26842a.clear();
        this.h = null;
    }
}
