package com.garena.e;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f7920a;

    /* renamed from: b  reason: collision with root package name */
    private ScheduledExecutorService f7921b = Executors.newSingleThreadScheduledExecutor();

    public static c a() {
        if (f7920a == null) {
            f7920a = new c();
        }
        return f7920a;
    }

    public Future a(Runnable runnable, int i) {
        return this.f7921b.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
    }
}
