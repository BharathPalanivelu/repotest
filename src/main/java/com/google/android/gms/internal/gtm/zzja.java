package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzja extends zzhb {
    public static final zzja zzark = new zzja();

    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzoh zzoh = zzoaArr[0];
        zzoa<?> zzoa = zzoaArr[1];
        Preconditions.checkArgument(!zzoo.zzm(zzoh));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoa));
        String zzd = zzha.zzd(zzoa);
        if (zzoh instanceof zzoh) {
            if ("length".equals(zzd)) {
                return new zzod(true);
            }
            double zzb = zzha.zzb(zzoa);
            if (zzb == Math.floor(zzb)) {
                int i = (int) zzb;
                if (zzd.equals(Integer.toString(i)) && i >= 0 && i < ((List) zzoh.value()).size()) {
                    return new zzod(true);
                }
            }
        } else if (zzoh instanceof zzom) {
            if ("length".equals(zzd)) {
                return new zzod(true);
            }
            double zzb2 = zzha.zzb(zzoa);
            if (zzb2 == Math.floor(zzb2)) {
                int i2 = (int) zzb2;
                if (zzd.equals(Integer.toString(i2)) && i2 >= 0 && i2 < ((String) ((zzom) zzoh).value()).length()) {
                    return new zzod(true);
                }
            }
            return new zzod(false);
        }
        return new zzod(Boolean.valueOf(zzoh.zzcn(zzd)));
    }
}
