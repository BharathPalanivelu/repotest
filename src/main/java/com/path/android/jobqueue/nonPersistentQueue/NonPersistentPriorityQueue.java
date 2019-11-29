package com.path.android.jobqueue.nonPersistentQueue;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.JobQueue;
import com.path.android.jobqueue.TagConstraint;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

public class NonPersistentPriorityQueue implements JobQueue {
    private final String id;
    public final Comparator<JobHolder> jobComparator = new Comparator<JobHolder>() {
        public int compare(JobHolder jobHolder, JobHolder jobHolder2) {
            int access$000 = NonPersistentPriorityQueue.compareInt(jobHolder.getPriority(), jobHolder2.getPriority());
            if (access$000 != 0) {
                return access$000;
            }
            int i = -NonPersistentPriorityQueue.compareLong(jobHolder.getCreatedNs(), jobHolder2.getCreatedNs());
            if (i != 0) {
                return i;
            }
            return -NonPersistentPriorityQueue.compareLong(jobHolder.getId().longValue(), jobHolder2.getId().longValue());
        }
    };
    private NetworkAwarePriorityQueue jobs;
    private long nonPersistentJobIdGenerator = -2147483648L;
    private final long sessionId;

    /* access modifiers changed from: private */
    public static int compareInt(int i, int i2) {
        if (i > i2) {
            return -1;
        }
        return i2 > i ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static int compareLong(long j, long j2) {
        if (j > j2) {
            return -1;
        }
        return j2 > j ? 1 : 0;
    }

    public NonPersistentPriorityQueue(long j, String str, boolean z) {
        this.id = str;
        this.sessionId = j;
        this.jobs = new NetworkAwarePriorityQueue(5, this.jobComparator);
    }

    public synchronized long insert(JobHolder jobHolder) {
        this.nonPersistentJobIdGenerator++;
        jobHolder.setId(Long.valueOf(this.nonPersistentJobIdGenerator));
        this.jobs.offer(jobHolder);
        return jobHolder.getId().longValue();
    }

    public long insertOrReplace(JobHolder jobHolder) {
        remove(jobHolder);
        jobHolder.setRunningSessionId(Long.MIN_VALUE);
        this.jobs.offer(jobHolder);
        return jobHolder.getId().longValue();
    }

    public void remove(JobHolder jobHolder) {
        this.jobs.remove(jobHolder);
    }

    public int count() {
        return this.jobs.size();
    }

    public int countReadyJobs(boolean z, Collection<String> collection) {
        return this.jobs.countReadyJobs(z, collection).getCount();
    }

    public JobHolder nextJobAndIncRunCount(boolean z, Collection<String> collection) {
        JobHolder peek = this.jobs.peek(z, collection);
        if (peek == null) {
            return peek;
        }
        if (peek.getDelayUntilNs() > System.nanoTime()) {
            return null;
        }
        peek.setRunningSessionId(this.sessionId);
        peek.setRunCount(peek.getRunCount() + 1);
        this.jobs.remove(peek);
        return peek;
    }

    public Long getNextJobDelayUntilNs(boolean z, Collection<String> collection) {
        JobHolder peek = this.jobs.peek(z, collection);
        if (peek == null) {
            return null;
        }
        return Long.valueOf(peek.getDelayUntilNs());
    }

    public void clear() {
        this.jobs.clear();
    }

    public JobHolder findJobById(long j) {
        return this.jobs.findById(j);
    }

    public Set<JobHolder> findJobsByTags(TagConstraint tagConstraint, boolean z, Collection<Long> collection, String... strArr) {
        return this.jobs.findByTags(tagConstraint, collection, strArr);
    }

    public void onJobCancelled(JobHolder jobHolder) {
        remove(jobHolder);
    }
}
