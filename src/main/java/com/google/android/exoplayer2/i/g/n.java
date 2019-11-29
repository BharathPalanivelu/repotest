package com.google.android.exoplayer2.i.g;

import com.google.android.exoplayer2.s.a;
import java.util.Arrays;

final class n {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f10327a;

    /* renamed from: b  reason: collision with root package name */
    public int f10328b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10329c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10330d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10331e;

    public n(int i, int i2) {
        this.f10329c = i;
        this.f10327a = new byte[(i2 + 3)];
        this.f10327a[2] = 1;
    }

    public void a() {
        this.f10330d = false;
        this.f10331e = false;
    }

    public boolean b() {
        return this.f10331e;
    }

    public void a(int i) {
        boolean z = true;
        a.b(!this.f10330d);
        if (i != this.f10329c) {
            z = false;
        }
        this.f10330d = z;
        if (this.f10330d) {
            this.f10328b = 3;
            this.f10331e = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f10330d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f10327a;
            int length = bArr2.length;
            int i4 = this.f10328b;
            if (length < i4 + i3) {
                this.f10327a = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f10327a, this.f10328b, i3);
            this.f10328b += i3;
        }
    }

    public boolean b(int i) {
        if (!this.f10330d) {
            return false;
        }
        this.f10328b -= i;
        this.f10330d = false;
        this.f10331e = true;
        return true;
    }
}
