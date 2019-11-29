package io.b.e.g;

import io.b.b.b;
import io.b.e.a.a;
import io.b.e.a.c;
import io.b.p;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class e extends p.b implements b {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f33520a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f33521b;

    public e(ThreadFactory threadFactory) {
        this.f33521b = j.a(threadFactory);
    }

    public b a(Runnable runnable) {
        return a(runnable, 0, (TimeUnit) null);
    }

    public b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f33520a) {
            return c.INSTANCE;
        }
        return a(runnable, j, timeUnit, (a) null);
    }

    public b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        h hVar = new h(io.b.g.a.a(runnable));
        if (j <= 0) {
            try {
                future = this.f33521b.submit(hVar);
            } catch (RejectedExecutionException e2) {
                io.b.g.a.a((Throwable) e2);
                return c.INSTANCE;
            }
        } else {
            future = this.f33521b.schedule(hVar, j, timeUnit);
        }
        hVar.a(future);
        return hVar;
    }

    public i a(Runnable runnable, long j, TimeUnit timeUnit, a aVar) {
        Future future;
        i iVar = new i(io.b.g.a.a(runnable), aVar);
        if (aVar != null && !aVar.a(iVar)) {
            return iVar;
        }
        if (j <= 0) {
            try {
                future = this.f33521b.submit(iVar);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.b(iVar);
                }
                io.b.g.a.a((Throwable) e2);
            }
        } else {
            future = this.f33521b.schedule(iVar, j, timeUnit);
        }
        iVar.a(future);
        return iVar;
    }

    public void dispose() {
        if (!this.f33520a) {
            this.f33520a = true;
            this.f33521b.shutdownNow();
        }
    }

    public void b() {
        if (!this.f33520a) {
            this.f33520a = true;
            this.f33521b.shutdown();
        }
    }

    public boolean isDisposed() {
        return this.f33520a;
    }
}
