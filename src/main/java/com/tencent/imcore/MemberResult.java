package com.tencent.imcore;

public class MemberResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MemberResult() {
        this(internalGroupExtJNI.new_MemberResult(), true);
    }

    protected MemberResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MemberResult memberResult) {
        if (memberResult == null) {
            return 0;
        }
        return memberResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_MemberResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getStatus() {
        return internalGroupExtJNI.MemberResult_status_get(this.swigCPtr, this);
    }

    public String getUser() {
        return internalGroupExtJNI.MemberResult_user_get(this.swigCPtr, this);
    }

    public void setStatus(long j) {
        internalGroupExtJNI.MemberResult_status_set(this.swigCPtr, this, j);
    }

    public void setUser(String str) {
        internalGroupExtJNI.MemberResult_user_set(this.swigCPtr, this, str);
    }
}
