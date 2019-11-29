package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzjd implements zzgz {
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(zzoaArr != null);
        ArrayList arrayList = new ArrayList(zzoaArr.length);
        for (zzoa<?> add : zzoaArr) {
            arrayList.add(add);
        }
        return new zzoh(arrayList);
    }
}
