package com.salesforce.android.service.common.utilities.lifecycle;

import android.os.Handler;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.Enum;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LifecycleStateWatcher<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
    private final Handler mHandler;
    protected final ServiceLogger mLog;
    protected final BlockingDeque<S> mStateQueue = new LinkedBlockingDeque();

    LifecycleStateWatcher(Handler handler, ServiceLogger serviceLogger) {
        this.mHandler = handler;
        this.mLog = serviceLogger;
    }

    /* access modifiers changed from: package-private */
    public void push(S s, final LifecycleEvaluator<S, M> lifecycleEvaluator) {
        if (this.mStateQueue.isEmpty() || this.mStateQueue.getLast() != s) {
            this.mLog.debug("Adding state: {}.{} to the notification queue", s.getClass().getSimpleName(), s.name());
            this.mStateQueue.add(s);
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (LifecycleStateWatcher.this.mStateQueue.isEmpty()) {
                        LifecycleStateWatcher.this.mLog.warn("State queue is empty.");
                        return;
                    }
                    Enum enumR = (Enum) LifecycleStateWatcher.this.mStateQueue.pop();
                    LifecycleStateWatcher.this.mLog.debug("Processing state {}", enumR.name());
                    lifecycleEvaluator.stateChanged(enumR);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
        private Handler mHandler;
        private ServiceLogger mLog;

        public Builder<S, M> handler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        public LifecycleStateWatcher<S, M> build(Class<S> cls) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            if (this.mLog == null) {
                this.mLog = ServiceLogging.getLogger(LifecycleStateWatcher.class, String.format("LifecycleStateWatcher:%s", new Object[]{cls.getSimpleName()}));
            }
            return new LifecycleStateWatcher<>(this.mHandler, this.mLog);
        }
    }
}
