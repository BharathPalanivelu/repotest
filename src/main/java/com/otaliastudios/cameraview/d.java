package com.otaliastudios.cameraview;

import android.graphics.PointF;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.i;
import com.otaliastudios.cameraview.q;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

abstract class d implements i.a, q.a, Thread.UncaughtExceptionHandler {
    private static final String Q = "d";
    /* access modifiers changed from: private */
    public static final g R = g.a(Q);
    protected af A;
    protected af B;
    protected int C;
    protected int D;
    protected boolean E = false;
    protected boolean F = false;
    protected int G = 0;
    ak<Void> H = new ak<>();
    ak<Void> I = new ak<>();
    ak<Void> J = new ak<>();
    ak<Void> K = new ak<>();
    ak<Void> L = new ak<>();
    ak<Void> M = new ak<>();
    ak<Void> N = new ak<>();
    ak<Void> O = new ak<>();
    ak<Void> P = new ak<>();
    private int S;
    private int T;

    /* renamed from: a  reason: collision with root package name */
    protected final CameraView.b f15616a;

    /* renamed from: b  reason: collision with root package name */
    protected i f15617b;

    /* renamed from: c  reason: collision with root package name */
    protected ap f15618c;

    /* renamed from: d  reason: collision with root package name */
    Handler f15619d;

    /* renamed from: e  reason: collision with root package name */
    protected n f15620e;

    /* renamed from: f  reason: collision with root package name */
    protected o f15621f;

    /* renamed from: g  reason: collision with root package name */
    protected ao f15622g;
    protected an h;
    protected am i;
    protected ae j;
    protected x k;
    protected Location l;
    protected b m;
    protected float n;
    protected float o;
    protected boolean p;
    protected int q;
    protected m r;
    protected h s;
    protected y t;
    protected q u;
    protected ag v;
    protected MediaRecorder w;
    protected File x;
    protected long y;
    protected int z;

    /* access modifiers changed from: package-private */
    public abstract void a(float f2, float[] fArr, PointF[] pointFArr, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract void a(float f2, PointF[] pointFArr, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract void a(Location location);

    /* access modifiers changed from: package-private */
    public abstract void a(ae aeVar);

    /* access modifiers changed from: package-private */
    public abstract void a(an anVar);

    /* access modifiers changed from: package-private */
    public abstract void a(ao aoVar);

    /* access modifiers changed from: package-private */
    public abstract void a(b bVar);

    /* access modifiers changed from: package-private */
    public abstract void a(n nVar);

    /* access modifiers changed from: package-private */
    public abstract void a(o oVar);

    /* access modifiers changed from: package-private */
    public abstract void a(s sVar, PointF pointF);

    /* access modifiers changed from: package-private */
    public abstract void a(x xVar);

    /* access modifiers changed from: package-private */
    public abstract void a(boolean z2);

    /* access modifiers changed from: package-private */
    public abstract void c();

    /* access modifiers changed from: package-private */
    public abstract void d();

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f();

    d(CameraView.b bVar) {
        this.f15616a = bVar;
        this.f15619d = new Handler(Looper.getMainLooper());
        this.f15618c = ap.a("CameraViewController");
        this.f15618c.b().setUncaughtExceptionHandler(this);
        this.u = new q(2, this);
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        this.f15617b = iVar;
        this.f15617b.a((i.a) this);
    }

    private static class a implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread thread, Throwable th) {
        }

        private a() {
        }
    }

