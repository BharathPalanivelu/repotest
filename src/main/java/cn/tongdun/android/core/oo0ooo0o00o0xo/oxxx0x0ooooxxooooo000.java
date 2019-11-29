package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.text.TextUtils;
import cn.tongdun.android.core.O0o0o0o0o;
import cn.tongdun.android.core.o00xx0xx0ooooo0xx00.o00xxox0x0xoox;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ooxo0o0xxxooxo00;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class oxxx0x0ooooxxooooo000 {
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("4f0b7b167402671676", 82);
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("7a344f284328472a4b2646", 114);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("00793e7e36", 117);
    private static final oxxx0x0ooooxxooooo000 x0ox00x0oooo0xxx = new oxxx0x0ooooxxooooo000();
    /* access modifiers changed from: private */
    public String x0000xo0x0oooooo0 = null;

    public static oxxx0x0ooooxxooooo000 o00xxox0x0xoox() {
        return x0ox00x0oooo0xxx;
    }

    private oxxx0x0ooooxxooooo000() {
    }

    public String o00xxox0x0xoox(Context context) {
        if (context == null) {
            return null;
        }
        if (this.x0000xo0x0oooooo0 == null) {
            this.x0000xo0x0oooooo0 = o00xx0xx0ooooo0xx00(context);
        }
        return this.x0000xo0x0oooooo0;
    }

    public void o00xxox0x0xoox(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.x0000xo0x0oooooo0 = str;
        }
    }

    public void oo0ooo0o00o0xo(Context context) {
        if (!TextUtils.isEmpty(this.x0000xo0x0oooooo0)) {
            new Thread(new x000x0xo0x0(this, context)).start();
        }
    }

    /* access modifiers changed from: private */
    public String oo0ooo0o00o0xo(String str) {
        if (O0o0o0o0o.o0OOO0ooo0o == null || str == null) {
            return null;
        }
        try {
            return new String(o00xxox0x0xoox.o00xxox0x0xoox(str.getBytes(o00xxox0x0xoox("5b10675b72", 71)), O0o0o0o0o.o0OOO0ooo0o.getBytes(o00xxox0x0xoox("5b5a671172", 13))), o00xxox0x0xoox("5b6a672172", 61));
        } catch (Exception unused) {
            return null;
        }
    }

    private String o00xx0xx0ooooo0xx00(Context context) {
        String[] strArr = {x0000xo0x0oooooo0(context), x0ox00x0oooo0xxx(context)};
        String str = (strArr[0] == null || strArr[1] == null || !strArr[0].equals(strArr[1])) ? null : strArr[0];
        if (!(O0o0o0o0o.o0OOO0ooo0o == null || str == null)) {
            try {
                return new String(o00xxox0x0xoox.oo0ooo0o00o0xo(str.getBytes(o00xxox0x0xoox("5b68672372", 63)), O0o0o0o0o.o0OOO0ooo0o.getBytes(o00xxox0x0xoox("5b65672e72", 50))), o00xxox0x0xoox("5b22676972", 117));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String x0000xo0x0oooooo0(Context context) {
        String str = (String) ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox, (Object) "");
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static void o00xx0xx0ooooo0xx00(Context context, String str) {
        ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox, str);
    }

    private static String x0ox00x0oooo0xxx(Context context) {
        return o00xxox0x0xoox(new File(context.getFilesDir().getAbsolutePath(), oo0ooo0o00o0xo));
    }

    /* access modifiers changed from: private */
    public static void x0000xo0x0oooooo0(Context context, String str) {
        o00xxox0x0xoox(new File(context.getFilesDir().getAbsolutePath(), oo0ooo0o00o0xo), str);
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
                return new String(bArr, 0, read, o00xxox0x0xoox("5b42670972", 21));
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
                fileOutputStream.write(str.getBytes(o00xxox0x0xoox("5b2a676172", 125)));
                fileOutputStream.close();
                if (!xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(9)) {
                    file.getClass().getMethod(o00xxox0x0xoox("5d1b623d5539503c53325a", 91), new Class[]{Boolean.TYPE, Boolean.TYPE}).invoke(file, new Object[]{true, false});
                } else if (!file.setReadable(true, false)) {
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(o00xxox0x0xoox("4d2766256d61796179", 122) + file.getAbsolutePath());
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
            byte b2 = (byte) (i ^ 86);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 46);
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
