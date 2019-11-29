package com.path.android.jobqueue.nonPersistentQueue;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.nonPersistentQueue.MergedQueue;
import java.util.Collection;
import java.util.Comparator;

public class NetworkAwarePriorityQueue extends MergedQueue {
    public NetworkAwarePriorityQueue(int i, Comparator<JobHolder> comparator) {
        super(i, comparator, new TimeAwareComparator(comparator));
    }

    public JobHolder peek(boolean z, Collection<String> collection) {
        if (z) {
            return super.peek(collection);
        }
        return super.peekFromQueue(MergedQueue.SetId.S1, collection);
    }

    public JobHolder poll(boolean z, Collection<String> collection) {
        if (z) {
            return super.peek(collection);
        }
        return super.peekFromQueue(MergedQueue.SetId.S1, collection);
    }

    /* access modifiers changed from: protected */
    public MergedQueue.SetId decideQueue(JobHolder jobHolder) {
        return jobHolder.requiresNetwork() ? MergedQueue.SetId.S0 : MergedQueue.SetId.S1;
    }

    /* access modifiers changed from: protected */
    public JobSet createQueue(MergedQueue.SetId setId, int i, Comparator<JobHolder> comparator) {
        return new TimeAwarePriorityQueue(i, comparator);
    }

    public CountWithGroupIdsResult countReadyJobs(boolean z, Collection<String> collection) {
        long nanoTime = System.nanoTime();
        if (z) {
            return super.countReadyJobs(MergedQueue.SetId.S0, nanoTime, collection).mergeWith(super.countReadyJobs(MergedQueue.SetId.S1, nanoTime, collection));
        }
        return super.countReadyJobs(MergedQueue.SetId.S1, nanoTime, collection);
    }

    public CountWithGroupIdsResult countReadyJobs(long j, Collection<String> collection) {
        throw new UnsupportedOperationException("cannot call network aware priority queue count w/o providing network status");
    }

    public CountWithGroupIdsResult countReadyJobs(Collection<String> collection) {
        throw new UnsupportedOperationException("cannot call network aware priority queue count w/o providing network status");
    }
}
