package com.tencent.imcore;

public class GroupCacheInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupCacheInfoVec() {
        this(internalGroupExtJNI.new_GroupCacheInfoVec__SWIG_0(), true);
    }

    public GroupCacheInfoVec(long j) {
        this(internalGroupExtJNI.new_GroupCacheInfoVec__SWIG_1(j), true);
    }

    protected GroupCacheInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupCacheInfoVec groupCacheInfoVec) {
        if (groupCacheInfoVec == null) {
            return 0;
        }
        return groupCacheInfoVec.swigCPtr;
    }

    public void add(GroupCacheInfo groupCacheInfo) {
        internalGroupExtJNI.GroupCacheInfoVec_add(this.swigCPtr, this, GroupCacheInfo.getCPtr(groupCacheInfo), groupCacheInfo);
    }

    public long capacity() {
        return internalGroupExtJNI.GroupCacheInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalGroupExtJNI.GroupCacheInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupCacheInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupCacheInfo get(int i) {
        return new GroupCacheInfo(internalGroupExtJNI.GroupCacheInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalGroupExtJNI.GroupCacheInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalGroupExtJNI.GroupCacheInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, GroupCacheInfo groupCacheInfo) {
        internalGroupExtJNI.GroupCacheInfoVec_set(this.swigCPtr, this, i, GroupCacheInfo.getCPtr(groupCacheInfo), groupCacheInfo);
    }

    public long size() {
        return internalGroupExtJNI.GroupCacheInfoVec_size(this.swigCPtr, this);
    }
}
