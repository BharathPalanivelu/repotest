package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzif extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        boolean z = false;
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzom zzom = zzoaArr[0];
        zzom zzom2 = zzoaArr[1];
        if ((zzom instanceof zzok) || (zzom instanceof zzoh) || (zzom instanceof zzof)) {
            zzom = new zzom(zzha.zzd(zzom));
        }
        if ((zzom2 instanceof zzok) || (zzom2 instanceof zzoh) || (zzom2 instanceof zzof)) {
            zzom2 = new zzom(zzha.zzd(zzom2));
        }
        if ((((zzom instanceof zzom) && (zzom2 instanceof zzom)) || (!Double.isNaN(zzha.zzb(zzom)) && !Double.isNaN(zzha.zzb(zzom2)))) && !zzha.zzb(zzom2, zzom)) {
            z = true;
        }
        return new zzod(Boolean.valueOf(z));
    }
}