    public void uncaughtException(Thread thread, final Throwable th) {
        if (!(th instanceof e)) {
            R.d("uncaughtException:", "Unexpected exception:", th);
            h();
            this.f15619d.post(new Runnable() {
                public void run() {
                    RuntimeException runtimeException;
                    Throwable th = th;
                    if (th instanceof RuntimeException) {
                        runtimeException = (RuntimeException) th;
                    } else {
                        runtimeException = new RuntimeException(th);
                    }
                    throw runtimeException;
                }
            });
            return;
        }
        final e eVar = (e) th;
        R.d("uncaughtException:", "Interrupting thread with state:", g(), "due to CameraException:", eVar);
        thread.interrupt();
        this.f15618c = ap.a("CameraViewController");
        this.f15618c.b().setUncaughtExceptionHandler(this);
        R.b("uncaughtException:", "Calling stopImmediately and notifying.");
        this.f15618c.b(new Runnable() {
            public void run() {
                d.this.k();
                d.this.f15616a.a(eVar);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        R.b("destroy:", "state:", g());
        this.f15618c.b().setUncaughtExceptionHandler(new a());
        k();
    }

    /* access modifiers changed from: private */
    public String g() {
        int i2 = this.G;
        if (i2 == -1) {
            return "STATE_STOPPING";
        }
        if (i2 == 0) {
            return "STATE_STOPPED";
        }
        if (i2 != 1) {
            return i2 != 2 ? "null" : "STATE_STARTED";
        }
        return "STATE_STARTING";
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        R.b("Start:", "posting runnable. State:", g());
        this.f15618c.b(new Runnable() {
            public void run() {
                d.R.b("Start:", "executing. State:", d.this.g());
                if (d.this.G < 1) {
                    d.this.G = 1;
                    d.R.b("Start:", "about to call onStart()", d.this.g());
                    d.this.c();
                    d.R.b("Start:", "returned from onStart().", "Dispatching.", d.this.g());
                    d dVar = d.this;
                    dVar.G = 2;
                    dVar.f15616a.a(d.this.s);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        R.b("Stop:", "posting runnable. State:", g());
        this.f15618c.b(new Runnable() {
            public void run() {
                d.R.b("Stop:", "executing. State:", d.this.g());
                if (d.this.G > 0) {
                    d.this.G = -1;
                    d.R.b("Stop:", "about to call onStop()");
                    d.this.d();
                    d.R.b("Stop:", "returned from onStop().", "Dispatching.");
                    d dVar = d.this;
                    dVar.G = 0;
                    dVar.f15616a.a();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        try {
            R.b("stopImmediately:", "State was:", g());
            if (this.G != 0) {
                this.G = -1;
                d();
                this.G = 0;
                R.b("stopImmediately:", "Stopped. State is:", g());
            }
        } catch (Exception e2) {
            R.b("stopImmediately:", "Swallowing exception while stopping.", e2);
            this.G = 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        R.b("Restart:", "posting runnable");
        this.f15618c.b(new Runnable() {
            public void run() {
                g J = d.R;
                Object[] objArr = new Object[4];
                objArr[0] = "Restart:";
                objArr[1] = "executing. Needs stopping:";
                objArr[2] = Boolean.valueOf(d.this.G > 0);
                objArr[3] = d.this.g();
                J.b(objArr);
                if (d.this.G > 0) {
                    d dVar = d.this;
                    dVar.G = -1;
                    dVar.d();
                    d.this.G = 0;
                    d.R.b("Restart:", "stopped. Dispatching.", d.this.g());
                    d.this.f15616a.a();
                }
                d.R.b("Restart: about to start. State:", d.this.g());
                d dVar2 = d.this;
                dVar2.G = 1;
                dVar2.c();
                d.this.G = 2;
                d.R.b("Restart: returned from start. Dispatching. State:", d.this.g());
                d.this.f15616a.a(d.this.s);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final int m() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.S = i2;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        this.T = i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(ag agVar) {
        this.v = agVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        this.y = j2;
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        this.z = i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(am amVar) {
        this.i = amVar;
    }

    /* access modifiers changed from: package-private */
    public final m n() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public final h o() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public final n p() {
        return this.f15620e;
    }

    /* access modifiers changed from: package-private */
    public final o q() {
        return this.f15621f;
    }

    /* access modifiers changed from: package-private */
    public final ao r() {
        return this.f15622g;
    }

    /* access modifiers changed from: package-private */
    public final an s() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public final am t() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public final long u() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public final int v() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public final ae w() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final x x() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public final Location y() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final b z() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public final af A() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public final float B() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final float C() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public final af D() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public final boolean E() {
        int F2 = F();
        R.b("shouldFlipSizes:", "displayOffset=", Integer.valueOf(this.S), "sensorOffset=", Integer.valueOf(this.D));
        R.b("shouldFlipSizes:", "sensorToDisplay=", Integer.valueOf(F2));
        if (F2 % 180 != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int F() {
        if (this.f15620e == n.FRONT) {
            return (360 - ((this.D + this.S) % 360)) % 360;
        }
        return ((this.D - this.S) + 360) % 360;
    }

    /* access modifiers changed from: protected */
    public final int G() {
        if (this.f15620e == n.FRONT) {
            return ((this.D - this.T) + 360) % 360;
        }
        return (this.D + this.T) % 360;
    }

    /* access modifiers changed from: protected */
    public final af H() {
        ag agVar;
        boolean E2 = E();
        if (this.j == ae.PICTURE) {
            agVar = ah.b(this.v, ah.a());
        } else {
            CamcorderProfile I2 = I();
            a a2 = a.a(I2.videoFrameWidth, I2.videoFrameHeight);
            if (E2) {
                a2 = a2.b();
            }
            R.b("size:", "computeCaptureSize:", "videoQuality:", this.h, "targetRatio:", a2);
            ag a3 = ah.a(a2, BitmapDescriptorFactory.HUE_RED);
            agVar = ah.b(ah.a(a3, this.v), ah.a(a3), this.v);
        }
        af afVar = agVar.a(new ArrayList(this.s.a())).get(0);
        R.b("computePictureSize:", "result:", afVar, "flip:", Boolean.valueOf(E2));
        return E2 ? afVar.c() : afVar;
    }

    /* access modifiers changed from: protected */
    public final af a(List<af> list) {
        boolean E2 = E();
        a a2 = a.a(this.A.a(), this.A.b());
        af d2 = this.f15617b.d();
        if (E2) {
            d2 = d2.c();
        }
        R.b("size:", "computePreviewSize:", "targetRatio:", a2, "targetMinSize:", d2);
        ag a3 = ah.a(a2, BitmapDescriptorFactory.HUE_RED);
        af afVar = ah.b(ah.a(a3, ah.a(ah.d(d2.b()), ah.b(d2.a()))), ah.a(a3, ah.a()), ah.a()).a(list).get(0);
        R.b("computePreviewSize:", "result:", afVar, "flip:", Boolean.valueOf(E2));
        return afVar;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        return android.media.CamcorderProfile.get(r2.q, 6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (android.media.CamcorderProfile.hasProfile(r2.q, 5) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        return android.media.CamcorderProfile.get(r2.q, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (android.media.CamcorderProfile.hasProfile(r2.q, 4) == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return android.media.CamcorderProfile.get(r2.q, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (android.media.CamcorderProfile.hasProfile(r2.q, 7) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        return android.media.CamcorderProfile.get(r2.q, 7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        return android.media.CamcorderProfile.get(r2.q, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (android.media.CamcorderProfile.hasProfile(r2.q, 6) == false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.CamcorderProfile I() {
        /*
            r2 = this;
            int[] r0 = com.otaliastudios.cameraview.d.AnonymousClass6.f15630a
            com.otaliastudios.cameraview.an r1 = r2.h
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0063;
                case 2: goto L_0x000e;
                case 3: goto L_0x0023;
                case 4: goto L_0x0033;
                case 5: goto L_0x0043;
                case 6: goto L_0x0053;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x006b
        L_0x000e:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x0023
            r0 = 8
            boolean r1 = android.media.CamcorderProfile.hasProfile(r0)
            if (r1 == 0) goto L_0x0023
            int r1 = r2.q
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r1, r0)
            return r0
        L_0x0023:
            int r0 = r2.q
            r1 = 6
            boolean r0 = android.media.CamcorderProfile.hasProfile(r0, r1)
            if (r0 == 0) goto L_0x0033
            int r0 = r2.q
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0, r1)
            return r0
        L_0x0033:
            int r0 = r2.q
            r1 = 5
            boolean r0 = android.media.CamcorderProfile.hasProfile(r0, r1)
            if (r0 == 0) goto L_0x0043
            int r0 = r2.q
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0, r1)
            return r0
        L_0x0043:
            int r0 = r2.q
            r1 = 4
            boolean r0 = android.media.CamcorderProfile.hasProfile(r0, r1)
            if (r0 == 0) goto L_0x0053
            int r0 = r2.q
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0, r1)
            return r0
        L_0x0053:
            int r0 = r2.q
            r1 = 7
            boolean r0 = android.media.CamcorderProfile.hasProfile(r0, r1)
            if (r0 == 0) goto L_0x006b
            int r0 = r2.q
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0, r1)
            return r0
        L_0x0063:
            int r0 = r2.q
            r1 = 1
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0, r1)
            return r0
        L_0x006b:
            int r0 = r2.q
            r1 = 0
            android.media.CamcorderProfile r0 = android.media.CamcorderProfile.get(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.d.I():android.media.CamcorderProfile");
    }
}
