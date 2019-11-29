package com.tencent.imcore;

public class Draft {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Draft() {
        this(internalMsgExtJNI.new_Draft(), true);
    }

    protected Draft(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Draft draft) {
        if (draft == null) {
            return 0;
        }
        return draft.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_Draft(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public ElemVec getElems() {
        long Draft_elems_get = internalMsgExtJNI.Draft_elems_get(this.swigCPtr, this);
        if (Draft_elems_get == 0) {
            return null;
        }
        return new ElemVec(Draft_elems_get, false);
    }

    public long getUint64_edit_time() {
        return internalMsgExtJNI.Draft_uint64_edit_time_get(this.swigCPtr, this);
    }

    public byte[] getUser_define() {
        return internalMsgExtJNI.Draft_user_define_get(this.swigCPtr, this);
    }

    public void setElems(ElemVec elemVec) {
        internalMsgExtJNI.Draft_elems_set(this.swigCPtr, this, ElemVec.getCPtr(elemVec), elemVec);
    }

    public void setUint64_edit_time(long j) {
        internalMsgExtJNI.Draft_uint64_edit_time_set(this.swigCPtr, this, j);
    }

    public void setUser_define(byte[] bArr) {
        internalMsgExtJNI.Draft_user_define_set(this.swigCPtr, this, bArr);
    }
}
