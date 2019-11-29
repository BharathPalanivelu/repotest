package com.google.android.gms.internal.p000firebaseperf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgm  reason: invalid package */
final class zzgm {
    private static final zzgm zztv = new zzgm();
    private final zzgq zztw = new zzfn();
    private final ConcurrentMap<Class<?>, zzgn<?>> zztx = new ConcurrentHashMap();

    public static zzgm zzir() {
        return zztv;
    }

    public final <T> zzgn<T> zze(Class<T> cls) {
        zzer.zza(cls, "messageType");
        zzgn<T> zzgn = (zzgn) this.zztx.get(cls);
        if (zzgn != null) {
            return zzgn;
        }
        zzgn<T> zzd = this.zztw.zzd(cls);
        zzer.zza(cls, "messageType");
        zzer.zza(zzd, "schema");
        zzgn<T> putIfAbsent = this.zztx.putIfAbsent(cls, zzd);
        return putIfAbsent != null ? putIfAbsent : zzd;
    }

    public final <T> zzgn<T> zzn(T t) {
        return zze(t.getClass());
    }

    private zzgm() {
    }
}
