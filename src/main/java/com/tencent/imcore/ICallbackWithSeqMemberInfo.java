package com.tencent.imcore;

public class ICallbackWithSeqMemberInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ICallbackWithSeqMemberInfo() {
        this(internalGroupExtJNI.new_ICallbackWithSeqMemberInfo(), true);
        internalGroupExtJNI.ICallbackWithSeqMemberInfo_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected ICallbackWithSeqMemberInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo) {
        if (iCallbackWithSeqMemberInfo == null) {
            return 0;
        }
        return iCallbackWithSeqMemberInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_ICallbackWithSeqMemberInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done(SeqMemberInfo seqMemberInfo) {
        if (getClass() == ICallbackWithSeqMemberInfo.class) {
            internalGroupExtJNI.ICallbackWithSeqMemberInfo_done(this.swigCPtr, this, SeqMemberInfo.getCPtr(seqMemberInfo), seqMemberInfo);
            return;
        }
        internalGroupExtJNI.ICallbackWithSeqMemberInfo_doneSwigExplicitICallbackWithSeqMemberInfo(this.swigCPtr, this, SeqMemberInfo.getCPtr(seqMemberInfo), seqMemberInfo);
    }

    public void fail(int i, String str) {
        if (getClass() == ICallbackWithSeqMemberInfo.class) {
            internalGroupExtJNI.ICallbackWithSeqMemberInfo_fail(this.swigCPtr, this, i, str);
        } else {
            internalGroupExtJNI.ICallbackWithSeqMemberInfo_failSwigExplicitICallbackWithSeqMemberInfo(this.swigCPtr, this, i, str);
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
        internalGroupExtJNI.ICallbackWithSeqMemberInfo_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.ICallbackWithSeqMemberInfo_change_ownership(this, this.swigCPtr, true);
    }
}
