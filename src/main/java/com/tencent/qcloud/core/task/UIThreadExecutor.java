package com.tencent.qcloud.core.task;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class UIThreadExecutor implements Executor {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    UIThreadExecutor() {
    }

    public final void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
