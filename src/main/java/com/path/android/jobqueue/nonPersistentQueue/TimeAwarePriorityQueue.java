package com.path.android.jobqueue.nonPersistentQueue;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.nonPersistentQueue.MergedQueue;
import java.util.Collection;
import java.util.Comparator;

public class TimeAwarePriorityQueue extends MergedQueue {
    public TimeAwarePriorityQueue(int i, Comparator<JobHolder> comparator) {
        super(i, comparator, new TimeAwareComparator(comparator));
    }

    /* access modifiers changed from: protected */
    public MergedQueue.SetId decideQueue(JobHolder jobHolder) {
        return jobHolder.getDelayUntilNs() <= System.nanoTime() ? MergedQueue.SetId.S0 : MergedQueue.SetId.S1;
    }

    /* access modifiers changed from: protected */
    public JobSet createQueue(MergedQueue.SetId setId, int i, Comparator<JobHolder> comparator) {
        if (setId == MergedQueue.SetId.S0) {
            return new NonPersistentJobSet(comparator);
        }
        return new NonPersistentJobSet(new ConsistentTimedComparator(comparator));
    }

    public CountWithGroupIdsResult countReadyJobs(long j, Collection<String> collection) {
        return super.countReadyJobs(MergedQueue.SetId.S0, collection).mergeWith(super.countReadyJobs(MergedQueue.SetId.S1, j, collection));
    }

    public CountWithGroupIdsResult countReadyJobs(Collection<String> collection) {
        throw new UnsupportedOperationException("cannot call time aware priority queue's count ready jobs w/o providing a time");
    }
}
