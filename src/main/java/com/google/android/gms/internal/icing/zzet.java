package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class zzet implements zzeq {
    zzet() {
    }

    public final zzeo<?, ?> zzk(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzi(Object obj) {
        return (zzer) obj;
    }

    public final Object zzj(Object obj) {
        ((zzer) obj).zzah();
        return obj;
    }

    public final Object zzb(Object obj, Object obj2) {
        zzer zzer = (zzer) obj;
        zzer zzer2 = (zzer) obj2;
        if (!zzer2.isEmpty()) {
            if (!zzer.isMutable()) {
                zzer = zzer.zzcj();
            }
            zzer.zza(zzer2);
        }
        return zzer;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzer zzer = (zzer) obj;
        if (zzer.isEmpty()) {
            return 0;
        }
        Iterator it = zzer.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
