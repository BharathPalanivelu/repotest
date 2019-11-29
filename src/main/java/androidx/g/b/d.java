package androidx.g.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class d<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f2320a = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2327a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f2327a.getAndIncrement());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f2321b = new LinkedBlockingQueue(10);

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f2322c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f2321b, f2320a);

    /* renamed from: f  reason: collision with root package name */
    private static b f2323f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Executor f2324g = f2322c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f2325d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f2326e = new AtomicBoolean();
    private final C0053d<Params, Result> h = new C0053d<Params, Result>() {
        public Result call() throws Exception {
            d.this.f2326e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = d.this.a((Params[]) this.f2333b);
                Binder.flushPendingCommands();
                d.this.d(result);
                return result;
            } catch (Throwable th) {
                d.this.d(result);
                throw th;
            }
        }
    };
    private final FutureTask<Result> i = new FutureTask<Result>(this.h) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                d.this.c(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (CancellationException unused) {
                d.this.c(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };
    private volatile c j = c.PENDING;

    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    private static Handler d() {
        b bVar;
        synchronized (d.class) {
            if (f2323f == null) {
                f2323f = new b();
            }
            bVar = f2323f;
        }
        return bVar;
    }

    d() {
    }

    /* access modifiers changed from: package-private */
    public void c(Result result) {
        if (!this.f2326e.get()) {
            d(result);
        }
    }

    /* access modifiers changed from: package-private */
    public Result d(Result result) {
        d().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        b();
    }

    public final boolean c() {
        return this.f2325d.get();
    }

    public final boolean a(boolean z) {
        this.f2325d.set(true);
        return this.i.cancel(z);
    }

    /* renamed from: androidx.g.b.d$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2330a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                androidx.g.b.d$c[] r0 = androidx.g.b.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2330a = r0
                int[] r0 = f2330a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.g.b.d$c r1 = androidx.g.b.d.c.RUNNING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2330a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.g.b.d$c r1 = androidx.g.b.d.c.FINISHED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.g.b.d.AnonymousClass4.<clinit>():void");
        }
    }

    public final d<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != c.PENDING) {
            int i2 = AnonymousClass4.f2330a[this.j.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.j = c.RUNNING;
            a();
            this.h.f2333b = paramsArr;
            executor.execute(this.i);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Result result) {
        if (c()) {
            b(result);
        } else {
            a(result);
        }
        this.j = c.FINISHED;
    }

    private static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f2331a.e(aVar.f2332b[0]);
            } else if (i == 2) {
                aVar.f2331a.b((Progress[]) aVar.f2332b);
            }
        }
    }

    /* renamed from: androidx.g.b.d$d  reason: collision with other inner class name */
    private static abstract class C0053d<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f2333b;

        C0053d() {
        }
    }

    private static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final d f2331a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f2332b;

        a(d dVar, Data... dataArr) {
            this.f2331a = dVar;
            this.f2332b = dataArr;
        }
    }
}
