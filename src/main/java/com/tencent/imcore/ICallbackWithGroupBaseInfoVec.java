package com.tencent.imcore;

public class ICallbackWithGroupBaseInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithGroupBaseInfoVec() {
        this(internalGroupExtJNI.new_ICallbackWithGroupBaseInfoVec(), true);
        internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithGroupBaseInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec) {
        if (iCallbackWithGroupBaseInfoVec == null) {
            return 0;
        }
        return iCallbackWithGroupBaseInfoVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithGroupBaseInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(GroupBaseInfoVec groupBaseInfoVec) {
        if (getClass() == ICallbackWithGroupBaseInfoVec.class) {
            internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_done(this.swigCPtr, this, GroupBaseInfoVec.getCPtr(groupBaseInfoVec), groupBaseInfoVec);
            return;
        }
        internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_doneSwigExplicitICallbackWithGroupBaseInfoVec(this.swigCPtr, this, GroupBaseInfoVec.getCPtr(groupBaseInfoVec), groupBaseInfoVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithGroupBaseInfoVec.class) {
            internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_failSwigExplicitICallbackWithGroupBaseInfoVec(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithGroupBaseInfoVec_change_ownership(this, this.swigCPtr, true);
    }
}
