package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzdf {
    private static volatile boolean zzgs = false;
    private static final Class<?> zzgt = zzay();
    private static volatile zzdf zzgu;
    static final zzdf zzgv = new zzdf(true);
    private final Map<Object, Object> zzgw;

    private static Class<?> zzay() {
        try {
            return Class.forName("com.google.c.l");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdf zzaz() {
        zzdf zzdf = zzgu;
        if (zzdf == null) {
            synchronized (zzdf.class) {
                zzdf = zzgu;
                if (zzdf == null) {
                    zzdf = zzdc.zzaw();
                    zzgu = zzdf;
                }
            }
        }
        return zzdf;
    }

    zzdf() {
        this.zzgw = new HashMap();
    }

    private zzdf(boolean z) {
        this.zzgw = Collections.emptyMap();
    }
}
