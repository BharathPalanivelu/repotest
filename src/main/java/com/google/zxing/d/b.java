package com.google.zxing.d;

import com.tencent.qcloud.core.util.IOUtils;

public final class b extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14587a = {'A', 'B', 'C', 'D'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14588b = {'T', 'N', '*', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f14589c = {IOUtils.DIR_SEPARATOR_UNIX, ':', '+', '.'};

    /* renamed from: d  reason: collision with root package name */
    private static final char f14590d = f14587a[0];

    public boolean[] a(String str) {
        int i;
        if (str.length() < 2) {
            str = f14590d + str + f14590d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a2 = a.a(f14587a, upperCase);
            boolean a3 = a.a(f14587a, upperCase2);
            boolean a4 = a.a(f14588b, upperCase);
            boolean a5 = a.a(f14588b, upperCase2);
            if (a2) {
                if (!a3) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a4) {
                if (!a5) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a3 || a5) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            } else {
                str = f14590d + str + f14590d;
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else if (a.a(f14589c, str.charAt(i3))) {
                i2 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
            }
        }
        boolean[] zArr = new boolean[(i2 + (str.length() - 1))];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                if (i6 >= a.f14524a.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == a.f14524a[i6]) {
                    i = a.f14525b[i6];
                    break;
                } else {
                    i6++;
                }
            }
            int i7 = i4;
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i7] = z;
                    i7++;
                    if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i7] = false;
                i7++;
            }
            i4 = i7;
        }
        return zArr;
    }
}
