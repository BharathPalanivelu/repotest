package com.tencent.imcore;

public class CompatUint64 {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CompatUint64() {
        this(internalJNI.new_CompatUint64(), true);
    }

    protected CompatUint64(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CompatUint64 compatUint64) {
        if (compatUint64 == null) {
            return 0;
        }
        return compatUint64.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_CompatUint64(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getValue() {
        return internalJNI.CompatUint64_value_get(this.swigCPtr, this);
    }

    public void setValue(long j) {
        internalJNI.CompatUint64_value_set(this.swigCPtr, this, j);
    }
}
