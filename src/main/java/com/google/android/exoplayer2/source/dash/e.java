package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.dash.manifest.f;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final a f11929a;

    public int a() {
        return 0;
    }

    public boolean b() {
        return true;
    }

    public e(a aVar) {
        this.f11929a = aVar;
    }

    public int a(long j) {
        return this.f11929a.f9940a;
    }

    public long a(int i) {
        return this.f11929a.f9944e[i];
    }

    public long a(int i, long j) {
        return this.f11929a.f9943d[i];
    }

    public f b(int i) {
        return new f((String) null, this.f11929a.f9942c[i], (long) this.f11929a.f9941b[i]);
    }

    public int a(long j, long j2) {
        return this.f11929a.a(j);
    }
}
