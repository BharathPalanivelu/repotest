package com.google.android.exoplayer2.j.d;

import com.google.android.exoplayer2.j.a;
import com.google.android.exoplayer2.j.d;
import com.google.android.exoplayer2.n.t;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f10562a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f10563b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, e> f10564c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, c> f10565d;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        this.f10562a = bVar;
        this.f10565d = map2;
        this.f10564c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f10563b = bVar.b();
    }

    public int a(long j) {
        int b2 = t.b(this.f10563b, j, false, false);
        if (b2 < this.f10563b.length) {
            return b2;
        }
        return -1;
    }

    public int i_() {
        return this.f10563b.length;
    }

    public long a(int i) {
        return this.f10563b[i];
    }

    public List<a> b(long j) {
        return this.f10562a.a(j, this.f10564c, this.f10565d);
    }
}
