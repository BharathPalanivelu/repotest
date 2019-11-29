package com.tencent.imcore;

public class GroupPendencyItemVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupPendencyItemVec() {
        this(internalGroupExtJNI.new_GroupPendencyItemVec__SWIG_0(), true);
    }

    public GroupPendencyItemVec(long j) {
        this(internalGroupExtJNI.new_GroupPendencyItemVec__SWIG_1(j), true);
    }

    protected GroupPendencyItemVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupPendencyItemVec groupPendencyItemVec) {
        if (groupPendencyItemVec == null) {
            return 0;
        }
        return groupPendencyItemVec.swigCPtr;
    }

    public void add(GroupPendencyItem groupPendencyItem) {
        internalGroupExtJNI.GroupPendencyItemVec_add(this.swigCPtr, this, GroupPendencyItem.getCPtr(groupPendencyItem), groupPendencyItem);
    }

    public long capacity() {
        return internalGroupExtJNI.GroupPendencyItemVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalGroupExtJNI.GroupPendencyItemVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupPendencyItemVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupPendencyItem get(int i) {
        return new GroupPendencyItem(internalGroupExtJNI.GroupPendencyItemVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalGroupExtJNI.GroupPendencyItemVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalGroupExtJNI.GroupPendencyItemVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, GroupPendencyItem groupPendencyItem) {
        internalGroupExtJNI.GroupPendencyItemVec_set(this.swigCPtr, this, i, GroupPendencyItem.getCPtr(groupPendencyItem), groupPendencyItem);
    }

    public long size() {
        return internalGroupExtJNI.GroupPendencyItemVec_size(this.swigCPtr, this);
    }
}
