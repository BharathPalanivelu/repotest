package com.bca.xco.widget.d.a.a.g;

import com.facebook.soloader.MinElf;
import java.util.Arrays;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f5029a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f5030b = new int[10];

    /* access modifiers changed from: package-private */
    public void a() {
        this.f5029a = 0;
        Arrays.fill(this.f5030b, 0);
    }

    /* access modifiers changed from: package-private */
    public m a(int i, int i2) {
        int[] iArr = this.f5030b;
        if (i >= iArr.length) {
            return this;
        }
        this.f5029a = (1 << i) | this.f5029a;
        iArr[i] = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.f5029a) != 0;
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        return this.f5030b[i];
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f5029a);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        if ((this.f5029a & 2) != 0) {
            return this.f5030b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int c(int i) {
        return (this.f5029a & 16) != 0 ? this.f5030b[4] : i;
    }

    /* access modifiers changed from: package-private */
    public int d(int i) {
        return (this.f5029a & 32) != 0 ? this.f5030b[5] : i;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return (this.f5029a & 128) != 0 ? this.f5030b[7] : MinElf.PN_XNUM;
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar) {
        for (int i = 0; i < 10; i++) {
            if (mVar.a(i)) {
                a(i, mVar.b(i));
            }
        }
    }
}
