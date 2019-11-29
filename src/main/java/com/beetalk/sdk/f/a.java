package com.beetalk.sdk.f;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f5420a;

    /* renamed from: b  reason: collision with root package name */
    private ScheduledExecutorService f5421b = Executors.newSingleThreadScheduledExecutor();

    public static a a() {
        if (f5420a == null) {
            f5420a = new a();
        }
        return f5420a;
    }

    public void a(Runnable runnable) {
        this.f5421b.execute(runnable);
    }

    public Future a(Runnable runnable, int i) {
        return this.f5421b.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
    }
}
