package com.tencent.imcore;

public class BytesVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public BytesVec() {
        this(internalJNI.new_BytesVec__SWIG_0(), true);
    }

    public BytesVec(long j) {
        this(internalJNI.new_BytesVec__SWIG_1(j), true);
    }

    protected BytesVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BytesVec bytesVec) {
        if (bytesVec == null) {
            return 0;
        }
        return bytesVec.swigCPtr;
    }

    public void add(byte[] bArr) {
        internalJNI.BytesVec_add(this.swigCPtr, this, bArr);
    }

    public long capacity() {
        return internalJNI.BytesVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalJNI.BytesVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_BytesVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public byte[] get(int i) {
        return internalJNI.BytesVec_get(this.swigCPtr, this, i);
    }

    public boolean isEmpty() {
        return internalJNI.BytesVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalJNI.BytesVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, byte[] bArr) {
        internalJNI.BytesVec_set(this.swigCPtr, this, i, bArr);
    }

    public long size() {
        return internalJNI.BytesVec_size(this.swigCPtr, this);
    }
}
