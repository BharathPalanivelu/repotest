package com.google.android.gms.internal.gtm;

import android.os.RemoteException;
import java.util.Map;

final class zzfi implements zzkl {
    private final /* synthetic */ zzff zzapd;

    private zzfi(zzff zzff) {
        this.zzapd = zzff;
    }

    public final Object zza(String str, Map<String, Object> map) {
        try {
            return this.zzapd.zzanh.zzc(str, map);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzev.zzav(valueOf.length() != 0 ? "Error calling customEvaluator proxy:".concat(valueOf) : new String("Error calling customEvaluator proxy:"));
            return null;
        }
    }

    /* synthetic */ zzfi(zzff zzff, zzfg zzfg) {
        this(zzff);
    }
}
