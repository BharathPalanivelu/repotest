package com.google.zxing.e.c;

final class d {
    static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    static int b(b bVar) {
        byte[][] c2 = bVar.c();
        int b2 = bVar.b();
        int a2 = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a2 - 1) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < b2 - 1) {
                byte b3 = c2[i][i4];
                int i5 = i4 + 1;
                if (b3 == c2[i][i5]) {
                    int i6 = i + 1;
                    if (b3 == c2[i6][i4] && b3 == c2[i6][i5]) {
                        i3++;
                    }
                }
                i4 = i5;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    static int c(b bVar) {
        byte[][] c2 = bVar.c();
        int b2 = bVar.b();
        int a2 = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a2) {
            int i3 = i2;
            for (int i4 = 0; i4 < b2; i4++) {
                byte[] bArr = c2[i];
                int i5 = i4 + 6;
                if (i5 < b2 && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (a(bArr, i4 - 4, i4) || a(bArr, i4 + 7, i4 + 11))) {
                    i3++;
                }
                int i6 = i + 6;
                if (i6 < a2 && c2[i][i4] == 1 && c2[i + 1][i4] == 0 && c2[i + 2][i4] == 1 && c2[i + 3][i4] == 1 && c2[i + 4][i4] == 1 && c2[i + 5][i4] == 0 && c2[i6][i4] == 1 && (a(c2, i4, i - 4, i) || a(c2, i4, i + 7, i + 11))) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (i >= 0 && i < bArr.length && bArr[i] == 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2][i] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    static int d(b bVar) {
        byte[][] c2 = bVar.c();
        int b2 = bVar.b();
        int a2 = bVar.a();
        int i = 0;
        int i2 = 0;
        while (i < a2) {
            byte[] bArr = c2[i];
            int i3 = i2;
            for (int i4 = 0; i4 < b2; i4++) {
                if (bArr[i4] == 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int a3 = bVar.a() * bVar.b();
        return ((Math.abs((i2 * 2) - a3) * 10) / a3) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        r3 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r1 != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L_0x0041;
                case 1: goto L_0x0042;
                case 2: goto L_0x003e;
                case 3: goto L_0x003a;
                case 4: goto L_0x0035;
                case 5: goto L_0x002d;
                case 6: goto L_0x0024;
                case 7: goto L_0x001b;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x001b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L_0x002b
        L_0x0024:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L_0x002b:
            r1 = r1 & r0
            goto L_0x0044
        L_0x002d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x0044
        L_0x0035:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L_0x0041
        L_0x003a:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x0044
        L_0x003e:
            int r1 = r2 % 3
            goto L_0x0044
        L_0x0041:
            int r3 = r3 + r2
        L_0x0042:
            r1 = r3 & 1
        L_0x0044:
            if (r1 != 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.c.d.a(int, int, int):boolean");
    }

    private static int a(b bVar, boolean z) {
        int a2 = z ? bVar.a() : bVar.b();
        int b2 = z ? bVar.b() : bVar.a();
        byte[][] c2 = bVar.c();
        int i = 0;
        for (int i2 = 0; i2 < a2; i2++) {
            int i3 = i;
            int i4 = 0;
            byte b3 = -1;
            for (int i5 = 0; i5 < b2; i5++) {
                byte b4 = z ? c2[i2][i5] : c2[i5][i2];
                if (b4 == b3) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b3 = b4;
                }
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i = i3;
        }
        return i;
    }
}
