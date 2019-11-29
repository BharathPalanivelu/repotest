package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkw implements zzgz {
    private final Context zzrm;

    public zzkw(Context context) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        TelephonyManager telephonyManager = (TelephonyManager) this.zzrm.getSystemService("phone");
        zzog zzog = zzog.zzaum;
        if (telephonyManager == null) {
            return zzog;
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        return networkOperatorName != null ? new zzom(networkOperatorName) : zzog;
    }
}
