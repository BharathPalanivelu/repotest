package com.tencent.imcore;

public class INotifyCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public INotifyCallback() {
        this(internalJNI.new_INotifyCallback(), true);
        internalJNI.INotifyCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected INotifyCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(INotifyCallback iNotifyCallback) {
        if (iNotifyCallback == null) {
            return 0;
        }
        return iNotifyCallback.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_INotifyCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done() {
        if (getClass() == INotifyCallback.class) {
            internalJNI.INotifyCallback_done(this.swigCPtr, this);
        } else {
            internalJNI.INotifyCallback_doneSwigExplicitINotifyCallback(this.swigCPtr, this);
        }
    }

    public void fail(int i, String str) {
        if (getClass() == INotifyCallback.class) {
            internalJNI.INotifyCallback_fail(this.swigCPtr, this, i, str);
        } else {
            internalJNI.INotifyCallback_failSwigExplicitINotifyCallback(this.swigCPtr, this, i, str);
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
        internalJNI.INotifyCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalJNI.INotifyCallback_change_ownership(this, this.swigCPtr, true);
    }
}
