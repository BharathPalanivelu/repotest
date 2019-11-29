package com.tencent.imcore;

public class GroupBaseInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupBaseInfoVec() {
        this(internalGroupExtJNI.new_GroupBaseInfoVec__SWIG_0(), true);
    }

    public GroupBaseInfoVec(long j) {
        this(internalGroupExtJNI.new_GroupBaseInfoVec__SWIG_1(j), true);
    }

    protected GroupBaseInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupBaseInfoVec groupBaseInfoVec) {
        if (groupBaseInfoVec == null) {
            return 0;
        }
        return groupBaseInfoVec.swigCPtr;
    }

    public void add(GroupBaseInfo groupBaseInfo) {
        internalGroupExtJNI.GroupBaseInfoVec_add(this.swigCPtr, this, GroupBaseInfo.getCPtr(groupBaseInfo), groupBaseInfo);
    }

    public long capacity() {
        return internalGroupExtJNI.GroupBaseInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalGroupExtJNI.GroupBaseInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupBaseInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public GroupBaseInfo get(int i) {
        return new GroupBaseInfo(internalGroupExtJNI.GroupBaseInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalGroupExtJNI.GroupBaseInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalGroupExtJNI.GroupBaseInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, GroupBaseInfo groupBaseInfo) {
        internalGroupExtJNI.GroupBaseInfoVec_set(this.swigCPtr, this, i, GroupBaseInfo.getCPtr(groupBaseInfo), groupBaseInfo);
    }

    public long size() {
        return internalGroupExtJNI.GroupBaseInfoVec_size(this.swigCPtr, this);
    }
}
