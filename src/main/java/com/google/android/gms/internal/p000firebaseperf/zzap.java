package com.google.android.gms.internal.p000firebaseperf;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzap  reason: invalid package */
public final class zzap {
    private static final long zzau = TimeUnit.SECONDS.toMicros(1);
    private static zzap zzav = null;
    private ScheduledFuture zzaw = null;
    private final ScheduledExecutorService zzax;
    private long zzay;
    private final long zzaz;
    private final String zzba;
    public final ConcurrentLinkedQueue<zzbu> zzbb;

    private zzap() {
        long j = -1;
        this.zzay = -1;
        this.zzbb = new ConcurrentLinkedQueue<>();
        this.zzax = Executors.newSingleThreadScheduledExecutor();
        String num = Integer.toString(Process.myPid());
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 11);
        sb.append("/proc/");
        sb.append(num);
        sb.append("/stat");
        this.zzba = sb.toString();
        this.zzaz = Build.VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : j;
    }

    public static zzap zzs() {
        if (zzav == null) {
            zzav = new zzap();
        }
        return zzav;
    }

    public final void zzb(long j) {
        long j2 = this.zzaz;
        if (j2 != -1 && j2 != 0 && j > 0) {
            if (this.zzaw == null) {
                zzc(j);
            } else if (this.zzay != j) {
                zzt();
                zzc(j);
            }
        }
    }

    public final void zzt() {
        ScheduledFuture scheduledFuture = this.zzaw;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.zzaw = null;
            this.zzay = -1;
        }
    }

    public final void zzu() {
        zzv();
    }

    private final synchronized void zzc(long j) {
        this.zzay = j;
        try {
            this.zzaw = this.zzax.scheduleAtFixedRate(new zzar(this), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Cpu Metrics: ".concat(valueOf) : new String("Unable to start collecting Cpu Metrics: "));
        }
    }

    private final synchronized void zzv() {
        try {
            this.zzax.schedule(new zzaq(this), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to collect Cpu Metric: ".concat(valueOf) : new String("Unable to collect Cpu Metric: "));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        r14 = r4;
        r4 = r3;
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0069, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006a, code lost:
        r4 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.p000firebaseperf.zzbu zzw() {
        /*
            r15 = this;
            java.lang.String r0 = "FirebasePerformance"
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            java.lang.String r4 = r15.zzba     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r3 = r3.toMicros(r4)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            java.lang.String r5 = r2.readLine()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            java.lang.String r6 = " "
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r6 = 13
            r6 = r5[r6]     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r8 = 15
            r8 = r5[r8]     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r10 = 14
            r10 = r5[r10]     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r10 = java.lang.Long.parseLong(r10)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r12 = 16
            r5 = r5[r12]     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r12 = java.lang.Long.parseLong(r5)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r5 = com.google.android.gms.internal.p000firebaseperf.zzbu.zzdl()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r3 = r5.zzu(r3)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r10 = r10 + r12
            long r4 = r15.zzd(r10)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r3 = r3.zzw(r4)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            long r6 = r6 + r8
            long r4 = r15.zzd(r6)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r3 = r3.zzv(r4)     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzga r3 = r3.zzhr()     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzep r3 = (com.google.android.gms.internal.p000firebaseperf.zzep) r3     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            com.google.android.gms.internal.firebase-perf.zzbu r3 = (com.google.android.gms.internal.p000firebaseperf.zzbu) r3     // Catch:{ Throwable -> 0x006c, all -> 0x0069 }
            r2.close()     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            return r3
        L_0x0069:
            r3 = move-exception
            r4 = r1
            goto L_0x0072
        L_0x006c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x006e }
        L_0x006e:
            r4 = move-exception
            r14 = r4
            r4 = r3
            r3 = r14
        L_0x0072:
            if (r4 == 0) goto L_0x007d
            r2.close()     // Catch:{ Throwable -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r2 = move-exception
            com.google.android.gms.internal.p000firebaseperf.zzak.zza(r4, r2)     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
            goto L_0x0080
        L_0x007d:
            r2.close()     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
        L_0x0080:
            throw r3     // Catch:{ IOException -> 0x00a4, ArrayIndexOutOfBoundsException -> 0x0085, NumberFormatException -> 0x0083, NullPointerException -> 0x0081 }
        L_0x0081:
            r2 = move-exception
            goto L_0x0086
        L_0x0083:
            r2 = move-exception
            goto L_0x0086
        L_0x0085:
            r2 = move-exception
        L_0x0086:
            java.lang.String r3 = "Unexpected '/proc/[pid]/stat' file format encountered: "
            java.lang.String r2 = r2.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x009b
            java.lang.String r2 = r3.concat(r2)
            goto L_0x00a0
        L_0x009b:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
        L_0x00a0:
            android.util.Log.w(r0, r2)
            goto L_0x00c2
        L_0x00a4:
            r2 = move-exception
            java.lang.String r3 = "Unable to read 'proc/[pid]/stat' file: "
            java.lang.String r2 = r2.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x00ba
            java.lang.String r2 = r3.concat(r2)
            goto L_0x00bf
        L_0x00ba:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
        L_0x00bf:
            android.util.Log.w(r0, r2)
        L_0x00c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzap.zzw():com.google.android.gms.internal.firebase-perf.zzbu");
    }

    private final long zzd(long j) {
        double d2 = (double) j;
        double d3 = (double) this.zzaz;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        double d5 = (double) zzau;
        Double.isNaN(d5);
        return Math.round(d4 * d5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx() {
        zzbu zzw = zzw();
        if (zzw != null) {
            this.zzbb.add(zzw);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzy() {
        zzbu zzw = zzw();
        if (zzw != null) {
            this.zzbb.add(zzw);
        }
    }
}
