package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;

public final class zziu extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < zzoaArr.length - 1) {
            String zzd = zzha.zzd(zzoaArr[i]);
            zzog zzog = zzoaArr[i + 1];
            if (!(zzog instanceof zzog) || zzog == zzog.zzaul || zzog == zzog.zzaum) {
                hashMap.put(zzd, zzog);
                i += 2;
            } else {
                throw new IllegalStateException("Illegal InternalType found in CreateObject.");
            }
        }
        return new zzok(hashMap);
    }
}
