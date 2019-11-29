package com.path.android.jobqueue.nonPersistentQueue;

import java.util.Set;

public class CountWithGroupIdsResult {
    private int count;
    private Set<String> groupIds;

    public CountWithGroupIdsResult(int i, Set<String> set) {
        this.count = i;
        this.groupIds = set;
    }

    public int getCount() {
        return this.count;
    }

    public Set<String> getGroupIds() {
        return this.groupIds;
    }

    public CountWithGroupIdsResult mergeWith(CountWithGroupIdsResult countWithGroupIdsResult) {
        if (this.groupIds != null) {
            Set<String> set = countWithGroupIdsResult.groupIds;
            if (set != null) {
                int i = 0;
                for (String add : set) {
                    if (!this.groupIds.add(add)) {
                        i++;
                    }
                }
                this.count = (this.count + countWithGroupIdsResult.count) - i;
                return this;
            }
        }
        this.count += countWithGroupIdsResult.count;
        if (this.groupIds == null) {
            this.groupIds = countWithGroupIdsResult.groupIds;
        }
        return this;
    }
}
