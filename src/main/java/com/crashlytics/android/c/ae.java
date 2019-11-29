package com.crashlytics.android.c;

import android.content.Context;
import io.a.a.a.a.b.i;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class ae {
    static byte[] a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] a2 = a((InputStream) fileInputStream);
                i.a((Closeable) fileInputStream);
                return a2;
            } catch (FileNotFoundException unused) {
                i.a((Closeable) fileInputStream);
                return null;
            } catch (IOException unused2) {
                i.a((Closeable) fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                i.a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            fileInputStream = null;
            i.a((Closeable) fileInputStream);
            return null;
        } catch (IOException unused4) {
            fileInputStream = null;
            i.a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            i.a((Closeable) fileInputStream2);
            throw th;
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static File a(File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    static byte[] b(File file) {
        File a2 = a(file, ".dmp");
        return a2 == null ? new byte[0] : d(a2);
    }

    private static byte[] d(File file) {
        return a(file);
    }

    static byte[] a(File file, Context context) throws IOException {
        File a2 = a(file, ".binary_libs");
        if (a2 == null) {
            return null;
        }
        return b(a2, context);
    }

    private static byte[] b(File file, Context context) throws IOException {
        byte[] a2 = a(file);
        if (a2 == null || a2.length == 0) {
            return null;
        }
        return a(context, new String(a2));
    }

    static byte[] c(File file) {
        File a2 = a(file, ".device_info");
        if (a2 == null) {
            return null;
        }
        return a(a2);
    }

    private static byte[] a(Context context, String str) throws IOException {
        return new b(context, new aq()).a(str);
    }
}
