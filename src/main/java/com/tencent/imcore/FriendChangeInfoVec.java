package com.tencent.imcore;

public class FriendChangeInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendChangeInfoVec() {
        this(internalJNI.new_FriendChangeInfoVec__SWIG_0(), true);
    }

    public FriendChangeInfoVec(long j) {
        this(internalJNI.new_FriendChangeInfoVec__SWIG_1(j), true);
    }

    protected FriendChangeInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendChangeInfoVec friendChangeInfoVec) {
        if (friendChangeInfoVec == null) {
            return 0;
        }
        return friendChangeInfoVec.swigCPtr;
    }

    public void add(FriendChangeUserInfo friendChangeUserInfo) {
        internalJNI.FriendChangeInfoVec_add(this.swigCPtr, this, FriendChangeUserInfo.getCPtr(friendChangeUserInfo), friendChangeUserInfo);
    }

    public long capacity() {
        return internalJNI.FriendChangeInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalJNI.FriendChangeInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_FriendChangeInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendChangeUserInfo get(int i) {
        return new FriendChangeUserInfo(internalJNI.FriendChangeInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalJNI.FriendChangeInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalJNI.FriendChangeInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, FriendChangeUserInfo friendChangeUserInfo) {
        internalJNI.FriendChangeInfoVec_set(this.swigCPtr, this, i, FriendChangeUserInfo.getCPtr(friendChangeUserInfo), friendChangeUserInfo);
    }

    public long size() {
        return internalJNI.FriendChangeInfoVec_size(this.swigCPtr, this);
    }
}
