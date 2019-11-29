package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class ah {

    /* renamed from: a  reason: collision with root package name */
    final Intent f14105a;

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver.PendingResult f14106b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14107c = false;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledFuture<?> f14108d;

    ah(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f14105a = intent;
        this.f14106b = pendingResult;
        this.f14108d = scheduledExecutorService.schedule(new ag(this, intent), 9000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.f14107c) {
            this.f14106b.finish();
            this.f14108d.cancel(false);
            this.f14107c = true;
        }
    }
}
