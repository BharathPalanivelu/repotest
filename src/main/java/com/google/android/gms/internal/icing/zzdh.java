package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;
import java.io.IOException;
import java.util.Map;

final class zzdh extends zzde<Object> {
    zzdh() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzex zzex) {
        return zzex instanceof zzdo.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzdj<Object> zzd(Object obj) {
        return ((zzdo.zzd) obj).zzko;
    }

    /* access modifiers changed from: package-private */
    public final zzdj<Object> zze(Object obj) {
        zzdo.zzd zzd = (zzdo.zzd) obj;
        if (zzd.zzko.isImmutable()) {
            zzd.zzko = (zzdj) zzd.zzko.clone();
        }
        return zzd.zzko;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        zzd(obj).zzah();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgw zzgw, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }
}
