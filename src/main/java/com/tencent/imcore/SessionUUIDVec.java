package com.tencent.imcore;

public class SessionUUIDVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SessionUUIDVec() {
        this(internalJNI.new_SessionUUIDVec__SWIG_0(), true);
    }

    public SessionUUIDVec(long j) {
        this(internalJNI.new_SessionUUIDVec__SWIG_1(j), true);
    }

    protected SessionUUIDVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SessionUUIDVec sessionUUIDVec) {
        if (sessionUUIDVec == null) {
            return 0;
        }
        return sessionUUIDVec.swigCPtr;
    }

    public void add(SessionUUID sessionUUID) {
        internalJNI.SessionUUIDVec_add(this.swigCPtr, this, SessionUUID.getCPtr(sessionUUID), sessionUUID);
    }

    public long capacity() {
        return internalJNI.SessionUUIDVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalJNI.SessionUUIDVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_SessionUUIDVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SessionUUID get(int i) {
        return new SessionUUID(internalJNI.SessionUUIDVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalJNI.SessionUUIDVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalJNI.SessionUUIDVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, SessionUUID sessionUUID) {
        internalJNI.SessionUUIDVec_set(this.swigCPtr, this, i, SessionUUID.getCPtr(sessionUUID), sessionUUID);
    }

    public long size() {
        return internalJNI.SessionUUIDVec_size(this.swigCPtr, this);
    }
}
