package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhn extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa<?> zzoa;
        int i;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
        zzoh zzoh = zzoaArr[0];
        zzof zzof = zzoaArr[1];
        List list = (List) zzoh.value();
        int size = list.size();
        if (zzoaArr.length == 3) {
            zzoa = zzoaArr[2];
            i = size - 1;
        } else {
            Preconditions.checkState(size > 0);
            int i2 = size - 1;
            zzoa<?> zzac = zzoh.zzac(i2);
            i = size - 2;
            while (true) {
                if (i2 < 0) {
                    break;
                } else if (zzoh.zzad(i2)) {
                    zzac = zzoh.zzac(i2);
                    i = i2 - 1;
                    break;
                } else {
                    i2--;
                }
            }
            Preconditions.checkState(i2 >= 0);
            zzoa = zzac;
        }
        while (i >= 0) {
            if (zzoh.zzad(i)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, zzoa, (zzoa) list.get(i), new zzoe(Double.valueOf((double) i)), zzoh);
            }
            i--;
        }
        return zzoa;
    }
}
