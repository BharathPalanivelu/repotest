package com.tencent.imcore;

public class MessageLocator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MessageLocator() {
        this(internalJNI.new_MessageLocator(), true);
    }

    protected MessageLocator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MessageLocator messageLocator) {
        if (messageLocator == null) {
            return 0;
        }
        return messageLocator.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MessageLocator(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public boolean getIsRevokedMsg() {
        return internalJNI.MessageLocator_isRevokedMsg_get(this.swigCPtr, this);
    }

    public boolean getIs_self() {
        return internalJNI.MessageLocator_is_self_get(this.swigCPtr, this);
    }

    public long getRand() {
        return internalJNI.MessageLocator_rand_get(this.swigCPtr, this);
    }

    public long getSeq() {
        return internalJNI.MessageLocator_seq_get(this.swigCPtr, this);
    }

    public byte[] getSid() {
        return internalJNI.MessageLocator_sid_get(this.swigCPtr, this);
    }

    public long getTime() {
        return internalJNI.MessageLocator_time_get(this.swigCPtr, this);
    }

    public SessionType getType() {
        return SessionType.swigToEnum(internalJNI.MessageLocator_type_get(this.swigCPtr, this));
    }

    public void setIsRevokedMsg(boolean z) {
        internalJNI.MessageLocator_isRevokedMsg_set(this.swigCPtr, this, z);
    }

    public void setIs_self(boolean z) {
        internalJNI.MessageLocator_is_self_set(this.swigCPtr, this, z);
    }

    public void setRand(long j) {
        internalJNI.MessageLocator_rand_set(this.swigCPtr, this, j);
    }

    public void setSeq(long j) {
        internalJNI.MessageLocator_seq_set(this.swigCPtr, this, j);
    }

    public void setSid(byte[] bArr) {
        internalJNI.MessageLocator_sid_set(this.swigCPtr, this, bArr);
    }

    public void setTime(long j) {
        internalJNI.MessageLocator_time_set(this.swigCPtr, this, j);
    }

    public void setType(SessionType sessionType) {
        internalJNI.MessageLocator_type_set(this.swigCPtr, this, sessionType.swigValue());
    }
}
