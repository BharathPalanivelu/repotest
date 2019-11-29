package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzbh implements AppMeasurement.EventInterceptor {
    private final /* synthetic */ zzcj zzagq;

    zzbh(zzbg zzbg, zzcj zzcj) {
        this.zzagq = zzcj;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zzagq.interceptEvent(str, str2, bundle, j);
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
