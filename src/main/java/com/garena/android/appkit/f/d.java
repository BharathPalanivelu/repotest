package com.garena.android.appkit.f;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private ScheduledExecutorService f7675a = Executors.newSingleThreadScheduledExecutor();

    public void a(Runnable runnable) {
        this.f7675a.execute(runnable);
    }

    public Future a(Runnable runnable, int i) {
        return this.f7675a.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
    }
}
