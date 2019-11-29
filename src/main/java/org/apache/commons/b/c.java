package org.apache.commons.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final char f33835a = File.separatorChar;

    /* renamed from: b  reason: collision with root package name */
    public static final String f33836b;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        r5 = r4;
        r4 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0037, code lost:
        if (r1 != null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003d, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r3 = th;
     */
    static {
        /*
            char r0 = java.io.File.separatorChar
            f33835a = r0
            org.apache.commons.b.a.a r0 = new org.apache.commons.b.a.a
            r1 = 4
            r0.<init>(r1)
            r1 = 0
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ Throwable -> 0x0035 }
            r2.<init>(r0)     // Catch:{ Throwable -> 0x0035 }
            r2.println()     // Catch:{ Throwable -> 0x0023, all -> 0x0020 }
            java.lang.String r3 = r0.toString()     // Catch:{ Throwable -> 0x0023, all -> 0x0020 }
            f33836b = r3     // Catch:{ Throwable -> 0x0023, all -> 0x0020 }
            r2.close()     // Catch:{ Throwable -> 0x0035 }
            r0.close()
            return
        L_0x0020:
            r3 = move-exception
            r4 = r1
            goto L_0x0029
        L_0x0023:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r4 = move-exception
            r5 = r4
            r4 = r3
            r3 = r5
        L_0x0029:
            if (r4 == 0) goto L_0x002f
            r2.close()     // Catch:{ Throwable -> 0x0032 }
            goto L_0x0032
        L_0x002f:
            r2.close()     // Catch:{ Throwable -> 0x0035 }
        L_0x0032:
            throw r3     // Catch:{ Throwable -> 0x0035 }
        L_0x0033:
            r2 = move-exception
            goto L_0x0037
        L_0x0035:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0033 }
        L_0x0037:
            if (r1 == 0) goto L_0x003d
            r0.close()     // Catch:{ Throwable -> 0x0040 }
            goto L_0x0040
        L_0x003d:
            r0.close()
        L_0x0040:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.b.c.<clinit>():void");
    }

    @Deprecated
    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    @Deprecated
    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    @Deprecated
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long b2 = b(inputStream, outputStream);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        return a(inputStream, outputStream, new byte[i]);
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return a(inputStream, outputStream, 4096);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
