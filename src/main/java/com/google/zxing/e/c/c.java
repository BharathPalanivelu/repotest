package com.google.zxing.e.c;

import com.google.zxing.ac;
import com.google.zxing.c.a;
import com.google.zxing.c.d;
import com.google.zxing.e.a.f;
import com.google.zxing.e.a.h;
import com.google.zxing.e.a.j;
import com.google.zxing.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14692a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int a(b bVar) {
        return d.a(bVar) + d.b(bVar) + d.c(bVar) + d.d(bVar);
    }

    public static f a(String str, f fVar, Map<l, ?> map) throws ac {
        String str2 = map == null ? null : (String) map.get(l.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        h a2 = a(str, str2);
        a aVar = new a();
        if (a2 == h.BYTE && !"ISO-8859-1".equals(str2)) {
            d characterSetECIByName = d.getCharacterSetECIByName(str2);
            if (characterSetECIByName != null) {
                a(characterSetECIByName, aVar);
            }
        }
        a(a2, aVar);
        a aVar2 = new a();
        a(str, a2, aVar2, str2);
        j a3 = a(aVar.a() + a2.getCharacterCountBits(a(aVar.a() + a2.getCharacterCountBits(j.b(1)) + aVar2.a(), fVar)) + aVar2.a(), fVar);
        a aVar3 = new a();
        aVar3.a(aVar);
        a(a2 == h.BYTE ? aVar2.b() : str.length(), a3, a2, aVar3);
        aVar3.a(aVar2);
        j.b a4 = a3.a(fVar);
        int c2 = a3.c() - a4.c();
        a(c2, aVar3);
        a a5 = a(aVar3, a3.c(), c2, a4.b());
        f fVar2 = new f();
        fVar2.a(fVar);
        fVar2.a(a2);
        fVar2.a(a3);
        int d2 = a3.d();
        b bVar = new b(d2, d2);
        int a6 = a(a5, fVar, a3, bVar);
        fVar2.a(a6);
        e.a(a5, fVar, a3, a6, bVar);
        fVar2.a(bVar);
        return fVar2;
    }

    static int a(int i) {
        int[] iArr = f14692a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static h a(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return a(str) ? h.KANJI : h.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (a((int) charAt) == -1) {
                return h.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return h.ALPHANUMERIC;
        }
        if (z2) {
            return h.NUMERIC;
        }
        return h.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                byte b2 = bytes[i] & 255;
                if ((b2 < 129 || b2 > 159) && (b2 < 224 || b2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(a aVar, f fVar, j jVar, b bVar) throws ac {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            e.a(aVar, fVar, jVar, i3, bVar);
            int a2 = a(bVar);
            if (a2 < i) {
                i2 = i3;
                i = a2;
            }
        }
        return i2;
    }

    private static j a(int i, f fVar) throws ac {
        for (int i2 = 1; i2 <= 40; i2++) {
            j b2 = j.b(i2);
            if (b2.c() - b2.a(fVar).c() >= (i + 7) / 8) {
                return b2;
            }
        }
        throw new ac("Data too big");
    }

    static void a(int i, a aVar) throws ac {
        int i2 = i * 8;
        if (aVar.a() <= i2) {
            for (int i3 = 0; i3 < 4 && aVar.a() < i2; i3++) {
                aVar.a(false);
            }
            int a2 = aVar.a() & 7;
            if (a2 > 0) {
                while (a2 < 8) {
                    aVar.a(false);
                    a2++;
                }
            }
            int b2 = i - aVar.b();
            for (int i4 = 0; i4 < b2; i4++) {
                aVar.a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.a() != i2) {
                throw new ac("Bits size does not equal capacity");
            }
            return;
        }
        throw new ac("data bits cannot fit in the QR Code" + aVar.a() + " > " + i2);
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws ac {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new ac("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new ac("RS blocks mismatch");
            } else if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new ac("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
            }
        } else {
            throw new ac("Block ID too large");
        }
    }

    static a a(a aVar, int i, int i2, int i3) throws ac {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (aVar.b() == i5) {
            ArrayList<a> arrayList = new ArrayList<>(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i10, iArr, iArr2);
                int i11 = iArr[0];
                byte[] bArr = new byte[i11];
                aVar.a(i7 * 8, bArr, 0, i11);
                byte[] a2 = a(bArr, iArr2[0]);
                arrayList.add(new a(bArr, a2));
                i8 = Math.max(i8, i11);
                i9 = Math.max(i9, a2.length);
                i7 += iArr[0];
            }
            if (i5 == i7) {
                a aVar2 = new a();
                for (int i12 = 0; i12 < i8; i12++) {
                    for (a a3 : arrayList) {
                        byte[] a4 = a3.a();
                        if (i12 < a4.length) {
                            aVar2.a(a4[i12], 8);
                        }
                    }
                }
                for (int i13 = 0; i13 < i9; i13++) {
                    for (a b2 : arrayList) {
                        byte[] b3 = b2.b();
                        if (i13 < b3.length) {
                            aVar2.a(b3[i13], 8);
                        }
                    }
                }
                if (i4 == aVar2.b()) {
                    return aVar2;
                }
                throw new ac("Interleaving error: " + i4 + " and " + aVar2.b() + " differ.");
            }
            throw new ac("Data bytes does not match offset");
        }
        throw new ac("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.google.zxing.c.b.d(com.google.zxing.c.b.a.f14487e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void a(h hVar, a aVar) {
        aVar.a(hVar.getBits(), 4);
    }

    static void a(int i, j jVar, h hVar, a aVar) throws ac {
        int characterCountBits = hVar.getCharacterCountBits(jVar);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            aVar.a(i, characterCountBits);
            return;
        }
        throw new ac(i + " is bigger than " + (i2 - 1));
    }

    /* renamed from: com.google.zxing.e.c.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14693a = new int[h.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.zxing.e.a.h[] r0 = com.google.zxing.e.a.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14693a = r0
                int[] r0 = f14693a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f14693a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f14693a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.BYTE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f14693a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.zxing.e.a.h r1 = com.google.zxing.e.a.h.KANJI     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.c.c.AnonymousClass1.<clinit>():void");
        }
    }

    static void a(String str, h hVar, a aVar, String str2) throws ac {
        int i = AnonymousClass1.f14693a[hVar.ordinal()];
        if (i == 1) {
            a((CharSequence) str, aVar);
        } else if (i == 2) {
            b(str, aVar);
        } else if (i == 3) {
            a(str, aVar, str2);
        } else if (i == 4) {
            a(str, aVar);
        } else {
            throw new ac("Invalid mode: " + hVar);
        }
    }

    static void a(CharSequence charSequence, a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                aVar.a((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    aVar.a((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    aVar.a(charAt, 4);
                }
            }
        }
    }

    static void b(CharSequence charSequence, a aVar) throws ac {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a((int) charSequence.charAt(i));
            if (a2 != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    int a3 = a((int) charSequence.charAt(i2));
                    if (a3 != -1) {
                        aVar.a((a2 * 45) + a3, 11);
                        i += 2;
                    } else {
                        throw new ac();
                    }
                } else {
                    aVar.a(a2, 6);
                    i = i2;
                }
            } else {
                throw new ac();
            }
        }
    }

    static void a(String str, a aVar, String str2) throws ac {
        try {
            for (byte a2 : str.getBytes(str2)) {
                aVar.a(a2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new ac((Throwable) e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.lang.String r6, com.google.zxing.c.a r7) throws com.google.zxing.ac {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = -1
        L_0x0033:
            if (r2 == r4) goto L_0x0044
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x0044:
            com.google.zxing.ac r6 = new com.google.zxing.ac
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.google.zxing.ac r7 = new com.google.zxing.ac
            r7.<init>((java.lang.Throwable) r6)
            goto L_0x0055
        L_0x0054:
            throw r7
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.c.c.a(java.lang.String, com.google.zxing.c.a):void");
    }

    private static void a(d dVar, a aVar) {
        aVar.a(h.ECI.getBits(), 4);
        aVar.a(dVar.getValue(), 8);
    }
}
