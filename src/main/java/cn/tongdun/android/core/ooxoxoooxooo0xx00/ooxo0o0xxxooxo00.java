package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.content.Context;
import android.content.SharedPreferences;

public class ooxo0o0xxxooxo00 {
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("1f5554794f705c675d", 89);

    private static void o00xxox0x0xoox(SharedPreferences.Editor editor, String str, Object obj) {
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            editor.putString(str, (String) obj);
        }
    }

    public static void o00xxox0x0xoox(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        o00xxox0x0xoox(edit, str2, (Object) str3);
        edit.commit();
    }

    public static void o00xxox0x0xoox(Context context, String str, String str2) {
        o00xxox0x0xoox(context, o00xxox0x0xoox, str, str2);
    }

    private static Object o00xxox0x0xoox(SharedPreferences sharedPreferences, String str, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        return null;
    }

    public static Object o00xxox0x0xoox(Context context, String str, String str2, Object obj) {
        return o00xxox0x0xoox(context.getSharedPreferences(str, 0), str2, obj);
    }

    public static Object o00xxox0x0xoox(Context context, String str, Object obj) {
        return o00xxox0x0xoox(context, o00xxox0x0xoox, str, obj);
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
            byte b2 = (byte) (i ^ 7);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 121);
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
