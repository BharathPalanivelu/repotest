package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class e extends com.tencent.liteav.basic.module.a implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f31938a = {1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f};
    private long A = 0;
    private boolean B = false;
    private boolean C = false;
    private a D = new a();

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f31939b;

    /* renamed from: c  reason: collision with root package name */
    private int f31940c = 800;

    /* renamed from: d  reason: collision with root package name */
    protected TextureView f31941d;

    /* renamed from: e  reason: collision with root package name */
    protected d f31942e;

    /* renamed from: f  reason: collision with root package name */
    protected int f31943f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f31944g = 0;
    protected int h = 0;
    protected int i = 0;
    protected int j = 0;
    protected volatile int k = -1;
    protected int l = 0;
    protected int m = 0;
    protected f n;
    WeakReference<com.tencent.liteav.basic.c.a> o;
    /* access modifiers changed from: private */
    public d p;
    private h q;
    private Surface r;
    private int s = 0;
    private int t = 0;
    private int u;
    /* access modifiers changed from: private */
    public int[] v;
    private int w = 500;
    private long x = 0;
    private long y = 0;
    private long z = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f31948a;

        /* renamed from: b  reason: collision with root package name */
        public long f31949b;

        /* renamed from: c  reason: collision with root package name */
        public long f31950c;

        /* renamed from: d  reason: collision with root package name */
        public long f31951d;

        /* renamed from: e  reason: collision with root package name */
        public long f31952e;

        /* renamed from: f  reason: collision with root package name */
        public long f31953f;

        /* renamed from: g  reason: collision with root package name */
        public long f31954g;
        public long h;
        public long i;
        public int j;
        public int k;
    }

    public SurfaceTexture a() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(SurfaceTexture surfaceTexture) {
    }

    /* access modifiers changed from: protected */
    public void b(SurfaceTexture surfaceTexture) {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void a(int i2) {
        this.j = i2;
    }

    public void b(int i2) {
        if (i2 > 0) {
            this.f31940c = i2;
        }
    }

    public void a(f fVar) {
        this.n = fVar;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.o = new WeakReference<>(aVar);
    }

    public void a(TextureView textureView) {
        b(textureView);
    }

    public void a(Surface surface) {
        b(surface);
    }

    public void a(TXSVideoFrame tXSVideoFrame, int i2, int i3, int i4) {
        if (i4 != this.t) {
            this.t = i4;
            d(this.s);
        }
        a(i2, i3);
        b();
    }

    public void a(int i2, int i3, int i4, boolean z2, int i5) {
        a(i3, i4);
    }

    public void i() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.C = true;
        } else {
            this.C = false;
        }
        this.B = false;
        q();
    }

    public void j() {
        this.B = false;
        this.C = false;
        this.v = null;
        if (this.k == 1) {
            this.k = -1;
            h();
            synchronized (this) {
                if (this.p != null) {
                    this.p.a();
                    this.p = null;
                }
            }
        }
    }

    public void b(int i2, int i3) {
        a(i2, i3);
    }

    public void c(int i2) {
        this.u = i2;
        d dVar = this.f31942e;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void d(int i2) {
        this.s = i2;
        d dVar = this.f31942e;
        if (dVar != null) {
            dVar.c((i2 + this.t) % 360);
        }
    }

    public int k() {
        TextureView textureView = this.f31941d;
        if (textureView != null) {
            return textureView.getWidth();
        }
        if (this.r != null) {
            return this.l;
        }
        return 0;
    }

    public int l() {
        TextureView textureView = this.f31941d;
        if (textureView != null) {
            return textureView.getHeight();
        }
        if (this.r != null) {
            return this.m;
        }
        return 0;
    }

    public int m() {
        return this.h;
    }

    public int n() {
        return this.i;
    }

    public void e(int i2) {
        this.w = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if (r1.equals(r4) == false) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.view.TextureView r4) {
        /*
            r3 = this;
            r0 = 0
            r3.k = r0
            android.view.TextureView r1 = r3.f31941d
            if (r1 != 0) goto L_0x0009
            if (r4 != 0) goto L_0x0013
        L_0x0009:
            android.view.TextureView r1 = r3.f31941d
            if (r1 == 0) goto L_0x0014
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "play:vrender: set video view @old="
            r1.append(r2)
            android.view.TextureView r2 = r3.f31941d
            r1.append(r2)
            java.lang.String r2 = ",new="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = "id "
            r1.append(r2)
            java.lang.String r2 = r3.getID()
            r1.append(r2)
            java.lang.String r2 = "_"
            r1.append(r2)
            int r2 = r3.j
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TXCVideoRender"
            com.tencent.liteav.basic.log.TXCLog.w(r2, r1)
            if (r0 == 0) goto L_0x00d3
            android.view.TextureView r0 = r3.f31941d
            if (r0 == 0) goto L_0x0061
            android.graphics.SurfaceTexture r1 = r3.f31939b
            if (r1 != 0) goto L_0x0061
            android.graphics.SurfaceTexture r0 = r0.getSurfaceTexture()
            r3.b((android.graphics.SurfaceTexture) r0)
            android.view.TextureView r0 = r3.f31941d
            r1 = 0
            r0.setSurfaceTextureListener(r1)
        L_0x0061:
            r3.f31941d = r4
            android.view.TextureView r4 = r3.f31941d
            if (r4 == 0) goto L_0x00d3
            int r4 = r4.getWidth()
            r3.f31943f = r4
            android.view.TextureView r4 = r3.f31941d
            int r4 = r4.getHeight()
            r3.f31944g = r4
            com.tencent.liteav.renderer.d r4 = new com.tencent.liteav.renderer.d
            android.view.TextureView r0 = r3.f31941d
            r4.<init>(r0)
            r3.f31942e = r4
            com.tencent.liteav.renderer.d r4 = r3.f31942e
            int r0 = r3.h
            int r1 = r3.i
            r4.b(r0, r1)
            com.tencent.liteav.renderer.d r4 = r3.f31942e
            int r0 = r3.f31943f
            int r1 = r3.f31944g
            r4.a(r0, r1)
            com.tencent.liteav.renderer.d r4 = r3.f31942e
            int r0 = r3.u
            r4.a((int) r0)
            com.tencent.liteav.renderer.d r4 = r3.f31942e
            int r0 = r3.s
            int r1 = r3.t
            int r0 = r0 + r1
            int r0 = r0 % 360
            r4.c((int) r0)
            android.view.TextureView r4 = r3.f31941d
            r4.setSurfaceTextureListener(r3)
            android.graphics.SurfaceTexture r4 = r3.f31939b
            if (r4 == 0) goto L_0x00c2
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r4 < r0) goto L_0x00d3
            android.view.TextureView r4 = r3.f31941d
            android.graphics.SurfaceTexture r4 = r4.getSurfaceTexture()
            android.graphics.SurfaceTexture r0 = r3.f31939b
            if (r4 == r0) goto L_0x00d3
            android.view.TextureView r4 = r3.f31941d
            r4.setSurfaceTexture(r0)
            goto L_0x00d3
        L_0x00c2:
            android.view.TextureView r4 = r3.f31941d
            boolean r4 = r4.isAvailable()
            if (r4 == 0) goto L_0x00d3
            android.view.TextureView r4 = r3.f31941d
            android.graphics.SurfaceTexture r4 = r4.getSurfaceTexture()
            r3.a((android.graphics.SurfaceTexture) r4)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.e.b(android.view.TextureView):void");
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        if (this.h != i2 || this.i != i3) {
            if (this.h != i2 || this.i != i3) {
                this.h = i2;
                this.i = i3;
                d dVar = this.f31942e;
                if (dVar != null) {
                    dVar.b(this.h, this.i);
                }
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        TXCLog.w("TXCVideoRender", "play:vrender: texture available @" + surfaceTexture + "id " + getID() + "_" + this.j);
        this.f31943f = i2;
        this.f31944g = i3;
        d dVar = this.f31942e;
        if (dVar != null) {
            dVar.a(this.f31943f, this.f31944g);
        }
        if (this.f31939b != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                SurfaceTexture surfaceTexture2 = this.f31941d.getSurfaceTexture();
                SurfaceTexture surfaceTexture3 = this.f31939b;
                if (surfaceTexture2 != surfaceTexture3) {
                    this.f31941d.setSurfaceTexture(surfaceTexture3);
                }
            }
            this.f31939b = null;
            return;
        }
        a(surfaceTexture);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + i2 + "," + i3 + " old:" + this.f31943f + "," + this.f31944g);
        this.f31943f = i2;
        this.f31944g = i3;
        d dVar = this.f31942e;
        if (dVar != null) {
            dVar.a(this.f31943f, this.f31944g);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.C + "id " + getID() + "_" + this.j);
            if (this.C) {
                this.f31939b = surfaceTexture;
            } else {
                this.D.f31948a = 0;
                b(surfaceTexture);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.f31939b == null;
    }

    private void b(Surface surface) {
        TXCLog.i("TXCVideoRender", "surface-render: set surface " + surface);
        if (this.r == surface) {
            TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
            return;
        }
        this.r = surface;
        this.k = 1;
        if (surface != null) {
            g();
            return;
        }
        synchronized (this) {
            if (this.p != null) {
                this.p.a();
                this.p = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        synchronized (this) {
            if (this.p != null) {
                this.p.a();
                this.p = null;
            }
        }
        h hVar = this.q;
        if (hVar != null) {
            hVar.c();
            this.q = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(EGLContext eGLContext, int i2, float[] fArr, boolean z2) {
        if (this.k == 1) {
            int[] a2 = a(i2, this.h, this.i, fArr, z2);
            this.v = a2;
            int i3 = a2[0];
            int i4 = a2[1];
            int i5 = a2[2];
            synchronized (this) {
                if (this.r != null) {
                    if (!(this.p == null || this.p.b() == this.r)) {
                        this.p.a();
                        this.p = null;
                    }
                    if (this.p == null && this.k == 1) {
                        this.p = new d();
                        this.p.a(eGLContext, this.r);
                    }
                    if (this.p != null && this.k == 1) {
                        if (z2) {
                            this.p.a(i3, true, 180, this.l, this.m, i4, i5, false);
                        } else {
                            this.p.a(i3, false, 0, this.l, this.m, i4, i5, false);
                        }
                    }
                } else if (this.p != null) {
                    this.p.a();
                    this.p = null;
                }
            }
        }
    }

    private int[] a(int i2, int i3, int i4, float[] fArr, boolean z2) {
        h hVar = this.q;
        if (!(hVar == null || hVar.a() == z2)) {
            this.q.c();
            this.q = null;
        }
        if (this.q == null) {
            this.q = new h(Boolean.valueOf(z2));
            this.q.b();
        }
        if (fArr != null) {
            this.q.a(fArr);
        } else {
            this.q.a(f31938a);
        }
        int i5 = this.l;
        int i6 = this.m;
        if (this.u == 0) {
            this.q.a(h.f31955a);
        } else {
            this.q.a(h.f31956b);
        }
        this.q.b((this.s + this.t) % 360);
        this.q.b(i3, i4);
        this.q.a(i5, i6);
        return new int[]{this.q.d(i2), i5, i6};
    }

    public void c(final int i2, final int i3) {
        if (i2 != this.l || i3 != this.m) {
            if (this.p == null || this.k != 1 || this.v == null) {
                this.l = i2;
                this.m = i3;
                return;
            }
            this.p.a((Runnable) new Runnable() {
                public void run() {
                    e eVar = e.this;
                    eVar.l = i2;
                    eVar.m = i3;
                    if (eVar.p != null) {
                        e.this.p.a(e.this.v[0], false, 0, e.this.l, e.this.m, e.this.v[1], e.this.v[2], true);
                    }
                }
            });
        }
    }

    public void q() {
        a aVar = this.D;
        aVar.f31948a = 0;
        aVar.f31949b = 0;
        aVar.f31950c = 0;
        aVar.f31951d = 0;
        aVar.f31952e = 0;
        aVar.f31953f = 0;
        aVar.f31954g = 0;
        aVar.h = 0;
        aVar.i = 0;
        aVar.j = 0;
        aVar.k = 0;
        setStatusValue(BaseConstants.ERR_PARSE_RESPONSE_FAILED, this.j, 0L);
        setStatusValue(BaseConstants.ERR_SERIALIZE_REQ_FAILED, this.j, Double.valueOf(0.0d));
        setStatusValue(BaseConstants.ERR_NO_SUCC_RESULT, this.j, 0L);
        setStatusValue(BaseConstants.ERR_LOADMSG_FAILED, this.j, 0L);
        setStatusValue(BaseConstants.ERR_FILE_TRANS_AUTH_FAILED, this.j, 0L);
        setStatusValue(BaseConstants.ERR_INVALID_CONVERSATION, this.j, 0L);
    }

    private long a(long j2) {
        long timeTick = TXCTimeUtil.getTimeTick();
        if (j2 > timeTick) {
            return 0;
        }
        return timeTick - j2;
    }

    public void r() {
        if (this.D.f31948a == 0) {
            this.D.f31948a = TXCTimeUtil.getTimeTick();
            return;
        }
        long timeTick = TXCTimeUtil.getTimeTick() - this.D.f31948a;
        if (timeTick >= 1000) {
            double d2 = (double) (this.D.f31950c - this.D.f31949b);
            Double.isNaN(d2);
            double d3 = (double) timeTick;
            Double.isNaN(d3);
            double doubleValue = Double.valueOf((d2 * 1000.0d) / d3).doubleValue();
            setStatusValue(BaseConstants.ERR_SERIALIZE_REQ_FAILED, this.j, Double.valueOf(doubleValue));
            TXCKeyPointReportProxy.a(getID(), 40001, (int) doubleValue);
            a aVar = this.D;
            aVar.f31949b = aVar.f31950c;
            this.D.f31948a += timeTick;
        }
    }

    private void b() {
        if (!this.B) {
            Bundle bundle = new Bundle();
            bundle.putString("EVT_USERID", getID());
            bundle.putInt("EVT_ID", 2003);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "渲染首个视频数据包(IDR)");
            bundle.putInt("EVT_PARAM1", this.h);
            bundle.putInt("EVT_PARAM2", this.i);
            b.a(this.o, 2003, bundle);
            setStatusValue(BaseConstants.ERR_PARSE_RESPONSE_FAILED, this.j, Long.valueOf(TXCTimeUtil.getTimeTick()));
            TXCLog.d("TXCVideoRender", "trtc_render render first frame " + getID() + ", " + this.j);
            this.B = true;
        }
        this.D.f31950c++;
        r();
        if (this.D.f31951d != 0) {
            a aVar = this.D;
            aVar.i = a(aVar.f31951d);
            if (this.D.i > ((long) this.w)) {
                this.D.f31952e++;
                setStatusValue(BaseConstants.ERR_NO_SUCC_RESULT, this.j, Long.valueOf(this.D.f31952e));
                if (this.D.i > this.D.h) {
                    a aVar2 = this.D;
                    aVar2.h = aVar2.i;
                    setStatusValue(BaseConstants.ERR_LOADMSG_FAILED, this.j, Long.valueOf(this.D.h));
                }
                this.D.f31954g += this.D.i;
                setStatusValue(BaseConstants.ERR_FILE_TRANS_AUTH_FAILED, this.j, Long.valueOf(this.D.f31954g));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.D.f31950c + " block time:" + this.D.i + "> 500");
                this.x = this.x + 1;
                this.z = this.z + this.D.i;
            }
            if (this.D.i > ((long) this.f31940c)) {
                TXCLog.w("TXCVideoRender", "render frame count:" + this.D.f31950c + " block time:" + this.D.i + "> " + this.f31940c);
            }
            if (this.D.i > 1000) {
                this.D.f31953f++;
                setStatusValue(BaseConstants.ERR_INVALID_CONVERSATION, this.j, Long.valueOf(this.D.f31953f));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.D.f31950c + " block time:" + this.D.i + "> 1000");
                b.a(this.o, getID(), 2105, "当前视频播放出现卡顿" + this.D.i + "ms");
            }
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        long j2 = this.y;
        if (j2 == 0) {
            this.y = timeTick;
        } else if (timeTick - j2 >= 2000) {
            setStatusValue(17015, this.j, Long.valueOf(this.x));
            setStatusValue(17016, this.j, Long.valueOf(this.z));
            this.x = 0;
            this.y = timeTick;
            this.z = 0;
            if (this.A != 0) {
                TXCKeyPointReportProxy.a(getID(), 40005, (int) this.D.f31954g);
                TXCKeyPointReportProxy.a(getID(), 40006, (int) (timeTick - this.A));
            }
        }
        this.D.f31951d = TXCTimeUtil.getTimeTick();
        if (this.A == 0) {
            this.A = this.D.f31951d;
        }
        a aVar3 = this.D;
        aVar3.k = this.i;
        aVar3.j = this.h;
    }
}
