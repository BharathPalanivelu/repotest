package com.tencent.imcore;

public class ICallbackWithMsgVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithMsgVec() {
        this(internalMsgExtJNI.new_ICallbackWithMsgVec(), true);
        internalMsgExtJNI.ICallbackWithMsgVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithMsgVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithMsgVec iCallbackWithMsgVec) {
        if (iCallbackWithMsgVec == null) {
            return 0;
        }
        return iCallbackWithMsgVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_ICallbackWithMsgVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(MsgVec msgVec) {
        if (getClass() == ICallbackWithMsgVec.class) {
            internalMsgExtJNI.ICallbackWithMsgVec_done(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
            return;
        }
        internalMsgExtJNI.ICallbackWithMsgVec_doneSwigExplicitICallbackWithMsgVec(this.swigCPtr, this, MsgVec.getCPtr(msgVec), msgVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithMsgVec.class) {
            internalMsgExtJNI.ICallbackWithMsgVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalMsgExtJNI.ICallbackWithMsgVec_failSwigExplicitICallbackWithMsgVec(this.swigCPtr, this, i, str);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        internalMsgExtJNI.ICallbackWithMsgVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalMsgExtJNI.ICallbackWithMsgVec_change_ownership(this, this.swigCPtr, true);
    }
}
