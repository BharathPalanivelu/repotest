package com.path.android.jobqueue.nonPersistentQueue;

import com.path.android.jobqueue.JobHolder;
import java.util.Comparator;

public class TimeAwareComparator implements Comparator<JobHolder> {
    final Comparator<JobHolder> baseComparator;

    public TimeAwareComparator(Comparator<JobHolder> comparator) {
        this.baseComparator = comparator;
    }

    public int compare(JobHolder jobHolder, JobHolder jobHolder2) {
        long nanoTime = System.nanoTime();
        boolean z = false;
        boolean z2 = jobHolder.getDelayUntilNs() <= nanoTime;
        if (jobHolder2.getDelayUntilNs() <= nanoTime) {
            z = true;
        }
        if (z2) {
            if (z) {
                return this.baseComparator.compare(jobHolder, jobHolder2);
            }
            return -1;
        } else if (z) {
            if (z2) {
                return this.baseComparator.compare(jobHolder, jobHolder2);
            }
            return 1;
        } else if (jobHolder.getDelayUntilNs() < jobHolder2.getDelayUntilNs()) {
            return -1;
        } else {
            if (jobHolder.getDelayUntilNs() > jobHolder2.getDelayUntilNs()) {
                return 1;
            }
            return this.baseComparator.compare(jobHolder, jobHolder2);
        }
    }
}
