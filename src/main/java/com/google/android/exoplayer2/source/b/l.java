package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.i;
import com.google.android.exoplayer2.s.a;

public abstract class l extends c {
    public final int i;

    public abstract boolean g();

    public l(f fVar, i iVar, Format format, int i2, Object obj, long j, long j2, int i3) {
        super(fVar, iVar, 1, format, i2, obj, j, j2);
        a.a(format);
        this.i = i3;
    }

    public int f() {
        return this.i + 1;
    }
}
