package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhc extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        ArrayList arrayList = new ArrayList();
        for (zzoa add : (List) zzoaArr[0].value()) {
            arrayList.add(add);
        }
        for (int i = 1; i < zzoaArr.length; i++) {
            if (zzoaArr[i] instanceof zzoh) {
                for (zzoa add2 : (List) zzoaArr[i].value()) {
                    arrayList.add(add2);
                }
            } else {
                arrayList.add(zzoaArr[i]);
            }
        }
        return new zzoh(arrayList);
    }
}
