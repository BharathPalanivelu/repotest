package com.google.zxing.e.c;

import com.google.zxing.ac;
import com.google.zxing.c.a;
import com.google.zxing.e.a.f;
import com.google.zxing.e.a.j;
import com.tencent.qcloud.core.util.IOUtils;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f14694a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f14695b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f14696c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f14697d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static int a(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    private static boolean b(int i) {
        return i == -1;
    }

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    static void a(a aVar, f fVar, j jVar, int i, b bVar) throws ac {
        a(bVar);
        a(jVar, bVar);
        a(fVar, i, bVar);
        b(jVar, bVar);
        a(aVar, i, bVar);
    }

    static void a(j jVar, b bVar) throws ac {
        d(bVar);
        c(bVar);
        c(jVar, bVar);
        b(bVar);
    }

    static void a(f fVar, int i, b bVar) throws ac {
        a aVar = new a();
        a(fVar, i, aVar);
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            boolean a2 = aVar.a((aVar.a() - 1) - i2);
            int[][] iArr = f14697d;
            bVar.a(iArr[i2][0], iArr[i2][1], a2);
            if (i2 < 8) {
                bVar.a((bVar.b() - i2) - 1, 8, a2);
            } else {
                bVar.a(8, (bVar.a() - 7) + (i2 - 8), a2);
            }
        }
    }

    static void b(j jVar, b bVar) throws ac {
        if (jVar.a() >= 7) {
            a aVar = new a();
            a(jVar, aVar);
            int i = 0;
            int i2 = 17;
            while (i < 6) {
                int i3 = i2;
                for (int i4 = 0; i4 < 3; i4++) {
                    boolean a2 = aVar.a(i3);
                    i3--;
                    bVar.a(i, (bVar.a() - 11) + i4, a2);
                    bVar.a((bVar.a() - 11) + i4, i, a2);
                }
                i++;
                i2 = i3;
            }
        }
    }

    static void a(a aVar, int i, b bVar) throws ac {
        boolean z;
        int b2 = bVar.b() - 1;
        int a2 = bVar.a() - 1;
        int i2 = 0;
        int i3 = -1;
        while (b2 > 0) {
            if (b2 == 6) {
                b2--;
            }
            while (a2 >= 0 && a2 < bVar.a()) {
                int i4 = i2;
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = b2 - i5;
                    if (b((int) bVar.a(i6, a2))) {
                        if (i4 < aVar.a()) {
                            z = aVar.a(i4);
                            i4++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && d.a(i, i6, a2)) {
                            z = !z;
                        }
                        bVar.a(i6, a2, z);
                    }
                }
                a2 += i3;
                i2 = i4;
            }
            i3 = -i3;
            a2 += i3;
            b2 -= 2;
        }
        if (i2 != aVar.a()) {
            throw new ac("Not all bits consumed: " + i2 + IOUtils.DIR_SEPARATOR_UNIX + aVar.a());
        }
    }

    static int a(int i, int i2) {
        if (i2 != 0) {
            int a2 = a(i2);
            int i3 = i << (a2 - 1);
            while (a(i3) >= a2) {
                i3 ^= i2 << (a(i3) - a2);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(f fVar, int i, a aVar) throws ac {
        if (f.b(i)) {
            int bits = (fVar.getBits() << 3) | i;
            aVar.a(bits, 5);
            aVar.a(a(bits, 1335), 10);
            a aVar2 = new a();
            aVar2.a(21522, 15);
            aVar.b(aVar2);
            if (aVar.a() != 15) {
                throw new ac("should not happen but we got: " + aVar.a());
            }
            return;
        }
        throw new ac("Invalid mask pattern");
    }

    static void a(j jVar, a aVar) throws ac {
        aVar.a(jVar.a(), 6);
        aVar.a(a(jVar.a(), 7973), 12);
        if (aVar.a() != 18) {
            throw new ac("should not happen but we got: " + aVar.a());
        }
    }

    private static void b(b bVar) {
        int i = 8;
        while (i < bVar.b() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b((int) bVar.a(i, 6))) {
                bVar.a(i, 6, i3);
            }
            if (b((int) bVar.a(6, i))) {
                bVar.a(6, i, i3);
            }
            i = i2;
        }
    }

    private static void c(b bVar) throws ac {
        if (bVar.a(8, bVar.a() - 8) != 0) {
            bVar.a(8, bVar.a() - 8, 1);
            return;
        }
        throw new ac();
    }

    private static void a(int i, int i2, b bVar) throws ac {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (b((int) bVar.a(i4, i2))) {
                bVar.a(i4, i2, 0);
                i3++;
            } else {
                throw new ac();
            }
        }
    }

    private static void b(int i, int i2, b bVar) throws ac {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (b((int) bVar.a(i, i4))) {
                bVar.a(i, i4, 0);
                i3++;
            } else {
                throw new ac();
            }
        }
    }

    private static void c(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.a(i + i4, i2 + i3, f14695b[i3][i4]);
            }
        }
    }

    private static void d(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.a(i + i4, i2 + i3, f14694a[i3][i4]);
            }
        }
    }

    private static void d(b bVar) throws ac {
        int length = f14694a[0].length;
        d(0, 0, bVar);
        d(bVar.b() - length, 0, bVar);
        d(0, bVar.b() - length, bVar);
        a(0, 7, bVar);
        a(bVar.b() - 8, 7, bVar);
        a(0, bVar.b() - 8, bVar);
        b(7, 0, bVar);
        b((bVar.a() - 7) - 1, 0, bVar);
        b(7, bVar.a() - 7, bVar);
    }

    private static void c(j jVar, b bVar) {
        if (jVar.a() >= 2) {
            int a2 = jVar.a() - 1;
            int[][] iArr = f14696c;
            int[] iArr2 = iArr[a2];
            int length = iArr[a2].length;
            for (int i = 0; i < length; i++) {
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr2[i];
                    int i4 = iArr2[i2];
                    if (!(i4 == -1 || i3 == -1 || !b((int) bVar.a(i4, i3)))) {
                        c(i4 - 2, i3 - 2, bVar);
                    }
                }
            }
        }
    }
}
