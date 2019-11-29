package com.tencent.imsdk.ext.sns;

import java.util.Map;

public class TIMFriendRecommendItem {
    private long addTime;
    private String identifier;
    private Map<String, byte[]> tags;

    public long getAddTime() {
        return this.addTime;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public Map<String, byte[]> getTags() {
        return this.tags;
    }

    /* access modifiers changed from: package-private */
    public void setAddTime(long j) {
        this.addTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setIdentifier(String str) {
        this.identifier = str;
    }

    /* access modifiers changed from: package-private */
    public void setTags(Map<String, byte[]> map) {
        this.tags = map;
    }
}
