package com.shopee.shopeetracker;

import com.shopee.shopeetracker.model.Config;
import com.shopee.shopeetracker.utils.ExceptionHandler;
import com.shopee.shopeetracker.utils.Logger;
import com.shopee.shopeetracker.worker.TrackerTaskRunnable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class EventSendScheduler {
    private static final String uniqueName = "ShopeeTrackerSendWorkerName";
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private ScheduledFuture future;
    private ExceptionHandler mHandler;
    private Runnable task = new TrackerTaskRunnable();

    EventSendScheduler(ExceptionHandler exceptionHandler) {
        this.mHandler = exceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public void schedule(boolean z) {
        if (ShopeeTracker.isInitialized()) {
            try {
                Config config = ShopeeTracker.getInstance().getConfig();
                if (z) {
                    Logger.debug("EventSendScheduler", "app went to foreground.schedule the task");
                    this.future = this.executor.scheduleAtFixedRate(this.task, 3, config.getPeriodForeground(), TimeUnit.SECONDS);
                    return;
                }
                Logger.debug("EventSendScheduler", "cancel the task,app went to background");
                this.future.cancel(false);
            } catch (Exception e2) {
                this.mHandler.onException(e2);
            }
        }
    }

    public void addTask(Runnable runnable) {
        if (runnable != null) {
            try {
                this.executor.execute(runnable);
            } catch (RejectedExecutionException e2) {
                Logger.debug("EventSendScheduler", "RejectedExecutionException" + e2.getMessage());
            } catch (Exception e3) {
                Logger.debug("EventSendScheduler", "Exception" + e3.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelSchedule() {
        try {
            this.future.cancel(false);
        } catch (Exception e2) {
            this.mHandler.onException(e2);
        }
    }
}
