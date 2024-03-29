package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzef extends ThreadPoolExecutor {
    private final Context zzrm;

    public zzef(Context context, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(1, 1, 0, timeUnit, blockingQueue, threadFactory);
        this.zzrm = context;
    }

    /* access modifiers changed from: protected */
    public final void afterExecute(Runnable runnable, Throwable th) {
        if (th != null) {
            zzea.zza("Uncaught exception: ", th, this.zzrm);
        }
    }
}
