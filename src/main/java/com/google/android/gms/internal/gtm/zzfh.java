package com.google.android.gms.internal.gtm;

import android.os.RemoteException;
import java.util.Map;

final class zzfh implements zzkl {
    private final /* synthetic */ zzff zzapd;

    private zzfh(zzff zzff) {
        this.zzapd = zzff;
    }

    public final Object zza(String str, Map<String, Object> map) {
        try {
            this.zzapd.zzanh.zzb(str, map);
            return null;
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzev.zzav(valueOf.length() != 0 ? "Error calling customEvaluator proxy:".concat(valueOf) : new String("Error calling customEvaluator proxy:"));
            return null;
        }
    }

    /* synthetic */ zzfh(zzff zzff, zzfg zzfg) {
        this(zzff);
    }
}
