package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjo extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        return new zzoe(Double.valueOf(zzha.zza(zzoaArr[0], new zzoe(Double.valueOf(zzha.zzb(zzoaArr[1]) * -1.0d)))));
    }
}
