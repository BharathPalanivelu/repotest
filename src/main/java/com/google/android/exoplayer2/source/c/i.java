package com.google.android.exoplayer2.source.c;

import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;

final class i implements l {

    /* renamed from: a  reason: collision with root package name */
    public final int f11708a;

    /* renamed from: b  reason: collision with root package name */
    private final j f11709b;

    public i(j jVar, int i) {
        this.f11709b = jVar;
        this.f11708a = i;
    }

    public boolean c() {
        return this.f11709b.a(this.f11708a);
    }

    public void k_() throws IOException {
        this.f11709b.i();
    }

    public int a(com.google.android.exoplayer2.l lVar, e eVar, boolean z) {
        return this.f11709b.a(this.f11708a, lVar, eVar, z);
    }

    public void a(long j) {
        this.f11709b.a(this.f11708a, j);
    }
}
