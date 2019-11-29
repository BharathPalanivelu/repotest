package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceViewBase extends SurfaceView implements SurfaceHolder.Callback {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final j f31870a = new j();

    /* renamed from: b  reason: collision with root package name */
    protected boolean f31871b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f31872c = false;

    /* renamed from: d  reason: collision with root package name */
    protected final WeakReference<TXCGLSurfaceViewBase> f31873d = new WeakReference<>(this);

    /* renamed from: e  reason: collision with root package name */
    protected boolean f31874e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f31875f;

    /* renamed from: g  reason: collision with root package name */
    private i f31876g;
    /* access modifiers changed from: private */
    public GLSurfaceView.Renderer h;
    private boolean i;
    /* access modifiers changed from: private */
    public e j;
    /* access modifiers changed from: private */
    public f k;
    /* access modifiers changed from: private */
    public g l;
    /* access modifiers changed from: private */
    public k m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public boolean p;

    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface k {
        GL a(GL gl);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public int c() {
        return 0;
    }

    public TXCGLSurfaceViewBase(Context context) {
        super(context);
        a();
    }

    public TXCGLSurfaceViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f31876g != null) {
                this.f31876g.g();
            }
        } finally {
            super.finalize();
        }
    }

    private void a() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(k kVar) {
        this.m = kVar;
    }

    public void setDebugFlags(int i2) {
        this.n = i2;
    }

    public int getDebugFlags() {
        return this.n;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.p = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.p;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        f();
        if (this.j == null) {
            this.j = new m(true);
        }
        if (this.k == null) {
            this.k = new c();
        }
        if (this.l == null) {
            this.l = new d();
        }
        this.h = renderer;
        this.f31876g = new i(this.f31873d);
        this.f31876g.start();
        TXCLog.i("TXCGLSurfaceViewBase", "setRenderer-->mGLThread.start");
    }

    public void setEGLContextFactory(f fVar) {
        f();
        this.k = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        f();
        this.l = gVar;
    }

    public void setEGLConfigChooser(e eVar) {
        f();
        this.j = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((e) new m(z));
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser((e) new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLContextClientVersion(int i2) {
        f();
        this.o = i2;
    }

    public void setRenderMode(int i2) {
        this.f31876g.a(i2);
    }

    public int getRenderMode() {
        return this.f31876g.d();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f31876g.e();
        setRunInBackground(false);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        setRunInBackground(true);
        if (!this.f31871b) {
            this.f31876g.a((Runnable) new Runnable() {
                public void run() {
                    TXCGLSurfaceViewBase.this.b();
                }
            });
            this.f31876g.f();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.f31876g.a(i3, i4);
    }

    public void b(boolean z) {
        this.f31871b = z;
        if (!this.f31871b && this.f31872c && this.f31876g != null) {
            TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
            this.f31876g.a((Runnable) new Runnable() {
                public void run() {
                    TXCGLSurfaceViewBase.this.b();
                }
            });
            this.f31876g.f();
        }
    }

    /* access modifiers changed from: protected */
    public void setRunInBackground(boolean z) {
        this.f31872c = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.h != null) {
            i iVar = this.f31876g;
            int d2 = iVar != null ? iVar.d() : 1;
            this.f31876g = new i(this.f31873d);
            if (d2 != 1) {
                this.f31876g.a(d2);
            }
            this.f31876g.start();
        }
        this.i = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        i iVar = this.f31876g;
        if (iVar != null) {
            iVar.g();
        }
        this.i = true;
        super.onDetachedFromWindow();
    }

    static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f31894a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f31895b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31896c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31897d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31898e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f31899f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f31900g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l = 0;
        private int m = 0;
        private int n = 1;
        private boolean o = true;
        private boolean p;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private h s;
        private WeakReference<TXCGLSurfaceViewBase> t;

        i(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            this.t = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                i();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                TXCGLSurfaceViewBase.f31870a.a(this);
                throw th;
            }
            TXCGLSurfaceViewBase.f31870a.a(this);
        }

        public int a() {
            return this.s.c();
        }

        public h b() {
            return this.s;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0163, code lost:
            if (r1.s.b() == false) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0165, code lost:
            r10 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0169, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
            r1.j = true;
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0174, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0175, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x017a, code lost:
            r15 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x017e, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
            r1.j = true;
            r1.f31899f = true;
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x018b, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x0191, code lost:
            if (r11 == false) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x0193, code lost:
            r0 = (javax.microedition.khronos.opengles.GL10) r1.s.d();
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e().a(r0);
            r6 = r0;
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01a4, code lost:
            if (r9 == false) goto L_0x01bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x01a6, code lost:
            r0 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r1.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ae, code lost:
            if (r0 == null) goto L_0x01bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01b0, code lost:
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.b(r0).onSurfaceCreated(r6, r1.s.f31891d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01bb, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01bc, code lost:
            if (r12 == false) goto L_0x01d0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01be, code lost:
            r0 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r1.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01c6, code lost:
            if (r0 == null) goto L_0x01cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01c8, code lost:
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.b(r0).onSurfaceChanged(r6, r7, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01cf, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01d0, code lost:
            r0 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r1.t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01da, code lost:
            if (r0 == null) goto L_0x01e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x01dc, code lost:
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.b(r0).onDrawFrame(r6);
            r0 = r0.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x01e8, code lost:
            r0 = 12288;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x01ea, code lost:
            if (r0 == 12288) goto L_0x020e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x01ee, code lost:
            if (r0 == 12302) goto L_0x020b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f0, code lost:
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.h.a("GLThread", "eglSwapBuffers", r0);
            r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x01fb, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
            r1.f31899f = true;
            com.tencent.liteav.renderer.TXCGLSurfaceViewBase.e().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x0206, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x020b, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x020f, code lost:
            if (r13 == false) goto L_0x0212;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0211, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0153, code lost:
            if (r14 == null) goto L_0x015b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x015b, code lost:
            if (r10 == false) goto L_0x0191;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void i() throws java.lang.InterruptedException {
            /*
                r16 = this;
                r1 = r16
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h r0 = new com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h
                java.lang.ref.WeakReference<com.tencent.liteav.renderer.TXCGLSurfaceViewBase> r2 = r1.t
                r0.<init>(r2)
                r1.s = r0
                r0 = 0
                r1.h = r0
                r1.i = r0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
            L_0x001b:
                r14 = 0
            L_0x001c:
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r15 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0223 }
                monitor-enter(r15)     // Catch:{ all -> 0x0223 }
            L_0x0021:
                boolean r2 = r1.f31894a     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x0036
                monitor-exit(r15)     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a
                monitor-enter(r2)
                r16.j()     // Catch:{ all -> 0x0033 }
                r16.k()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0
            L_0x0036:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.q     // Catch:{ all -> 0x0220 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0220 }
                if (r2 != 0) goto L_0x004b
                java.util.ArrayList<java.lang.Runnable> r2 = r1.q     // Catch:{ all -> 0x0220 }
                r14 = 0
                java.lang.Object r2 = r2.remove(r14)     // Catch:{ all -> 0x0220 }
                java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x0220 }
                r14 = r2
                r2 = 0
                goto L_0x0152
            L_0x004b:
                boolean r2 = r1.f31897d     // Catch:{ all -> 0x0220 }
                boolean r0 = r1.f31896c     // Catch:{ all -> 0x0220 }
                if (r2 == r0) goto L_0x005f
                boolean r0 = r1.f31896c     // Catch:{ all -> 0x0220 }
                boolean r2 = r1.f31896c     // Catch:{ all -> 0x0220 }
                r1.f31897d = r2     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r2.notifyAll()     // Catch:{ all -> 0x0220 }
                goto L_0x0060
            L_0x005f:
                r0 = 0
            L_0x0060:
                boolean r2 = r1.k     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x006e
                r16.j()     // Catch:{ all -> 0x0220 }
                r16.k()     // Catch:{ all -> 0x0220 }
                r2 = 0
                r1.k = r2     // Catch:{ all -> 0x0220 }
                r5 = 1
            L_0x006e:
                if (r3 == 0) goto L_0x0077
                r16.j()     // Catch:{ all -> 0x0220 }
                r16.k()     // Catch:{ all -> 0x0220 }
                r3 = 0
            L_0x0077:
                if (r0 == 0) goto L_0x0080
                boolean r2 = r1.i     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x0080
                r16.j()     // Catch:{ all -> 0x0220 }
            L_0x0080:
                if (r0 == 0) goto L_0x00a5
                boolean r2 = r1.h     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x00a5
                java.lang.ref.WeakReference<com.tencent.liteav.renderer.TXCGLSurfaceViewBase> r2 = r1.t     // Catch:{ all -> 0x0220 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase r2 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r2     // Catch:{ all -> 0x0220 }
                if (r2 != 0) goto L_0x0092
                r2 = 0
                goto L_0x0096
            L_0x0092:
                boolean r2 = r2.p     // Catch:{ all -> 0x0220 }
            L_0x0096:
                if (r2 == 0) goto L_0x00a2
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                boolean r2 = r2.a()     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x00a5
            L_0x00a2:
                r16.k()     // Catch:{ all -> 0x0220 }
            L_0x00a5:
                if (r0 == 0) goto L_0x00b6
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                boolean r0 = r0.b()     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x00b6
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h r0 = r1.s     // Catch:{ all -> 0x0220 }
                r0.g()     // Catch:{ all -> 0x0220 }
            L_0x00b6:
                boolean r0 = r1.f31898e     // Catch:{ all -> 0x0220 }
                if (r0 != 0) goto L_0x00d2
                boolean r0 = r1.f31900g     // Catch:{ all -> 0x0220 }
                if (r0 != 0) goto L_0x00d2
                boolean r0 = r1.i     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x00c5
                r16.j()     // Catch:{ all -> 0x0220 }
            L_0x00c5:
                r0 = 1
                r1.f31900g = r0     // Catch:{ all -> 0x0220 }
                r0 = 0
                r1.f31899f = r0     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r0.notifyAll()     // Catch:{ all -> 0x0220 }
            L_0x00d2:
                boolean r0 = r1.f31898e     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x00e4
                boolean r0 = r1.f31900g     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x00e4
                r0 = 0
                r1.f31900g = r0     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r0.notifyAll()     // Catch:{ all -> 0x0220 }
            L_0x00e4:
                if (r4 == 0) goto L_0x00f2
                r0 = 1
                r1.p = r0     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r0.notifyAll()     // Catch:{ all -> 0x0220 }
                r4 = 0
                r13 = 0
            L_0x00f2:
                boolean r0 = r16.l()     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x0216
                boolean r0 = r1.h     // Catch:{ all -> 0x0220 }
                if (r0 != 0) goto L_0x0124
                if (r5 == 0) goto L_0x0100
                r5 = 0
                goto L_0x0124
            L_0x0100:
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                boolean r0 = r0.b(r1)     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x0124
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h r0 = r1.s     // Catch:{ RuntimeException -> 0x011b }
                r0.a()     // Catch:{ RuntimeException -> 0x011b }
                r0 = 1
                r1.h = r0     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r0.notifyAll()     // Catch:{ all -> 0x0220 }
                r9 = 1
                goto L_0x0124
            L_0x011b:
                r0 = move-exception
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r2.c(r1)     // Catch:{ all -> 0x0220 }
                throw r0     // Catch:{ all -> 0x0220 }
            L_0x0124:
                boolean r0 = r1.h     // Catch:{ all -> 0x0220 }
                if (r0 == 0) goto L_0x0133
                boolean r0 = r1.i     // Catch:{ all -> 0x0220 }
                if (r0 != 0) goto L_0x0133
                r0 = 1
                r1.i = r0     // Catch:{ all -> 0x0220 }
                r0 = 1
                r11 = 1
                r12 = 1
                goto L_0x0134
            L_0x0133:
                r0 = r10
            L_0x0134:
                boolean r2 = r1.i     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x0215
                boolean r2 = r1.r     // Catch:{ all -> 0x0220 }
                if (r2 == 0) goto L_0x0147
                int r7 = r1.l     // Catch:{ all -> 0x0220 }
                int r8 = r1.m     // Catch:{ all -> 0x0220 }
                r2 = 0
                r1.r = r2     // Catch:{ all -> 0x0220 }
                r0 = 1
                r12 = 1
                r13 = 1
                goto L_0x0148
            L_0x0147:
                r2 = 0
            L_0x0148:
                r1.o = r2     // Catch:{ all -> 0x0220 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r10 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r10.notifyAll()     // Catch:{ all -> 0x0220 }
                r10 = r0
            L_0x0152:
                monitor-exit(r15)     // Catch:{ all -> 0x0220 }
                if (r14 == 0) goto L_0x015b
                r14.run()     // Catch:{ all -> 0x0223 }
                r0 = 0
                goto L_0x001b
            L_0x015b:
                if (r10 == 0) goto L_0x0191
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h r0 = r1.s     // Catch:{ all -> 0x0223 }
                boolean r0 = r0.b()     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x017a
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r10 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0223 }
                monitor-enter(r10)     // Catch:{ all -> 0x0223 }
                r0 = 1
                r1.j = r0     // Catch:{ all -> 0x0177 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0177 }
                r0.notifyAll()     // Catch:{ all -> 0x0177 }
                monitor-exit(r10)     // Catch:{ all -> 0x0177 }
                r10 = 0
                goto L_0x0191
            L_0x0177:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x0177 }
                throw r0     // Catch:{ all -> 0x0223 }
            L_0x017a:
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r15 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0223 }
                monitor-enter(r15)     // Catch:{ all -> 0x0223 }
                r0 = 1
                r1.j = r0     // Catch:{ all -> 0x018e }
                r1.f31899f = r0     // Catch:{ all -> 0x018e }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x018e }
                r0.notifyAll()     // Catch:{ all -> 0x018e }
                monitor-exit(r15)     // Catch:{ all -> 0x018e }
                goto L_0x0212
            L_0x018e:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x018e }
                throw r0     // Catch:{ all -> 0x0223 }
            L_0x0191:
                if (r11 == 0) goto L_0x01a4
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h r0 = r1.s     // Catch:{ all -> 0x0223 }
                javax.microedition.khronos.opengles.GL r0 = r0.d()     // Catch:{ all -> 0x0223 }
                javax.microedition.khronos.opengles.GL10 r0 = (javax.microedition.khronos.opengles.GL10) r0     // Catch:{ all -> 0x0223 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r6 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0223 }
                r6.a((javax.microedition.khronos.opengles.GL10) r0)     // Catch:{ all -> 0x0223 }
                r6 = r0
                r11 = 0
            L_0x01a4:
                if (r9 == 0) goto L_0x01bc
                java.lang.ref.WeakReference<com.tencent.liteav.renderer.TXCGLSurfaceViewBase> r0 = r1.t     // Catch:{ all -> 0x0223 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0223 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase r0 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r0     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x01bb
                android.opengl.GLSurfaceView$Renderer r0 = r0.h     // Catch:{ all -> 0x0223 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h r9 = r1.s     // Catch:{ all -> 0x0223 }
                javax.microedition.khronos.egl.EGLConfig r9 = r9.f31891d     // Catch:{ all -> 0x0223 }
                r0.onSurfaceCreated(r6, r9)     // Catch:{ all -> 0x0223 }
            L_0x01bb:
                r9 = 0
            L_0x01bc:
                if (r12 == 0) goto L_0x01d0
                java.lang.ref.WeakReference<com.tencent.liteav.renderer.TXCGLSurfaceViewBase> r0 = r1.t     // Catch:{ all -> 0x0223 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0223 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase r0 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r0     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x01cf
                android.opengl.GLSurfaceView$Renderer r0 = r0.h     // Catch:{ all -> 0x0223 }
                r0.onSurfaceChanged(r6, r7, r8)     // Catch:{ all -> 0x0223 }
            L_0x01cf:
                r12 = 0
            L_0x01d0:
                java.lang.ref.WeakReference<com.tencent.liteav.renderer.TXCGLSurfaceViewBase> r0 = r1.t     // Catch:{ all -> 0x0223 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0223 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase r0 = (com.tencent.liteav.renderer.TXCGLSurfaceViewBase) r0     // Catch:{ all -> 0x0223 }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r0 == 0) goto L_0x01e8
                android.opengl.GLSurfaceView$Renderer r2 = r0.h     // Catch:{ all -> 0x0223 }
                r2.onDrawFrame(r6)     // Catch:{ all -> 0x0223 }
                int r0 = r0.c()     // Catch:{ all -> 0x0223 }
                goto L_0x01ea
            L_0x01e8:
                r0 = 12288(0x3000, float:1.7219E-41)
            L_0x01ea:
                if (r0 == r15) goto L_0x020e
                r2 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r2) goto L_0x020b
                java.lang.String r2 = "GLThread"
                java.lang.String r15 = "eglSwapBuffers"
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase.h.a(r2, r15, r0)     // Catch:{ all -> 0x0223 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0223 }
                monitor-enter(r2)     // Catch:{ all -> 0x0223 }
                r0 = 1
                r1.f31899f = r0     // Catch:{ all -> 0x0208 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r15 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0208 }
                r15.notifyAll()     // Catch:{ all -> 0x0208 }
                monitor-exit(r2)     // Catch:{ all -> 0x0208 }
                goto L_0x020f
            L_0x0208:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0208 }
                throw r0     // Catch:{ all -> 0x0223 }
            L_0x020b:
                r0 = 1
                r3 = 1
                goto L_0x020f
            L_0x020e:
                r0 = 1
            L_0x020f:
                if (r13 == 0) goto L_0x0212
                r4 = 1
            L_0x0212:
                r0 = 0
                goto L_0x001c
            L_0x0215:
                r10 = r0
            L_0x0216:
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0220 }
                r0.wait()     // Catch:{ all -> 0x0220 }
                r0 = 0
                goto L_0x0021
            L_0x0220:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0220 }
                throw r0     // Catch:{ all -> 0x0223 }
            L_0x0223:
                r0 = move-exception
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a
                monitor-enter(r2)
                r16.j()     // Catch:{ all -> 0x0231 }
                r16.k()     // Catch:{ all -> 0x0231 }
                monitor-exit(r2)     // Catch:{ all -> 0x0231 }
                throw r0
            L_0x0231:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0231 }
                goto L_0x0235
            L_0x0234:
                throw r0
            L_0x0235:
                goto L_0x0234
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i.i():void");
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.s.f();
            }
        }

        private void k() {
            if (this.h) {
                this.s.g();
                this.h = false;
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.t.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f31875f = false;
                }
                TXCGLSurfaceViewBase.f31870a.c(this);
            }
        }

        public boolean c() {
            return this.h && this.i && l();
        }

        private boolean l() {
            return !this.f31897d && this.f31898e && !this.f31899f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (TXCGLSurfaceViewBase.f31870a) {
                this.n = i2;
                TXCGLSurfaceViewBase.f31870a.notifyAll();
            }
        }

        public int d() {
            int i2;
            synchronized (TXCGLSurfaceViewBase.f31870a) {
                i2 = this.n;
            }
            return i2;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r2 = this;
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a
                monitor-enter(r0)
                r1 = 1
                r2.f31898e = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.j = r1     // Catch:{ all -> 0x0030 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r1 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.f31900g     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.j     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.f31895b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r1 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                goto L_0x0034
            L_0x0033:
                throw r1
            L_0x0034:
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i.e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
                r2 = this;
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a
                monitor-enter(r0)
                r1 = 0
                r2.f31898e = r1     // Catch:{ all -> 0x0029 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r1 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.f31900g     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.f31895b     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r1 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                goto L_0x002d
            L_0x002c:
                throw r1
            L_0x002d:
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i.f():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|27|21|4) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0032 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r2, int r3) {
            /*
                r1 = this;
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a
                monitor-enter(r0)
                r1.l = r2     // Catch:{ all -> 0x003c }
                r1.m = r3     // Catch:{ all -> 0x003c }
                r2 = 1
                r1.r = r2     // Catch:{ all -> 0x003c }
                r1.o = r2     // Catch:{ all -> 0x003c }
                r2 = 0
                r1.p = r2     // Catch:{ all -> 0x003c }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x003c }
                r2.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x0018:
                boolean r2 = r1.f31895b     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.f31897d     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.p     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.c()     // Catch:{ all -> 0x003c }
                if (r2 == 0) goto L_0x003a
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r2 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ InterruptedException -> 0x0032 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0032 }
                goto L_0x0018
            L_0x0032:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003c }
                r2.interrupt()     // Catch:{ all -> 0x003c }
                goto L_0x0018
            L_0x003a:
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                return
            L_0x003c:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                goto L_0x0040
            L_0x003f:
                throw r2
            L_0x0040:
                goto L_0x003f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i.a(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r2 = this;
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r0 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a
                monitor-enter(r0)
                r1 = 1
                r2.f31894a = r1     // Catch:{ all -> 0x0025 }
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r1 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.f31895b     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j r1 = com.tencent.liteav.renderer.TXCGLSurfaceViewBase.f31870a     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                goto L_0x0029
            L_0x0028:
                throw r1
            L_0x0029:
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceViewBase.i.g():void");
        }

        public void h() {
            this.k = true;
            TXCGLSurfaceViewBase.f31870a.notifyAll();
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (TXCGLSurfaceViewBase.f31870a) {
                    this.q.add(runnable);
                    TXCGLSurfaceViewBase.f31870a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f31908a = new StringBuilder();

        l() {
        }

        public void close() {
            a();
        }

        public void flush() {
            a();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i + i3];
                if (c2 == 10) {
                    a();
                } else {
                    this.f31908a.append(c2);
                }
            }
        }

        private void a() {
            if (this.f31908a.length() > 0) {
                TXCLog.v("TXCGLSurfaceViewBase", this.f31908a.toString());
                StringBuilder sb = this.f31908a;
                sb.delete(0, sb.length());
            }
        }
    }

    private void f() {
        if (this.f31876g != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        private static String f31901a = "GLThreadManager";

        /* renamed from: b  reason: collision with root package name */
        private boolean f31902b;

        /* renamed from: c  reason: collision with root package name */
        private int f31903c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31904d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31905e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f31906f;

        /* renamed from: g  reason: collision with root package name */
        private i f31907g;

        private j() {
        }

        public synchronized void a(i iVar) {
            boolean unused = iVar.f31895b = true;
            if (this.f31907g == iVar) {
                this.f31907g = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            i iVar2 = this.f31907g;
            if (iVar2 == iVar || iVar2 == null) {
                this.f31907g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.f31905e) {
                return true;
            }
            i iVar3 = this.f31907g;
            if (iVar3 == null) {
                return false;
            }
            iVar3.h();
            return false;
        }

        public void c(i iVar) {
            if (this.f31907g == iVar) {
                this.f31907g = null;
            }
            notifyAll();
        }

        public synchronized boolean a() {
            return this.f31906f;
        }

        public synchronized boolean b() {
            c();
            return !this.f31905e;
        }

        public synchronized void a(GL10 gl10) {
            if (!this.f31904d) {
                c();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.f31903c < 131072) {
                    this.f31905e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (!this.f31905e) {
                    z = true;
                }
                this.f31906f = z;
                this.f31904d = true;
            }
        }

        private void c() {
            this.f31903c = 131072;
            this.f31905e = true;
            this.f31902b = true;
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f31888a;

        /* renamed from: b  reason: collision with root package name */
        EGLDisplay f31889b;

        /* renamed from: c  reason: collision with root package name */
        EGLSurface f31890c;

        /* renamed from: d  reason: collision with root package name */
        EGLConfig f31891d;

        /* renamed from: e  reason: collision with root package name */
        EGLContext f31892e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<TXCGLSurfaceViewBase> f31893f;

        public h(WeakReference<TXCGLSurfaceViewBase> weakReference) {
            this.f31893f = weakReference;
        }

        public void a() {
            this.f31888a = (EGL10) EGLContext.getEGL();
            this.f31889b = this.f31888a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f31889b != EGL10.EGL_NO_DISPLAY) {
                if (this.f31888a.eglInitialize(this.f31889b, new int[2])) {
                    TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f31893f.get();
                    if (tXCGLSurfaceViewBase == null) {
                        this.f31891d = null;
                        this.f31892e = null;
                    } else {
                        this.f31891d = tXCGLSurfaceViewBase.j.a(this.f31888a, this.f31889b);
                        this.f31892e = tXCGLSurfaceViewBase.k.a(this.f31888a, this.f31889b, this.f31891d);
                    }
                    EGLContext eGLContext = this.f31892e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f31892e = null;
                        a("createContext");
                    }
                    if (tXCGLSurfaceViewBase != null) {
                        tXCGLSurfaceViewBase.f31875f = true;
                    }
                    this.f31890c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            if (this.f31888a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f31889b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.f31891d != null) {
                h();
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f31893f.get();
                if (tXCGLSurfaceViewBase != null) {
                    this.f31890c = tXCGLSurfaceViewBase.l.a(this.f31888a, this.f31889b, this.f31891d, tXCGLSurfaceViewBase.getHolder());
                } else {
                    this.f31890c = null;
                }
                EGLSurface eGLSurface = this.f31890c;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.f31888a.eglGetError() == 12299) {
                        TXCLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.f31888a;
                EGLDisplay eGLDisplay = this.f31889b;
                EGLSurface eGLSurface2 = this.f31890c;
                if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.f31892e)) {
                    a("EGLHelper", "eglMakeCurrent", this.f31888a.eglGetError());
                    return false;
                }
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.f31874e = true;
                }
                return true;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        public int c() {
            return e();
        }

        /* access modifiers changed from: package-private */
        public GL d() {
            GL gl = this.f31892e.getGL();
            TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f31893f.get();
            if (tXCGLSurfaceViewBase == null) {
                return gl;
            }
            if (tXCGLSurfaceViewBase.m != null) {
                gl = tXCGLSurfaceViewBase.m.a(gl);
            }
            if ((tXCGLSurfaceViewBase.n & 3) == 0) {
                return gl;
            }
            int i = 0;
            l lVar = null;
            if ((tXCGLSurfaceViewBase.n & 1) != 0) {
                i = 1;
            }
            if ((tXCGLSurfaceViewBase.n & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl, i, lVar);
        }

        public int e() {
            if (!this.f31888a.eglSwapBuffers(this.f31889b, this.f31890c)) {
                return this.f31888a.eglGetError();
            }
            return 12288;
        }

        public void f() {
            h();
        }

        private void h() {
            EGLSurface eGLSurface = this.f31890c;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.f31888a.eglMakeCurrent(this.f31889b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f31893f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.l.a(this.f31888a, this.f31889b, this.f31890c);
                    tXCGLSurfaceViewBase.f31874e = false;
                }
                this.f31890c = null;
            }
        }

        public void g() {
            if (this.f31892e != null) {
                TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase) this.f31893f.get();
                if (tXCGLSurfaceViewBase != null) {
                    tXCGLSurfaceViewBase.k.a(this.f31888a, this.f31889b, this.f31892e);
                }
                this.f31892e = null;
            }
            EGLDisplay eGLDisplay = this.f31889b;
            if (eGLDisplay != null) {
                this.f31888a.eglTerminate(eGLDisplay);
                this.f31889b = null;
            }
        }

        private void a(String str) {
            a(str, this.f31888a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            TXCLog.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }
    }

    private class b extends a {

        /* renamed from: c  reason: collision with root package name */
        protected int f31881c;

        /* renamed from: d  reason: collision with root package name */
        protected int f31882d;

        /* renamed from: e  reason: collision with root package name */
        protected int f31883e;

        /* renamed from: f  reason: collision with root package name */
        protected int f31884f;

        /* renamed from: g  reason: collision with root package name */
        protected int f31885g;
        protected int h;
        private int[] j = new int[1];

        public b(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344});
            this.f31881c = i2;
            this.f31882d = i3;
            this.f31883e = i4;
            this.f31884f = i5;
            this.f31885g = i6;
            this.h = i7;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int a2 = a(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int a3 = a(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (a2 >= this.f31885g && a3 >= this.h) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int a4 = a(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int a5 = a(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int a6 = a(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int a7 = a(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (a4 == this.f31881c && a5 == this.f31882d && a6 == this.f31883e && a7 == this.f31884f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.j) ? this.j[0] : i3;
        }
    }

    private class m extends b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    private class c implements f {

        /* renamed from: b  reason: collision with root package name */
        private int f31887b;

        private c() {
            this.f31887b = 12440;
        }

        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f31887b, TXCGLSurfaceViewBase.this.o, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TXCGLSurfaceViewBase.this.o == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                TXCLog.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    private static class d implements g {
        private d() {
        }

        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e2) {
                TXCLog.e("TXCGLSurfaceViewBase", "eglCreateWindowSurface");
                TXCLog.e("TXCGLSurfaceViewBase", e2.toString());
                return null;
            }
        }

        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f31879a;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.f31879a = a(iArr);
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f31879a, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f31879a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] a(int[] iArr) {
            if (TXCGLSurfaceViewBase.this.o != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    public int d() {
        return this.f31876g.a();
    }

    public h getEGLHelper() {
        return this.f31876g.b();
    }
}
