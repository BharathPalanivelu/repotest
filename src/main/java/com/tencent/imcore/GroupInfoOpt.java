package com.tencent.imcore;

public class GroupInfoOpt {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupInfoOpt() {
        this(internalJNI.new_GroupInfoOpt(), true);
    }

    protected GroupInfoOpt(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupInfoOpt groupInfoOpt) {
        if (groupInfoOpt == null) {
            return 0;
        }
        return groupInfoOpt.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_GroupInfoOpt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public BytesVec getCustom() {
        long GroupInfoOpt_custom_get = internalJNI.GroupInfoOpt_custom_get(this.swigCPtr, this);
        if (GroupInfoOpt_custom_get == 0) {
            return null;
        }
        return new BytesVec(GroupInfoOpt_custom_get, false);
    }

    public long getFlags() {
        return internalJNI.GroupInfoOpt_flags_get(this.swigCPtr, this);
    }

    public void setCustom(BytesVec bytesVec) {
        internalJNI.GroupInfoOpt_custom_set(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec);
    }

    public void setFlags(long j) {
        internalJNI.GroupInfoOpt_flags_set(this.swigCPtr, this, j);
    }
}
