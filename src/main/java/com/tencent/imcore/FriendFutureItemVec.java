package com.tencent.imcore;

public class FriendFutureItemVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendFutureItemVec() {
        this(internalSnsExtJNI.new_FriendFutureItemVec__SWIG_0(), true);
    }

    public FriendFutureItemVec(long j) {
        this(internalSnsExtJNI.new_FriendFutureItemVec__SWIG_1(j), true);
    }

    protected FriendFutureItemVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendFutureItemVec friendFutureItemVec) {
        if (friendFutureItemVec == null) {
            return 0;
        }
        return friendFutureItemVec.swigCPtr;
    }

    public void add(FriendFutureItem friendFutureItem) {
        internalSnsExtJNI.FriendFutureItemVec_add(this.swigCPtr, this, FriendFutureItem.getCPtr(friendFutureItem), friendFutureItem);
    }

    public long capacity() {
        return internalSnsExtJNI.FriendFutureItemVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalSnsExtJNI.FriendFutureItemVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendFutureItemVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendFutureItem get(int i) {
        return new FriendFutureItem(internalSnsExtJNI.FriendFutureItemVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalSnsExtJNI.FriendFutureItemVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalSnsExtJNI.FriendFutureItemVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, FriendFutureItem friendFutureItem) {
        internalSnsExtJNI.FriendFutureItemVec_set(this.swigCPtr, this, i, FriendFutureItem.getCPtr(friendFutureItem), friendFutureItem);
    }

    public long size() {
        return internalSnsExtJNI.FriendFutureItemVec_size(this.swigCPtr, this);
    }
}
