package com.path.android.jobqueue;

import java.util.Collection;
import java.util.Set;

public interface JobQueue {
    void clear();

    int count();

    int countReadyJobs(boolean z, Collection<String> collection);

    JobHolder findJobById(long j);

    Set<JobHolder> findJobsByTags(TagConstraint tagConstraint, boolean z, Collection<Long> collection, String... strArr);

    Long getNextJobDelayUntilNs(boolean z, Collection<String> collection);

    long insert(JobHolder jobHolder);

    long insertOrReplace(JobHolder jobHolder);

    JobHolder nextJobAndIncRunCount(boolean z, Collection<String> collection);

    void onJobCancelled(JobHolder jobHolder);

    void remove(JobHolder jobHolder);
}
