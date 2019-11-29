package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.content.pm.PackageManager;
import android.text.TextUtils;

public class o00xxox0x0xoox {
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("1c0f614c2e412b4a28492b06681f705d3354270a620670126304", 78);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("122e756f3d723163267f2972", 122);

    public static boolean o00xxox0x0xoox(PackageManager packageManager, String str) {
        if (x0000xo0x0oooooo0.o00xxox0x0xoox(packageManager, o00xxox0x0xoox) == null) {
            return !TextUtils.isEmpty(str) && str.contains(oo0ooo0o00o0xo);
        }
        return true;
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
            byte b2 = (byte) (i ^ 77);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ Byte.MAX_VALUE);
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
