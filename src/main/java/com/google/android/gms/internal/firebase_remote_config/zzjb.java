package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzjb {
    private static final zzjb zzwk = new zzjb();
    private final zzji zzwl = new zzid();
    private final ConcurrentMap<Class<?>, zzjf<?>> zzwm = new ConcurrentHashMap();

    public static zzjb zzii() {
        return zzwk;
    }

    public final <T> zzjf<T> zzk(Class<T> cls) {
        zzhm.zza(cls, "messageType");
        zzjf<T> zzjf = (zzjf) this.zzwm.get(cls);
        if (zzjf != null) {
            return zzjf;
        }
        zzjf<T> zzj = this.zzwl.zzj(cls);
        zzhm.zza(cls, "messageType");
        zzhm.zza(zzj, "schema");
        zzjf<T> putIfAbsent = this.zzwm.putIfAbsent(cls, zzj);
        return putIfAbsent != null ? putIfAbsent : zzj;
    }

    public final <T> zzjf<T> zzz(T t) {
        return zzk(t.getClass());
    }

    private zzjb() {
    }
}
