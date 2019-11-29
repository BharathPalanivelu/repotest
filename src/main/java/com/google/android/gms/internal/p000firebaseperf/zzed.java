package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzed  reason: invalid package */
final class zzed {
    private static final Class<?> zznj = zzgr();

    private static Class<?> zzgr() {
        try {
            return Class.forName("com.google.c.n");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzeg zzgs() {
        Class<?> cls = zznj;
        if (cls != null) {
            try {
                return (zzeg) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzeg.zznn;
    }
}
