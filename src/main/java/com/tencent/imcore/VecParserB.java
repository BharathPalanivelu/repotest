package com.tencent.imcore;

public class VecParserB {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected VecParserB(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public VecParserB(BytesVec bytesVec) {
        this(internalJNI.new_VecParserB(BytesVec.getCPtr(bytesVec), bytesVec), true);
    }

    protected static long getCPtr(VecParserB vecParserB) {
        if (vecParserB == null) {
            return 0;
        }
        return vecParserB.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_VecParserB(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public byte[] get(int i) {
        return internalJNI.VecParserB_get(this.swigCPtr, this, i);
    }

    public BytesVec getValues() {
        long VecParserB_values_get = internalJNI.VecParserB_values_get(this.swigCPtr, this);
        if (VecParserB_values_get == 0) {
            return null;
        }
        return new BytesVec(VecParserB_values_get, false);
    }

    public void setValues(BytesVec bytesVec) {
        internalJNI.VecParserB_values_set(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec);
    }
}
