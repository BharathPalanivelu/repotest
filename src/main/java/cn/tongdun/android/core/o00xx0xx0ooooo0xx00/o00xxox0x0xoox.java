package cn.tongdun.android.core.o00xx0xx0ooooo0xx00;

import android.os.Build;
import android.util.Base64;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class o00xxox0x0xoox {
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("230f57", 80);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("1740670b72", 26);

    public static byte[] o00xxox0x0xoox(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, o00xxox0x0xoox);
                Cipher instance = Cipher.getInstance(o00xxox0x0xoox("234f57333d353c5843434b532d361c331c3e1b37", 16));
                instance.init(1, secretKeySpec);
                return oo0ooo0o00o0xo.o00xxox0x0xoox(instance.doFinal(bArr)).getBytes(oo0ooo0o00o0xo);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static byte[] oo0ooo0o00o0xo(byte[] bArr, byte[] bArr2) throws Exception {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, o00xxox0x0xoox);
        Cipher instance = Cipher.getInstance(o00xxox0x0xoox("2357572b3d2d3c40435b4b4b2d2e1c2b1c261b2f", 8));
        instance.init(2, secretKeySpec);
        return instance.doFinal(oo0ooo0o00o0xo.o00xxox0x0xoox(new String(bArr, oo0ooo0o00o0xo)));
    }

    public static String o00xxox0x0xoox(String str, String str2) {
        SecureRandom secureRandom;
        if (!(str == null || str2 == null)) {
            if (Build.VERSION.SDK_INT >= 24) {
                return o00xxox0x0xoox("0c327566267020662771", 104);
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (decode == null) {
                    return null;
                }
                KeyGenerator instance = KeyGenerator.getInstance(o00xxox0x0xoox);
                if (xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(17)) {
                    secureRandom = SecureRandom.getInstance(o00xxox0x0xoox("31545a243b26272f", 20), o00xxox0x0xoox("215848514c4a", 50));
                } else {
                    secureRandom = SecureRandom.getInstance(o00xxox0x0xoox("31115a613b63276a", 81));
                }
                secureRandom.setSeed(decode);
                instance.init(128, secureRandom);
                Cipher instance2 = Cipher.getInstance(o00xxox0x0xoox("233f57", 96));
                instance2.init(2, (SecretKeySpec) instance.generateKey());
                return new String(instance2.doFinal(oo0ooo0o00o0xo.o00xxox0x0xoox(str)), oo0ooo0o00o0xo);
            } catch (Exception unused) {
            }
        }
        return "";
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
            byte b2 = (byte) (i ^ 91);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 98);
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
