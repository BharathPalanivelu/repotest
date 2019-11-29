package com.tencent.imcore;

public class ICallbackWithNumberGroupsDetail {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithNumberGroupsDetail() {
        this(internalGroupExtJNI.new_ICallbackWithNumberGroupsDetail(), true);
        internalGroupExtJNI.ICallbackWithNumberGroupsDetail_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithNumberGroupsDetail(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail) {
        if (iCallbackWithNumberGroupsDetail == null) {
            return 0;
        }
        return iCallbackWithNumberGroupsDetail.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithNumberGroupsDetail(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(NumberGroupsDetail numberGroupsDetail) {
        if (getClass() == ICallbackWithNumberGroupsDetail.class) {
            internalGroupExtJNI.ICallbackWithNumberGroupsDetail_done(this.swigCPtr, this, NumberGroupsDetail.getCPtr(numberGroupsDetail), numberGroupsDetail);
            return;
        }
        internalGroupExtJNI.ICallbackWithNumberGroupsDetail_doneSwigExplicitICallbackWithNumberGroupsDetail(this.swigCPtr, this, NumberGroupsDetail.getCPtr(numberGroupsDetail), numberGroupsDetail);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithNumberGroupsDetail.class) {
            internalGroupExtJNI.ICallbackWithNumberGroupsDetail_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithNumberGroupsDetail_failSwigExplicitICallbackWithNumberGroupsDetail(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithNumberGroupsDetail_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithNumberGroupsDetail_change_ownership(this, this.swigCPtr, true);
    }
}
