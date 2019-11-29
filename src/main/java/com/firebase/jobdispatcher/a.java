package com.firebase.jobdispatcher;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f7184a = {2, 1, 4, 8};

    static int a(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = 0;
        for (int i2 : iArr) {
            i |= i2;
        }
        return i;
    }

    static int[] a(int i) {
        int[] iArr = f7184a;
        int length = iArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            i2 += (i & i4) == i4 ? 1 : 0;
        }
        int[] iArr2 = new int[i2];
        int i5 = 0;
        for (int i6 : f7184a) {
            if ((i & i6) == i6) {
                iArr2[i5] = i6;
                i5++;
            }
        }
        return iArr2;
    }
}
