package com.tencent.imcore;

import com.tencent.imcore.IBatchOprCallback;

public class ErrInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ErrInfoVec() {
        this(internalMsgExtJNI.new_ErrInfoVec__SWIG_0(), true);
    }

    public ErrInfoVec(long j) {
        this(internalMsgExtJNI.new_ErrInfoVec__SWIG_1(j), true);
    }

    protected ErrInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ErrInfoVec errInfoVec) {
        if (errInfoVec == null) {
            return 0;
        }
        return errInfoVec.swigCPtr;
    }

    public void add(IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo) {
        internalMsgExtJNI.ErrInfoVec_add(this.swigCPtr, this, IBatchOprCallback.BatchOprDetailInfo.ErrInfo.getCPtr(errInfo), errInfo);
    }

    public long capacity() {
        return internalMsgExtJNI.ErrInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalMsgExtJNI.ErrInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_ErrInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public IBatchOprCallback.BatchOprDetailInfo.ErrInfo get(int i) {
        return new IBatchOprCallback.BatchOprDetailInfo.ErrInfo(internalMsgExtJNI.ErrInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalMsgExtJNI.ErrInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalMsgExtJNI.ErrInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo) {
        internalMsgExtJNI.ErrInfoVec_set(this.swigCPtr, this, i, IBatchOprCallback.BatchOprDetailInfo.ErrInfo.getCPtr(errInfo), errInfo);
    }

    public long size() {
        return internalMsgExtJNI.ErrInfoVec_size(this.swigCPtr, this);
    }
}
