package com.tencent.imcore;

public class FriendMetaInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendMetaInfo() {
        this(internalSnsExtJNI.new_FriendMetaInfo(), true);
    }

    protected FriendMetaInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendMetaInfo friendMetaInfo) {
        if (friendMetaInfo == null) {
            return 0;
        }
        return friendMetaInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendMetaInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getDdwInfoSeq() {
        return internalSnsExtJNI.FriendMetaInfo_ddwInfoSeq_get(this.swigCPtr, this);
    }

    public long getDdwNextSeq() {
        return internalSnsExtJNI.FriendMetaInfo_ddwNextSeq_get(this.swigCPtr, this);
    }

    public long getDdwTimestamp() {
        return internalSnsExtJNI.FriendMetaInfo_ddwTimestamp_get(this.swigCPtr, this);
    }

    public boolean getRecover() {
        return internalSnsExtJNI.FriendMetaInfo_recover_get(this.swigCPtr, this);
    }

    public void setDdwInfoSeq(long j) {
        internalSnsExtJNI.FriendMetaInfo_ddwInfoSeq_set(this.swigCPtr, this, j);
    }

    public void setDdwNextSeq(long j) {
        internalSnsExtJNI.FriendMetaInfo_ddwNextSeq_set(this.swigCPtr, this, j);
    }

    public void setDdwTimestamp(long j) {
        internalSnsExtJNI.FriendMetaInfo_ddwTimestamp_set(this.swigCPtr, this, j);
    }

    public void setRecover(boolean z) {
        internalSnsExtJNI.FriendMetaInfo_recover_set(this.swigCPtr, this, z);
    }
}
