package com.tencent.imcore;

public class FriendGroupVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendGroupVec() {
        this(internalSnsExtJNI.new_FriendGroupVec__SWIG_0(), true);
    }

    public FriendGroupVec(long j) {
        this(internalSnsExtJNI.new_FriendGroupVec__SWIG_1(j), true);
    }

    protected FriendGroupVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendGroupVec friendGroupVec) {
        if (friendGroupVec == null) {
            return 0;
        }
        return friendGroupVec.swigCPtr;
    }

    public void add(FriendGroup friendGroup) {
        internalSnsExtJNI.FriendGroupVec_add(this.swigCPtr, this, FriendGroup.getCPtr(friendGroup), friendGroup);
    }

    public long capacity() {
        return internalSnsExtJNI.FriendGroupVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalSnsExtJNI.FriendGroupVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendGroupVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendGroup get(int i) {
        return new FriendGroup(internalSnsExtJNI.FriendGroupVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalSnsExtJNI.FriendGroupVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalSnsExtJNI.FriendGroupVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, FriendGroup friendGroup) {
        internalSnsExtJNI.FriendGroupVec_set(this.swigCPtr, this, i, FriendGroup.getCPtr(friendGroup), friendGroup);
    }

    public long size() {
        return internalSnsExtJNI.FriendGroupVec_size(this.swigCPtr, this);
    }
}
