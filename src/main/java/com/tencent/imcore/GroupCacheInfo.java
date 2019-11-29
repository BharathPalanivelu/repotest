package com.tencent.imcore;

public class GroupCacheInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupCacheInfo() {
        this(internalGroupExtJNI.new_GroupCacheInfo(), true);
    }

    protected GroupCacheInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupCacheInfo groupCacheInfo) {
        if (groupCacheInfo == null) {
            return 0;
        }
        return groupCacheInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupCacheInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupDetailInfo getGroupInfo() {
        long GroupCacheInfo_groupInfo_get = internalGroupExtJNI.GroupCacheInfo_groupInfo_get(this.swigCPtr, this);
        if (GroupCacheInfo_groupInfo_get == 0) {
            return null;
        }
        return new GroupDetailInfo(GroupCacheInfo_groupInfo_get, false);
    }

    public GroupSelfInfo getSelfInfo() {
        long GroupCacheInfo_selfInfo_get = internalGroupExtJNI.GroupCacheInfo_selfInfo_get(this.swigCPtr, this);
        if (GroupCacheInfo_selfInfo_get == 0) {
            return null;
        }
        return new GroupSelfInfo(GroupCacheInfo_selfInfo_get, false);
    }

    public void setGroupInfo(GroupDetailInfo groupDetailInfo) {
        internalGroupExtJNI.GroupCacheInfo_groupInfo_set(this.swigCPtr, this, GroupDetailInfo.getCPtr(groupDetailInfo), groupDetailInfo);
    }

    public void setSelfInfo(GroupSelfInfo groupSelfInfo) {
        internalGroupExtJNI.GroupCacheInfo_selfInfo_set(this.swigCPtr, this, GroupSelfInfo.getCPtr(groupSelfInfo), groupSelfInfo);
    }
}
