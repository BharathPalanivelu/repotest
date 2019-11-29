package com.google.android.exoplayer2.i.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.io.IOException;

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10219a = v.g("RCC\u0001");

    /* renamed from: b  reason: collision with root package name */
    private final Format f10220b;

    /* renamed from: c  reason: collision with root package name */
    private final l f10221c = new l(9);

    /* renamed from: d  reason: collision with root package name */
    private m f10222d;

    /* renamed from: e  reason: collision with root package name */
    private int f10223e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f10224f;

    /* renamed from: g  reason: collision with root package name */
    private long f10225g;
    private int h;
    private int i;

    public void c() {
    }

    public a(Format format) {
        this.f10220b = format;
    }

    public void a(g gVar) {
        gVar.a(new l.a(-9223372036854775807L));
        this.f10222d = gVar.a(0, 3);
        gVar.a();
        this.f10222d.a(this.f10220b);
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        this.f10221c.a();
        fVar.c(this.f10221c.f11422a, 0, 8);
        if (this.f10221c.n() == f10219a) {
            return true;
        }
        return false;
    }

    public int a(f fVar, k kVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f10223e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        d(fVar);
                        this.f10223e = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (c(fVar)) {
                    this.f10223e = 2;
                } else {
                    this.f10223e = 0;
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            } else {
                this.f10223e = 1;
            }
        }
    }

    public void a(long j, long j2) {
        this.f10223e = 0;
    }

    private boolean b(f fVar) throws IOException, InterruptedException {
        this.f10221c.a();
        if (!fVar.a(this.f10221c.f11422a, 0, 8, true)) {
            return false;
        }
        if (this.f10221c.n() == f10219a) {
            this.f10224f = this.f10221c.g();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private boolean c(f fVar) throws IOException, InterruptedException {
        this.f10221c.a();
        int i2 = this.f10224f;
        if (i2 == 0) {
            if (!fVar.a(this.f10221c.f11422a, 0, 5, true)) {
                return false;
            }
            this.f10225g = (this.f10221c.l() * 1000) / 45;
        } else if (i2 != 1) {
            throw new p("Unsupported version number: " + this.f10224f);
        } else if (!fVar.a(this.f10221c.f11422a, 0, 9, true)) {
            return false;
        } else {
            this.f10225g = this.f10221c.p();
        }
        this.h = this.f10221c.g();
        this.i = 0;
        return true;
    }

    private void d(f fVar) throws IOException, InterruptedException {
        while (this.h > 0) {
            this.f10221c.a();
            fVar.b(this.f10221c.f11422a, 0, 3);
            this.f10222d.a(this.f10221c, 3);
            this.i += 3;
            this.h--;
        }
        int i2 = this.i;
        if (i2 > 0) {
            this.f10222d.a(this.f10225g, 1, i2, 0, (m.a) null);
        }
    }
}
