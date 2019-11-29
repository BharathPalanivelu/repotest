package com.google.android.gms.internal.p000firebaseperf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzeg  reason: invalid package */
public class zzeg {
    private static volatile boolean zznk = false;
    private static final Class<?> zznl = zzgu();
    private static volatile zzeg zznm;
    static final zzeg zznn = new zzeg(true);
    private final Map<Object, Object> zzno;

    private static Class<?> zzgu() {
        try {
            return Class.forName("com.google.c.l");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzeg zzgv() {
        zzeg zzeg = zznm;
        if (zzeg == null) {
            synchronized (zzeg.class) {
                zzeg = zznm;
                if (zzeg == null) {
                    zzeg = zzed.zzgs();
                    zznm = zzeg;
                }
            }
        }
        return zzeg;
    }

    zzeg() {
        this.zzno = new HashMap();
    }

    private zzeg(boolean z) {
        this.zzno = Collections.emptyMap();
    }
}
