package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f31912a = 12440;

    /* renamed from: b  reason: collision with root package name */
    private int f31913b = 4;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<a> f31914c;

    /* renamed from: d  reason: collision with root package name */
    private EGL10 f31915d;

    /* renamed from: e  reason: collision with root package name */
    private EGLContext f31916e;

    /* renamed from: f  reason: collision with root package name */
    private EGLDisplay f31917f;

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f31918g;
    private EGLConfig h;
    private WeakReference<SurfaceTexture> i;
    private boolean j = false;
    private int k = 1280;
    private int l = 720;
    private Object m = new Object();

    b(WeakReference<a> weakReference) {
        this.f31914c = weakReference;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "VRender-"
            r0.append(r1)
            long r1 = r3.getId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.setName(r0)
            r0 = 1
            r3.j = r0     // Catch:{ Exception -> 0x0074 }
            r3.i()     // Catch:{ Exception -> 0x0074 }
            r3.d()     // Catch:{ Exception -> 0x0074 }
            r3.g()     // Catch:{ Exception -> 0x0074 }
        L_0x0024:
            boolean r0 = r3.j     // Catch:{ Exception -> 0x0074 }
            if (r0 == 0) goto L_0x0068
            boolean r0 = r3.f()     // Catch:{ Exception -> 0x0074 }
            if (r0 == 0) goto L_0x0059
            javax.microedition.khronos.egl.EGL10 r0 = r3.f31915d     // Catch:{ Exception -> 0x0074 }
            if (r0 == 0) goto L_0x0059
            javax.microedition.khronos.egl.EGLDisplay r0 = r3.f31917f     // Catch:{ Exception -> 0x0074 }
            if (r0 == 0) goto L_0x0059
            javax.microedition.khronos.egl.EGLSurface r0 = r3.f31918g     // Catch:{ Exception -> 0x0074 }
            if (r0 == 0) goto L_0x0059
            java.lang.ref.WeakReference<com.tencent.liteav.renderer.a> r0 = r3.f31914c     // Catch:{ Exception -> 0x0074 }
            if (r0 != 0) goto L_0x0040
            r0 = 0
            goto L_0x0048
        L_0x0040:
            java.lang.ref.WeakReference<com.tencent.liteav.renderer.a> r0 = r3.f31914c     // Catch:{ Exception -> 0x0074 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0074 }
            com.tencent.liteav.renderer.a r0 = (com.tencent.liteav.renderer.a) r0     // Catch:{ Exception -> 0x0074 }
        L_0x0048:
            if (r0 == 0) goto L_0x0059
            android.graphics.SurfaceTexture r0 = r0.f()     // Catch:{ Exception -> 0x0074 }
            if (r0 == 0) goto L_0x0059
            javax.microedition.khronos.egl.EGL10 r0 = r3.f31915d     // Catch:{ Exception -> 0x0074 }
            javax.microedition.khronos.egl.EGLDisplay r1 = r3.f31917f     // Catch:{ Exception -> 0x0074 }
            javax.microedition.khronos.egl.EGLSurface r2 = r3.f31918g     // Catch:{ Exception -> 0x0074 }
            r0.eglSwapBuffers(r1, r2)     // Catch:{ Exception -> 0x0074 }
        L_0x0059:
            java.lang.Object r0 = r3.m     // Catch:{ Exception -> 0x0074 }
            monitor-enter(r0)     // Catch:{ Exception -> 0x0074 }
            java.lang.Object r1 = r3.m     // Catch:{ InterruptedException -> 0x0064 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0064 }
            goto L_0x0064
        L_0x0062:
            r1 = move-exception
            goto L_0x0066
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            goto L_0x0024
        L_0x0066:
            monitor-exit(r0)     // Catch:{ all -> 0x0062 }
            throw r1     // Catch:{ Exception -> 0x0074 }
        L_0x0068:
            r3.h()     // Catch:{ Exception -> 0x0074 }
            r3.e()     // Catch:{ Exception -> 0x0074 }
            r3.j()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0078
        L_0x0072:
            r0 = move-exception
            goto L_0x0079
        L_0x0074:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0072 }
        L_0x0078:
            return
        L_0x0079:
            goto L_0x007b
        L_0x007a:
            throw r0
        L_0x007b:
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.b.run():void");
    }

    public EGLContext a() {
        return this.f31916e;
    }

    public void b() {
        this.j = false;
        c();
    }

    public void c() {
        synchronized (this.m) {
            this.m.notifyAll();
        }
    }

    private void d() {
        try {
            a aVar = (a) this.f31914c.get();
            if (aVar != null) {
                aVar.c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        try {
            a aVar = (a) this.f31914c.get();
            if (aVar != null) {
                aVar.d();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean f() {
        try {
            if (this.f31914c == null) {
                return false;
            }
            a aVar = (a) this.f31914c.get();
            if (aVar != null) {
                return aVar.e();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void g() {
        WeakReference<a> weakReference = this.f31914c;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.o();
            }
        }
    }

    private void h() {
        WeakReference<a> weakReference = this.f31914c;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    private void i() {
        a aVar = (a) this.f31914c.get();
        if (aVar != null) {
            this.f31915d = (EGL10) EGLContext.getEGL();
            this.f31917f = this.f31915d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f31915d.eglInitialize(this.f31917f, new int[2]);
            this.h = k();
            SurfaceTexture f2 = aVar.f();
            if (f2 != null) {
                this.i = new WeakReference<>(f2);
                this.f31918g = this.f31915d.eglCreateWindowSurface(this.f31917f, this.h, f2, (int[]) null);
            } else {
                this.f31918g = this.f31915d.eglCreatePbufferSurface(this.f31917f, this.h, new int[]{12375, this.k, 12374, this.l, 12344});
            }
            this.f31916e = a(this.f31915d, this.f31917f, this.h, EGL10.EGL_NO_CONTEXT);
            TXCLog.w("TXCVideoRenderThread", "vrender: init egl @context=" + this.f31916e + ",surface=" + this.f31918g);
            try {
                if (this.f31918g == null || this.f31918g == EGL10.EGL_NO_SURFACE) {
                    throw new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.f31915d.eglGetError()));
                } else if (!this.f31915d.eglMakeCurrent(this.f31917f, this.f31918g, this.f31918g, this.f31916e)) {
                    throw new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.f31915d.eglGetError()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void j() {
        this.f31915d.eglMakeCurrent(this.f31917f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.f31915d.eglDestroyContext(this.f31917f, this.f31916e);
        this.f31915d.eglDestroySurface(this.f31917f, this.f31918g);
        this.f31915d.eglTerminate(this.f31917f);
        this.i = null;
        TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.f31916e + ",surface=" + this.f31918g);
    }

    private EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{this.f31912a, 2, 12344});
    }

    private EGLConfig k() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f31915d.eglChooseConfig(this.f31917f, l(), eGLConfigArr, 1, iArr)) {
            throw new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.f31915d.eglGetError()));
        } else if (iArr[0] > 0) {
            return eGLConfigArr[0];
        } else {
            return null;
        }
    }

    private int[] l() {
        return new int[]{12352, this.f31913b, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }
}
