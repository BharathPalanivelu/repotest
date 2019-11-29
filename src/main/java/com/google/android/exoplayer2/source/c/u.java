package com.google.android.exoplayer2.source.c;

import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;

final class u implements z {

    /* renamed from: a  reason: collision with root package name */
    public final int f11757a;

    /* renamed from: b  reason: collision with root package name */
    private final v f11758b;

    public u(v vVar, int i) {
        this.f11758b = vVar;
        this.f11757a = i;
    }

    public boolean d() {
        return this.f11758b.a(this.f11757a);
    }

    public void e() throws IOException {
        this.f11758b.h();
    }

    public int a(ah ahVar, e eVar, boolean z) {
        return this.f11758b.a(this.f11757a, ahVar, eVar, z);
    }

    public void c(long j) {
        this.f11758b.a(this.f11757a, j);
    }
}
