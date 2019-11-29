package com.google.b.a;

import com.google.b.a.i;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c f13583a = new c() {
        public InputStream a(String str) {
            return d.class.getResourceAsStream(str);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f13584b = Logger.getLogger(d.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, i.b> f13585c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap<String, i.b> f13586d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Set<Integer> f13587e = a.a();

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f13588f = k.a();

    private d() {
    }

    static <T> i.b a(T t, ConcurrentHashMap<T, i.b> concurrentHashMap, String str, c cVar) {
        i.b bVar = concurrentHashMap.get(t);
        if (bVar != null) {
            return bVar;
        }
        String str2 = str + "_" + t;
        List<i.b> a2 = a(str2, cVar);
        if (a2.size() > 1) {
            f13584b.log(Level.WARNING, "more than one metadata in file " + str2);
        }
        i.b bVar2 = a2.get(0);
        i.b putIfAbsent = concurrentHashMap.putIfAbsent(t, bVar2);
        return putIfAbsent != null ? putIfAbsent : bVar2;
    }

    private static List<i.b> a(String str, c cVar) {
        InputStream a2 = cVar.a(str);
        if (a2 != null) {
            List<i.b> a3 = a(a2).a();
            if (a3.size() != 0) {
                return a3;
            }
            throw new IllegalStateException("empty metadata: " + str);
        }
        throw new IllegalStateException("missing metadata: " + str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034 A[SYNTHETIC, Splitter:B:24:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0038 A[Catch:{ IOException -> 0x003c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.b.a.i.c a(java.io.InputStream r5) {
        /*
            java.lang.String r0 = "error closing input stream (ignored)"
            java.lang.String r1 = "cannot load/parse metadata"
            r2 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002b }
            r3.<init>(r5)     // Catch:{ IOException -> 0x002b }
            com.google.b.a.i$c r2 = new com.google.b.a.i$c     // Catch:{ all -> 0x0026 }
            r2.<init>()     // Catch:{ all -> 0x0026 }
            r2.readExternal(r3)     // Catch:{ IOException -> 0x001f }
            r3.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x001e
        L_0x0016:
            r5 = move-exception
            java.util.logging.Logger r1 = f13584b
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r1.log(r3, r0, r5)
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0026 }
            r4.<init>(r1, r2)     // Catch:{ all -> 0x0026 }
            throw r4     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            goto L_0x0032
        L_0x0028:
            r1 = move-exception
            r3 = r2
            goto L_0x0032
        L_0x002b:
            r3 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0028 }
            r4.<init>(r1, r3)     // Catch:{ all -> 0x0028 }
            throw r4     // Catch:{ all -> 0x0028 }
        L_0x0032:
            if (r3 == 0) goto L_0x0038
            r3.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0044
        L_0x0038:
            r5.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0044
        L_0x003c:
            r5 = move-exception
            java.util.logging.Logger r2 = f13584b
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r2.log(r3, r0, r5)
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.a.d.a(java.io.InputStream):com.google.b.a.i$c");
    }
}
