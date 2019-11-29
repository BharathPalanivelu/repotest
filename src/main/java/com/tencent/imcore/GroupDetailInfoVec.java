package com.tencent.imcore;

public class GroupDetailInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupDetailInfoVec() {
        this(internalGroupExtJNI.new_GroupDetailInfoVec__SWIG_0(), true);
    }

    public GroupDetailInfoVec(long j) {
        this(internalGroupExtJNI.new_GroupDetailInfoVec__SWIG_1(j), true);
    }

    protected GroupDetailInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupDetailInfoVec groupDetailInfoVec) {
        if (groupDetailInfoVec == null) {
            return 0;
        }
        return groupDetailInfoVec.swigCPtr;
    }

    public void add(GroupDetailInfo groupDetailInfo) {
        internalGroupExtJNI.GroupDetailInfoVec_add(this.swigCPtr, this, GroupDetailInfo.getCPtr(groupDetailInfo), groupDetailInfo);
    }

    public long capacity() {
        return internalGroupExtJNI.GroupDetailInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalGroupExtJNI.GroupDetailInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupDetailInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupDetailInfo get(int i) {
        return new GroupDetailInfo(internalGroupExtJNI.GroupDetailInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalGroupExtJNI.GroupDetailInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalGroupExtJNI.GroupDetailInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, GroupDetailInfo groupDetailInfo) {
        internalGroupExtJNI.GroupDetailInfoVec_set(this.swigCPtr, this, i, GroupDetailInfo.getCPtr(groupDetailInfo), groupDetailInfo);
    }

    public long size() {
        return internalGroupExtJNI.GroupDetailInfoVec_size(this.swigCPtr, this);
    }
}
