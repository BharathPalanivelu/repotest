package com.c.a.c.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class a extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f5761a;

    /* renamed from: c  reason: collision with root package name */
    private static final long f5762c = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5763b;

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f5770a = new b() {
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final b f5771b = new b() {
            public void a(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final b f5772c = new b() {
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final b f5773d = f5771b;

        void a(Throwable th);
    }

    public static a a() {
        return a(1, "disk-cache", b.f5773d);
    }

    public static a a(int i, String str, b bVar) {
        return new a(i, str, bVar, true, false);
    }

    public static a b() {
        return b(e(), ShareConstants.FEED_SOURCE_PARAM, b.f5773d);
    }

    public static a b(int i, String str, b bVar) {
        return new a(i, str, bVar, false, false);
    }

    public static a c() {
        return new a(0, Integer.MAX_VALUE, f5762c, "source-unlimited", b.f5773d, false, false, new SynchronousQueue());
    }

    public static a d() {
        return new a(0, e() >= 4 ? 2 : 1, f5762c, "animation", b.f5773d, true, false, new PriorityBlockingQueue());
    }

    a(int i, String str, b bVar, boolean z, boolean z2) {
        this(i, i, 0, str, bVar, z, z2);
    }

    a(int i, int i2, long j, String str, b bVar, boolean z, boolean z2) {
        this(i, i2, j, str, bVar, z, z2, new PriorityBlockingQueue());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(int i, int i2, long j, String str, b bVar, boolean z, boolean z2, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, TimeUnit.MILLISECONDS, blockingQueue, new C0100a(str, bVar, z));
        String str2 = str;
        b bVar2 = bVar;
        boolean z3 = z;
        this.f5763b = z2;
    }

    public void execute(Runnable runnable) {
        if (this.f5763b) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    public Future<?> submit(Runnable runnable) {
        return a(super.submit(runnable));
    }

    private <T> Future<T> a(Future<T> future) {
        if (this.f5763b) {
            boolean z = false;
            while (!future.isDone()) {
                try {
                    future.get();
                } catch (ExecutionException e2) {
                    throw new RuntimeException(e2);
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        return future;
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return a(super.submit(runnable, t));
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return a(super.submit(callable));
    }

    public static int e() {
        if (f5761a == 0) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            File[] fileArr = null;
            try {
                File file = new File("/sys/devices/system/cpu/");
                final Pattern compile = Pattern.compile("cpu[0-9]+");
                fileArr = file.listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return compile.matcher(str).matches();
                    }
                });
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            f5761a = Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArr != null ? fileArr.length : 0));
        }
        return f5761a;
    }

    /* renamed from: com.c.a.c.b.c.a$a  reason: collision with other inner class name */
    private static final class C0100a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final b f5765a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f5766b;

        /* renamed from: c  reason: collision with root package name */
        private final String f5767c;

        /* renamed from: d  reason: collision with root package name */
        private int f5768d;

        C0100a(String str, b bVar, boolean z) {
            this.f5767c = str;
            this.f5765a = bVar;
            this.f5766b = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            AnonymousClass1 r0;
            r0 = new Thread(runnable, "glide-" + this.f5767c + "-thread-" + this.f5768d) {
                public void run() {
                    Process.setThreadPriority(9);
                    if (C0100a.this.f5766b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        C0100a.this.f5765a.a(th);
                    }
                }
            };
            this.f5768d = this.f5768d + 1;
            return r0;
        }
    }
}
