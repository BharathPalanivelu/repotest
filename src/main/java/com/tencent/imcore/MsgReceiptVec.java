package com.tencent.imcore;

public class MsgReceiptVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MsgReceiptVec() {
        this(internalJNI.new_MsgReceiptVec__SWIG_0(), true);
    }

    public MsgReceiptVec(long j) {
        this(internalJNI.new_MsgReceiptVec__SWIG_1(j), true);
    }

    protected MsgReceiptVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MsgReceiptVec msgReceiptVec) {
        if (msgReceiptVec == null) {
            return 0;
        }
        return msgReceiptVec.swigCPtr;
    }

    public void add(MsgReceipt msgReceipt) {
        internalJNI.MsgReceiptVec_add(this.swigCPtr, this, MsgReceipt.getCPtr(msgReceipt), msgReceipt);
    }

    public long capacity() {
        return internalJNI.MsgReceiptVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalJNI.MsgReceiptVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MsgReceiptVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public MsgReceipt get(int i) {
        return new MsgReceipt(internalJNI.MsgReceiptVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalJNI.MsgReceiptVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalJNI.MsgReceiptVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, MsgReceipt msgReceipt) {
        internalJNI.MsgReceiptVec_set(this.swigCPtr, this, i, MsgReceipt.getCPtr(msgReceipt), msgReceipt);
    }

    public long size() {
        return internalJNI.MsgReceiptVec_size(this.swigCPtr, this);
    }
}
