package com.path.android.jobqueue;

import java.util.HashSet;

public class Params {
    private long delayMs;
    private String groupId = null;
    private boolean persistent = false;
    private int priority;
    private boolean requiresNetwork = false;
    private HashSet<String> tags;

    public Params(int i) {
        this.priority = i;
    }

    public Params requireNetwork() {
        this.requiresNetwork = true;
        return this;
    }

    public Params groupBy(String str) {
        this.groupId = str;
        return this;
    }

    public Params persist() {
        this.persistent = true;
        return this;
    }

    public Params delayInMs(long j) {
        this.delayMs = j;
        return this;
    }

    public Params setRequiresNetwork(boolean z) {
        this.requiresNetwork = z;
        return this;
    }

    public Params setGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public Params setPersistent(boolean z) {
        this.persistent = z;
        return this;
    }

    public Params setDelayMs(long j) {
        this.delayMs = j;
        return this;
    }

    public Params addTags(String... strArr) {
        if (this.tags == null) {
            this.tags = new HashSet<>();
        }
        for (String add : strArr) {
            this.tags.add(add);
        }
        return this;
    }

    public Params removeTags(String... strArr) {
        if (this.tags == null) {
            return this;
        }
        for (String remove : strArr) {
            this.tags.remove(remove);
        }
        return this;
    }

    public Params clearTags() {
        this.tags = null;
        return this;
    }

    public boolean doesRequireNetwork() {
        return this.requiresNetwork;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getDelayMs() {
        return this.delayMs;
    }

    public HashSet<String> getTags() {
        return this.tags;
    }
}
