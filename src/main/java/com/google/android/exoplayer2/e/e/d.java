package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.k;
import java.io.IOException;
import java.util.Arrays;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final e f9528a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final k f9529b = new k(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f9530c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f9531d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9532e;

    d() {
    }

    public void a() {
        this.f9528a.a();
        this.f9529b.a();
        this.f9530c = -1;
        this.f9532e = false;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        int i;
        a.b(gVar != null);
        if (this.f9532e) {
            this.f9532e = false;
            this.f9529b.a();
        }
        while (!this.f9532e) {
            if (this.f9530c < 0) {
                if (!this.f9528a.a(gVar, true)) {
                    return false;
                }
                int i2 = this.f9528a.h;
                if ((this.f9528a.f9534b & 1) == 1 && this.f9529b.c() == 0) {
                    i2 += a(0);
                    i = this.f9531d + 0;
                } else {
                    i = 0;
                }
                gVar.b(i2);
                this.f9530c = i;
            }
            int a2 = a(this.f9530c);
            int i3 = this.f9530c + this.f9531d;
            if (a2 > 0) {
                if (this.f9529b.e() < this.f9529b.c() + a2) {
                    k kVar = this.f9529b;
                    kVar.f10948a = Arrays.copyOf(kVar.f10948a, this.f9529b.c() + a2);
                }
                gVar.b(this.f9529b.f10948a, this.f9529b.c(), a2);
                k kVar2 = this.f9529b;
                kVar2.b(kVar2.c() + a2);
                this.f9532e = this.f9528a.j[i3 + -1] != 255;
            }
            if (i3 == this.f9528a.f9539g) {
                i3 = -1;
            }
            this.f9530c = i3;
        }
        return true;
    }

    public e b() {
        return this.f9528a;
    }

    public k c() {
        return this.f9529b;
    }

    public void d() {
        if (this.f9529b.f10948a.length != 65025) {
            k kVar = this.f9529b;
            kVar.f10948a = Arrays.copyOf(kVar.f10948a, Math.max(65025, this.f9529b.c()));
        }
    }

    private int a(int i) {
        int i2 = 0;
        this.f9531d = 0;
        while (this.f9531d + i < this.f9528a.f9539g) {
            int[] iArr = this.f9528a.j;
            int i3 = this.f9531d;
            this.f9531d = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
