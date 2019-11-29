package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzit extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        ArrayList arrayList = new ArrayList();
        int length = zzoaArr.length;
        for (int i = 0; i < length; i++) {
            zzog zzog = zzoaArr[i];
            Preconditions.checkArgument(!(zzog instanceof zzog) || zzog == zzog.zzaum || zzog == zzog.zzaul);
            arrayList.add(zzog);
        }
        return new zzoh(arrayList);
    }
}
