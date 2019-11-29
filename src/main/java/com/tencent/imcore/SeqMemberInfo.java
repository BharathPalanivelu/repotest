package com.tencent.imcore;

public class SeqMemberInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SeqMemberInfo() {
        this(internalGroupExtJNI.new_SeqMemberInfo(), true);
    }

    protected SeqMemberInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SeqMemberInfo seqMemberInfo) {
        if (seqMemberInfo == null) {
            return 0;
        }
        return seqMemberInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_SeqMemberInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public MemberInfoVec getMembers() {
        long SeqMemberInfo_members_get = internalGroupExtJNI.SeqMemberInfo_members_get(this.swigCPtr, this);
        if (SeqMemberInfo_members_get == 0) {
            return null;
        }
        return new MemberInfoVec(SeqMemberInfo_members_get, false);
    }

    public long getSeq() {
        return internalGroupExtJNI.SeqMemberInfo_seq_get(this.swigCPtr, this);
    }

    public void setMembers(MemberInfoVec memberInfoVec) {
        internalGroupExtJNI.SeqMemberInfo_members_set(this.swigCPtr, this, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
    }

    public void setSeq(long j) {
        internalGroupExtJNI.SeqMemberInfo_seq_set(this.swigCPtr, this, j);
    }
}
