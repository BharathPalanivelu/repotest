package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.n.a;

public abstract class l extends c {
    public final int i;

    public abstract boolean g();

    public l(f fVar, i iVar, j jVar, int i2, Object obj, long j, long j2, int i3) {
        super(fVar, iVar, 1, jVar, i2, obj, j, j2);
        a.a(jVar);
        this.i = i3;
    }

    public int f() {
        return this.i + 1;
    }
}
