package com.google.android.gms.internal.p000firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfw  reason: invalid package */
final class zzfw implements zzft {
    zzfw() {
    }

    public final zzfr<?, ?> zzj(Object obj) {
        return ((zzfs) obj).zzic();
    }

    public final Map<?, ?> zzh(Object obj) {
        return (zzfu) obj;
    }

    public final Object zzi(Object obj) {
        ((zzfu) obj).zzgf();
        return obj;
    }

    public final Object zzd(Object obj, Object obj2) {
        zzfu zzfu = (zzfu) obj;
        zzfu zzfu2 = (zzfu) obj2;
        if (!zzfu2.isEmpty()) {
            if (!zzfu.isMutable()) {
                zzfu = zzfu.zzie();
            }
            zzfu.zza(zzfu2);
        }
        return zzfu;
    }

    public final int zzc(int i, Object obj, Object obj2) {
        zzfu zzfu = (zzfu) obj;
        zzfs zzfs = (zzfs) obj2;
        int i2 = 0;
        if (zzfu.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : zzfu.entrySet()) {
            i2 += zzfs.zzb(i, entry.getKey(), entry.getValue());
        }
        return i2;
    }
}
