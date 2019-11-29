package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzkp implements zzgz {
    private final zzdl zzarm;

    public zzkp(Context context) {
        this(zzdl.zzo(context));
    }

    @VisibleForTesting
    private zzkp(zzdl zzdl) {
        this.zzarm = zzdl;
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        String zzgq = this.zzarm.zzgq();
        return zzgq == null ? zzog.zzaum : new zzom(zzgq);
    }
}
