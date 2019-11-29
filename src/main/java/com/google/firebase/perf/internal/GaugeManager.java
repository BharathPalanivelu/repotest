package com.google.firebase.perf.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.zzap;
import com.google.android.gms.internal.p000firebaseperf.zzat;
import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.android.gms.internal.p000firebaseperf.zzbz;
import com.google.android.gms.internal.p000firebaseperf.zzcd;
import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
public class GaugeManager {
    private static GaugeManager zzdn = new GaugeManager();
    private final FeatureControl zzcy;
    private final ScheduledExecutorService zzdo;
    private final zzap zzdp;
    private final zzat zzdq;
    private c zzdr;
    private p zzds;
    private zzbt zzdt;
    private String zzdu;
    private ScheduledFuture zzdv;
    private final ConcurrentLinkedQueue<a> zzdw;

    class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final zzcd f14225a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final zzbt f14226b;

        a(GaugeManager gaugeManager, zzcd zzcd, zzbt zzbt) {
            this.f14225a = zzcd;
            this.f14226b = zzbt;
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), (c) null, FeatureControl.zzao(), (p) null, zzap.zzs(), zzat.zzz());
    }

    private GaugeManager(ScheduledExecutorService scheduledExecutorService, c cVar, FeatureControl featureControl, p pVar, zzap zzap, zzat zzat) {
        this.zzdt = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzdu = null;
        this.zzdv = null;
        this.zzdw = new ConcurrentLinkedQueue<>();
        this.zzdo = scheduledExecutorService;
        this.zzdr = null;
        this.zzcy = featureControl;
        this.zzds = null;
        this.zzdp = zzap;
        this.zzdq = zzat;
    }

    public final void zze(Context context) {
        this.zzds = new p(context);
    }

    public static synchronized GaugeManager zzbf() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = zzdn;
        }
        return gaugeManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r13, com.google.android.gms.internal.p000firebaseperf.zzbt r14) {
        /*
            r12 = this;
            java.lang.String r0 = r12.zzdu
            if (r0 == 0) goto L_0x0007
            r12.zzbg()
        L_0x0007:
            int[] r0 = com.google.firebase.perf.internal.n.f14261a
            int r1 = r14.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            r3 = -1
            if (r0 == r2) goto L_0x0020
            if (r0 == r1) goto L_0x0019
            r5 = r3
            goto L_0x0026
        L_0x0019:
            com.google.firebase.perf.internal.FeatureControl r0 = r12.zzcy
            long r5 = r0.zzat()
            goto L_0x0026
        L_0x0020:
            com.google.firebase.perf.internal.FeatureControl r0 = r12.zzcy
            long r5 = r0.zzav()
        L_0x0026:
            r7 = 0
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0030
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0031
        L_0x0030:
            r5 = r3
        L_0x0031:
            com.google.firebase.perf.internal.FeatureControl r0 = r12.zzcy
            boolean r0 = r0.zzaq()
            r9 = 0
            java.lang.String r10 = "FirebasePerformance"
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = "Cpu Metrics collection is disabled. Did not collect Cpu Metrics."
            android.util.Log.d(r10, r0)
        L_0x0041:
            r0 = 0
            goto L_0x0053
        L_0x0043:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x004d
            java.lang.String r0 = "Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics."
            android.util.Log.d(r10, r0)
            goto L_0x0041
        L_0x004d:
            com.google.android.gms.internal.firebase-perf.zzap r0 = r12.zzdp
            r0.zzb(r5)
            r0 = 1
        L_0x0053:
            if (r0 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r5 = r3
        L_0x0057:
            int[] r0 = com.google.firebase.perf.internal.n.f14261a
            int r11 = r14.ordinal()
            r0 = r0[r11]
            if (r0 == r2) goto L_0x006c
            if (r0 == r1) goto L_0x0065
            r0 = r3
            goto L_0x0072
        L_0x0065:
            com.google.firebase.perf.internal.FeatureControl r0 = r12.zzcy
            long r0 = r0.zzau()
            goto L_0x0072
        L_0x006c:
            com.google.firebase.perf.internal.FeatureControl r0 = r12.zzcy
            long r0 = r0.zzaw()
        L_0x0072:
            int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r11 == 0) goto L_0x007a
            int r11 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r11 > 0) goto L_0x007b
        L_0x007a:
            r0 = r3
        L_0x007b:
            com.google.firebase.perf.internal.FeatureControl r7 = r12.zzcy
            boolean r7 = r7.zzar()
            if (r7 != 0) goto L_0x0089
            java.lang.String r2 = "Memory Metrics collection is disabled. Did not collect Memory Metrics."
            android.util.Log.d(r10, r2)
            goto L_0x0099
        L_0x0089:
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0093
            java.lang.String r2 = "Invalid Memory Metrics collection frequency. Did not collect Memory Metrics."
            android.util.Log.d(r10, r2)
            goto L_0x0099
        L_0x0093:
            com.google.android.gms.internal.firebase-perf.zzat r7 = r12.zzdq
            r7.zzb(r0)
            r9 = 1
        L_0x0099:
            if (r9 == 0) goto L_0x00a5
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x00a0
            goto L_0x00a4
        L_0x00a0:
            long r0 = java.lang.Math.min(r5, r0)
        L_0x00a4:
            r5 = r0
        L_0x00a5:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x00af
            java.lang.String r13 = "Invalid gauge collection frequency. Unable to start collecting Gauges."
            android.util.Log.w(r10, r13)
            return
        L_0x00af:
            r12.zzdu = r13
            r12.zzdt = r14
            java.util.concurrent.ScheduledExecutorService r0 = r12.zzdo     // Catch:{ RejectedExecutionException -> 0x00c8 }
            com.google.firebase.perf.internal.m r1 = new com.google.firebase.perf.internal.m     // Catch:{ RejectedExecutionException -> 0x00c8 }
            r1.<init>(r12, r13, r14)     // Catch:{ RejectedExecutionException -> 0x00c8 }
            r13 = 20
            long r4 = r5 * r13
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ RejectedExecutionException -> 0x00c8 }
            r2 = r4
            java.util.concurrent.ScheduledFuture r13 = r0.scheduleAtFixedRate(r1, r2, r4, r6)     // Catch:{ RejectedExecutionException -> 0x00c8 }
            r12.zzdv = r13     // Catch:{ RejectedExecutionException -> 0x00c8 }
            return
        L_0x00c8:
            r13 = move-exception
            java.lang.String r14 = "Unable to start collecting Gauges: "
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r0 = r13.length()
            if (r0 == 0) goto L_0x00de
            java.lang.String r13 = r14.concat(r13)
            goto L_0x00e3
        L_0x00de:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r14)
        L_0x00e3:
            android.util.Log.w(r10, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.GaugeManager.zza(java.lang.String, com.google.android.gms.internal.firebase-perf.zzbt):void");
    }

    public final void zzbg() {
        String str = this.zzdu;
        if (str != null) {
            zzbt zzbt = this.zzdt;
            this.zzdp.zzt();
            this.zzdq.zzt();
            ScheduledFuture scheduledFuture = this.zzdv;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzdo.schedule(new o(this, str, zzbt), 20, TimeUnit.MILLISECONDS);
            this.zzdu = null;
            this.zzdt = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final void zze(String str, zzbt zzbt) {
        zzcd.zza zzdx = zzcd.zzdx();
        while (!this.zzdp.zzbb.isEmpty()) {
            zzdx.zzb(this.zzdp.zzbb.poll());
        }
        while (!this.zzdq.zzbg.isEmpty()) {
            zzdx.zzb(this.zzdq.zzbg.poll());
        }
        zzdx.zzaa(str);
        zzc((zzcd) ((zzep) zzdx.zzhr()), zzbt);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, zzbt zzbt) {
        if (this.zzds == null) {
            return false;
        }
        zzc((zzcd) ((zzep) zzcd.zzdx().zzaa(str).zzb((zzbz) ((zzep) zzbz.zzdo().zzy(this.zzds.a()).zzi(this.zzds.d()).zzj(this.zzds.b()).zzk(this.zzds.c()).zzhr())).zzhr()), zzbt);
        return true;
    }

    private final void zzc(zzcd zzcd, zzbt zzbt) {
        c cVar = this.zzdr;
        if (cVar == null) {
            cVar = c.a();
        }
        this.zzdr = cVar;
        c cVar2 = this.zzdr;
        if (cVar2 != null) {
            cVar2.a(zzcd, zzbt);
            while (!this.zzdw.isEmpty()) {
                a poll = this.zzdw.poll();
                this.zzdr.a(poll.f14225a, poll.f14226b);
            }
            return;
        }
        this.zzdw.add(new a(this, zzcd, zzbt));
    }

    public final void zzbh() {
        zza(this.zzcy.zzaq(), this.zzcy.zzar(), this.zzdp, this.zzdq);
    }

    public static void zzbi() {
        zza(true, true, zzap.zzs(), zzat.zzz());
    }

    private static void zza(boolean z, boolean z2, zzap zzap, zzat zzat) {
        if (z) {
            zzap.zzu();
        } else {
            Log.d("FirebasePerformance", "Cpu Metrics collection is disabled. Did not collect Cpu Metric.");
        }
        if (z2) {
            zzat.zzu();
        } else {
            Log.d("FirebasePerformance", "Memory Metrics collection is disabled. Did not collect Memory Metric.");
        }
    }
}
