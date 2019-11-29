package com.crashlytics.android.b;

import android.content.Context;
import android.content.pm.PackageManager;
import io.a.a.a.a.a.d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class h implements d<String> {
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(android.content.Context r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to close the APK file"
            java.lang.String r1 = "Beta"
            long r2 = java.lang.System.nanoTime()
            r4 = 0
            java.lang.String r5 = "io.crash.air"
            java.util.zip.ZipInputStream r4 = r7.a(r8, r5)     // Catch:{ NameNotFoundException -> 0x0044, FileNotFoundException -> 0x0034, IOException -> 0x0024 }
            java.lang.String r8 = r7.a((java.util.zip.ZipInputStream) r4)     // Catch:{ NameNotFoundException -> 0x0044, FileNotFoundException -> 0x0034, IOException -> 0x0024 }
            if (r4 == 0) goto L_0x005d
            r4.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x005d
        L_0x0019:
            r4 = move-exception
            io.a.a.a.l r5 = io.a.a.a.c.h()
            r5.e(r1, r0, r4)
            goto L_0x005d
        L_0x0022:
            r8 = move-exception
            goto L_0x008a
        L_0x0024:
            r8 = move-exception
            io.a.a.a.l r5 = io.a.a.a.c.h()     // Catch:{ all -> 0x0022 }
            java.lang.String r6 = "Failed to read the APK file"
            r5.e(r1, r6, r8)     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x005b
            r4.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005b
        L_0x0034:
            r8 = move-exception
            io.a.a.a.l r5 = io.a.a.a.c.h()     // Catch:{ all -> 0x0022 }
            java.lang.String r6 = "Failed to find the APK file"
            r5.e(r1, r6, r8)     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x005b
            r4.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005b
        L_0x0044:
            io.a.a.a.l r8 = io.a.a.a.c.h()     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = "Beta by Crashlytics app is not installed"
            r8.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x005b
            r4.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005b
        L_0x0053:
            r8 = move-exception
            io.a.a.a.l r4 = io.a.a.a.c.h()
            r4.e(r1, r0, r8)
        L_0x005b:
            java.lang.String r8 = ""
        L_0x005d:
            long r4 = java.lang.System.nanoTime()
            long r4 = r4 - r2
            double r2 = (double) r4
            r4 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r4
            io.a.a.a.l r0 = io.a.a.a.c.h()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Beta device token load took "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = "ms"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.a((java.lang.String) r1, (java.lang.String) r2)
            return r8
        L_0x008a:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0098
        L_0x0090:
            r2 = move-exception
            io.a.a.a.l r3 = io.a.a.a.c.h()
            r3.e(r1, r0, r2)
        L_0x0098:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.b.h.b(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public ZipInputStream a(Context context, String str) throws PackageManager.NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    /* access modifiers changed from: package-private */
    public String a(ZipInputStream zipInputStream) throws IOException {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry == null) {
            return "";
        }
        String name = nextEntry.getName();
        return name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=") ? name.substring(59, name.length() - 1) : "";
    }
}
