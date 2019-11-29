package com.tencent.imcore;

public class AddFriendReqVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public AddFriendReqVec() {
        this(internalSnsExtJNI.new_AddFriendReqVec__SWIG_0(), true);
    }

    public AddFriendReqVec(long j) {
        this(internalSnsExtJNI.new_AddFriendReqVec__SWIG_1(j), true);
    }

    protected AddFriendReqVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AddFriendReqVec addFriendReqVec) {
        if (addFriendReqVec == null) {
            return 0;
        }
        return addFriendReqVec.swigCPtr;
    }

    public void add(AddFriendReq addFriendReq) {
        internalSnsExtJNI.AddFriendReqVec_add(this.swigCPtr, this, AddFriendReq.getCPtr(addFriendReq), addFriendReq);
    }

    public long capacity() {
        return internalSnsExtJNI.AddFriendReqVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalSnsExtJNI.AddFriendReqVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_AddFriendReqVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public AddFriendReq get(int i) {
        return new AddFriendReq(internalSnsExtJNI.AddFriendReqVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalSnsExtJNI.AddFriendReqVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalSnsExtJNI.AddFriendReqVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, AddFriendReq addFriendReq) {
        internalSnsExtJNI.AddFriendReqVec_set(this.swigCPtr, this, i, AddFriendReq.getCPtr(addFriendReq), addFriendReq);
    }

    public long size() {
        return internalSnsExtJNI.AddFriendReqVec_size(this.swigCPtr, this);
    }
}
