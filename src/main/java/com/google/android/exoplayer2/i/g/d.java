package com.google.android.exoplayer2.i.g;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.c;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import java.util.Arrays;
import java.util.Collections;

public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f10245a = {73, 68, 51};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10246b;

    /* renamed from: c  reason: collision with root package name */
    private final k f10247c;

    /* renamed from: d  reason: collision with root package name */
    private final l f10248d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10249e;

    /* renamed from: f  reason: collision with root package name */
    private String f10250f;

    /* renamed from: g  reason: collision with root package name */
    private m f10251g;
    private m h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private long n;
    private int o;
    private long p;
    private m q;
    private long r;

    public void b() {
    }

    public d(boolean z) {
        this(z, (String) null);
    }

    public d(boolean z, String str) {
        this.f10247c = new k(new byte[7]);
        this.f10248d = new l(Arrays.copyOf(f10245a, 10));
        c();
        this.f10246b = z;
        this.f10249e = str;
    }

    public void a() {
        c();
    }

    public void a(g gVar, v.d dVar) {
        dVar.a();
        this.f10250f = dVar.c();
        this.f10251g = gVar.a(dVar.b(), 1);
        if (this.f10246b) {
            dVar.a();
            this.h = gVar.a(dVar.b(), 4);
            this.h.a(Format.a(dVar.c(), "application/id3", (String) null, -1, (DrmInitData) null));
            return;
        }
        this.h = new com.google.android.exoplayer2.i.d();
    }

    public void a(long j2, boolean z) {
        this.p = j2;
    }

    public void a(l lVar) {
        while (lVar.b() > 0) {
            int i2 = this.i;
            if (i2 == 0) {
                b(lVar);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (a(lVar, this.f10247c.f11418a, this.l ? 7 : 5)) {
                        g();
                    }
                } else if (i2 == 3) {
                    c(lVar);
                }
            } else if (a(lVar, this.f10248d.f11422a, 10)) {
                f();
            }
        }
    }

    private boolean a(l lVar, byte[] bArr, int i2) {
        int min = Math.min(lVar.b(), i2 - this.j);
        lVar.a(bArr, this.j, min);
        this.j += min;
        return this.j == i2;
    }

    private void c() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    private void d() {
        this.i = 1;
        this.j = f10245a.length;
        this.o = 0;
        this.f10248d.c(0);
    }

    private void a(m mVar, long j2, int i2, int i3) {
        this.i = 3;
        this.j = i2;
        this.q = mVar;
        this.r = j2;
        this.o = i3;
    }

    private void e() {
        this.i = 2;
        this.j = 0;
    }

    private void b(l lVar) {
        byte[] bArr = lVar.f11422a;
        int d2 = lVar.d();
        int c2 = lVar.c();
        while (d2 < c2) {
            int i2 = d2 + 1;
            byte b2 = bArr[d2] & 255;
            if (this.k != 512 || b2 < 240 || b2 == 255) {
                int i3 = this.k;
                byte b3 = b2 | i3;
                if (b3 == 329) {
                    this.k = 768;
                } else if (b3 == 511) {
                    this.k = 512;
                } else if (b3 == 836) {
                    this.k = 1024;
                } else if (b3 == 1075) {
                    d();
                    lVar.c(i2);
                    return;
                } else if (i3 != 256) {
                    this.k = 256;
                    i2--;
                }
                d2 = i2;
            } else {
                boolean z = true;
                if ((b2 & 1) != 0) {
                    z = false;
                }
                this.l = z;
                e();
                lVar.c(i2);
                return;
            }
        }
        lVar.c(d2);
    }

    private void f() {
        this.h.a(this.f10248d, 10);
        this.f10248d.c(6);
        a(this.h, 0, 10, this.f10248d.s() + 10);
    }

    private void g() {
        this.f10247c.a(0);
        if (!this.m) {
            int c2 = this.f10247c.c(2) + 1;
            if (c2 != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + c2 + ", but assuming AAC LC.");
                c2 = 2;
            }
            int c3 = this.f10247c.c(4);
            this.f10247c.b(1);
            byte[] a2 = c.a(c2, c3, this.f10247c.c(3));
            Pair<Integer, Integer> a3 = c.a(a2);
            Format a4 = Format.a(this.f10250f, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), Collections.singletonList(a2), (DrmInitData) null, 0, this.f10249e);
            this.n = 1024000000 / ((long) a4.s);
            this.f10251g.a(a4);
            this.m = true;
        } else {
            this.f10247c.b(10);
        }
        this.f10247c.b(4);
        int c4 = (this.f10247c.c(13) - 2) - 5;
        if (this.l) {
            c4 -= 2;
        }
        a(this.f10251g, this.n, 0, c4);
    }

    private void c(l lVar) {
        int min = Math.min(lVar.b(), this.o - this.j);
        this.q.a(lVar, min);
        this.j += min;
        int i2 = this.j;
        int i3 = this.o;
        if (i2 == i3) {
            this.q.a(this.p, 1, i3, 0, (m.a) null);
            this.p += this.r;
            c();
        }
    }
}
