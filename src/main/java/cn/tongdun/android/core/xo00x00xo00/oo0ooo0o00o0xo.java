package cn.tongdun.android.core.xo00x00xo00;

import cn.tongdun.android.shell.settings.Constants;

public class oo0ooo0o00o0xo {
    public static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("021661284e2446", 111);
    public static final String o00xxox0x0xoox = Constants.VERSION;
    public static final String oo0ooo0o00o0xo = o00xxox0x0xoox("02526b4476427b", 53);
    public static final String ooxoxoooxooo0xx00 = o00xxox0x0xoox("4d043a172e06270e36082d197b5476", 36);
    public static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("0b78687c6b357e353723696b7d786969606171676a763c3b317a7f75756368656532796d7b70727f77763c32252e24", 12);
    public static final String x0ox00x0oooo0xxx = o00xxox0x0xoox("4c4d2047365a3057674b384925402a45230e67177b16", 107);
    public static final String xo00x00xo00 = o00xxox0x0xoox("0b5768536b1a7e1a370c331d251a7f526b417f507658675e7c4f2a022743694c635a7e5c730b6f546d496446614f2a0b331732", 35);

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 104);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 99);
            byte b3 = bArr[0];
            int i4 = 1;
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
