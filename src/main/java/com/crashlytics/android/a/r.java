package com.crashlytics.android.a;

import android.content.Context;
import io.a.a.a.c;
import io.a.a.a.l;

class r {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6357a;

    /* renamed from: b  reason: collision with root package name */
    private final t f6358b;

    /* renamed from: c  reason: collision with root package name */
    private q f6359c;

    public r(Context context) {
        this(context, new t());
    }

    public r(Context context, t tVar) {
        this.f6357a = context;
        this.f6358b = tVar;
    }

    public q a() {
        if (this.f6359c == null) {
            this.f6359c = k.a(this.f6357a);
        }
        return this.f6359c;
    }

    public void a(ad adVar) {
        q a2 = a();
        if (a2 == null) {
            c.h().a("Answers", "Firebase analytics logging was enabled, but not available...");
            return;
        }
        s a3 = this.f6358b.a(adVar);
        if (a3 == null) {
            l h = c.h();
            h.a("Answers", "Fabric event was not mappable to Firebase event: " + adVar);
            return;
        }
        a2.a(a3.a(), a3.b());
        if ("levelEnd".equals(adVar.f6289g)) {
            a2.a("post_score", a3.b());
        }
    }
}
