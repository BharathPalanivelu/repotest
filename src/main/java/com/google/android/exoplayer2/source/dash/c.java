package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.r.s;
import com.google.android.exoplayer2.r.t;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.x;
import com.tencent.imsdk.BaseConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11909a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f11910b;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0193a f11911c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11912d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11913e;

    /* renamed from: f  reason: collision with root package name */
    private final a.C0185a f11914f;

    /* renamed from: g  reason: collision with root package name */
    private final t.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> f11915g;
    private final C0194c h;
    private final Object i;
    private final SparseArray<b> j;
    private final Runnable k;
    private final Runnable l;
    private i.a m;
    private com.google.android.exoplayer2.r.f n;
    private r o;
    private s p;
    private Uri q;
    private long r;
    private long s;
    private com.google.android.exoplayer2.source.dash.manifest.b t;
    private Handler u;
    private long v;
    private int w;

    static {
        k.a("goog.exo.dash");
    }

    public c(Uri uri, f.a aVar, a.C0193a aVar2, Handler handler, com.google.android.exoplayer2.source.a aVar3) {
        this(uri, aVar, aVar2, 3, -1, handler, aVar3);
    }

    public c(Uri uri, f.a aVar, a.C0193a aVar2, int i2, long j2, Handler handler, com.google.android.exoplayer2.source.a aVar3) {
        this(uri, aVar, new com.google.android.exoplayer2.source.dash.manifest.c(), aVar2, i2, j2, handler, aVar3);
    }

    public c(Uri uri, f.a aVar, t.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.C0193a aVar3, int i2, long j2, Handler handler, com.google.android.exoplayer2.source.a aVar4) {
        this((com.google.android.exoplayer2.source.dash.manifest.b) null, uri, aVar, aVar2, aVar3, i2, j2, handler, aVar4);
    }

    private c(com.google.android.exoplayer2.source.dash.manifest.b bVar, Uri uri, f.a aVar, t.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.C0193a aVar3, int i2, long j2, Handler handler, com.google.android.exoplayer2.source.a aVar4) {
        this.t = bVar;
        this.q = uri;
        this.f11910b = aVar;
        this.f11915g = aVar2;
        this.f11911c = aVar3;
        this.f11912d = i2;
        this.f11913e = j2;
        this.f11909a = bVar != null;
        this.f11914f = new a.C0185a(handler, aVar4);
        this.i = new Object();
        this.j = new SparseArray<>();
        if (this.f11909a) {
            com.google.android.exoplayer2.s.a.b(!bVar.f12000d);
            this.h = null;
            this.k = null;
            this.l = null;
            return;
        }
        this.h = new C0194c();
        this.k = new Runnable() {
            public void run() {
                c.this.c();
            }
        };
        this.l = new Runnable() {
            public void run() {
                c.this.a(false);
            }
        };
    }

    public void a(com.google.android.exoplayer2.f fVar, boolean z, i.a aVar) {
        this.m = aVar;
        if (this.f11909a) {
            this.p = new s.a();
            a(false);
            return;
        }
        this.n = this.f11910b.a();
        this.o = new r("Loader:DashMediaSource");
        this.p = this.o;
        this.u = new Handler();
        c();
    }

    public void a() throws IOException {
        this.p.d();
    }

    public h a(i.b bVar, com.google.android.exoplayer2.r.b bVar2) {
        int i2 = bVar.f12083b;
        b bVar3 = new b(this.w + i2, this.t, i2, this.f11911c, this.f11912d, this.f11914f.a(this.t.a(i2).f12018b), this.v, this.p, bVar2);
        this.j.put(bVar3.f11896a, bVar3);
        return bVar3;
    }

    public void a(h hVar) {
        b bVar = (b) hVar;
        bVar.f();
        this.j.remove(bVar.f11896a);
    }

    public void b() {
        this.n = null;
        this.p = null;
        r rVar = this.o;
        if (rVar != null) {
            rVar.c();
            this.o = null;
        }
        this.r = 0;
        this.s = 0;
        this.t = null;
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.u = null;
        }
        this.v = 0;
        this.j.clear();
    }

    /* access modifiers changed from: package-private */
    public void a(t<com.google.android.exoplayer2.source.dash.manifest.b> tVar, long j2, long j3) {
        this.f11914f.a(tVar.f11379a, tVar.f11380b, j2, j3, tVar.e());
        com.google.android.exoplayer2.source.dash.manifest.b d2 = tVar.d();
        com.google.android.exoplayer2.source.dash.manifest.b bVar = this.t;
        int i2 = 0;
        int a2 = bVar == null ? 0 : bVar.a();
        long j4 = d2.a(0).f12018b;
        while (i2 < a2 && this.t.a(i2).f12018b < j4) {
            i2++;
        }
        if (a2 - i2 > d2.a()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            d();
            return;
        }
        this.t = d2;
        this.r = j2 - j3;
        this.s = j2;
        if (this.t.i != null) {
            synchronized (this.i) {
                if (tVar.f11379a.f11313a == this.q) {
                    this.q = this.t.i;
                }
            }
        }
        if (a2 != 0) {
            this.w += i2;
            a(true);
        } else if (this.t.h != null) {
            a(this.t.h);
        } else {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(t<com.google.android.exoplayer2.source.dash.manifest.b> tVar, long j2, long j3, IOException iOException) {
        t<com.google.android.exoplayer2.source.dash.manifest.b> tVar2 = tVar;
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof p;
        this.f11914f.a(tVar2.f11379a, tVar2.f11380b, j2, j3, tVar.e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    public void b(t<Long> tVar, long j2, long j3) {
        this.f11914f.a(tVar.f11379a, tVar.f11380b, j2, j3, tVar.e());
        a(tVar.d().longValue() - j2);
    }

    /* access modifiers changed from: package-private */
    public int b(t<Long> tVar, long j2, long j3, IOException iOException) {
        t<Long> tVar2 = tVar;
        a.C0185a aVar = this.f11914f;
        com.google.android.exoplayer2.r.i iVar = tVar2.f11379a;
        int i2 = tVar2.f11380b;
        aVar.a(iVar, i2, j2, j3, tVar.e(), iOException, true);
        a(iOException);
        return 2;
    }

    /* access modifiers changed from: package-private */
    public void c(t<?> tVar, long j2, long j3) {
        this.f11914f.b(tVar.f11379a, tVar.f11380b, j2, j3, tVar.e());
    }

    /* access modifiers changed from: private */
    public void c() {
        Uri uri;
        synchronized (this.i) {
            uri = this.q;
        }
        a(new t(this.n, uri, 4, this.f11915g), this.h, this.f11912d);
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar) {
        String str = kVar.f12050a;
        if (v.a((Object) str, (Object) "urn:mpeg:dash:utc:direct:2014") || v.a((Object) str, (Object) "urn:mpeg:dash:utc:direct:2012")) {
            b(kVar);
        } else if (v.a((Object) str, (Object) "urn:mpeg:dash:utc:http-iso:2014") || v.a((Object) str, (Object) "urn:mpeg:dash:utc:http-iso:2012")) {
            a(kVar, (t.a<Long>) new b());
        } else if (v.a((Object) str, (Object) "urn:mpeg:dash:utc:http-xsdate:2014") || v.a((Object) str, (Object) "urn:mpeg:dash:utc:http-xsdate:2012")) {
            a(kVar, (t.a<Long>) new f());
        } else {
            a(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void b(com.google.android.exoplayer2.source.dash.manifest.k kVar) {
        try {
            a(v.f(kVar.f12051b) - this.s);
        } catch (p e2) {
            a((IOException) e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, t.a<Long> aVar) {
        a(new t(this.n, Uri.parse(kVar.f12051b), 5, aVar), new e(), 1);
    }

    private void a(long j2) {
        this.v = j2;
        a(true);
    }

    private void a(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        a(true);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        long j2;
        boolean z2;
        long j3;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            int keyAt = this.j.keyAt(i2);
            if (keyAt >= this.w) {
                this.j.valueAt(i2).a(this.t, keyAt - this.w);
            }
        }
        int a2 = this.t.a() - 1;
        d a3 = d.a(this.t.a(0), this.t.c(0));
        d a4 = d.a(this.t.a(a2), this.t.c(a2));
        long j4 = a3.f11926b;
        long j5 = a4.f11927c;
        long j6 = 0;
        if (!this.t.f12000d || a4.f11925a) {
            j2 = j4;
            z2 = false;
        } else {
            j5 = Math.min((e() - com.google.android.exoplayer2.b.b(this.t.f11997a)) - com.google.android.exoplayer2.b.b(this.t.a(a2).f12018b), j5);
            if (this.t.f12002f != -9223372036854775807L) {
                long b2 = j5 - com.google.android.exoplayer2.b.b(this.t.f12002f);
                while (b2 < 0 && a2 > 0) {
                    a2--;
                    b2 += this.t.c(a2);
                }
                if (a2 == 0) {
                    j3 = Math.max(j4, b2);
                } else {
                    j3 = this.t.c(0);
                }
                j4 = j3;
            }
            j2 = j4;
            z2 = true;
        }
        long j7 = j5 - j2;
        for (int i3 = 0; i3 < this.t.a() - 1; i3++) {
            j7 += this.t.c(i3);
        }
        if (this.t.f12000d) {
            long j8 = this.f11913e;
            if (j8 == -1) {
                j8 = this.t.f12003g != -9223372036854775807L ? this.t.f12003g : BaseConstants.DEFAULT_MSG_TIMEOUT;
            }
            j6 = j7 - com.google.android.exoplayer2.b.b(j8);
            if (j6 < 5000000) {
                j6 = Math.min(5000000, j7 / 2);
            }
        }
        this.m.a(new a(this.t.f11997a, this.t.f11997a + this.t.a(0).f12018b + com.google.android.exoplayer2.b.a(j2), this.w, j2, j7, j6, this.t), this.t);
        if (!this.f11909a) {
            this.u.removeCallbacks(this.l);
            if (z2) {
                this.u.postDelayed(this.l, 5000);
            }
            if (z) {
                d();
            }
        }
    }

    private void d() {
        if (this.t.f12000d) {
            long j2 = this.t.f12001e;
            if (j2 == 0) {
                j2 = 5000;
            }
            this.u.postDelayed(this.k, Math.max(0, (this.r + j2) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(t<T> tVar, r.a<t<T>> aVar, int i2) {
        this.f11914f.a(tVar.f11379a, tVar.f11380b, this.o.a(tVar, aVar, i2));
    }

    private long e() {
        if (this.v != 0) {
            return com.google.android.exoplayer2.b.b(SystemClock.elapsedRealtime() + this.v);
        }
        return com.google.android.exoplayer2.b.b(System.currentTimeMillis());
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f11925a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11926b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11927c;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            int i;
            com.google.android.exoplayer2.source.dash.manifest.e eVar2 = eVar;
            long j2 = j;
            int size = eVar2.f12019c.size();
            int i2 = 0;
            long j3 = Long.MAX_VALUE;
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            long j4 = 0;
            while (i3 < size) {
                d e2 = eVar2.f12019c.get(i3).f11994c.get(i2).e();
                if (e2 == null) {
                    return new d(true, 0, j);
                }
                z2 |= e2.b();
                int a2 = e2.a(j2);
                if (a2 == 0) {
                    i = i3;
                    z = true;
                    j4 = 0;
                    j3 = 0;
                } else if (!z) {
                    int a3 = e2.a();
                    i = i3;
                    long max = Math.max(j4, e2.a(a3));
                    if (a2 != -1) {
                        int i4 = (a3 + a2) - 1;
                        j3 = Math.min(j3, e2.a(i4) + e2.a(i4, j2));
                    }
                    j4 = max;
                } else {
                    i = i3;
                }
                i3 = i + 1;
                i2 = 0;
            }
            return new d(z2, j4, j3);
        }

        private d(boolean z, long j, long j2) {
            this.f11925a = z;
            this.f11926b = j;
            this.f11927c = j2;
        }
    }

    private static final class a extends x {

        /* renamed from: b  reason: collision with root package name */
        private final long f11918b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11919c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11920d;

        /* renamed from: e  reason: collision with root package name */
        private final long f11921e;

        /* renamed from: f  reason: collision with root package name */
        private final long f11922f;

        /* renamed from: g  reason: collision with root package name */
        private final long f11923g;
        private final com.google.android.exoplayer2.source.dash.manifest.b h;

        public int b() {
            return 1;
        }

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.f11918b = j;
            this.f11919c = j2;
            this.f11920d = i;
            this.f11921e = j3;
            this.f11922f = j4;
            this.f11923g = j5;
            this.h = bVar;
        }

        public int c() {
            return this.h.a();
        }

        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.s.a.a(i, 0, this.h.a());
            Integer num = null;
            String str = z ? this.h.a(i).f12017a : null;
            if (z) {
                num = Integer.valueOf(this.f11920d + com.google.android.exoplayer2.s.a.a(i, 0, this.h.a()));
            }
            return aVar.a(str, num, 0, this.h.c(i), com.google.android.exoplayer2.b.b(this.h.a(i).f12018b - this.h.a(0).f12018b) - this.f11921e);
        }

        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.s.a.a(i, 0, 1);
            return bVar.a((Object) null, this.f11918b, this.f11919c, true, this.h.f12000d, a(j), this.f11922f, 0, this.h.a() - 1, this.f11921e);
        }

        public int a(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            int intValue = ((Integer) obj).intValue();
            int i = this.f11920d;
            if (intValue < i || intValue >= i + c()) {
                return -1;
            }
            return intValue - this.f11920d;
        }

        private long a(long j) {
            long j2 = this.f11923g;
            if (!this.h.f12000d) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.f11922f) {
                    return -9223372036854775807L;
                }
            }
            long c2 = this.h.c(0);
            long j3 = this.f11921e + j2;
            int i = 0;
            while (i < this.h.a() - 1 && j3 >= c2) {
                j3 -= c2;
                i++;
                c2 = this.h.c(i);
            }
            com.google.android.exoplayer2.source.dash.manifest.e a2 = this.h.a(i);
            int a3 = a2.a(2);
            if (a3 == -1) {
                return j2;
            }
            d e2 = a2.f12019c.get(a3).f11994c.get(0).e();
            return (e2 == null || e2.a(c2) == 0) ? j2 : (j2 + e2.a(e2.a(j3, c2))) - j3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.dash.c$c  reason: collision with other inner class name */
    private final class C0194c implements r.a<t<com.google.android.exoplayer2.source.dash.manifest.b>> {
        private C0194c() {
        }

        public void a(t<com.google.android.exoplayer2.source.dash.manifest.b> tVar, long j, long j2) {
            c.this.a(tVar, j, j2);
        }

        public void a(t<com.google.android.exoplayer2.source.dash.manifest.b> tVar, long j, long j2, boolean z) {
            c.this.c(tVar, j, j2);
        }

        public int a(t<com.google.android.exoplayer2.source.dash.manifest.b> tVar, long j, long j2, IOException iOException) {
            return c.this.a(tVar, j, j2, iOException);
        }
    }

    private final class e implements r.a<t<Long>> {
        private e() {
        }

        public void a(t<Long> tVar, long j, long j2) {
            c.this.b(tVar, j, j2);
        }

        public void a(t<Long> tVar, long j, long j2, boolean z) {
            c.this.c(tVar, j, j2);
        }

        public int a(t<Long> tVar, long j, long j2, IOException iOException) {
            return c.this.b(tVar, j, j2, iOException);
        }
    }

    private static final class f implements t.a<Long> {
        private f() {
        }

        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(v.f(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    private static final class b implements t.a<Long> {
        private b() {
        }

        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
            } catch (ParseException e2) {
                throw new p((Throwable) e2);
            }
        }
    }
}
