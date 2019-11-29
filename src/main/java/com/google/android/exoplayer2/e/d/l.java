package com.google.android.exoplayer2.e.d;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.n.k;
import java.io.IOException;

final class l {

    /* renamed from: a  reason: collision with root package name */
    public c f9498a;

    /* renamed from: b  reason: collision with root package name */
    public long f9499b;

    /* renamed from: c  reason: collision with root package name */
    public long f9500c;

    /* renamed from: d  reason: collision with root package name */
    public long f9501d;

    /* renamed from: e  reason: collision with root package name */
    public int f9502e;

    /* renamed from: f  reason: collision with root package name */
    public int f9503f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f9504g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public k o;
    public int p;
    public k q;
    public boolean r;
    public long s;

    l() {
    }

    public void a() {
        this.f9502e = 0;
        this.s = 0;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public void a(int i2, int i3) {
        this.f9502e = i2;
        this.f9503f = i3;
        int[] iArr = this.h;
        if (iArr == null || iArr.length < i2) {
            this.f9504g = new long[i2];
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
        k kVar = this.q;
        if (kVar == null || kVar.c() < i2) {
            this.q = new k(i2);
        }
        this.p = i2;
        this.m = true;
        this.r = true;
    }

    public void a(g gVar) throws IOException, InterruptedException {
        gVar.b(this.q.f10948a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public void a(k kVar) {
        kVar.a(this.q.f10948a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public long b(int i2) {
        return this.k[i2] + ((long) this.j[i2]);
    }
}
