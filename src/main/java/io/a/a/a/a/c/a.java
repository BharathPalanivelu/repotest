package io.a.a.a.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
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

public abstract class a<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f33114a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f33115b = new ThreadPoolExecutor(f33117d, f33118e, 1, TimeUnit.SECONDS, f33120g, f33119f);

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f33116c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final int f33117d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f33118e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f33119f = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f33121a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f33121a.getAndIncrement());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f33120g = new LinkedBlockingQueue(128);
    private static final b h = new b();
    private static volatile Executor i = f33116c;
    private final e<Params, Result> j = new e<Params, Result>() {
        public Result call() throws Exception {
            a.this.n.set(true);
            Process.setThreadPriority(10);
            a aVar = a.this;
            return aVar.e(aVar.a((Params[]) this.f33134b));
        }
    };
    private final FutureTask<Result> k = new FutureTask<Result>(this.j) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                a.this.d(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            } catch (CancellationException unused) {
                a.this.d(null);
            }
        }
    };
    private volatile d l = d.PENDING;
    private final AtomicBoolean m = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean n = new AtomicBoolean();

    public enum d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public void H_() {
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
    public void b(Progress... progressArr) {
    }

    static {
        int i2 = f33114a;
        f33117d = i2 + 1;
        f33118e = (i2 * 2) + 1;
    }

    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final LinkedList<Runnable> f33128a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f33129b;

        private c() {
            this.f33128a = new LinkedList<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f33128a.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.f33129b == null) {
                a();
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void a() {
            Runnable poll = this.f33128a.poll();
            this.f33129b = poll;
            if (poll != null) {
                a.f33115b.execute(this.f33129b);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(Result result) {
        if (!this.n.get()) {
            e(result);
        }
    }

    /* access modifiers changed from: private */
    public Result e(Result result) {
        h.obtainMessage(1, new C0511a(this, result)).sendToTarget();
        return result;
    }

    public final d G_() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        H_();
    }

    public final boolean e() {
        return this.m.get();
    }

    public final boolean a(boolean z) {
        this.m.set(true);
        return this.k.cancel(z);
    }

    public final a<Params, Progress, Result> c(Params... paramsArr) {
        return a(i, paramsArr);
    }

    /* renamed from: io.a.a.a.a.c.a$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33124a = new int[d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                io.a.a.a.a.c.a$d[] r0 = io.a.a.a.a.c.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33124a = r0
                int[] r0 = f33124a     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.a.a.a.a.c.a$d r1 = io.a.a.a.a.c.a.d.RUNNING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f33124a     // Catch:{ NoSuchFieldError -> 0x001f }
                io.a.a.a.a.c.a$d r1 = io.a.a.a.a.c.a.d.FINISHED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.c.a.AnonymousClass4.<clinit>():void");
        }
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.l != d.PENDING) {
            int i2 = AnonymousClass4.f33124a[this.l.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.l = d.RUNNING;
        a();
        this.j.f33134b = paramsArr;
        executor.execute(this.k);
        return this;
    }

    /* access modifiers changed from: private */
    public void f(Result result) {
        if (e()) {
            b(result);
        } else {
            a(result);
        }
        this.l = d.FINISHED;
    }

    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0511a aVar = (C0511a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f33125a.f(aVar.f33126b[0]);
            } else if (i == 2) {
                aVar.f33125a.b((Progress[]) aVar.f33126b);
            }
        }
    }

    private static abstract class e<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f33134b;

        private e() {
        }
    }

    /* renamed from: io.a.a.a.a.c.a$a  reason: collision with other inner class name */
    private static class C0511a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final a f33125a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f33126b;

        C0511a(a aVar, Data... dataArr) {
            this.f33125a = aVar;
            this.f33126b = dataArr;
        }
    }
}
