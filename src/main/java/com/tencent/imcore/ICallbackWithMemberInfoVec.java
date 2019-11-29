package com.tencent.imcore;

public class ICallbackWithMemberInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithMemberInfoVec() {
        this(internalGroupExtJNI.new_ICallbackWithMemberInfoVec(), true);
        internalGroupExtJNI.ICallbackWithMemberInfoVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithMemberInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec) {
        if (iCallbackWithMemberInfoVec == null) {
            return 0;
        }
        return iCallbackWithMemberInfoVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithMemberInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(MemberInfoVec memberInfoVec) {
        if (getClass() == ICallbackWithMemberInfoVec.class) {
            internalGroupExtJNI.ICallbackWithMemberInfoVec_done(this.swigCPtr, this, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
            return;
        }
        internalGroupExtJNI.ICallbackWithMemberInfoVec_doneSwigExplicitICallbackWithMemberInfoVec(this.swigCPtr, this, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithMemberInfoVec.class) {
            internalGroupExtJNI.ICallbackWithMemberInfoVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithMemberInfoVec_failSwigExplicitICallbackWithMemberInfoVec(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithMemberInfoVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithMemberInfoVec_change_ownership(this, this.swigCPtr, true);
    }
}
