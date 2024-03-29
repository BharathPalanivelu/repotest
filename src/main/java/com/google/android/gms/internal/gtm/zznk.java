package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zznk {
    private boolean closed;
    private String zzafk;
    private final ScheduledExecutorService zzaji;
    private ScheduledFuture<?> zzajk;

    public zznk() {
        this(zzdf.zzgp().zza(1, zzdi.zzadg));
    }

    @VisibleForTesting
    private zznk(ScheduledExecutorService scheduledExecutorService) {
        this.zzajk = null;
        this.zzafk = null;
        this.zzaji = scheduledExecutorService;
        this.closed = false;
    }

    public final void zza(Context context, zzmw zzmw, long j, zzmn zzmn) {
        synchronized (this) {
            if (this.zzajk != null) {
                this.zzajk.cancel(false);
            }
            this.zzajk = this.zzaji.schedule(new zznj(context, zzmw, zzmn), 0, TimeUnit.MILLISECONDS);
        }
    }
}
