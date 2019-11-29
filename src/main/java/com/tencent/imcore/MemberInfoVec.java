package com.tencent.imcore;

public class MemberInfoVec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MemberInfoVec() {
        this(internalGroupExtJNI.new_MemberInfoVec__SWIG_0(), true);
    }

    public MemberInfoVec(long j) {
        this(internalGroupExtJNI.new_MemberInfoVec__SWIG_1(j), true);
    }

    protected MemberInfoVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MemberInfoVec memberInfoVec) {
        if (memberInfoVec == null) {
            return 0;
        }
        return memberInfoVec.swigCPtr;
    }

    public void add(MemberInfo memberInfo) {
        internalGroupExtJNI.MemberInfoVec_add(this.swigCPtr, this, MemberInfo.getCPtr(memberInfo), memberInfo);
    }

    public long capacity() {
        return internalGroupExtJNI.MemberInfoVec_capacity(this.swigCPtr, this);
    }

    public void clear() {
        internalGroupExtJNI.MemberInfoVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_MemberInfoVec(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public MemberInfo get(int i) {
        return new MemberInfo(internalGroupExtJNI.MemberInfoVec_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return internalGroupExtJNI.MemberInfoVec_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        internalGroupExtJNI.MemberInfoVec_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, MemberInfo memberInfo) {
        internalGroupExtJNI.MemberInfoVec_set(this.swigCPtr, this, i, MemberInfo.getCPtr(memberInfo), memberInfo);
    }

    public long size() {
        return internalGroupExtJNI.MemberInfoVec_size(this.swigCPtr, this);
    }
}
