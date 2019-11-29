package com.google.android.gms.internal.icing;

final class zzdc {
    private static final Class<?> zzgp = zzav();

    private static Class<?> zzav() {
        try {
            return Class.forName("com.google.c.n");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdf zzaw() {
        Class<?> cls = zzgp;
        if (cls != null) {
            try {
                return (zzdf) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzdf.zzgv;
    }
}
