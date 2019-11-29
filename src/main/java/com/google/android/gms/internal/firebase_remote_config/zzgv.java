package com.google.android.gms.internal.firebase_remote_config;

final class zzgv {
    private static final Class<?> zzpz = zzge();

    private static Class<?> zzge() {
        try {
            return Class.forName("com.google.c.n");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzgx zzgf() {
        Class<?> cls = zzpz;
        if (cls != null) {
            try {
                return (zzgx) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzgx.zzqd;
    }
}
