package com.crashlytics.android.c;

import android.os.Looper;
import io.a.a.a.c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f6482a;

    public i(ExecutorService executorService) {
        this.f6482a = executorService;
    }

    /* access modifiers changed from: package-private */
    public <T> T a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f6482a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f6482a.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            c.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e2) {
            c.h().e("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Future<?> a(final Runnable runnable) {
        try {
            return this.f6482a.submit(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e2) {
                        c.h().e("CrashlyticsCore", "Failed to execute task.", e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            c.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public <T> Future<T> b(final Callable<T> callable) {
        try {
            return this.f6482a.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        return callable.call();
                    } catch (Exception e2) {
                        c.h().e("CrashlyticsCore", "Failed to execute task.", e2);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            c.h().a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
