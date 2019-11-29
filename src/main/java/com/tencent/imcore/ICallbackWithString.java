package com.tencent.imcore;

public class ICallbackWithString {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithString() {
        this(internalJNI.new_ICallbackWithString(), true);
        internalJNI.ICallbackWithString_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithString(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithString iCallbackWithString) {
        if (iCallbackWithString == null) {
            return 0;
        }
        return iCallbackWithString.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_ICallbackWithString(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(String str) {
        if (getClass() == ICallbackWithString.class) {
            internalJNI.ICallbackWithString_done(this.swigCPtr, this, str);
        } else {
            internalJNI.ICallbackWithString_doneSwigExplicitICallbackWithString(this.swigCPtr, this, str);
        }
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithString.class) {
            internalJNI.ICallbackWithString_fail(this.swigCPtr, this, i, str);
        } else {
            internalJNI.ICallbackWithString_failSwigExplicitICallbackWithString(this.swigCPtr, this, i, str);
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
        internalJNI.ICallbackWithString_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalJNI.ICallbackWithString_change_ownership(this, this.swigCPtr, true);
    }
}
