package com.tencent.imcore;

public class MsgReceipt {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MsgReceipt() {
        this(internalJNI.new_MsgReceipt(), true);
    }

    protected MsgReceipt(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MsgReceipt msgReceipt) {
        if (msgReceipt == null) {
            return 0;
        }
        return msgReceipt.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MsgReceipt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SessionUUID getSess() {
        long MsgReceipt_sess_get = internalJNI.MsgReceipt_sess_get(this.swigCPtr, this);
        if (MsgReceipt_sess_get == 0) {
            return null;
        }
        return new SessionUUID(MsgReceipt_sess_get, false);
    }

    public long getTimestamp() {
        return internalJNI.MsgReceipt_timestamp_get(this.swigCPtr, this);
    }

    public void setSess(SessionUUID sessionUUID) {
        internalJNI.MsgReceipt_sess_set(this.swigCPtr, this, SessionUUID.getCPtr(sessionUUID), sessionUUID);
    }

    public void setTimestamp(long j) {
        internalJNI.MsgReceipt_timestamp_set(this.swigCPtr, this, j);
    }
}
