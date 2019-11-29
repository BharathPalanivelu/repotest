package com.salesforce.android.service.common.utilities.hashing;

public class Murmur3_32 {
    public static int hash(CharSequence charSequence, int i) {
        return hash(charSequence, 0, charSequence.length(), i);
    }

    public static int hash(CharSequence charSequence, int i, int i2, int i3) {
        CharSequence charSequence2 = charSequence;
        int i4 = i + i2;
        int i5 = i;
        int i6 = i3;
        char c2 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < i4) {
            int i9 = i5 + 1;
            char charAt = charSequence2.charAt(i5);
            char c3 = 8;
            if (charAt >= 128) {
                if (charAt < 2048) {
                    charAt = (((charAt & '?') | 128) << 8) | (charAt >> 6) | 192;
                    c3 = 16;
                } else if (charAt < 55296 || charAt > 57343 || i9 >= i4) {
                    charAt = (((charAt & '?') | 128) << 16) | (charAt >> 12) | 224 | ((((charAt >> 6) & 63) | 128) << 8);
                    c3 = 24;
                } else {
                    int charAt2 = ((charAt - 55232) << 10) + (charSequence2.charAt(i9) & 1023);
                    charAt = (((charAt2 & 63) | 128) << 24) | ((((charAt2 >> 12) & 63) | 128) << 8) | (((charAt2 >> 18) | 240) & 255) | ((((charAt2 >> 6) & 63) | 128) << 16);
                    i9++;
                    c3 = ' ';
                }
            }
            int i10 = (charAt << c2) | i8;
            c2 += c3;
            if (c2 >= 32) {
                int i11 = i10 * -862048943;
                int i12 = (((i11 >>> 17) | (i11 << 15)) * 461845907) ^ i6;
                c2 -= 32;
                i7 += 4;
                i6 = (((i12 >>> 19) | (i12 << 13)) * 5) - 430675100;
                i8 = c2 != 0 ? charAt >>> (c3 - c2) : 0;
            } else {
                i8 = i10;
            }
            i5 = i9;
        }
        if (c2 > 0) {
            i7 += c2 >> 3;
            int i13 = i8 * -862048943;
            i6 ^= ((i13 << 15) | (i13 >>> 17)) * 461845907;
        }
        int i14 = i6 ^ i7;
        int i15 = (i14 ^ (i14 >>> 16)) * -2048144789;
        int i16 = (i15 ^ (i15 >>> 13)) * -1028477387;
        return i16 ^ (i16 >>> 16);
    }
}
