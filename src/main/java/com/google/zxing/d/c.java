package com.google.zxing.d;

import com.google.zxing.c.a;
import com.google.zxing.q;

public final class c extends q {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f14591a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int[] a(a aVar) throws q {
        int a2 = aVar.a();
        int c2 = aVar.c(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i = c2;
        boolean z = false;
        int i2 = 0;
        while (c2 < a2) {
            if (aVar.a(c2) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 == i3) {
                    float f2 = 0.25f;
                    int i4 = -1;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float a3 = a(iArr, f14591a[i5], 0.7f);
                        if (a3 < f2) {
                            i4 = i5;
                            f2 = a3;
                        }
                    }
                    if (i4 < 0 || !aVar.a(Math.max(0, i - ((c2 - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        int i6 = length - 2;
                        System.arraycopy(iArr, 2, iArr, 0, i6);
                        iArr[i6] = 0;
                        iArr[i3] = 0;
                        i2--;
                    } else {
                        return new int[]{i, c2, i4};
                    }
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            c2++;
        }
        throw q.a();
    }

    private static int a(a aVar, int[] iArr, int i) throws q {
        a(aVar, i, iArr);
        float f2 = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = f14591a;
            if (i3 >= iArr2.length) {
                break;
            }
            float a2 = a(iArr, iArr2[i3], 0.7f);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw q.a();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x019c, code lost:
        r11 = r3;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x019e, code lost:
        if (r14 == false) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01a2, code lost:
        if (r9 != 'e') goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01a4, code lost:
        r9 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01a7, code lost:
        r9 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01ac, code lost:
        r14 = r3;
        r12 = r8;
        r3 = r11;
        r8 = r21;
        r23 = r16;
        r16 = r2;
        r2 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ef, code lost:
        r10 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f3, code lost:
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010d, code lost:
        r3 = false;
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013b, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0145, code lost:
        r10 = r9;
        r3 = false;
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0149, code lost:
        r9 = r3;
        r3 = false;
        r10 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0150, code lost:
        r10 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0153, code lost:
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0154, code lost:
        r9 = r3;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x015a, code lost:
        r11 = r9;
        r9 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.w a(int r25, com.google.zxing.c.a r26, java.util.Map<com.google.zxing.j, ?> r27) throws com.google.zxing.q, com.google.zxing.m, com.google.zxing.g {
        /*
            r24 = this;
            r0 = r26
            r1 = r27
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.zxing.j r4 = com.google.zxing.j.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int[] r4 = a(r26)
            r5 = 2
            r6 = r4[r5]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r6
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            switch(r6) {
                case 103: goto L_0x0037;
                case 104: goto L_0x0034;
                case 105: goto L_0x0031;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.zxing.m r0 = com.google.zxing.m.a()
            throw r0
        L_0x0031:
            r12 = 99
            goto L_0x0039
        L_0x0034:
            r12 = 100
            goto L_0x0039
        L_0x0037:
            r12 = 101(0x65, float:1.42E-43)
        L_0x0039:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            r8 = r4[r3]
            r14 = r4[r2]
            r15 = 6
            int[] r15 = new int[r15]
            r17 = r6
            r9 = r12
            r2 = 0
            r5 = 0
            r6 = 0
            r16 = 0
            r18 = 0
            r19 = 1
            r12 = r8
            r8 = r14
            r14 = 0
        L_0x0054:
            if (r6 != 0) goto L_0x01b9
            int r2 = a((com.google.zxing.c.a) r0, (int[]) r15, (int) r8)
            byte r12 = (byte) r2
            java.lang.Byte r12 = java.lang.Byte.valueOf(r12)
            r7.add(r12)
            r12 = 106(0x6a, float:1.49E-43)
            if (r2 == r12) goto L_0x0068
            r19 = 1
        L_0x0068:
            if (r2 == r12) goto L_0x0070
            int r18 = r18 + 1
            int r20 = r18 * r2
            int r17 = r17 + r20
        L_0x0070:
            int r11 = r15.length
            r21 = r8
            r10 = 0
        L_0x0074:
            if (r10 >= r11) goto L_0x007d
            r22 = r15[r10]
            int r21 = r21 + r22
            int r10 = r10 + 1
            goto L_0x0074
        L_0x007d:
            switch(r2) {
                case 103: goto L_0x008b;
                case 104: goto L_0x008b;
                case 105: goto L_0x008b;
                default: goto L_0x0080;
            }
        L_0x0080:
            r10 = 96
            java.lang.String r11 = "]C1"
            switch(r9) {
                case 99: goto L_0x015f;
                case 100: goto L_0x00fa;
                case 101: goto L_0x0090;
                default: goto L_0x0087;
            }
        L_0x0087:
            r10 = 100
            goto L_0x019c
        L_0x008b:
            com.google.zxing.m r0 = com.google.zxing.m.a()
            throw r0
        L_0x0090:
            r12 = 64
            if (r2 >= r12) goto L_0x00a8
            if (r3 != r5) goto L_0x009e
            int r3 = r2 + 32
            char r3 = (char) r3
            r13.append(r3)
            goto L_0x010d
        L_0x009e:
            int r3 = r2 + 32
            int r3 = r3 + 128
            char r3 = (char) r3
            r13.append(r3)
            goto L_0x010d
        L_0x00a8:
            if (r2 >= r10) goto L_0x00bb
            if (r3 != r5) goto L_0x00b4
            int r3 = r2 + -64
            char r3 = (char) r3
            r13.append(r3)
            goto L_0x010d
        L_0x00b4:
            int r3 = r2 + 64
            char r3 = (char) r3
            r13.append(r3)
            goto L_0x010d
        L_0x00bb:
            r10 = 106(0x6a, float:1.49E-43)
            if (r2 == r10) goto L_0x00c1
            r19 = 0
        L_0x00c1:
            if (r2 == r10) goto L_0x00f6
            switch(r2) {
                case 96: goto L_0x00f3;
                case 97: goto L_0x00f3;
                case 98: goto L_0x00ed;
                case 99: goto L_0x0149;
                case 100: goto L_0x00ea;
                case 101: goto L_0x00d9;
                case 102: goto L_0x00c7;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            goto L_0x00f3
        L_0x00c7:
            if (r1 == 0) goto L_0x00f3
            int r10 = r13.length()
            if (r10 != 0) goto L_0x00d3
            r13.append(r11)
            goto L_0x00f3
        L_0x00d3:
            r10 = 29
            r13.append(r10)
            goto L_0x00f3
        L_0x00d9:
            if (r5 != 0) goto L_0x00e2
            if (r3 == 0) goto L_0x00e2
            r10 = r9
            r3 = 0
            r5 = 1
            goto L_0x013b
        L_0x00e2:
            if (r5 == 0) goto L_0x0145
            if (r3 == 0) goto L_0x0145
            r10 = r9
            r3 = 0
            r5 = 0
            goto L_0x013b
        L_0x00ea:
            r9 = r3
            r3 = 0
            goto L_0x00ef
        L_0x00ed:
            r9 = r3
            r3 = 1
        L_0x00ef:
            r10 = 100
            goto L_0x015a
        L_0x00f3:
            r10 = r9
            goto L_0x0154
        L_0x00f6:
            r10 = r9
            r6 = 1
            goto L_0x0154
        L_0x00fa:
            if (r2 >= r10) goto L_0x0113
            if (r3 != r5) goto L_0x0105
            int r3 = r2 + 32
            char r3 = (char) r3
            r13.append(r3)
            goto L_0x010d
        L_0x0105:
            int r3 = r2 + 32
            int r3 = r3 + 128
            char r3 = (char) r3
            r13.append(r3)
        L_0x010d:
            r3 = 0
            r10 = 100
            r11 = 0
            goto L_0x019e
        L_0x0113:
            r10 = 106(0x6a, float:1.49E-43)
            if (r2 == r10) goto L_0x0119
            r19 = 0
        L_0x0119:
            if (r2 == r10) goto L_0x0157
            switch(r2) {
                case 96: goto L_0x0153;
                case 97: goto L_0x0153;
                case 98: goto L_0x014e;
                case 99: goto L_0x0149;
                case 100: goto L_0x0134;
                case 101: goto L_0x0131;
                case 102: goto L_0x011f;
                default: goto L_0x011e;
            }
        L_0x011e:
            goto L_0x0153
        L_0x011f:
            if (r1 == 0) goto L_0x0153
            int r10 = r13.length()
            if (r10 != 0) goto L_0x012b
            r13.append(r11)
            goto L_0x0153
        L_0x012b:
            r10 = 29
            r13.append(r10)
            goto L_0x0153
        L_0x0131:
            r9 = r3
            r3 = 0
            goto L_0x0150
        L_0x0134:
            if (r5 != 0) goto L_0x013d
            if (r3 == 0) goto L_0x013d
            r10 = r9
            r3 = 0
            r5 = 1
        L_0x013b:
            r9 = 0
            goto L_0x015a
        L_0x013d:
            if (r5 == 0) goto L_0x0145
            if (r3 == 0) goto L_0x0145
            r10 = r9
            r3 = 0
            r5 = 0
            goto L_0x013b
        L_0x0145:
            r10 = r9
            r3 = 0
            r9 = 1
            goto L_0x015a
        L_0x0149:
            r9 = r3
            r3 = 0
            r10 = 99
            goto L_0x015a
        L_0x014e:
            r9 = r3
            r3 = 1
        L_0x0150:
            r10 = 101(0x65, float:1.42E-43)
            goto L_0x015a
        L_0x0153:
            r10 = r9
        L_0x0154:
            r9 = r3
            r3 = 0
            goto L_0x015a
        L_0x0157:
            r10 = r9
            r6 = 1
            goto L_0x0154
        L_0x015a:
            r11 = r9
            r9 = r10
            r10 = 100
            goto L_0x019e
        L_0x015f:
            r10 = 100
            if (r2 >= r10) goto L_0x0170
            r11 = 10
            if (r2 >= r11) goto L_0x016c
            r11 = 48
            r13.append(r11)
        L_0x016c:
            r13.append(r2)
            goto L_0x019c
        L_0x0170:
            r12 = 106(0x6a, float:1.49E-43)
            if (r2 == r12) goto L_0x0176
            r19 = 0
        L_0x0176:
            if (r2 == r12) goto L_0x0198
            switch(r2) {
                case 100: goto L_0x0193;
                case 101: goto L_0x018e;
                case 102: goto L_0x017c;
                default: goto L_0x017b;
            }
        L_0x017b:
            goto L_0x019c
        L_0x017c:
            if (r1 == 0) goto L_0x019c
            int r12 = r13.length()
            if (r12 != 0) goto L_0x0188
            r13.append(r11)
            goto L_0x019c
        L_0x0188:
            r11 = 29
            r13.append(r11)
            goto L_0x019c
        L_0x018e:
            r11 = r3
            r3 = 0
            r9 = 101(0x65, float:1.42E-43)
            goto L_0x019e
        L_0x0193:
            r11 = r3
            r3 = 0
            r9 = 100
            goto L_0x019e
        L_0x0198:
            r11 = r3
            r3 = 0
            r6 = 1
            goto L_0x019e
        L_0x019c:
            r11 = r3
            r3 = 0
        L_0x019e:
            if (r14 == 0) goto L_0x01aa
            r14 = 101(0x65, float:1.42E-43)
            if (r9 != r14) goto L_0x01a7
            r9 = 100
            goto L_0x01ac
        L_0x01a7:
            r9 = 101(0x65, float:1.42E-43)
            goto L_0x01ac
        L_0x01aa:
            r14 = 101(0x65, float:1.42E-43)
        L_0x01ac:
            r14 = r3
            r12 = r8
            r3 = r11
            r8 = r21
            r23 = r16
            r16 = r2
            r2 = r23
            goto L_0x0054
        L_0x01b9:
            int r1 = r8 - r12
            int r3 = r0.d(r8)
            int r5 = r26.a()
            int r6 = r3 - r12
            r8 = 2
            int r6 = r6 / r8
            int r6 = r6 + r3
            int r5 = java.lang.Math.min(r5, r6)
            r6 = 0
            boolean r0 = r0.a(r3, r5, r6)
            if (r0 == 0) goto L_0x0247
            int r18 = r18 * r2
            int r17 = r17 - r18
            int r0 = r17 % 103
            if (r0 != r2) goto L_0x0242
            int r0 = r13.length()
            if (r0 == 0) goto L_0x023d
            if (r0 <= 0) goto L_0x01f4
            if (r19 == 0) goto L_0x01f4
            r2 = 99
            if (r9 != r2) goto L_0x01ef
            int r2 = r0 + -2
            r13.delete(r2, r0)
            goto L_0x01f4
        L_0x01ef:
            int r2 = r0 + -1
            r13.delete(r2, r0)
        L_0x01f4:
            r0 = 1
            r2 = r4[r0]
            r0 = 0
            r3 = r4[r0]
            int r2 = r2 + r3
            float r0 = (float) r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r3 = (float) r12
            float r1 = (float) r1
            float r1 = r1 / r2
            float r3 = r3 + r1
            int r1 = r7.size()
            byte[] r2 = new byte[r1]
            r4 = 0
        L_0x020a:
            if (r4 >= r1) goto L_0x021b
            java.lang.Object r5 = r7.get(r4)
            java.lang.Byte r5 = (java.lang.Byte) r5
            byte r5 = r5.byteValue()
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x020a
        L_0x021b:
            com.google.zxing.w r1 = new com.google.zxing.w
            java.lang.String r4 = r13.toString()
            r5 = 2
            com.google.zxing.y[] r5 = new com.google.zxing.y[r5]
            com.google.zxing.y r6 = new com.google.zxing.y
            r7 = r25
            float r7 = (float) r7
            r6.<init>(r0, r7)
            r0 = 0
            r5[r0] = r6
            com.google.zxing.y r0 = new com.google.zxing.y
            r0.<init>(r3, r7)
            r3 = 1
            r5[r3] = r0
            com.google.zxing.c r0 = com.google.zxing.c.CODE_128
            r1.<init>(r4, r2, r5, r0)
            return r1
        L_0x023d:
            com.google.zxing.q r0 = com.google.zxing.q.a()
            throw r0
        L_0x0242:
            com.google.zxing.g r0 = com.google.zxing.g.a()
            throw r0
        L_0x0247:
            com.google.zxing.q r0 = com.google.zxing.q.a()
            goto L_0x024d
        L_0x024c:
            throw r0
        L_0x024d:
            goto L_0x024c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.d.c.a(int, com.google.zxing.c.a, java.util.Map):com.google.zxing.w");
    }
}
