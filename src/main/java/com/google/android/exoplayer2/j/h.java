package com.google.android.exoplayer2.j;

import com.google.android.exoplayer2.d.e;

public final class h extends e implements Comparable<h> {

    /* renamed from: d  reason: collision with root package name */
    public long f10621d;

    public h() {
        super(1);
    }

    /* renamed from: a */
    public int compareTo(h hVar) {
        long j = this.f9281c - hVar.f9281c;
        if (j == 0) {
            return 0;
        }
        return j > 0 ? 1 : -1;
    }
}
