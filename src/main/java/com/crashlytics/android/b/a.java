package com.crashlytics.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import io.a.a.a.a.b.g;
import io.a.a.a.a.b.k;
import io.a.a.a.a.b.p;
import io.a.a.a.a.e.e;
import io.a.a.a.a.f.c;
import io.a.a.a.a.g.f;
import io.a.a.a.l;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class a implements j {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f6372a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f6373b;

    /* renamed from: c  reason: collision with root package name */
    private Context f6374c;

    /* renamed from: d  reason: collision with root package name */
    private c f6375d;

    /* renamed from: e  reason: collision with root package name */
    private p f6376e;

    /* renamed from: f  reason: collision with root package name */
    private f f6377f;

    /* renamed from: g  reason: collision with root package name */
    private d f6378g;
    private c h;
    private k i;
    private e j;
    private long k;

    public a() {
        this(false);
    }

    public a(boolean z) {
        this.f6372a = new AtomicBoolean();
        this.k = 0;
        this.f6373b = new AtomicBoolean(z);
    }

    public void a(Context context, c cVar, p pVar, f fVar, d dVar, c cVar2, k kVar, e eVar) {
        this.f6374c = context;
        this.f6375d = cVar;
        this.f6376e = pVar;
        this.f6377f = fVar;
        this.f6378g = dVar;
        this.h = cVar2;
        this.i = kVar;
        this.j = eVar;
        if (b()) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        this.f6373b.set(true);
        return this.f6372a.get();
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        this.f6372a.set(true);
        return this.f6373b.get();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"CommitPrefEdits"})
    public void c() {
        synchronized (this.h) {
            if (this.h.a().contains("last_update_check")) {
                this.h.a(this.h.b().remove("last_update_check"));
            }
        }
        long a2 = this.i.a();
        long j2 = ((long) this.f6377f.f33226b) * 1000;
        l h2 = io.a.a.a.c.h();
        h2.a("Beta", "Check for updates delay: " + j2);
        l h3 = io.a.a.a.c.h();
        h3.a("Beta", "Check for updates last check time: " + d());
        long d2 = d() + j2;
        l h4 = io.a.a.a.c.h();
        h4.a("Beta", "Check for updates current time: " + a2 + ", next check time: " + d2);
        if (a2 >= d2) {
            try {
                e();
            } finally {
                a(a2);
            }
        } else {
            io.a.a.a.c.h().a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void e() {
        io.a.a.a.c.h().a("Beta", "Performing update check");
        c cVar = this.f6375d;
        new e(cVar, cVar.g(), this.f6377f.f33225a, this.j, new g()).a(new g().a(this.f6374c), this.f6376e.h().get(p.a.FONT_TOKEN), this.f6378g);
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.k = j2;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.k;
    }
}
