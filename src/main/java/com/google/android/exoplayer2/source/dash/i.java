package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.r;
import com.google.android.exoplayer2.m.s;
import com.google.android.exoplayer2.m.t;
import com.google.android.exoplayer2.source.dash.a.k;
import com.google.android.exoplayer2.source.dash.g;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.z;
import com.tencent.imsdk.BaseConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class i implements y {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11953a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f11954b;

    /* renamed from: c  reason: collision with root package name */
    private final g.a f11955c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11956d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11957e;

    /* renamed from: f  reason: collision with root package name */
    private final r.a f11958f;

    /* renamed from: g  reason: collision with root package name */
    private final t.a<? extends com.google.android.exoplayer2.source.dash.a.b> f11959g;
    private final c h;
    private final Object i;
    private final SparseArray<h> j;
    private final Runnable k;
    private final Runnable l;
    private y.a m;
    private com.google.android.exoplayer2.m.f n;
    private com.google.android.exoplayer2.m.r o;
    private s p;
    private Uri q;
    private long r;
    private long s;
    private com.google.android.exoplayer2.source.dash.a.b t;
    private Handler u;
    private long v;
    private int w;

    public i(Uri uri, f.a aVar, g.a aVar2, Handler handler, r rVar) {
        this(uri, aVar, aVar2, 3, -1, handler, rVar);
    }

    public i(Uri uri, f.a aVar, g.a aVar2, int i2, long j2, Handler handler, r rVar) {
        this(uri, aVar, new com.google.android.exoplayer2.source.dash.a.c(), aVar2, i2, j2, handler, rVar);
    }

    public i(Uri uri, f.a aVar, t.a<? extends com.google.android.exoplayer2.source.dash.a.b> aVar2, g.a aVar3, int i2, long j2, Handler handler, r rVar) {
        this((com.google.android.exoplayer2.source.dash.a.b) null, uri, aVar, aVar2, aVar3, i2, j2, handler, rVar);
    }

    private i(com.google.android.exoplayer2.source.dash.a.b bVar, Uri uri, f.a aVar, t.a<? extends com.google.android.exoplayer2.source.dash.a.b> aVar2, g.a aVar3, int i2, long j2, Handler handler, r rVar) {
        this.t = bVar;
        this.q = uri;
        this.f11954b = aVar;
        this.f11959g = aVar2;
        this.f11955c = aVar3;
        this.f11956d = i2;
        this.f11957e = j2;
        this.f11953a = bVar != null;
        this.f11958f = new r.a(handler, rVar);
        this.i = new Object();
        this.j = new SparseArray<>();
        if (this.f11953a) {
            com.google.android.exoplayer2.n.a.b(!bVar.f11845d);
            this.h = null;
            this.k = null;
            this.l = null;
            return;
        }
        this.h = new c();
        this.k = new Runnable() {
            public void run() {
                i.this.c();
            }
        };
        this.l = new Runnable() {
            public void run() {
                i.this.a(false);
            }
        };
    }

    public void a(ad adVar, boolean z, y.a aVar) {
        this.m = aVar;
        if (this.f11953a) {
            this.p = new s.a();
            a(false);
            return;
        }
        this.n = this.f11954b.a();
        this.o = new com.google.android.exoplayer2.m.r("Loader:DashMediaSource");
        this.p = this.o;
        this.u = new Handler();
        c();
    }

    public void a() throws IOException {
        this.p.d();
    }

    public x a(int i2, com.google.android.exoplayer2.m.b bVar, long j2) {
        int i3 = i2;
        h hVar = new h(this.w + i3, this.t, i3, this.f11955c, this.f11956d, this.f11958f.a(this.t.a(i2).f11860b), this.v, this.p, bVar);
        this.j.put(hVar.f11944a, hVar);
        return hVar;
    }

    public void a(x xVar) {
        h hVar = (h) xVar;
        hVar.a();
        this.j.remove(hVar.f11944a);
    }

    public void b() {
        this.n = null;
        this.p = null;
        com.google.android.exoplayer2.m.r rVar = this.o;
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
    public void a(t<com.google.android.exoplayer2.source.dash.a.b> tVar, long j2, long j3) {
        this.f11958f.a(tVar.f10827a, tVar.f10828b, j2, j3, tVar.e());
        com.google.android.exoplayer2.source.dash.a.b d2 = tVar.d();
        com.google.android.exoplayer2.source.dash.a.b bVar = this.t;
        int i2 = 0;
        int a2 = bVar == null ? 0 : bVar.a();
        long j4 = d2.a(0).f11860b;
        while (i2 < a2 && this.t.a(i2).f11860b < j4) {
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
                if (tVar.f10827a.f10764a == this.q) {
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
    public int a(t<com.google.android.exoplayer2.source.dash.a.b> tVar, long j2, long j3, IOException iOException) {
        t<com.google.android.exoplayer2.source.dash.a.b> tVar2 = tVar;
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof ak;
        this.f11958f.a(tVar2.f10827a, tVar2.f10828b, j2, j3, tVar.e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    public void b(t<Long> tVar, long j2, long j3) {
        this.f11958f.a(tVar.f10827a, tVar.f10828b, j2, j3, tVar.e());
        a(tVar.d().longValue() - j2);
    }

    /* access modifiers changed from: package-private */
    public int b(t<Long> tVar, long j2, long j3, IOException iOException) {
        t<Long> tVar2 = tVar;
        r.a aVar = this.f11958f;
        com.google.android.exoplayer2.m.i iVar = tVar2.f10827a;
        int i2 = tVar2.f10828b;
        aVar.a(iVar, i2, j2, j3, tVar.e(), iOException, true);
        a(iOException);
        return 2;
    }

    /* access modifiers changed from: package-private */
    public void c(t<?> tVar, long j2, long j3) {
        this.f11958f.b(tVar.f10827a, tVar.f10828b, j2, j3, tVar.e());
    }

    /* access modifiers changed from: private */
    public void c() {
        Uri uri;
        synchronized (this.i) {
            uri = this.q;
        }
        a(new t(this.n, uri, 4, this.f11959g), this.h, this.f11956d);
    }

    private void a(k kVar) {
        String str = kVar.f11894a;
        if (com.google.android.exoplayer2.n.t.a((Object) str, (Object) "urn:mpeg:dash:utc:direct:2012")) {
            b(kVar);
        } else if (com.google.android.exoplayer2.n.t.a((Object) str, (Object) "urn:mpeg:dash:utc:http-iso:2014")) {
            a(kVar, (t.a<Long>) new b());
        } else if (com.google.android.exoplayer2.n.t.a((Object) str, (Object) "urn:mpeg:dash:utc:http-xsdate:2012") || com.google.android.exoplayer2.n.t.a((Object) str, (Object) "urn:mpeg:dash:utc:http-xsdate:2014")) {
            a(kVar, (t.a<Long>) new f());
        } else {
            a(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void b(k kVar) {
        try {
            a(com.google.android.exoplayer2.n.t.f(kVar.f11895b) - this.s);
        } catch (ak e2) {
            a((IOException) e2);
        }
    }

    private void a(k kVar, t.a<Long> aVar) {
        a(new t(this.n, Uri.parse(kVar.f11895b), 5, aVar), new e(), 1);
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
        long j4 = a3.f11970b;
        long j5 = a4.f11971c;
        long j6 = 0;
        if (!this.t.f11845d || a4.f11969a) {
            j2 = j4;
            z2 = false;
        } else {
            j5 = Math.min((e() - z.b(this.t.f11842a)) - z.b(this.t.a(a2).f11860b), j5);
            if (this.t.f11847f != -9223372036854775807L) {
                long b2 = j5 - z.b(this.t.f11847f);
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
        if (this.t.f11845d) {
            long j8 = this.f11957e;
            if (j8 == -1) {
                j8 = this.t.f11848g != -9223372036854775807L ? this.t.f11848g : BaseConstants.DEFAULT_MSG_TIMEOUT;
            }
            j6 = j7 - z.b(j8);
            if (j6 < 5000000) {
                j6 = Math.min(5000000, j7 / 2);
            }
        }
        this.m.a(new a(this.t.f11842a, this.t.f11842a + this.t.a(0).f11860b + z.a(j2), this.w, j2, j7, j6, this.t), this.t);
        if (!this.f11953a) {
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
        if (this.t.f11845d) {
            long j2 = this.t.f11846e;
            if (j2 == 0) {
                j2 = 5000;
            }
            this.u.postDelayed(this.k, Math.max(0, (this.r + j2) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(t<T> tVar, r.a<t<T>> aVar, int i2) {
        this.f11958f.a(tVar.f10827a, tVar.f10828b, this.o.a(tVar, aVar, i2));
    }

    private long e() {
        if (this.v != 0) {
            return z.b(SystemClock.elapsedRealtime() + this.v);
        }
        return z.b(System.currentTimeMillis());
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f11969a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11970b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11971c;

        public static d a(com.google.android.exoplayer2.source.dash.a.d dVar, long j) {
            int i;
            com.google.android.exoplayer2.source.dash.a.d dVar2 = dVar;
            long j2 = j;
            int size = dVar2.f11861c.size();
            int i2 = 0;
            long j3 = Long.MAX_VALUE;
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            long j4 = 0;
            while (i3 < size) {
                j c2 = dVar2.f11861c.get(i3).f11840c.get(i2).c();
                if (c2 == null) {
                    return new d(true, 0, j);
                }
                z2 |= c2.f();
                int a2 = c2.a(j2);
                if (a2 == 0) {
                    i = i3;
                    z = true;
                    j4 = 0;
                    j3 = 0;
                } else if (!z) {
                    int e2 = c2.e();
                    i = i3;
                    long max = Math.max(j4, c2.b(e2));
                    if (a2 != -1) {
                        int i4 = (e2 + a2) - 1;
                        j3 = Math.min(j3, c2.b(i4) + c2.a(i4, j2));
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
            this.f11969a = z;
            this.f11970b = j;
            this.f11971c = j2;
        }
    }

    private static final class a extends ar {

        /* renamed from: b  reason: collision with root package name */
        private final long f11962b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11963c;

        /* renamed from: d  reason: collision with root package name */
        private final int f11964d;

        /* renamed from: e  reason: collision with root package name */
        private final long f11965e;

        /* renamed from: f  reason: collision with root package name */
        private final long f11966f;

        /* renamed from: g  reason: collision with root package name */
        private final long f11967g;
        private final com.google.android.exoplayer2.source.dash.a.b h;

        public int b() {
            return 1;
        }

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.a.b bVar) {
            this.f11962b = j;
            this.f11963c = j2;
            this.f11964d = i;
            this.f11965e = j3;
            this.f11966f = j4;
            this.f11967g = j5;
            this.h = bVar;
        }

        public int a() {
            return this.h.a();
        }

        public ar.a a(int i, ar.a aVar, boolean z) {
            com.google.android.exoplayer2.n.a.a(i, 0, this.h.a());
            Integer num = null;
            String str = z ? this.h.a(i).f11859a : null;
            if (z) {
                num = Integer.valueOf(this.f11964d + com.google.android.exoplayer2.n.a.a(i, 0, this.h.a()));
            }
            return aVar.a(str, num, 0, this.h.c(i), z.b(this.h.a(i).f11860b - this.h.a(0).f11860b) - this.f11965e, false);
        }

        public ar.b a(int i, ar.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.n.a.a(i, 0, 1);
            return bVar.a((Object) null, this.f11962b, this.f11963c, true, this.h.f11845d, a(j), this.f11966f, 0, this.h.a() - 1, this.f11965e);
        }

        public int a(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            int intValue = ((Integer) obj).intValue();
            int i = this.f11964d;
            if (intValue < i || intValue >= i + a()) {
                return -1;
            }
            return intValue - this.f11964d;
        }

        private long a(long j) {
            long j2 = this.f11967g;
            if (!this.h.f11845d) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.f11966f) {
                    return -9223372036854775807L;
                }
            }
            long c2 = this.h.c(0);
            long j3 = this.f11965e + j2;
            int i = 0;
            while (i < this.h.a() - 1 && j3 >= c2) {
                j3 -= c2;
                i++;
                c2 = this.h.c(i);
            }
            com.google.android.exoplayer2.source.dash.a.d a2 = this.h.a(i);
            int a3 = a2.a(2);
            if (a3 == -1) {
                return j2;
            }
            j c3 = a2.f11861c.get(a3).f11840c.get(0).c();
            return (c3 == null || c3.a(c2) == 0) ? j2 : (j2 + c3.b(c3.a(j3, c2))) - j3;
        }
    }

    private final class c implements r.a<t<com.google.android.exoplayer2.source.dash.a.b>> {
        private c() {
        }

        public void a(t<com.google.android.exoplayer2.source.dash.a.b> tVar, long j, long j2) {
            i.this.a(tVar, j, j2);
        }

        public void a(t<com.google.android.exoplayer2.source.dash.a.b> tVar, long j, long j2, boolean z) {
            i.this.c(tVar, j, j2);
        }

        public int a(t<com.google.android.exoplayer2.source.dash.a.b> tVar, long j, long j2, IOException iOException) {
            return i.this.a(tVar, j, j2, iOException);
        }
    }

    private final class e implements r.a<t<Long>> {
        private e() {
        }

        public void a(t<Long> tVar, long j, long j2) {
            i.this.b(tVar, j, j2);
        }

        public void a(t<Long> tVar, long j, long j2, boolean z) {
            i.this.c(tVar, j, j2);
        }

        public int a(t<Long> tVar, long j, long j2, IOException iOException) {
            return i.this.b(tVar, j, j2, iOException);
        }
    }

    private static final class f implements t.a<Long> {
        private f() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(com.google.android.exoplayer2.n.t.f(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    private static final class b implements t.a<Long> {
        private b() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
            } catch (ParseException e2) {
                throw new ak((Throwable) e2);
            }
        }
    }
}
