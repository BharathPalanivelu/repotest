package com.tencent.imcore;

public class ICallbackWithFutureResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithFutureResult() {
        this(internalSnsExtJNI.new_ICallbackWithFutureResult(), true);
        internalSnsExtJNI.ICallbackWithFutureResult_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithFutureResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithFutureResult iCallbackWithFutureResult) {
        if (iCallbackWithFutureResult == null) {
            return 0;
        }
        return iCallbackWithFutureResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_ICallbackWithFutureResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(FriendFutureResult friendFutureResult) {
        if (getClass() == ICallbackWithFutureResult.class) {
            internalSnsExtJNI.ICallbackWithFutureResult_done(this.swigCPtr, this, FriendFutureResult.getCPtr(friendFutureResult), friendFutureResult);
            return;
        }
        internalSnsExtJNI.ICallbackWithFutureResult_doneSwigExplicitICallbackWithFutureResult(this.swigCPtr, this, FriendFutureResult.getCPtr(friendFutureResult), friendFutureResult);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithFutureResult.class) {
            internalSnsExtJNI.ICallbackWithFutureResult_fail(this.swigCPtr, this, i, str);
        } else {
            internalSnsExtJNI.ICallbackWithFutureResult_failSwigExplicitICallbackWithFutureResult(this.swigCPtr, this, i, str);
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
        internalSnsExtJNI.ICallbackWithFutureResult_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalSnsExtJNI.ICallbackWithFutureResult_change_ownership(this, this.swigCPtr, true);
    }
}
