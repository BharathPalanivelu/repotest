package com.squareup.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import android.os.Build;
import com.squareup.a.ab;
import com.squareup.a.j;
import com.squareup.a.t;
import com.squareup.a.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class c implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final ab w = new ab() {
        public boolean a(z zVar) {
            return true;
        }

        public ab.a a(z zVar, int i) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + zVar);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f30535a = v.incrementAndGet();

    /* renamed from: b  reason: collision with root package name */
    final w f30536b;

    /* renamed from: c  reason: collision with root package name */
    final i f30537c;

    /* renamed from: d  reason: collision with root package name */
    final d f30538d;

    /* renamed from: e  reason: collision with root package name */
    final ad f30539e;

    /* renamed from: f  reason: collision with root package name */
    final String f30540f;

    /* renamed from: g  reason: collision with root package name */
    final z f30541g;
    final int h;
    int i;
    final ab j;
    a k;
    List<a> l;
    Bitmap m;
    Future<?> n;
    w.d o;
    Exception p;
    int q;
    int r;
    w.e s;

    static int a(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static boolean a(boolean z, int i2, int i3, int i4, int i5) {
        return !z || (i4 != 0 && i2 > i4) || (i5 != 0 && i3 > i5);
    }

    static int b(int i2) {
        return (i2 == 2 || i2 == 7 || i2 == 4 || i2 == 5) ? -1 : 1;
    }

    c(w wVar, i iVar, d dVar, ad adVar, a aVar, ab abVar) {
        this.f30536b = wVar;
        this.f30537c = iVar;
        this.f30538d = dVar;
        this.f30539e = adVar;
        this.k = aVar;
        this.f30540f = aVar.e();
        this.f30541g = aVar.c();
        this.s = aVar.k();
        this.h = aVar.h();
        this.i = aVar.i();
        this.j = abVar;
        this.r = abVar.a();
    }

    static Bitmap a(InputStream inputStream, z zVar) throws IOException {
        p pVar = new p(inputStream);
        pVar.a(false);
        long a2 = pVar.a(1024);
        BitmapFactory.Options c2 = ab.c(zVar);
        boolean a3 = ab.a(c2);
        boolean c3 = aj.c((InputStream) pVar);
        boolean z = zVar.r && Build.VERSION.SDK_INT < 21;
        pVar.a(a2);
        if (c3 || z) {
            byte[] b2 = aj.b((InputStream) pVar);
            if (a3) {
                BitmapFactory.decodeByteArray(b2, 0, b2.length, c2);
                ab.a(zVar.h, zVar.i, c2, zVar);
            }
            return BitmapFactory.decodeByteArray(b2, 0, b2.length, c2);
        }
        if (a3) {
            BitmapFactory.decodeStream(pVar, (Rect) null, c2);
            ab.a(zVar.h, zVar.i, c2, zVar);
            pVar.a(a2);
        }
        pVar.a(true);
        Bitmap decodeStream = BitmapFactory.decodeStream(pVar, (Rect) null, c2);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public void run() {
        try {
            a(this.f30541g);
            if (this.f30536b.l) {
                aj.a("Hunter", "executing", aj.a(this));
            }
            this.m = a();
            if (this.m == null) {
                this.f30537c.c(this);
            } else {
                this.f30537c.a(this);
            }
        } catch (j.b e2) {
            if (!e2.localCacheOnly || e2.responseCode != 504) {
                this.p = e2;
            }
            this.f30537c.c(this);
        } catch (t.a e3) {
            this.p = e3;
            this.f30537c.b(this);
        } catch (IOException e4) {
            this.p = e4;
            this.f30537c.b(this);
        } catch (OutOfMemoryError e5) {
            StringWriter stringWriter = new StringWriter();
            this.f30539e.e().a(new PrintWriter(stringWriter));
            this.p = new RuntimeException(stringWriter.toString(), e5);
            this.f30537c.c(this);
        } catch (Exception e6) {
            this.p = e6;
            this.f30537c.c(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public Bitmap a() throws IOException {
        Bitmap bitmap;
        if (r.a(this.h)) {
            bitmap = this.f30538d.a(this.f30540f);
            if (bitmap != null) {
                this.f30539e.a();
                this.o = w.d.MEMORY;
                if (this.f30536b.l) {
                    aj.a("Hunter", "decoded", this.f30541g.a(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        this.f30541g.f30600c = this.r == 0 ? s.OFFLINE.index : this.i;
        ab.a a2 = this.j.a(this.f30541g, this.i);
        if (a2 != null) {
            this.o = a2.c();
            this.q = a2.d();
            bitmap = a2.a();
            if (bitmap == null) {
                InputStream b2 = a2.b();
                try {
                    Bitmap a3 = a(b2, this.f30541g);
                    aj.a(b2);
                    bitmap = a3;
                } catch (Throwable th) {
                    aj.a(b2);
                    throw th;
                }
            }
        }
        if (bitmap != null) {
            if (this.f30536b.l) {
                aj.a("Hunter", "decoded", this.f30541g.a());
            }
            this.f30539e.a(bitmap);
            if (this.f30541g.e() || this.q != 0) {
                synchronized (t) {
                    if (this.f30541g.f() || this.q != 0) {
                        bitmap = a(this.f30541g, bitmap, this.q);
                        if (this.f30536b.l) {
                            aj.a("Hunter", "transformed", this.f30541g.a());
                        }
                    }
                    if (this.f30541g.g()) {
                        bitmap = a(this.f30541g.f30604g, bitmap);
                        if (this.f30536b.l) {
                            aj.a("Hunter", "transformed", this.f30541g.a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f30539e.b(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        boolean z = this.f30536b.l;
        z zVar = aVar.f30490b;
        if (this.k == null) {
            this.k = aVar;
            if (z) {
                List<a> list = this.l;
                if (list == null || list.isEmpty()) {
                    aj.a("Hunter", "joined", zVar.a(), "to empty hunter");
                } else {
                    aj.a("Hunter", "joined", zVar.a(), aj.a(this, "to "));
                }
            }
        } else {
            if (this.l == null) {
                this.l = new ArrayList(3);
            }
            this.l.add(aVar);
            if (z) {
                aj.a("Hunter", "joined", zVar.a(), aj.a(this, "to "));
            }
            w.e k2 = aVar.k();
            if (k2.ordinal() > this.s.ordinal()) {
                this.s = k2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        boolean z;
        if (this.k == aVar) {
            this.k = null;
            z = true;
        } else {
            List<a> list = this.l;
            z = list != null ? list.remove(aVar) : false;
        }
        if (z && aVar.k() == this.s) {
            this.s = o();
        }
        if (this.f30536b.l) {
            aj.a("Hunter", "removed", aVar.f30490b.a(), aj.a(this, "from "));
        }
    }

    private w.e o() {
        w.e eVar = w.e.LOW;
        List<a> list = this.l;
        boolean z = true;
        boolean z2 = list != null && !list.isEmpty();
        if (this.k == null && !z2) {
            z = false;
        }
        if (!z) {
            return eVar;
        }
        a aVar = this.k;
        if (aVar != null) {
            eVar = aVar.k();
        }
        if (z2) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                w.e k2 = this.l.get(i2).k();
                if (k2.ordinal() > eVar.ordinal()) {
                    eVar = k2;
                }
            }
        }
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        if (this.k != null) {
            return false;
        }
        List<a> list = this.l;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        Future<?> future = this.n;
        if (future == null || !future.cancel(false)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        Future<?> future = this.n;
        return future != null && future.isCancelled();
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.r > 0)) {
            return false;
        }
        this.r--;
        return this.j.a(z, networkInfo);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.j.b();
    }

    /* access modifiers changed from: package-private */
    public Bitmap e() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.f30540f;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public z h() {
        return this.f30541g;
    }

    /* access modifiers changed from: package-private */
    public a i() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public w j() {
        return this.f30536b;
    }

    /* access modifiers changed from: package-private */
    public List<a> k() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public Exception l() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public w.d m() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public w.e n() {
        return this.s;
    }

    static void a(z zVar) {
        String c2 = zVar.c();
        StringBuilder sb = u.get();
        sb.ensureCapacity(c2.length() + 8);
        sb.replace(8, sb.length(), c2);
        Thread.currentThread().setName(sb.toString());
    }

    static c a(w wVar, i iVar, d dVar, ad adVar, a aVar) {
        z c2 = aVar.c();
        List<ab> a2 = wVar.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            ab abVar = a2.get(i2);
            if (abVar.a(c2)) {
                return new c(wVar, iVar, dVar, adVar, aVar, abVar);
            }
        }
        return new c(wVar, iVar, dVar, adVar, aVar, w);
    }

    static Bitmap a(List<ah> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            final ah ahVar = list.get(i2);
            try {
                Bitmap a2 = ahVar.a(bitmap);
                if (a2 == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(ahVar.a());
                    sb.append(" returned null after ");
                    sb.append(i2);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (ah a3 : list) {
                        sb.append(a3.a());
                        sb.append(10);
                    }
                    w.f7153a.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                } else if (a2 == bitmap && bitmap.isRecycled()) {
                    w.f7153a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + ahVar.a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (a2 == bitmap || bitmap.isRecycled()) {
                    i2++;
                    bitmap = a2;
                } else {
                    w.f7153a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + ahVar.a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e2) {
                w.f7153a.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException("Transformation " + ahVar.a() + " crashed with exception.", e2);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap a(com.squareup.a.z r28, android.graphics.Bitmap r29, int r30) {
        /*
            r0 = r28
            int r1 = r29.getWidth()
            int r2 = r29.getHeight()
            boolean r3 = r0.m
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r4 = r28.f()
            if (r4 != 0) goto L_0x001f
            if (r30 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r5 = r2
            r3 = r9
            r2 = r1
            goto L_0x02b2
        L_0x001f:
            int r4 = r0.h
            int r6 = r0.i
            float r7 = r0.n
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0198
            double r10 = (double) r7
            double r12 = java.lang.Math.toRadians(r10)
            double r12 = java.lang.Math.cos(r12)
            double r10 = java.lang.Math.toRadians(r10)
            double r10 = java.lang.Math.sin(r10)
            boolean r4 = r0.q
            if (r4 == 0) goto L_0x0109
            float r4 = r0.o
            float r6 = r0.p
            r9.setRotate(r7, r4, r6)
            float r4 = r0.o
            double r6 = (double) r4
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 - r12
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r14
            float r4 = r0.p
            r16 = r6
            double r5 = (double) r4
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r10
            double r6 = r16 + r5
            float r4 = r0.p
            double r4 = (double) r4
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r14
            float r14 = r0.o
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r10
            double r4 = r4 - r14
            int r14 = r0.h
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r12
            double r14 = r14 + r6
            int r8 = r0.h
            r17 = r2
            r18 = r3
            double r2 = (double) r8
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r10
            double r2 = r2 + r4
            int r8 = r0.h
            r19 = r9
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r12
            double r8 = r8 + r6
            r20 = r1
            int r1 = r0.i
            r21 = r2
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r10
            double r8 = r8 - r1
            int r1 = r0.h
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r10
            double r1 = r1 + r4
            int r3 = r0.i
            r23 = r8
            double r8 = (double) r3
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r12
            double r1 = r1 + r8
            int r3 = r0.i
            double r8 = (double) r3
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r10
            double r8 = r6 - r8
            int r3 = r0.i
            double r10 = (double) r3
            java.lang.Double.isNaN(r10)
            double r10 = r10 * r12
            double r10 = r10 + r4
            double r12 = java.lang.Math.max(r6, r14)
            r25 = r10
            r10 = r23
            double r12 = java.lang.Math.max(r10, r12)
            double r12 = java.lang.Math.max(r8, r12)
            double r6 = java.lang.Math.min(r6, r14)
            double r6 = java.lang.Math.min(r10, r6)
            double r6 = java.lang.Math.min(r8, r6)
            r8 = r21
            double r10 = java.lang.Math.max(r4, r8)
            double r10 = java.lang.Math.max(r1, r10)
            r14 = r25
            double r10 = java.lang.Math.max(r14, r10)
            double r3 = java.lang.Math.min(r4, r8)
            double r1 = java.lang.Math.min(r1, r3)
            double r1 = java.lang.Math.min(r14, r1)
            double r12 = r12 - r6
            double r3 = java.lang.Math.floor(r12)
            int r4 = (int) r3
            double r10 = r10 - r1
            double r1 = java.lang.Math.floor(r10)
            int r6 = (int) r1
            goto L_0x01a0
        L_0x0109:
            r20 = r1
            r17 = r2
            r18 = r3
            r1 = r9
            r1.setRotate(r7)
            int r2 = r0.h
            double r2 = (double) r2
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r12
            int r4 = r0.h
            double r4 = (double) r4
            java.lang.Double.isNaN(r4)
            double r4 = r4 * r10
            int r6 = r0.h
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r12
            int r8 = r0.i
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r10
            double r6 = r6 - r8
            int r8 = r0.h
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r10
            int r14 = r0.i
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r12
            double r8 = r8 + r14
            int r14 = r0.i
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r10
            double r10 = -r14
            int r14 = r0.i
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r12
            r12 = 0
            r19 = r1
            double r0 = java.lang.Math.max(r12, r2)
            double r0 = java.lang.Math.max(r6, r0)
            double r0 = java.lang.Math.max(r10, r0)
            double r2 = java.lang.Math.min(r12, r2)
            double r2 = java.lang.Math.min(r6, r2)
            double r2 = java.lang.Math.min(r10, r2)
            double r6 = java.lang.Math.max(r12, r4)
            double r6 = java.lang.Math.max(r8, r6)
            double r6 = java.lang.Math.max(r14, r6)
            double r4 = java.lang.Math.min(r12, r4)
            double r4 = java.lang.Math.min(r8, r4)
            double r4 = java.lang.Math.min(r14, r4)
            double r0 = r0 - r2
            double r0 = java.lang.Math.floor(r0)
            int r0 = (int) r0
            double r6 = r6 - r4
            double r1 = java.lang.Math.floor(r6)
            int r6 = (int) r1
            r4 = r0
            goto L_0x01a0
        L_0x0198:
            r20 = r1
            r17 = r2
            r18 = r3
            r19 = r9
        L_0x01a0:
            if (r30 == 0) goto L_0x01cc
            int r0 = a((int) r30)
            int r1 = b((int) r30)
            if (r0 == 0) goto L_0x01c0
            float r2 = (float) r0
            r3 = r19
            r3.preRotate(r2)
            r2 = 90
            if (r0 == r2) goto L_0x01ba
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 != r2) goto L_0x01c2
        L_0x01ba:
            r27 = r6
            r6 = r4
            r4 = r27
            goto L_0x01c2
        L_0x01c0:
            r3 = r19
        L_0x01c2:
            r0 = 1
            if (r1 == r0) goto L_0x01ce
            float r0 = (float) r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r3.postScale(r0, r1)
            goto L_0x01ce
        L_0x01cc:
            r3 = r19
        L_0x01ce:
            r0 = r28
            boolean r1 = r0.j
            if (r1 == 0) goto L_0x0267
            if (r4 == 0) goto L_0x01de
            float r1 = (float) r4
            r2 = r20
            float r5 = (float) r2
            float r1 = r1 / r5
            r5 = r17
            goto L_0x01e5
        L_0x01de:
            r2 = r20
            float r1 = (float) r6
            r5 = r17
            float r7 = (float) r5
            float r1 = r1 / r7
        L_0x01e5:
            if (r6 == 0) goto L_0x01ea
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x01ec
        L_0x01ea:
            float r7 = (float) r4
            float r8 = (float) r2
        L_0x01ec:
            float r7 = r7 / r8
            int r8 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x021d
            float r8 = (float) r5
            float r7 = r7 / r1
            float r8 = r8 * r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            int r8 = r0.k
            r9 = 48
            r8 = r8 & r9
            if (r8 != r9) goto L_0x0204
            r0 = 0
            goto L_0x0212
        L_0x0204:
            int r0 = r0.k
            r8 = 80
            r0 = r0 & r8
            if (r0 != r8) goto L_0x020e
            int r0 = r5 - r7
            goto L_0x0212
        L_0x020e:
            int r0 = r5 - r7
            int r0 = r0 / 2
        L_0x0212:
            float r8 = (float) r6
            float r9 = (float) r7
            float r8 = r8 / r9
            r9 = r2
            r10 = r7
            r16 = 0
            r7 = r1
            r1 = r18
            goto L_0x0258
        L_0x021d:
            int r8 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x0250
            float r8 = (float) r2
            float r1 = r1 / r7
            float r8 = r8 * r1
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r1 = (int) r8
            int r8 = r0.k
            r9 = 3
            r8 = r8 & r9
            if (r8 != r9) goto L_0x0233
            r0 = 0
            goto L_0x0240
        L_0x0233:
            int r0 = r0.k
            r8 = 5
            r0 = r0 & r8
            if (r0 != r8) goto L_0x023c
            int r0 = r2 - r1
            goto L_0x0240
        L_0x023c:
            int r0 = r2 - r1
            int r0 = r0 / 2
        L_0x0240:
            float r8 = (float) r4
            float r9 = (float) r1
            float r8 = r8 / r9
            r16 = r0
            r9 = r1
            r10 = r5
            r1 = r18
            r0 = 0
            r27 = r8
            r8 = r7
            r7 = r27
            goto L_0x0258
        L_0x0250:
            r9 = r2
            r10 = r5
            r8 = r7
            r1 = r18
            r0 = 0
            r16 = 0
        L_0x0258:
            boolean r1 = a((boolean) r1, (int) r2, (int) r5, (int) r4, (int) r6)
            if (r1 == 0) goto L_0x0261
            r3.preScale(r7, r8)
        L_0x0261:
            r6 = r0
            r7 = r9
            r8 = r10
            r5 = r16
            goto L_0x02b6
        L_0x0267:
            r5 = r17
            r1 = r18
            r2 = r20
            boolean r0 = r0.l
            if (r0 == 0) goto L_0x0291
            if (r4 == 0) goto L_0x0276
            float r0 = (float) r4
            float r7 = (float) r2
            goto L_0x0278
        L_0x0276:
            float r0 = (float) r6
            float r7 = (float) r5
        L_0x0278:
            float r0 = r0 / r7
            if (r6 == 0) goto L_0x027e
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x0280
        L_0x027e:
            float r7 = (float) r4
            float r8 = (float) r2
        L_0x0280:
            float r7 = r7 / r8
            int r8 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x0286
            goto L_0x0287
        L_0x0286:
            r0 = r7
        L_0x0287:
            boolean r1 = a((boolean) r1, (int) r2, (int) r5, (int) r4, (int) r6)
            if (r1 == 0) goto L_0x02b2
            r3.preScale(r0, r0)
            goto L_0x02b2
        L_0x0291:
            if (r4 != 0) goto L_0x0295
            if (r6 == 0) goto L_0x02b2
        L_0x0295:
            if (r4 != r2) goto L_0x0299
            if (r6 == r5) goto L_0x02b2
        L_0x0299:
            if (r4 == 0) goto L_0x029e
            float r0 = (float) r4
            float r7 = (float) r2
            goto L_0x02a0
        L_0x029e:
            float r0 = (float) r6
            float r7 = (float) r5
        L_0x02a0:
            float r0 = r0 / r7
            if (r6 == 0) goto L_0x02a6
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x02a8
        L_0x02a6:
            float r7 = (float) r4
            float r8 = (float) r2
        L_0x02a8:
            float r7 = r7 / r8
            boolean r1 = a((boolean) r1, (int) r2, (int) r5, (int) r4, (int) r6)
            if (r1 == 0) goto L_0x02b2
            r3.preScale(r0, r7)
        L_0x02b2:
            r7 = r2
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x02b6:
            r10 = 1
            r4 = r29
            r9 = r3
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            r1 = r29
            if (r0 == r1) goto L_0x02c6
            r29.recycle()
            goto L_0x02c7
        L_0x02c6:
            r0 = r1
        L_0x02c7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.a.c.a(com.squareup.a.z, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
