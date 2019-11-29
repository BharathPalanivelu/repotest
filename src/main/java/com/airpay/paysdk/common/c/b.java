package com.airpay.paysdk.common.c;

import java.lang.Thread;
import java.util.List;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class b extends AbstractExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<c, b> f3970a = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C0076b f3971b = new C0076b();

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f3972c;

    /* renamed from: d  reason: collision with root package name */
    private a f3973d = new a();

    public enum c {
        CACHE,
        SINGLE,
        FIXED,
        SCHEDULED
    }

    /* renamed from: com.airpay.paysdk.common.c.b$b  reason: collision with other inner class name */
    class C0076b implements Thread.UncaughtExceptionHandler {
        C0076b() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            com.airpay.paysdk.common.b.a.a(th);
        }
    }

    private b() {
    }

    public static synchronized b a(c cVar) {
        b a2;
        synchronized (b.class) {
            a2 = a(cVar, 0);
        }
        return a2;
    }

    public static synchronized b a(c cVar, int i) {
        b bVar;
        synchronized (b.class) {
            bVar = f3970a.get(cVar);
            if (bVar == null) {
                bVar = new b();
                f3970a.put(cVar, bVar);
            }
            int i2 = AnonymousClass1.f3974a[cVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (bVar.f3972c == null) {
                            bVar.f3972c = Executors.newCachedThreadPool(bVar.f3973d);
                        }
                    } else if (bVar.f3972c == null) {
                        bVar.f3972c = Executors.newSingleThreadExecutor(bVar.f3973d);
                    }
                } else if (bVar.f3972c == null) {
                    bVar.f3972c = Executors.newScheduledThreadPool(i, bVar.f3973d);
                }
            } else if (bVar.f3972c == null) {
                bVar.f3972c = Executors.newFixedThreadPool(i, bVar.f3973d);
            }
        }
        return bVar;
    }

    /* renamed from: com.airpay.paysdk.common.c.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3974a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.airpay.paysdk.common.c.b$c[] r0 = com.airpay.paysdk.common.c.b.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3974a = r0
                int[] r0 = f3974a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airpay.paysdk.common.c.b$c r1 = com.airpay.paysdk.common.c.b.c.FIXED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3974a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airpay.paysdk.common.c.b$c r1 = com.airpay.paysdk.common.c.b.c.SCHEDULED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3974a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airpay.paysdk.common.c.b$c r1 = com.airpay.paysdk.common.c.b.c.SINGLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airpay.paysdk.common.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    public void execute(Runnable runnable) {
        this.f3972c.execute(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        ExecutorService executorService = this.f3972c;
        if (executorService != null) {
            return executorService.submit(runnable);
        }
        return null;
    }

    public Future<?> a(Runnable runnable, int i, TimeUnit timeUnit) {
        ExecutorService executorService = this.f3972c;
        if (executorService != null) {
            return ((ScheduledExecutorService) executorService).schedule(runnable, (long) i, timeUnit);
        }
        return submit(runnable);
    }

    public void shutdown() {
        this.f3972c.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f3972c.shutdownNow();
    }

    public boolean isShutdown() {
        return this.f3972c.isShutdown();
    }

    public boolean isTerminated() {
        return this.f3972c.isTerminated();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f3972c.awaitTermination(j, timeUnit);
    }

    class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setUncaughtExceptionHandler(b.this.f3971b);
            return thread;
        }
    }
}
