package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjr extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        return new zzoe(Double.valueOf((double) str.indexOf(zzha.zzd(zzoaArr[1]), (int) Math.min(Math.max(zzoaArr.length < 3 ? 0.0d : zzha.zzc(zzoaArr[2]), 0.0d), (double) str.length()))));
    }
}
