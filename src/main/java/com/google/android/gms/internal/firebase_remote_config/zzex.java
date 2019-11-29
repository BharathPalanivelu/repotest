package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class zzex {
    private static final Map<String, zzex> zzkg = new HashMap();
    private final Context zzja;
    private final String zzlq;

    private zzex(Context context, String str) {
        this.zzja = context;
        this.zzlq = str;
    }

    public final synchronized Void zzh(zzen zzen) throws IOException {
        Throwable th;
        FileOutputStream openFileOutput = this.zzja.openFileOutput(this.zzlq, 0);
        try {
            openFileOutput.write(zzen.toString().getBytes("UTF-8"));
            if (openFileOutput != null) {
                zza((Throwable) null, openFileOutput);
            }
        } catch (Throwable th2) {
            if (openFileOutput != null) {
                zza(th, openFileOutput);
            }
            throw th2;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r5 = r3;
        r3 = r2;
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.firebase_remote_config.zzen zzdb() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.content.Context r1 = r6.zzja     // Catch:{ FileNotFoundException | JSONException -> 0x003e, all -> 0x003b }
            java.lang.String r2 = r6.zzlq     // Catch:{ FileNotFoundException | JSONException -> 0x003e, all -> 0x003b }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x003e, all -> 0x003b }
            int r2 = r1.available()     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            r3 = 0
            int r4 = r2.length     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            r1.read(r2, r3, r4)     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            com.google.android.gms.internal.firebase_remote_config.zzen r2 = com.google.android.gms.internal.firebase_remote_config.zzen.zza(r2)     // Catch:{ Throwable -> 0x002f, all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            zza((java.lang.Throwable) r0, (java.io.FileInputStream) r1)     // Catch:{ FileNotFoundException | JSONException -> 0x003e, all -> 0x003b }
        L_0x002a:
            monitor-exit(r6)
            return r2
        L_0x002c:
            r2 = move-exception
            r3 = r0
            goto L_0x0035
        L_0x002f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L_0x0035:
            if (r1 == 0) goto L_0x003a
            zza((java.lang.Throwable) r3, (java.io.FileInputStream) r1)     // Catch:{ FileNotFoundException | JSONException -> 0x003e, all -> 0x003b }
        L_0x003a:
            throw r2     // Catch:{ FileNotFoundException | JSONException -> 0x003e, all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x003e:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzex.zzdb():com.google.android.gms.internal.firebase_remote_config.zzen");
    }

    public final synchronized Void zzdc() {
        this.zzja.deleteFile(this.zzlq);
        return null;
    }

    public static synchronized zzex zzb(Context context, String str) {
        zzex zzex;
        synchronized (zzex.class) {
            if (!zzkg.containsKey(str)) {
                zzkg.put(str, new zzex(context, str));
            }
            zzex = zzkg.get(str);
        }
        return zzex;
    }

    /* access modifiers changed from: package-private */
    public final String getFileName() {
        return this.zzlq;
    }

    private static /* synthetic */ void zza(Throwable th, FileOutputStream fileOutputStream) {
        if (th != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                zzea.zza(th, th2);
            }
        } else {
            fileOutputStream.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzea.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}
