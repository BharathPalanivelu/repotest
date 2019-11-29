package com.tencent.imcore;

public class GroupMemberInfoOpt {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupMemberInfoOpt() {
        this(internalJNI.new_GroupMemberInfoOpt(), true);
    }

    protected GroupMemberInfoOpt(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupMemberInfoOpt groupMemberInfoOpt) {
        if (groupMemberInfoOpt == null) {
            return 0;
        }
        return groupMemberInfoOpt.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupMemberInfoOpt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesVec getCustom() {
        long GroupMemberInfoOpt_custom_get = internalJNI.GroupMemberInfoOpt_custom_get(this.swigCPtr, this);
        if (GroupMemberInfoOpt_custom_get == 0) {
            return null;
        }
        return new BytesVec(GroupMemberInfoOpt_custom_get, false);
    }

    public long getFlags() {
        return internalJNI.GroupMemberInfoOpt_flags_get(this.swigCPtr, this);
    }

    public void setCustom(BytesVec bytesVec) {
        internalJNI.GroupMemberInfoOpt_custom_set(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec);
    }

    public void setFlags(long j) {
        internalJNI.GroupMemberInfoOpt_flags_set(this.swigCPtr, this, j);
    }
}
