package com.tencent.imcore;

public class MemberResultVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MemberResultVec() {
        this(internalGroupExtJNI.new_MemberResultVec__SWIG_0(), true);
    }

    public MemberResultVec(long j) {
        this(internalGroupExtJNI.new_MemberResultVec__SWIG_1(j), true);
    }

    protected MemberResultVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MemberResultVec memberResultVec) {
        if (memberResultVec == null) {
            return 0;
        }
        return memberResultVec.swigCPtr;
    }

    public void add(MemberResult memberResult) {
        internalGroupExtJNI.MemberResultVec_add(this.swigCPtr, this, MemberResult.getCPtr(memberResult), memberResult);
    }

    public long capacity() {
        return internalGroupExtJNI.MemberResultVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalGroupExtJNI.MemberResultVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_MemberResultVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public MemberResult get(int i) {
        return new MemberResult(internalGroupExtJNI.MemberResultVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalGroupExtJNI.MemberResultVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalGroupExtJNI.MemberResultVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, MemberResult memberResult) {
        internalGroupExtJNI.MemberResultVec_set(this.swigCPtr, this, i, MemberResult.getCPtr(memberResult), memberResult);
    }

    public long size() {
        return internalGroupExtJNI.MemberResultVec_size(this.swigCPtr, this);
    }
}
