package com.path.android.jobqueue.nonPersistentQueue;

import com.path.android.jobqueue.JobHolder;
import com.path.android.jobqueue.TagConstraint;
import com.path.android.jobqueue.log.JqLog;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NonPersistentJobSet implements JobSet {
    private final Map<String, Integer> existingGroups = new HashMap();
    private final Map<Long, JobHolder> idCache = new HashMap();
    private final TreeSet<JobHolder> set;
    private final Map<String, List<JobHolder>> tagCache = new HashMap();

    public NonPersistentJobSet(Comparator<JobHolder> comparator) {
        this.set = new TreeSet<>(comparator);
    }

    private JobHolder safeFirst() {
        if (this.set.size() < 1) {
            return null;
        }
        return this.set.first();
    }

    public JobHolder peek(Collection<String> collection) {
        if (collection == null || collection.size() == 0) {
            return safeFirst();
        }
        Iterator<JobHolder> it = this.set.iterator();
        while (it.hasNext()) {
            JobHolder next = it.next();
            if (next.getGroupId() == null) {
                return next;
            }
            if (!collection.contains(next.getGroupId())) {
                return next;
            }
        }
        return null;
    }

    private JobHolder safePeek() {
        if (this.set.size() == 0) {
            return null;
        }
        return safeFirst();
    }

    public JobHolder poll(Collection<String> collection) {
        JobHolder peek = peek(collection);
        if (peek != null) {
            remove(peek);
        }
        return peek;
    }

    public JobHolder findById(long j) {
        return this.idCache.get(Long.valueOf(j));
    }

    public Set<JobHolder> findByTags(TagConstraint tagConstraint, Collection<Long> collection, String... strArr) {
        if (strArr == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        boolean z = true;
        for (String str : strArr) {
            List list = this.tagCache.get(str);
            if (list != null && list.size() != 0) {
                if (tagConstraint == TagConstraint.ALL) {
                    hashSet.addAll(list);
                } else if (z) {
                    hashSet.addAll(list);
                } else {
                    removeIfNotExists(hashSet, list);
                    if (hashSet.size() == 0) {
                        return Collections.emptySet();
                    }
                }
                z = false;
            } else if (tagConstraint == TagConstraint.ALL) {
                return Collections.emptySet();
            }
        }
        if (collection != null) {
            removeIds(hashSet, collection);
        }
        return hashSet;
    }

    private void removeIds(Set<JobHolder> set2, Collection<Long> collection) {
        Iterator<JobHolder> it = set2.iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next().getId())) {
                it.remove();
            }
        }
    }

    private void removeIfNotExists(Set<JobHolder> set2, List<JobHolder> list) {
        Iterator<JobHolder> it = set2.iterator();
        while (it.hasNext()) {
            if (!list.contains(it.next())) {
                it.remove();
            }
        }
    }

    public boolean offer(JobHolder jobHolder) {
        if (jobHolder.getId() != null) {
            boolean add = this.set.add(jobHolder);
            if (!add) {
                remove(jobHolder);
                add = this.set.add(jobHolder);
            }
            if (add) {
                this.idCache.put(jobHolder.getId(), jobHolder);
                addToTagCache(jobHolder);
                if (jobHolder.getGroupId() != null) {
                    incGroupCount(jobHolder.getGroupId());
                }
            }
            return add;
        }
        throw new RuntimeException("cannot add job holder w/o an ID");
    }

    private void addToTagCache(JobHolder jobHolder) {
        Set<String> tags = jobHolder.getTags();
        if (tags != null && tags.size() != 0) {
            for (String next : tags) {
                List list = this.tagCache.get(next);
                if (list == null) {
                    list = new LinkedList();
                    this.tagCache.put(next, list);
                }
                list.add(jobHolder);
            }
        }
    }

    private void removeFromTagCache(JobHolder jobHolder) {
        Set<String> tags = jobHolder.getTags();
        if (tags != null && tags.size() != 0) {
            for (String next : tags) {
                List list = this.tagCache.get(next);
                if (list == null) {
                    JqLog.e("trying to remove job from tag cache but cannot find the tag cache", new Object[0]);
                    return;
                } else if (!list.remove(jobHolder)) {
                    JqLog.e("trying to remove job from tag cache but cannot find it in the cache", new Object[0]);
                } else if (list.size() == 0) {
                    this.tagCache.remove(next);
                }
            }
        }
    }

    private void incGroupCount(String str) {
        if (!this.existingGroups.containsKey(str)) {
            this.existingGroups.put(str, 1);
            return;
        }
        Map<String, Integer> map = this.existingGroups;
        map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
    }

    private void decGroupCount(String str) {
        Integer num = this.existingGroups.get(str);
        if (num == null || num.intValue() <= 0) {
            JqLog.e("detected inconsistency in NonPersistentJobSet's group id hash. Please report a bug", new Object[0]);
            this.existingGroups.remove(str);
            return;
        }
        Integer valueOf = Integer.valueOf(num.intValue() - 1);
        if (valueOf.intValue() == 0) {
            this.existingGroups.remove(str);
        } else {
            this.existingGroups.put(str, valueOf);
        }
    }

    public boolean remove(JobHolder jobHolder) {
        boolean remove = this.set.remove(jobHolder);
        if (remove) {
            this.idCache.remove(jobHolder.getId());
            removeFromTagCache(jobHolder);
            if (jobHolder.getGroupId() != null) {
                decGroupCount(jobHolder.getGroupId());
            }
        }
        return remove;
    }

    public void clear() {
        this.set.clear();
        this.existingGroups.clear();
        this.idCache.clear();
        this.tagCache.clear();
    }

    public int size() {
        return this.set.size();
    }

    public CountWithGroupIdsResult countReadyJobs(long j, Collection<String> collection) {
        int size = this.existingGroups.keySet().size();
        HashSet hashSet = size > 0 ? new HashSet() : null;
        Iterator<JobHolder> it = this.set.iterator();
        int i = 0;
        while (it.hasNext()) {
            JobHolder next = it.next();
            if (next.getDelayUntilNs() < j && (next.getGroupId() == null || ((collection == null || !collection.contains(next.getGroupId())) && size > 0 && hashSet.add(next.getGroupId())))) {
                i++;
            }
        }
        return new CountWithGroupIdsResult(i, hashSet);
    }

    public CountWithGroupIdsResult countReadyJobs(Collection<String> collection) {
        HashSet hashSet = null;
        if (this.existingGroups.size() == 0) {
            return new CountWithGroupIdsResult(this.set.size(), (Set<String>) null);
        }
        int i = 0;
        Iterator<JobHolder> it = this.set.iterator();
        while (it.hasNext()) {
            JobHolder next = it.next();
            if (next.getGroupId() != null) {
                if (collection == null || !collection.contains(next.getGroupId())) {
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        hashSet.add(next.getGroupId());
                    } else if (!hashSet.add(next.getGroupId())) {
                    }
                }
            }
            i++;
        }
        return new CountWithGroupIdsResult(i, hashSet);
    }
}
