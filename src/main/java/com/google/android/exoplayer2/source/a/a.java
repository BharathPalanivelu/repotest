package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;

public abstract class a extends l {
    private b j;
    private int[] k;

    public a(f fVar, i iVar, j jVar, int i, Object obj, long j2, long j3, int i2) {
        super(fVar, iVar, jVar, i, obj, j2, j3, i2);
    }

    public void a(b bVar) {
        this.j = bVar;
        this.k = bVar.a();
    }

    public final int a(int i) {
        return this.k[i];
    }

    /* access modifiers changed from: protected */
    public final b d() {
        return this.j;
    }
}
