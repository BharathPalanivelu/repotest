package com.tencent.imcore;

public class ICallbackWithStrVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithStrVec() {
        this(internalJNI.new_ICallbackWithStrVec(), true);
        internalJNI.ICallbackWithStrVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithStrVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithStrVec iCallbackWithStrVec) {
        if (iCallbackWithStrVec == null) {
            return 0;
        }
        return iCallbackWithStrVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_ICallbackWithStrVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(StrVec strVec) {
        if (getClass() == ICallbackWithStrVec.class) {
            internalJNI.ICallbackWithStrVec_done(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
            return;
        }
        internalJNI.ICallbackWithStrVec_doneSwigExplicitICallbackWithStrVec(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithStrVec.class) {
            internalJNI.ICallbackWithStrVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalJNI.ICallbackWithStrVec_failSwigExplicitICallbackWithStrVec(this.swigCPtr, this, i, str);
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
        internalJNI.ICallbackWithStrVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalJNI.ICallbackWithStrVec_change_ownership(this, this.swigCPtr, true);
    }
}
