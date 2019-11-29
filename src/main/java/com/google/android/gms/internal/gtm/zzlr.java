package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlr extends zzhb {
    private static final zzoe zzarv = new zzoe(Double.valueOf(0.0d));
    private static final zzoe zzarw = new zzoe(Double.valueOf(2.147483647E9d));

    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        double d2;
        double d3;
        Preconditions.checkArgument(true);
        zzoe zzoe = zzoaArr.length > 0 ? zzoaArr[0] : zzarv;
        zzoe zzoe2 = zzoaArr.length > 1 ? zzoaArr[1] : zzarw;
        if (!zzg(zzoe) || !zzg(zzoe2) || !zzha.zzb(zzoe, zzoe2)) {
            d3 = 0.0d;
            d2 = 2.147483647E9d;
        } else {
            d3 = ((Double) zzoe.value()).doubleValue();
            d2 = ((Double) zzoe2.value()).doubleValue();
        }
        return new zzoe(Double.valueOf((double) Math.round((Math.random() * (d2 - d3)) + d3)));
    }

    private static boolean zzg(zzoa<?> zzoa) {
        return (zzoa instanceof zzoe) && !Double.isNaN(((Double) ((zzoe) zzoa).value()).doubleValue());
    }
}
