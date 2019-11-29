package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjl extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa<?>[] zzoaArr2 = zzoaArr;
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr2.length == 2);
        double zzb = zzha.zzb(zzoaArr2[0]);
        double zzb2 = zzha.zzb(zzoaArr2[1]);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        boolean z2 = ((double) Double.compare(zzb, 0.0d)) < 0.0d;
        if (((double) Double.compare(zzb2, 0.0d)) >= 0.0d) {
            z = false;
        }
        boolean z3 = z2 ^ z;
        double d2 = Double.NEGATIVE_INFINITY;
        if (!Double.isInfinite(zzb) || Double.isInfinite(zzb2)) {
            double d3 = -0.0d;
            if (!Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
                if (!z3) {
                    d3 = 0.0d;
                }
                return new zzoe(Double.valueOf(d3));
            } else if (zzb == 0.0d) {
                if (zzb2 == 0.0d) {
                    return new zzoe(Double.valueOf(Double.NaN));
                }
                if (!z3) {
                    d3 = 0.0d;
                }
                return new zzoe(Double.valueOf(d3));
            } else if (Double.isInfinite(zzb) || zzb == 0.0d || zzb2 != 0.0d) {
                return new zzoe(Double.valueOf(zzb / zzb2));
            } else {
                if (!z3) {
                    d2 = Double.POSITIVE_INFINITY;
                }
                return new zzoe(Double.valueOf(d2));
            }
        } else {
            if (!z3) {
                d2 = Double.POSITIVE_INFINITY;
            }
            return new zzoe(Double.valueOf(d2));
        }
    }
}
