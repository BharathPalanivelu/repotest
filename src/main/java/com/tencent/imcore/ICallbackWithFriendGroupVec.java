package com.tencent.imcore;

public class ICallbackWithFriendGroupVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithFriendGroupVec() {
        this(internalSnsExtJNI.new_ICallbackWithFriendGroupVec(), true);
        internalSnsExtJNI.ICallbackWithFriendGroupVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithFriendGroupVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec) {
        if (iCallbackWithFriendGroupVec == null) {
            return 0;
        }
        return iCallbackWithFriendGroupVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_ICallbackWithFriendGroupVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(FriendGroupVec friendGroupVec) {
        if (getClass() == ICallbackWithFriendGroupVec.class) {
            internalSnsExtJNI.ICallbackWithFriendGroupVec_done(this.swigCPtr, this, FriendGroupVec.getCPtr(friendGroupVec), friendGroupVec);
            return;
        }
        internalSnsExtJNI.ICallbackWithFriendGroupVec_doneSwigExplicitICallbackWithFriendGroupVec(this.swigCPtr, this, FriendGroupVec.getCPtr(friendGroupVec), friendGroupVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithFriendGroupVec.class) {
            internalSnsExtJNI.ICallbackWithFriendGroupVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalSnsExtJNI.ICallbackWithFriendGroupVec_failSwigExplicitICallbackWithFriendGroupVec(this.swigCPtr, this, i, str);
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
        internalSnsExtJNI.ICallbackWithFriendGroupVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalSnsExtJNI.ICallbackWithFriendGroupVec_change_ownership(this, this.swigCPtr, true);
    }
}
