package com.path.android.jobqueue.cachedQueue;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.JobQueue;
import com.path.android.jobqueue.TagConstraint;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CachedJobQueue implements JobQueue {
    private Cache cache = new Cache();
    JobQueue delegate;

    public CachedJobQueue(JobQueue jobQueue) {
        this.delegate = jobQueue;
    }

    public long insert(JobHolder jobHolder) {
        this.cache.invalidateAll();
        return this.delegate.insert(jobHolder);
    }

    public long insertOrReplace(JobHolder jobHolder) {
        this.cache.invalidateAll();
        return this.delegate.insertOrReplace(jobHolder);
    }

    public void remove(JobHolder jobHolder) {
        this.cache.invalidateAll();
        this.delegate.remove(jobHolder);
    }

    public int count() {
        if (this.cache.count == null) {
            this.cache.count = Integer.valueOf(this.delegate.count());
        }
        return this.cache.count.intValue();
    }

    public int countReadyJobs(boolean z, Collection<String> collection) {
        if (this.cache.count != null && this.cache.count.intValue() < 1) {
            return 0;
        }
        int countReadyJobs = this.delegate.countReadyJobs(z, collection);
        if (countReadyJobs == 0) {
            count();
        }
        return countReadyJobs;
    }

    public JobHolder nextJobAndIncRunCount(boolean z, Collection<String> collection) {
        if (this.cache.count != null && this.cache.count.intValue() < 1) {
            return null;
        }
        JobHolder nextJobAndIncRunCount = this.delegate.nextJobAndIncRunCount(z, collection);
        if (nextJobAndIncRunCount == null) {
            count();
        } else if (this.cache.count != null) {
            Cache cache2 = this.cache;
            Integer num = cache2.count;
            cache2.count = Integer.valueOf(cache2.count.intValue() - 1);
        }
        return nextJobAndIncRunCount;
    }

    public Long getNextJobDelayUntilNs(boolean z, Collection<String> collection) {
        if (this.cache.delayUntil == null) {
            this.cache.delayUntil = new Cache.DelayUntil(z, this.delegate.getNextJobDelayUntilNs(z, collection), collection);
        } else if (!this.cache.delayUntil.isValid(z, collection)) {
            this.cache.delayUntil.set(z, this.delegate.getNextJobDelayUntilNs(z, collection), collection);
        }
        return this.cache.delayUntil.value;
    }

    public void clear() {
        this.cache.invalidateAll();
        this.delegate.clear();
    }

    public Set<JobHolder> findJobsByTags(TagConstraint tagConstraint, boolean z, Collection<Long> collection, String... strArr) {
        return this.delegate.findJobsByTags(tagConstraint, z, collection, strArr);
    }

    public void onJobCancelled(JobHolder jobHolder) {
        this.delegate.onJobCancelled(jobHolder);
    }

    public JobHolder findJobById(long j) {
        return this.delegate.findJobById(j);
    }

    private static class Cache {
        Integer count;
        DelayUntil delayUntil;

        private Cache() {
        }

        public void invalidateAll() {
            this.count = null;
            this.delayUntil = null;
        }

        private static class DelayUntil {
            Collection<String> excludeGroups;
            boolean hasNetwork;
            Long value;

            private DelayUntil(boolean z, Long l, Collection<String> collection) {
                this.value = l;
                this.hasNetwork = z;
                this.excludeGroups = collection;
            }

            /* access modifiers changed from: private */
            public boolean isValid(boolean z, Collection<String> collection) {
                return this.hasNetwork == z && validateExcludes(collection);
            }

            private boolean validateExcludes(Collection<String> collection) {
                Collection<String> collection2 = this.excludeGroups;
                if (collection2 == collection) {
                    return true;
                }
                if (collection2 == null || collection == null || collection2.size() != collection.size()) {
                    return false;
                }
                Iterator<String> it = collection.iterator();
                for (String equals : this.excludeGroups) {
                    if (!equals.equals(it.next())) {
                        return false;
                    }
                }
                return true;
            }

            public void set(boolean z, Long l, Collection<String> collection) {
                this.value = l;
                this.hasNetwork = z;
                this.excludeGroups = collection;
            }
        }
    }
}
