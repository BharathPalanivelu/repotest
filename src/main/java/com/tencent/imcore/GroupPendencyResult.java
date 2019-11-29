package com.tencent.imcore;

public class GroupPendencyResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupPendencyResult() {
        this(internalGroupExtJNI.new_GroupPendencyResult(), true);
    }

    protected GroupPendencyResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupPendencyResult groupPendencyResult) {
        if (groupPendencyResult == null) {
            return 0;
        }
        return groupPendencyResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupPendencyResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupPendencyItemVec getItems() {
        long GroupPendencyResult_items_get = internalGroupExtJNI.GroupPendencyResult_items_get(this.swigCPtr, this);
        if (GroupPendencyResult_items_get == 0) {
            return null;
        }
        return new GroupPendencyItemVec(GroupPendencyResult_items_get, false);
    }

    public GroupPendencyMeta getMeta() {
        long GroupPendencyResult_meta_get = internalGroupExtJNI.GroupPendencyResult_meta_get(this.swigCPtr, this);
        if (GroupPendencyResult_meta_get == 0) {
            return null;
        }
        return new GroupPendencyMeta(GroupPendencyResult_meta_get, false);
    }

    public void setItems(GroupPendencyItemVec groupPendencyItemVec) {
        internalGroupExtJNI.GroupPendencyResult_items_set(this.swigCPtr, this, GroupPendencyItemVec.getCPtr(groupPendencyItemVec), groupPendencyItemVec);
    }

    public void setMeta(GroupPendencyMeta groupPendencyMeta) {
        internalGroupExtJNI.GroupPendencyResult_meta_set(this.swigCPtr, this, GroupPendencyMeta.getCPtr(groupPendencyMeta), groupPendencyMeta);
    }
}
