package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhh extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        List<zzoa> list = (List) zzoaArr[0].value();
        zzog zzog = zzoaArr.length < 2 ? zzog.zzaum : zzoaArr[1];
        if (zzog == zzog.zzaum) {
            str = ",";
        } else {
            str = zzha.zzd(zzog);
        }
        ArrayList arrayList = new ArrayList();
        for (zzoa zzoa : list) {
            if (zzoa == zzog.zzaul || zzoa == zzog.zzaum) {
                arrayList.add("");
            } else {
                arrayList.add(zzha.zzd(zzoa));
            }
        }
        return new zzom(TextUtils.join(str, arrayList));
    }
}
