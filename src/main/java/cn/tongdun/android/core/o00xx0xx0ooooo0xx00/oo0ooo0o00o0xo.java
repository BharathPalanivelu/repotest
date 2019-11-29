package cn.tongdun.android.core.o00xx0xx0ooooo0xx00;

import java.util.Random;

public class oo0ooo0o00o0xo {
    public static String o00xxox0x0xoox(int i) {
        char[] cArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        int i2 = 0;
        while (i2 < i) {
            int abs = (int) Math.abs((((long) random.nextInt()) + System.nanoTime()) % 36);
            if (abs >= 0 && abs < cArr.length) {
                stringBuffer.append(cArr[abs]);
                i2++;
            }
        }
        return stringBuffer.toString();
    }

    public static String o00xxox0x0xoox(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] o00xxox0x0xoox(String str) {
        byte[] bArr = null;
        if (str != null) {
            if (str.length() < 1) {
                return null;
            }
            bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < str.length() / 2; i++) {
                int i2 = i * 2;
                int i3 = i2 + 1;
                bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) * 16) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
            }
        }
        return bArr;
    }
}
