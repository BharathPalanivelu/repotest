package a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final int f345a;

    /* renamed from: b  reason: collision with root package name */
    static final int f346b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f347c = new a();

    /* renamed from: e  reason: collision with root package name */
    private static final int f348e = Runtime.getRuntime().availableProcessors();

    /* renamed from: d  reason: collision with root package name */
    private final Executor f349d = new C0000a();

    static {
        int i = f348e;
        f345a = i + 1;
        f346b = (i * 2) + 1;
    }

    private a() {
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f345a, f346b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor b() {
        return f347c.f349d;
    }

    /* renamed from: a.a$a  reason: collision with other inner class name */
    private static class C0000a implements Executor {
        private C0000a() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
