package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
public final class zzdq {
    /* access modifiers changed from: private */
    public volatile int state = 1;
    /* access modifiers changed from: private */
    public final String zzaec;
    private ScheduledFuture<?> zzajk = null;
    /* access modifiers changed from: private */
    public final String zzamr;
    /* access modifiers changed from: private */
    public final String zzams;
    /* access modifiers changed from: private */
    public final zzfk zzamt;
    /* access modifiers changed from: private */
    public final zzmo zzamu;
    /* access modifiers changed from: private */
    public final ExecutorService zzamv;
    private final ScheduledExecutorService zzamw;
    /* access modifiers changed from: private */
    public final zzcm zzamx;
    /* access modifiers changed from: private */
    public final zzdz zzamy;
    /* access modifiers changed from: private */
    public zzff zzamz;
    /* access modifiers changed from: private */
    public List<zzee> zzana = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzanb = false;
    /* access modifiers changed from: private */
    public final Context zzrm;
    /* access modifiers changed from: private */
    public final Clock zzsd;

    zzdq(Context context, String str, String str2, String str3, zzfk zzfk, zzmo zzmo, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzcm zzcm, Clock clock, zzdz zzdz) {
        this.zzrm = context;
        this.zzaec = (String) Preconditions.checkNotNull(str);
        this.zzamt = (zzfk) Preconditions.checkNotNull(zzfk);
        this.zzamu = (zzmo) Preconditions.checkNotNull(zzmo);
        this.zzamv = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzamw = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        this.zzamx = (zzcm) Preconditions.checkNotNull(zzcm);
        this.zzsd = (Clock) Preconditions.checkNotNull(clock);
        this.zzamy = (zzdz) Preconditions.checkNotNull(zzdz);
        this.zzamr = str3;
        this.zzams = str2;
        this.zzana.add(new zzee("gtm.load", new Bundle(), "gtm", new Date(), false, this.zzamx));
        String str4 = this.zzaec;
        StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 35);
        sb.append("Container ");
        sb.append(str4);
        sb.append("is scheduled for loading.");
        zzev.zzab(sb.toString());
        this.zzamv.execute(new zzdu(this, (zzdr) null));
    }

    @VisibleForTesting
    public final void zza(zzee zzee) {
        this.zzamv.execute(new zzdv(this, zzee));
    }

    public final void dispatch() {
        this.zzamv.execute(new zzdr(this));
    }

    /* access modifiers changed from: private */
    public final void zzn(long j) {
        ScheduledFuture<?> scheduledFuture = this.zzajk;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        String str = this.zzaec;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45);
        sb.append("Refresh container ");
        sb.append(str);
        sb.append(" in ");
        sb.append(j);
        sb.append("ms.");
        zzev.zzab(sb.toString());
        this.zzajk = this.zzamw.schedule(new zzds(this), j, TimeUnit.MILLISECONDS);
    }
}
