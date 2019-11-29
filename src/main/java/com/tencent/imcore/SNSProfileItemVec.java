package com.tencent.imcore;

public class SNSProfileItemVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SNSProfileItemVec() {
        this(internalSnsExtJNI.new_SNSProfileItemVec__SWIG_0(), true);
    }

    public SNSProfileItemVec(long j) {
        this(internalSnsExtJNI.new_SNSProfileItemVec__SWIG_1(j), true);
    }

    protected SNSProfileItemVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SNSProfileItemVec sNSProfileItemVec) {
        if (sNSProfileItemVec == null) {
            return 0;
        }
        return sNSProfileItemVec.swigCPtr;
    }

    public void add(SNSProfileItem sNSProfileItem) {
        internalSnsExtJNI.SNSProfileItemVec_add(this.swigCPtr, this, SNSProfileItem.getCPtr(sNSProfileItem), sNSProfileItem);
    }

    public long capacity() {
        return internalSnsExtJNI.SNSProfileItemVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalSnsExtJNI.SNSProfileItemVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_SNSProfileItemVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SNSProfileItem get(int i) {
        return new SNSProfileItem(internalSnsExtJNI.SNSProfileItemVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalSnsExtJNI.SNSProfileItemVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalSnsExtJNI.SNSProfileItemVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, SNSProfileItem sNSProfileItem) {
        internalSnsExtJNI.SNSProfileItemVec_set(this.swigCPtr, this, i, SNSProfileItem.getCPtr(sNSProfileItem), sNSProfileItem);
    }

    public long size() {
        return internalSnsExtJNI.SNSProfileItemVec_size(this.swigCPtr, this);
    }
}
