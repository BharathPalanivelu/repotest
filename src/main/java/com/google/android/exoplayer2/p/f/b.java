package com.google.android.exoplayer2.p.f;

import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.s.a;
import java.util.Collections;
import java.util.List;

final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final b f11178a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final List<com.google.android.exoplayer2.p.b> f11179b;

    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int b() {
        return 1;
    }

    public b(com.google.android.exoplayer2.p.b bVar) {
        this.f11179b = Collections.singletonList(bVar);
    }

    private b() {
        this.f11179b = Collections.emptyList();
    }

    public long a(int i) {
        a.a(i == 0);
        return 0;
    }

    public List<com.google.android.exoplayer2.p.b> b(long j) {
        return j >= 0 ? this.f11179b : Collections.emptyList();
    }
}
