package com.google.android.gms.internal.p000firebaseperf;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzat  reason: invalid package */
public final class zzat {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzat zzbe = new zzat();
    private final ScheduledExecutorService zzbf;
    public final ConcurrentLinkedQueue<zzbo> zzbg;
    private final Runtime zzbh;
    private ScheduledFuture zzbi;
    private long zzbj;

    private zzat() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private zzat(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.zzbi = null;
        this.zzbj = -1;
        this.zzbf = scheduledExecutorService;
        this.zzbg = new ConcurrentLinkedQueue<>();
        this.zzbh = runtime;
    }

    public static zzat zzz() {
        return zzbe;
    }

    public final void zzb(long j) {
        if (j > 0) {
            if (this.zzbi == null) {
                zze(j);
            } else if (this.zzbj != j) {
                zzt();
                zze(j);
            }
        }
    }

    public final void zzt() {
        ScheduledFuture scheduledFuture = this.zzbi;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.zzbi = null;
            this.zzbj = -1;
        }
    }

    public final void zzu() {
        zzaa();
    }

    private final synchronized void zze(long j) {
        this.zzbj = j;
        try {
            this.zzbi = this.zzbf.scheduleAtFixedRate(new zzas(this), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Memory Metrics: ".concat(valueOf) : new String("Unable to start collecting Memory Metrics: "));
        }
    }

    private final synchronized void zzaa() {
        try {
            this.zzbf.schedule(new zzav(this), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to collect Memory Metric: ".concat(valueOf) : new String("Unable to collect Memory Metric: "));
        }
    }

    private final zzbo zzab() {
        return (zzbo) ((zzep) zzbo.zzcy().zzr(TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis())).zze(zzah.zza(zzba.BYTES.zzp(this.zzbh.totalMemory() - this.zzbh.freeMemory()))).zzhr());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzac() throws Exception {
        return Boolean.valueOf(this.zzbg.add(zzab()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzad() {
        this.zzbg.add(zzab());
    }
}
