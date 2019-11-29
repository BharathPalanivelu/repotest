package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjf extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 3);
        zzok zzok = zzoaArr[0];
        zzoa<?> zzoa = zzoaArr[1];
        zzoa<?> zzoa2 = zzoaArr[2];
        Preconditions.checkArgument(zzok != zzog.zzaul);
        Preconditions.checkArgument(zzok != zzog.zzaum);
        Preconditions.checkArgument(!zzoo.zzm(zzok));
        Preconditions.checkArgument(!zzoo.zzm(zzoa));
        Preconditions.checkArgument(!zzoo.zzm(zzoa2));
        if (zzoo.zzl(zzok)) {
            return zzoa2;
        }
        String zzd = zzha.zzd(zzoa);
        if (zzok instanceof zzok) {
            zzok zzok2 = zzok;
            if (!zzok2.isImmutable()) {
                zzok2.zzc(zzd, zzoa2);
            }
            return zzoa2;
        }
        if (zzok instanceof zzoh) {
            zzoh zzoh = (zzoh) zzok;
            if ("length".equals(zzd)) {
                double zzb = zzha.zzb(zzoa2);
                if (Double.isInfinite(zzb) || zzb != Math.floor(zzb)) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                zzoh.setSize((int) zzb);
                return zzoa2;
            }
            double zzb2 = zzha.zzb(zzoa);
            if (!Double.isInfinite(zzb2) && zzb2 >= 0.0d) {
                int i = (int) zzb2;
                if (zzd.equals(Integer.toString(i))) {
                    zzoh.zza(i, zzoa2);
                    return zzoa2;
                }
            }
        }
        zzok.zzc(zzd, zzoa2);
        return zzoa2;
    }
}
