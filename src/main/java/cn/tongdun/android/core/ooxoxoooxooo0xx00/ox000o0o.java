package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import com.g.a.a.g;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ox000o0o {
    private static final Pattern o00xxox0x0xoox = Pattern.compile(o00xxox0x0xoox("552444232a4837505f7111187a05636c62547a73116e0d026f61573a340279030d710b6b0c0567187f705e3e37552a4c434d7b555c3e41222d404e78151b2d562d04654a3c", 33));

    public static String o00xxox0x0xoox(int i) {
        return (i & 255) + o00xxox0x0xoox("25", 0) + ((i >> 8) & 255) + o00xxox0x0xoox("25", 82) + ((i >> 16) & 255) + o00xxox0x0xoox("25", 24) + ((i >> 24) & 255);
    }

    public static String oo0ooo0o00o0xo(int i) {
        int i2 = -1 << (32 - i);
        return ((i2 >> 24) & 255) + o00xxox0x0xoox("25", 90) + ((i2 >> 16) & 255) + o00xxox0x0xoox("25", 76) + ((i2 >> 8) & 255) + o00xxox0x0xoox("25", 77) + (i2 & 255);
    }

    public static String o00xxox0x0xoox(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append(o00xxox0x0xoox("3b", 5));
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
            stringBuffer.append(o00xxox0x0xoox("31", 70));
        }
        return String.valueOf(stringBuffer.substring(0, stringBuffer.length() - 1));
    }

    public static boolean o00xxox0x0xoox(String str) {
        return str == null || "".equals(str.trim()) || str.length() == 0;
    }

    public static boolean o00xxox0x0xoox(String... strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (str != null && !"".equals(str) && str.length() > 0) {
                return false;
            }
        }
        return true;
    }

    public static List o00xxox0x0xoox(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!(str == null || str.length() == 0)) {
            if (str2 == null || str2.length() == 0) {
                arrayList.add(str);
            } else if (str.equals(str2)) {
                return arrayList;
            } else {
                while (true) {
                    int indexOf = str.indexOf(str2);
                    if (indexOf == -1) {
                        break;
                    } else if (indexOf == 0) {
                        str = str.substring(indexOf + str2.length());
                    } else if (indexOf >= 1) {
                        arrayList.add(str.substring(0, indexOf));
                        str = str.substring(indexOf + str2.length());
                    }
                }
                if (!o00xxox0x0xoox(str)) {
                    arrayList.add(str);
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public static boolean oo0ooo0o00o0xo(String str) {
        return o00xxox0x0xoox.matcher(str).matches();
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
            byte b2 = (byte) (i ^ 115);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ g.STRUCT_END);
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
