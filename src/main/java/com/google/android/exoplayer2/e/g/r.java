package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import com.google.android.exoplayer2.n.t;

public final class r implements v {

    /* renamed from: a  reason: collision with root package name */
    private final q f9718a;

    /* renamed from: b  reason: collision with root package name */
    private final k f9719b = new k(32);

    /* renamed from: c  reason: collision with root package name */
    private int f9720c;

    /* renamed from: d  reason: collision with root package name */
    private int f9721d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9722e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9723f;

    public r(q qVar) {
        this.f9718a = qVar;
    }

    public void a(q qVar, h hVar, v.d dVar) {
        this.f9718a.a(qVar, hVar, dVar);
        this.f9723f = true;
    }

    public void a() {
        this.f9723f = true;
    }

    public void a(k kVar, boolean z) {
        int g2 = z ? kVar.g() + kVar.d() : -1;
        if (this.f9723f) {
            if (z) {
                this.f9723f = false;
                kVar.c(g2);
                this.f9721d = 0;
            } else {
                return;
            }
        }
        while (kVar.b() > 0) {
            int i = this.f9721d;
            boolean z2 = true;
            if (i < 3) {
                if (i == 0) {
                    int g3 = kVar.g();
                    kVar.c(kVar.d() - 1);
                    if (g3 == 255) {
                        this.f9723f = true;
                        return;
                    }
                }
                int min = Math.min(kVar.b(), 3 - this.f9721d);
                kVar.a(this.f9719b.f10948a, this.f9721d, min);
                this.f9721d += min;
                if (this.f9721d == 3) {
                    this.f9719b.a(3);
                    this.f9719b.d(1);
                    int g4 = this.f9719b.g();
                    int g5 = this.f9719b.g();
                    if ((g4 & 128) == 0) {
                        z2 = false;
                    }
                    this.f9722e = z2;
                    this.f9720c = (((g4 & 15) << 8) | g5) + 3;
                    if (this.f9719b.e() < this.f9720c) {
                        byte[] bArr = this.f9719b.f10948a;
                        this.f9719b.a(Math.min(4098, Math.max(this.f9720c, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f9719b.f10948a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(kVar.b(), this.f9720c - this.f9721d);
                kVar.a(this.f9719b.f10948a, this.f9721d, min2);
                this.f9721d += min2;
                int i2 = this.f9721d;
                int i3 = this.f9720c;
                if (i2 != i3) {
                    continue;
                } else {
                    if (!this.f9722e) {
                        this.f9719b.a(i3);
                    } else if (t.a(this.f9719b.f10948a, 0, this.f9720c, -1) != 0) {
                        this.f9723f = true;
                        return;
                    } else {
                        this.f9719b.a(this.f9720c - 4);
                    }
                    this.f9718a.a(this.f9719b);
                    this.f9721d = 0;
                }
            }
        }
    }
}
