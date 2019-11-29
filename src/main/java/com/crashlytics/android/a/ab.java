package com.crashlytics.android.a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.a.ad;
import com.crashlytics.android.a.l;
import io.a.a.a.a;
import io.a.a.a.a.b.n;
import io.a.a.a.a.b.p;
import io.a.a.a.a.f.b;
import io.a.a.a.c;
import io.a.a.a.i;
import java.util.concurrent.ScheduledExecutorService;

class ab implements l.a {

    /* renamed from: a  reason: collision with root package name */
    final f f6278a;

    /* renamed from: b  reason: collision with root package name */
    final a f6279b;

    /* renamed from: c  reason: collision with root package name */
    final l f6280c;

    /* renamed from: d  reason: collision with root package name */
    final i f6281d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6282e;

    public void a(String str) {
    }

    public static ab a(i iVar, Context context, p pVar, String str, String str2, long j) {
        Context context2 = context;
        p pVar2 = pVar;
        ag agVar = new ag(context, pVar, str, str2);
        g gVar = new g(context, new b(iVar));
        io.a.a.a.a.e.b bVar = new io.a.a.a.a.e.b(c.h());
        a aVar = new a(context);
        ScheduledExecutorService b2 = n.b("Answers Events Handler");
        l lVar = new l(b2);
        return new ab(new f(iVar, context, gVar, agVar, bVar, b2, new r(context)), aVar, lVar, i.a(context), j);
    }

    ab(f fVar, a aVar, l lVar, i iVar, long j) {
        this.f6278a = fVar;
        this.f6279b = aVar;
        this.f6280c = lVar;
        this.f6281d = iVar;
        this.f6282e = j;
    }

    public void b() {
        this.f6278a.b();
        this.f6279b.a(new h(this, this.f6280c));
        this.f6280c.a((l.a) this);
        if (d()) {
            a(this.f6282e);
            this.f6281d.a();
        }
    }

    public void c() {
        this.f6279b.a();
        this.f6278a.a();
    }

    public void a(m mVar) {
        io.a.a.a.l h = c.h();
        h.a("Answers", "Logged custom event: " + mVar);
        this.f6278a.a(ad.a(mVar));
    }

    public void a(String str, String str2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            c.h().a("Answers", "Logged crash");
            this.f6278a.c(ad.a(str, str2));
            return;
        }
        throw new IllegalStateException("onCrash called from main thread!!!");
    }

    public void a(long j) {
        c.h().a("Answers", "Logged install");
        this.f6278a.b(ad.a(j));
    }

    public void a(Activity activity, ad.b bVar) {
        io.a.a.a.l h = c.h();
        h.a("Answers", "Logged lifecycle event: " + bVar.name());
        this.f6278a.a(ad.a(bVar, activity));
    }

    public void a() {
        c.h().a("Answers", "Flush events when app is backgrounded");
        this.f6278a.c();
    }

    public void a(io.a.a.a.a.g.b bVar, String str) {
        this.f6280c.a(bVar.j);
        this.f6278a.a(bVar, str);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return !this.f6281d.b();
    }
}
