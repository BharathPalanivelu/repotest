package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzab  reason: invalid package */
final class zzab extends zzr<Map.Entry<K, V>> {
    private final /* synthetic */ zzac zzaf;

    zzab(zzac zzac) {
        this.zzaf = zzac;
    }

    public final int size() {
        return this.zzaf.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzf.zza(i, this.zzaf.size);
        Object[] zzb = this.zzaf.zzz;
        int i2 = i * 2;
        zzac zzac = this.zzaf;
        Object obj = zzb[i2];
        Object[] zzb2 = zzac.zzz;
        zzac zzac2 = this.zzaf;
        return new AbstractMap.SimpleImmutableEntry(obj, zzb2[i2 + 1]);
    }
}
