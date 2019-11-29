package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import cn.tongdun.android.core.O0o0o0o0o;
import cn.tongdun.android.core.o00xx0xx0ooooo0xx00.o00xxox0x0xoox;
import java.io.File;
import java.io.FileInputStream;

public class x00oxo0xx {
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("6f1e4f0452155f", 61);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("15113e10230b2b", 120);
    private static final x00oxo0xx x0000xo0x0oooooo0 = new x00oxo0xx();
    private String o00xx0xx0ooooo0xx00 = null;

    public static x00oxo0xx o00xxox0x0xoox() {
        return x0000xo0x0oooooo0;
    }

    private x00oxo0xx() {
    }

    public String o00xxox0x0xoox(Context context) {
        if (context == null) {
            return null;
        }
        if (this.o00xx0xx0ooooo0xx00 == null) {
            this.o00xx0xx0ooooo0xx00 = oo0ooo0o00o0xo(context);
        }
        return this.o00xx0xx0ooooo0xx00;
    }

    private String oo0ooo0o00o0xo(Context context) {
        String o00xx0xx0ooooo0xx002 = o00xx0xx0ooooo0xx00(context);
        if (!(O0o0o0o0o.o0OOO0ooo0o == null || o00xx0xx0ooooo0xx002 == null)) {
            try {
                return new String(o00xxox0x0xoox.oo0ooo0o00o0xo(o00xx0xx0ooooo0xx002.getBytes(o00xxox0x0xoox("4e31677a72", 3)), O0o0o0o0o.o0OOO0ooo0o.getBytes(o00xxox0x0xoox("4e28676372", 26))), o00xxox0x0xoox("4e38677372", 10));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String o00xx0xx0ooooo0xx00(Context context) {
        return o00xxox0x0xoox(new File(context.getFilesDir().getAbsolutePath(), oo0ooo0o00o0xo));
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
                return new String(bArr, 0, read, o00xxox0x0xoox("4e54671f72", 102));
            }
        } catch (Exception unused) {
        }
        return null;
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
            byte b2 = (byte) (i ^ 51);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 59);
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
