package com.tencent.imcore;

public class FriendPendencyResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendPendencyResult() {
        this(internalSnsExtJNI.new_FriendPendencyResult(), true);
    }

    protected FriendPendencyResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendPendencyResult friendPendencyResult) {
        if (friendPendencyResult == null) {
            return 0;
        }
        return friendPendencyResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendPendencyResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendPendencyMeta getMeta() {
        long FriendPendencyResult_meta_get = internalSnsExtJNI.FriendPendencyResult_meta_get(this.swigCPtr, this);
        if (FriendPendencyResult_meta_get == 0) {
            return null;
        }
        return new FriendPendencyMeta(FriendPendencyResult_meta_get, false);
    }

    public FriendPendencyItemVec getPendencies() {
        long FriendPendencyResult_pendencies_get = internalSnsExtJNI.FriendPendencyResult_pendencies_get(this.swigCPtr, this);
        if (FriendPendencyResult_pendencies_get == 0) {
            return null;
        }
        return new FriendPendencyItemVec(FriendPendencyResult_pendencies_get, false);
    }

    public void setMeta(FriendPendencyMeta friendPendencyMeta) {
        internalSnsExtJNI.FriendPendencyResult_meta_set(this.swigCPtr, this, FriendPendencyMeta.getCPtr(friendPendencyMeta), friendPendencyMeta);
    }

    public void setPendencies(FriendPendencyItemVec friendPendencyItemVec) {
        internalSnsExtJNI.FriendPendencyResult_pendencies_set(this.swigCPtr, this, FriendPendencyItemVec.getCPtr(friendPendencyItemVec), friendPendencyItemVec);
    }
}
