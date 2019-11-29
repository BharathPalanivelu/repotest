package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.m;
import com.google.zxing.q;

public final class z extends x {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14635a = {1, 1, 1, 1, 1, 1};

    /* renamed from: f  reason: collision with root package name */
    private static final int[][] f14636f = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: g  reason: collision with root package name */
    private final int[] f14637g = new int[4];

    /* access modifiers changed from: protected */
    public int a(a aVar, int[] iArr, StringBuilder sb) throws q {
        int[] iArr2 = this.f14637g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a2 = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < a2) {
            int a3 = a(aVar, iArr2, i, f14631e);
            sb.append((char) ((a3 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a3 >= 10) {
                i3 = (1 << (5 - i2)) | i3;
            }
            i2++;
            i = i4;
        }
        a(sb, i3);
        return i;
    }

    /* access modifiers changed from: protected */
    public int[] a(a aVar, int i) throws q {
        return a(aVar, i, true, f14635a);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) throws m {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i) throws q {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f14636f[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw q.a();
    }

    /* access modifiers changed from: package-private */
    public c b() {
        return c.UPC_E;
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }
}
