package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.e.a;
import com.google.android.exoplayer2.source.dash.a.e;

public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final a f11973a;

    public int e() {
        return 0;
    }

    public boolean f() {
        return true;
    }

    public k(a aVar) {
        this.f11973a = aVar;
    }

    public int a(long j) {
        return this.f11973a.f9304a;
    }

    public long b(int i) {
        return this.f11973a.f9308e[i];
    }

    public long a(int i, long j) {
        return this.f11973a.f9307d[i];
    }

    public e a(int i) {
        return new e((String) null, this.f11973a.f9306c[i], (long) this.f11973a.f9305b[i]);
    }

    public int a(long j, long j2) {
        return this.f11973a.a(j);
    }
}
