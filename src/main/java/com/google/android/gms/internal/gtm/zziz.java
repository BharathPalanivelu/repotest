package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zziz extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        boolean z = false;
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzoh zzoh = zzoaArr[0];
        zzoa<?> zzoa = zzoaArr[1];
        boolean z2 = zzoh instanceof zzom;
        if (z2 || !zzoo.zzl(zzoh)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(!zzoo.zzm(zzoh));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoa));
        String zzd = zzha.zzd(zzoa);
        if (zzoh instanceof zzoh) {
            zzoh zzoh2 = zzoh;
            if ("length".equals(zzd)) {
                return new zzoe(Double.valueOf((double) ((List) zzoh2.value()).size()));
            }
            double zzb = zzha.zzb(zzoa);
            if (zzb == Math.floor(zzb)) {
                int i = (int) zzb;
                if (zzd.equals(Integer.toString(i))) {
                    zzoa<?> zzac = zzoh2.zzac(i);
                    if (zzac != zzog.zzaum) {
                        return zzac;
                    }
                }
            }
        } else if (z2) {
            zzom zzom = (zzom) zzoh;
            if ("length".equals(zzd)) {
                return new zzoe(Double.valueOf((double) ((String) zzom.value()).length()));
            }
            double zzb2 = zzha.zzb(zzoa);
            if (zzb2 == Math.floor(zzb2)) {
                int i2 = (int) zzb2;
                if (zzd.equals(Integer.toString(i2))) {
                    return zzom.zzae(i2);
                }
            }
            return zzog.zzaum;
        }
        return zzoh.zzco(zzd);
    }
}
