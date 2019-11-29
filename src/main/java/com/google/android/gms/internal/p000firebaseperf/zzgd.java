package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgd  reason: invalid package */
final class zzgd<T> implements zzgn<T> {
    private final zzga zzsz;
    private final zzhf<?, ?> zzta;
    private final boolean zztb;
    private final zzef<?> zztc;

    private zzgd(zzhf<?, ?> zzhf, zzef<?> zzef, zzga zzga) {
        this.zzta = zzhf;
        this.zztb = zzef.zze(zzga);
        this.zztc = zzef;
        this.zzsz = zzga;
    }

    static <T> zzgd<T> zza(zzhf<?, ?> zzhf, zzef<?> zzef, zzga zzga) {
        return new zzgd<>(zzhf, zzef, zzga);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzta.zzo(t).equals(this.zzta.zzo(t2))) {
            return false;
        }
        if (this.zztb) {
            return this.zztc.zzc(t).equals(this.zztc.zzc(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzta.zzo(t).hashCode();
        return this.zztb ? (hashCode * 53) + this.zztc.zzc(t).hashCode() : hashCode;
    }

    public final void zze(T t, T t2) {
        zzgp.zza(this.zzta, t, t2);
        if (this.zztb) {
            zzgp.zza(this.zztc, t, t2);
        }
    }

    public final void zza(T t, zzhz zzhz) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zztc.zzc(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzem zzem = (zzem) next.getKey();
            if (zzem.zzhc() != zzia.MESSAGE || zzem.zzhd() || zzem.zzhe()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfd) {
                zzhz.zza(zzem.zzdj(), (Object) ((zzfd) next).zzhw().zzfz());
            } else {
                zzhz.zza(zzem.zzdj(), next.getValue());
            }
        }
        zzhf<?, ?> zzhf = this.zzta;
        zzhf.zzc(zzhf.zzo(t), zzhz);
    }

    public final void zze(T t) {
        this.zzta.zze(t);
        this.zztc.zze((Object) t);
    }

    public final boolean zzl(T t) {
        return this.zztc.zzc(t).isInitialized();
    }

    public final int zzm(T t) {
        zzhf<?, ?> zzhf = this.zzta;
        int zzp = zzhf.zzp(zzhf.zzo(t)) + 0;
        return this.zztb ? zzp + this.zztc.zzc(t).zzha() : zzp;
    }
}
