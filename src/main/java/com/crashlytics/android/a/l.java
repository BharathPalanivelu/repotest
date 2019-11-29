package com.crashlytics.android.a;

import io.a.a.a.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class l {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<ScheduledFuture<?>> f6343a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    boolean f6344b = true;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f6345c;

    /* renamed from: d  reason: collision with root package name */
    private final List<a> f6346d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f6347e = true;

    public interface a {
        void a();
    }

    public l(ScheduledExecutorService scheduledExecutorService) {
        this.f6345c = scheduledExecutorService;
    }

    public void a(boolean z) {
        this.f6347e = z;
    }

    /* access modifiers changed from: private */
    public void c() {
        for (a a2 : this.f6346d) {
            a2.a();
        }
    }

    public void a(a aVar) {
        this.f6346d.add(aVar);
    }

    public void a() {
        this.f6344b = false;
        ScheduledFuture andSet = this.f6343a.getAndSet((Object) null);
        if (andSet != null) {
            andSet.cancel(false);
        }
    }

    public void b() {
        if (this.f6347e && !this.f6344b) {
            this.f6344b = true;
            try {
                this.f6343a.compareAndSet((Object) null, this.f6345c.schedule(new Runnable() {
                    public void run() {
                        l.this.f6343a.set((Object) null);
                        l.this.c();
                    }
                }, 5000, TimeUnit.MILLISECONDS));
            } catch (RejectedExecutionException e2) {
                c.h().a("Answers", "Failed to schedule background detector", (Throwable) e2);
            }
        }
    }
}
