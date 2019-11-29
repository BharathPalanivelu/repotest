package a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final d f357a = new d();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f358b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f359c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f360d;

    private static boolean d() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private d() {
        this.f358b = !d() ? Executors.newCachedThreadPool() : a.a();
        this.f359c = Executors.newSingleThreadScheduledExecutor();
        this.f360d = new a();
    }

    public static ExecutorService a() {
        return f357a.f358b;
    }

    static ScheduledExecutorService b() {
        return f357a.f359c;
    }

    static Executor c() {
        return f357a.f360d;
    }

    private static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private ThreadLocal<Integer> f361a;

        private a() {
            this.f361a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f361a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f361a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int b() {
            Integer num = this.f361a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f361a.remove();
            } else {
                this.f361a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (a() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    b();
                    throw th;
                }
            } else {
                d.a().execute(runnable);
            }
            b();
        }
    }
}
