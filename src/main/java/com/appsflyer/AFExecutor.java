package com.appsflyer;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import androidx.core.content.b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AFExecutor {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AFExecutor f10;

    /* renamed from: ˊ  reason: contains not printable characters */
    Executor f11;

    /* renamed from: ˎ  reason: contains not printable characters */
    private ScheduledExecutorService f12;

    /* renamed from: ˏ  reason: contains not printable characters */
    ScheduledExecutorService f13;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ThreadFactory f14 = new AnonymousClass2();

    /* renamed from: com.appsflyer.AFExecutor$2  reason: invalid class name */
    public class AnonymousClass2 implements ThreadFactory {
        AnonymousClass2() {
        }

        /* renamed from: com.appsflyer.AFExecutor$2$1  reason: invalid class name */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: ˊ  reason: contains not printable characters */
            private static String f16;

            /* renamed from: ˋ  reason: contains not printable characters */
            private static String f17;

            /* renamed from: ˎ  reason: contains not printable characters */
            private /* synthetic */ Runnable f18;

            AnonymousClass1(Runnable runnable) {
                this.f18 = runnable;
            }

            public final void run() {
                if (Build.VERSION.SDK_INT >= 14) {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                }
                this.f18.run();
            }

            AnonymousClass1() {
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            static void m26(String str) {
                f16 = str;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0 || i == str.length() - 1) {
                        sb.append(str.charAt(i));
                    } else {
                        sb.append("*");
                    }
                }
                f17 = sb.toString();
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public static void m27(String str) {
                if (f16 == null) {
                    m26(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
                }
                String str2 = f16;
                if (str2 != null && str.contains(str2)) {
                    AFLogger.afInfoLog(str.replace(f16, f17));
                }
            }
        }

        public final Thread newThread(Runnable runnable) {
            return new Thread(new AnonymousClass1(runnable));
        }

        AnonymousClass2() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static boolean m25(Context context, String str) {
            int b2 = b.b(context, str);
            StringBuilder sb = new StringBuilder("is Permission Available: ");
            sb.append(str);
            sb.append("; res: ");
            sb.append(b2);
            AFLogger.afRDLog(sb.toString());
            return b2 == 0;
        }
    }

    private AFExecutor() {
    }

    public static AFExecutor getInstance() {
        if (f10 == null) {
            f10 = new AFExecutor();
        }
        return f10;
    }

    public ScheduledExecutorService getSerialExecutor() {
        if (this.f12 == null) {
            this.f12 = Executors.newSingleThreadScheduledExecutor(this.f14);
        }
        return this.f12;
    }

    public Executor getThreadPoolExecutor() {
        Executor executor = this.f11;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.f11).isTerminated() || ((ThreadPoolExecutor) this.f11).isTerminating()))) {
            if (Build.VERSION.SDK_INT < 11) {
                return Executors.newSingleThreadExecutor();
            }
            this.f11 = Executors.newFixedThreadPool(2, this.f14);
        }
        return this.f11;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final ScheduledThreadPoolExecutor m24() {
        ScheduledExecutorService scheduledExecutorService = this.f13;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.f13.isTerminated()) {
            this.f13 = Executors.newScheduledThreadPool(2, this.f14);
        }
        return (ScheduledThreadPoolExecutor) this.f13;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static void m23(ExecutorService executorService) {
        try {
            AFLogger.afRDLog("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.afRDLog("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}
