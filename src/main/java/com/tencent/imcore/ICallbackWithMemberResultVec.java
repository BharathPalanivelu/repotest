package com.tencent.imcore;

public class ICallbackWithMemberResultVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithMemberResultVec() {
        this(internalGroupExtJNI.new_ICallbackWithMemberResultVec(), true);
        internalGroupExtJNI.ICallbackWithMemberResultVec_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithMemberResultVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithMemberResultVec iCallbackWithMemberResultVec) {
        if (iCallbackWithMemberResultVec == null) {
            return 0;
        }
        return iCallbackWithMemberResultVec.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithMemberResultVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(MemberResultVec memberResultVec) {
        if (getClass() == ICallbackWithMemberResultVec.class) {
            internalGroupExtJNI.ICallbackWithMemberResultVec_done(this.swigCPtr, this, MemberResultVec.getCPtr(memberResultVec), memberResultVec);
            return;
        }
        internalGroupExtJNI.ICallbackWithMemberResultVec_doneSwigExplicitICallbackWithMemberResultVec(this.swigCPtr, this, MemberResultVec.getCPtr(memberResultVec), memberResultVec);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithMemberResultVec.class) {
            internalGroupExtJNI.ICallbackWithMemberResultVec_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithMemberResultVec_failSwigExplicitICallbackWithMemberResultVec(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithMemberResultVec_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithMemberResultVec_change_ownership(this, this.swigCPtr, true);
    }
}
