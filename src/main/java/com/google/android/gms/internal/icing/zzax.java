package com.google.android.gms.internal.icing;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzax {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbs = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbt = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbu = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static final AtomicBoolean zzbv = new AtomicBoolean();
    private static HashMap<String, String> zzbw;
    private static final HashMap<String, Boolean> zzbx = new HashMap<>();
    private static final HashMap<String, Integer> zzby = new HashMap<>();
    private static final HashMap<String, Long> zzbz = new HashMap<>();
    private static final HashMap<String, Float> zzca = new HashMap<>();
    private static Object zzcb;
    private static boolean zzcc;
    private static String[] zzcd = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00aa, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        r10 = r10.query(CONTENT_URI, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r11}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bd, code lost:
        if (r10 != null) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bf, code lost:
        if (r10 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c4, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c9, code lost:
        if (r10.moveToFirst() != false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cb, code lost:
        zza(r0, r11, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r12 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d8, code lost:
        if (r12 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00de, code lost:
        if (r12.equals((java.lang.Object) null) == false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e0, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e1, code lost:
        zza(r0, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e4, code lost:
        if (r12 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e8, code lost:
        if (r10 == null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ea, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ed, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ee, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ef, code lost:
        if (r10 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f1, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f4, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.Class<com.google.android.gms.internal.icing.zzax> r12 = com.google.android.gms.internal.icing.zzax.class
            monitor-enter(r12)
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzbw     // Catch:{ all -> 0x00f5 }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002a
            java.util.concurrent.atomic.AtomicBoolean r0 = zzbv     // Catch:{ all -> 0x00f5 }
            r0.set(r2)     // Catch:{ all -> 0x00f5 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00f5 }
            r0.<init>()     // Catch:{ all -> 0x00f5 }
            zzbw = r0     // Catch:{ all -> 0x00f5 }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x00f5 }
            r0.<init>()     // Catch:{ all -> 0x00f5 }
            zzcb = r0     // Catch:{ all -> 0x00f5 }
            zzcc = r2     // Catch:{ all -> 0x00f5 }
            android.net.Uri r0 = CONTENT_URI     // Catch:{ all -> 0x00f5 }
            com.google.android.gms.internal.icing.zzba r4 = new com.google.android.gms.internal.icing.zzba     // Catch:{ all -> 0x00f5 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f5 }
            r10.registerContentObserver(r0, r1, r4)     // Catch:{ all -> 0x00f5 }
            goto L_0x0054
        L_0x002a:
            java.util.concurrent.atomic.AtomicBoolean r0 = zzbv     // Catch:{ all -> 0x00f5 }
            boolean r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x0054
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzbw     // Catch:{ all -> 0x00f5 }
            r0.clear()     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = zzbx     // Catch:{ all -> 0x00f5 }
            r0.clear()     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = zzby     // Catch:{ all -> 0x00f5 }
            r0.clear()     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.Long> r0 = zzbz     // Catch:{ all -> 0x00f5 }
            r0.clear()     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.Float> r0 = zzca     // Catch:{ all -> 0x00f5 }
            r0.clear()     // Catch:{ all -> 0x00f5 }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x00f5 }
            r0.<init>()     // Catch:{ all -> 0x00f5 }
            zzcb = r0     // Catch:{ all -> 0x00f5 }
            zzcc = r2     // Catch:{ all -> 0x00f5 }
        L_0x0054:
            java.lang.Object r0 = zzcb     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.String> r4 = zzbw     // Catch:{ all -> 0x00f5 }
            boolean r4 = r4.containsKey(r11)     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x006c
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzbw     // Catch:{ all -> 0x00f5 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f5 }
            if (r10 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r10 = r3
        L_0x006a:
            monitor-exit(r12)     // Catch:{ all -> 0x00f5 }
            return r10
        L_0x006c:
            java.lang.String[] r4 = zzcd     // Catch:{ all -> 0x00f5 }
            int r5 = r4.length     // Catch:{ all -> 0x00f5 }
            r6 = 0
        L_0x0070:
            if (r6 >= r5) goto L_0x00ae
            r7 = r4[r6]     // Catch:{ all -> 0x00f5 }
            boolean r7 = r11.startsWith(r7)     // Catch:{ all -> 0x00f5 }
            if (r7 == 0) goto L_0x00ab
            boolean r0 = zzcc     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x0086
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzbw     // Catch:{ all -> 0x00f5 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00f5 }
            if (r0 == 0) goto L_0x00a9
        L_0x0086:
            java.lang.String[] r0 = zzcd     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = zzbw     // Catch:{ all -> 0x00f5 }
            java.util.Map r10 = zza(r10, r0)     // Catch:{ all -> 0x00f5 }
            r2.putAll(r10)     // Catch:{ all -> 0x00f5 }
            zzcc = r1     // Catch:{ all -> 0x00f5 }
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzbw     // Catch:{ all -> 0x00f5 }
            boolean r10 = r10.containsKey(r11)     // Catch:{ all -> 0x00f5 }
            if (r10 == 0) goto L_0x00a9
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzbw     // Catch:{ all -> 0x00f5 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x00f5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00f5 }
            if (r10 == 0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r10 = r3
        L_0x00a7:
            monitor-exit(r12)     // Catch:{ all -> 0x00f5 }
            return r10
        L_0x00a9:
            monitor-exit(r12)     // Catch:{ all -> 0x00f5 }
            return r3
        L_0x00ab:
            int r6 = r6 + 1
            goto L_0x0070
        L_0x00ae:
            monitor-exit(r12)     // Catch:{ all -> 0x00f5 }
            android.net.Uri r5 = CONTENT_URI
            r6 = 0
            r7 = 0
            java.lang.String[] r8 = new java.lang.String[r1]
            r8[r2] = r11
            r9 = 0
            r4 = r10
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)
            if (r10 != 0) goto L_0x00c5
            if (r10 == 0) goto L_0x00c4
            r10.close()
        L_0x00c4:
            return r3
        L_0x00c5:
            boolean r12 = r10.moveToFirst()     // Catch:{ all -> 0x00ee }
            if (r12 != 0) goto L_0x00d4
            zza((java.lang.Object) r0, (java.lang.String) r11, (java.lang.String) r3)     // Catch:{ all -> 0x00ee }
            if (r10 == 0) goto L_0x00d3
            r10.close()
        L_0x00d3:
            return r3
        L_0x00d4:
            java.lang.String r12 = r10.getString(r1)     // Catch:{ all -> 0x00ee }
            if (r12 == 0) goto L_0x00e1
            boolean r1 = r12.equals(r3)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00e1
            r12 = r3
        L_0x00e1:
            zza((java.lang.Object) r0, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x00ee }
            if (r12 == 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r12 = r3
        L_0x00e8:
            if (r10 == 0) goto L_0x00ed
            r10.close()
        L_0x00ed:
            return r12
        L_0x00ee:
            r11 = move-exception
            if (r10 == 0) goto L_0x00f4
            r10.close()
        L_0x00f4:
            throw r11
        L_0x00f5:
            r10 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00f5 }
            goto L_0x00f9
        L_0x00f8:
            throw r10
        L_0x00f9:
            goto L_0x00f8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzax.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzax.class) {
            if (obj == zzcb) {
                zzbw.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbs, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
