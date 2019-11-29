package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzji implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (zzom zzom : zzoaArr) {
            Preconditions.checkNotNull(zzom);
            Preconditions.checkArgument(zzom instanceof zzom);
            zzfl.zza((String) zzom.value(), zzog.zzaum);
        }
        return zzog.zzaum;
    }
}
