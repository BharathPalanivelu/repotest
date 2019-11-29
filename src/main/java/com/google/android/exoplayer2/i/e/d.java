package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.l;
import java.io.IOException;
import java.util.Arrays;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final e f10162a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final l f10163b = new l(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f10164c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f10165d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10166e;

    d() {
    }

    public void a() {
        this.f10162a.a();
        this.f10163b.a();
        this.f10164c = -1;
        this.f10166e = false;
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        int i;
        a.b(fVar != null);
        if (this.f10166e) {
            this.f10166e = false;
            this.f10163b.a();
        }
        while (!this.f10166e) {
            if (this.f10164c < 0) {
                if (!this.f10162a.a(fVar, true)) {
                    return false;
                }
                int i2 = this.f10162a.h;
                if ((this.f10162a.f10168b & 1) == 1 && this.f10163b.c() == 0) {
                    i2 += a(0);
                    i = this.f10165d + 0;
                } else {
                    i = 0;
                }
                fVar.b(i2);
                this.f10164c = i;
            }
            int a2 = a(this.f10164c);
            int i3 = this.f10164c + this.f10165d;
            if (a2 > 0) {
                if (this.f10163b.e() < this.f10163b.c() + a2) {
                    l lVar = this.f10163b;
                    lVar.f11422a = Arrays.copyOf(lVar.f11422a, this.f10163b.c() + a2);
                }
                fVar.b(this.f10163b.f11422a, this.f10163b.c(), a2);
                l lVar2 = this.f10163b;
                lVar2.b(lVar2.c() + a2);
                this.f10166e = this.f10162a.j[i3 + -1] != 255;
            }
            if (i3 == this.f10162a.f10173g) {
                i3 = -1;
            }
            this.f10164c = i3;
        }
        return true;
    }

    public e b() {
        return this.f10162a;
    }

    public l c() {
        return this.f10163b;
    }

    public void d() {
        if (this.f10163b.f11422a.length != 65025) {
            l lVar = this.f10163b;
            lVar.f11422a = Arrays.copyOf(lVar.f11422a, Math.max(65025, this.f10163b.c()));
        }
    }

    private int a(int i) {
        int i2 = 0;
        this.f10165d = 0;
        while (this.f10165d + i < this.f10162a.f10173g) {
            int[] iArr = this.f10162a.j;
            int i3 = this.f10165d;
            this.f10165d = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
