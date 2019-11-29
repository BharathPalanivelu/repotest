package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.d.l;
import com.tencent.liteav.basic.d.m;
import com.tencent.liteav.basic.d.n;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceView extends TXCGLSurfaceViewBase implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, l {
    /* access modifiers changed from: private */
    public n A = null;
    /* access modifiers changed from: private */
    public int B = 0;
    /* access modifiers changed from: private */
    public int C = 0;
    private int D;
    private int E;
    private boolean F = true;
    private boolean G = true;
    private m H;
    private byte[] I = null;
    private long J = 0;
    private int K = 0;
    private int L = 0;
    private final Queue<Runnable> M = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    WeakReference<a> f31856a;

    /* renamed from: g  reason: collision with root package name */
    private SurfaceTexture f31857g;
    private EGLContext h;
    private g i;
    private int[] j;
    private float[] k = new float[16];
    private int l = 0;
    private boolean m = false;
    private float n = 1.0f;
    private float o = 1.0f;
    /* access modifiers changed from: private */
    public int p = 20;
    /* access modifiers changed from: private */
    public long q = 0;
    /* access modifiers changed from: private */
    public long r = 0;
    private int s = 12288;
    private boolean t = true;
    private boolean u = false;
    private Object v = new Object();
    private Handler w;
    private int x = 0;
    private int y = 0;
    private boolean z = true;

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
    }

    public TXCGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
    }

    public TXCGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
    }

    public void setFPS(final int i2) {
        b((Runnable) new Runnable() {
            public void run() {
                int unused = TXCGLSurfaceView.this.p = i2;
                if (TXCGLSurfaceView.this.p <= 0) {
                    int unused2 = TXCGLSurfaceView.this.p = 1;
                } else if (TXCGLSurfaceView.this.p > 60) {
                    int unused3 = TXCGLSurfaceView.this.p = 60;
                }
                long unused4 = TXCGLSurfaceView.this.r = 0;
                long unused5 = TXCGLSurfaceView.this.q = 0;
            }
        });
    }

    public void setRendMode(final int i2) {
        b((Runnable) new Runnable() {
            public void run() {
                int unused = TXCGLSurfaceView.this.B = i2;
                GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
                GLES20.glClear(16640);
            }
        });
    }

    public void setRendMirror(final int i2) {
        b((Runnable) new Runnable() {
            public void run() {
                int unused = TXCGLSurfaceView.this.C = i2;
                GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
                GLES20.glClear(16640);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void b() {
        TXCLog.i("TXCGLSurfaceView", "surfaceDestroyed-->enter with mSurfaceTextureListener:" + this.H);
        m mVar = this.H;
        if (mVar != null) {
            mVar.b(this.f31857g);
        }
        SurfaceTexture surfaceTexture = this.f31857g;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f31857g = null;
        }
    }

    /* access modifiers changed from: protected */
    public void setRunInBackground(boolean z2) {
        if (z2) {
            synchronized (this) {
                TXCLog.d("TXCGLSurfaceView", "background capture enter background");
                this.f31872c = true;
            }
            return;
        }
        b((Runnable) new Runnable() {
            public void run() {
                synchronized (this) {
                    TXCLog.d("TXCGLSurfaceView", "background capture exit background");
                    TXCGLSurfaceView.this.f31872c = false;
                }
            }
        });
    }

    public void setNotifyListener(a aVar) {
        this.f31856a = new WeakReference<>(aVar);
    }

    public void a(n nVar) {
        this.A = nVar;
        this.z = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        android.opengl.GLES20.glClear(16640);
        r3 = getWidth();
        r5 = getHeight();
        r6 = r1.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r6 != 0) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r1.D = 0;
        r1.E = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r6 != 1) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r6 = (720 - r1.l) % 360;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6 == 90) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r6 != 270) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r6 == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r12 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r6 == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        r3 = a(r3, r5, r12, r6);
        r5 = r3[0];
        r6 = r3[1];
        r1.D = r3[2];
        r1.E = r3[3];
        r3 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r1.x = r3;
        r1.y = r5;
        android.opengl.GLES20.glViewport(r1.D, r1.E, r3, r5);
        r6 = r1.C;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        if (r6 != 1) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        if (r2 != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        r6 = !r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        if (r6 != 2) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r2 == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
        r8 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
        if (r5 == 0) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007f, code lost:
        r12 = ((float) r3) / ((float) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        r12 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0085, code lost:
        if (r4 == 0) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0087, code lost:
        r8 = ((float) r19) / ((float) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        r13 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        if (r1.m != r6) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0095, code lost:
        if (r1.l != r0) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009b, code lost:
        if (r1.n != r12) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a1, code lost:
        if (r1.o != r8) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a5, code lost:
        if (r1.F == r2) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a7, code lost:
        r1.m = r6;
        r1.l = r0;
        r1.n = r12;
        r1.o = r8;
        r1.F = r2;
        r0 = (720 - r1.l) % 360;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b7, code lost:
        if (r0 == 90) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b9, code lost:
        if (r0 != 270) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bc, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00be, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bf, code lost:
        if (r12 == false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c1, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c3, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c4, code lost:
        if (r12 == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c7, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c8, code lost:
        r5 = r1.i;
        r6 = com.tencent.liteav.basic.d.k.a(com.tencent.liteav.basic.d.j.f31342a, false, true);
        r7 = ((float) r2) / ((float) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d4, code lost:
        if (r12 == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d6, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d8, code lost:
        r8 = r1.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00db, code lost:
        if (r12 == false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00dd, code lost:
        r9 = r1.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e1, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e2, code lost:
        r5.a(r19, r20, r0, r6, r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00eb, code lost:
        if (r12 == false) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ed, code lost:
        r1.i.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f3, code lost:
        r1.i.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f8, code lost:
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        r1.i.a(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0105, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r16, boolean r17, int r18, int r19, int r20, boolean r21) {
        /*
            r15 = this;
            r1 = r15
            r0 = r18
            r4 = r20
            r2 = r21
            com.tencent.liteav.basic.d.g r3 = r1.i
            if (r3 != 0) goto L_0x000c
            return
        L_0x000c:
            monitor-enter(r15)
            boolean r3 = r1.f31872c     // Catch:{ all -> 0x0106 }
            if (r3 == 0) goto L_0x0013
            monitor-exit(r15)     // Catch:{ all -> 0x0106 }
            return
        L_0x0013:
            monitor-exit(r15)     // Catch:{ all -> 0x0106 }
            r3 = 16640(0x4100, float:2.3318E-41)
            android.opengl.GLES20.glClear(r3)
            int r3 = r15.getWidth()
            int r5 = r15.getHeight()
            int r6 = r1.B
            r7 = 270(0x10e, float:3.78E-43)
            r8 = 2
            r9 = 90
            r10 = 1
            r11 = 0
            if (r6 != 0) goto L_0x0031
            r1.D = r11
            r1.E = r11
            goto L_0x0060
        L_0x0031:
            if (r6 != r10) goto L_0x0060
            int r6 = r1.l
            int r6 = 720 - r6
            int r6 = r6 % 360
            if (r6 == r9) goto L_0x0040
            if (r6 != r7) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r6 = 0
            goto L_0x0041
        L_0x0040:
            r6 = 1
        L_0x0041:
            if (r6 == 0) goto L_0x0045
            r12 = r4
            goto L_0x0047
        L_0x0045:
            r12 = r19
        L_0x0047:
            if (r6 == 0) goto L_0x004c
            r6 = r19
            goto L_0x004d
        L_0x004c:
            r6 = r4
        L_0x004d:
            int[] r3 = r15.a(r3, r5, r12, r6)
            r5 = r3[r11]
            r6 = r3[r10]
            r12 = r3[r8]
            r1.D = r12
            r12 = 3
            r3 = r3[r12]
            r1.E = r3
            r3 = r5
            r5 = r6
        L_0x0060:
            r1.x = r3
            r1.y = r5
            int r6 = r1.D
            int r12 = r1.E
            android.opengl.GLES20.glViewport(r6, r12, r3, r5)
            int r6 = r1.C
            if (r6 != r10) goto L_0x0074
            if (r2 != 0) goto L_0x0079
        L_0x0071:
            r6 = r17 ^ 1
            goto L_0x007b
        L_0x0074:
            if (r6 != r8) goto L_0x0079
            if (r2 == 0) goto L_0x0079
            goto L_0x0071
        L_0x0079:
            r6 = r17
        L_0x007b:
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L_0x0083
            float r12 = (float) r3
            float r13 = (float) r5
            float r12 = r12 / r13
            goto L_0x0085
        L_0x0083:
            r12 = 1065353216(0x3f800000, float:1.0)
        L_0x0085:
            if (r4 == 0) goto L_0x008d
            r13 = r19
            float r8 = (float) r13
            float r14 = (float) r4
            float r8 = r8 / r14
            goto L_0x008f
        L_0x008d:
            r13 = r19
        L_0x008f:
            boolean r14 = r1.m
            if (r14 != r6) goto L_0x00a7
            int r14 = r1.l
            if (r14 != r0) goto L_0x00a7
            float r14 = r1.n
            int r14 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x00a7
            float r14 = r1.o
            int r14 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x00a7
            boolean r14 = r1.F
            if (r14 == r2) goto L_0x00f8
        L_0x00a7:
            r1.m = r6
            r1.l = r0
            r1.n = r12
            r1.o = r8
            r1.F = r2
            int r0 = r1.l
            int r0 = 720 - r0
            int r0 = r0 % 360
            if (r0 == r9) goto L_0x00be
            if (r0 != r7) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r12 = 0
            goto L_0x00bf
        L_0x00be:
            r12 = 1
        L_0x00bf:
            if (r12 == 0) goto L_0x00c3
            r2 = r5
            goto L_0x00c4
        L_0x00c3:
            r2 = r3
        L_0x00c4:
            if (r12 == 0) goto L_0x00c7
            goto L_0x00c8
        L_0x00c7:
            r3 = r5
        L_0x00c8:
            com.tencent.liteav.basic.d.g r5 = r1.i
            com.tencent.liteav.basic.d.j r6 = com.tencent.liteav.basic.d.j.NORMAL
            float[] r6 = com.tencent.liteav.basic.d.k.a(r6, r11, r10)
            float r2 = (float) r2
            float r3 = (float) r3
            float r7 = r2 / r3
            if (r12 == 0) goto L_0x00d8
            r8 = 0
            goto L_0x00db
        L_0x00d8:
            boolean r2 = r1.m
            r8 = r2
        L_0x00db:
            if (r12 == 0) goto L_0x00e1
            boolean r2 = r1.m
            r9 = r2
            goto L_0x00e2
        L_0x00e1:
            r9 = 0
        L_0x00e2:
            r2 = r5
            r3 = r19
            r4 = r20
            r5 = r0
            r2.a(r3, r4, r5, r6, r7, r8, r9)
            if (r12 == 0) goto L_0x00f3
            com.tencent.liteav.basic.d.g r0 = r1.i
            r0.g()
            goto L_0x00f8
        L_0x00f3:
            com.tencent.liteav.basic.d.g r0 = r1.i
            r0.h()
        L_0x00f8:
            r0 = 36160(0x8d40, float:5.0671E-41)
            android.opengl.GLES20.glBindFramebuffer(r0, r11)
            com.tencent.liteav.basic.d.g r0 = r1.i
            r2 = r16
            r0.a((int) r2)
            return
        L_0x0106:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0106 }
            goto L_0x010a
        L_0x0109:
            throw r0
        L_0x010a:
            goto L_0x0109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceView.a(int, boolean, int, int, int, boolean):void");
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            this.I = bArr;
            this.t = false;
            this.u = true;
        }
    }

    private int[] a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] iArr = new int[4];
        float f2 = (float) i3;
        float f3 = (float) i2;
        float f4 = ((float) i5) / ((float) i4);
        if (f2 / f3 > f4) {
            int i8 = (int) (f3 * f4);
            i7 = (i3 - i8) / 2;
            i3 = i8;
            i6 = 0;
        } else {
            int i9 = (int) (f2 / f4);
            i7 = 0;
            int i10 = i9;
            i6 = (i2 - i9) / 2;
            i2 = i10;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = i6;
        iArr[3] = i7;
        return iArr;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f31857g;
    }

    public void a(int i2, boolean z2) {
        this.p = i2;
        this.A = null;
        this.z = false;
        this.K = 0;
        this.J = 0;
        this.L = 0;
        b(true);
        this.G = z2;
        g();
    }

    public void a() {
        b(false);
    }

    public void setSurfaceTextureListener(m mVar) {
        this.H = mVar;
    }

    public EGLContext getGLContext() {
        return this.h;
    }

    public void a(Runnable runnable) {
        synchronized (this.M) {
            this.M.add(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public int c() {
        if (this.s != 12288) {
            TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.s);
        }
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            Handler handler = this.w;
            if (handler != null) {
                handler.getLooper().quitSafely();
                this.w = null;
            }
        }
    }

    public void b(Runnable runnable) {
        synchronized (this.M) {
            this.M.add(runnable);
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceView.a(java.util.Queue):boolean");
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.h = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        this.j = new int[1];
        this.j[0] = i.b();
        int[] iArr = this.j;
        if (iArr[0] <= 0) {
            this.j = null;
            TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            return;
        }
        this.f31857g = new SurfaceTexture(iArr[0]);
        g();
        this.i = new g();
        if (this.i.a()) {
            this.i.a(k.f31351e, k.a(j.NORMAL, false, false));
            m mVar = this.H;
            if (mVar != null) {
                mVar.a(this.f31857g);
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 r15) {
        /*
            r14 = this;
            java.util.Queue<java.lang.Runnable> r15 = r14.M
            r14.a((java.util.Queue<java.lang.Runnable>) r15)
            r15 = 1
            r0 = 0
            r1 = 1
        L_0x0008:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r14.r
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0016
            r14.r = r2
        L_0x0016:
            long r4 = r14.r
            long r6 = r2 - r4
            long r8 = r14.q
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r10
            int r12 = r14.p
            long r12 = (long) r12
            long r8 = r8 / r12
            int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x002f
            r1 = 15
            r14.a((long) r1)
            r1 = 0
            goto L_0x0008
        L_0x002f:
            long r2 = r2 - r4
            r4 = 1
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x0040
            r14.q = r4
            long r2 = java.lang.System.currentTimeMillis()
            r14.r = r2
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            boolean r3 = r14.t
            if (r3 == 0) goto L_0x0046
            return
        L_0x0046:
            monitor-enter(r14)     // Catch:{ Exception -> 0x00f8 }
            boolean r3 = r14.u     // Catch:{ all -> 0x00f5 }
            r6 = 0
            if (r3 != 0) goto L_0x004f
            r2 = r1
            r1 = 1
            goto L_0x0087
        L_0x004f:
            byte[] r1 = r14.I     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0069
            byte[] r1 = r14.I     // Catch:{ all -> 0x00f5 }
            r14.I = r6     // Catch:{ all -> 0x00f5 }
            android.graphics.SurfaceTexture r3 = r14.f31857g     // Catch:{ all -> 0x00f5 }
            if (r3 == 0) goto L_0x0067
            android.graphics.SurfaceTexture r3 = r14.f31857g     // Catch:{ all -> 0x00f5 }
            r3.updateTexImage()     // Catch:{ all -> 0x00f5 }
            android.graphics.SurfaceTexture r3 = r14.f31857g     // Catch:{ all -> 0x00f5 }
            float[] r6 = r14.k     // Catch:{ all -> 0x00f5 }
            r3.getTransformMatrix(r6)     // Catch:{ all -> 0x00f5 }
        L_0x0067:
            r6 = r1
            goto L_0x0079
        L_0x0069:
            android.graphics.SurfaceTexture r1 = r14.f31857g     // Catch:{ all -> 0x00f5 }
            if (r1 == 0) goto L_0x0079
            android.graphics.SurfaceTexture r1 = r14.f31857g     // Catch:{ all -> 0x00f5 }
            r1.updateTexImage()     // Catch:{ all -> 0x00f5 }
            android.graphics.SurfaceTexture r1 = r14.f31857g     // Catch:{ all -> 0x00f5 }
            float[] r3 = r14.k     // Catch:{ all -> 0x00f5 }
            r1.getTransformMatrix(r3)     // Catch:{ all -> 0x00f5 }
        L_0x0079:
            if (r2 != 0) goto L_0x0081
            long r1 = r14.q     // Catch:{ all -> 0x00f5 }
            long r1 = r1 + r4
            r14.q = r1     // Catch:{ all -> 0x00f5 }
            goto L_0x0083
        L_0x0081:
            r14.q = r4     // Catch:{ all -> 0x00f5 }
        L_0x0083:
            r14.u = r0     // Catch:{ all -> 0x00f5 }
            r1 = 0
            r2 = 0
        L_0x0087:
            monitor-exit(r14)     // Catch:{ all -> 0x00f5 }
            if (r15 != r1) goto L_0x0092
            if (r15 != r2) goto L_0x0091
            r0 = 5
            r14.a((long) r0)     // Catch:{ Exception -> 0x00f8 }
        L_0x0091:
            return
        L_0x0092:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f8 }
            double r3 = (double) r1     // Catch:{ Exception -> 0x00f8 }
            long r7 = r14.J     // Catch:{ Exception -> 0x00f8 }
            double r7 = (double) r7
            r9 = 4652007308841189376(0x408f400000000000, double:1000.0)
            java.lang.Double.isNaN(r7)
            double r7 = r7 + r9
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c0
            int r3 = r14.L     // Catch:{ Exception -> 0x00f8 }
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r3 = r3 * r9
            long r7 = r14.J     // Catch:{ Exception -> 0x00f8 }
            long r7 = r1 - r7
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r3 = r3 / r7
            int r3 = (int) r3
            int r3 = r3 + r15
            r14.K = r3     // Catch:{ Exception -> 0x00f8 }
            r14.J = r1     // Catch:{ Exception -> 0x00f8 }
            r14.L = r0     // Catch:{ Exception -> 0x00f8 }
        L_0x00c0:
            int r1 = r14.L     // Catch:{ Exception -> 0x00f8 }
            int r1 = r1 + r15
            r14.L = r1     // Catch:{ Exception -> 0x00f8 }
            com.tencent.liteav.basic.d.m r1 = r14.H     // Catch:{ Exception -> 0x00f8 }
            if (r1 == 0) goto L_0x00de
            if (r6 == 0) goto L_0x00d3
            com.tencent.liteav.basic.d.m r1 = r14.H     // Catch:{ Exception -> 0x00f8 }
            float[] r2 = r14.k     // Catch:{ Exception -> 0x00f8 }
            r1.a((byte[]) r6, (float[]) r2)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00de
        L_0x00d3:
            com.tencent.liteav.basic.d.m r1 = r14.H     // Catch:{ Exception -> 0x00f8 }
            int[] r2 = r14.j     // Catch:{ Exception -> 0x00f8 }
            r2 = r2[r0]     // Catch:{ Exception -> 0x00f8 }
            float[] r3 = r14.k     // Catch:{ Exception -> 0x00f8 }
            r1.a((int) r2, (float[]) r3)     // Catch:{ Exception -> 0x00f8 }
        L_0x00de:
            r14.f()     // Catch:{ Exception -> 0x00f8 }
            monitor-enter(r14)     // Catch:{ Exception -> 0x00f8 }
            boolean r1 = r14.f31872c     // Catch:{ all -> 0x00f2 }
            if (r1 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r15 = 0
        L_0x00e8:
            monitor-exit(r14)     // Catch:{ all -> 0x00f2 }
            if (r15 == 0) goto L_0x00fc
            int r15 = r14.d()     // Catch:{ Exception -> 0x00f8 }
            r14.s = r15     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00fc
        L_0x00f2:
            r15 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00f2 }
            throw r15     // Catch:{ Exception -> 0x00f8 }
        L_0x00f5:
            r15 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00f5 }
            throw r15     // Catch:{ Exception -> 0x00f8 }
        L_0x00f8:
            r15 = move-exception
            r15.printStackTrace()
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceView.onDrawFrame(javax.microedition.khronos.opengles.GL10):void");
    }

    private void f() {
        if (this.z) {
            if (!(this.x == 0 || this.y == 0)) {
                boolean z2 = getWidth() <= getHeight();
                int i2 = this.y;
                int i3 = this.x;
                if (i2 < i3) {
                    i2 = i3;
                }
                int i4 = this.y;
                int i5 = this.x;
                if (i4 >= i5) {
                    i4 = i5;
                }
                if (z2) {
                    int i6 = i4;
                    i4 = i2;
                    i2 = i6;
                }
                ByteBuffer allocate = ByteBuffer.allocate(i2 * i4 * 4);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ARGB_8888);
                allocate.position(0);
                GLES20.glReadPixels(this.D, this.E, i2, i4, 6408, 5121, allocate);
                final ByteBuffer byteBuffer = allocate;
                final Bitmap bitmap = createBitmap;
                final int i7 = i2;
                final int i8 = i4;
                new Thread(new Runnable() {
                    public void run() {
                        byteBuffer.position(0);
                        bitmap.copyPixelsFromBuffer(byteBuffer);
                        Matrix matrix = new Matrix();
                        matrix.setScale(1.0f, -1.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i7, i8, matrix, false);
                        if (TXCGLSurfaceView.this.A != null) {
                            TXCGLSurfaceView.this.A.a(createBitmap);
                            n unused = TXCGLSurfaceView.this.A = null;
                        }
                        bitmap.recycle();
                    }
                }).start();
            }
            this.z = false;
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.t = false;
        synchronized (this) {
            this.u = true;
        }
    }

    public void a(boolean z2) {
        this.t = true;
        if (z2) {
            GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
            GLES20.glClear(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
            this.s = d();
        }
        synchronized (this) {
            if (this.u) {
                this.u = false;
                if (this.f31857g != null) {
                    this.f31857g.updateTexImage();
                }
            }
        }
    }

    private void a(long j2) {
        try {
            Thread.sleep(j2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        if (!this.G) {
            SurfaceTexture surfaceTexture = this.f31857g;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            }
        } else if (this.f31857g == null) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.w == null) {
                    HandlerThread handlerThread = new HandlerThread("VideoCaptureThread");
                    handlerThread.start();
                    this.w = new Handler(handlerThread.getLooper());
                }
                this.f31857g.setOnFrameAvailableListener(this, this.w);
                return;
            }
            this.f31857g.setOnFrameAvailableListener(this);
        }
    }
}
