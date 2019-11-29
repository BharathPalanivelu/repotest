package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import cn.tongdun.android.core.o00xx0xx0ooooo0xx00.o00xxox0x0xoox;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ooxo0o0xxxooxo00;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ox000o0o;
import cn.tongdun.android.shell.common.HelperJNI;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class xoo0xoo0oxo00x0o0 {
    private static final String o00o0o0oo0oo0o000x00 = o00xxox0x0xoox("6b406e477549734b", 16);
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("68535e62536f68406a576942", 21);
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("48286f097c1676105a1d", 78);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("68215e10531d", 103);
    private static final String ooxoxoooxooo0xx00 = o00xxox0x0xoox("674274456f4b6949", 8);
    private static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("20223a312e202728362e2d3f3c32", 39);
    private static final String x0ox00x0oooo0xxx = o00xxox0x0xoox("7d7362737f747660", 40);
    private static final String xo00x00xo00 = o00xxox0x0xoox("7d207a336d266f31", 118);

    public static String o00xxox0x0xoox(Context context) {
        String str;
        int i = 0;
        String[] strArr = {oo0ooo0o00o0xo(o00xx0xx0ooooo0xx00(oo0ooo0o00o0xo(context), 0), 0), oo0ooo0o00o0xo(o00xx0xx0ooooo0xx00(o00xx0xx0ooooo0xx00(context), 1), 1), oo0ooo0o00o0xo(o00xx0xx0ooooo0xx00(o00xxox0x0xoox(x0000xo0x0oooooo0), 2), 2), oo0ooo0o00o0xo(o00xx0xx0ooooo0xx00(oo0ooo0o00o0xo(x0000xo0x0oooooo0), 3), 3)};
        int length = strArr.length;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            str = strArr[i];
            if (!ox000o0o.o00xxox0x0xoox(str)) {
                break;
            }
            i++;
        }
        return ox000o0o.o00xxox0x0xoox(str) ? (String) ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xx0xx0ooooo0xx00, oo0ooo0o00o0xo, (Object) "") : str;
    }

    private static String oo0ooo0o00o0xo(String str, int i) {
        if (str == null) {
            return str;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && str.startsWith(o00o0o0oo0oo0o000x00)) {
                        return str.substring(8);
                    }
                } else if (str.startsWith(ooxoxoooxooo0xx00)) {
                    return str.substring(8);
                }
            } else if (str.startsWith(xo00x00xo00)) {
                return str.substring(8);
            }
        } else if (str.startsWith(x0ox00x0oooo0xxx)) {
            return str.substring(8);
        }
        return "";
    }

    private static String o00xx0xx0ooooo0xx00(String str, int i) {
        if (ox000o0o.o00xxox0x0xoox(str)) {
            return "";
        }
        if (i == 0) {
            return o00xxox0x0xoox.o00xxox0x0xoox(str, x0ox00x0oooo0xxx);
        }
        if (i == 1) {
            return o00xxox0x0xoox.o00xxox0x0xoox(str, xo00x00xo00);
        }
        if (i == 2) {
            return o00xxox0x0xoox.o00xxox0x0xoox(str, ooxoxoooxooo0xx00);
        }
        if (i != 3) {
            return "";
        }
        return o00xxox0x0xoox.o00xxox0x0xoox(str, o00o0o0oo0oo0o000x00);
    }

    private static String oo0ooo0o00o0xo(Context context) {
        String str;
        if (cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.WRITE_SETTINGS")) {
            str = Settings.System.getString(context.getContentResolver(), o00xxox0x0xoox);
        } else {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String o00xx0xx0ooooo0xx00(Context context) {
        return (String) ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox, (Object) "");
    }

    private static String o00xxox0x0xoox(String str) {
        String str2;
        File file = new File(o00xxox0x0xoox("21", 12));
        if (file.canWrite()) {
            str2 = o00xxox0x0xoox(new File(file, str));
            if (!ox000o0o.o00xxox0x0xoox(str2)) {
                return str2;
            }
        } else {
            str2 = "";
        }
        String[] td_listfiles = HelperJNI.td_listfiles(o00xxox0x0xoox("21", 14), 10);
        if (td_listfiles == null) {
            return "";
        }
        String str3 = str2;
        int i = 0;
        while (i < td_listfiles.length && td_listfiles[i] != null) {
            File file2 = new File(td_listfiles[i]);
            if (!o00xxox0x0xoox("215438533a402c", 69).equals(file2.getAbsolutePath())) {
                if (file2.canWrite()) {
                    str3 = o00xxox0x0xoox(new File(file2, str));
                    if (!ox000o0o.o00xxox0x0xoox(str3)) {
                        return str3;
                    }
                }
                String[] td_listfiles2 = HelperJNI.td_listfiles(file2.getAbsolutePath(), 10);
                if (td_listfiles2 == null) {
                    continue;
                } else {
                    String str4 = str3;
                    int i2 = 0;
                    while (i2 < td_listfiles2.length && td_listfiles2[i2] != null) {
                        File file3 = new File(td_listfiles2[i2]);
                        if (file3.canWrite()) {
                            str4 = o00xxox0x0xoox(new File(file3, str));
                            if (!ox000o0o.o00xxox0x0xoox(str4)) {
                                return str4;
                            }
                        }
                        i2++;
                    }
                    str3 = str4;
                }
            }
            i++;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    private static String oo0ooo0o00o0xo(String str) {
        return "mounted".equals(Environment.getExternalStorageState()) ? o00xxox0x0xoox(new File(Environment.getExternalStorageDirectory(), str)) : "";
    }

    private static String o00xxox0x0xoox(File file) {
        try {
            if (!file.exists() || !file.canRead()) {
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read > 0) {
                return new String(bArr, 0, read, o00xxox0x0xoox("7b18675372", 84));
            }
            return "";
        } catch (IOException unused) {
            return "";
        }
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
            bArr[0] = (byte) (bArr[0] ^ 14);
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
