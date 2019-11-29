package com.shopee.app.util;

import com.facebook.login.widget.ToolTipPopup;
import com.shopee.app.application.ar;
import io.a.a.a.c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

public class p extends ThreadPoolExecutor {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f26478a = false;

    public static ThreadPoolExecutor a() {
        return new p(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
    }

    public p(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public void execute(Runnable runnable) {
        super.execute(new a(runnable));
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Runnable f26480b;

        a(Runnable runnable) {
            this.f26480b = runnable;
        }

        public void run() {
            try {
                if (p.this.f26478a && this.f26480b.getClass().getName().contains("AsyncStorageModule")) {
                    Thread.sleep(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                }
                this.f26480b.run();
            } catch (Exception e2) {
                ar.f().e().fabricClient().a((Throwable) e2, "ExceptionCatchingPoolExecutor");
            } catch (OutOfMemoryError e3) {
                if (c.j()) {
                    ar.f().e().fabricClient().a((Throwable) e3, "ExceptionCatchingPoolExecutor");
                }
                System.gc();
            }
        }
    }
}
