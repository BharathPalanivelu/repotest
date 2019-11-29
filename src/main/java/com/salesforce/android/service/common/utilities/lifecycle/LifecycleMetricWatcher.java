package com.salesforce.android.service.common.utilities.lifecycle;

import android.os.Handler;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.Enum;

public class LifecycleMetricWatcher<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final ServiceLogger mLog;
    private boolean mStopped;

    LifecycleMetricWatcher(Handler handler, ServiceLogger serviceLogger) {
        this.mHandler = handler;
        this.mLog = serviceLogger;
    }

    /* access modifiers changed from: package-private */
    public void watch(S s, final LifecycleEvaluator lifecycleEvaluator) {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        for (final Enum enumR : ((LifecycleState) s).getMetrics()) {
            LifecycleMetric lifecycleMetric = (LifecycleMetric) enumR;
            if (lifecycleMetric.getTimeoutMs() != null && lifecycleMetric.getTimeoutMs().intValue() > 0) {
                this.mLog.debug("Starting timeout for metric: {} on state: {}", enumR.name(), s.name());
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (!LifecycleMetricWatcher.this.isStopped() && !lifecycleEvaluator.isMetricSatisfied(enumR)) {
                            LifecycleMetricWatcher.this.mLog.debug("Metric {} timed out after {} ms", enumR.name(), ((LifecycleMetric) enumR).getTimeoutMs());
                            lifecycleEvaluator.metricTimedOut(enumR);
                            LifecycleMetricWatcher.this.stop();
                        }
                    }
                }, (long) lifecycleMetric.getTimeoutMs().intValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isStopped() {
        return this.mStopped;
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mStopped = true;
    }

    public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {
        private Handler mHandler;
        private ServiceLogger mLog;

        public Builder<S, M> handler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        public Builder<S, M> logger(ServiceLogger serviceLogger) {
            this.mLog = serviceLogger;
            return this;
        }

        public LifecycleMetricWatcher<S, M> build(Class<S> cls) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            if (this.mLog == null) {
                this.mLog = ServiceLogging.getLogger(LifecycleEvaluator.class, String.format("LifecycleMetricWatcher:%s", new Object[]{cls.getSimpleName()}));
            }
            return new LifecycleMetricWatcher<>(this.mHandler, this.mLog);
        }
    }
}
