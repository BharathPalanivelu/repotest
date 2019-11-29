package com.google.android.exoplayer2.p;

import com.google.android.exoplayer2.g.e;

public final class i extends e implements Comparable<i> {

    /* renamed from: d  reason: collision with root package name */
    public long f11226d;

    public i() {
        super(1);
    }

    /* renamed from: a */
    public int compareTo(i iVar) {
        long j = this.f9882c - iVar.f9882c;
        if (j == 0) {
            return 0;
        }
        return j > 0 ? 1 : -1;
    }
}
