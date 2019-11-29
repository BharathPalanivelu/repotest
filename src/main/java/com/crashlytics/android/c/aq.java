package com.crashlytics.android.c;

import com.crashlytics.android.c.b;
import io.a.a.a.a.b.i;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class aq implements b.a {
    aq() {
    }

    public String a(File file) throws IOException {
        return a(file.getPath());
    }

    private static String a(String str) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String b2 = i.b((InputStream) bufferedInputStream2);
                i.a((Closeable) bufferedInputStream2);
                return b2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                i.a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i.a((Closeable) bufferedInputStream);
            throw th;
        }
    }
}
