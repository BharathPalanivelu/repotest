package com.google.android.exoplayer2.e.g;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.b;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.k;
import java.util.Arrays;
import java.util.Collections;

public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f9611a = {73, 68, 51};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9612b;

    /* renamed from: c  reason: collision with root package name */
    private final j f9613c;

    /* renamed from: d  reason: collision with root package name */
    private final k f9614d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9615e;

    /* renamed from: f  reason: collision with root package name */
    private String f9616f;

    /* renamed from: g  reason: collision with root package name */
    private n f9617g;
    private n h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private long n;
    private int o;
    private long p;
    private n q;
    private long r;

    public void b() {
    }

    public d(boolean z) {
        this(z, (String) null);
    }

    public d(boolean z, String str) {
        this.f9613c = new j(new byte[7]);
        this.f9614d = new k(Arrays.copyOf(f9611a, 10));
        c();
        this.f9612b = z;
        this.f9615e = str;
    }

    public void a() {
        c();
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.f9616f = dVar.c();
        this.f9617g = hVar.a(dVar.b(), 1);
        if (this.f9612b) {
            dVar.a();
            this.h = hVar.a(dVar.b(), 4);
            this.h.a(com.google.android.exoplayer2.j.a(dVar.c(), "application/id3", (String) null, -1, (a) null));
            return;
        }
        this.h = new e();
    }

    public void a(long j2, boolean z) {
        this.p = j2;
    }

    public void a(k kVar) {
        while (kVar.b() > 0) {
            int i2 = this.i;
            if (i2 == 0) {
                b(kVar);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (a(kVar, this.f9613c.f10944a, this.l ? 7 : 5)) {
                        g();
                    }
                } else if (i2 == 3) {
                    c(kVar);
                }
            } else if (a(kVar, this.f9614d.f10948a, 10)) {
                f();
            }
        }
    }

    private boolean a(k kVar, byte[] bArr, int i2) {
        int min = Math.min(kVar.b(), i2 - this.j);
        kVar.a(bArr, this.j, min);
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
        this.j = f9611a.length;
        this.o = 0;
        this.f9614d.c(0);
    }

    private void a(n nVar, long j2, int i2, int i3) {
        this.i = 3;
        this.j = i2;
        this.q = nVar;
        this.r = j2;
        this.o = i3;
    }

    private void e() {
        this.i = 2;
        this.j = 0;
    }

    private void b(k kVar) {
        byte[] bArr = kVar.f10948a;
        int d2 = kVar.d();
        int c2 = kVar.c();
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
                    kVar.c(i2);
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
                kVar.c(i2);
                return;
            }
        }
        kVar.c(d2);
    }

    private void f() {
        this.h.a(this.f9614d, 10);
        this.f9614d.c(6);
        a(this.h, 0, 10, this.f9614d.s() + 10);
    }

    private void g() {
        this.f9613c.a(0);
        if (!this.m) {
            int c2 = this.f9613c.c(2) + 1;
            if (c2 != 2) {
                Log.w("AdtsReader", "Detected audio object type: " + c2 + ", but assuming AAC LC.");
                c2 = 2;
            }
            int c3 = this.f9613c.c(4);
            this.f9613c.b(1);
            byte[] a2 = b.a(c2, c3, this.f9613c.c(3));
            Pair<Integer, Integer> a3 = b.a(a2);
            com.google.android.exoplayer2.j a4 = com.google.android.exoplayer2.j.a(this.f9616f, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a3.second).intValue(), ((Integer) a3.first).intValue(), Collections.singletonList(a2), (a) null, 0, this.f9615e);
            this.n = 1024000000 / ((long) a4.s);
            this.f9617g.a(a4);
            this.m = true;
        } else {
            this.f9613c.b(10);
        }
        this.f9613c.b(4);
        int c4 = (this.f9613c.c(13) - 2) - 5;
        if (this.l) {
            c4 -= 2;
        }
        a(this.f9617g, this.n, 0, c4);
    }

    private void c(k kVar) {
        int min = Math.min(kVar.b(), this.o - this.j);
        this.q.a(kVar, min);
        this.j += min;
        int i2 = this.j;
        int i3 = this.o;
        if (i2 == i3) {
            this.q.a(this.p, 1, i3, 0, (byte[]) null);
            this.p += this.r;
            c();
        }
    }
}
