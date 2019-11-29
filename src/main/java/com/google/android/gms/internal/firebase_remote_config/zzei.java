package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class zzei {
    private static final Map<String, zzei> zzkg = new HashMap();
    private static final Executor zzkk = zzem.zzko;
    private final ExecutorService zzkh;
    private final zzex zzki;
    private Task<zzen> zzkj = null;

    private zzei(ExecutorService executorService, zzex zzex) {
        this.zzkh = executorService;
        this.zzki = zzex;
    }

    public final Task<zzen> zzb(zzen zzen) {
        zzd(zzen);
        return zza(zzen, false);
    }

    public final zzen zzco() {
        return zzb(5);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r6 = zzcp();
        r0 = java.util.concurrent.TimeUnit.SECONDS;
        r1 = new com.google.android.gms.internal.firebase_remote_config.zzeo((com.google.android.gms.internal.firebase_remote_config.zzel) null);
        r6.addOnSuccessListener(zzkk, (com.google.android.gms.tasks.OnSuccessListener<? super com.google.android.gms.internal.firebase_remote_config.zzen>) r1);
        r6.addOnFailureListener(zzkk, (com.google.android.gms.tasks.OnFailureListener) r1);
        r6.addOnCanceledListener(zzkk, (com.google.android.gms.tasks.OnCanceledListener) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1.await(5, r0) == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r6.isSuccessful() == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        return r6.getResult();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        throw new java.util.concurrent.ExecutionException(r6.getException());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        throw new java.util.concurrent.TimeoutException("Task await timed out.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        android.util.Log.d("ConfigCacheClient", "Reading from storage file failed.", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.firebase_remote_config.zzen zzb(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzen> r5 = r4.zzkj     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzen> r5 = r4.zzkj     // Catch:{ all -> 0x0067 }
            boolean r5 = r5.isSuccessful()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzen> r5 = r4.zzkj     // Catch:{ all -> 0x0067 }
            java.lang.Object r5 = r5.getResult()     // Catch:{ all -> 0x0067 }
            com.google.android.gms.internal.firebase_remote_config.zzen r5 = (com.google.android.gms.internal.firebase_remote_config.zzen) r5     // Catch:{ all -> 0x0067 }
            monitor-exit(r4)     // Catch:{ all -> 0x0067 }
            return r5
        L_0x0017:
            monitor-exit(r4)     // Catch:{ all -> 0x0067 }
            r5 = 0
            com.google.android.gms.tasks.Task r6 = r4.zzcp()     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            com.google.android.gms.internal.firebase_remote_config.zzeo r1 = new com.google.android.gms.internal.firebase_remote_config.zzeo     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            r1.<init>()     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            java.util.concurrent.Executor r2 = zzkk     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            r6.addOnSuccessListener((java.util.concurrent.Executor) r2, r1)     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            java.util.concurrent.Executor r2 = zzkk     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            r6.addOnFailureListener((java.util.concurrent.Executor) r2, (com.google.android.gms.tasks.OnFailureListener) r1)     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            java.util.concurrent.Executor r2 = zzkk     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            r6.addOnCanceledListener((java.util.concurrent.Executor) r2, (com.google.android.gms.tasks.OnCanceledListener) r1)     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            r2 = 5
            boolean r0 = r1.await(r2, r0)     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            if (r0 == 0) goto L_0x0052
            boolean r0 = r6.isSuccessful()     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            if (r0 == 0) goto L_0x0048
            java.lang.Object r6 = r6.getResult()     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            com.google.android.gms.internal.firebase_remote_config.zzen r6 = (com.google.android.gms.internal.firebase_remote_config.zzen) r6     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            return r6
        L_0x0048:
            java.util.concurrent.ExecutionException r0 = new java.util.concurrent.ExecutionException     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            java.lang.Exception r6 = r6.getException()     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            r0.<init>(r6)     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            throw r0     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
        L_0x0052:
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            java.lang.String r0 = "Task await timed out."
            r6.<init>(r0)     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
            throw r6     // Catch:{ InterruptedException -> 0x005e, ExecutionException -> 0x005c, TimeoutException -> 0x005a }
        L_0x005a:
            r6 = move-exception
            goto L_0x005f
        L_0x005c:
            r6 = move-exception
            goto L_0x005f
        L_0x005e:
            r6 = move-exception
        L_0x005f:
            java.lang.String r0 = "ConfigCacheClient"
            java.lang.String r1 = "Reading from storage file failed."
            android.util.Log.d(r0, r1, r6)
            return r5
        L_0x0067:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0067 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzei.zzb(long):com.google.android.gms.internal.firebase_remote_config.zzen");
    }

    public final Task<zzen> zzc(zzen zzen) {
        return zza(zzen, true);
    }

    public final Task<zzen> zza(zzen zzen, boolean z) {
        return Tasks.call(this.zzkh, new zzeh(this, zzen)).onSuccessTask(this.zzkh, new zzek(this, z, zzen));
    }

    public final synchronized Task<zzen> zzcp() {
        if (this.zzkj == null || (this.zzkj.isComplete() && !this.zzkj.isSuccessful())) {
            ExecutorService executorService = this.zzkh;
            zzex zzex = this.zzki;
            zzex.getClass();
            this.zzkj = Tasks.call(executorService, zzej.zza(zzex));
        }
        return this.zzkj;
    }

    public final void clear() {
        synchronized (this) {
            this.zzkj = Tasks.forResult(null);
        }
        this.zzki.zzdc();
    }

    private final synchronized void zzd(zzen zzen) {
        this.zzkj = Tasks.forResult(zzen);
    }

    public static synchronized zzei zza(ExecutorService executorService, zzex zzex) {
        zzei zzei;
        synchronized (zzei.class) {
            String fileName = zzex.getFileName();
            if (!zzkg.containsKey(fileName)) {
                zzkg.put(fileName, new zzei(executorService, zzex));
            }
            zzei = zzkg.get(fileName);
        }
        return zzei;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(boolean z, zzen zzen, Void voidR) throws Exception {
        if (z) {
            zzd(zzen);
        }
        return Tasks.forResult(zzen);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zze(zzen zzen) throws Exception {
        return this.zzki.zzh(zzen);
    }
}
