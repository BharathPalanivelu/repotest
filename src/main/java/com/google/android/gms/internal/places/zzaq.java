package com.google.android.gms.internal.places;

final class zzaq {
    private static final Class<?> zzfe = zzap();

    private static Class<?> zzap() {
        try {
            return Class.forName("com.google.c.n");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzap zzaq() {
        Class<?> cls = zzfe;
        if (cls != null) {
            try {
                return (zzap) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzap.zzfc;
    }
}
