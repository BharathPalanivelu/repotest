package com.salesforce.android.service.common.utilities.threading;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
    private final int mPriority;

    public static PriorityThreadFactory background() {
        return new PriorityThreadFactory(10);
    }

    public PriorityThreadFactory(int i) {
        this.mPriority = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.mPriority);
        return thread;
    }
}
