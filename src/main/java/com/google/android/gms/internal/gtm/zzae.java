package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzae extends zzan {
    /* access modifiers changed from: private */
    public final zzbb zzvu;

    public zzae(zzap zzap, zzar zzar) {
        super(zzap);
        Preconditions.checkNotNull(zzar);
        this.zzvu = new zzbb(zzap, zzar);
    }

    /* access modifiers changed from: protected */
    public final void zzaw() {
        this.zzvu.zzag();
    }

    public final void start() {
        this.zzvu.start();
    }

    public final void setLocalDispatchPeriod(int i) {
        zzdb();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zzcq().zza((Runnable) new zzaf(this, i));
    }

    public final long zza(zzas zzas) {
        zzdb();
        Preconditions.checkNotNull(zzas);
        zzk.zzav();
        long zza = this.zzvu.zza(zzas, true);
        if (zza == 0) {
            this.zzvu.zzb(zzas);
        }
        return zza;
    }

    public final void zza(zzcd zzcd) {
        Preconditions.checkNotNull(zzcd);
        zzdb();
        zzb("Hit delivery requested", zzcd);
        zzcq().zza((Runnable) new zzai(this, zzcd));
    }

    public final void zzch() {
        zzdb();
        zzcq().zza((Runnable) new zzaj(this));
    }

    public final void zza(zzbw zzbw) {
        zzdb();
        zzcq().zza((Runnable) new zzak(this, zzbw));
    }

    public final void zzci() {
        zzdb();
        Context context = getContext();
        if (!zzcp.zza(context) || !zzcq.zze(context)) {
            zza((zzbw) null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
        context.startService(intent);
    }

    public final boolean zzcj() {
        zzdb();
        try {
            zzcq().zza(new zzal(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e2) {
            zzd("syncDispatchLocalHits interrupted", e2);
            return false;
        } catch (ExecutionException e3) {
            zze("syncDispatchLocalHits failed", e3);
            return false;
        } catch (TimeoutException e4) {
            zzd("syncDispatchLocalHits timed out", e4);
            return false;
        }
    }

    public final void zzck() {
        zzdb();
        zzk.zzav();
        zzbb zzbb = this.zzvu;
        zzk.zzav();
        zzbb.zzdb();
        zzbb.zzq("Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final void onServiceConnected() {
        zzk.zzav();
        this.zzvu.onServiceConnected();
    }

    /* access modifiers changed from: package-private */
    public final void zzcl() {
        zzk.zzav();
        this.zzvu.zzcl();
    }

    public final void zza(String str, Runnable runnable) {
        Preconditions.checkNotEmpty(str, "campaign param can't be empty");
        zzcq().zza((Runnable) new zzah(this, str, runnable));
    }
}
