package com.tencent.imcore;

public class GroupTipsElem_GroupInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupTipsElem_GroupInfoVec() {
        this(internalJNI.new_GroupTipsElem_GroupInfoVec__SWIG_0(), true);
    }

    public GroupTipsElem_GroupInfoVec(long j) {
        this(internalJNI.new_GroupTipsElem_GroupInfoVec__SWIG_1(j), true);
    }

    protected GroupTipsElem_GroupInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec) {
        if (groupTipsElem_GroupInfoVec == null) {
            return 0;
        }
        return groupTipsElem_GroupInfoVec.swigCPtr;
    }

    public void add(GroupTipsElem_GroupInfo groupTipsElem_GroupInfo) {
        internalJNI.GroupTipsElem_GroupInfoVec_add(this.swigCPtr, this, GroupTipsElem_GroupInfo.getCPtr(groupTipsElem_GroupInfo), groupTipsElem_GroupInfo);
    }

    public long capacity() {
        return internalJNI.GroupTipsElem_GroupInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalJNI.GroupTipsElem_GroupInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupTipsElem_GroupInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupTipsElem_GroupInfo get(int i) {
        return new GroupTipsElem_GroupInfo(internalJNI.GroupTipsElem_GroupInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalJNI.GroupTipsElem_GroupInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalJNI.GroupTipsElem_GroupInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo) {
        internalJNI.GroupTipsElem_GroupInfoVec_set(this.swigCPtr, this, i, GroupTipsElem_GroupInfo.getCPtr(groupTipsElem_GroupInfo), groupTipsElem_GroupInfo);
    }

    public long size() {
        return internalJNI.GroupTipsElem_GroupInfoVec_size(this.swigCPtr, this);
    }
}
