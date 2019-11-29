package io.b.e.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f33526a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f33527b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f33528c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f33529d = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f33526a = aVar.f33530a;
        f33527b = aVar.f33531b;
        a();
    }

    public static void a() {
        a(f33526a);
    }

    static void a(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = f33528c.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new g("RxSchedulerPurge"));
                    if (f33528c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        b bVar = new b();
                        int i = f33527b;
                        newScheduledThreadPool.scheduleAtFixedRate(bVar, (long) i, (long) i, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f33530a;

        /* renamed from: b  reason: collision with root package name */
        int f33531b;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f33530a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f33530a = true;
            }
            if (!this.f33530a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f33531b = 1;
                return;
            }
            try {
                this.f33531b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f33531b = 1;
            }
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(f33526a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f33529d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static final class b implements Runnable {
        b() {
        }

        public void run() {
            Iterator it = new ArrayList(j.f33529d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    j.f33529d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
