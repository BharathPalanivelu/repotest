package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zze;
import com.google.android.gms.internal.measurement.zzf;

public final class zzex implements ServiceConnection {
    /* access modifiers changed from: private */
    public final String packageName;
    final /* synthetic */ zzeu zzmt;

    zzex(zzeu zzeu, String str) {
        this.zzmt = zzeu;
        this.packageName = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zzmt.zzj.zzab().zzgn().zzao("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzf zza = zze.zza(iBinder);
            if (zza == null) {
                this.zzmt.zzj.zzab().zzgn().zzao("Install Referrer Service implementation was not found");
                return;
            }
            this.zzmt.zzj.zzab().zzgq().zzao("Install Referrer Service connected");
            this.zzmt.zzj.zzaa().zza((Runnable) new zzew(this, zza, this));
        } catch (Exception e2) {
            this.zzmt.zzj.zzab().zzgn().zza("Exception occurred while calling Install Referrer API", e2);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzmt.zzj.zzab().zzgq().zzao("Install Referrer Service disconnected");
    }
}
