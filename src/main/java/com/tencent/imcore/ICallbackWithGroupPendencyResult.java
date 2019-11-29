package com.tencent.imcore;

public class ICallbackWithGroupPendencyResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithGroupPendencyResult() {
        this(internalGroupExtJNI.new_ICallbackWithGroupPendencyResult(), true);
        internalGroupExtJNI.ICallbackWithGroupPendencyResult_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithGroupPendencyResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult) {
        if (iCallbackWithGroupPendencyResult == null) {
            return 0;
        }
        return iCallbackWithGroupPendencyResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithGroupPendencyResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(GroupPendencyResult groupPendencyResult) {
        if (getClass() == ICallbackWithGroupPendencyResult.class) {
            internalGroupExtJNI.ICallbackWithGroupPendencyResult_done(this.swigCPtr, this, GroupPendencyResult.getCPtr(groupPendencyResult), groupPendencyResult);
            return;
        }
        internalGroupExtJNI.ICallbackWithGroupPendencyResult_doneSwigExplicitICallbackWithGroupPendencyResult(this.swigCPtr, this, GroupPendencyResult.getCPtr(groupPendencyResult), groupPendencyResult);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithGroupPendencyResult.class) {
            internalGroupExtJNI.ICallbackWithGroupPendencyResult_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithGroupPendencyResult_failSwigExplicitICallbackWithGroupPendencyResult(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithGroupPendencyResult_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithGroupPendencyResult_change_ownership(this, this.swigCPtr, true);
    }
}
