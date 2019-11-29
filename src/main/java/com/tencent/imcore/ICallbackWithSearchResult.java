package com.tencent.imcore;

public class ICallbackWithSearchResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithSearchResult() {
        this(internalSnsExtJNI.new_ICallbackWithSearchResult(), true);
        internalSnsExtJNI.ICallbackWithSearchResult_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithSearchResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithSearchResult iCallbackWithSearchResult) {
        if (iCallbackWithSearchResult == null) {
            return 0;
        }
        return iCallbackWithSearchResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_ICallbackWithSearchResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(SearchUserResult searchUserResult) {
        if (getClass() == ICallbackWithSearchResult.class) {
            internalSnsExtJNI.ICallbackWithSearchResult_done(this.swigCPtr, this, SearchUserResult.getCPtr(searchUserResult), searchUserResult);
            return;
        }
        internalSnsExtJNI.ICallbackWithSearchResult_doneSwigExplicitICallbackWithSearchResult(this.swigCPtr, this, SearchUserResult.getCPtr(searchUserResult), searchUserResult);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithSearchResult.class) {
            internalSnsExtJNI.ICallbackWithSearchResult_fail(this.swigCPtr, this, i, str);
        } else {
            internalSnsExtJNI.ICallbackWithSearchResult_failSwigExplicitICallbackWithSearchResult(this.swigCPtr, this, i, str);
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
        internalSnsExtJNI.ICallbackWithSearchResult_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalSnsExtJNI.ICallbackWithSearchResult_change_ownership(this, this.swigCPtr, true);
    }
}
