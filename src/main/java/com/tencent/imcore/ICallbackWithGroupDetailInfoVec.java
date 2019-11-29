package com.tencent.imcore;

public class ICallbackWithGroupDetailInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithGroupDetailInfoVec() {
        this(internalGroupExtJNI.new_ICallbackWithGroupDetailInfoVec(), true);
        internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithGroupDetailInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec) {
        if (iCallbackWithGroupDetailInfoVec == null) {
            return 0;
        }
        return iCallbackWithGroupDetailInfoVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithGroupDetailInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(GroupDetailInfoVec groupDetailInfoVec) {
        if (getClass() == ICallbackWithGroupDetailInfoVec.class) {
            internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_done(this.swigCPtr, this, GroupDetailInfoVec.getCPtr(groupDetailInfoVec), groupDetailInfoVec);
            return;
        }
        internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_doneSwigExplicitICallbackWithGroupDetailInfoVec(this.swigCPtr, this, GroupDetailInfoVec.getCPtr(groupDetailInfoVec), groupDetailInfoVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithGroupDetailInfoVec.class) {
            internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_failSwigExplicitICallbackWithGroupDetailInfoVec(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithGroupDetailInfoVec_change_ownership(this, this.swigCPtr, true);
    }
}
