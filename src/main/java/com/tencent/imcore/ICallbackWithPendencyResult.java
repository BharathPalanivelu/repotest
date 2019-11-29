package com.tencent.imcore;

public class ICallbackWithPendencyResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithPendencyResult() {
        this(internalSnsExtJNI.new_ICallbackWithPendencyResult(), true);
        internalSnsExtJNI.ICallbackWithPendencyResult_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithPendencyResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithPendencyResult iCallbackWithPendencyResult) {
        if (iCallbackWithPendencyResult == null) {
            return 0;
        }
        return iCallbackWithPendencyResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_ICallbackWithPendencyResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(FriendPendencyResult friendPendencyResult) {
        if (getClass() == ICallbackWithPendencyResult.class) {
            internalSnsExtJNI.ICallbackWithPendencyResult_done(this.swigCPtr, this, FriendPendencyResult.getCPtr(friendPendencyResult), friendPendencyResult);
            return;
        }
        internalSnsExtJNI.ICallbackWithPendencyResult_doneSwigExplicitICallbackWithPendencyResult(this.swigCPtr, this, FriendPendencyResult.getCPtr(friendPendencyResult), friendPendencyResult);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithPendencyResult.class) {
            internalSnsExtJNI.ICallbackWithPendencyResult_fail(this.swigCPtr, this, i, str);
        } else {
            internalSnsExtJNI.ICallbackWithPendencyResult_failSwigExplicitICallbackWithPendencyResult(this.swigCPtr, this, i, str);
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
        internalSnsExtJNI.ICallbackWithPendencyResult_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalSnsExtJNI.ICallbackWithPendencyResult_change_ownership(this, this.swigCPtr, true);
    }
}
