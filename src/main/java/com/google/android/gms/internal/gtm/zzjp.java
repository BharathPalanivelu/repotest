package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjp extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        int i = 0;
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        if (zzoaArr.length == 2) {
            i = (int) zzha.zzc(zzoaArr[1]);
        }
        if (i < 0 || i >= str.length()) {
            return new zzom("");
        }
        return new zzom(String.valueOf(str.charAt(i)));
    }
}
