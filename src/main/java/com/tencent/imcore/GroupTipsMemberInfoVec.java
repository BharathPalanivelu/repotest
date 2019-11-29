package com.tencent.imcore;

public class GroupTipsMemberInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupTipsMemberInfoVec() {
        this(internalJNI.new_GroupTipsMemberInfoVec__SWIG_0(), true);
    }

    public GroupTipsMemberInfoVec(long j) {
        this(internalJNI.new_GroupTipsMemberInfoVec__SWIG_1(j), true);
    }

    protected GroupTipsMemberInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupTipsMemberInfoVec groupTipsMemberInfoVec) {
        if (groupTipsMemberInfoVec == null) {
            return 0;
        }
        return groupTipsMemberInfoVec.swigCPtr;
    }

    public void add(GroupTipsMemberInfo groupTipsMemberInfo) {
        internalJNI.GroupTipsMemberInfoVec_add(this.swigCPtr, this, GroupTipsMemberInfo.getCPtr(groupTipsMemberInfo), groupTipsMemberInfo);
    }

    public long capacity() {
        return internalJNI.GroupTipsMemberInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalJNI.GroupTipsMemberInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupTipsMemberInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupTipsMemberInfo get(int i) {
        return new GroupTipsMemberInfo(internalJNI.GroupTipsMemberInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalJNI.GroupTipsMemberInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalJNI.GroupTipsMemberInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, GroupTipsMemberInfo groupTipsMemberInfo) {
        internalJNI.GroupTipsMemberInfoVec_set(this.swigCPtr, this, i, GroupTipsMemberInfo.getCPtr(groupTipsMemberInfo), groupTipsMemberInfo);
    }

    public long size() {
        return internalJNI.GroupTipsMemberInfoVec_size(this.swigCPtr, this);
    }
}
