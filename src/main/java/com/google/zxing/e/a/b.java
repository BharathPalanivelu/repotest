package com.google.zxing.e.a;

import com.google.zxing.e.a.j;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f14646a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f14647b;

    private b(int i, byte[] bArr) {
        this.f14646a = i;
        this.f14647b = bArr;
    }

    static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length == jVar.c()) {
            j.b a2 = jVar.a(fVar);
            j.a[] d2 = a2.d();
            int i = 0;
            for (j.a a3 : d2) {
                i += a3.a();
            }
            b[] bVarArr = new b[i];
            int length = d2.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                j.a aVar = d2[i2];
                int i4 = i3;
                int i5 = 0;
                while (i5 < aVar.a()) {
                    int b2 = aVar.b();
                    bVarArr[i4] = new b(b2, new byte[(a2.a() + b2)]);
                    i5++;
                    i4++;
                }
                i2++;
                i3 = i4;
            }
            int length2 = bVarArr[0].f14647b.length;
            int length3 = bVarArr.length - 1;
            while (length3 >= 0 && bVarArr[length3].f14647b.length != length2) {
                length3--;
            }
            int i6 = length3 + 1;
            int a4 = length2 - a2.a();
            int i7 = 0;
            int i8 = 0;
            while (i7 < a4) {
                int i9 = i8;
                int i10 = 0;
                while (i10 < i3) {
                    bVarArr[i10].f14647b[i7] = bArr[i9];
                    i10++;
                    i9++;
                }
                i7++;
                i8 = i9;
            }
            int i11 = i6;
            while (i11 < i3) {
                bVarArr[i11].f14647b[a4] = bArr[i8];
                i11++;
                i8++;
            }
            int length4 = bVarArr[0].f14647b.length;
            while (a4 < length4) {
                int i12 = i8;
                int i13 = 0;
                while (i13 < i3) {
                    bVarArr[i13].f14647b[i13 < i6 ? a4 : a4 + 1] = bArr[i12];
                    i13++;
                    i12++;
                }
                a4++;
                i8 = i12;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f14646a;
    }

    /* access modifiers changed from: package-private */
    public byte[] b() {
        return this.f14647b;
    }
}
