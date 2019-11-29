package com.google.android.exoplayer2.i.d;

import com.google.android.exoplayer2.i.f;
import java.io.IOException;

final class l {

    /* renamed from: a  reason: collision with root package name */
    public c f10130a;

    /* renamed from: b  reason: collision with root package name */
    public long f10131b;

    /* renamed from: c  reason: collision with root package name */
    public long f10132c;

    /* renamed from: d  reason: collision with root package name */
    public long f10133d;

    /* renamed from: e  reason: collision with root package name */
    public int f10134e;

    /* renamed from: f  reason: collision with root package name */
    public int f10135f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f10136g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public k o;
    public int p;
    public com.google.android.exoplayer2.s.l q;
    public boolean r;
    public long s;

    l() {
    }

    public void a() {
        this.f10134e = 0;
        this.s = 0;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public void a(int i2, int i3) {
        this.f10134e = i2;
        this.f10135f = i3;
        int[] iArr = this.h;
        if (iArr == null || iArr.length < i2) {
            this.f10136g = new long[i2];
            this.h = new int[i2];
        }
        int[] iArr2 = this.i;
        if (iArr2 == null || iArr2.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.i = new int[i4];
            this.j = new int[i4];
            this.k = new long[i4];
            this.l = new boolean[i4];
            this.n = new boolean[i4];
        }
    }

    public void a(int i2) {
        com.google.android.exoplayer2.s.l lVar = this.q;
        if (lVar == null || lVar.c() < i2) {
            this.q = new com.google.android.exoplayer2.s.l(i2);
        }
        this.p = i2;
        this.m = true;
        this.r = true;
    }

    public void a(f fVar) throws IOException, InterruptedException {
        fVar.b(this.q.f11422a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public void a(com.google.android.exoplayer2.s.l lVar) {
        lVar.a(this.q.f11422a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public long b(int i2) {
        return this.k[i2] + ((long) this.j[i2]);
    }
}
