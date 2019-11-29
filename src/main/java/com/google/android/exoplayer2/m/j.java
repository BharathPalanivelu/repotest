package com.google.android.exoplayer2.m;

import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f10771a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10772b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f10773c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f10774d;

    /* renamed from: e  reason: collision with root package name */
    private int f10775e;

    /* renamed from: f  reason: collision with root package name */
    private int f10776f;

    /* renamed from: g  reason: collision with root package name */
    private int f10777g;
    private a[] h;

    public j(boolean z, int i) {
        this(z, i, 0);
    }

    public j(boolean z, int i, int i2) {
        a.a(i > 0);
        a.a(i2 >= 0);
        this.f10771a = z;
        this.f10772b = i;
        this.f10777g = i2;
        this.h = new a[(i2 + 100)];
        if (i2 > 0) {
            this.f10773c = new byte[(i2 * i)];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new a(this.f10773c, i3 * i);
            }
        } else {
            this.f10773c = null;
        }
        this.f10774d = new a[1];
    }

    public synchronized void d() {
        if (this.f10771a) {
            a(0);
        }
    }

    public synchronized void a(int i) {
        boolean z = i < this.f10775e;
        this.f10775e = i;
        if (z) {
            b();
        }
    }

    public synchronized a a() {
        a aVar;
        this.f10776f++;
        if (this.f10777g > 0) {
            a[] aVarArr = this.h;
            int i = this.f10777g - 1;
            this.f10777g = i;
            aVar = aVarArr[i];
            this.h[this.f10777g] = null;
        } else {
            aVar = new a(new byte[this.f10772b], 0);
        }
        return aVar;
    }

    public synchronized void a(a aVar) {
        this.f10774d[0] = aVar;
        a(this.f10774d);
    }

    public synchronized void a(a[] aVarArr) {
        boolean z;
        if (this.f10777g + aVarArr.length >= this.h.length) {
            this.h = (a[]) Arrays.copyOf(this.h, Math.max(this.h.length * 2, this.f10777g + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            if (aVar.f10743a != this.f10773c) {
                if (aVar.f10743a.length != this.f10772b) {
                    z = false;
                    a.a(z);
                    a[] aVarArr2 = this.h;
                    int i = this.f10777g;
                    this.f10777g = i + 1;
                    aVarArr2[i] = aVar;
                }
            }
            z = true;
            a.a(z);
            a[] aVarArr22 = this.h;
            int i2 = this.f10777g;
            this.f10777g = i2 + 1;
            aVarArr22[i2] = aVar;
        }
        this.f10776f -= aVarArr.length;
        notifyAll();
    }

    public synchronized void b() {
        int i = 0;
        int max = Math.max(0, t.a(this.f10775e, this.f10772b) - this.f10776f);
        if (max < this.f10777g) {
            if (this.f10773c != null) {
                int i2 = this.f10777g - 1;
                while (i <= i2) {
                    a aVar = this.h[i];
                    if (aVar.f10743a == this.f10773c) {
                        i++;
                    } else {
                        a aVar2 = this.h[i2];
                        if (aVar2.f10743a != this.f10773c) {
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
                if (max >= this.f10777g) {
                    return;
                }
            }
            Arrays.fill(this.h, max, this.f10777g, (Object) null);
            this.f10777g = max;
        }
    }

    public synchronized int e() {
        return this.f10776f * this.f10772b;
    }

    public int c() {
        return this.f10772b;
    }
}
