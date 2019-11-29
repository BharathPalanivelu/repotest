package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;

public final class r implements v {

    /* renamed from: a  reason: collision with root package name */
    private final q f10353a;

    /* renamed from: b  reason: collision with root package name */
    private final l f10354b = new l(32);

    /* renamed from: c  reason: collision with root package name */
    private int f10355c;

    /* renamed from: d  reason: collision with root package name */
    private int f10356d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10357e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10358f;

    public r(q qVar) {
        this.f10353a = qVar;
    }

    public void a(s sVar, g gVar, v.d dVar) {
        this.f10353a.a(sVar, gVar, dVar);
        this.f10358f = true;
    }

    public void a() {
        this.f10358f = true;
    }

    public void a(l lVar, boolean z) {
        int g2 = z ? lVar.g() + lVar.d() : -1;
        if (this.f10358f) {
            if (z) {
                this.f10358f = false;
                lVar.c(g2);
                this.f10356d = 0;
            } else {
                return;
            }
        }
        while (lVar.b() > 0) {
            int i = this.f10356d;
            boolean z2 = true;
            if (i < 3) {
                if (i == 0) {
                    int g3 = lVar.g();
                    lVar.c(lVar.d() - 1);
                    if (g3 == 255) {
                        this.f10358f = true;
                        return;
                    }
                }
                int min = Math.min(lVar.b(), 3 - this.f10356d);
                lVar.a(this.f10354b.f11422a, this.f10356d, min);
                this.f10356d += min;
                if (this.f10356d == 3) {
                    this.f10354b.a(3);
                    this.f10354b.d(1);
                    int g4 = this.f10354b.g();
                    int g5 = this.f10354b.g();
                    if ((g4 & 128) == 0) {
                        z2 = false;
                    }
                    this.f10357e = z2;
                    this.f10355c = (((g4 & 15) << 8) | g5) + 3;
                    if (this.f10354b.e() < this.f10355c) {
                        byte[] bArr = this.f10354b.f11422a;
                        this.f10354b.a(Math.min(4098, Math.max(this.f10355c, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f10354b.f11422a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(lVar.b(), this.f10355c - this.f10356d);
                lVar.a(this.f10354b.f11422a, this.f10356d, min2);
                this.f10356d += min2;
                int i2 = this.f10356d;
                int i3 = this.f10355c;
                if (i2 != i3) {
                    continue;
                } else {
                    if (!this.f10357e) {
                        this.f10354b.a(i3);
                    } else if (com.google.android.exoplayer2.s.v.a(this.f10354b.f11422a, 0, this.f10355c, -1) != 0) {
                        this.f10358f = true;
                        return;
                    } else {
                        this.f10354b.a(this.f10355c - 4);
                    }
                    this.f10353a.a(this.f10354b);
                    this.f10356d = 0;
                }
            }
        }
    }
}
