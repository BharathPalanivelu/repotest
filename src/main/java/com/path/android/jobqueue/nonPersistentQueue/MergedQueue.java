package com.path.android.jobqueue.nonPersistentQueue;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.TagConstraint;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public abstract class MergedQueue implements JobSet {
    final Comparator<JobHolder> comparator;
    JobSet queue0;
    JobSet queue1;
    final Comparator<JobHolder> retrieveComparator;

    protected enum SetId {
        S0,
        S1
    }

    /* access modifiers changed from: protected */
    public abstract JobSet createQueue(SetId setId, int i, Comparator<JobHolder> comparator2);

    /* access modifiers changed from: protected */
    public abstract SetId decideQueue(JobHolder jobHolder);

    public MergedQueue(int i, Comparator<JobHolder> comparator2, Comparator<JobHolder> comparator3) {
        this.comparator = comparator2;
        this.retrieveComparator = comparator3;
        this.queue0 = createQueue(SetId.S0, i, comparator2);
        this.queue1 = createQueue(SetId.S1, i, comparator2);
    }

    /* access modifiers changed from: protected */
    public JobHolder pollFromQueue(SetId setId, Collection<String> collection) {
        if (setId == SetId.S0) {
            return this.queue0.poll(collection);
        }
        return this.queue1.poll(collection);
    }

    /* access modifiers changed from: protected */
    public JobHolder peekFromQueue(SetId setId, Collection<String> collection) {
        if (setId == SetId.S0) {
            return this.queue0.peek(collection);
        }
        return this.queue1.peek(collection);
    }

    public boolean offer(JobHolder jobHolder) {
        if (decideQueue(jobHolder) == SetId.S0) {
            return this.queue0.offer(jobHolder);
        }
        return this.queue1.offer(jobHolder);
    }

    public JobHolder poll(Collection<String> collection) {
        JobHolder peek = this.queue0.peek(collection);
        if (peek == null) {
            return this.queue1.poll(collection);
        }
        if (decideQueue(peek) != SetId.S0) {
            this.queue0.remove(peek);
            this.queue1.offer(peek);
            return poll(collection);
        }
        JobHolder peek2 = this.queue1.peek(collection);
        if (peek2 == null) {
            this.queue0.remove(peek);
            return peek;
        } else if (decideQueue(peek2) != SetId.S1) {
            this.queue0.offer(peek2);
            this.queue1.remove(peek2);
            return poll(collection);
        } else if (this.retrieveComparator.compare(peek, peek2) == -1) {
            this.queue0.remove(peek);
            return peek;
        } else {
            this.queue1.remove(peek2);
            return peek2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.path.android.jobqueue.JobHolder peek(java.util.Collection<java.lang.String> r5) {
        /*
            r4 = this;
        L_0x0000:
            com.path.android.jobqueue.nonPersistentQueue.JobSet r0 = r4.queue0
            com.path.android.jobqueue.JobHolder r0 = r0.peek(r5)
            if (r0 == 0) goto L_0x001b
            com.path.android.jobqueue.nonPersistentQueue.MergedQueue$SetId r1 = r4.decideQueue(r0)
            com.path.android.jobqueue.nonPersistentQueue.MergedQueue$SetId r2 = com.path.android.jobqueue.nonPersistentQueue.MergedQueue.SetId.S0
            if (r1 == r2) goto L_0x001b
            com.path.android.jobqueue.nonPersistentQueue.JobSet r1 = r4.queue1
            r1.offer(r0)
            com.path.android.jobqueue.nonPersistentQueue.JobSet r1 = r4.queue0
            r1.remove(r0)
            goto L_0x0000
        L_0x001b:
            com.path.android.jobqueue.nonPersistentQueue.JobSet r1 = r4.queue1
            com.path.android.jobqueue.JobHolder r1 = r1.peek(r5)
            if (r1 == 0) goto L_0x0036
            com.path.android.jobqueue.nonPersistentQueue.MergedQueue$SetId r2 = r4.decideQueue(r1)
            com.path.android.jobqueue.nonPersistentQueue.MergedQueue$SetId r3 = com.path.android.jobqueue.nonPersistentQueue.MergedQueue.SetId.S1
            if (r2 == r3) goto L_0x0036
            com.path.android.jobqueue.nonPersistentQueue.JobSet r0 = r4.queue0
            r0.offer(r1)
            com.path.android.jobqueue.nonPersistentQueue.JobSet r0 = r4.queue1
            r0.remove(r1)
            goto L_0x0000
        L_0x0036:
            if (r0 != 0) goto L_0x0039
            return r1
        L_0x0039:
            if (r1 != 0) goto L_0x003c
            return r0
        L_0x003c:
            java.util.Comparator<com.path.android.jobqueue.JobHolder> r5 = r4.retrieveComparator
            int r5 = r5.compare(r0, r1)
            r2 = -1
            if (r5 != r2) goto L_0x0046
            return r0
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.path.android.jobqueue.nonPersistentQueue.MergedQueue.peek(java.util.Collection):com.path.android.jobqueue.JobHolder");
    }

    public void clear() {
        this.queue1.clear();
        this.queue0.clear();
    }

    public boolean remove(JobHolder jobHolder) {
        return this.queue1.remove(jobHolder) || this.queue0.remove(jobHolder);
    }

    public int size() {
        return this.queue0.size() + this.queue1.size();
    }

    public CountWithGroupIdsResult countReadyJobs(SetId setId, long j, Collection<String> collection) {
        if (setId == SetId.S0) {
            return this.queue0.countReadyJobs(j, collection);
        }
        return this.queue1.countReadyJobs(j, collection);
    }

    public CountWithGroupIdsResult countReadyJobs(SetId setId, Collection<String> collection) {
        if (setId == SetId.S0) {
            return this.queue0.countReadyJobs(collection);
        }
        return this.queue1.countReadyJobs(collection);
    }

    public JobHolder findById(long j) {
        JobHolder findById = this.queue0.findById(j);
        return findById == null ? this.queue1.findById(j) : findById;
    }

    public Set<JobHolder> findByTags(TagConstraint tagConstraint, Collection<Long> collection, String... strArr) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.queue0.findByTags(tagConstraint, collection, strArr));
        hashSet.addAll(this.queue1.findByTags(tagConstraint, collection, strArr));
        return hashSet;
    }
}
