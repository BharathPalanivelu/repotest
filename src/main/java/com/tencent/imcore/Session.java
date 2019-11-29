package com.tencent.imcore;

public class Session {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Session() {
        this(internalJNI.new_Session(), true);
    }

    protected Session(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Session session) {
        if (session == null) {
            return 0;
        }
        return session.swigCPtr;
    }

    public long activeTime() {
        return internalJNI.Session_activeTime(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__shared_ptrT_imcore__SessionNode_t cloneShared() {
        return new SWIGTYPE_p_std__shared_ptrT_imcore__SessionNode_t(internalJNI.Session_cloneShared(this.swigCPtr, this), true);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_Session(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public String iconUrl() {
        return internalJNI.Session_iconUrl(this.swigCPtr, this);
    }

    public String identifier() {
        return internalJNI.Session_identifier(this.swigCPtr, this);
    }

    public boolean isValid() {
        return internalJNI.Session_isValid(this.swigCPtr, this);
    }

    public String name() {
        return internalJNI.Session_name(this.swigCPtr, this);
    }

    public void sendCustomMsg(Msg msg, INotifyCallback iNotifyCallback, long j) {
        internalJNI.Session_sendCustomMsg(this.swigCPtr, this, Msg.getCPtr(msg), msg, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback, j);
    }

    public void sendMsg(Msg msg, INotifyCallback iNotifyCallback) {
        internalJNI.Session_sendMsg(this.swigCPtr, this, Msg.getCPtr(msg), msg, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public String sid() {
        return internalJNI.Session_sid(this.swigCPtr, this);
    }

    public SessionType type() {
        return SessionType.swigToEnum(internalJNI.Session_type(this.swigCPtr, this));
    }
}
