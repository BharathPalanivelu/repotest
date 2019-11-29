package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import java.io.EOFException;
import java.io.IOException;

final class e {
    private static final int k = t.g("OggS");

    /* renamed from: a  reason: collision with root package name */
    public int f9533a;

    /* renamed from: b  reason: collision with root package name */
    public int f9534b;

    /* renamed from: c  reason: collision with root package name */
    public long f9535c;

    /* renamed from: d  reason: collision with root package name */
    public long f9536d;

    /* renamed from: e  reason: collision with root package name */
    public long f9537e;

    /* renamed from: f  reason: collision with root package name */
    public long f9538f;

    /* renamed from: g  reason: collision with root package name */
    public int f9539g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    private final k l = new k(255);

    e() {
    }

    public void a() {
        this.f9533a = 0;
        this.f9534b = 0;
        this.f9535c = 0;
        this.f9536d = 0;
        this.f9537e = 0;
        this.f9538f = 0;
        this.f9539g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean a(g gVar, boolean z) throws IOException, InterruptedException {
        this.l.a();
        a();
        if (!(gVar.d() == -1 || gVar.d() - gVar.b() >= 27) || !gVar.b(this.l.f10948a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.l.l() == ((long) k)) {
            this.f9533a = this.l.g();
            if (this.f9533a == 0) {
                this.f9534b = this.l.g();
                this.f9535c = this.l.q();
                this.f9536d = this.l.m();
                this.f9537e = this.l.m();
                this.f9538f = this.l.m();
                this.f9539g = this.l.g();
                this.h = this.f9539g + 27;
                this.l.a();
                gVar.c(this.l.f10948a, 0, this.f9539g);
                for (int i2 = 0; i2 < this.f9539g; i2++) {
                    this.j[i2] = this.l.g();
                    this.i += this.j[i2];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new ak("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new ak("expected OggS capture pattern at begin of page");
        }
    }
}
