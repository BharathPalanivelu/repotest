package com.google.android.exoplayer2.source.c.b;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r.r;
import com.google.android.exoplayer2.r.t;
import com.google.android.exoplayer2.s.u;
import com.google.android.exoplayer2.source.a;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.c.b.a;
import com.google.android.exoplayer2.source.c.b.b;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements r.a<t<c>> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11668a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final com.google.android.exoplayer2.source.c.d f11669b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final d f11670c = new d();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f11671d;

    /* renamed from: e  reason: collision with root package name */
    private final IdentityHashMap<a.C0187a, a> f11672e = new IdentityHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Handler f11673f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    private final C0188e f11674g;
    private final List<b> h = new ArrayList();
    private final r i = new r("HlsPlaylistTracker:MasterPlaylist");
    /* access modifiers changed from: private */
    public final a.C0185a j;
    /* access modifiers changed from: private */
    public a k;
    /* access modifiers changed from: private */
    public a.C0187a l;
    private b m;
    private boolean n;

    public interface b {
        void a(a.C0187a aVar, long j);

        void h();
    }

    /* renamed from: com.google.android.exoplayer2.source.c.b.e$e  reason: collision with other inner class name */
    public interface C0188e {
        void a(b bVar);
    }

    public static final class d extends IOException {
        public final String url;

        private d(String str) {
            this.url = str;
        }
    }

    public static final class c extends IOException {
        public final String url;

        private c(String str) {
            this.url = str;
        }
    }

    public e(Uri uri, com.google.android.exoplayer2.source.c.d dVar, a.C0185a aVar, int i2, C0188e eVar) {
        this.f11668a = uri;
        this.f11669b = dVar;
        this.j = aVar;
        this.f11671d = i2;
        this.f11674g = eVar;
    }

    public void a(b bVar) {
        this.h.add(bVar);
    }

    public void b(b bVar) {
        this.h.remove(bVar);
    }

    public void a() {
        this.i.a(new t(this.f11669b.a(4), this.f11668a, 4, this.f11670c), this, this.f11671d);
    }

    public a b() {
        return this.k;
    }

    public b a(a.C0187a aVar) {
        b a2 = this.f11672e.get(aVar).a();
        if (a2 != null) {
            e(aVar);
        }
        return a2;
    }

    public boolean b(a.C0187a aVar) {
        return this.f11672e.get(aVar).b();
    }

    public void c() {
        this.i.c();
        for (a c2 : this.f11672e.values()) {
            c2.c();
        }
        this.f11673f.removeCallbacksAndMessages((Object) null);
        this.f11672e.clear();
    }

    public void d() throws IOException {
        this.i.d();
        a.C0187a aVar = this.l;
        if (aVar != null) {
            c(aVar);
        }
    }

    public void c(a.C0187a aVar) throws IOException {
        this.f11672e.get(aVar).e();
    }

    public void d(a.C0187a aVar) {
        this.f11672e.get(aVar).d();
    }

    public boolean e() {
        return this.n;
    }

    public void a(t<c> tVar, long j2, long j3) {
        a aVar;
        c d2 = tVar.d();
        boolean z = d2 instanceof b;
        if (z) {
            aVar = a.a(d2.o);
        } else {
            aVar = (a) d2;
        }
        this.k = aVar;
        this.l = aVar.f11637a.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.f11637a);
        arrayList.addAll(aVar.f11638b);
        arrayList.addAll(aVar.f11639c);
        a((List<a.C0187a>) arrayList);
        a aVar2 = this.f11672e.get(this.l);
        if (z) {
            aVar2.a((b) d2);
        } else {
            aVar2.d();
        }
        this.j.a(tVar.f11379a, 4, j2, j3, tVar.e());
    }

    public void a(t<c> tVar, long j2, long j3, boolean z) {
        this.j.b(tVar.f11379a, 4, j2, j3, tVar.e());
    }

    public int a(t<c> tVar, long j2, long j3, IOException iOException) {
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof p;
        this.j.a(tVar.f11379a, 4, j2, j3, tVar.e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* access modifiers changed from: private */
    public boolean f() {
        List<a.C0187a> list = this.k.f11637a;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f11672e.get(list.get(i2));
            if (elapsedRealtime > aVar.i) {
                this.l = aVar.f11676b;
                aVar.d();
                return true;
            }
        }
        return false;
    }

    private void e(a.C0187a aVar) {
        if (this.k.f11637a.contains(aVar)) {
            b bVar = this.m;
            if ((bVar == null || !bVar.j) && this.f11672e.get(this.l).h - SystemClock.elapsedRealtime() > Timer.DEFAULT_TIMER_DELAY_MS) {
                this.l = aVar;
                this.f11672e.get(this.l).d();
            }
        }
    }

    private void a(List<a.C0187a> list) {
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0187a aVar = list.get(i2);
            this.f11672e.put(aVar, new a(aVar, elapsedRealtime));
        }
    }

    /* access modifiers changed from: private */
    public boolean a(a.C0187a aVar, b bVar) {
        if (aVar == this.l) {
            if (this.m == null) {
                this.n = !bVar.j;
            }
            this.m = bVar;
            this.f11674g.a(bVar);
        }
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.h.get(i2).h();
        }
        if (aVar != this.l || bVar.j) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(a.C0187a aVar, long j2) {
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.h.get(i2).a(aVar, j2);
        }
    }

    /* access modifiers changed from: private */
    public b a(b bVar, b bVar2) {
        if (!bVar2.a(bVar)) {
            return bVar2.j ? bVar.b() : bVar;
        }
        return bVar2.a(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(b bVar, b bVar2) {
        if (bVar2.k) {
            return bVar2.f11646c;
        }
        b bVar3 = this.m;
        long j2 = bVar3 != null ? bVar3.f11646c : 0;
        if (bVar == null) {
            return j2;
        }
        int size = bVar.m.size();
        b.a d2 = d(bVar, bVar2);
        if (d2 != null) {
            return bVar.f11646c + d2.f11654d;
        }
        return size == bVar2.f11649f - bVar.f11649f ? bVar.a() : j2;
    }

    private int c(b bVar, b bVar2) {
        if (bVar2.f11647d) {
            return bVar2.f11648e;
        }
        b bVar3 = this.m;
        int i2 = bVar3 != null ? bVar3.f11648e : 0;
        if (bVar == null) {
            return i2;
        }
        b.a d2 = d(bVar, bVar2);
        return d2 != null ? (bVar.f11648e + d2.f11653c) - bVar2.m.get(0).f11653c : i2;
    }

    private static b.a d(b bVar, b bVar2) {
        int i2 = bVar2.f11649f - bVar.f11649f;
        List<b.a> list = bVar.m;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    private final class a implements r.a<t<c>>, Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final a.C0187a f11676b;

        /* renamed from: c  reason: collision with root package name */
        private final r f11677c = new r("HlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d  reason: collision with root package name */
        private final t<c> f11678d;

        /* renamed from: e  reason: collision with root package name */
        private b f11679e;

        /* renamed from: f  reason: collision with root package name */
        private long f11680f;

        /* renamed from: g  reason: collision with root package name */
        private long f11681g;
        /* access modifiers changed from: private */
        public long h;
        /* access modifiers changed from: private */
        public long i;
        private boolean j;
        private IOException k;

        public a(a.C0187a aVar, long j2) {
            this.f11676b = aVar;
            this.h = j2;
            this.f11678d = new t<>(e.this.f11669b.a(4), u.a(e.this.k.o, aVar.f11642a), 4, e.this.f11670c);
        }

        public b a() {
            this.h = SystemClock.elapsedRealtime();
            return this.f11679e;
        }

        public boolean b() {
            if (this.f11679e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(BaseConstants.DEFAULT_MSG_TIMEOUT, com.google.android.exoplayer2.b.a(this.f11679e.n));
            if (this.f11679e.j || this.f11679e.f11644a == 2 || this.f11679e.f11644a == 1 || this.f11680f + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void c() {
            this.f11677c.c();
        }

        public void d() {
            this.i = 0;
            if (!this.j && !this.f11677c.a()) {
                this.f11677c.a(this.f11678d, this, e.this.f11671d);
            }
        }

        public void e() throws IOException {
            this.f11677c.d();
            IOException iOException = this.k;
            if (iOException != null) {
                throw iOException;
            }
        }

        public void a(t<c> tVar, long j2, long j3) {
            c d2 = tVar.d();
            if (d2 instanceof b) {
                a((b) d2);
                e.this.j.a(tVar.f11379a, 4, j2, j3, tVar.e());
                return;
            }
            this.k = new p("Loaded playlist has unexpected type.");
        }

        public void a(t<c> tVar, long j2, long j3, boolean z) {
            e.this.j.b(tVar.f11379a, 4, j2, j3, tVar.e());
        }

        public int a(t<c> tVar, long j2, long j3, IOException iOException) {
            boolean z = iOException instanceof p;
            e.this.j.a(tVar.f11379a, 4, j2, j3, tVar.e(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.a(iOException)) {
                f();
                if (e.this.l != this.f11676b || e.this.f()) {
                    z2 = false;
                }
            }
            if (z2) {
                return 0;
            }
            return 2;
        }

        public void run() {
            this.j = false;
            d();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.google.android.exoplayer2.source.c.b.b r10) {
            /*
                r9 = this;
                com.google.android.exoplayer2.source.c.b.b r0 = r9.f11679e
                long r1 = android.os.SystemClock.elapsedRealtime()
                r9.f11680f = r1
                com.google.android.exoplayer2.source.c.b.e r3 = com.google.android.exoplayer2.source.c.b.e.this
                com.google.android.exoplayer2.source.c.b.b r3 = r3.a((com.google.android.exoplayer2.source.c.b.b) r0, (com.google.android.exoplayer2.source.c.b.b) r10)
                r9.f11679e = r3
                com.google.android.exoplayer2.source.c.b.b r3 = r9.f11679e
                r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r6 = 0
                if (r3 == r0) goto L_0x002d
                r9.k = r6
                r9.f11681g = r1
                com.google.android.exoplayer2.source.c.b.e r10 = com.google.android.exoplayer2.source.c.b.e.this
                com.google.android.exoplayer2.source.c.b.a$a r0 = r9.f11676b
                boolean r10 = r10.a((com.google.android.exoplayer2.source.c.b.a.C0187a) r0, (com.google.android.exoplayer2.source.c.b.b) r3)
                if (r10 == 0) goto L_0x007a
                com.google.android.exoplayer2.source.c.b.b r10 = r9.f11679e
                long r0 = r10.h
                goto L_0x007b
            L_0x002d:
                boolean r0 = r3.j
                if (r0 != 0) goto L_0x007a
                long r7 = r9.f11681g
                long r1 = r1 - r7
                double r0 = (double) r1
                com.google.android.exoplayer2.source.c.b.b r2 = r9.f11679e
                long r2 = r2.h
                long r2 = com.google.android.exoplayer2.b.a(r2)
                double r2 = (double) r2
                r7 = 4615063718147915776(0x400c000000000000, double:3.5)
                java.lang.Double.isNaN(r2)
                double r2 = r2 * r7
                int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r7 <= 0) goto L_0x0058
                com.google.android.exoplayer2.source.c.b.e$d r10 = new com.google.android.exoplayer2.source.c.b.e$d
                com.google.android.exoplayer2.source.c.b.a$a r0 = r9.f11676b
                java.lang.String r0 = r0.f11642a
                r10.<init>(r0)
                r9.k = r10
                r9.f()
                goto L_0x0072
            L_0x0058:
                int r0 = r10.f11649f
                java.util.List<com.google.android.exoplayer2.source.c.b.b$a> r10 = r10.m
                int r10 = r10.size()
                int r0 = r0 + r10
                com.google.android.exoplayer2.source.c.b.b r10 = r9.f11679e
                int r10 = r10.f11649f
                if (r0 >= r10) goto L_0x0072
                com.google.android.exoplayer2.source.c.b.e$c r10 = new com.google.android.exoplayer2.source.c.b.e$c
                com.google.android.exoplayer2.source.c.b.a$a r0 = r9.f11676b
                java.lang.String r0 = r0.f11642a
                r10.<init>(r0)
                r9.k = r10
            L_0x0072:
                com.google.android.exoplayer2.source.c.b.b r10 = r9.f11679e
                long r0 = r10.h
                r2 = 2
                long r0 = r0 / r2
                goto L_0x007b
            L_0x007a:
                r0 = r4
            L_0x007b:
                int r10 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r10 == 0) goto L_0x008f
                com.google.android.exoplayer2.source.c.b.e r10 = com.google.android.exoplayer2.source.c.b.e.this
                android.os.Handler r10 = r10.f11673f
                long r0 = com.google.android.exoplayer2.b.a(r0)
                boolean r10 = r10.postDelayed(r9, r0)
                r9.j = r10
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.b.e.a.a(com.google.android.exoplayer2.source.c.b.b):void");
        }

        private void f() {
            this.i = SystemClock.elapsedRealtime() + 60000;
            e.this.a(this.f11676b, 60000);
        }
    }
}
