package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.tongdun.android.core.O0o0o0o0o;
import cn.tongdun.android.core.o00xx0xx0ooooo0xx00.o00xxox0x0xoox;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ox000o0o;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0;
import cn.tongdun.android.shell.common.HelperJNI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class ooxo0o0xxxooxo00 {
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("197f7b627476676276", 4);
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("0c153d5b325e3e55240c6001291f", 113);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("56283e6120", 6);
    /* access modifiers changed from: private */
    public static Map x0000xo0x0oooooo0;
    private static int x0ox00x0oooo0xxx = 0;

    public static String o00xxox0x0xoox(Context context) {
        x0ox00x0oooo0xxx = 0;
        String[] strArr = new String[4];
        String[] strArr2 = {"", oo0ooo0o00o0xo(context), o00xx0xx0ooooo0xx00(context), x0000xo0x0oooooo0()};
        for (int i = 1; i < strArr2.length; i++) {
            String str = strArr2[i];
            if (str == null || str.length() == 0) {
                x0ox00x0oooo0xxx |= 1 << i;
            }
        }
        strArr[1] = o00xx0xx0ooooo0xx00(1, strArr2[1]);
        strArr[2] = o00xx0xx0ooooo0xx00(2, strArr2[2]);
        strArr[3] = o00xx0xx0ooooo0xx00(3, strArr2[3]);
        if (ox000o0o.o00xxox0x0xoox(strArr)) {
            String o00xx0xx0ooooo0xx002 = o00xx0xx0ooooo0xx00();
            new Thread(new ox0xxoox0(context, o00xx0xx0ooooo0xx002)).start();
            return o00xx0xx0ooooo0xx002;
        }
        x0000xo0x0oooooo0 = new HashMap();
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && !o00xxox0x0xoox("167b777b", 20).equals(str2)) {
                if (x0000xo0x0oooooo0.containsKey(str2)) {
                    Map map = x0000xo0x0oooooo0;
                    map.put(str2, Integer.valueOf(((Integer) map.get(str2)).intValue() + 1));
                } else {
                    x0000xo0x0oooooo0.put(str2, 1);
                }
            }
        }
        TreeMap treeMap = new TreeMap(new ox000o0o());
        treeMap.putAll(x0000xo0x0oooooo0);
        String str3 = (String) treeMap.firstKey();
        new Thread(new ox0xxoox0(context, str3)).start();
        if (strArr[1] != null && !str3.equals(strArr[1])) {
            x0ox00x0oooo0xxx |= 512;
        }
        if (strArr[2] != null && !str3.equals(strArr[2])) {
            x0ox00x0oooo0xxx |= 1024;
        }
        return str3;
    }

    static int o00xxox0x0xoox() {
        return x0ox00x0oooo0xxx;
    }

    private static String o00xx0xx0ooooo0xx00() {
        O0o0o0o0o.o0ooo0oo0oo0o = UUID.randomUUID().toString();
        HelperJNI.exprot(2, 0);
        return O0o0o0o0o.o0o0oo;
    }

    /* access modifiers changed from: private */
    public static String oo0ooo0o00o0xo(int i, String str) {
        HelperJNI.exprot(3, i);
        if (O0o0o0o0o.o0OOO0ooo0o == null) {
            HelperJNI.exprot(3, i);
        }
        if (O0o0o0o0o.o0OOO0ooo0o == null || str == null) {
            return null;
        }
        try {
            return new String(o00xxox0x0xoox.o00xxox0x0xoox(str.getBytes(o00xxox0x0xoox("0d7f673472", 10)), O0o0o0o0o.o0OOO0ooo0o.getBytes(o00xxox0x0xoox("0d3f677472", 74))), o00xxox0x0xoox("0d02674972", 119));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String o00xx0xx0ooooo0xx00(int i, String str) {
        HelperJNI.exprot(3, i);
        if (O0o0o0o0o.o0OOO0ooo0o == null) {
            HelperJNI.exprot(3, i);
        }
        if (O0o0o0o0o.o0OOO0ooo0o == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(o00xxox0x0xoox.oo0ooo0o00o0xo(str.getBytes(o00xxox0x0xoox("0d0c674772", 121)), O0o0o0o0o.o0OOO0ooo0o.getBytes(o00xxox0x0xoox("0d67672c72", 18))), o00xxox0x0xoox("0d57671c72", 34));
        } catch (Exception unused) {
            x0ox00x0oooo0xxx = (16 << i) | x0ox00x0oooo0xxx;
            return null;
        }
    }

    private static String oo0ooo0o00o0xo(Context context) {
        String str = (String) cn.tongdun.android.core.ooxoxoooxooo0xx00.ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox, (Object) "");
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static void x0000xo0x0oooooo0(Context context, String str) {
        cn.tongdun.android.core.ooxoxoooxooo0xx00.ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox, str);
    }

    private static String o00xx0xx0ooooo0xx00(Context context) {
        return o00xxox0x0xoox(new File(context.getFilesDir().getAbsolutePath(), oo0ooo0o00o0xo));
    }

    /* access modifiers changed from: private */
    public static void x0ox00x0oooo0xxx(Context context, String str) {
        o00xxox0x0xoox(new File(context.getFilesDir().getAbsolutePath(), oo0ooo0o00o0xo), str);
    }

    private static String x0000xo0x0oooooo0() {
        new HashMap();
        String externalStorageState = Environment.getExternalStorageState();
        String o00xxox0x0xoox2 = o00xxox0x0xoox("575738503a432c", 127);
        if ("mounted".equals(externalStorageState)) {
            o00xxox0x0xoox2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return HelperJNI.tdread(o00xxox0x0xoox2 + File.separator + o00xx0xx0ooooo0xx00, 1, 1);
    }

    /* access modifiers changed from: private */
    public static void xo00x00xo00(Context context, String str) {
        String externalStorageState = Environment.getExternalStorageState();
        String o00xxox0x0xoox2 = o00xxox0x0xoox("577738703a632c", 95);
        if ("mounted".equals(externalStorageState)) {
            o00xxox0x0xoox2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        String str2 = o00xxox0x0xoox2 + File.separator + o00xx0xx0ooooo0xx00;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            HelperJNI.tdwrite(str2, 1, 1, str);
        }
    }

    private static String o00xxox0x0xoox(File file) {
        try {
            if (file.exists() && file.canRead()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                int read = fileInputStream.read(bArr);
                fileInputStream.close();
                if (read == -1) {
                    return null;
                }
                return new String(bArr, 0, read, o00xxox0x0xoox("0d1b675072", 110));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static boolean o00xxox0x0xoox(File file, String str) {
        try {
            File file2 = new File(file.toString());
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file.canWrite()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (str == null) {
                    return false;
                }
                fileOutputStream.write(str.getBytes(o00xxox0x0xoox("0d14675f72", 97)));
                fileOutputStream.close();
                if (!xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(9)) {
                    file.getClass().getMethod(o00xxox0x0xoox("0b44626255665063536d5a", 38), new Class[]{Boolean.TYPE, Boolean.TYPE}).invoke(file, new Object[]{true, false});
                } else if (!file.setReadable(true, false)) {
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(o00xxox0x0xoox("1b5166536d17791779", 46) + file.getAbsolutePath());
                }
                return true;
            }
        } catch (Exception unused) {
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
            byte b2 = (byte) (i ^ 116);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 120);
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
