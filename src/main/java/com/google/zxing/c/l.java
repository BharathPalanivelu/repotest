package com.google.zxing.c;

import com.google.zxing.j;
import java.nio.charset.Charset;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14521a = Charset.defaultCharset().name();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f14522b = ("SJIS".equalsIgnoreCase(f14521a) || "EUC_JP".equalsIgnoreCase(f14521a));

    public static String a(byte[] bArr, Map<j, ?> map) {
        byte[] bArr2 = bArr;
        Map<j, ?> map2 = map;
        if (map2 != null) {
            String str = (String) map2.get(j.CHARACTER_SET);
            if (str != null) {
                return str;
            }
        }
        int length = bArr2.length;
        int i = 0;
        boolean z = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (z2 || z3 || z4)) {
            byte b2 = bArr2[i3] & 255;
            if (z4) {
                if (i4 > 0) {
                    if ((b2 & 128) != 0) {
                        i4--;
                    }
                } else if ((b2 & 128) != 0) {
                    if ((b2 & 64) != 0) {
                        i4++;
                        if ((b2 & 32) == 0) {
                            i6++;
                        } else {
                            i4++;
                            if ((b2 & 16) == 0) {
                                i7++;
                            } else {
                                i4++;
                                if ((b2 & 8) == 0) {
                                    i8++;
                                }
                            }
                        }
                    }
                }
                z4 = false;
            }
            if (z2) {
                if (b2 > Byte.MAX_VALUE && b2 < 160) {
                    z2 = false;
                } else if (b2 > 159 && (b2 < 192 || b2 == 215 || b2 == 247)) {
                    i10++;
                }
            }
            if (z3) {
                if (i5 > 0) {
                    if (b2 >= 64 && b2 != Byte.MAX_VALUE && b2 <= 252) {
                        i5--;
                    }
                } else if (!(b2 == 128 || b2 == 160 || b2 > 239)) {
                    if (b2 <= 160 || b2 >= 224) {
                        if (b2 > Byte.MAX_VALUE) {
                            i5++;
                            int i13 = i11 + 1;
                            if (i13 > i) {
                                i = i13;
                                i11 = i;
                            } else {
                                i11 = i13;
                            }
                        } else {
                            i11 = 0;
                        }
                        i12 = 0;
                    } else {
                        i2++;
                        int i14 = i12 + 1;
                        if (i14 > i9) {
                            i9 = i14;
                            i12 = i9;
                        } else {
                            i12 = i14;
                        }
                        i11 = 0;
                    }
                }
                z3 = false;
            }
            i3++;
            bArr2 = bArr;
        }
        if (z4 && i4 > 0) {
            z4 = false;
        }
        if (z3 && i5 > 0) {
            z3 = false;
        }
        if (z4 && (z || i6 + i7 + i8 > 0)) {
            return "UTF8";
        }
        if (z3 && (f14522b || i9 >= 3 || i >= 3)) {
            return "SJIS";
        }
        if (!z2 || !z3) {
            if (z2) {
                return "ISO8859_1";
            }
            if (z3) {
                return "SJIS";
            }
            if (z4) {
                return "UTF8";
            }
            return f14521a;
        } else if ((i9 != 2 || i2 != 2) && i10 * 10 < length) {
            return "ISO8859_1";
        } else {
            return "SJIS";
        }
    }
}
