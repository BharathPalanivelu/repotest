package com.tencent.qcloud.core.task;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskExecutors {
    public static final ThreadPoolExecutor COMMAND_EXECUTOR = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new TaskThreadFactory("Command-"));
    public static final ThreadPoolExecutor DOWNLOAD_EXECUTOR = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new TaskThreadFactory("Download-"));
    public static final UIThreadExecutor UI_THREAD_EXECUTOR = new UIThreadExecutor();
    public static final ThreadPoolExecutor UPLOAD_EXECUTOR = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new TaskThreadFactory("Upload-"));

    static {
        UPLOAD_EXECUTOR.allowCoreThreadTimeOut(true);
        COMMAND_EXECUTOR.allowCoreThreadTimeOut(true);
        DOWNLOAD_EXECUTOR.allowCoreThreadTimeOut(true);
    }

    static final class TaskThreadFactory implements ThreadFactory {
        private final AtomicInteger increment = new AtomicInteger(1);
        private final String tag;

        TaskThreadFactory(String str) {
            this.tag = str;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "QCloud-" + this.tag + this.increment.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }
}
