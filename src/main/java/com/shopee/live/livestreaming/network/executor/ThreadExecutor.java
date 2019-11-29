package com.shopee.live.livestreaming.network.executor;

import com.shopee.e.a.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor implements Executor {
    private static final int CORE_POOL_SIZE = 3;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final int MAX_POOL_SIZE = 5;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue();
    private static volatile ThreadExecutor sThreadExecutor;
    private ThreadPoolExecutor mThreadPoolExecutor = new ThreadPoolExecutor(3, 5, 120, TIME_UNIT, WORK_QUEUE);

    private ThreadExecutor() {
    }

    public <T, C> void execute(final AbstractInteractor<T, C> abstractInteractor, final T t, final C c2) {
        this.mThreadPoolExecutor.submit(new Runnable() {
            public void run() {
                try {
                    abstractInteractor.run(t, c2);
                } catch (Exception e2) {
                    a.a(e2, "thread exception", new Object[0]);
                }
            }
        });
    }

    public void closeExcutor() {
        ThreadPoolExecutor threadPoolExecutor = this.mThreadPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
        }
    }

    public static Executor getInstance() {
        if (sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutor();
        }
        return sThreadExecutor;
    }
}
