package com.facebook.common.util;

import com.litesuits.orm.db.assit.SQLBuilder;

public class Hex {
    private static final byte[] DIGITS = new byte[103];
    private static final char[] FIRST_CHAR = new char[256];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] SECOND_CHAR = new char[256];

    static {
        for (int i = 0; i < 256; i++) {
            char[] cArr = FIRST_CHAR;
            char[] cArr2 = HEX_DIGITS;
            cArr[i] = cArr2[(i >> 4) & 15];
            SECOND_CHAR[i] = cArr2[i & 15];
        }
        for (int i2 = 0; i2 <= 70; i2++) {
            DIGITS[i2] = -1;
        }
        for (byte b2 = 0; b2 < 10; b2 = (byte) (b2 + 1)) {
            DIGITS[b2 + 48] = b2;
        }
        for (byte b3 = 0; b3 < 6; b3 = (byte) (b3 + 1)) {
            byte[] bArr = DIGITS;
            byte b4 = (byte) (b3 + 10);
            bArr[b3 + 65] = b4;
            bArr[b3 + 97] = b4;
        }
    }

    public static String byte2Hex(int i) {
        if (i > 255 || i < 0) {
            throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
        }
        return String.valueOf(FIRST_CHAR[i]) + String.valueOf(SECOND_CHAR[i]);
    }

    public static String encodeHex(byte[] bArr, boolean z) {
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 == 0 && z) {
                break;
            }
            int i2 = i + 1;
            cArr[i] = FIRST_CHAR[b3];
            i = i2 + 1;
            cArr[i2] = SECOND_CHAR[b3];
        }
        return new String(cArr, 0, i);
    }

    public static byte[] decodeHex(String str) {
        boolean z;
        int length = str.length();
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i = 0;
            int i2 = 0;
            while (true) {
                z = true;
                if (i >= length) {
                    z = false;
                    break;
                }
                int i3 = i + 1;
                char charAt = str.charAt(i);
                if (charAt > 'f') {
                    break;
                }
                byte b2 = DIGITS[charAt];
                if (b2 == -1) {
                    break;
                }
                int i4 = i3 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt2 > 'f') {
                    break;
                }
                byte b3 = DIGITS[charAt2];
                if (b3 == -1) {
                    break;
                }
                bArr[i2] = (byte) ((b2 << 4) | b3);
                i2++;
                i = i4;
            }
            if (!z) {
                return bArr;
            }
            throw new IllegalArgumentException("Invalid hexadecimal digit: " + str);
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static byte[] hexStringToByteArray(String str) {
        return decodeHex(str.replaceAll(SQLBuilder.BLANK, ""));
    }
}
