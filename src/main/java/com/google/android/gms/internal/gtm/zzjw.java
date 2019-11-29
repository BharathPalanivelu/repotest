package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjw extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        double d2;
        double d3;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) zzoaArr[0].value();
        double zzc = zzoaArr.length < 2 ? 0.0d : zzha.zzc(zzoaArr[1]);
        double length = (double) str.length();
        if (zzoaArr.length == 3 && zzoaArr[2] != zzog.zzaum) {
            length = zzha.zzc(zzoaArr[2]);
        }
        if (zzc < 0.0d) {
            double length2 = (double) str.length();
            Double.isNaN(length2);
            d2 = Math.max(length2 + zzc, 0.0d);
        } else {
            d2 = Math.min(zzc, (double) str.length());
        }
        int i = (int) d2;
        if (length < 0.0d) {
            double length3 = (double) str.length();
            Double.isNaN(length3);
            d3 = Math.max(length3 + length, 0.0d);
        } else {
            d3 = Math.min(length, (double) str.length());
        }
        return new zzom(str.substring(i, Math.max(0, ((int) d3) - i) + i));
    }
}
