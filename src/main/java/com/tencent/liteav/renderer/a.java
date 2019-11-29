package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class a extends e implements SurfaceTexture.OnFrameAvailableListener {
    private TXSVideoFrame A;
    private TXCYuvTextureRender B;
    private final Queue<Runnable> C = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    g f31909a;

    /* renamed from: b  reason: collision with root package name */
    C0490a f31910b;

    /* renamed from: c  reason: collision with root package name */
    C0490a f31911c;
    private final int p = 0;
    private final int q = 0;
    private final int r = 0;
    private final int s = 0;
    private Object t = new Object();
    private b u;
    private SurfaceTexture v;
    private c w;
    private boolean x;
    private float[] y = new float[16];
    private c z;

    /* renamed from: com.tencent.liteav.renderer.a$a  reason: collision with other inner class name */
    public interface C0490a {
        void onTextureProcess(int i, int i2, int i3);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void a(g gVar) {
        this.f31909a = gVar;
    }

    public void a(C0490a aVar) {
        this.f31910b = aVar;
        if (aVar != null) {
            TXCYuvTextureRender tXCYuvTextureRender = this.B;
            if (tXCYuvTextureRender != null) {
                tXCYuvTextureRender.setHasFrameBuffer(this.h, this.i);
            }
        }
    }

    public void b(C0490a aVar) {
        this.f31911c = aVar;
        if (aVar != null) {
            TXCYuvTextureRender tXCYuvTextureRender = this.B;
            if (tXCYuvTextureRender != null) {
                tXCYuvTextureRender.setHasFrameBuffer(this.h, this.i);
            }
        }
    }

    public void a(TXSVideoFrame tXSVideoFrame, int i, int i2, int i3) {
        synchronized (this) {
            this.A = tXSVideoFrame;
        }
        super.a(tXSVideoFrame, i, i2, i3);
        b bVar = this.u;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(int i, int i2, int i3, boolean z2, int i4) {
        GLES20.glViewport(0, 0, k(), l());
        c cVar = this.z;
        if (cVar != null) {
            cVar.a(i, z2, i4);
        }
        super.a(i, i2, i3, z2, i4);
        b bVar = this.u;
        if (bVar != null) {
            bVar.c();
        }
    }

    public SurfaceTexture a() {
        return this.v;
    }

    public EGLContext b() {
        EGLContext a2;
        synchronized (this.t) {
            a2 = this.u != null ? this.u.a() : null;
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a(SurfaceTexture surfaceTexture) {
        g();
    }

    /* access modifiers changed from: protected */
    public void b(SurfaceTexture surfaceTexture) {
        h();
    }

    /* access modifiers changed from: protected */
    public void a(int i, int i2) {
        super.a(i, i2);
        TXCYuvTextureRender tXCYuvTextureRender = this.B;
        if (tXCYuvTextureRender != null) {
            tXCYuvTextureRender.setVideoSize(i, i2);
        }
        c cVar = this.w;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender initTextureRender");
        s();
        if (this.f31942e != null) {
            this.f31942e.a(this.f31943f, this.f31944g);
            this.f31942e.b(this.h, this.i);
        }
        c cVar = this.w;
        if (cVar != null) {
            cVar.b();
            this.v = new SurfaceTexture(this.w.a());
            this.v.setOnFrameAvailableListener(this);
        }
        TXCYuvTextureRender tXCYuvTextureRender = this.B;
        if (tXCYuvTextureRender != null) {
            tXCYuvTextureRender.createTexture();
        }
        if (this.f31910b != null) {
            TXCYuvTextureRender tXCYuvTextureRender2 = this.B;
            if (tXCYuvTextureRender2 != null) {
                tXCYuvTextureRender2.setHasFrameBuffer(this.h, this.i);
            }
        }
        c cVar2 = this.z;
        if (cVar2 != null) {
            cVar2.b();
        }
        if (this.n != null) {
            this.n.onSurfaceTextureAvailable(this.v);
        }
    }

    private void s() {
        this.w = new c(true);
        this.B = new TXCYuvTextureRender();
        this.z = new c(false);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        try {
            if (this.n != null) {
                this.n.onSurfaceTextureDestroy(this.v);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c cVar = this.w;
        if (cVar != null) {
            cVar.c();
            this.w = null;
        }
        TXCYuvTextureRender tXCYuvTextureRender = this.B;
        if (tXCYuvTextureRender != null) {
            tXCYuvTextureRender.onSurfaceDestroy();
            this.B = null;
        }
        c cVar2 = this.z;
        if (cVar2 != null) {
            cVar2.c();
            this.z = null;
        }
        this.v = null;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        do {
        } while (a(this.C));
        return t();
    }

    /* access modifiers changed from: package-private */
    public SurfaceTexture f() {
        if (this.f31941d != null) {
            return this.f31941d.getSurfaceTexture();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void g() {
        synchronized (this.t) {
            if (this.u == null) {
                this.u = new b(new WeakReference(this));
                this.u.start();
                this.u.c();
                TXCLog.w("TXCVideoRender", "play:vrender: start render thread id " + getID() + ", " + this);
            } else {
                TXCLog.w("TXCVideoRender", "play:vrender: render thread is running " + getID() + ", " + this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        synchronized (this.t) {
            if (this.u != null) {
                this.u.b();
                this.u.c();
                this.u = null;
                TXCLog.w("TXCVideoRender", "play:vrender: quit render thread id" + getID() + ", " + this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r10.k != 1) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r4 = b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0 == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        r0 = r10.v;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        r0.updateTexImage();
        r10.v.getTransformMatrix(r10.y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        r0 = r10.f31909a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r0 == null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r1 = r10.w;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r1 == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        r0.a(r1.a(), r10.y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r0 = r10.w;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (r0 == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r0.a(r10.v);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        r0 = r10.f31911c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r0.onTextureProcess(r10.w.a(), m(), n());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r10.k != 1) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        r0 = r10.w;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r0 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
        a(r4, r0.a(), r10.y, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (r3 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0082, code lost:
        r0 = r10.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r0 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r10.f31910b == null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        r0.setHasFrameBuffer(r10.h, r10.i);
        r0 = r10.B.drawToTexture(r3);
        r10.f31910b.onTextureProcess(r0, m(), n());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        if (r10.k != 0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
        r10.B.drawFrame(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        if (r10.k != 1) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b4, code lost:
        if (r0 != -1) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b6, code lost:
        r10.B.setHasFrameBuffer(r10.h, r10.i);
        r0 = r10.B.drawToTexture(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c5, code lost:
        a(r4, r0, (float[]) null, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        android.opengl.GLES20.glViewport(0, 0, k(), l());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean t() {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.x     // Catch:{ all -> 0x00cb }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x000d
            boolean r0 = r10.x     // Catch:{ all -> 0x00cb }
            r10.x = r2     // Catch:{ all -> 0x00cb }
            r3 = r1
            goto L_0x0017
        L_0x000d:
            com.tencent.liteav.basic.structs.TXSVideoFrame r0 = r10.A     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00c9
            com.tencent.liteav.basic.structs.TXSVideoFrame r0 = r10.A     // Catch:{ all -> 0x00cb }
            r10.A = r1     // Catch:{ all -> 0x00cb }
            r3 = r0
            r0 = 0
        L_0x0017:
            monitor-exit(r10)     // Catch:{ all -> 0x00cb }
            int r4 = r10.k()
            int r5 = r10.l()
            android.opengl.GLES20.glViewport(r2, r2, r4, r5)
            int r4 = r10.k
            r5 = 1
            if (r4 != r5) goto L_0x002d
            javax.microedition.khronos.egl.EGLContext r4 = r10.b()
            goto L_0x002e
        L_0x002d:
            r4 = r1
        L_0x002e:
            if (r0 == 0) goto L_0x0080
            android.graphics.SurfaceTexture r0 = r10.v
            if (r0 == 0) goto L_0x003e
            r0.updateTexImage()
            android.graphics.SurfaceTexture r0 = r10.v
            float[] r1 = r10.y
            r0.getTransformMatrix(r1)
        L_0x003e:
            com.tencent.liteav.renderer.g r0 = r10.f31909a
            if (r0 == 0) goto L_0x0050
            com.tencent.liteav.renderer.c r1 = r10.w
            if (r1 == 0) goto L_0x0059
            int r1 = r1.a()
            float[] r2 = r10.y
            r0.a(r1, r2)
            goto L_0x0059
        L_0x0050:
            com.tencent.liteav.renderer.c r0 = r10.w
            if (r0 == 0) goto L_0x0059
            android.graphics.SurfaceTexture r1 = r10.v
            r0.a((android.graphics.SurfaceTexture) r1)
        L_0x0059:
            com.tencent.liteav.renderer.a$a r0 = r10.f31911c
            if (r0 == 0) goto L_0x006e
            com.tencent.liteav.renderer.c r1 = r10.w
            int r1 = r1.a()
            int r2 = r10.m()
            int r3 = r10.n()
            r0.onTextureProcess(r1, r2, r3)
        L_0x006e:
            int r0 = r10.k
            if (r0 != r5) goto L_0x00c8
            com.tencent.liteav.renderer.c r0 = r10.w
            if (r0 == 0) goto L_0x00c8
            int r0 = r0.a()
            float[] r1 = r10.y
            r10.a((javax.microedition.khronos.egl.EGLContext) r4, (int) r0, (float[]) r1, (boolean) r5)
            goto L_0x00c8
        L_0x0080:
            if (r3 == 0) goto L_0x00c8
            com.tencent.liteav.renderer.TXCYuvTextureRender r0 = r10.B
            if (r0 == 0) goto L_0x00c8
            com.tencent.liteav.renderer.a$a r6 = r10.f31910b
            r7 = -1
            if (r6 == 0) goto L_0x00a6
            int r6 = r10.h
            int r8 = r10.i
            r0.setHasFrameBuffer(r6, r8)
            com.tencent.liteav.renderer.TXCYuvTextureRender r0 = r10.B
            int r0 = r0.drawToTexture(r3)
            com.tencent.liteav.renderer.a$a r6 = r10.f31910b
            int r8 = r10.m()
            int r9 = r10.n()
            r6.onTextureProcess(r0, r8, r9)
            goto L_0x00b0
        L_0x00a6:
            int r0 = r10.k
            if (r0 != 0) goto L_0x00af
            com.tencent.liteav.renderer.TXCYuvTextureRender r0 = r10.B
            r0.drawFrame(r3)
        L_0x00af:
            r0 = -1
        L_0x00b0:
            int r6 = r10.k
            if (r6 != r5) goto L_0x00c8
            if (r0 != r7) goto L_0x00c5
            com.tencent.liteav.renderer.TXCYuvTextureRender r0 = r10.B
            int r6 = r10.h
            int r7 = r10.i
            r0.setHasFrameBuffer(r6, r7)
            com.tencent.liteav.renderer.TXCYuvTextureRender r0 = r10.B
            int r0 = r0.drawToTexture(r3)
        L_0x00c5:
            r10.a((javax.microedition.khronos.egl.EGLContext) r4, (int) r0, (float[]) r1, (boolean) r2)
        L_0x00c8:
            return r5
        L_0x00c9:
            monitor-exit(r10)     // Catch:{ all -> 0x00cb }
            return r2
        L_0x00cb:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00cb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.a.t():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r0.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r3) {
        /*
            r2 = this;
            monitor-enter(r3)
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000a:
            java.lang.Object r0 = r3.poll()     // Catch:{ all -> 0x0019 }
            java.lang.Runnable r0 = (java.lang.Runnable) r0     // Catch:{ all -> 0x0019 }
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0014
            return r1
        L_0x0014:
            r0.run()
            r3 = 1
            return r3
        L_0x0019:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0019 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.a.a(java.util.Queue):boolean");
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.x = true;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
        try {
            h();
        } catch (Exception unused) {
        }
    }
}
