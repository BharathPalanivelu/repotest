package com.garena.f.a;

import com.garena.f.f;
import com.garena.f.h;
import com.garena.f.i;
import com.garena.f.j;
import com.garena.h.a.d;
import com.garena.h.c;
import com.garena.h.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class b extends d implements h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f7936a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public i f7937b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f7938c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f7939d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List<com.garena.f.c> f7940e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final List<f> f7941f;

    /* renamed from: g  reason: collision with root package name */
    private a<j> f7942g;
    private f h;
    private boolean i = false;

    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public b(c cVar, i iVar, c cVar2, ScheduledExecutorService scheduledExecutorService, List<com.garena.f.c> list) {
        this.f7936a = cVar;
        this.f7937b = iVar;
        this.f7938c = cVar2;
        this.f7939d = scheduledExecutorService;
        this.f7940e = list;
        this.f7941f = new ArrayList();
    }

    public void a(f fVar) {
        this.h = fVar;
        c();
    }

    private void c() {
        this.f7939d.execute(new Runnable() {
            public void run() {
                f fVar = new f(b.this.f7937b);
                for (int i = 0; i < b.this.f7940e.size(); i++) {
                    fVar = ((com.garena.f.c) b.this.f7940e.get(i)).a(fVar);
                    b.this.f7941f.add(fVar);
                    i unused = b.this.f7937b = fVar.a();
                }
                b.this.f7938c.a(b.this.f7937b.a(), b.this);
                ScheduledExecutorService e2 = b.this.f7939d;
                b bVar = b.this;
                e2.schedule(bVar, (long) bVar.f7937b.c(), TimeUnit.MILLISECONDS);
                b.this.f7936a.c(b.this.f7937b.b());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar) {
        a(dVar, this.f7937b.b());
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        a(d.NONE, eVar);
    }

    public void a() {
        a(d.TIMEOUT, this.f7937b.b());
    }

    private synchronized void a(d dVar, e eVar) {
        if (!this.i) {
            this.f7938c.c(eVar.a());
            b();
            j jVar = new j(eVar, dVar);
            g gVar = new g(jVar);
            for (int size = this.f7940e.size() - 1; size >= 0; size--) {
                gVar.a(this.f7941f.get(size));
                gVar = this.f7940e.get(size).a(gVar);
                jVar = gVar.a();
            }
            if (jVar.a() == d.NONE) {
                if (this.f7942g != null) {
                    this.f7942g.a(jVar);
                }
                if (this.h != null) {
                    this.h.b(this.f7937b, jVar);
                }
            } else {
                if (this.f7942g != null) {
                    this.f7942g.a(jVar);
                }
                if (this.h != null) {
                    this.h.a(this.f7937b, jVar);
                }
            }
            this.i = true;
        }
    }
}
