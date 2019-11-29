package com.c.a.c.b;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.c.a.c.b.d;
import com.c.a.c.b.g;
import com.c.a.c.h;
import com.c.a.c.j;
import com.c.a.c.l;
import com.c.a.c.m;
import com.c.a.i.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class f<R> implements d.a, a.c, Comparable<f<?>>, Runnable {
    private com.c.a.c.a.b<?> A;
    private volatile d B;
    private volatile boolean C;
    private volatile boolean D;

    /* renamed from: a  reason: collision with root package name */
    final e<R> f5785a = new e<>();

    /* renamed from: b  reason: collision with root package name */
    final c<?> f5786b = new c<>();

    /* renamed from: c  reason: collision with root package name */
    h f5787c;

    /* renamed from: d  reason: collision with root package name */
    int f5788d;

    /* renamed from: e  reason: collision with root package name */
    int f5789e;

    /* renamed from: f  reason: collision with root package name */
    h f5790f;

    /* renamed from: g  reason: collision with root package name */
    j f5791g;
    h h;
    private final List<Throwable> i = new ArrayList();
    private final com.c.a.i.a.b j = com.c.a.i.a.b.a();
    private final d k;
    private final Pools.a<f<?>> l;
    private final e m = new e();
    /* access modifiers changed from: private */
    public com.c.a.e n;
    private com.c.a.g o;
    private l p;
    private a<R> q;
    private int r;
    private g s;
    private C0101f t;
    private long u;
    private boolean v;
    private Thread w;
    private h x;
    private Object y;
    private com.c.a.c.a z;

    interface a<R> {
        void a(f<?> fVar);

        void a(o oVar);

        void a(s<R> sVar, com.c.a.c.a aVar);
    }

    interface d {
        com.c.a.c.b.b.a a();
    }

    /* renamed from: com.c.a.c.b.f$f  reason: collision with other inner class name */
    private enum C0101f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    f(d dVar, Pools.a<f<?>> aVar) {
        this.k = dVar;
        this.l = aVar;
    }

    /* access modifiers changed from: package-private */
    public f<R> a(com.c.a.e eVar, Object obj, l lVar, h hVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.c.a.g gVar, h hVar2, Map<Class<?>, m<?>> map, boolean z2, boolean z3, boolean z4, j jVar, a<R> aVar, int i4) {
        this.f5785a.a(eVar, obj, hVar, i2, i3, hVar2, cls, cls2, gVar, jVar, map, z2, z3, this.k);
        this.n = eVar;
        this.f5787c = hVar;
        this.o = gVar;
        this.p = lVar;
        this.f5788d = i2;
        this.f5789e = i3;
        this.f5790f = hVar2;
        this.v = z4;
        this.f5791g = jVar;
        this.q = aVar;
        this.r = i4;
        this.t = C0101f.INITIALIZE;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        g a2 = a(g.INITIALIZE);
        return a2 == g.RESOURCE_CACHE || a2 == g.DATA_CACHE;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.m.a(z2)) {
            g();
        }
    }

    private void e() {
        if (this.m.a()) {
            g();
        }
    }

    private void f() {
        if (this.m.b()) {
            g();
        }
    }

    private void g() {
        this.m.c();
        this.f5786b.b();
        this.f5785a.a();
        this.C = false;
        this.n = null;
        this.f5787c = null;
        this.f5791g = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.B = null;
        this.w = null;
        this.h = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.u = 0;
        this.D = false;
        this.i.clear();
        this.l.release(this);
    }

    /* renamed from: a */
    public int compareTo(f<?> fVar) {
        int h2 = h() - fVar.h();
        return h2 == 0 ? this.r - fVar.r : h2;
    }

    private int h() {
        return this.o.ordinal();
    }

    public void b() {
        this.D = true;
        d dVar = this.B;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob"
            java.lang.String r1 = "DecodeJob#run"
            androidx.core.d.f.a(r1)
            com.c.a.c.a.b<?> r1 = r5.A
            boolean r2 = r5.D     // Catch:{ Throwable -> 0x0027 }
            if (r2 == 0) goto L_0x0019
            r5.l()     // Catch:{ Throwable -> 0x0027 }
            if (r1 == 0) goto L_0x0015
            r1.a()
        L_0x0015:
            androidx.core.d.f.a()
            return
        L_0x0019:
            r5.i()     // Catch:{ Throwable -> 0x0027 }
            if (r1 == 0) goto L_0x0021
        L_0x001e:
            r1.a()
        L_0x0021:
            androidx.core.d.f.a()
            goto L_0x0064
        L_0x0025:
            r0 = move-exception
            goto L_0x0066
        L_0x0027:
            r2 = move-exception
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x004f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0025 }
            r3.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            boolean r4 = r5.D     // Catch:{ all -> 0x0025 }
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            com.c.a.c.b.f$g r4 = r5.s     // Catch:{ all -> 0x0025 }
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0025 }
            android.util.Log.d(r0, r3, r2)     // Catch:{ all -> 0x0025 }
        L_0x004f:
            com.c.a.c.b.f$g r0 = r5.s     // Catch:{ all -> 0x0025 }
            com.c.a.c.b.f$g r3 = com.c.a.c.b.f.g.ENCODE     // Catch:{ all -> 0x0025 }
            if (r0 == r3) goto L_0x005d
            java.util.List<java.lang.Throwable> r0 = r5.i     // Catch:{ all -> 0x0025 }
            r0.add(r2)     // Catch:{ all -> 0x0025 }
            r5.l()     // Catch:{ all -> 0x0025 }
        L_0x005d:
            boolean r0 = r5.D     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0065
            if (r1 == 0) goto L_0x0021
            goto L_0x001e
        L_0x0064:
            return
        L_0x0065:
            throw r2     // Catch:{ all -> 0x0025 }
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.a()
        L_0x006b:
            androidx.core.d.f.a()
            goto L_0x0070
        L_0x006f:
            throw r0
        L_0x0070:
            goto L_0x006f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.b.f.run():void");
    }

    private void i() {
        int i2 = AnonymousClass1.f5792a[this.t.ordinal()];
        if (i2 == 1) {
            this.s = a(g.INITIALIZE);
            this.B = j();
            k();
        } else if (i2 == 2) {
            k();
        } else if (i2 == 3) {
            n();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.t);
        }
    }

    /* renamed from: com.c.a.c.b.f$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5792a = new int[C0101f.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5793b = new int[g.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005d */
        static {
            /*
                com.c.a.c.b.f$g[] r0 = com.c.a.c.b.f.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5793b = r0
                r0 = 1
                int[] r1 = f5793b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.c.a.c.b.f$g r2 = com.c.a.c.b.f.g.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f5793b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.c.a.c.b.f$g r3 = com.c.a.c.b.f.g.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f5793b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.c.a.c.b.f$g r4 = com.c.a.c.b.f.g.SOURCE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r3 = f5793b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.c.a.c.b.f$g r4 = com.c.a.c.b.f.g.FINISHED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r3 = f5793b     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.c.a.c.b.f$g r4 = com.c.a.c.b.f.g.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                com.c.a.c.b.f$f[] r3 = com.c.a.c.b.f.C0101f.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5792a = r3
                int[] r3 = f5792a     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.c.a.c.b.f$f r4 = com.c.a.c.b.f.C0101f.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f5792a     // Catch:{ NoSuchFieldError -> 0x005d }
                com.c.a.c.b.f$f r3 = com.c.a.c.b.f.C0101f.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x005d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = f5792a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.c.a.c.b.f$f r1 = com.c.a.c.b.f.C0101f.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.b.f.AnonymousClass1.<clinit>():void");
        }
    }

    private d j() {
        int i2 = AnonymousClass1.f5793b[this.s.ordinal()];
        if (i2 == 1) {
            return new t(this.f5785a, this);
        }
        if (i2 == 2) {
            return new a(this.f5785a, this);
        }
        if (i2 == 3) {
            return new w(this.f5785a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.s);
    }

    private void k() {
        this.w = Thread.currentThread();
        this.u = com.c.a.i.d.a();
        boolean z2 = false;
        while (!this.D && this.B != null) {
            z2 = this.B.a();
            if (z2) {
                break;
            }
            this.s = a(this.s);
            this.B = j();
            if (this.s == g.SOURCE) {
                c();
                return;
            }
        }
        if ((this.s == g.FINISHED || this.D) && !z2) {
            l();
        }
    }

    private void l() {
        m();
        this.q.a(new o("Failed to load resource", (List<Throwable>) new ArrayList(this.i)));
        f();
    }

    private void a(s<R> sVar, com.c.a.c.a aVar) {
        m();
        this.q.a(sVar, aVar);
    }

    private void m() {
        this.j.b();
        if (!this.C) {
            this.C = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }

    private g a(g gVar) {
        int i2 = AnonymousClass1.f5793b[gVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return this.v ? g.FINISHED : g.SOURCE;
            }
            if (i2 == 3 || i2 == 4) {
                return g.FINISHED;
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + gVar);
            } else if (this.f5790f.a()) {
                return g.RESOURCE_CACHE;
            } else {
                return a(g.RESOURCE_CACHE);
            }
        } else if (this.f5790f.b()) {
            return g.DATA_CACHE;
        } else {
            return a(g.DATA_CACHE);
        }
    }

    public void c() {
        this.t = C0101f.SWITCH_TO_SOURCE_SERVICE;
        this.q.a((f<?>) this);
    }

    public void a(h hVar, Object obj, com.c.a.c.a.b<?> bVar, com.c.a.c.a aVar, h hVar2) {
        this.h = hVar;
        this.y = obj;
        this.A = bVar;
        this.z = aVar;
        this.x = hVar2;
        if (Thread.currentThread() != this.w) {
            this.t = C0101f.DECODE_DATA;
            this.q.a((f<?>) this);
            return;
        }
        androidx.core.d.f.a("DecodeJob.decodeFromRetrievedData");
        try {
            n();
        } finally {
            androidx.core.d.f.a();
        }
    }

    public void a(h hVar, Exception exc, com.c.a.c.a.b<?> bVar, com.c.a.c.a aVar) {
        bVar.a();
        o oVar = new o("Fetching data failed", (Throwable) exc);
        oVar.a(hVar, aVar, bVar.d());
        this.i.add(oVar);
        if (Thread.currentThread() != this.w) {
            this.t = C0101f.SWITCH_TO_SOURCE_SERVICE;
            this.q.a((f<?>) this);
            return;
        }
        k();
    }

    private void n() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.u;
            a("Retrieved data", j2, "data: " + this.y + ", cache key: " + this.h + ", fetcher: " + this.A);
        }
        s<R> sVar = null;
        try {
            sVar = a(this.A, this.y, this.z);
        } catch (o e2) {
            e2.a(this.x, this.z);
            this.i.add(e2);
        }
        if (sVar != null) {
            b(sVar, this.z);
        } else {
            k();
        }
    }

    private void b(s<R> sVar, com.c.a.c.a aVar) {
        if (sVar instanceof p) {
            ((p) sVar).a();
        }
        r<R> rVar = null;
        r<R> rVar2 = sVar;
        if (this.f5786b.a()) {
            r<R> a2 = r.a(sVar);
            rVar = a2;
            rVar2 = a2;
        }
        a(rVar2, aVar);
        this.s = g.ENCODE;
        try {
            if (this.f5786b.a()) {
                this.f5786b.a(this.k, this.f5791g);
            }
        } finally {
            if (rVar != null) {
                rVar.a();
            }
            e();
        }
    }

    private <Data> s<R> a(com.c.a.c.a.b<?> bVar, Data data, com.c.a.c.a aVar) throws o {
        if (data == null) {
            bVar.a();
            return null;
        }
        try {
            long a2 = com.c.a.i.d.a();
            s<R> a3 = a(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            bVar.a();
        }
    }

    private <Data> s<R> a(Data data, com.c.a.c.a aVar) throws o {
        return a(data, aVar, this.f5785a.b(data.getClass()));
    }

    private j a(com.c.a.c.a aVar) {
        j jVar = this.f5791g;
        if (Build.VERSION.SDK_INT < 26 || jVar.a(com.c.a.c.d.a.h.f6015d) != null) {
            return jVar;
        }
        if (aVar != com.c.a.c.a.RESOURCE_DISK_CACHE && !this.f5785a.j()) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.a(this.f5791g);
        jVar2.a(com.c.a.c.d.a.h.f6015d, true);
        return jVar2;
    }

    private <Data, ResourceType> s<R> a(Data data, com.c.a.c.a aVar, q<Data, ResourceType, R> qVar) throws o {
        j a2 = a(aVar);
        com.c.a.c.a.c b2 = this.n.d().b(data);
        try {
            return qVar.a(b2, a2, this.f5788d, this.f5789e, new b(aVar));
        } finally {
            b2.b();
        }
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.c.a.i.d.a(j2));
        sb.append(", load key: ");
        sb.append(this.p);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    public com.c.a.i.a.b f_() {
        return this.j;
    }

    private final class b<Z> implements g.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        private final com.c.a.c.a f5795b;

        b(com.c.a.c.a aVar) {
            this.f5795b = aVar;
        }

        /* JADX WARNING: type inference failed for: r11v9, types: [com.c.a.c.b.b] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.c.a.c.b.s<Z> a(com.c.a.c.b.s<Z> r11) {
            /*
                r10 = this;
                java.lang.Class r6 = r10.b(r11)
                com.c.a.c.a r0 = r10.f5795b
                com.c.a.c.a r1 = com.c.a.c.a.RESOURCE_DISK_CACHE
                r2 = 0
                if (r0 == r1) goto L_0x0028
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.b.e<R> r0 = r0.f5785a
                com.c.a.c.m r0 = r0.c(r6)
                com.c.a.c.b.f r1 = com.c.a.c.b.f.this
                com.c.a.e r1 = r1.n
                com.c.a.c.b.f r3 = com.c.a.c.b.f.this
                int r3 = r3.f5788d
                com.c.a.c.b.f r4 = com.c.a.c.b.f.this
                int r4 = r4.f5789e
                com.c.a.c.b.s r1 = r0.a(r1, r11, r3, r4)
                r5 = r0
                r8 = r1
                goto L_0x002a
            L_0x0028:
                r8 = r11
                r5 = r2
            L_0x002a:
                boolean r0 = r11.equals(r8)
                if (r0 != 0) goto L_0x0033
                r11.e()
            L_0x0033:
                com.c.a.c.b.f r11 = com.c.a.c.b.f.this
                com.c.a.c.b.e<R> r11 = r11.f5785a
                boolean r11 = r11.a((com.c.a.c.b.s<?>) r8)
                if (r11 == 0) goto L_0x004e
                com.c.a.c.b.f r11 = com.c.a.c.b.f.this
                com.c.a.c.b.e<R> r11 = r11.f5785a
                com.c.a.c.l r2 = r11.b(r8)
                com.c.a.c.b.f r11 = com.c.a.c.b.f.this
                com.c.a.c.j r11 = r11.f5791g
                com.c.a.c.c r11 = r2.a(r11)
                goto L_0x0050
            L_0x004e:
                com.c.a.c.c r11 = com.c.a.c.c.NONE
            L_0x0050:
                r9 = r2
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.b.e<R> r0 = r0.f5785a
                com.c.a.c.b.f r1 = com.c.a.c.b.f.this
                com.c.a.c.h r1 = r1.h
                boolean r0 = r0.a((com.c.a.c.h) r1)
                r0 = r0 ^ 1
                com.c.a.c.b.f r1 = com.c.a.c.b.f.this
                com.c.a.c.b.h r1 = r1.f5790f
                com.c.a.c.a r2 = r10.f5795b
                boolean r0 = r1.a(r0, r2, r11)
                if (r0 == 0) goto L_0x00ce
                if (r9 == 0) goto L_0x00c0
                com.c.a.c.c r0 = com.c.a.c.c.SOURCE
                if (r11 != r0) goto L_0x007f
                com.c.a.c.b.b r11 = new com.c.a.c.b.b
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.h r0 = r0.h
                com.c.a.c.b.f r1 = com.c.a.c.b.f.this
                com.c.a.c.h r1 = r1.f5787c
                r11.<init>(r0, r1)
                goto L_0x009d
            L_0x007f:
                com.c.a.c.c r0 = com.c.a.c.c.TRANSFORMED
                if (r11 != r0) goto L_0x00a9
                com.c.a.c.b.u r11 = new com.c.a.c.b.u
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.h r1 = r0.h
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.h r2 = r0.f5787c
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                int r3 = r0.f5788d
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                int r4 = r0.f5789e
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.j r7 = r0.f5791g
                r0 = r11
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            L_0x009d:
                com.c.a.c.b.r r8 = com.c.a.c.b.r.a(r8)
                com.c.a.c.b.f r0 = com.c.a.c.b.f.this
                com.c.a.c.b.f$c<?> r0 = r0.f5786b
                r0.a(r11, r9, r8)
                goto L_0x00ce
            L_0x00a9:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unknown strategy: "
                r1.append(r2)
                r1.append(r11)
                java.lang.String r11 = r1.toString()
                r0.<init>(r11)
                throw r0
            L_0x00c0:
                com.c.a.h$d r11 = new com.c.a.h$d
                java.lang.Object r0 = r8.c()
                java.lang.Class r0 = r0.getClass()
                r11.<init>(r0)
                throw r11
            L_0x00ce:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.b.f.b.a(com.c.a.c.b.s):com.c.a.c.b.s");
        }

        private Class<Z> b(s<Z> sVar) {
            return sVar.c().getClass();
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5799a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5800b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5801c;

        e() {
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a(boolean z) {
            this.f5799a = true;
            return b(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a() {
            this.f5800b = true;
            return b(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f5801c = true;
            return b(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized void c() {
            this.f5800b = false;
            this.f5799a = false;
            this.f5801c = false;
        }

        private boolean b(boolean z) {
            return (this.f5801c || z || this.f5800b) && this.f5799a;
        }
    }

    private static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        private h f5796a;

        /* renamed from: b  reason: collision with root package name */
        private l<Z> f5797b;

        /* renamed from: c  reason: collision with root package name */
        private r<Z> f5798c;

        c() {
        }

        /* access modifiers changed from: package-private */
        public <X> void a(h hVar, l<X> lVar, r<X> rVar) {
            this.f5796a = hVar;
            this.f5797b = lVar;
            this.f5798c = rVar;
        }

        /* access modifiers changed from: package-private */
        public void a(d dVar, j jVar) {
            androidx.core.d.f.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f5796a, new c(this.f5797b, this.f5798c, jVar));
            } finally {
                this.f5798c.a();
                androidx.core.d.f.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f5798c != null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f5796a = null;
            this.f5797b = null;
            this.f5798c = null;
        }
    }
}
