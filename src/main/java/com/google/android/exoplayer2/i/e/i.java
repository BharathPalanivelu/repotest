package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.s.a;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f10186a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10187b;

    /* renamed from: c  reason: collision with root package name */
    private int f10188c;

    /* renamed from: d  reason: collision with root package name */
    private int f10189d;

    public i(byte[] bArr) {
        this.f10186a = bArr;
        this.f10187b = bArr.length;
    }

    public boolean a() {
        boolean z = (((this.f10186a[this.f10188c] & 255) >> this.f10189d) & 1) == 1;
        b(1);
        return z;
    }

    public int a(int i) {
        int i2 = this.f10188c;
        int min = Math.min(i, 8 - this.f10189d);
        int i3 = i2 + 1;
        int i4 = ((this.f10186a[i2] & 255) >> this.f10189d) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.f10186a[i3] & 255) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & (-1 >>> (32 - i));
        b(i);
        return i5;
    }

    public void b(int i) {
        int i2 = i / 8;
        this.f10188c += i2;
        this.f10189d += i - (i2 * 8);
        int i3 = this.f10189d;
        if (i3 > 7) {
            this.f10188c++;
            this.f10189d = i3 - 8;
        }
        c();
    }

    public int b() {
        return (this.f10188c * 8) + this.f10189d;
    }

    private void c() {
        boolean z;
        int i = this.f10188c;
        if (i >= 0) {
            int i2 = this.f10187b;
            if (i < i2 || (i == i2 && this.f10189d == 0)) {
                z = true;
                a.b(z);
            }
        }
        z = false;
        a.b(z);
    }
}
