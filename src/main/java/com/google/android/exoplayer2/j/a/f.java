package com.google.android.exoplayer2.j.a;

import com.google.android.exoplayer2.j.a;
import com.google.android.exoplayer2.j.d;
import java.util.Collections;
import java.util.List;

final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f10477a;

    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public int i_() {
        return 1;
    }

    public f(List<a> list) {
        this.f10477a = list;
    }

    public long a(int i) {
        com.google.android.exoplayer2.n.a.a(i == 0);
        return 0;
    }

    public List<a> b(long j) {
        return j >= 0 ? this.f10477a : Collections.emptyList();
    }
}
