package com.google.android.exoplayer2.r;

import com.google.android.exoplayer2.s.a;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11320a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11321b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11322c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f11323d;

    /* renamed from: e  reason: collision with root package name */
    private int f11324e;

    /* renamed from: f  reason: collision with root package name */
    private int f11325f;

    /* renamed from: g  reason: collision with root package name */
    private int f11326g;
    private a[] h;

    public j(boolean z, int i) {
        this(z, i, 0);
    }

    public j(boolean z, int i, int i2) {
        a.a(i > 0);
        a.a(i2 >= 0);
        this.f11320a = z;
        this.f11321b = i;
        this.f11326g = i2;
        this.h = new a[(i2 + 100)];
        if (i2 > 0) {
            this.f11322c = new byte[(i2 * i)];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new a(this.f11322c, i3 * i);
            }
        } else {
            this.f11322c = null;
        }
        this.f11323d = new a[1];
    }

    public synchronized void d() {
        if (this.f11320a) {
            a(0);
        }
    }

    public synchronized void a(int i) {
        boolean z = i < this.f11324e;
        this.f11324e = i;
        if (z) {
            b();
        }
    }

    public synchronized a a() {
        a aVar;
        this.f11325f++;
        if (this.f11326g > 0) {
            a[] aVarArr = this.h;
            int i = this.f11326g - 1;
            this.f11326g = i;
            aVar = aVarArr[i];
            this.h[this.f11326g] = null;
        } else {
            aVar = new a(new byte[this.f11321b], 0);
        }
        return aVar;
    }

    public synchronized void a(a aVar) {
        this.f11323d[0] = aVar;
        a(this.f11323d);
    }

    public synchronized void a(a[] aVarArr) {
        boolean z;
        if (this.f11326g + aVarArr.length >= this.h.length) {
            this.h = (a[]) Arrays.copyOf(this.h, Math.max(this.h.length * 2, this.f11326g + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            if (aVar.f11292a != this.f11322c) {
                if (aVar.f11292a.length != this.f11321b) {
                    z = false;
                    a.a(z);
                    a[] aVarArr2 = this.h;
                    int i = this.f11326g;
                    this.f11326g = i + 1;
                    aVarArr2[i] = aVar;
                }
            }
            z = true;
            a.a(z);
            a[] aVarArr22 = this.h;
            int i2 = this.f11326g;
            this.f11326g = i2 + 1;
            aVarArr22[i2] = aVar;
        }
        this.f11325f -= aVarArr.length;
        notifyAll();
    }

    public synchronized void b() {
        int i = 0;
        int max = Math.max(0, v.a(this.f11324e, this.f11321b) - this.f11325f);
        if (max < this.f11326g) {
            if (this.f11322c != null) {
                int i2 = this.f11326g - 1;
                while (i <= i2) {
                    a aVar = this.h[i];
                    if (aVar.f11292a == this.f11322c) {
                        i++;
                    } else {
                        a aVar2 = this.h[i2];
                        if (aVar2.f11292a != this.f11322c) {
                            i2--;
                        } else {
                            this.h[i] = aVar2;
                            this.h[i2] = aVar;
                            i2--;
                            i++;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.f11326g) {
                    return;
                }
            }
            Arrays.fill(this.h, max, this.f11326g, (Object) null);
            this.f11326g = max;
        }
    }

    public synchronized int e() {
        return this.f11325f * this.f11321b;
    }

    public int c() {
        return this.f11321b;
    }
}
