package life.knowledge4.videotrimmer.c;

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
    public static final Executor f33759a = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    /* renamed from: b  reason: collision with root package name */
    private static Executor f33760b = f33759a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final List<C0531a> f33761c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<String> f33762d = new ThreadLocal<>();

    private a() {
    }

    private static Future<?> a(Runnable runnable, long j) {
        if (j > 0) {
            Executor executor = f33760b;
            if (executor instanceof ScheduledExecutorService) {
                return ((ScheduledExecutorService) executor).schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
            throw new IllegalArgumentException("The executor set does not support scheduling");
        }
        Executor executor2 = f33760b;
        if (executor2 instanceof ExecutorService) {
            return ((ExecutorService) executor2).submit(runnable);
        }
        executor2.execute(runnable);
        return null;
    }

    public static synchronized void a(C0531a aVar) {
        synchronized (a.class) {
            Future<?> future = null;
            if (aVar.f33766d == null || !b(aVar.f33766d)) {
                boolean unused = aVar.f33767e = true;
                future = a((Runnable) aVar, aVar.f33764b);
            }
            if (!(aVar.f33763a == null && aVar.f33766d == null) && !aVar.f33769g.get()) {
                Future unused2 = aVar.f33768f = future;
                f33761c.add(aVar);
            }
        }
    }

    private static boolean b(String str) {
        for (C0531a next : f33761c) {
            if (next.f33767e && str.equals(next.f33766d)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static C0531a c(String str) {
        int size = f33761c.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(f33761c.get(i).f33766d)) {
                return f33761c.remove(i);
            }
        }
        return null;
    }

    public static synchronized void a(String str, boolean z) {
        synchronized (a.class) {
            for (int size = f33761c.size() - 1; size >= 0; size--) {
                C0531a aVar = f33761c.get(size);
                if (str.equals(aVar.f33763a)) {
                    if (aVar.f33768f != null) {
                        aVar.f33768f.cancel(z);
                        if (!aVar.f33769g.getAndSet(true)) {
                            aVar.b();
                        }
                    } else if (aVar.f33767e) {
                        Log.w("BackgroundExecutor", "A task with id " + aVar.f33763a + " cannot be cancelled (the executor set does not support it)");
                    } else {
                        f33761c.remove(size);
                    }
                }
            }
        }
    }

    /* renamed from: life.knowledge4.videotrimmer.c.a$a  reason: collision with other inner class name */
    public static abstract class C0531a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f33763a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f33764b;

        /* renamed from: c  reason: collision with root package name */
        private long f33765c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f33766d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f33767e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Future<?> f33768f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public AtomicBoolean f33769g = new AtomicBoolean();

        public abstract void a();

        public C0531a(String str, long j, String str2) {
            if (!"".equals(str)) {
                this.f33763a = str;
            }
            if (j > 0) {
                this.f33764b = j;
                this.f33765c = System.currentTimeMillis() + j;
            }
            if (!"".equals(str2)) {
                this.f33766d = str2;
            }
        }

        public void run() {
            if (!this.f33769g.getAndSet(true)) {
                try {
                    a.f33762d.set(this.f33766d);
                    a();
                } finally {
                    b();
                }
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            if (this.f33763a != null || this.f33766d != null) {
                a.f33762d.set((Object) null);
                synchronized (a.class) {
                    a.f33761c.remove(this);
                    if (this.f33766d != null) {
                        C0531a a2 = a.c(this.f33766d);
                        if (a2 != null) {
                            if (a2.f33764b != 0) {
                                a2.f33764b = Math.max(0, this.f33765c - System.currentTimeMillis());
                            }
                            a.a(a2);
                        }
                    }
                }
            }
        }
    }
}
