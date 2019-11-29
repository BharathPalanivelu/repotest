package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdj  reason: invalid package */
final class zzdj {
    private static final Class<?> zzmq = zzaf("libcore.io.Memory");
    private static final boolean zzmr = (zzaf("org.robolectric.Robolectric") != null);

    static boolean zzgc() {
        return zzmq != null && !zzmr;
    }

    static Class<?> zzgd() {
        return zzmq;
    }

    private static <T> Class<T> zzaf(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
