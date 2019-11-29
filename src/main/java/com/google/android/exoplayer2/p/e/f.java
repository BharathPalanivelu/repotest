package com.google.android.exoplayer2.p.e;

import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.s.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f11167a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f11168b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, e> f11169c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, c> f11170d;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.f11167a = bVar;
        this.f11170d = map2;
        this.f11169c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f11168b = bVar.b();
    }

    public int a(long j) {
        int b2 = v.b(this.f11168b, j, false, false);
        if (b2 < this.f11168b.length) {
            return b2;
        }
        return -1;
    }

    public int b() {
        return this.f11168b.length;
    }

    public long a(int i) {
        return this.f11168b[i];
    }

    public List<b> b(long j) {
        return this.f11167a.a(j, this.f11169c, this.f11170d);
    }
}
