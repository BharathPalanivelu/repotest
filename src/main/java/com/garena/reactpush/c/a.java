package com.garena.reactpush.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ScheduledExecutorService f8346a = Executors.newSingleThreadScheduledExecutor();

    public static void a(final Runnable runnable) {
        f8346a.execute(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } catch (Exception unused) {
                }
            }
        });
    }
}
