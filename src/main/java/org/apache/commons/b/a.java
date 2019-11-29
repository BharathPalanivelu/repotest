package org.apache.commons.b;

import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final BigInteger f33825a = BigInteger.valueOf(IjkMediaMeta.AV_CH_SIDE_RIGHT);

    /* renamed from: b  reason: collision with root package name */
    public static final BigInteger f33826b;

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f33827c = f33825a.multiply(f33826b);

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f33828d = f33825a.multiply(f33827c);

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f33829e = f33825a.multiply(f33828d);

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f33830f = f33825a.multiply(f33829e);

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f33831g = BigInteger.valueOf(IjkMediaMeta.AV_CH_SIDE_RIGHT).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger h = f33825a.multiply(f33831g);
    public static final File[] i = new File[0];

    static {
        BigInteger bigInteger = f33825a;
        f33826b = bigInteger.multiply(bigInteger);
    }

    public static void a(File file) throws IOException {
        if (file.exists()) {
            if (!e(file)) {
                c(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|(1:6)|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r2.isDirectory()     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            c(r2)     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            boolean r2 = r2.delete()     // Catch:{ Exception -> 0x0012 }
            return r2
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.b.a.b(java.io.File):boolean");
    }

    public static void c(File file) throws IOException {
        IOException e2 = null;
        for (File d2 : f(file)) {
            try {
                d(d2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    private static File[] f(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return listFiles;
            }
            throw new IOException("Failed to list contents of " + file);
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static void d(File file) throws IOException {
        if (file.isDirectory()) {
            a(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static boolean e(File file) throws IOException {
        if (file != null) {
            return Files.isSymbolicLink(file.toPath());
        }
        throw new NullPointerException("File must not be null");
    }
}
