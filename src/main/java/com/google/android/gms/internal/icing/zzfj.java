package com.google.android.gms.internal.icing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzfj {
    private static final zzfj zzna = new zzfj();
    private final zzfn zznb = new zzen();
    private final ConcurrentMap<Class<?>, zzfk<?>> zznc = new ConcurrentHashMap();

    public static zzfj zzcw() {
        return zzna;
    }

    public final <T> zzfk<T> zze(Class<T> cls) {
        zzdq.zza(cls, "messageType");
        zzfk<T> zzfk = (zzfk) this.zznc.get(cls);
        if (zzfk != null) {
            return zzfk;
        }
        zzfk<T> zzd = this.zznb.zzd(cls);
        zzdq.zza(cls, "messageType");
        zzdq.zza(zzd, "schema");
        zzfk<T> putIfAbsent = this.zznc.putIfAbsent(cls, zzd);
        return putIfAbsent != null ? putIfAbsent : zzd;
    }

    public final <T> zzfk<T> zzo(T t) {
        return zze(t.getClass());
    }

    private zzfj() {
    }
}
