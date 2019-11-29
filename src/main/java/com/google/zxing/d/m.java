package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.j;
import com.google.zxing.q;
import com.google.zxing.w;
import com.google.zxing.y;
import java.util.Map;

public final class m extends q {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f14609a = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14610b = {6, 8, 10, 12, 14};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f14611d = {1, 1, 1, 1};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f14612e = {1, 1, 3};

    /* renamed from: c  reason: collision with root package name */
    private int f14613c = -1;

    public w a(int i, a aVar, Map<j, ?> map) throws com.google.zxing.m, q {
        boolean z;
        int[] a2 = a(aVar);
        int[] b2 = b(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, a2[1], b2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(j.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f14610b;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (z) {
            float f2 = (float) i;
            return new w(sb2, (byte[]) null, new y[]{new y((float) a2[1], f2), new y((float) b2[0], f2)}, c.ITF);
        }
        throw com.google.zxing.m.a();
    }

    private static void a(a aVar, int i, int i2, StringBuilder sb) throws q {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            a(aVar, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i5 : iArr) {
                i += i5;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int[] a(a aVar) throws q {
        int[] c2 = c(aVar, c(aVar), f14611d);
        this.f14613c = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        return c2;
    }

    private void a(a aVar, int i) throws q {
        int i2 = this.f14613c * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i - 1;
        while (i2 > 0 && i3 >= 0 && !aVar.a(i3)) {
            i2--;
            i3--;
        }
        if (i2 != 0) {
            throw q.a();
        }
    }

    private static int c(a aVar) throws q {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        if (c2 != a2) {
            return c2;
        }
        throw q.a();
    }

    /* access modifiers changed from: package-private */
    public int[] b(a aVar) throws q {
        aVar.d();
        try {
            int[] c2 = c(aVar, c(aVar), f14612e);
            a(aVar, c2[0]);
            int i = c2[0];
            c2[0] = aVar.a() - c2[1];
            c2[1] = aVar.a() - i;
            return c2;
        } finally {
            aVar.d();
        }
    }

    private static int[] c(a aVar, int i, int[] iArr) throws q {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int a2 = aVar.a();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < a2) {
            if (aVar.a(i) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else if (a(iArr2, iArr, 0.78f) < 0.38f) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw q.a();
    }

    private static int a(int[] iArr) throws q {
        int length = f14609a.length;
        float f2 = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float a2 = a(iArr, f14609a[i2], 0.78f);
            if (a2 < f2) {
                i = i2;
                f2 = a2;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw q.a();
    }
}
