package com.tencent.liteav;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.liteav.a;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.n;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.e;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import tencent.tls.platform.TLSErrInfo;

public class c extends com.tencent.liteav.basic.module.a implements a.b, d, com.tencent.liteav.basic.c.a, e, m, com.tencent.liteav.videoencoder.d {

    /* renamed from: c  reason: collision with root package name */
    private static final String f31551c = "c";
    /* access modifiers changed from: private */
    public com.tencent.liteav.basic.d.d A = null;
    private int B = 0;
    /* access modifiers changed from: private */
    public b C;
    /* access modifiers changed from: private */
    public int D = 0;
    private boolean E = false;
    private boolean F = false;
    private long G = 0;
    private long H = 0;
    /* access modifiers changed from: private */
    public int I = 0;
    /* access modifiers changed from: private */
    public byte[] J;
    private WeakReference<p> K;
    private WeakReference<a> L = null;
    /* access modifiers changed from: private */
    public g M = null;
    private g N;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private WeakReference<com.tencent.liteav.basic.c.a> R;
    private WeakReference<n> S;
    private int T = 0;
    private int U = 0;
    private boolean V = false;
    private int W = -1;
    private int X = -1;
    private int Y = 10;

    /* renamed from: a  reason: collision with root package name */
    a f31552a;

    /* renamed from: b  reason: collision with root package name */
    boolean f31553b = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public l f31554d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.tencent.liteav.beauty.c f31555e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31556f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f31557g = -1;
    /* access modifiers changed from: private */
    public TXSVideoEncoderParam h = null;
    /* access modifiers changed from: private */
    public com.tencent.liteav.videoencoder.b i = null;
    private int j = 15;
    private boolean k = false;
    private TXSVideoEncoderParam l = null;
    private com.tencent.liteav.videoencoder.b m = null;
    private Context n = null;
    /* access modifiers changed from: private */
    public f o = null;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private float t = 1.0f;
    private int u = 0;
    private float v = BitmapDescriptorFactory.HUE_RED;
    private TXCloudVideoView w = null;
    private Surface x = null;
    /* access modifiers changed from: private */
    public int y = 0;
    /* access modifiers changed from: private */
    public int z = 0;

    public interface a {
        void a(MediaFormat mediaFormat);

        void a(TXSNALPacket tXSNALPacket);

        void a(byte[] bArr, long j, int i, int i2);

        void a(byte[] bArr, long j, int i, int i2, int i3);

