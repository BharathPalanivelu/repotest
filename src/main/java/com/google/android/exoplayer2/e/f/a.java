package com.google.android.exoplayer2.e.f;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9585a = t.g("RCC\u0001");

    /* renamed from: b  reason: collision with root package name */
    private final j f9586b;

    /* renamed from: c  reason: collision with root package name */
    private final k f9587c = new k(9);

    /* renamed from: d  reason: collision with root package name */
    private n f9588d;

    /* renamed from: e  reason: collision with root package name */
    private int f9589e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f9590f;

    /* renamed from: g  reason: collision with root package name */
    private long f9591g;
    private int h;
    private int i;

    public void c() {
    }

    public a(j jVar) {
        this.f9586b = jVar;
    }

    public void a(h hVar) {
        hVar.a(new m.a(-9223372036854775807L));
        this.f9588d = hVar.a(0, 3);
        hVar.a();
        this.f9588d.a(this.f9586b);
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        this.f9587c.a();
        gVar.c(this.f9587c.f10948a, 0, 8);
        if (this.f9587c.n() == f9585a) {
            return true;
        }
        return false;
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f9589e;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        d(gVar);
                        this.f9589e = 1;
                        return 0;
                    }
                    throw new IllegalStateException();
                } else if (c(gVar)) {
                    this.f9589e = 2;
                } else {
                    this.f9589e = 0;
                    return -1;
                }
            } else if (!b(gVar)) {
                return -1;
            } else {
                this.f9589e = 1;
            }
        }
    }

    public void a(long j, long j2) {
        this.f9589e = 0;
    }

    private boolean b(g gVar) throws IOException, InterruptedException {
        this.f9587c.a();
        if (!gVar.a(this.f9587c.f10948a, 0, 8, true)) {
            return false;
        }
        if (this.f9587c.n() == f9585a) {
            this.f9590f = this.f9587c.g();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    private boolean c(g gVar) throws IOException, InterruptedException {
        this.f9587c.a();
        int i2 = this.f9590f;
        if (i2 == 0) {
            if (!gVar.a(this.f9587c.f10948a, 0, 5, true)) {
                return false;
            }
            this.f9591g = (this.f9587c.l() * 1000) / 45;
        } else if (i2 != 1) {
            throw new ak("Unsupported version number: " + this.f9590f);
        } else if (!gVar.a(this.f9587c.f10948a, 0, 9, true)) {
            return false;
        } else {
            this.f9591g = this.f9587c.p();
        }
        this.h = this.f9587c.g();
        this.i = 0;
        return true;
    }

    private void d(g gVar) throws IOException, InterruptedException {
        while (this.h > 0) {
            this.f9587c.a();
            gVar.b(this.f9587c.f10948a, 0, 3);
            this.f9588d.a(this.f9587c, 3);
            this.i += 3;
            this.h--;
        }
        int i2 = this.i;
        if (i2 > 0) {
            this.f9588d.a(this.f9591g, 1, i2, 0, (byte[]) null);
        }
    }
}
