package com.crashlytics.android.a;

import android.content.Context;
import io.a.a.a.a.b.k;
import io.a.a.a.a.d.b;
import io.a.a.a.a.d.c;
import java.io.IOException;
import java.util.UUID;

class z extends b<ad> {

    /* renamed from: g  reason: collision with root package name */
    private io.a.a.a.a.g.b f6371g;

    z(Context context, af afVar, k kVar, c cVar) throws IOException {
        super(context, afVar, kVar, cVar, 100);
    }

    /* access modifiers changed from: protected */
    public String a() {
        UUID randomUUID = UUID.randomUUID();
        return "sa" + "_" + randomUUID.toString() + "_" + this.f33152c.a() + ".tap";
    }

    /* access modifiers changed from: protected */
    public int b() {
        io.a.a.a.a.g.b bVar = this.f6371g;
        return bVar == null ? super.b() : bVar.f33205e;
    }

    /* access modifiers changed from: protected */
    public int c() {
        io.a.a.a.a.g.b bVar = this.f6371g;
        return bVar == null ? super.c() : bVar.f33203c;
    }

    /* access modifiers changed from: package-private */
    public void a(io.a.a.a.a.g.b bVar) {
        this.f6371g = bVar;
    }
}
