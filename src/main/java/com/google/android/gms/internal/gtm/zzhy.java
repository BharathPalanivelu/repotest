package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzhy implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(zzoaArr != null);
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzoa<?> zza = zzoo.zza(zzfl, (zzoa) zzoaArr[0]);
        if (!zzha.zza(zza)) {
            return zza;
        }
        return zzoo.zza(zzfl, (zzoa) zzoaArr[1]);
    }
}
