package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.a;
import com.tencent.liteav.beauty.b.c;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.b.x;
import com.tencent.liteav.beauty.c;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class b extends HandlerThread {
    private int A = -1;
    /* access modifiers changed from: private */
    public int B = 0;
    private int C = 0;
    private boolean D = false;
    /* access modifiers changed from: private */
    public float[] E = null;
    /* access modifiers changed from: private */
    public boolean F = false;
    private int G = 0;
    /* access modifiers changed from: private */
    public int H = 0;
    private com.tencent.liteav.basic.d.a I = null;
    private Bitmap J = null;
    private k K = null;
    private o L = null;
    /* access modifiers changed from: private */
    public com.tencent.liteav.beauty.b.b M = null;
    private com.tencent.liteav.beauty.b.a.a N = null;
    private com.tencent.liteav.beauty.b.b.a O = null;
    private c P = null;
    /* access modifiers changed from: private */
    public Bitmap Q;
    /* access modifiers changed from: private */
    public Bitmap R;
    /* access modifiers changed from: private */
    public float S;
    /* access modifiers changed from: private */
    public float T;
    /* access modifiers changed from: private */
    public float U;
    /* access modifiers changed from: private */
    public m V;
    private n W = null;
    /* access modifiers changed from: private */
    public x X = null;
    private j Y = null;
    private i Z = null;

    /* renamed from: a  reason: collision with root package name */
    boolean f31452a = false;
    /* access modifiers changed from: private */
    public int[] aA = null;
    private boolean aB = false;
    private byte[] aC = null;
    private int aD = -1;
    private int aE = 0;
    private int aF = 1;
    private int aG = this.aD;
    private d aH = null;
    private WeakReference<com.tencent.liteav.basic.c.a> aI = new WeakReference<>((Object) null);
    private i.a aJ = new i.a() {
    };
    private g aa = null;
    private l ab = null;
    private h ac = null;
    private g ad = null;
    private final Queue<Runnable> ae = new LinkedList();
    private boolean af;
    private Object ag = new Object();
    private Object ah = new Object();
    private Handler ai;
    private a aj;
    /* access modifiers changed from: private */
    public float ak = 0.5f;
    private int al = 0;
    private int am = 0;
    private int an = 0;
    private int ao = 0;
    private int ap = 0;
    /* access modifiers changed from: private */
    public boolean aq = false;
    /* access modifiers changed from: private */
    public com.tencent.liteav.beauty.a.a.c ar = null;
    /* access modifiers changed from: private */
    public com.tencent.liteav.beauty.a.a.a as = null;
    private Bitmap at = null;
    private List<c.e> au = null;
    private long av = 0;
    private int aw = 0;
    private final int ax = 100;
    private final float ay = 1000.0f;
    private byte[] az = null;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f31453b = null;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f31454c = null;

    /* renamed from: d  reason: collision with root package name */
    a f31455d = new a();

    /* renamed from: e  reason: collision with root package name */
    a f31456e = new a();

    /* renamed from: f  reason: collision with root package name */
    a f31457f = new a();

    /* renamed from: g  reason: collision with root package name */
    private int f31458g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private Context m = null;
    private boolean n = true;
    private c.d o = new c.d();
    private c.e p = null;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    /* access modifiers changed from: private */
    public int u = -1;
    /* access modifiers changed from: private */
    public int v = -1;
    /* access modifiers changed from: private */
    public int w = -1;
    /* access modifiers changed from: private */
    public int x = -1;
    private float y = 1.0f;
    private int z = -1;

    public void a(String str) {
    }

    public void a(String str, boolean z2) {
    }

    public void b(boolean z2) {
    }

    public void g(int i2) {
    }

    public void h(int i2) {
    }

    public void i(int i2) {
    }

    public void j(int i2) {
    }

    public void k(int i2) {
    }

    public void l(int i2) {
    }

    b(Context context, boolean z2) {
        super("TXCFilterDrawer");
        this.m = context;
        this.ai = new Handler(this.m.getMainLooper());
        this.af = z2;
    }

    public synchronized boolean a(c.b bVar) {
        boolean z2;
        z2 = true;
        if (!bVar.j) {
            if (this.aj == null) {
                start();
                this.aj = new a(getLooper(), this.m);
            }
            this.aj.obtainMessage(0, bVar).sendToTarget();
            this.aj.b();
        } else {
            z2 = c(bVar);
        }
        return z2;
    }

    public int a(int i2, int i3, long j2) {
        a(this.ae);
        boolean z2 = this.y != 1.0f;
        GLES20.glViewport(0, 0, this.w, this.x);
        if (this.ab != null) {
            if (4 == i3 || true == this.F) {
                this.ab.a(this.E);
                this.ab.c(this.F);
            }
            i2 = this.ab.b(i2);
        }
        if (this.M != null && (this.am > 0 || this.an > 0 || this.ap > 0)) {
            i2 = this.M.b(i2);
        }
        m mVar = this.V;
        if (mVar != null) {
            i2 = mVar.b(i2);
        }
        GLES20.glViewport(0, 0, this.u, this.v);
        j jVar = this.Y;
        if (jVar != null) {
            i2 = jVar.a(i2);
            z2 = false;
        }
        com.tencent.liteav.beauty.b.i iVar = this.Z;
        if (iVar != null) {
            i2 = iVar.b(i2);
            z2 = false;
        }
        if (z2) {
            b(this.u, this.v);
            if (this.ad != null) {
                GLES20.glViewport(0, 0, this.u, this.v);
                i2 = this.ad.b(i2);
            }
        }
        d dVar = this.aH;
        if (dVar != null) {
            int a2 = dVar.a(i2, this.u, this.v);
            if (a2 > 0) {
                i2 = a2;
            }
        }
        GLES20.glViewport(0, 0, this.u, this.v);
        x xVar = this.X;
        if (xVar != null) {
            i2 = xVar.b(i2);
        }
        if (this.aa != null) {
            GLES20.glViewport(0, 0, this.z, this.A);
            i2 = this.aa.b(i2);
        }
        a(i2, j2);
        return i2;
    }

    public int a(byte[] bArr, int i2) {
        a(bArr);
        if (!this.af) {
            byte[] bArr2 = (byte[]) bArr.clone();
            this.aj.obtainMessage(2, bArr2).sendToTarget();
            if (!this.aB) {
                TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
                NativeLoad.getInstance();
                NativeLoad.nativeClearQueue();
            }
            this.aj.obtainMessage(3, i2, 0).sendToTarget();
            a(bArr2, this.aB);
            this.aB = true;
            return -1;
        }
        b(bArr);
        return m(i2);
    }

    public void a(final float f2) {
        this.ak = f2;
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.V != null) {
                    b.this.V.a(f2);
                }
            }
        });
    }

    public void a(final float[] fArr) {
        a((Runnable) new Runnable() {
            public void run() {
                float[] unused = b.this.E = fArr;
            }
        });
    }

    public void a(final boolean z2) {
        a((Runnable) new Runnable() {
            public void run() {
                boolean unused = b.this.F = z2;
            }
        });
    }

    private void a(com.tencent.liteav.basic.d.a aVar, int i2, int i3, int i4, int i5, boolean z2, int i6, int i7) {
        if (this.ab == null) {
            TXCLog.i("TXCFilterDrawer", "Create CropFilter");
            if (4 == i7) {
                this.ab = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
            } else {
                this.ab = new l();
            }
            if (true == this.ab.a()) {
                this.ab.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
            }
        } else {
            int i8 = i7;
        }
        int i9 = i4;
        int i10 = i5;
        this.ab.a(i9, i10);
        float[] a2 = this.ab.a(this.q, this.r, (FloatBuffer) null, aVar, i7);
        int i11 = (720 - i6) % 360;
        int i12 = (i11 == 90 || i11 == 270) ? i10 : i9;
        if (!(i11 == 90 || i11 == 270)) {
            i9 = i10;
        }
        this.ab.a(i2, i3, i11, a2, ((float) i12) / ((float) i9), z2, false);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        synchronized (this.ah) {
            int i8 = ((i7 - i4) + 360) % 360;
            TXCLog.i("TXCFilterDrawer", "real outputAngle " + i8);
            if (this.aa == null) {
                if (i2 == i5 && i3 == i6 && i8 == 0) {
                    TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
                    return;
                }
                this.aa = new g();
                if (true == this.aa.a()) {
                    this.aa.a(true);
                } else {
                    TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
                }
            }
            this.aa.a(i5, i6);
            this.aa.a((720 - i8) % 360, (FloatBuffer) null);
        }
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4) {
        if (this.p == null) {
            this.p = new c.e();
        }
        if (this.p.f31544a != null && bitmap != null && true == this.p.f31544a.equals(bitmap) && f2 == this.p.f31545b && f3 == this.p.f31546c && f4 == this.p.f31547d) {
            Log.d("TXCFilterDrawer", "Same Water Mark; don't set again");
            return;
        }
        c.e eVar = this.p;
        eVar.f31544a = bitmap;
        eVar.f31545b = f2;
        eVar.f31546c = f3;
        eVar.f31547d = f4;
        final Bitmap bitmap2 = bitmap;
        final float f5 = f2;
        final float f6 = f3;
        final float f7 = f4;
        a((Runnable) new Runnable() {
            public void run() {
                if (bitmap2 != null) {
                    a.a().e();
                }
                if (bitmap2 != null) {
                    if (b.this.X == null) {
                        if (b.this.u <= 0 || b.this.v <= 0) {
                            TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
                            return;
                        }
                        x unused = b.this.X = new x();
                        b.this.X.a(true);
                        if (!b.this.X.a()) {
                            TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
                            b.this.X.d();
                            x unused2 = b.this.X = null;
                            return;
                        }
                        b.this.X.a(b.this.u, b.this.v);
                    }
                    b.this.X.c(true);
                    b.this.X.a(bitmap2, f5, f6, f7);
                } else if (b.this.X != null) {
                    b.this.X.d();
                    x unused3 = b.this.X = null;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar) {
        TXCLog.i("TXCFilterDrawer", "set listener");
        this.aH = dVar;
    }

    /* access modifiers changed from: package-private */
    public void a(com.tencent.liteav.basic.c.a aVar) {
        TXCLog.i("TXCFilterDrawer", "set notify");
        this.aI = new WeakReference<>(aVar);
        j jVar = this.Y;
        if (jVar != null) {
            jVar.a((com.tencent.liteav.basic.c.a) this.aI.get());
        }
    }

    private int a(int i2, long j2) {
        int i3 = this.H;
        if (i3 == 0) {
            if (this.aH != null) {
                if (j2 == 0) {
                    j2 = TXCTimeUtil.getTimeTick();
                }
                int i4 = i2;
                this.aH.a(i4, this.z, this.A, j2);
            }
            return i2;
        } else if (1 == i3 || 3 == i3 || 2 == i3) {
            GLES20.glViewport(0, 0, this.z, this.A);
            if (this.L == null) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
                return i2;
            }
            GLES20.glBindFramebuffer(36160, this.f31453b[0]);
            this.L.a(i2);
            if (2 == this.H) {
                a(this.z, this.A);
            } else {
                a(this.z, (this.A * 3) / 8);
            }
            GLES20.glBindFramebuffer(36160, 0);
            return i2;
        } else {
            TXCLog.e("TXCFilterDrawer", "Don't support format!");
            return -1;
        }
    }

    private int a(int i2, int i3) {
        if (true == this.af) {
            if (this.aH != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i2, i3, this.az);
                this.aH.a(this.az, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
            } else if (this.aC != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i2, i3, this.aC);
            }
        } else if (3 == com.tencent.liteav.basic.d.i.a()) {
            if (0 == this.av) {
                this.av = TXCTimeUtil.getTimeTick();
            }
            int i4 = this.aw + 1;
            this.aw = i4;
            if (i4 >= 100) {
                float timeTick = 100.0f / (((float) (TXCTimeUtil.getTimeTick() - this.av)) / 1000.0f);
                TXCLog.i("TXCFilterDrawer", "Real fps " + timeTick);
                this.aw = 0;
                this.av = TXCTimeUtil.getTimeTick();
            }
            GLES30.glPixelStorei(3333, 1);
            if (Build.VERSION.SDK_INT >= 18) {
                GLES30.glReadBuffer(Place.TYPE_SYNTHETIC_GEOCODE);
            }
            GLES30.glBindBuffer(35051, this.aA[0]);
            NativeLoad.getInstance();
            ByteBuffer byteBuffer = null;
            NativeLoad.nativeGlReadPixs(i2, i3, (byte[]) null);
            if (Build.VERSION.SDK_INT >= 18) {
                byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, i2 * i3 * 4, 1);
                if (byteBuffer == null) {
                    TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
                    return -1;
                }
            }
            NativeLoad.getInstance();
            NativeLoad.nativeGlMapBufferToQueue(i2, i3, byteBuffer);
            if (Build.VERSION.SDK_INT >= 18) {
                GLES30.glUnmapBuffer(35051);
            }
            GLES30.glBindBuffer(35051, 0);
        } else {
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixsToQueue(i2, i3);
        }
        return 0;
    }

    public void a(final int i2) {
        a((Runnable) new Runnable() {
            public void run() {
                int unused = b.this.H = i2;
            }
        });
    }

    private void a(byte[] bArr, boolean z2) {
        if (!z2) {
            d dVar = this.aH;
            if (dVar != null) {
                dVar.a(bArr, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
                return;
            }
            TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
            return;
        }
        int i2 = this.A;
        int i3 = (i2 * 3) / 8;
        if (2 != this.H) {
            i2 = i3;
        }
        if (this.aH != null) {
            NativeLoad.getInstance();
            if (true == NativeLoad.nativeGlReadPixsFromQueue(this.z, i2, this.az)) {
                this.aH.a(this.az, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
                return;
            }
            TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
            byte[] bArr2 = bArr;
            this.aH.a(bArr2, this.z, this.A, this.H, TXCTimeUtil.getTimeTick());
            return;
        }
        NativeLoad.getInstance();
        if (!NativeLoad.nativeGlReadPixsFromQueue(this.z, i2, this.aC)) {
            TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
        }
    }

    /* access modifiers changed from: private */
    public int m(int i2) {
        GLES20.glViewport(0, 0, this.q, this.r);
        return a(this.K.q(), i2, 0);
    }

    public void a(byte[] bArr) {
        this.aC = bArr;
    }

    /* access modifiers changed from: private */
    public void b(byte[] bArr) {
        k kVar = this.K;
        if (kVar == null) {
            TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
        } else {
            kVar.a(bArr);
        }
    }

    public void a() {
        if (!this.af) {
            a aVar = this.aj;
            if (aVar != null) {
                aVar.obtainMessage(1).sendToTarget();
                try {
                    this.f31455d.b();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
        this.aB = false;
        k kVar = this.K;
        if (kVar != null) {
            kVar.d();
            this.K = null;
        }
        o oVar = this.L;
        if (oVar != null) {
            oVar.d();
            this.L = null;
        }
        c();
        m mVar = this.V;
        if (mVar != null) {
            mVar.d();
            this.V = null;
        }
        n nVar = this.W;
        if (nVar != null) {
            nVar.a();
            this.W = null;
        }
        h hVar = this.ac;
        if (hVar != null) {
            hVar.d();
            this.ac = null;
        }
        l lVar = this.ab;
        if (lVar != null) {
            lVar.d();
            this.ab = null;
        }
        g gVar = this.aa;
        if (gVar != null) {
            gVar.d();
            this.aa = null;
        }
        x xVar = this.X;
        if (xVar != null) {
            xVar.d();
            this.X = null;
        }
        j jVar = this.Y;
        if (jVar != null) {
            jVar.a();
            this.Y = null;
        }
        com.tencent.liteav.beauty.b.i iVar = this.Z;
        if (iVar != null) {
            iVar.d();
            this.Z = null;
        }
        g gVar2 = this.ad;
        if (gVar2 != null) {
            gVar2.d();
            this.ad = null;
        }
        int[] iArr = this.f31453b;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.f31453b = null;
        }
        int[] iArr2 = this.f31454c;
        if (iArr2 != null) {
            GLES20.glDeleteTextures(1, iArr2, 0);
            this.f31454c = null;
        }
        this.p = null;
        TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
    }

    /* access modifiers changed from: private */
    public boolean c(c.b bVar) {
        TXCLog.i("TXCFilterDrawer", "come into initInternal");
        b();
        this.af = bVar.j;
        this.q = bVar.f31531d;
        this.r = bVar.f31532e;
        this.I = bVar.m;
        this.s = bVar.f31534g;
        this.t = bVar.f31533f;
        this.B = bVar.h;
        this.D = bVar.i;
        this.z = bVar.f31529b;
        this.A = bVar.f31530c;
        this.C = bVar.f31528a;
        this.u = bVar.f31534g;
        this.v = bVar.f31533f;
        int i2 = this.B;
        if (i2 == 90 || i2 == 270) {
            this.u = bVar.f31533f;
            this.v = bVar.f31534g;
        }
        this.H = bVar.l;
        this.G = bVar.k;
        this.az = new byte[(this.z * this.A * 4)];
        TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is " + this.y);
        if (this.y != 1.0f) {
            int i3 = this.u;
            int i4 = this.v;
            if (i3 >= i4) {
                i3 = i4;
            }
            if (i3 > 368) {
                this.y = 432.0f / ((float) i3);
            }
            if (this.y > 1.0f) {
                this.y = 1.0f;
            }
        }
        float f2 = this.y;
        this.w = (int) (((float) this.u) * f2);
        this.x = (int) (((float) this.v) * f2);
        a(this.w, this.x, this.al);
        c.e eVar = this.p;
        if (!(eVar == null || eVar.f31544a == null || this.X != null)) {
            TXCLog.i("TXCFilterDrawer", "reset water mark!");
            a(this.p.f31544a, this.p.f31545b, this.p.f31546c, this.p.f31547d);
        }
        if (!(this.Q == null && this.R == null) && this.V == null) {
            a(this.w, this.x, this.S, this.Q, this.T, this.R, this.U);
        }
        a(this.I, this.s, this.t, this.w, this.x, this.D, this.B, this.G);
        a(this.u, this.v, this.B, this.z, this.A, this.C);
        int[] iArr = this.f31453b;
        if (iArr == null) {
            this.f31453b = new int[1];
        } else {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
        int[] iArr2 = this.f31454c;
        if (iArr2 == null) {
            this.f31454c = new int[1];
        } else {
            GLES20.glDeleteTextures(1, iArr2, 0);
        }
        a(this.f31453b, this.f31454c, this.z, this.A);
        if (3 == com.tencent.liteav.basic.d.i.a()) {
            if (this.aA == null) {
                this.aA = new int[1];
            } else {
                TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
                GLES30.glDeleteBuffers(1, this.aA, 0);
            }
            TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
            com.tencent.liteav.basic.d.i.a(this.s, this.t, this.aA);
        }
        TXCLog.i("TXCFilterDrawer", "come out initInternal");
        return true;
    }

    public boolean b(c.b bVar) {
        if (!this.af) {
            a aVar = this.aj;
            if (aVar == null) {
                TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
                return false;
            }
            aVar.obtainMessage(5, 0, 0, bVar).sendToTarget();
            return true;
        }
        d(bVar);
        return true;
    }

    private void a(int[] iArr, int[] iArr2, int i2, int i3) {
        GLES20.glGenFramebuffers(1, iArr, 0);
        iArr2[0] = com.tencent.liteav.basic.d.i.a(i2, i3, 6408, 6408, iArr2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* access modifiers changed from: private */
    public boolean d(c.b bVar) {
        if ((1 == bVar.k || 3 == bVar.k || 2 == bVar.k) && this.K == null) {
            this.K = new k(bVar.k);
            this.K.a(true);
            if (!this.K.a()) {
                TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
                return false;
            }
            this.K.a(bVar.f31531d, bVar.f31532e);
        }
        if ((1 == bVar.l || 3 == bVar.l || 2 == bVar.l) && this.L == null) {
            this.L = new o(bVar.l);
            if (!this.L.a()) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
                return false;
            }
            this.L.a(bVar.f31529b, bVar.f31530c);
        }
        return true;
    }

    public void b(final int i2) {
        this.am = i2;
        a((Runnable) new Runnable() {
            public void run() {
                if (i2 > 0) {
                    a.a().b();
                }
                if (b.this.M != null && i2 >= 0) {
                    b.this.M.c(i2);
                }
            }
        });
    }

    public void c(final int i2) {
        if (this.al != i2 && i2 <= 2 && i2 >= 0) {
            this.al = i2;
            a((Runnable) new Runnable() {
                public void run() {
                    b bVar = b.this;
                    bVar.a(bVar.w, b.this.x, i2);
                }
            });
        }
    }

    public void d(final int i2) {
        this.an = i2;
        a((Runnable) new Runnable() {
            public void run() {
                if (i2 > 0) {
                    a.a().c();
                }
                if (b.this.M != null && i2 >= 0) {
                    b.this.M.d(i2);
                }
            }
        });
    }

    public void e(final int i2) {
        this.ao = i2;
        a((Runnable) new Runnable() {
            public void run() {
                if (i2 > 0) {
                    a.a().c();
                }
                if (b.this.M != null && i2 >= 0) {
                    b.this.M.f(i2);
                }
            }
        });
    }

    public void f(final int i2) {
        this.ap = i2;
        a((Runnable) new Runnable() {
            public void run() {
                if (i2 > 0) {
                    a.a().c();
                }
                if (b.this.M != null && i2 >= 0) {
                    b.this.M.e(i2);
                }
            }
        });
    }

    public void a(Bitmap bitmap) {
        a(1.0f, bitmap, this.ak, (Bitmap) null, BitmapDescriptorFactory.HUE_RED);
    }

    public void a(final float f2, Bitmap bitmap, final float f3, Bitmap bitmap2, final float f4) {
        if (this.Q != bitmap || this.R != bitmap2) {
            this.Q = bitmap;
            this.R = bitmap2;
            this.S = f2;
            this.T = f3;
            this.U = f4;
            final float f5 = f2;
            final Bitmap bitmap3 = bitmap;
            final float f6 = f3;
            final Bitmap bitmap4 = bitmap2;
            final float f7 = f4;
            a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.V != null) {
                        a.a().d();
                    }
                    if (b.this.Q == null && b.this.R == null) {
                        if (b.this.V != null) {
                            b.this.V.d();
                            m unused = b.this.V = null;
                        }
                    } else if (b.this.V == null) {
                        b bVar = b.this;
                        bVar.a(bVar.w, b.this.x, b.this.S, b.this.Q, b.this.T, b.this.R, b.this.U);
                    } else {
                        b.this.V.a(f5, bitmap3, f6, bitmap4, f7);
                    }
                }
            });
        } else if (this.V == null) {
        } else {
            if (this.S != f2 || this.T != f3 || this.U != f4) {
                this.S = f2;
                this.T = f3;
                this.U = f4;
                a((Runnable) new Runnable() {
                    public void run() {
                        b.this.V.a(f2, f3, f4);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
        if (i4 == 0) {
            if (this.N == null) {
                this.N = new com.tencent.liteav.beauty.b.a.a();
            }
            this.M = this.N;
            Log.i("TXCFilterDrawer", "0 BeautyFilter");
        } else if (1 == i4) {
            if (this.O == null) {
                this.O = new com.tencent.liteav.beauty.b.b.a();
            }
            this.M = this.O;
            Log.i("TXCFilterDrawer", "1 BeautyFilter");
        } else if (2 == i4) {
            if (this.P == null) {
                this.P = new com.tencent.liteav.beauty.b.c();
            }
            this.M = this.P;
            Log.i("TXCFilterDrawer", "2 BeautyFilter");
        }
        com.tencent.liteav.beauty.b.b bVar = this.M;
        if (bVar == null) {
            TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
            return;
        }
        bVar.a(true);
        if (true == this.M.c(i2, i3)) {
            int i5 = this.am;
            if (i5 > 0) {
                this.M.c(i5);
            }
            int i6 = this.an;
            if (i6 > 0) {
                this.M.d(i6);
            }
            int i7 = this.ap;
            if (i7 > 0) {
                this.M.e(i7);
            }
            int i8 = this.ao;
            if (i8 > 0) {
                this.M.f(i8);
                return;
            }
            return;
        }
        TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
    }

    private void c() {
        com.tencent.liteav.beauty.b.a.a aVar = this.N;
        if (aVar != null) {
            aVar.d();
            this.N = null;
        }
        com.tencent.liteav.beauty.b.b.a aVar2 = this.O;
        if (aVar2 != null) {
            aVar2.d();
            this.O = null;
        }
        com.tencent.liteav.beauty.b.c cVar = this.P;
        if (cVar != null) {
            cVar.d();
            this.P = null;
        }
        this.M = null;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, float f2, Bitmap bitmap, float f3, Bitmap bitmap2, float f4) {
        if (this.V == null) {
            TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
            this.V = new m(f2, bitmap, f3, bitmap2, f4);
            if (true == this.V.a()) {
                this.V.a(true);
                this.V.a(i2, i3);
                return;
            }
            TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
        }
    }

    private void b(int i2, int i3) {
        if (this.ad == null) {
            TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
            this.ad = new g();
            if (true == this.ad.a()) {
                this.ad.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
            }
        }
        g gVar = this.ad;
        if (gVar != null) {
            gVar.a(i2, i3);
        }
    }

    private void a(Runnable runnable) {
        synchronized (this.ae) {
            this.ae.add(runnable);
        }
    }

    private void a(Queue<Runnable> queue) {
        while (true) {
            Runnable runnable = null;
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    runnable = queue.poll();
                }
            }
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
        while (true) {
        }
    }

    private class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private String f31494b = "EGLDrawThreadHandler";

        a(Looper looper, Context context) {
            super(looper);
        }

        private void a(Object obj) {
            TXCLog.i(this.f31494b, "come into InitEGL");
            c.b bVar = (c.b) obj;
            a();
            com.tencent.liteav.beauty.a.a.a unused = b.this.as = new com.tencent.liteav.beauty.a.a.a();
            b bVar2 = b.this;
            com.tencent.liteav.beauty.a.a.c unused2 = bVar2.ar = new com.tencent.liteav.beauty.a.a.c(bVar2.as, bVar.f31534g, bVar.f31533f, false);
            b.this.ar.b();
            if (!b.this.c(bVar)) {
                TXCLog.e(this.f31494b, "initInternal failed!");
            } else {
                TXCLog.i(this.f31494b, "come out InitEGL");
            }
        }

        public void a() {
            TXCLog.i(this.f31494b, "come into releaseEGL");
            if (b.this.aA != null && b.this.aA[0] > 0) {
                GLES20.glDeleteBuffers(1, b.this.aA, 0);
                int[] unused = b.this.aA = null;
            }
            b.this.b();
            if (b.this.ar != null) {
                b.this.ar.c();
                com.tencent.liteav.beauty.a.a.c unused2 = b.this.ar = null;
            }
            if (b.this.as != null) {
                b.this.as.a();
                com.tencent.liteav.beauty.a.a.a unused3 = b.this.as = null;
            }
            boolean unused4 = b.this.aq = false;
            NativeLoad.getInstance();
            NativeLoad.nativeDeleteYuv2Yuv();
            TXCLog.i(this.f31494b, "come out releaseEGL");
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
            	at java.util.ArrayList.get(ArrayList.java:433)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void handleMessage(android.os.Message r11) {
            /*
                r10 = this;
                super.handleMessage(r11)
                int r0 = r11.what
                r1 = 1
                if (r0 == 0) goto L_0x0095
                if (r0 == r1) goto L_0x0089
                r2 = 2
                if (r0 == r2) goto L_0x007d
                r2 = 3
                if (r0 == r2) goto L_0x0075
                r2 = 4
                if (r0 == r2) goto L_0x004e
                r2 = 5
                if (r0 == r2) goto L_0x0044
                r2 = 7
                if (r0 == r2) goto L_0x001b
                goto L_0x0093
            L_0x001b:
                com.tencent.liteav.beauty.b r3 = com.tencent.liteav.beauty.b.this
                int r4 = r3.u
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                int r5 = r0.v
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                int r6 = r0.B
                int r7 = r11.arg1
                int r8 = r11.arg2
                java.lang.Object r11 = r11.obj
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r9 = r11.intValue()
                r3.a(r4, r5, r6, r7, r8, r9)
                com.tencent.liteav.beauty.b r11 = com.tencent.liteav.beauty.b.this
                com.tencent.liteav.beauty.b.a r11 = r11.f31457f
                r11.a()
                goto L_0x0093
            L_0x0044:
                java.lang.Object r11 = r11.obj
                com.tencent.liteav.beauty.c$b r11 = (com.tencent.liteav.beauty.c.b) r11
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                boolean unused = r0.d((com.tencent.liteav.beauty.c.b) r11)
                goto L_0x0093
            L_0x004e:
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                int r11 = r11.arg1
                double r2 = (double) r11
                r4 = 4636737291354636288(0x4059000000000000, double:100.0)
                java.lang.Double.isNaN(r2)
                double r2 = r2 / r4
                float r11 = (float) r2
                float unused = r0.ak = r11
                com.tencent.liteav.beauty.b r11 = com.tencent.liteav.beauty.b.this
                com.tencent.liteav.beauty.b.m r11 = r11.V
                if (r11 == 0) goto L_0x0093
                com.tencent.liteav.beauty.b r11 = com.tencent.liteav.beauty.b.this
                com.tencent.liteav.beauty.b.m r11 = r11.V
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                float r0 = r0.ak
                r11.a((float) r0)
                goto L_0x0093
            L_0x0075:
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                int r11 = r11.arg1
                int unused = r0.m((int) r11)
                goto L_0x009f
            L_0x007d:
                com.tencent.liteav.beauty.b r0 = com.tencent.liteav.beauty.b.this
                java.lang.Object r11 = r11.obj
                byte[] r11 = (byte[]) r11
                byte[] r11 = (byte[]) r11
                r0.b((byte[]) r11)
                goto L_0x0093
            L_0x0089:
                r10.a()
                com.tencent.liteav.beauty.b r11 = com.tencent.liteav.beauty.b.this
                com.tencent.liteav.beauty.b.a r11 = r11.f31455d
                r11.a()
            L_0x0093:
                r11 = 0
                goto L_0x00a0
            L_0x0095:
                java.lang.Object r11 = r11.obj
                r10.a(r11)
                com.tencent.liteav.beauty.b r11 = com.tencent.liteav.beauty.b.this
                boolean unused = r11.aq = r1
            L_0x009f:
                r11 = 1
            L_0x00a0:
                monitor-enter(r10)
                if (r1 != r11) goto L_0x00a6
                r10.notify()     // Catch:{ all -> 0x00a8 }
            L_0x00a6:
                monitor-exit(r10)     // Catch:{ all -> 0x00a8 }
                return
            L_0x00a8:
                r11 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00a8 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.b.a.handleMessage(android.os.Message):void");
        }

        /* access modifiers changed from: package-private */
        public void b() {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
