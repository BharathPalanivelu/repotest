package com.tencent.imcore;

public class SessionUUID {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SessionUUID() {
        this(internalJNI.new_SessionUUID(), true);
    }

    protected SessionUUID(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SessionUUID sessionUUID) {
        if (sessionUUID == null) {
            return 0;
        }
        return sessionUUID.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_SessionUUID(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public String getSid() {
        return internalJNI.SessionUUID_sid_get(this.swigCPtr, this);
    }

    public SessionType getType() {
        return SessionType.swigToEnum(internalJNI.SessionUUID_type_get(this.swigCPtr, this));
    }

    public void setSid(String str) {
        internalJNI.SessionUUID_sid_set(this.swigCPtr, this, str);
    }

    public void setType(SessionType sessionType) {
        internalJNI.SessionUUID_type_set(this.swigCPtr, this, sessionType.swigValue());
    }
}
