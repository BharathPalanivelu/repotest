package com.google.android.gms.tagmanager;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;

final class zzbg extends zzcn {
    private final /* synthetic */ AppMeasurement zzagp;

    zzbg(AppMeasurement appMeasurement) {
        this.zzagp = appMeasurement;
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzagp.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    public final Map<String, Object> zzib() {
        return this.zzagp.getUserProperties(true);
    }

    public final void zza(zzcj zzcj) {
        this.zzagp.setEventInterceptor(new zzbh(this, zzcj));
    }

    public final void zza(zzcg zzcg) {
        this.zzagp.registerOnMeasurementEventListener(new zzbi(this, zzcg));
    }
}
