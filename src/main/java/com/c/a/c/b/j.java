package com.c.a.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.util.Pools;
import com.c.a.c.b.f;
import com.c.a.g.h;
import com.c.a.i.a.a;
import com.c.a.i.i;
import java.util.ArrayList;
import java.util.List;

class j<R> implements f.a<R>, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final a f5837a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f5838b = new Handler(Looper.getMainLooper(), new b());

    /* renamed from: c  reason: collision with root package name */
    private final List<h> f5839c;

    /* renamed from: d  reason: collision with root package name */
    private final com.c.a.i.a.b f5840d;

    /* renamed from: e  reason: collision with root package name */
    private final Pools.a<j<?>> f5841e;

    /* renamed from: f  reason: collision with root package name */
    private final a f5842f;

    /* renamed from: g  reason: collision with root package name */
    private final k f5843g;
    private final com.c.a.c.b.c.a h;
    private final com.c.a.c.b.c.a i;
    private final com.c.a.c.b.c.a j;
    private final com.c.a.c.b.c.a k;
    private com.c.a.c.h l;
    private boolean m;
    private boolean n;
    private boolean o;
    private s<?> p;
    private com.c.a.c.a q;
    private boolean r;
    private o s;
    private boolean t;
    private List<h> u;
    private n<?> v;
    private f<R> w;
    private volatile boolean x;

    j(com.c.a.c.b.c.a aVar, com.c.a.c.b.c.a aVar2, com.c.a.c.b.c.a aVar3, com.c.a.c.b.c.a aVar4, k kVar, Pools.a<j<?>> aVar5) {
        this(aVar, aVar2, aVar3, aVar4, kVar, aVar5, f5837a);
    }

    j(com.c.a.c.b.c.a aVar, com.c.a.c.b.c.a aVar2, com.c.a.c.b.c.a aVar3, com.c.a.c.b.c.a aVar4, k kVar, Pools.a<j<?>> aVar5, a aVar6) {
        this.f5839c = new ArrayList(2);
        this.f5840d = com.c.a.i.a.b.a();
        this.h = aVar;
        this.i = aVar2;
        this.j = aVar3;
        this.k = aVar4;
        this.f5843g = kVar;
        this.f5841e = aVar5;
        this.f5842f = aVar6;
    }

    /* access modifiers changed from: package-private */
    public j<R> a(com.c.a.c.h hVar, boolean z, boolean z2, boolean z3) {
        this.l = hVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        return this;
    }

    public void b(f<R> fVar) {
        com.c.a.c.b.c.a aVar;
        this.w = fVar;
        if (fVar.a()) {
            aVar = this.h;
        } else {
            aVar = f();
        }
        aVar.execute(fVar);
    }

    public void a(h hVar) {
        i.a();
        this.f5840d.b();
        if (this.r) {
            hVar.a(this.v, this.q);
        } else if (this.t) {
            hVar.a(this.s);
        } else {
            this.f5839c.add(hVar);
        }
    }

    public void b(h hVar) {
        i.a();
        this.f5840d.b();
        if (this.r || this.t) {
            c(hVar);
            return;
        }
        this.f5839c.remove(hVar);
        if (this.f5839c.isEmpty()) {
            a();
        }
    }

    private com.c.a.c.b.c.a f() {
        if (this.n) {
            return this.j;
        }
        return this.o ? this.k : this.i;
    }

    private void c(h hVar) {
        if (this.u == null) {
            this.u = new ArrayList(2);
        }
        if (!this.u.contains(hVar)) {
            this.u.add(hVar);
        }
    }

    private boolean d(h hVar) {
        List<h> list = this.u;
        return list != null && list.contains(hVar);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.t && !this.r && !this.x) {
            this.x = true;
            this.w.b();
            this.f5843g.a(this, this.l);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f5840d.b();
        if (this.x) {
            this.p.e();
            a(false);
        } else if (this.f5839c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (!this.r) {
            this.v = this.f5842f.a(this.p, this.m);
            this.r = true;
            this.v.f();
            this.f5843g.a(this.l, this.v);
            for (h next : this.f5839c) {
                if (!d(next)) {
                    this.v.f();
                    next.a(this.v, this.q);
                }
            }
            this.v.g();
            a(false);
        } else {
            throw new IllegalStateException("Already have resource");
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f5840d.b();
        if (this.x) {
            this.f5843g.a(this, this.l);
            a(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    private void a(boolean z) {
        i.a();
        this.f5839c.clear();
        this.l = null;
        this.v = null;
        this.p = null;
        List<h> list = this.u;
        if (list != null) {
            list.clear();
        }
        this.t = false;
        this.x = false;
        this.r = false;
        this.w.a(z);
        this.w = null;
        this.s = null;
        this.q = null;
        this.f5841e.release(this);
    }

    public void a(s<R> sVar, com.c.a.c.a aVar) {
        this.p = sVar;
        this.q = aVar;
        f5838b.obtainMessage(1, this).sendToTarget();
    }

    public void a(o oVar) {
        this.s = oVar;
        f5838b.obtainMessage(2, this).sendToTarget();
    }

    public void a(f<?> fVar) {
        f().execute(fVar);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f5840d.b();
        if (this.x) {
            a(false);
        } else if (this.f5839c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (!this.t) {
            this.t = true;
            this.f5843g.a(this.l, (n<?>) null);
            for (h next : this.f5839c) {
                if (!d(next)) {
                    next.a(this.s);
                }
            }
            a(false);
        } else {
            throw new IllegalStateException("Already failed once");
        }
    }

    public com.c.a.i.a.b f_() {
        return this.f5840d;
    }

    static class a {
        a() {
        }

        public <R> n<R> a(s<R> sVar, boolean z) {
            return new n<>(sVar, z);
        }
    }

    private static class b implements Handler.Callback {
        b() {
        }

        public boolean handleMessage(Message message) {
            j jVar = (j) message.obj;
            int i = message.what;
            if (i == 1) {
                jVar.b();
            } else if (i == 2) {
                jVar.e();
            } else if (i == 3) {
                jVar.c();
            } else {
                throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            return true;
        }
    }
}
