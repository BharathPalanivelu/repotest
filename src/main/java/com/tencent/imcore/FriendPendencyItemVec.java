package com.tencent.imcore;

public class FriendPendencyItemVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendPendencyItemVec() {
        this(internalSnsExtJNI.new_FriendPendencyItemVec__SWIG_0(), true);
    }

    public FriendPendencyItemVec(long j) {
        this(internalSnsExtJNI.new_FriendPendencyItemVec__SWIG_1(j), true);
    }

    protected FriendPendencyItemVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendPendencyItemVec friendPendencyItemVec) {
        if (friendPendencyItemVec == null) {
            return 0;
        }
        return friendPendencyItemVec.swigCPtr;
    }

    public void add(FriendPendencyItem friendPendencyItem) {
        internalSnsExtJNI.FriendPendencyItemVec_add(this.swigCPtr, this, FriendPendencyItem.getCPtr(friendPendencyItem), friendPendencyItem);
    }

    public long capacity() {
        return internalSnsExtJNI.FriendPendencyItemVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalSnsExtJNI.FriendPendencyItemVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendPendencyItemVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendPendencyItem get(int i) {
        return new FriendPendencyItem(internalSnsExtJNI.FriendPendencyItemVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalSnsExtJNI.FriendPendencyItemVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalSnsExtJNI.FriendPendencyItemVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, FriendPendencyItem friendPendencyItem) {
        internalSnsExtJNI.FriendPendencyItemVec_set(this.swigCPtr, this, i, FriendPendencyItem.getCPtr(friendPendencyItem), friendPendencyItem);
    }

    public long size() {
        return internalSnsExtJNI.FriendPendencyItemVec_size(this.swigCPtr, this);
    }
}
