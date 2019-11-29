package com.salesforce.android.service.common.utilities.threading;

public interface HandlerManager {

    public interface Builder {
        HandlerManager build();

        Builder onTimerElapsedListener(OnTimerElapsedListener onTimerElapsedListener);
    }

    public interface OnTimerElapsedListener {
        void onTimerElapsed();
    }

    void cancel();

    boolean isScheduled();

    void schedule();
}
