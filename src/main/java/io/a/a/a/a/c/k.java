package io.a.a.a.a.c;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static final int f33146a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    private static final int f33147b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f33148c;

    static {
        int i = f33146a;
        f33147b = i + 1;
        f33148c = (i * 2) + 1;
    }

    <T extends Runnable & b & l & i> k(int i, int i2, long j, TimeUnit timeUnit, c<T> cVar, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, cVar, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & b & l & i> k a(int i, int i2) {
        return new k(i, i2, 1, TimeUnit.SECONDS, new c(), new a(10));
    }

    public static k a() {
        return a(f33147b, f33148c);
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new h(runnable, t);
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new h(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (j.a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, (Object) null));
        }
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        l lVar = (l) runnable;
        lVar.b(true);
        lVar.a(th);
        getQueue().d();
        super.afterExecute(runnable, th);
    }

    /* renamed from: b */
    public c getQueue() {
        return (c) super.getQueue();
    }

    protected static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final int f33149a;

        public a(int i) {
            this.f33149a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f33149a);
            thread.setName("Queue");
            return thread;
        }
    }
}
