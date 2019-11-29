package com.google.zxing.e.a;

import com.facebook.imageutils.JfifUtil;
import com.google.zxing.c.c;
import com.google.zxing.c.l;
import com.google.zxing.j;
import com.google.zxing.m;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14649a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', IOUtils.DIR_SEPARATOR_UNIX, ':'};

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e8 A[LOOP:0: B:1:0x001e->B:60:0x00e8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.zxing.c.e a(byte[] r17, com.google.zxing.e.a.j r18, com.google.zxing.e.a.f r19, java.util.Map<com.google.zxing.j, ?> r20) throws com.google.zxing.m {
        /*
            r0 = r18
            com.google.zxing.c.c r7 = new com.google.zxing.c.c
            r8 = r17
            r7.<init>(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r1 = 50
            r9.<init>(r1)
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 1
            r10.<init>(r11)
            r1 = 0
            r2 = -1
            r12 = 0
            r14 = r12
            r13 = 0
            r15 = -1
            r16 = -1
        L_0x001e:
            int r1 = r7.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            r2 = 4
            if (r1 >= r2) goto L_0x0029
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x0027:
            r6 = r1
            goto L_0x0032
        L_0x0029:
            int r1 = r7.a(r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.forBits(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0027
        L_0x0032:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 == r1) goto L_0x0059
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.FNC1_FIRST_POSITION     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 == r1) goto L_0x00c0
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.FNC1_SECOND_POSITION     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x0040
            goto L_0x00c0
        L_0x0040:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.STRUCTURED_APPEND     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x0061
            int r1 = r7.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            r2 = 16
            if (r1 < r2) goto L_0x005c
            r1 = 8
            int r2 = r7.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r1 = r7.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            r16 = r1
            r15 = r2
        L_0x0059:
            r11 = r6
            goto L_0x00c2
        L_0x005c:
            com.google.zxing.m r0 = com.google.zxing.m.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x0061:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.ECI     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x0075
            int r1 = a((com.google.zxing.c.c) r7)     // Catch:{ IllegalArgumentException -> 0x00eb }
            com.google.zxing.c.d r14 = com.google.zxing.c.d.getCharacterSetECIByValue(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r14 == 0) goto L_0x0070
            goto L_0x0059
        L_0x0070:
            com.google.zxing.m r0 = com.google.zxing.m.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x0075:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.HANZI     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x008b
            int r1 = r7.a(r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r2 = r6.getCharacterCountBits(r0)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r2 = r7.a(r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r1 != r11) goto L_0x0059
            a(r7, r9, r2)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0059
        L_0x008b:
            int r1 = r6.getCharacterCountBits(r0)     // Catch:{ IllegalArgumentException -> 0x00eb }
            int r3 = r7.a(r1)     // Catch:{ IllegalArgumentException -> 0x00eb }
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.NUMERIC     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x009b
            c(r7, r9, r3)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0059
        L_0x009b:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.ALPHANUMERIC     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x00a3
            a((com.google.zxing.c.c) r7, (java.lang.StringBuilder) r9, (int) r3, (boolean) r13)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x0059
        L_0x00a3:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.BYTE     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r6 != r1) goto L_0x00b2
            r1 = r7
            r2 = r9
            r4 = r14
            r5 = r10
            r11 = r6
            r6 = r20
            a(r1, r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x00c2
        L_0x00b2:
            r11 = r6
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.KANJI     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r11 != r1) goto L_0x00bb
            b(r7, r9, r3)     // Catch:{ IllegalArgumentException -> 0x00eb }
            goto L_0x00c2
        L_0x00bb:
            com.google.zxing.m r0 = com.google.zxing.m.a()     // Catch:{ IllegalArgumentException -> 0x00eb }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00eb }
        L_0x00c0:
            r11 = r6
            r13 = 1
        L_0x00c2:
            com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00eb }
            if (r11 != r1) goto L_0x00e8
            com.google.zxing.c.e r7 = new com.google.zxing.c.e
            java.lang.String r2 = r9.toString()
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x00d4
            r3 = r12
            goto L_0x00d5
        L_0x00d4:
            r3 = r10
        L_0x00d5:
            if (r19 != 0) goto L_0x00d9
            r4 = r12
            goto L_0x00de
        L_0x00d9:
            java.lang.String r0 = r19.toString()
            r4 = r0
        L_0x00de:
            r0 = r7
            r1 = r17
            r5 = r15
            r6 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x00e8:
            r11 = 1
            goto L_0x001e
        L_0x00eb:
            com.google.zxing.m r0 = com.google.zxing.m.a()
            goto L_0x00f1
        L_0x00f0:
            throw r0
        L_0x00f1:
            goto L_0x00f0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.a.d.a(byte[], com.google.zxing.e.a.j, com.google.zxing.e.a.f, java.util.Map):com.google.zxing.c.e");
    }

    private static void a(c cVar, StringBuilder sb, int i) throws m {
        if (i * 13 <= cVar.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = cVar.a(13);
                int i3 = (a2 % 96) | ((a2 / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) ((i4 >> 8) & 255);
                bArr[i2 + 1] = (byte) (i4 & 255);
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw m.a();
            }
        } else {
            throw m.a();
        }
    }

    private static void b(c cVar, StringBuilder sb, int i) throws m {
        if (i * 13 <= cVar.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = cVar.a(13);
                int i3 = (a2 % JfifUtil.MARKER_SOFn) | ((a2 / JfifUtil.MARKER_SOFn) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw m.a();
            }
        } else {
            throw m.a();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i, com.google.zxing.c.d dVar, Collection<byte[]> collection, Map<j, ?> map) throws m {
        String str;
        if (i * 8 <= cVar.a()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) cVar.a(8);
            }
            if (dVar == null) {
                str = l.a(bArr, map);
            } else {
                str = dVar.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw m.a();
            }
        } else {
            throw m.a();
        }
    }

    private static char a(int i) throws m {
        char[] cArr = f14649a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw m.a();
    }

    private static void a(c cVar, StringBuilder sb, int i, boolean z) throws m {
        while (i > 1) {
            if (cVar.a() >= 11) {
                int a2 = cVar.a(11);
                sb.append(a(a2 / 45));
                sb.append(a(a2 % 45));
                i -= 2;
            } else {
                throw m.a();
            }
        }
        if (i == 1) {
            if (cVar.a() >= 6) {
                sb.append(a(cVar.a(6)));
            } else {
                throw m.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void c(c cVar, StringBuilder sb, int i) throws m {
        while (i >= 3) {
            if (cVar.a() >= 10) {
                int a2 = cVar.a(10);
                if (a2 < 1000) {
                    sb.append(a(a2 / 100));
                    sb.append(a((a2 / 10) % 10));
                    sb.append(a(a2 % 10));
                    i -= 3;
                } else {
                    throw m.a();
                }
            } else {
                throw m.a();
            }
        }
        if (i == 2) {
            if (cVar.a() >= 7) {
                int a3 = cVar.a(7);
                if (a3 < 100) {
                    sb.append(a(a3 / 10));
                    sb.append(a(a3 % 10));
                    return;
                }
                throw m.a();
            }
            throw m.a();
        } else if (i != 1) {
        } else {
            if (cVar.a() >= 4) {
                int a4 = cVar.a(4);
                if (a4 < 10) {
                    sb.append(a(a4));
                    return;
                }
                throw m.a();
            }
            throw m.a();
        }
    }

    private static int a(c cVar) throws m {
        int a2 = cVar.a(8);
        if ((a2 & 128) == 0) {
            return a2 & 127;
        }
        if ((a2 & JfifUtil.MARKER_SOFn) == 128) {
            return cVar.a(8) | ((a2 & 63) << 8);
        }
        if ((a2 & 224) == 192) {
            return cVar.a(16) | ((a2 & 31) << 16);
        }
        throw m.a();
    }
}
