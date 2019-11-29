package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.ag;
import com.google.android.exoplayer2.ar;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.l.g;
import com.google.android.exoplayer2.l.h;
import com.google.android.exoplayer2.l.i;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;
import com.google.android.exoplayer2.source.y;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class af implements ad {

    /* renamed from: a  reason: collision with root package name */
    private final am[] f9074a;

    /* renamed from: b  reason: collision with root package name */
    private final h f9075b;

    /* renamed from: c  reason: collision with root package name */
    private final g f9076c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f9077d;

    /* renamed from: e  reason: collision with root package name */
    private final ag f9078e;

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArraySet<ad.a> f9079f;

    /* renamed from: g  reason: collision with root package name */
    private final ar.b f9080g;
    private final ar.a h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private ar o;
    private Object p;
    private com.google.android.exoplayer2.source.ad q;
    private g r;
    private al s;
    private ag.b t;
    private int u;
    private int v;
    private long w;

    @SuppressLint({"HandlerLeak"})
    public af(am[] amVarArr, h hVar, aj ajVar) {
        Log.i("ExoPlayerImpl", "Init ExoPlayerLib/2.4.1 [" + t.f10979e + "]");
        a.b(amVarArr.length > 0);
        this.f9074a = (am[]) a.a(amVarArr);
        this.f9075b = (h) a.a(hVar);
        this.j = false;
        this.k = 1;
        this.f9079f = new CopyOnWriteArraySet<>();
        this.f9076c = new g(new f[amVarArr.length]);
        this.o = ar.f9122a;
        this.f9080g = new ar.b();
        this.h = new ar.a();
        this.q = com.google.android.exoplayer2.source.ad.f11537a;
        this.r = this.f9076c;
        this.s = al.f9108a;
        this.f9077d = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                af.this.a(message);
            }
        };
        this.t = new ag.b(0, 0);
        this.f9078e = new ag(amVarArr, hVar, ajVar, this.j, this.f9077d, this.t, this);
    }

    public void a(ad.a aVar) {
        this.f9079f.add(aVar);
    }

    public void b(ad.a aVar) {
        this.f9079f.remove(aVar);
    }

    public int a() {
        return this.k;
    }

    public void a(y yVar) {
        a(yVar, true, true);
    }

    public void a(y yVar, boolean z, boolean z2) {
        if (z2) {
            if (!this.o.c() || this.p != null) {
                this.o = ar.f9122a;
                this.p = null;
                Iterator<ad.a> it = this.f9079f.iterator();
                while (it.hasNext()) {
                    it.next().onTimelineChanged(this.o, this.p);
                }
            }
            if (this.i) {
                this.i = false;
                this.q = com.google.android.exoplayer2.source.ad.f11537a;
                this.r = this.f9076c;
                this.f9075b.a((Object) null);
                Iterator<ad.a> it2 = this.f9079f.iterator();
                while (it2.hasNext()) {
                    it2.next().onTracksChanged(this.q, this.r);
                }
            }
        }
        this.m++;
        this.f9078e.a(yVar, z);
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.f9078e.a(z);
            Iterator<ad.a> it = this.f9079f.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(z, this.k);
            }
        }
    }

    public boolean b() {
        return this.j;
    }

    public void a(long j2) {
        a(h(), j2);
    }

    public void a(int i2, long j2) {
        if (i2 < 0 || (!this.o.c() && i2 >= this.o.b())) {
            throw new ai(this.o, i2, j2);
        }
        this.l++;
        this.u = i2;
        if (this.o.c()) {
            this.v = 0;
        } else {
            this.o.a(i2, this.f9080g);
            long a2 = j2 == -9223372036854775807L ? this.f9080g.a() : j2;
            int i3 = this.f9080g.f9134f;
            long c2 = this.f9080g.c() + z.b(a2);
            long b2 = this.o.a(i3, this.h).b();
            while (b2 != -9223372036854775807L && c2 >= b2 && i3 < this.f9080g.f9135g) {
                c2 -= b2;
                i3++;
                b2 = this.o.a(i3, this.h).b();
            }
            this.v = i3;
        }
        if (j2 == -9223372036854775807L) {
            this.w = 0;
            this.f9078e.a(this.o, i2, -9223372036854775807L);
            return;
        }
        this.w = j2;
        this.f9078e.a(this.o, i2, z.b(j2));
        Iterator<ad.a> it = this.f9079f.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity();
        }
    }

    public void a(al alVar) {
        if (alVar == null) {
            alVar = al.f9108a;
        }
        this.f9078e.a(alVar);
    }

    public al c() {
        return this.s;
    }

    public void d() {
        this.f9078e.a();
        this.f9077d.removeCallbacksAndMessages((Object) null);
    }

    public void a(ad.c... cVarArr) {
        this.f9078e.a(cVarArr);
    }

    public void b(ad.c... cVarArr) {
        this.f9078e.b(cVarArr);
    }

    public int h() {
        if (this.o.c() || this.l > 0) {
            return this.u;
        }
        return this.o.a(this.t.f9096a, this.h).f9125c;
    }

    public long e() {
        if (this.o.c()) {
            return -9223372036854775807L;
        }
        return this.o.a(h(), this.f9080g).b();
    }

    public long f() {
        if (this.o.c() || this.l > 0) {
            return this.w;
        }
        this.o.a(this.t.f9096a, this.h);
        return this.h.c() + z.a(this.t.f9098c);
    }

    public long i() {
        if (this.o.c() || this.l > 0) {
            return this.w;
        }
        this.o.a(this.t.f9096a, this.h);
        return this.h.c() + z.a(this.t.f9099d);
    }

    public int g() {
        if (this.o.c()) {
            return 0;
        }
        long i2 = i();
        long e2 = e();
        if (i2 == -9223372036854775807L || e2 == -9223372036854775807L) {
            return 0;
        }
        long j2 = 100;
        if (e2 != 0) {
            j2 = (i2 * 100) / e2;
        }
        return (int) j2;
    }

    /* access modifiers changed from: package-private */
    public void a(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.m--;
                return;
            case 1:
                this.k = message.arg1;
                Iterator<ad.a> it = this.f9079f.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerStateChanged(this.j, this.k);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.n = z;
                Iterator<ad.a> it2 = this.f9079f.iterator();
                while (it2.hasNext()) {
                    it2.next().onLoadingChanged(this.n);
                }
                return;
            case 3:
                if (this.m == 0) {
                    i iVar = (i) message.obj;
                    this.i = true;
                    this.q = iVar.f10739a;
                    this.r = iVar.f10740b;
                    this.f9075b.a(iVar.f10741c);
                    Iterator<ad.a> it3 = this.f9079f.iterator();
                    while (it3.hasNext()) {
                        it3.next().onTracksChanged(this.q, this.r);
                    }
                    return;
                }
                return;
            case 4:
                int i2 = this.l - 1;
                this.l = i2;
                if (i2 == 0) {
                    this.t = (ag.b) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<ad.a> it4 = this.f9079f.iterator();
                        while (it4.hasNext()) {
                            it4.next().onPositionDiscontinuity();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.l == 0) {
                    this.t = (ag.b) message.obj;
                    Iterator<ad.a> it5 = this.f9079f.iterator();
                    while (it5.hasNext()) {
                        it5.next().onPositionDiscontinuity();
                    }
                    return;
                }
                return;
            case 6:
                ag.d dVar = (ag.d) message.obj;
                this.l -= dVar.f9106d;
                if (this.m == 0) {
                    this.o = dVar.f9103a;
                    this.p = dVar.f9104b;
                    this.t = dVar.f9105c;
                    Iterator<ad.a> it6 = this.f9079f.iterator();
                    while (it6.hasNext()) {
                        it6.next().onTimelineChanged(this.o, this.p);
                    }
                    return;
                }
                return;
            case 7:
                al alVar = (al) message.obj;
                if (!this.s.equals(alVar)) {
                    this.s = alVar;
                    Iterator<ad.a> it7 = this.f9079f.iterator();
                    while (it7.hasNext()) {
                        it7.next().onPlaybackParametersChanged(alVar);
                    }
                    return;
                }
                return;
            case 8:
                ac acVar = (ac) message.obj;
                Iterator<ad.a> it8 = this.f9079f.iterator();
                while (it8.hasNext()) {
                    it8.next().onPlayerError(acVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
