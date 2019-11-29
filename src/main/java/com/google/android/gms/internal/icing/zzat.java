package com.google.android.gms.internal.icing;

import android.util.Log;
import com.google.android.gms.common.api.Status;

final class zzat extends zzar {
    private final /* synthetic */ zzau zzbn;

    zzat(zzau zzau) {
        this.zzbn = zzau;
    }

    public final void zzb(Status status) {
        if (this.zzbn.zzbp) {
            Log.d("SearchAuth", "ClearTokenImpl success");
        }
        this.zzbn.setResult(status);
    }
}
