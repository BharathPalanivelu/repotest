package com.path.android.jobqueue;

import java.util.Collection;
import java.util.HashSet;

public class CancelResult {
    Collection<Job> cancelledJobs = new HashSet();
    Collection<Job> failedToCancel = new HashSet();

    public interface AsyncCancelCallback {
        void onCancelled(CancelResult cancelResult);
    }

    public Collection<Job> getCancelledJobs() {
        return this.cancelledJobs;
    }

    public Collection<Job> getFailedToCancel() {
        return this.failedToCancel;
    }
}
