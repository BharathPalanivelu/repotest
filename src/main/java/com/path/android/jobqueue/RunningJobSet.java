package com.path.android.jobqueue;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class RunningJobSet {
    private long groupDelayTimeout = Clock.MAX_TIME;
    private final Map<String, Long> groupDelays = new HashMap();
    private final TreeSet<String> internalSet = new TreeSet<>();
    private ArrayList<String> publicClone;

    public synchronized void addGroupUntil(String str, long j) {
        Long l = this.groupDelays.get(str);
        if (l == null || l.longValue() <= j) {
            this.groupDelays.put(str, Long.valueOf(j));
            this.groupDelayTimeout = calculateNextDelayForGroups();
            this.publicClone = null;
        }
    }

    public synchronized Collection<String> getSafe() {
        long now = now();
        if (this.publicClone == null || now > this.groupDelayTimeout) {
            if (this.groupDelays.isEmpty()) {
                this.publicClone = new ArrayList<>(this.internalSet);
                this.groupDelayTimeout = Clock.MAX_TIME;
            } else {
                TreeSet treeSet = new TreeSet(this.internalSet);
                Iterator<Map.Entry<String, Long>> it = this.groupDelays.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (((Long) next.getValue()).longValue() <= now) {
                        it.remove();
                    } else if (!treeSet.contains(next.getKey())) {
                        treeSet.add(next.getKey());
                    }
                }
                this.publicClone = new ArrayList<>(treeSet);
                this.groupDelayTimeout = calculateNextDelayForGroups();
            }
        }
        return this.publicClone;
    }

    public Long getNextDelayForGroups() {
        long j = this.groupDelayTimeout;
        if (j == Clock.MAX_TIME) {
            return null;
        }
        return Long.valueOf(j);
    }

    private long calculateNextDelayForGroups() {
        long j = Clock.MAX_TIME;
        for (Long next : this.groupDelays.values()) {
            if (next.longValue() < j) {
                j = next.longValue();
            }
        }
        return j;
    }

    public synchronized void add(String str) {
        if (this.internalSet.add(str)) {
            this.publicClone = null;
        }
    }

    public synchronized void remove(String str) {
        if (this.internalSet.remove(str)) {
            this.publicClone = null;
        }
    }

    public synchronized void clear() {
        this.internalSet.clear();
        this.groupDelays.clear();
        this.publicClone = null;
    }

    /* access modifiers changed from: protected */
    public long now() {
        return System.nanoTime();
    }
}
