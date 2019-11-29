package io.b.e.g;

import io.b.b.b;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class a extends AtomicReference<Future<?>> implements b {

    /* renamed from: a  reason: collision with root package name */
    protected static final FutureTask<Void> f33485a = new FutureTask<>(io.b.e.b.a.f33328b, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    protected static final FutureTask<Void> f33486b = new FutureTask<>(io.b.e.b.a.f33328b, (Object) null);
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    a(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public final void dispose() {
        Future future = (Future) get();
        if (future != f33485a) {
            FutureTask<Void> futureTask = f33486b;
            if (future != futureTask && compareAndSet(future, futureTask) && future != null) {
                future.cancel(this.runner != Thread.currentThread());
            }
        }
    }

    public final boolean isDisposed() {
        Future future = (Future) get();
        return future == f33485a || future == f33486b;
    }

    public final void a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f33485a) {
                if (future2 == f33486b) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
