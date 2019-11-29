package com.path.android.jobqueue;

import java.util.Collections;
import java.util.Set;

public class JobHolder {
    public static final int RUN_RESULT_FAIL_FOR_CANCEL = 3;
    public static final int RUN_RESULT_FAIL_RUN_LIMIT = 2;
    public static final int RUN_RESULT_SUCCESS = 1;
    public static final int RUN_RESULT_TRY_AGAIN = 4;
    private boolean cancelled;
    protected long createdNs;
    protected long delayUntilNs;
    protected String groupId;
    protected Long id;
    transient Job job;
    protected int priority;
    protected boolean requiresNetwork;
    protected int runCount;
    protected long runningSessionId;
    private boolean successful;
    protected final Set<String> tags;

    public JobHolder(Long l, int i, String str, int i2, Job job2, long j, long j2, long j3) {
        this.id = l;
        this.priority = i;
        this.groupId = str;
        this.runCount = i2;
        this.createdNs = j;
        this.delayUntilNs = j2;
        this.job = job2;
        job2.priority = i;
        this.runningSessionId = j3;
        this.requiresNetwork = job2.requiresNetwork();
        this.tags = job2.getTags() == null ? null : Collections.unmodifiableSet(job2.getTags());
    }

    public JobHolder(int i, Job job2, long j) {
        this((Long) null, i, (String) null, 0, job2, System.nanoTime(), Long.MIN_VALUE, j);
    }

    public JobHolder(int i, Job job2, long j, long j2) {
        this((Long) null, i, job2.getRunGroupId(), 0, job2, System.nanoTime(), j, j2);
    }

    public final int safeRun(int i) {
        return this.job.safeRun(this, i);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public boolean requiresNetwork() {
        return this.requiresNetwork;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
        this.job.priority = this.priority;
    }

    /* access modifiers changed from: package-private */
    public void setDelayUntilNs(long j) {
        this.delayUntilNs = j;
    }

    public int getRunCount() {
        return this.runCount;
    }

    public void setRunCount(int i) {
        this.runCount = i;
    }

    public long getCreatedNs() {
        return this.createdNs;
    }

    public void setCreatedNs(long j) {
        this.createdNs = j;
    }

    public long getRunningSessionId() {
        return this.runningSessionId;
    }

    public void setRunningSessionId(long j) {
        this.runningSessionId = j;
    }

    public long getDelayUntilNs() {
        return this.delayUntilNs;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job2) {
        this.job = job2;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public Set<String> getTags() {
        return this.tags;
    }

    public void markAsCancelled() {
        this.cancelled = true;
        this.job.cancelled = true;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public int hashCode() {
        Long l = this.id;
        if (l == null) {
            return super.hashCode();
        }
        return l.intValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JobHolder)) {
            return false;
        }
        JobHolder jobHolder = (JobHolder) obj;
        Long l = this.id;
        if (l != null) {
            Long l2 = jobHolder.id;
            if (l2 != null) {
                return l.equals(l2);
            }
        }
        return false;
    }

    public boolean hasTags() {
        Set<String> set = this.tags;
        return set != null && set.size() > 0;
    }

    public synchronized void markAsSuccessful() {
        this.successful = true;
    }

    public synchronized boolean isSuccessful() {
        return this.successful;
    }
}
