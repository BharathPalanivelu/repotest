package com.tencent.imcore;

public class ICallbackWithProfileVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithProfileVec() {
        this(internalJNI.new_ICallbackWithProfileVec(), true);
        internalJNI.ICallbackWithProfileVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithProfileVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithProfileVec iCallbackWithProfileVec) {
        if (iCallbackWithProfileVec == null) {
            return 0;
        }
        return iCallbackWithProfileVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_ICallbackWithProfileVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(FriendProfileVec friendProfileVec) {
        if (getClass() == ICallbackWithProfileVec.class) {
            internalJNI.ICallbackWithProfileVec_done(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
            return;
        }
        internalJNI.ICallbackWithProfileVec_doneSwigExplicitICallbackWithProfileVec(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithProfileVec.class) {
            internalJNI.ICallbackWithProfileVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalJNI.ICallbackWithProfileVec_failSwigExplicitICallbackWithProfileVec(this.swigCPtr, this, i, str);
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
        internalJNI.ICallbackWithProfileVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalJNI.ICallbackWithProfileVec_change_ownership(this, this.swigCPtr, true);
    }
}
