package com.google.zxing.d;

import com.google.zxing.c.a;
import com.google.zxing.q;
import com.google.zxing.v;

final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14625a = {1, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    private final u f14626b = new u();

    /* renamed from: c  reason: collision with root package name */
    private final v f14627c = new v();

    w() {
    }

    /* access modifiers changed from: package-private */
    public com.google.zxing.w a(int i, a aVar, int i2) throws q {
        int[] a2 = x.a(aVar, i2, false, f14625a);
        try {
            return this.f14627c.a(i, aVar, a2);
        } catch (v unused) {
            return this.f14626b.a(i, aVar, a2);
        }
    }
}
