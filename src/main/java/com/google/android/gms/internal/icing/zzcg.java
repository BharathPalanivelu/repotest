package com.google.android.gms.internal.icing;

final class zzcg {
    private static final Class<?> zzfs = zzo("libcore.io.Memory");
    private static final boolean zzft = (zzo("org.robolectric.Robolectric") != null);

    static boolean zzae() {
        return zzfs != null && !zzft;
    }

    static Class<?> zzaf() {
        return zzfs;
    }

    private static <T> Class<T> zzo(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
