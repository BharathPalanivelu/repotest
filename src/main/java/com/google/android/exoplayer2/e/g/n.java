package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.n.a;
import java.util.Arrays;

final class n {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9692a;

    /* renamed from: b  reason: collision with root package name */
    public int f9693b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9694c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9695d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9696e;

    public n(int i, int i2) {
        this.f9694c = i;
        this.f9692a = new byte[(i2 + 3)];
        this.f9692a[2] = 1;
    }

    public void a() {
        this.f9695d = false;
        this.f9696e = false;
    }

    public boolean b() {
        return this.f9696e;
    }

    public void a(int i) {
        boolean z = true;
        a.b(!this.f9695d);
        if (i != this.f9694c) {
            z = false;
        }
        this.f9695d = z;
        if (this.f9695d) {
            this.f9693b = 3;
            this.f9696e = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f9695d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f9692a;
            int length = bArr2.length;
            int i4 = this.f9693b;
            if (length < i4 + i3) {
                this.f9692a = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f9692a, this.f9693b, i3);
            this.f9693b += i3;
        }
    }

    public boolean b(int i) {
        if (!this.f9695d) {
            return false;
        }
        this.f9693b -= i;
        this.f9695d = false;
        this.f9696e = true;
        return true;
    }
}
