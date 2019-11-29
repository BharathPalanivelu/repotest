package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.content.pm.PackageManager;

public class oo0ooo0o00o0xo {
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("2d2c616f2d6c2561343a7723606e2065324d004f014a0f56580c491a4e", 121);
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("2d4661052d06250b345077496004370e211932", 19);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("2d0d614e2d4d2540341b7702604f2f5e2f422c4a224d6217730174", 88);
    private static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("2d6a61292d2a2527347c796d6475776566736129222b2f202a29262e2e27", 63);
    private static final String x0ox00x0oooo0xxx = o00xxox0x0xoox("2d0461472d4425493412770b60462f572f4b2c432244", 81);
    private static final String[] xo00x00xo00 = {o00xxox0x0xoox, oo0ooo0o00o0xo, o00xx0xx0ooooo0xx00, x0000xo0x0oooooo0, x0ox00x0oooo0xxx};

    public static boolean o00xxox0x0xoox(PackageManager packageManager) {
        int i = 0;
        for (String o00xxox0x0xoox2 : xo00x00xo00) {
            if (x0000xo0x0oooooo0.o00xxox0x0xoox(packageManager, o00xxox0x0xoox2) != null) {
                i++;
            }
        }
        if (i >= 3) {
            return true;
        }
        return false;
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
            byte b2 = (byte) (i ^ 89);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 78);
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
