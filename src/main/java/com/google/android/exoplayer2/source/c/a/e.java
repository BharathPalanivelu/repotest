package com.google.android.exoplayer2.source.c.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.m.r;
import com.google.android.exoplayer2.m.t;
import com.google.android.exoplayer2.n.s;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.c.a.b;
import com.google.android.exoplayer2.source.c.p;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.z;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements r.a<t<c>> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11622a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final p f11623b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final d f11624c = new d();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f11625d;

    /* renamed from: e  reason: collision with root package name */
    private final IdentityHashMap<a.C0186a, a> f11626e = new IdentityHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Handler f11627f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    private final c f11628g;
    private final List<b> h = new ArrayList();
    private final r i = new r("HlsPlaylistTracker:MasterPlaylist");
    /* access modifiers changed from: private */
    public final r.a j;
    /* access modifiers changed from: private */
    public a k;
    /* access modifiers changed from: private */
    public a.C0186a l;
    private b m;
    private boolean n;

    public interface b {
        void a();

        void a(a.C0186a aVar, long j);
    }

    public interface c {
        void a(b bVar);
    }

    public e(Uri uri, p pVar, r.a aVar, int i2, c cVar) {
        this.f11622a = uri;
        this.f11623b = pVar;
        this.j = aVar;
        this.f11625d = i2;
        this.f11628g = cVar;
    }

    public void a(b bVar) {
        this.h.add(bVar);
    }

    public void b(b bVar) {
        this.h.remove(bVar);
    }

    public void a() {
        this.i.a(new t(this.f11623b.a(4), this.f11622a, 4, this.f11624c), this, this.f11625d);
    }

    public a b() {
        return this.k;
    }

    public b a(a.C0186a aVar) {
        b a2 = this.f11626e.get(aVar).a();
        if (a2 != null) {
            e(aVar);
        }
        return a2;
    }

    public boolean b(a.C0186a aVar) {
        return this.f11626e.get(aVar).b();
    }

    public void c() {
        this.i.c();
        for (a c2 : this.f11626e.values()) {
            c2.c();
        }
        this.f11627f.removeCallbacksAndMessages((Object) null);
        this.f11626e.clear();
    }

    public void d() throws IOException {
        this.i.d();
        a.C0186a aVar = this.l;
        if (aVar != null) {
            c(aVar);
        }
    }

    public void c(a.C0186a aVar) throws IOException {
        this.f11626e.get(aVar).f11631c.d();
    }

    public void d(a.C0186a aVar) {
        this.f11626e.get(aVar).d();
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
        this.l = aVar.f11591a.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.f11591a);
        arrayList.addAll(aVar.f11592b);
        arrayList.addAll(aVar.f11593c);
        a((List<a.C0186a>) arrayList);
        a aVar2 = this.f11626e.get(this.l);
        if (z) {
            aVar2.a((b) d2);
        } else {
            aVar2.d();
        }
        this.j.a(tVar.f10827a, 4, j2, j3, tVar.e());
    }

    public void a(t<c> tVar, long j2, long j3, boolean z) {
        this.j.b(tVar.f10827a, 4, j2, j3, tVar.e());
    }

    public int a(t<c> tVar, long j2, long j3, IOException iOException) {
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof ak;
        this.j.a(tVar.f10827a, 4, j2, j3, tVar.e(), iOException2, z);
        return z ? 3 : 0;
    }

    /* access modifiers changed from: private */
    public boolean f() {
        List<a.C0186a> list = this.k.f11591a;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f11626e.get(list.get(i2));
            if (elapsedRealtime > aVar.h) {
                this.l = aVar.f11630b;
                aVar.d();
                return true;
            }
        }
        return false;
    }

    private void e(a.C0186a aVar) {
        if (this.k.f11591a.contains(aVar)) {
            b bVar = this.m;
            if ((bVar == null || !bVar.i) && this.f11626e.get(this.l).f11635g - SystemClock.elapsedRealtime() > Timer.DEFAULT_TIMER_DELAY_MS) {
                this.l = aVar;
                this.f11626e.get(this.l).d();
            }
        }
    }

    private void a(List<a.C0186a> list) {
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0186a aVar = list.get(i2);
            this.f11626e.put(aVar, new a(aVar, elapsedRealtime));
        }
    }

    /* access modifiers changed from: private */
    public boolean a(a.C0186a aVar, b bVar) {
        if (aVar == this.l) {
            if (this.m == null) {
                this.n = !bVar.i;
            }
            this.m = bVar;
            this.f11628g.a(bVar);
        }
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.h.get(i2).a();
        }
        if (aVar != this.l || bVar.i) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(a.C0186a aVar, long j2) {
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.h.get(i2).a(aVar, j2);
        }
    }

    /* access modifiers changed from: private */
    public b a(b bVar, b bVar2) {
        if (!bVar2.a(bVar)) {
            return bVar2.i ? bVar.b() : bVar;
        }
        return bVar2.a(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(b bVar, b bVar2) {
        if (bVar2.j) {
            return bVar2.f11600c;
        }
        b bVar3 = this.m;
        long j2 = bVar3 != null ? bVar3.f11600c : 0;
        if (bVar == null) {
            return j2;
        }
        int size = bVar.l.size();
        b.a d2 = d(bVar, bVar2);
        if (d2 != null) {
            return bVar.f11600c + d2.f11608d;
        }
        return size == bVar2.f11603f - bVar.f11603f ? bVar.a() : j2;
    }

    private int c(b bVar, b bVar2) {
        if (bVar2.f11601d) {
            return bVar2.f11602e;
        }
        b bVar3 = this.m;
        int i2 = bVar3 != null ? bVar3.f11602e : 0;
        if (bVar == null) {
            return i2;
        }
        b.a d2 = d(bVar, bVar2);
        return d2 != null ? (bVar.f11602e + d2.f11607c) - bVar2.l.get(0).f11607c : i2;
    }

    private static b.a d(b bVar, b bVar2) {
        int i2 = bVar2.f11603f - bVar.f11603f;
        List<b.a> list = bVar.l;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    private final class a implements r.a<t<c>>, Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final a.C0186a f11630b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final com.google.android.exoplayer2.m.r f11631c = new com.google.android.exoplayer2.m.r("HlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d  reason: collision with root package name */
        private final t<c> f11632d;

        /* renamed from: e  reason: collision with root package name */
        private b f11633e;

        /* renamed from: f  reason: collision with root package name */
        private long f11634f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f11635g;
        /* access modifiers changed from: private */
        public long h;
        private boolean i;

        public a(a.C0186a aVar, long j) {
            this.f11630b = aVar;
            this.f11635g = j;
            this.f11632d = new t<>(e.this.f11623b.a(4), s.a(e.this.k.o, aVar.f11596a), 4, e.this.f11624c);
        }

        public b a() {
            this.f11635g = SystemClock.elapsedRealtime();
            return this.f11633e;
        }

        public boolean b() {
            if (this.f11633e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(BaseConstants.DEFAULT_MSG_TIMEOUT, z.a(this.f11633e.n));
            if (this.f11633e.i || this.f11633e.f11598a == 2 || this.f11633e.f11598a == 1 || this.f11634f + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void c() {
            this.f11631c.c();
        }

        public void d() {
            this.h = 0;
            if (!this.i && !this.f11631c.a()) {
                this.f11631c.a(this.f11632d, this, e.this.f11625d);
            }
        }

        public void a(t<c> tVar, long j, long j2) {
            c d2 = tVar.d();
            if (d2 instanceof b) {
                a((b) d2);
                e.this.j.a(tVar.f10827a, 4, j, j2, tVar.e());
                return;
            }
            a(tVar, j, j2, (IOException) new ak("Loaded playlist has unexpected type."));
        }

        public void a(t<c> tVar, long j, long j2, boolean z) {
            e.this.j.b(tVar.f10827a, 4, j, j2, tVar.e());
        }

        public int a(t<c> tVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ak;
            e.this.j.a(tVar.f10827a, 4, j, j2, tVar.e(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.a(iOException)) {
                this.h = SystemClock.elapsedRealtime() + 60000;
                e.this.a(this.f11630b, 60000);
                if (e.this.l != this.f11630b || e.this.f()) {
                    z2 = false;
                }
            }
            if (z2) {
                return 0;
            }
            return 2;
        }

        public void run() {
            this.i = false;
            d();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.google.android.exoplayer2.source.c.a.b r8) {
            /*
                r7 = this;
                com.google.android.exoplayer2.source.c.a.b r0 = r7.f11633e
                long r1 = android.os.SystemClock.elapsedRealtime()
                r7.f11634f = r1
                com.google.android.exoplayer2.source.c.a.e r1 = com.google.android.exoplayer2.source.c.a.e.this
                com.google.android.exoplayer2.source.c.a.b r8 = r1.a((com.google.android.exoplayer2.source.c.a.b) r0, (com.google.android.exoplayer2.source.c.a.b) r8)
                r7.f11633e = r8
                com.google.android.exoplayer2.source.c.a.b r8 = r7.f11633e
                r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                if (r8 == r0) goto L_0x0028
                com.google.android.exoplayer2.source.c.a.e r0 = com.google.android.exoplayer2.source.c.a.e.this
                com.google.android.exoplayer2.source.c.a.a$a r3 = r7.f11630b
                boolean r8 = r0.a((com.google.android.exoplayer2.source.c.a.a.C0186a) r3, (com.google.android.exoplayer2.source.c.a.b) r8)
                if (r8 == 0) goto L_0x0034
                com.google.android.exoplayer2.source.c.a.b r8 = r7.f11633e
                long r3 = r8.h
                goto L_0x0035
            L_0x0028:
                boolean r8 = r8.i
                if (r8 != 0) goto L_0x0034
                com.google.android.exoplayer2.source.c.a.b r8 = r7.f11633e
                long r3 = r8.h
                r5 = 2
                long r3 = r3 / r5
                goto L_0x0035
            L_0x0034:
                r3 = r1
            L_0x0035:
                int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r8 == 0) goto L_0x0049
                com.google.android.exoplayer2.source.c.a.e r8 = com.google.android.exoplayer2.source.c.a.e.this
                android.os.Handler r8 = r8.f11627f
                long r0 = com.google.android.exoplayer2.z.a(r3)
                boolean r8 = r8.postDelayed(r7, r0)
                r7.i = r8
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.a.e.a.a(com.google.android.exoplayer2.source.c.a.b):void");
        }
    }
}
