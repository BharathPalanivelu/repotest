package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.os.Build;

public class ooxoxoooxooo0xx00 {
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("7a69606d6c53505c534642525e5f46", 97);

    public static boolean o00xxox0x0xoox() {
        return o00xxox0x0xoox.equals(Build.PRODUCT) || o00xxox0x0xoox.equals(Build.DEVICE);
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            int i4 = 1;
            byte b2 = (byte) (i ^ 1);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 18);
            byte b3 = bArr[0];
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
