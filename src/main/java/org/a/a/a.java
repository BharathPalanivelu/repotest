package org.a.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f33811a = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    /* renamed from: b  reason: collision with root package name */
    public static final b f33812b = new b() {
    };

    /* renamed from: c  reason: collision with root package name */
    private static Executor f33813c = f33811a;

    /* renamed from: d  reason: collision with root package name */
    private static b f33814d = f33812b;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final List<C0532a> f33815e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal<String> f33816f = new ThreadLocal<>();

    public interface b {
    }

    private a() {
    }

    private static Future<?> b(Runnable runnable, long j) {
        if (j > 0) {
            Executor executor = f33813c;
            if (executor instanceof ScheduledExecutorService) {
                return ((ScheduledExecutorService) executor).schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
            throw new IllegalArgumentException("The executor set does not support scheduling");
        }
        Executor executor2 = f33813c;
        if (executor2 instanceof ExecutorService) {
            return ((ExecutorService) executor2).submit(runnable);
        }
        executor2.execute(runnable);
        return null;
    }

    public static synchronized void a(C0532a aVar) {
        synchronized (a.class) {
            if (!(aVar.id == null && aVar.serial == null)) {
                f33815e.add(aVar);
            }
            if (aVar.serial == null || !b(aVar.serial)) {
                boolean unused = aVar.executionAsked = true;
                Future unused2 = aVar.future = b(aVar, aVar.remainingDelay);
            }
        }
    }

    public static void a(Runnable runnable, String str, long j, String str2) {
        final Runnable runnable2 = runnable;
        a((C0532a) new C0532a(str, j, str2) {
            public void execute() {
                runnable2.run();
            }
        });
    }

    public static void a(Runnable runnable, long j) {
        b(runnable, j);
    }

    public static void a(Runnable runnable) {
        b(runnable, 0);
    }

    public static void a(Runnable runnable, String str, String str2) {
        a(runnable, str, 0, str2);
    }

    public static synchronized void a(String str, boolean z) {
        synchronized (a.class) {
            for (int size = f33815e.size() - 1; size >= 0; size--) {
                C0532a aVar = f33815e.get(size);
                if (str.equals(aVar.id)) {
                    if (aVar.future != null) {
                        aVar.future.cancel(z);
                        if (!aVar.managed.getAndSet(true)) {
                            aVar.postExecute();
                        }
                    } else if (aVar.executionAsked) {
                        Log.w("BackgroundExecutor", "A task with id " + aVar.id + " cannot be cancelled (the executor set does not support it)");
                    } else {
                        f33815e.remove(size);
                    }
                }
            }
        }
    }

    private static boolean b(String str) {
        for (C0532a next : f33815e) {
            if (next.executionAsked && str.equals(next.serial)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static C0532a c(String str) {
        int size = f33815e.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(f33815e.get(i).serial)) {
                return f33815e.remove(i);
            }
        }
        return null;
    }

    /* renamed from: org.a.a.a$a  reason: collision with other inner class name */
    public static abstract class C0532a implements Runnable {
        /* access modifiers changed from: private */
        public boolean executionAsked;
        /* access modifiers changed from: private */
        public Future<?> future;
        /* access modifiers changed from: private */
        public String id;
        /* access modifiers changed from: private */
        public AtomicBoolean managed = new AtomicBoolean();
        /* access modifiers changed from: private */
        public long remainingDelay;
        /* access modifiers changed from: private */
        public String serial;
        private long targetTimeMillis;

        public abstract void execute();

        public C0532a(String str, long j, String str2) {
            if (!"".equals(str)) {
                this.id = str;
            }
            if (j > 0) {
                this.remainingDelay = j;
                this.targetTimeMillis = SystemClock.elapsedRealtime() + j;
            }
            if (!"".equals(str2)) {
                this.serial = str2;
            }
        }

        public void run() {
            if (!this.managed.getAndSet(true)) {
                try {
                    a.f33816f.set(this.serial);
                    execute();
                } finally {
                    postExecute();
                }
            }
        }

        /* access modifiers changed from: private */
        public void postExecute() {
            if (this.id != null || this.serial != null) {
                a.f33816f.set((Object) null);
                synchronized (a.class) {
                    a.f33815e.remove(this);
                    if (this.serial != null) {
                        C0532a a2 = a.c(this.serial);
                        if (a2 != null) {
                            if (a2.remainingDelay != 0) {
                                a2.remainingDelay = Math.max(0, a2.targetTimeMillis - SystemClock.elapsedRealtime());
                            }
                            a.a(a2);
                        }
                    }
                }
            }
        }
    }
}
