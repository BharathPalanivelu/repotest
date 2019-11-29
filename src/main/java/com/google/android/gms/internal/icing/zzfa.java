package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzfa<T> implements zzfk<T> {
    private final zzex zzme;
    private final zzgc<?, ?> zzmf;
    private final boolean zzmg;
    private final zzde<?> zzmh;

    private zzfa(zzgc<?, ?> zzgc, zzde<?> zzde, zzex zzex) {
        this.zzmf = zzgc;
        this.zzmg = zzde.zze(zzex);
        this.zzmh = zzde;
        this.zzme = zzex;
    }

    static <T> zzfa<T> zza(zzgc<?, ?> zzgc, zzde<?> zzde, zzex zzex) {
        return new zzfa<>(zzgc, zzde, zzex);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzmf.zzp(t).equals(this.zzmf.zzp(t2))) {
            return false;
        }
        if (this.zzmg) {
            return this.zzmh.zzd(t).equals(this.zzmh.zzd(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzmf.zzp(t).hashCode();
        return this.zzmg ? (hashCode * 53) + this.zzmh.zzd(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzfm.zza(this.zzmf, t, t2);
        if (this.zzmg) {
            zzfm.zza(this.zzmh, t, t2);
        }
    }

    public final void zza(T t, zzgw zzgw) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzmh.zzd(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzdl zzdl = (zzdl) next.getKey();
            if (zzdl.zzbh() != zzgx.MESSAGE || zzdl.zzbi() || zzdl.zzbj()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzed) {
                zzgw.zza(zzdl.zzbf(), (Object) ((zzed) next).zzcc().zzab());
            } else {
                zzgw.zza(zzdl.zzbf(), next.getValue());
            }
        }
        zzgc<?, ?> zzgc = this.zzmf;
        zzgc.zzc(zzgc.zzp(t), zzgw);
    }

    public final void zzf(T t) {
        this.zzmf.zzf(t);
        this.zzmh.zzf(t);
    }

    public final boolean zzm(T t) {
        return this.zzmh.zzd(t).isInitialized();
    }

    public final int zzn(T t) {
        zzgc<?, ?> zzgc = this.zzmf;
        int zzq = zzgc.zzq(zzgc.zzp(t)) + 0;
        return this.zzmg ? zzq + this.zzmh.zzd(t).zzbe() : zzq;
    }
}
