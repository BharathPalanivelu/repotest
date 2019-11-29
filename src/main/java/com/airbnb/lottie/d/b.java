package com.airbnb.lottie.d;

import android.content.Context;
import com.airbnb.lottie.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3658a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3659b;

    b(Context context, String str) {
        this.f3658a = context.getApplicationContext();
        this.f3659b = str;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.util.d<com.airbnb.lottie.d.a, java.io.InputStream> a() {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r5.f3659b     // Catch:{ FileNotFoundException -> 0x0048 }
            java.io.File r1 = r5.a((java.lang.String) r1)     // Catch:{ FileNotFoundException -> 0x0048 }
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r1)     // Catch:{  }
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = ".zip"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x001e
            com.airbnb.lottie.d.a r0 = com.airbnb.lottie.d.a.Zip
            goto L_0x0020
        L_0x001e:
            com.airbnb.lottie.d.a r0 = com.airbnb.lottie.d.a.Json
        L_0x0020:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cache hit for "
            r3.append(r4)
            java.lang.String r4 = r5.f3659b
            r3.append(r4)
            java.lang.String r4 = " at "
            r3.append(r4)
            java.lang.String r1 = r1.getAbsolutePath()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.airbnb.lottie.c.a(r1)
            androidx.core.util.d r1 = new androidx.core.util.d
            r1.<init>(r0, r2)
            return r1
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.d.b.a():androidx.core.util.d");
    }

    /* access modifiers changed from: package-private */
    public File a(InputStream inputStream, a aVar) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(this.f3658a.getCacheDir(), a(this.f3659b, aVar, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        File file = new File(this.f3658a.getCacheDir(), a(this.f3659b, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        c.a("Copying temp file to real file (" + file2 + SQLBuilder.PARENTHESES_RIGHT);
        if (!renameTo) {
            c.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    private File a(String str) throws FileNotFoundException {
        File file = new File(this.f3658a.getCacheDir(), a(str, a.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f3658a.getCacheDir(), a(str, a.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String a(String str, a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? aVar.extension : aVar.tempExtension());
        return sb.toString();
    }
}
