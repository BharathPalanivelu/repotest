package com.c.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class c {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f5605a = Charset.forName("US-ASCII");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f5606b = Charset.forName("UTF-8");

    static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
