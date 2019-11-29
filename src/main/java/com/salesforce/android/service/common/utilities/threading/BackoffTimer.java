package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicInteger;

public class BackoffTimer implements HandlerManager {
    public static final long DEFAULT_INITIAL_TIMER_DELAY_MS = 1000;
    public static final int DEFAULT_MAX_ITERATIONS = 10;
    protected static final ServiceLogger log = ServiceLogging.getLogger(BackoffTimer.class);
    protected AtomicInteger mCurrentAttempt = new AtomicInteger();
    private long mCurrentTimerDelayMs;
    private final Handler mHandler;
    protected boolean mIsScheduled = false;
    private final int mMaxIterations;
    private final TimerRunnable mTimerRunnable;

    protected interface OnTimerExecutedListener {
        void onTimerExecuted();
    }

    protected BackoffTimer(Builder builder) {
        this.mTimerRunnable = new TimerRunnable(builder.mOnTimerElapsedListener, new OnTimerExecutedListener() {
            public void onTimerExecuted() {
                BackoffTimer.this.execute();
            }
        });
        this.mMaxIterations = builder.mMaxIterations;
        this.mCurrentTimerDelayMs = builder.mInitialTimerDelayMs;
        this.mHandler = builder.mHandler;
    }

    public boolean isScheduled() {
        return this.mIsScheduled;
    }

    public void schedule() {
        if (!this.mIsScheduled) {
            this.mIsScheduled = true;
            execute();
        }
    }

    public void cancel() {
        if (this.mIsScheduled) {
            log.trace("Cancelling the BackoffTimer.");
            this.mHandler.removeCallbacks(this.mTimerRunnable);
            this.mIsScheduled = false;
            this.mCurrentAttempt.set(0);
        }
    }

    /* access modifiers changed from: protected */
    public void execute() {
        if (this.mIsScheduled) {
            int i = this.mCurrentAttempt.get();
            int i2 = this.mMaxIterations;
            if (i >= i2) {
                log.warn("BackoffTimer has exceeded the maximum number of attempts ({}). Stopping.", Integer.valueOf(i2));
                cancel();
                return;
            }
            log.debug("Scheduling the BackoffTimer with a delay of {}ms", Long.valueOf(this.mCurrentTimerDelayMs));
            this.mCurrentAttempt.incrementAndGet();
            this.mHandler.postDelayed(this.mTimerRunnable, this.mCurrentTimerDelayMs);
            this.mCurrentTimerDelayMs *= 2;
        }
    }

    private static class TimerRunnable implements Runnable {
        private final HandlerManager.OnTimerElapsedListener mOnTimerElapsedListener;
        private final OnTimerExecutedListener mOnTimerExecutedListener;

        TimerRunnable(HandlerManager.OnTimerElapsedListener onTimerElapsedListener, OnTimerExecutedListener onTimerExecutedListener) {
            this.mOnTimerElapsedListener = onTimerElapsedListener;
            this.mOnTimerExecutedListener = onTimerExecutedListener;
        }

        public void run() {
            this.mOnTimerExecutedListener.onTimerExecuted();
            BackoffTimer.log.trace("Notifying the OnTimerElapsedListener that the BackoffTimer has elapsed.");
            this.mOnTimerElapsedListener.onTimerElapsed();
        }
    }

    public static class Builder implements HandlerManager.Builder {
        protected Handler mHandler;
        protected long mInitialTimerDelayMs = 1000;
        protected int mMaxIterations = 10;
        protected HandlerManager.OnTimerElapsedListener mOnTimerElapsedListener;

        public Builder onTimerElapsedListener(HandlerManager.OnTimerElapsedListener onTimerElapsedListener) {
            this.mOnTimerElapsedListener = onTimerElapsedListener;
            return this;
        }

        public Builder initialTimerDelayMs(long j) {
            this.mInitialTimerDelayMs = j;
            return this;
        }

        public Builder maxIterations(int i) {
            this.mMaxIterations = i;
            return this;
        }

        public Builder handler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        public BackoffTimer build() {
            Arguments.checkNotNull(this.mOnTimerElapsedListener);
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.myLooper());
            }
            return new BackoffTimer(this);
        }
    }
}
