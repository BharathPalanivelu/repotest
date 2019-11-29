package com.google.android.exoplayer2.j.e;

import com.google.android.exoplayer2.j.a;
import com.google.android.exoplayer2.j.d;
import java.util.Collections;
import java.util.List;

final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f10573a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f10574b;

    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int i_() {
        return 1;
    }

    public b(a aVar) {
        this.f10574b = Collections.singletonList(aVar);
    }

    private b() {
        this.f10574b = Collections.emptyList();
    }

    public long a(int i) {
        com.google.android.exoplayer2.n.a.a(i == 0);
        return 0;
    }

    public List<a> b(long j) {
        return j >= 0 ? this.f10574b : Collections.emptyList();
    }
}
