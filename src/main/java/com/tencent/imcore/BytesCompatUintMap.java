package com.tencent.imcore;

public class BytesCompatUintMap {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public BytesCompatUintMap() {
        this(internalJNI.new_BytesCompatUintMap__SWIG_0(), true);
    }

    protected BytesCompatUintMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public BytesCompatUintMap(BytesCompatUintMap bytesCompatUintMap) {
        this(internalJNI.new_BytesCompatUintMap__SWIG_1(getCPtr(bytesCompatUintMap), bytesCompatUintMap), true);
    }

    protected static long getCPtr(BytesCompatUintMap bytesCompatUintMap) {
        if (bytesCompatUintMap == null) {
            return 0;
        }
        return bytesCompatUintMap.swigCPtr;
    }

    public void clear() {
        internalJNI.BytesCompatUintMap_clear(this.swigCPtr, this);
    }

    public void del(byte[] bArr) {
        internalJNI.BytesCompatUintMap_del(this.swigCPtr, this, bArr);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_BytesCompatUintMap(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public boolean empty() {
        return internalJNI.BytesCompatUintMap_empty(this.swigCPtr, this);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public CompatUint64 get(byte[] bArr) {
        return new CompatUint64(internalJNI.BytesCompatUintMap_get(this.swigCPtr, this, bArr), false);
    }

    public boolean hasKey(byte[] bArr) {
        return internalJNI.BytesCompatUintMap_hasKey(this.swigCPtr, this, bArr);
    }

    public void set(byte[] bArr, CompatUint64 compatUint64) {
        internalJNI.BytesCompatUintMap_set(this.swigCPtr, this, bArr, CompatUint64.getCPtr(compatUint64), compatUint64);
    }

    public long size() {
        return internalJNI.BytesCompatUintMap_size(this.swigCPtr, this);
    }
}
