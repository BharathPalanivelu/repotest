package com.google.android.gms.internal.p000firebaseperf;

import java.io.Serializable;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzk  reason: invalid package */
public final class zzk {
    public static <T> zzh<T> zza(zzh<T> zzh) {
        if ((zzh instanceof zzm) || (zzh instanceof zzj)) {
            return zzh;
        }
        if (zzh instanceof Serializable) {
            return new zzj(zzh);
        }
        return new zzm(zzh);
    }
}
