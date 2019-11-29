package com.tencent.imcore;

public class FriendFutureResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendFutureResult() {
        this(internalSnsExtJNI.new_FriendFutureResult(), true);
    }

    protected FriendFutureResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendFutureResult friendFutureResult) {
        if (friendFutureResult == null) {
            return 0;
        }
        return friendFutureResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendFutureResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendFutureItemVec getFutures() {
        long FriendFutureResult_futures_get = internalSnsExtJNI.FriendFutureResult_futures_get(this.swigCPtr, this);
        if (FriendFutureResult_futures_get == 0) {
            return null;
        }
        return new FriendFutureItemVec(FriendFutureResult_futures_get, false);
    }

    public FutureFriendMeta getMeta() {
        long FriendFutureResult_meta_get = internalSnsExtJNI.FriendFutureResult_meta_get(this.swigCPtr, this);
        if (FriendFutureResult_meta_get == 0) {
            return null;
        }
        return new FutureFriendMeta(FriendFutureResult_meta_get, false);
    }

    public void setFutures(FriendFutureItemVec friendFutureItemVec) {
        internalSnsExtJNI.FriendFutureResult_futures_set(this.swigCPtr, this, FriendFutureItemVec.getCPtr(friendFutureItemVec), friendFutureItemVec);
    }

    public void setMeta(FutureFriendMeta futureFriendMeta) {
        internalSnsExtJNI.FriendFutureResult_meta_set(this.swigCPtr, this, FutureFriendMeta.getCPtr(futureFriendMeta), futureFriendMeta);
    }
}