        void a(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    public void b(byte[] bArr, int i2, int i3, int i4, long j2) {
    }

    public c(Context context) {
        this.n = context.getApplicationContext();
        this.o = new f();
        this.f31555e = new com.tencent.liteav.beauty.c(this.n, true);
        this.f31555e.a((e) this);
        this.f31555e.a((com.tencent.liteav.basic.c.a) this);
        this.h = new TXSVideoEncoderParam();
        this.i = null;
        this.l = new TXSVideoEncoderParam();
        this.f31552a = new a(this);
        com.tencent.liteav.basic.e.b.a().a(this.n);
    }

    public void a(a aVar) {
        this.L = new WeakReference<>(aVar);
    }

    public void a(f fVar) {
        boolean z2 = true;
        boolean z3 = (fVar == null || (this.o.y == fVar.y && this.o.z == fVar.z && this.o.A == fVar.A && this.o.D == fVar.D && this.o.B == fVar.B && this.o.C == fVar.C)) ? false : true;
        boolean z4 = (fVar == null || (this.o.f31618a == fVar.f31618a && this.o.f31619b == fVar.f31619b)) ? false : true;
        if (fVar != null) {
            try {
                this.o = (f) fVar.clone();
            } catch (CloneNotSupportedException e2) {
                this.o = new f();
                e2.printStackTrace();
            }
        } else {
            this.o = new f();
        }
        if (!z4 || this.o.N) {
            z2 = false;
        }
        f(z2);
        if (l()) {
            y();
            A();
            l lVar = this.f31554d;
            if (lVar != null) {
                lVar.e(this.o.l);
            }
            if (z3) {
                z();
            }
        }
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        this.R = new WeakReference<>(aVar);
    }

    public void a(byte[] bArr) {
        com.tencent.liteav.audio.b.a().a(bArr);
    }

    public void a(n nVar) {
        this.S = new WeakReference<>(nVar);
    }

    public int b() {
        return this.h.width;
    }

    public int c() {
        return this.h.height;
    }

    public void setID(String str) {
        super.setID(str);
        com.tencent.liteav.videoencoder.b bVar = this.i;
        if (bVar != null) {
            bVar.setID(str);
        }
        com.tencent.liteav.videoencoder.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.setID(str);
        }
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.setID(str);
        }
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a(getID());
        }
        com.tencent.liteav.audio.b.a().a(str);
    }

    public String d() {
        return com.tencent.liteav.audio.b.a().f() + " | " + com.tencent.liteav.audio.b.a().e() + "," + com.tencent.liteav.audio.b.a().d();
    }

    public int e() {
        int f2 = f();
        if (f2 == 0) {
            h();
        }
        return f2;
    }

    public int f() {
        if (l()) {
            String str = f31551c;
            TXCLog.w(str, "ignore startPush when pushing, status:" + this.q);
            return -2;
        }
        TXCDRApi.initCrashReport(this.n);
        this.q = 1;
        TXCLog.d(f31551c, "startWithoutAudio");
        A();
        TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.br);
        return 0;
    }

    public void g() {
        if (!l()) {
            String str = f31551c;
            TXCLog.w(str, "ignore stopPush when not pushing, status:" + this.q);
            return;
        }
        TXCLog.d(f31551c, "stop");
        this.q = 0;
        i();
        v();
        this.o.J = false;
        a aVar = this.f31552a;
        if (aVar != null) {
            aVar.a();
        }
        this.C = null;
    }

    public void h() {
        y();
        com.tencent.liteav.audio.b.a().a((d) this);
        this.O = false;
        TXCKeyPointReportProxy.a(30002);
        f fVar = this.o;
        if ((fVar == null || !fVar.G) && this.p != 1) {
            l lVar = this.f31554d;
            if (lVar != null && !lVar.d()) {
                l lVar2 = this.f31554d;
                if (lVar2 != null) {
                    lVar2.e(true);
                    return;
                }
                return;
            }
        }
        if (com.tencent.liteav.audio.b.a().a(this.n) == 0) {
            b((int) TXLiteAVCode.EVT_MIC_START_SUCC, "打开麦克风成功");
        }
    }

    public void i() {
        TXCKeyPointReportProxy.a(31003);
        TXCLog.d(f31551c, "stopAudioRecord");
        TXCKeyPointReportProxy.a(31003, com.tencent.liteav.audio.b.a().b());
        com.tencent.liteav.audio.b.a().a((d) null);
        this.v = BitmapDescriptorFactory.HUE_RED;
        this.f31553b = false;
    }

    public void j() {
        if (this.q != 1) {
            String str = f31551c;
            TXCLog.w(str, "ignore pause push when is not pushing, status:" + this.q);
            return;
        }
        this.q = 2;
        TXCLog.d(f31551c, "pausePusher");
        if ((this.o.x & 1) == 1) {
            if (!(this.f31552a == null || this.o.G || this.f31554d == null)) {
                this.f31552a.a(this.o.w, this.o.v, this.o.u, this.h.width, this.h.height);
            }
            l lVar = this.f31554d;
            if (lVar != null) {
                lVar.c();
            }
        }
        if ((this.o.x & 2) == 2) {
            com.tencent.liteav.audio.b.a().c(true);
        }
    }

    public void k() {
        if (this.q != 2) {
            String str = f31551c;
            TXCLog.w(str, "ignore resume push when is not pause, status:" + this.q);
            return;
        }
        this.q = 1;
        TXCLog.d(f31551c, "resumePusher");
        if ((this.o.x & 1) == 1) {
            if (this.f31552a != null && !this.o.G) {
                this.f31552a.a();
            }
            l lVar = this.f31554d;
            if (lVar != null) {
                lVar.b();
            }
            z();
        }
        if ((this.o.x & 2) == 2) {
            com.tencent.liteav.audio.b.a().c(this.V);
            if ((1 & this.o.L) == 0) {
                com.tencent.liteav.audio.b.a().b();
                com.tencent.liteav.audio.b.a().a(this.o.q);
                com.tencent.liteav.audio.b.a().a(this.o.s, this.n);
                com.tencent.liteav.audio.b.a().d(this.u);
                com.tencent.liteav.audio.b.a().a(this.W, this.X);
                com.tencent.liteav.audio.b.a().a(this.t);
                com.tencent.liteav.audio.b.a().c(this.V);
                com.tencent.liteav.audio.b.a().f(this.Y);
                com.tencent.liteav.audio.b.a().a((d) this);
                com.tencent.liteav.audio.b.a().d(this.f31553b);
                com.tencent.liteav.audio.b.a().a(this.n);
            }
        }
    }

    public void a(final int i2, final int i3, final int i4) {
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a((Runnable) new Runnable() {
                public void run() {
                    if (!(i3 == 0 || i4 == 0)) {
                        c.this.o.f31618a = i3;
                        c.this.o.f31619b = i4;
                        if (c.this.f31554d != null) {
                            c.this.f31554d.a(i3, i4);
                        }
                    }
                    if (i2 != 0 && c.this.i != null) {
                        c.this.o.f31620c = i2;
                        c.this.i.b(i2);
                    }
                }
            });
        }
    }

    public boolean l() {
        return this.q != 0;
    }

    public void m() {
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.f31554d != null) {
                        c.this.f31554d.b(true);
                    }
                    c cVar = c.this;
                    cVar.c(cVar.h.width, c.this.h.height);
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.tencent.liteav.basic.d.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.tencent.liteav.renderer.TXCGLSurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.tencent.liteav.basic.d.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.tencent.liteav.basic.d.e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.rtmp.ui.TXCloudVideoView r6) {
        /*
            r5 = this;
            com.tencent.liteav.f r0 = r5.o
            boolean r0 = r0.G
            if (r0 == 0) goto L_0x000e
            java.lang.String r6 = f31551c
            java.lang.String r0 = "enable pure audio push , so can not start preview!"
            com.tencent.liteav.basic.log.TXCLog.e(r6, r0)
            return
        L_0x000e:
            com.tencent.liteav.f r0 = r5.o
            boolean r0 = r0.P
            r1 = 0
            if (r6 == 0) goto L_0x0025
            r6.getGLSurfaceView()
            com.tencent.liteav.renderer.TXCGLSurfaceView r2 = new com.tencent.liteav.renderer.TXCGLSurfaceView
            android.content.Context r3 = r6.getContext()
            r2.<init>(r3)
            r6.addVideoView((com.tencent.liteav.renderer.TXCGLSurfaceView) r2)
            goto L_0x002b
        L_0x0025:
            com.tencent.liteav.basic.d.e r2 = new com.tencent.liteav.basic.d.e
            r2.<init>()
            r0 = 0
        L_0x002b:
            r5.p = r1
            com.tencent.liteav.b r1 = new com.tencent.liteav.b
            android.content.Context r3 = r5.n
            com.tencent.liteav.f r4 = r5.o
            r1.<init>(r3, r4, r2, r0)
            r5.f31554d = r1
            int r0 = r5.D
            r5.k((int) r0)
            com.tencent.liteav.l r0 = r5.f31554d
            java.lang.String r1 = r5.getID()
            r0.a((java.lang.String) r1)
            com.tencent.liteav.l r0 = r5.f31554d
            r0.a((com.tencent.liteav.m) r5)
            com.tencent.liteav.l r0 = r5.f31554d
            r0.a((com.tencent.liteav.basic.c.a) r5)
            com.tencent.liteav.l r0 = r5.f31554d
            r0.a()
            com.tencent.liteav.l r0 = r5.f31554d
            int r1 = r5.r
            r0.b((int) r1)
            com.tencent.liteav.l r0 = r5.f31554d
            int r1 = r5.s
            r0.c((int) r1)
            com.tencent.liteav.l r0 = r5.f31554d
            int r1 = r5.U
            r0.d((int) r1)
            r5.w = r6
            com.tencent.rtmp.ui.TXCloudVideoView r6 = r5.w
            if (r6 == 0) goto L_0x007d
            com.tencent.liteav.f r0 = r5.o
            boolean r0 = r0.E
            com.tencent.liteav.f r1 = r5.o
            boolean r1 = r1.F
            com.tencent.liteav.l r2 = r5.f31554d
            r6.start(r0, r1, r2)
        L_0x007d:
            r6 = 30003(0x7533, float:4.2043E-41)
            com.tencent.liteav.basic.module.TXCKeyPointReportProxy.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.c.a(com.tencent.rtmp.ui.TXCloudVideoView):void");
    }

    public void a(boolean z2) {
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a(z2);
            this.f31554d = null;
            TXCloudVideoView tXCloudVideoView = this.w;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.stop(z2);
                this.w = null;
            }
            this.x = null;
            com.tencent.liteav.basic.d.d dVar = this.A;
            if (dVar != null) {
                dVar.a();
                this.A = null;
            }
        }
    }

    public void a(Surface surface) {
        if (this.w != null) {
            TXCLog.w(f31551c, "camera preview view is not null, can't set surface");
        } else {
            this.x = surface;
        }
    }

    public void a(final int i2, final int i3) {
        com.tencent.liteav.basic.d.d dVar = this.A;
        if (dVar != null) {
            dVar.a((Runnable) new Runnable() {
                public void run() {
                    int unused = c.this.y = i2;
                    int unused2 = c.this.z = i3;
                    if (c.this.C != null && c.this.A != null) {
                        c cVar = c.this;
                        cVar.a(cVar.C, true);
                    }
                }
            });
            return;
        }
        this.y = i2;
        this.z = i3;
    }

    public void a(final n nVar) {
        TXCloudVideoView tXCloudVideoView = this.w;
        if (tXCloudVideoView != null) {
            TXCGLSurfaceView gLSurfaceView = tXCloudVideoView.getGLSurfaceView();
            if (gLSurfaceView != null) {
                gLSurfaceView.a((n) new n() {
                    public void a(Bitmap bitmap) {
                        n nVar = nVar;
                        if (nVar != null) {
                            nVar.a(bitmap);
                        }
                    }
                });
                return;
            }
            return;
        }
        com.tencent.liteav.basic.d.d dVar = this.A;
        if (dVar != null) {
            dVar.a((n) new n() {
                public void a(Bitmap bitmap) {
                    n nVar = nVar;
                    if (nVar != null) {
                        nVar.a(bitmap);
                    }
                }
            });
        }
    }

    public void n() {
        if (Build.VERSION.SDK_INT < 21) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
            onNotifyEvent(-1309, bundle);
            String str = f31551c;
            TXLog.e(str, "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
            return;
        }
        this.p = 1;
        this.f31554d = new h(this.n, this.o);
        this.f31554d.a((com.tencent.liteav.basic.c.a) this);
        this.f31554d.a((m) this);
        this.f31554d.a();
        this.f31554d.a(getID());
        TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.aG);
    }

    public void o() {
        if (this.f31554d != null) {
            v();
            this.f31554d.a(false);
            this.f31554d = null;
        }
    }

    public void a(int i2) {
        this.r = i2;
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.b(i2);
        }
    }

    public boolean b(boolean z2) {
        l lVar = this.f31554d;
        if (lVar == null) {
            return false;
        }
        return lVar.d(z2);
    }

    public boolean b(int i2, int i3, int i4) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar == null) {
            return true;
        }
        cVar.c(i2);
        this.f31555e.d(i3);
        this.f31555e.e(i4);
        return true;
    }

    public void b(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    public void a(Bitmap bitmap) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.a(bitmap);
        }
    }

    public void a(String str) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void c(boolean z2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.c(z2);
        }
    }

    @TargetApi(18)
    public boolean b(String str) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            return cVar.a(str, true);
        }
        return false;
    }

    public void c(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.g(i2);
        }
    }

    public void d(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void a(float f2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.a(f2);
        }
    }

    public void e(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.i(i2);
        }
    }

    public void f(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.j(i2);
        }
    }

    public void g(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.k(i2);
        }
    }

    public void h(int i2) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.l(i2);
        }
    }

    public void d(boolean z2) {
        this.V = z2;
        com.tencent.liteav.audio.b.a().c(z2);
    }

    public boolean p() {
        return this.V;
    }

    public void b(int i2, int i3) {
        this.W = i2;
        this.X = i3;
        com.tencent.liteav.audio.b.a().a(i2, i3);
    }

    public void b(float f2) {
        this.v = f2;
        TXCLiveBGMPlayer.getInstance().setPitch(f2);
    }

    public int q() {
        l lVar = this.f31554d;
        if (lVar == null) {
            return 0;
        }
        return lVar.e();
    }

    public boolean i(int i2) {
        l lVar = this.f31554d;
        if (lVar == null) {
            return false;
        }
        return lVar.a(i2);
    }

    public boolean e(boolean z2) {
        this.o.M = z2;
        l lVar = this.f31554d;
        if (lVar == null) {
            return false;
        }
        lVar.c(z2);
        return true;
    }

    public void c(float f2) {
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a(f2);
        }
    }

    public void j(int i2) {
        this.u = i2;
        com.tencent.liteav.audio.b.a().d(i2);
        TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.az);
    }

    public void k(int i2) {
        this.D = i2;
        l lVar = this.f31554d;
        if (lVar != null && (lVar instanceof b)) {
            ((b) lVar).g(this.D);
        }
    }

    private void b(int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", getID());
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        com.tencent.liteav.basic.util.b.a(this.R, i2, bundle);
        if (i2 == -1317) {
            TXCEventRecorderProxy.a(getID(), 2002, 4, -1, "", this.D);
        } else if (i2 == -1314) {
            TXCEventRecorderProxy.a(getID(), 2002, 5, -1, "", this.D);
        } else if (i2 == 1003 && this.f31554d != null) {
            TXCEventRecorderProxy.a(getID(), 4001, this.f31554d.g() ^ true ? 1 : 0, -1, "", this.D);
        }
        if (i2 == -1302 || i2 == -1317 || i2 == -1318 || i2 == -1319) {
            TXCKeyPointReportProxy.a(30002, i2);
        } else if (i2 == -1301 || i2 == -1314 || i2 == -1315 || i2 == -1316) {
            TXCKeyPointReportProxy.a(30003, i2);
            if (this.f31554d != null) {
                String id = getID();
                int i3 = this.D;
                TXCEventRecorderProxy.a(id, 4002, this.f31554d.g() ^ true ? 1 : 0, i2, "", i3);
            }
        }
    }

    public boolean c(String str) {
        if (!com.tencent.liteav.audio.b.a().c()) {
            return false;
        }
        TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.aA);
        return TXCLiveBGMPlayer.getInstance().startPlay(str, com.tencent.liteav.audio.b.a().f());
    }

    public boolean r() {
        TXCLiveBGMPlayer.getInstance().stopPlay();
        return true;
    }

    public boolean s() {
        TXCLiveBGMPlayer.getInstance().pause();
        return true;
    }

    public boolean t() {
        TXCLiveBGMPlayer.getInstance().resume();
        return true;
    }

    public boolean d(float f2) {
        this.t = f2;
        com.tencent.liteav.audio.b.a().a(f2);
        return true;
    }

    public boolean e(float f2) {
        TXCLiveBGMPlayer.getInstance().setVolume(f2);
        return true;
    }

    public int d(String str) {
        return (int) TXCLiveBGMPlayer.getInstance().getMusicDuration(str);
    }

    public void a(com.tencent.liteav.audio.e eVar) {
        TXCLiveBGMPlayer.getInstance().setOnPlayListener(eVar);
    }

    public int a(byte[] bArr, int i2, int i3, int i4, long j2) {
        int a2 = a(i3, i4, (Object) null);
        if (a2 != 0) {
            return a2;
        }
        if (this.i == null) {
            return 0;
        }
        if (j2 == 0) {
            j2 = TXCTimeUtil.getTimeTick();
        }
        this.i.a(bArr, i2, i3, i4, j2);
        return 0;
    }

    public int c(int i2, int i3, int i4) {
        int a2 = a(i3, i4, (Object) ((EGL10) EGLContext.getEGL()).eglGetCurrentContext());
        if (a2 != 0) {
            return a2;
        }
        com.tencent.liteav.videoencoder.b bVar = this.i;
        if (bVar == null) {
            return 0;
        }
        bVar.a(i2, i3, i4, TXCTimeUtil.getTimeTick());
        return 0;
    }

    public void a(byte[] bArr, long j2, int i2, int i3, int i4, boolean z2) {
        if (!this.O) {
            this.O = true;
            TXCKeyPointReportProxy.a(30002, 0);
        }
        WeakReference<a> weakReference = this.L;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.a(bArr, j2, i2, i3, i4, z2);
            }
        }
    }

    public void a(byte[] bArr, long j2, int i2, int i3, int i4) {
        WeakReference<a> weakReference = this.L;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.a(bArr, j2, i2, i3, i4);
            }
        }
    }

    public void b(byte[] bArr, long j2, int i2, int i3, int i4) {
        WeakReference<a> weakReference = this.L;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.a(bArr, j2, i2, i3);
            }
        }
    }

    public void a(int i2, String str) {
        String str2 = f31551c;
        TXCLog.e(str2, "onRecordError code = " + i2 + ":" + str);
        if (i2 == -1) {
            b(-1302, "打开麦克风失败");
        }
    }

    public int a(b bVar) {
        WeakReference<n> weakReference = this.S;
        if (weakReference != null) {
            n nVar = (n) weakReference.get();
            if (nVar != null) {
                bVar.f31404a = nVar.a(bVar.f31404a, bVar.f31408e, bVar.f31409f);
            }
        }
        c(bVar);
        a(bVar, false);
        return bVar.f31404a;
    }

    public void a(b bVar, long j2) {
        d(bVar.f31404a, bVar.f31408e, bVar.f31409f);
    }

    public void a(TXSNALPacket tXSNALPacket, int i2) {
        if (i2 == 0) {
            this.H = tXSNALPacket.gopIndex;
            this.G = tXSNALPacket.frameIndex;
            WeakReference<a> weakReference = this.L;
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.a(tXSNALPacket);
                }
            }
        } else if (i2 == 10000004 && this.f31557g == 1) {
            this.o.j = 0;
            b(1103, "硬编码启动失败,采用软编码");
            TXCEventRecorderProxy.a(getID(), 4011, -1, -1, TXCStatus.b(getID(), IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE), this.D);
        }
    }

    public void a(MediaFormat mediaFormat) {
        WeakReference<a> weakReference = this.L;
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.a(mediaFormat);
            }
        }
    }

    public void a(long j2, long j3, long j4) {
        this.H = j3;
        this.G = j4;
    }

    public void onNotifyEvent(int i2, Bundle bundle) {
        if (bundle != null) {
            bundle.putString("EVT_USERID", getID());
        }
        com.tencent.liteav.basic.util.b.a(this.R, i2, bundle);
        if (i2 == -1317) {
            TXCEventRecorderProxy.a(getID(), 2002, 4, -1, "", this.D);
        } else if (i2 == -1314) {
            TXCEventRecorderProxy.a(getID(), 2002, 5, -1, "", this.D);
        } else if (i2 == 1003 && this.f31554d != null) {
            TXCEventRecorderProxy.a(getID(), 4001, this.f31554d.g() ^ true ? 1 : 0, -1, "", this.D);
        }
        if (i2 == -1302 || i2 == -1317 || i2 == -1318 || i2 == -1319) {
            TXCKeyPointReportProxy.a(30002, i2);
        } else if (i2 == -1301 || i2 == -1314 || i2 == -1315 || i2 == -1316) {
            TXCKeyPointReportProxy.a(30003, i2);
            if (this.f31554d != null) {
                String id = getID();
                int i3 = this.D;
                TXCEventRecorderProxy.a(id, 4002, this.f31554d.g() ^ true ? 1 : 0, i2, "", i3);
            }
        }
    }

    public void a(Bitmap bitmap, ByteBuffer byteBuffer, int i2, int i3) {
        l lVar = this.f31554d;
        if (lVar != null) {
            final Bitmap bitmap2 = bitmap;
            final int i4 = i2;
            final int i5 = i3;
            final ByteBuffer byteBuffer2 = byteBuffer;
            lVar.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        c.this.f31555e.a(com.tencent.liteav.basic.util.b.a(width, height, i4, i5));
                        c.this.f31555e.b(false);
                        if (c.this.o.P) {
                            c.this.f31555e.a(false);
                        }
                        c.this.f31555e.a(i4, i5);
                        c.this.f31555e.a(0);
                        c.this.f31555e.a(byteBuffer2.array(), width, height, 0, 2, 0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(final com.tencent.liteav.videoencoder.b bVar) {
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        if (bVar != null) {
                            bVar.a();
                            bVar.a((com.tencent.liteav.videoencoder.d) null);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else if (bVar != null) {
            try {
                bVar.a();
                bVar.a((com.tencent.liteav.videoencoder.d) null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a() {
        com.tencent.liteav.audio.b.a().b();
        com.tencent.liteav.audio.b.a().a((d) null);
        this.f31553b = false;
    }

    public void a(SurfaceTexture surfaceTexture) {
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void b(b bVar) {
        if (!this.P) {
            this.P = true;
            TXCKeyPointReportProxy.a(30003, 0);
        }
        l lVar = this.f31554d;
        if (this.f31555e != null && !this.o.G && lVar != null) {
            if (!(this.h.height == bVar.h && this.h.width == bVar.f31410g)) {
                d(bVar.f31410g, bVar.h);
            }
            this.B = bVar.k;
            this.f31555e.a((Object) lVar.f());
            this.f31555e.a(bVar, bVar.f31405b, 0, 0);
        }
    }

    public void u() {
        String str = f31551c;
        TXCLog.i(str, "onCaptureDestroy->enter with mVideoFrameFilter:" + this.M);
        com.tencent.liteav.beauty.c cVar = this.f31555e;
        if (cVar != null) {
            cVar.b();
        }
        g gVar = this.M;
        if (gVar != null) {
            gVar.d();
            this.M = null;
        }
        g gVar2 = this.N;
        if (gVar2 != null) {
            gVar2.d();
            this.N = null;
        }
        x();
        WeakReference<n> weakReference = this.S;
        if (weakReference != null) {
            n nVar = (n) weakReference.get();
            if (nVar != null) {
                nVar.a();
            }
        }
    }

    private void a(int i2, int i3, int i4, Object obj) {
        Object obj2;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        String str = f31551c;
        TXCLog.d(str, "New encode size width = " + i5 + " height = " + i6 + " encType = " + i7);
        x();
        this.f31557g = i7;
        this.i = new com.tencent.liteav.videoencoder.b(this.f31557g);
        TXCStatus.a(getID(), 4005, this.D, Integer.valueOf(this.f31557g));
        if (this.f31557g == 1) {
            TXCEventRecorderProxy.a(getID(), 4004, 1, -1, "", this.D);
        } else {
            TXCEventRecorderProxy.a(getID(), 4004, 0, -1, "", this.D);
        }
        this.Q = false;
        TXSVideoEncoderParam tXSVideoEncoderParam = this.h;
        tXSVideoEncoderParam.width = i5;
        tXSVideoEncoderParam.height = i6;
        tXSVideoEncoderParam.fps = this.o.h;
        this.h.gop = this.o.i;
        this.h.encoderProfile = this.o.n ? 3 : 1;
        TXSVideoEncoderParam tXSVideoEncoderParam2 = this.h;
        tXSVideoEncoderParam2.encoderMode = 1;
        if (obj != null) {
            obj2 = obj;
        } else {
            obj2 = this.i.a(i5, i6);
        }
        tXSVideoEncoderParam2.glContext = obj2;
        this.h.realTime = this.o.J;
        TXSVideoEncoderParam tXSVideoEncoderParam3 = this.h;
        tXSVideoEncoderParam3.streamType = this.D;
        tXSVideoEncoderParam3.annexb = this.F;
        tXSVideoEncoderParam3.bMultiRef = this.E;
        tXSVideoEncoderParam3.baseFrameIndex = this.G + 20;
        tXSVideoEncoderParam3.baseGopIndex = this.H + 2;
        tXSVideoEncoderParam3.bLimitFps = this.f31556f;
        this.i.a((com.tencent.liteav.videoencoder.d) this);
        this.i.a((com.tencent.liteav.basic.c.a) this);
        this.i.a(this.h);
        this.i.b(this.o.f31620c);
        this.i.c(this.j);
        this.i.setID(getID());
        this.i.a(this.T);
        TXCStatus.a(getID(), 4003, this.D, Integer.valueOf((this.h.width << 16) | this.h.height));
        TXCStatus.a(getID(), 13003, this.D, Integer.valueOf(this.h.gop * 1000));
        TXCEventRecorderProxy.a(getID(), 4003, this.h.width, this.h.height, "", this.D);
    }

    private void a(Object obj) {
        Object obj2;
        TXSVideoEncoderParam tXSVideoEncoderParam = this.l;
        if (tXSVideoEncoderParam != null) {
            w();
            com.tencent.liteav.videoencoder.b bVar = new com.tencent.liteav.videoencoder.b(this.f31557g);
            TXCStatus.a(getID(), 4005, 3, Integer.valueOf(this.f31557g));
            if (this.f31557g == 1) {
                TXCEventRecorderProxy.a(getID(), 4004, 1, -1, "", 3);
            } else {
                TXCEventRecorderProxy.a(getID(), 4004, 0, -1, "", 3);
            }
            if (obj != null) {
                obj2 = obj;
            } else {
                obj2 = this.i.a(tXSVideoEncoderParam.width, tXSVideoEncoderParam.height);
            }
            tXSVideoEncoderParam.glContext = obj2;
            TXCLog.d(f31551c, "start small video encoder");
            bVar.a((com.tencent.liteav.videoencoder.d) this);
            bVar.a((com.tencent.liteav.basic.c.a) this);
            bVar.a(tXSVideoEncoderParam);
            bVar.b(tXSVideoEncoderParam.bitrate);
            bVar.setID(getID());
            bVar.a(this.T);
            this.m = bVar;
        }
    }

    private void d(int i2, int i3, int i4) {
        b(i3, i4, this.f31555e.a());
        com.tencent.liteav.videoencoder.b bVar = this.i;
        if (bVar != null) {
            bVar.a(i2, i3, i4, TXCTimeUtil.getTimeTick());
        }
        com.tencent.liteav.videoencoder.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.a(i2, i3, i4, TXCTimeUtil.getTimeTick());
        }
    }

    private int a(int i2, int i3, Object obj) {
        int i4 = this.o.f31618a;
        int i5 = this.o.f31619b;
        if (this.o.l == 0 || this.o.l == 2) {
            i4 = this.o.f31619b;
            i5 = this.o.f31618a;
        }
        if (i4 <= 0 || i5 <= 0) {
            TXCLog.e(f31551c, "sendCustomYUVData: invalid video encode resolution");
            return -1;
        } else if (this.o.G) {
            x();
            return TLSErrInfo.TIMEOUT;
        } else {
            b(i4, i5, obj);
            return 0;
        }
    }

    private void b(int i2, int i3, Object obj) {
        int i4 = this.o.j;
        int i5 = 2;
        if (i4 != 0) {
            if (i4 == 1) {
                i5 = 1;
            } else if (i4 == 2) {
                i5 = 3;
            }
        }
        if (this.p == 1) {
            i5 = 1;
        }
        int i6 = this.o.i;
        if (!(this.i != null && !this.Q && this.h.width == i2 && this.h.height == i3 && this.f31557g == i5 && this.h.gop == i6)) {
            a(i2, i3, i5, obj);
        }
        if (this.m == null && this.k) {
            a(obj);
        }
    }

    public void v() {
        if (this.i != null) {
            l lVar = this.f31554d;
            if (lVar != null) {
                lVar.a((Runnable) new Runnable() {
                    public void run() {
                        c.this.x();
                    }
                });
            } else {
                x();
            }
        }
    }

    private void w() {
        try {
            if (this.m != null) {
                this.m.a();
                this.m.a((com.tencent.liteav.videoencoder.d) null);
                this.m = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        try {
            TXCLog.d(f31551c, "stopVideoEncoderInGLThread");
            if (this.i != null) {
                this.i.a();
                this.i.a((com.tencent.liteav.videoencoder.d) null);
                this.i = null;
            }
            this.Q = true;
            w();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void y() {
        if ((this.o.L & 1) != 0) {
            com.tencent.liteav.audio.b.a().a(true);
            com.tencent.liteav.audio.b.a().b(this.o.r);
            com.tencent.liteav.audio.b.a().a(this.o.q);
            com.tencent.liteav.audio.b.a().a(false, this.n);
        } else {
            com.tencent.liteav.audio.b.a().b(1);
            com.tencent.liteav.audio.b.a().a(this.o.q);
            com.tencent.liteav.audio.b.a().a(this.o.s, this.n);
        }
        com.tencent.liteav.audio.b.a().c(this.V);
        com.tencent.liteav.audio.b.a().f(this.Y);
        TXCLiveBGMPlayer.getInstance().switchAecType(com.tencent.liteav.audio.b.a().f());
        TXCLiveBGMPlayer.getInstance().setPitch(this.v);
    }

    private void f(final boolean z2) {
        l lVar = this.f31554d;
        if (lVar != null && lVar.d()) {
            this.f31554d.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.f31554d != null) {
                        c.this.f31554d.f(c.this.o.h);
                        c.this.f31554d.a(c.this.o.f31618a, c.this.o.f31619b);
                        if (z2) {
                            c.this.f31554d.b(false);
                        }
                    }
                }
            });
        }
    }

    private void z() {
        l lVar = this.f31554d;
        if (lVar != null) {
            lVar.a((Runnable) new Runnable() {
                public void run() {
                    c cVar = c.this;
                    cVar.c(cVar.h.width, c.this.h.height);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2, int i3) {
        if (this.o.D != -1.0f) {
            com.tencent.liteav.beauty.c cVar = this.f31555e;
            if (cVar != null) {
                cVar.a(this.o.y, this.o.B, this.o.C, this.o.D);
                return;
            }
            return;
        }
        com.tencent.liteav.beauty.c cVar2 = this.f31555e;
        if (cVar2 != null && i2 != 0 && i3 != 0) {
            float f2 = (float) i2;
            cVar2.a(this.o.y, ((float) this.o.z) / f2, ((float) this.o.A) / ((float) i3), this.o.y == null ? BitmapDescriptorFactory.HUE_RED : ((float) this.o.y.getWidth()) / f2);
        }
    }

    private void A() {
        if (this.f31555e == null) {
            return;
        }
        if (this.o.J) {
            this.f31555e.f(0);
        } else {
            this.f31555e.f(3);
        }
    }

    private void d(int i2, int i3) {
        c(i2, i3);
    }

    /* access modifiers changed from: private */
    public void a(b bVar, boolean z2) {
        this.C = bVar;
        if (this.w != null) {
            l lVar = this.f31554d;
            if (lVar != null) {
                lVar.a(bVar);
                return;
            }
            return;
        }
        if (this.x != null) {
            com.tencent.liteav.basic.d.d dVar = this.A;
            if (!(dVar == null || dVar.b() == this.x)) {
                this.A.a();
                this.A = null;
            }
            if (this.A == null) {
                l lVar2 = this.f31554d;
                if (!(lVar2 == null || lVar2.f() == null)) {
                    this.A = new com.tencent.liteav.basic.d.d();
                    this.A.a(this.f31554d.f(), this.x);
                }
            }
        } else {
            com.tencent.liteav.basic.d.d dVar2 = this.A;
            if (dVar2 != null) {
                dVar2.a();
                this.A = null;
            }
        }
        com.tencent.liteav.basic.d.d dVar3 = this.A;
        if (dVar3 != null) {
            dVar3.a(bVar.f31404a, bVar.i, this.B, this.y, this.z, bVar.f31408e, bVar.f31409f, z2);
        }
    }

    private void c(b bVar) {
        final WeakReference<p> weakReference = this.K;
        if (weakReference != null) {
            if (this.I == 3) {
                p pVar = (p) weakReference.get();
                if (pVar != null) {
                    TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                    tXSVideoFrame.width = bVar.f31408e;
                    tXSVideoFrame.height = bVar.f31409f;
                    tXSVideoFrame.textureId = bVar.f31404a;
                    tXSVideoFrame.eglContext = this.f31555e.a();
                    tXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
                    pVar.a(getID(), this.D, tXSVideoFrame);
                    return;
                }
                return;
            }
            if (this.M == null) {
                this.M = new o(1);
                this.M.a(true);
                if (this.M.a()) {
                    this.M.a(bVar.f31408e, bVar.f31409f);
                    this.M.a((g.a) new g.a() {
                        public void a(int i) {
                            g i2 = c.this.M;
                            if (i2 != null) {
                                TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                                tXSVideoFrame.width = i2.n();
                                tXSVideoFrame.height = i2.o();
                                tXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
                                if (c.this.I == 2) {
                                    if (c.this.J == null || c.this.J.length != ((tXSVideoFrame.width * tXSVideoFrame.height) * 3) / 2) {
                                        byte[] unused = c.this.J = new byte[(((tXSVideoFrame.width * tXSVideoFrame.height) * 3) / 2)];
                                    }
                                    tXSVideoFrame.loadI420BufferFromGL(c.this.J);
                                    tXSVideoFrame.data = c.this.J;
                                } else {
                                    tXSVideoFrame.loadI420BufferFromGL();
                                }
                                p pVar = (p) weakReference.get();
                                if (pVar != null) {
                                    pVar.a(c.this.getID(), c.this.D, tXSVideoFrame);
                                }
                            }
                        }
                    });
                } else {
                    TXCLog.i(f31551c, "throwVideoFrame->release mVideoFrameFilter");
                    this.M = null;
                }
                if (this.N == null) {
                    this.N = new g();
                    this.N.a();
                    this.N.a(true);
                    this.N.a(bVar.f31408e, bVar.f31409f);
                    this.N.g();
                }
            }
            if (this.M != null) {
                GLES20.glViewport(0, 0, bVar.f31408e, bVar.f31409f);
                this.M.a(bVar.f31408e, bVar.f31409f);
                int i2 = bVar.f31404a;
                if (bVar.i) {
                    g gVar = this.N;
                    if (gVar != null) {
                        gVar.a(bVar.f31408e, bVar.f31409f);
                        i2 = this.N.b(bVar.f31404a);
                    }
                }
                this.M.b(i2);
            }
        }
    }

    public void a(float f2, float f3) {
        if (this.f31554d != null && this.o.E) {
            this.f31554d.a(f2, f3);
        }
    }
}
