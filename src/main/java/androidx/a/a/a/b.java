package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f502a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f503b = Executors.newFixedThreadPool(2, new ThreadFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f506b = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f506b.getAndIncrement())}));
            return thread;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f504c;

    public void a(Runnable runnable) {
        this.f503b.execute(runnable);
    }

    public void b(Runnable runnable) {
        if (this.f504c == null) {
            synchronized (this.f502a) {
                if (this.f504c == null) {
                    this.f504c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f504c.post(runnable);
    }

    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
