package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public abstract class zzmd extends zzhb {
    /* access modifiers changed from: protected */
    public abstract boolean zza(double d2, double d3);

    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        try {
            double zzb = zzha.zzb(zzoaArr[0]);
            double zzb2 = zzha.zzb(zzoaArr[1]);
            if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
                return new zzod(false);
            }
            return new zzod(Boolean.valueOf(zza(zzb, zzb2)));
        } catch (IllegalArgumentException unused) {
            return new zzod(false);
        }
    }
}
