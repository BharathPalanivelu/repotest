package com.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.c.a.c.b.h;
import com.c.a.c.d.e.c;
import com.c.a.d.c;
import com.c.a.d.d;
import com.c.a.d.i;
import com.c.a.d.m;
import com.c.a.d.n;
import com.c.a.d.p;
import com.c.a.g.a.e;
import com.c.a.g.g;

public class j implements i {

    /* renamed from: d  reason: collision with root package name */
    private static final g f6260d = g.a((Class<?>) Bitmap.class).b();

    /* renamed from: e  reason: collision with root package name */
    private static final g f6261e = g.a((Class<?>) c.class).b();

    /* renamed from: f  reason: collision with root package name */
    private static final g f6262f = g.a(h.f5809c).a(g.LOW).b(true);

    /* renamed from: a  reason: collision with root package name */
    protected final c f6263a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f6264b;

    /* renamed from: c  reason: collision with root package name */
    final com.c.a.d.h f6265c;

    /* renamed from: g  reason: collision with root package name */
    private final n f6266g;
    private final m h;
    private final p i;
    private final Runnable j;
    private final Handler k;
    private final com.c.a.d.c l;
    private g m;

    public j(c cVar, com.c.a.d.h hVar, m mVar, Context context) {
        this(cVar, hVar, mVar, new n(), cVar.d(), context);
    }

    j(c cVar, com.c.a.d.h hVar, m mVar, n nVar, d dVar, Context context) {
        this.i = new p();
        this.j = new Runnable() {
            public void run() {
                j.this.f6265c.a(j.this);
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        this.f6263a = cVar;
        this.f6265c = hVar;
        this.h = mVar;
        this.f6266g = nVar;
        this.f6264b = context;
        this.l = dVar.a(context.getApplicationContext(), new a(nVar));
        if (com.c.a.i.i.d()) {
            this.k.post(this.j);
        } else {
            hVar.a(this);
        }
        hVar.a(this.l);
        a(cVar.e().a());
        cVar.a(this);
    }

    /* access modifiers changed from: protected */
    public void a(g gVar) {
        this.m = gVar.clone().c();
    }

    public void a() {
        com.c.a.i.i.a();
        this.f6266g.a();
    }

    public void b() {
        com.c.a.i.i.a();
        this.f6266g.b();
    }

    public void c() {
        b();
        this.i.c();
    }

    public void d() {
        a();
        this.i.d();
    }

    public void e() {
        this.i.e();
        for (e<?> a2 : this.i.a()) {
            a(a2);
        }
        this.i.b();
        this.f6266g.c();
        this.f6265c.b(this);
        this.f6265c.b(this.l);
        this.k.removeCallbacks(this.j);
        this.f6263a.b(this);
    }

    public i<Bitmap> f() {
        return a(Bitmap.class).a(f6260d);
    }

    public <ResourceType> i<ResourceType> a(Class<ResourceType> cls) {
        return new i<>(this.f6263a, this, cls, this.f6264b);
    }

    public void a(final e<?> eVar) {
        if (eVar != null) {
            if (com.c.a.i.i.c()) {
                c(eVar);
            } else {
                this.k.post(new Runnable() {
                    public void run() {
                        j.this.a((e<?>) eVar);
                    }
                });
            }
        }
    }

    private void c(e<?> eVar) {
        if (!b(eVar)) {
            this.f6263a.a(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(e<?> eVar) {
        com.c.a.g.c a2 = eVar.a();
        if (a2 == null) {
            return true;
        }
        if (!this.f6266g.b(a2)) {
            return false;
        }
        this.i.b(eVar);
        eVar.a((com.c.a.g.c) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(e<?> eVar, com.c.a.g.c cVar) {
        this.i.a(eVar);
        this.f6266g.a(cVar);
    }

    /* access modifiers changed from: package-private */
    public g g() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public <T> k<?, T> b(Class<T> cls) {
        return this.f6263a.e().a(cls);
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.f6266g + ", treeNode=" + this.h + "}";
    }

    private static class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final n f6270a;

        public a(n nVar) {
            this.f6270a = nVar;
        }

        public void a(boolean z) {
            if (z) {
                this.f6270a.d();
            }
        }
    }
}
