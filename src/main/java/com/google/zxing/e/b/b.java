package com.google.zxing.e.b;

import com.google.zxing.q;
import com.google.zxing.z;
import java.util.ArrayList;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.c.b f14668a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f14669b = new ArrayList(5);

    /* renamed from: c  reason: collision with root package name */
    private final int f14670c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14671d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14672e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14673f;

    /* renamed from: g  reason: collision with root package name */
    private final float f14674g;
    private final int[] h;
    private final z i;

    b(com.google.zxing.c.b bVar, int i2, int i3, int i4, int i5, float f2, z zVar) {
        this.f14668a = bVar;
        this.f14670c = i2;
        this.f14671d = i3;
        this.f14672e = i4;
        this.f14673f = i5;
        this.f14674g = f2;
        this.h = new int[3];
        this.i = zVar;
    }

    /* access modifiers changed from: package-private */
    public a a() throws q {
        int i2 = this.f14670c;
        int i3 = this.f14673f;
        int i4 = this.f14672e + i2;
        int i5 = this.f14671d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f14668a.a(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f14668a.a(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 2) {
                    if (a(iArr)) {
                        a a2 = a(iArr, i7, i8);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                } else {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                }
                i8++;
            }
            if (a(iArr)) {
                a a3 = a(iArr, i7, i4);
                if (a3 != null) {
                    return a3;
                }
            }
        }
        if (!this.f14669b.isEmpty()) {
            return this.f14669b.get(0);
        }
        throw q.a();
    }

    private static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f2 = this.f14674g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }

    private float a(int i2, int i3, int i4, int i5) {
        com.google.zxing.c.b bVar = this.f14668a;
        int d2 = bVar.d();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bVar.a(i3, i6) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.a(i3, i6) && iArr[0] <= i4) {
            iArr[0] = iArr[0] + 1;
            i6--;
        }
        if (iArr[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < d2 && bVar.a(i3, i7) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i7++;
        }
        if (i7 == d2 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i7 < d2 && !bVar.a(i3, i7) && iArr[2] <= i4) {
            iArr[2] = iArr[2] + 1;
            i7++;
        }
        if (iArr[2] <= i4 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i5) * 5 < i5 * 2 && a(iArr)) {
            return a(iArr, i7);
        }
        return Float.NaN;
    }

    private a a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float a2 = a(iArr, i3);
        float a3 = a(i2, (int) a2, iArr[1] * 2, i4);
        if (Float.isNaN(a3)) {
            return null;
        }
        float f2 = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (a next : this.f14669b) {
            if (next.a(f2, a3, a2)) {
                return next.b(a3, a2, f2);
            }
        }
        a aVar = new a(a2, a3, f2);
        this.f14669b.add(aVar);
        z zVar = this.i;
        if (zVar == null) {
            return null;
        }
        zVar.a(aVar);
        return null;
    }
}
