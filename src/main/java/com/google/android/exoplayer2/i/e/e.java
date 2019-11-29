package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import java.io.EOFException;
import java.io.IOException;

final class e {
    private static final int k = v.g("OggS");

    /* renamed from: a  reason: collision with root package name */
    public int f10167a;

    /* renamed from: b  reason: collision with root package name */
    public int f10168b;

    /* renamed from: c  reason: collision with root package name */
    public long f10169c;

    /* renamed from: d  reason: collision with root package name */
    public long f10170d;

    /* renamed from: e  reason: collision with root package name */
    public long f10171e;

    /* renamed from: f  reason: collision with root package name */
    public long f10172f;

    /* renamed from: g  reason: collision with root package name */
    public int f10173g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    private final l l = new l(255);

    e() {
    }

    public void a() {
        this.f10167a = 0;
        this.f10168b = 0;
        this.f10169c = 0;
        this.f10170d = 0;
        this.f10171e = 0;
        this.f10172f = 0;
        this.f10173g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        this.l.a();
        a();
        if (!(fVar.d() == -1 || fVar.d() - fVar.b() >= 27) || !fVar.b(this.l.f11422a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        } else if (this.l.l() == ((long) k)) {
            this.f10167a = this.l.g();
            if (this.f10167a == 0) {
                this.f10168b = this.l.g();
                this.f10169c = this.l.q();
                this.f10170d = this.l.m();
                this.f10171e = this.l.m();
                this.f10172f = this.l.m();
                this.f10173g = this.l.g();
                this.h = this.f10173g + 27;
                this.l.a();
                fVar.c(this.l.f11422a, 0, this.f10173g);
                for (int i2 = 0; i2 < this.f10173g; i2++) {
                    this.j[i2] = this.l.g();
                    this.i += this.j[i2];
                }
                return true;
            } else if (z) {
                return false;
            } else {
                throw new p("unsupported bit stream revision");
            }
        } else if (z) {
            return false;
        } else {
            throw new p("expected OggS capture pattern at begin of page");
        }
    }
}
