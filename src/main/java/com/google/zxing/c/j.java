package com.google.zxing.c;

import com.google.zxing.d;
import com.google.zxing.n;
import com.google.zxing.q;
import java.lang.reflect.Array;

public final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private b f14513a;

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public j(n nVar) {
        super(nVar);
    }

    public b b() throws q {
        b bVar = this.f14513a;
        if (bVar != null) {
            return bVar;
        }
        n a2 = a();
        int b2 = a2.b();
        int c2 = a2.c();
        if (b2 < 40 || c2 < 40) {
            this.f14513a = super.b();
        } else {
            byte[] a3 = a2.a();
            int i = b2 >> 3;
            if ((b2 & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = c2 >> 3;
            if ((c2 & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] a4 = a(a3, i2, i4, b2, c2);
            b bVar2 = new b(b2, c2);
            a(a3, i2, i4, b2, c2, a4, bVar2);
            this.f14513a = bVar2;
        }
        return this.f14513a;
    }

    public d a(n nVar) {
        return new j(nVar);
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        int i5 = i;
        int i6 = i2;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 << 3;
            int i9 = i4 - 8;
            if (i8 > i9) {
                i8 = i9;
            }
            for (int i10 = 0; i10 < i5; i10++) {
                int i11 = i10 << 3;
                int i12 = i3 - 8;
                if (i11 <= i12) {
                    i12 = i11;
                }
                int a2 = a(i10, 2, i5 - 3);
                int a3 = a(i7, 2, i6 - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[a3 + i14];
                    i13 += iArr2[a2 - 2] + iArr2[a2 - 1] + iArr2[a2] + iArr2[a2 + 1] + iArr2[a2 + 2];
                }
                a(bArr, i12, i8, i13 / 25, i3, bVar);
            }
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bVar.b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i6, i5});
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 << 3;
            int i9 = i4 - 8;
            if (i8 > i9) {
                i8 = i9;
            }
            for (int i10 = 0; i10 < i5; i10++) {
                int i11 = i10 << 3;
                int i12 = i3 - 8;
                if (i11 > i12) {
                    i11 = i12;
                }
                int i13 = (i8 * i3) + i11;
                int i14 = 0;
                int i15 = 0;
                byte b2 = 0;
                byte b3 = 255;
                while (i14 < 8) {
                    int i16 = i15;
                    for (int i17 = 0; i17 < 8; i17++) {
                        byte b4 = bArr[i13 + i17] & 255;
                        i16 += b4;
                        if (b4 < b3) {
                            b3 = b4;
                        }
                        if (b4 > b2) {
                            b2 = b4;
                        }
                    }
                    if (b2 - b3 <= 24) {
                        i15 = i16;
                        i14++;
                        i13 += i3;
                    }
                    while (true) {
                        i14++;
                        i13 += i3;
                        if (i14 >= 8) {
                            break;
                        }
                        for (int i18 = 0; i18 < 8; i18++) {
                            i16 += bArr[i13 + i18] & 255;
                        }
                    }
                    i15 = i16;
                    i14++;
                    i13 += i3;
                }
                int i19 = i15 >> 6;
                if (b2 - b3 <= 24) {
                    i19 = b3 / 2;
                    if (i7 > 0 && i10 > 0) {
                        int i20 = i7 - 1;
                        int i21 = i10 - 1;
                        int i22 = ((iArr[i20][i10] + (iArr[i7][i21] * 2)) + iArr[i20][i21]) / 4;
                        if (b3 < i22) {
                            i19 = i22;
                        }
                    }
                }
                iArr[i7][i10] = i19;
            }
        }
        return iArr;
    }
}
