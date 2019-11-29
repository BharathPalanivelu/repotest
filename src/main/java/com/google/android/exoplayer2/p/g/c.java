package com.google.android.exoplayer2.p.g;

import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.s.a;
import java.util.Collections;
import java.util.List;

final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f11188a;

    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int b() {
        return 1;
    }

    public c(List<b> list) {
        this.f11188a = Collections.unmodifiableList(list);
    }

    public long a(int i) {
        a.a(i == 0);
        return 0;
    }

    public List<b> b(long j) {
        return j >= 0 ? this.f11188a : Collections.emptyList();
    }
}
