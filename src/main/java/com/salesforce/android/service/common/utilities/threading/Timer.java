package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class Timer implements HandlerManager {
    public static final long DEFAULT_TIMER_DELAY_MS = 15000;
    protected static final ServiceLogger log = ServiceLogging.getLogger(Timer.class);
    private final Handler mHandler;
    protected boolean mIsScheduled = false;
    private final long mTimerDelayMs;
    private final TimerRunnable mTimerRunnable;

    protected interface OnTimerExecutedListener {
        void onTimerExecuted();
    }

    protected Timer(Builder builder) {
        this.mTimerRunnable = new TimerRunnable(builder.mOnTimerElapsedListener, new OnTimerExecutedListener() {
            public void onTimerExecuted() {
                Timer.this.mIsScheduled = false;
            }
        });
        this.mTimerDelayMs = builder.mTimerDelayMs;
        this.mHandler = builder.mHandler;
    }

    public boolean isScheduled() {
        return this.mIsScheduled;
    }

    public void schedule() {
        if (!this.mIsScheduled) {
            log.debug("Scheduling the timer with a delay of {}ms", Long.valueOf(this.mTimerDelayMs));
            this.mHandler.postDelayed(this.mTimerRunnable, this.mTimerDelayMs);
            this.mIsScheduled = true;
        }
    }

    public void cancel() {
        if (this.mIsScheduled) {
            log.debug("Cancelling the timer.");
            this.mHandler.removeCallbacks(this.mTimerRunnable);
            this.mIsScheduled = false;
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
            Timer.log.trace("Notifying the OnTimerElapsedListener that the timer has elapsed.");
            this.mOnTimerElapsedListener.onTimerElapsed();
        }
    }

    public static class Builder implements HandlerManager.Builder {
        protected Handler mHandler;
        protected HandlerManager.OnTimerElapsedListener mOnTimerElapsedListener;
        protected long mTimerDelayMs = Timer.DEFAULT_TIMER_DELAY_MS;

        public Builder onTimerElapsedListener(HandlerManager.OnTimerElapsedListener onTimerElapsedListener) {
            this.mOnTimerElapsedListener = onTimerElapsedListener;
            return this;
        }

        public Builder timerDelayMs(long j) {
            this.mTimerDelayMs = j;
            return this;
        }

        public Builder handler(Handler handler) {
            this.mHandler = handler;
            return this;
        }

        public Timer build() {
            Arguments.checkNotNull(this.mOnTimerElapsedListener);
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.myLooper());
            }
            return new Timer(this);
        }
    }
}
