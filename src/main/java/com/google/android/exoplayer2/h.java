package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.q.f;
import com.google.android.exoplayer2.q.g;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private final s[] f9894a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.exoplayer2.q.h f9895b;

    /* renamed from: c  reason: collision with root package name */
    private final g f9896c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f9897d;

    /* renamed from: e  reason: collision with root package name */
    private final i f9898e;

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArraySet<r.a> f9899f;

    /* renamed from: g  reason: collision with root package name */
    private final x.b f9900g;
    private final x.a h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private x p;
    private Object q;
    private p r;
    private g s;
    private q t;
    private i.b u;
    private int v;
    private int w;
    private long x;

    @SuppressLint({"HandlerLeak"})
    public h(s[] sVarArr, com.google.android.exoplayer2.q.h hVar, n nVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.5.1" + "] [" + v.f11453e + "]");
        a.b(sVarArr.length > 0);
        this.f9894a = (s[]) a.a(sVarArr);
        this.f9895b = (com.google.android.exoplayer2.q.h) a.a(hVar);
        this.j = false;
        this.k = 0;
        this.l = 1;
        this.f9899f = new CopyOnWriteArraySet<>();
        this.f9896c = new g(new f[sVarArr.length]);
        this.p = x.f12293a;
        this.f9900g = new x.b();
        this.h = new x.a();
        this.r = p.f12117a;
        this.s = this.f9896c;
        this.t = q.f11236a;
        this.f9897d = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                h.this.a(message);
            }
        };
        this.u = new i.b(0, 0);
        this.f9898e = new i(sVarArr, hVar, nVar, this.j, this.k, this.f9897d, this.u, this);
    }

    public void a(r.a aVar) {
        this.f9899f.add(aVar);
    }

    public void b(r.a aVar) {
        this.f9899f.remove(aVar);
    }

    public int a() {
        return this.l;
    }

    public void a(com.google.android.exoplayer2.source.i iVar) {
        a(iVar, true, true);
    }

    public void a(com.google.android.exoplayer2.source.i iVar, boolean z, boolean z2) {
        if (z2) {
            if (!this.p.a() || this.q != null) {
                this.p = x.f12293a;
                this.q = null;
                Iterator<r.a> it = this.f9899f.iterator();
                while (it.hasNext()) {
                    it.next().a(this.p, this.q);
                }
            }
            if (this.i) {
                this.i = false;
                this.r = p.f12117a;
                this.s = this.f9896c;
                this.f9895b.a((Object) null);
                Iterator<r.a> it2 = this.f9899f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.r, this.s);
                }
            }
        }
        this.n++;
        this.f9898e.a(iVar, z);
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.f9898e.a(z);
            Iterator<r.a> it = this.f9899f.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.l);
            }
        }
    }

    public boolean b() {
        return this.j;
    }

    public void a(long j2) {
        a(d(), j2);
    }

    public void a(int i2, long j2) {
        if (i2 < 0 || (!this.p.a() && i2 >= this.p.b())) {
            throw new m(this.p, i2, j2);
        }
        this.m++;
        this.v = i2;
        if (this.p.a()) {
            this.w = 0;
        } else {
            this.p.a(i2, this.f9900g);
            long a2 = j2 == -9223372036854775807L ? this.f9900g.a() : b.b(j2);
            int i3 = this.f9900g.f12306f;
            long c2 = this.f9900g.c() + a2;
            long a3 = this.p.a(i3, this.h).a();
            while (a3 != -9223372036854775807L && c2 >= a3 && i3 < this.f9900g.f12307g) {
                c2 -= a3;
                i3++;
                a3 = this.p.a(i3, this.h).a();
            }
            this.w = i3;
        }
        if (j2 == -9223372036854775807L) {
            this.x = 0;
            this.f9898e.a(this.p, i2, -9223372036854775807L);
            return;
        }
        this.x = j2;
        this.f9898e.a(this.p, i2, b.b(j2));
        Iterator<r.a> it = this.f9899f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void c() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.5.1" + "] [" + v.f11453e + "] [" + k.a() + "]");
        this.f9898e.a();
        this.f9897d.removeCallbacksAndMessages((Object) null);
    }

    public void a(f.b... bVarArr) {
        this.f9898e.a(bVarArr);
    }

    public void b(f.b... bVarArr) {
        this.f9898e.b(bVarArr);
    }

    public int d() {
        if (this.p.a() || this.m > 0) {
            return this.v;
        }
        return this.p.a(this.u.f9964a.f12083b, this.h).f12296c;
    }

    public long e() {
        if (this.p.a()) {
            return -9223372036854775807L;
        }
        if (!g()) {
            return this.p.a(d(), this.f9900g).b();
        }
        i.b bVar = this.u.f9964a;
        this.p.a(bVar.f12083b, this.h);
        return b.a(this.h.b(bVar.f12084c, bVar.f12085d));
    }

    public long f() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.a(this.u.f9964a.f12083b, this.h);
        return this.h.b() + b.a(this.u.f9967d);
    }

    public boolean g() {
        return this.m == 0 && this.u.f9964a.f12084c != -1;
    }

    /* access modifiers changed from: package-private */
    public void a(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.n--;
                return;
            case 1:
                this.l = message.arg1;
                Iterator<r.a> it = this.f9899f.iterator();
                while (it.hasNext()) {
                    it.next().a(this.j, this.l);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.o = z;
                Iterator<r.a> it2 = this.f9899f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.o);
                }
                return;
            case 3:
                if (this.n == 0) {
                    com.google.android.exoplayer2.q.i iVar = (com.google.android.exoplayer2.q.i) message.obj;
                    this.i = true;
                    this.r = iVar.f11288a;
                    this.s = iVar.f11289b;
                    this.f9895b.a(iVar.f11290c);
                    Iterator<r.a> it3 = this.f9899f.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.r, this.s);
                    }
                    return;
                }
                return;
            case 4:
                int i2 = this.m - 1;
                this.m = i2;
                if (i2 == 0) {
                    this.u = (i.b) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<r.a> it4 = this.f9899f.iterator();
                        while (it4.hasNext()) {
                            it4.next().a();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.m == 0) {
                    this.u = (i.b) message.obj;
                    Iterator<r.a> it5 = this.f9899f.iterator();
                    while (it5.hasNext()) {
                        it5.next().a();
                    }
                    return;
                }
                return;
            case 6:
                i.d dVar = (i.d) message.obj;
                this.m -= dVar.f10037d;
                if (this.n == 0) {
                    this.p = dVar.f10034a;
                    this.q = dVar.f10035b;
                    this.u = dVar.f10036c;
                    Iterator<r.a> it6 = this.f9899f.iterator();
                    while (it6.hasNext()) {
                        it6.next().a(this.p, this.q);
                    }
                    return;
                }
                return;
            case 7:
                q qVar = (q) message.obj;
                if (!this.t.equals(qVar)) {
                    this.t = qVar;
                    Iterator<r.a> it7 = this.f9899f.iterator();
                    while (it7.hasNext()) {
                        it7.next().a(qVar);
                    }
                    return;
                }
                return;
            case 8:
                e eVar = (e) message.obj;
                Iterator<r.a> it8 = this.f9899f.iterator();
                while (it8.hasNext()) {
                    it8.next().a(eVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
