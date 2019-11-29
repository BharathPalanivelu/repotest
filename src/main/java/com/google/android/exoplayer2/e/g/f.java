package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.a.g;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.path.android.jobqueue.JobManager;

public final class f implements h {

    /* renamed from: a  reason: collision with root package name */
    private final k f9620a = new k(new byte[15]);

    /* renamed from: b  reason: collision with root package name */
    private final String f9621b;

    /* renamed from: c  reason: collision with root package name */
    private String f9622c;

    /* renamed from: d  reason: collision with root package name */
    private n f9623d;

    /* renamed from: e  reason: collision with root package name */
    private int f9624e;

    /* renamed from: f  reason: collision with root package name */
    private int f9625f;

    /* renamed from: g  reason: collision with root package name */
    private int f9626g;
    private long h;
    private j i;
    private int j;
    private long k;

    public void b() {
    }

    public f(String str) {
        this.f9620a.f10948a[0] = Byte.MAX_VALUE;
        this.f9620a.f10948a[1] = -2;
        this.f9620a.f10948a[2] = Byte.MIN_VALUE;
        this.f9620a.f10948a[3] = 1;
        this.f9624e = 0;
        this.f9621b = str;
    }

    public void a() {
        this.f9624e = 0;
        this.f9625f = 0;
        this.f9626g = 0;
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9622c = dVar.c();
        this.f9623d = hVar.a(dVar.b(), 1);
    }

    public void a(long j2, boolean z) {
        this.k = j2;
    }

    public void a(k kVar) {
        while (kVar.b() > 0) {
            int i2 = this.f9624e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(kVar.b(), this.j - this.f9625f);
                        this.f9623d.a(kVar, min);
                        this.f9625f += min;
                        int i3 = this.f9625f;
                        int i4 = this.j;
                        if (i3 == i4) {
                            this.f9623d.a(this.k, 1, i4, 0, (byte[]) null);
                            this.k += this.h;
                            this.f9624e = 0;
                        }
                    }
                } else if (a(kVar, this.f9620a.f10948a, 15)) {
                    c();
                    this.f9620a.c(0);
                    this.f9623d.a(this.f9620a, 15);
                    this.f9624e = 2;
                }
            } else if (b(kVar)) {
                this.f9625f = 4;
                this.f9624e = 1;
            }
        }
    }

    private boolean a(k kVar, byte[] bArr, int i2) {
        int min = Math.min(kVar.b(), i2 - this.f9625f);
        kVar.a(bArr, this.f9625f, min);
        this.f9625f += min;
        return this.f9625f == i2;
    }

    private boolean b(k kVar) {
        while (kVar.b() > 0) {
            this.f9626g <<= 8;
            this.f9626g |= kVar.g();
            if (this.f9626g == 2147385345) {
                this.f9626g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArr = this.f9620a.f10948a;
        if (this.i == null) {
            this.i = g.a(bArr, this.f9622c, this.f9621b, (a) null);
            this.f9623d.a(this.i);
        }
        this.j = g.b(bArr);
        this.h = (long) ((int) ((((long) g.a(bArr)) * JobManager.NS_PER_MS) / ((long) this.i.s)));
    }
}
