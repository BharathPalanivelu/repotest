package com.google.android.exoplayer2.source.d;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.r;
import com.google.android.exoplayer2.m.s;
import com.google.android.exoplayer2.m.t;
import com.google.android.exoplayer2.source.ab;
import com.google.android.exoplayer2.source.d.a.a;
import com.google.android.exoplayer2.source.d.b;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.z;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;
import java.util.ArrayList;

public final class d implements r.a<t<a>>, y {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11830a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f11831b;

    /* renamed from: c  reason: collision with root package name */
    private final b.a f11832c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11833d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11834e;

    /* renamed from: f  reason: collision with root package name */
    private final r.a f11835f;

    /* renamed from: g  reason: collision with root package name */
    private final t.a<? extends a> f11836g;
    private final ArrayList<c> h;
    private y.a i;
    private f j;
    private com.google.android.exoplayer2.m.r k;
    private s l;
    private long m;
    private a n;
    private Handler o;

    public d(Uri uri, f.a aVar, b.a aVar2, Handler handler, com.google.android.exoplayer2.source.r rVar) {
        this(uri, aVar, aVar2, 3, BaseConstants.DEFAULT_MSG_TIMEOUT, handler, rVar);
    }

    public d(Uri uri, f.a aVar, b.a aVar2, int i2, long j2, Handler handler, com.google.android.exoplayer2.source.r rVar) {
        this(uri, aVar, new com.google.android.exoplayer2.source.d.a.b(), aVar2, i2, j2, handler, rVar);
    }

    public d(Uri uri, f.a aVar, t.a<? extends a> aVar2, b.a aVar3, int i2, long j2, Handler handler, com.google.android.exoplayer2.source.r rVar) {
        this((a) null, uri, aVar, aVar2, aVar3, i2, j2, handler, rVar);
    }

    private d(a aVar, Uri uri, f.a aVar2, t.a<? extends a> aVar3, b.a aVar4, int i2, long j2, Handler handler, com.google.android.exoplayer2.source.r rVar) {
        com.google.android.exoplayer2.n.a.b(aVar == null || !aVar.f11786d);
        this.n = aVar;
        if (uri == null) {
            uri = null;
        } else if (!com.google.android.exoplayer2.n.t.d(uri.getLastPathSegment()).equals("manifest")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.f11830a = uri;
        this.f11831b = aVar2;
        this.f11836g = aVar3;
        this.f11832c = aVar4;
        this.f11833d = i2;
        this.f11834e = j2;
        this.f11835f = new r.a(handler, rVar);
        this.h = new ArrayList<>();
    }

    public void a(ad adVar, boolean z, y.a aVar) {
        this.i = aVar;
        if (this.n != null) {
            this.l = new s.a();
            c();
            return;
        }
        this.j = this.f11831b.a();
        this.k = new com.google.android.exoplayer2.m.r("Loader:Manifest");
        this.l = this.k;
        this.o = new Handler();
        e();
    }

    public void a() throws IOException {
        this.l.d();
    }

    public x a(int i2, com.google.android.exoplayer2.m.b bVar, long j2) {
        com.google.android.exoplayer2.n.a.a(i2 == 0);
        c cVar = new c(this.n, this.f11832c, this.f11833d, this.f11835f, this.l, bVar);
        this.h.add(cVar);
        return cVar;
    }

    public void a(x xVar) {
        ((c) xVar).a();
        this.h.remove(xVar);
    }

    public void b() {
        this.i = null;
        this.n = null;
        this.j = null;
        this.m = 0;
        com.google.android.exoplayer2.m.r rVar = this.k;
        if (rVar != null) {
            rVar.c();
            this.k = null;
        }
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.o = null;
        }
    }

    public void a(t<a> tVar, long j2, long j3) {
        this.f11835f.a(tVar.f10827a, tVar.f10828b, j2, j3, tVar.e());
        this.n = tVar.d();
        this.m = j2 - j3;
        c();
        d();
    }

    public void a(t<a> tVar, long j2, long j3, boolean z) {
        this.f11835f.a(tVar.f10827a, tVar.f10828b, j2, j3, tVar.e());
    }

    public int a(t<a> tVar, long j2, long j3, IOException iOException) {
        t<a> tVar2 = tVar;
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof ak;
        this.f11835f.a(tVar2.f10827a, tVar2.f10828b, j2, j3, tVar.e(), iOException2, z);
        return z ? 3 : 0;
    }

    private void c() {
        ab abVar;
        ab abVar2;
        boolean z = false;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.h.get(i2).a(this.n);
        }
        if (this.n.f11786d) {
            long j2 = Long.MIN_VALUE;
            long j3 = Long.MAX_VALUE;
            for (a.b bVar : this.n.f11788f) {
                if (bVar.k > 0) {
                    j3 = Math.min(j3, bVar.a(0));
                    j2 = Math.max(j2, bVar.a(bVar.k - 1) + bVar.b(bVar.k - 1));
                }
            }
            if (j3 == Clock.MAX_TIME) {
                abVar2 = new ab(-9223372036854775807L, false);
            } else {
                if (this.n.h != -9223372036854775807L && this.n.h > 0) {
                    j3 = Math.max(j3, j2 - this.n.h);
                }
                long j4 = j3;
                long j5 = j2 - j4;
                long b2 = j5 - z.b(this.f11834e);
                if (b2 < 5000000) {
                    b2 = Math.min(5000000, j5 / 2);
                }
                abVar = new ab(-9223372036854775807L, j5, j4, b2, true, true);
                this.i.a(abVar, this.n);
            }
        } else {
            if (this.n.f11789g != -9223372036854775807L) {
                z = true;
            }
            abVar2 = new ab(this.n.f11789g, z);
        }
        abVar = abVar2;
        this.i.a(abVar, this.n);
    }

    private void d() {
        if (this.n.f11786d) {
            this.o.postDelayed(new Runnable() {
                public void run() {
                    d.this.e();
                }
            }, Math.max(0, (this.m + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        t tVar = new t(this.j, this.f11830a, 4, this.f11836g);
        this.f11835f.a(tVar.f10827a, tVar.f10828b, this.k.a(tVar, this, this.f11833d));
    }
}
