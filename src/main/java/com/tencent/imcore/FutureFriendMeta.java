package com.tencent.imcore;

public class FutureFriendMeta {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FutureFriendMeta() {
        this(internalSnsExtJNI.new_FutureFriendMeta(), true);
    }

    protected FutureFriendMeta(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FutureFriendMeta futureFriendMeta) {
        if (futureFriendMeta == null) {
            return 0;
        }
        return futureFriendMeta.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FutureFriendMeta(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getDdwCurrentDecideTimestamp() {
        return internalSnsExtJNI.FutureFriendMeta_ddwCurrentDecideTimestamp_get(this.swigCPtr, this);
    }

    public long getDdwCurrentPendencyTimestamp() {
        return internalSnsExtJNI.FutureFriendMeta_ddwCurrentPendencyTimestamp_get(this.swigCPtr, this);
    }

    public long getDdwCurrentRecommendTimestamp() {
        return internalSnsExtJNI.FutureFriendMeta_ddwCurrentRecommendTimestamp_get(this.swigCPtr, this);
    }

    public long getDdwDecideSequence() {
        return internalSnsExtJNI.FutureFriendMeta_ddwDecideSequence_get(this.swigCPtr, this);
    }

    public long getDdwDecideUnreadCnt() {
        return internalSnsExtJNI.FutureFriendMeta_ddwDecideUnreadCnt_get(this.swigCPtr, this);
    }

    public long getDdwPendencySequence() {
        return internalSnsExtJNI.FutureFriendMeta_ddwPendencySequence_get(this.swigCPtr, this);
    }

    public long getDdwPendencyUnReadCnt() {
        return internalSnsExtJNI.FutureFriendMeta_ddwPendencyUnReadCnt_get(this.swigCPtr, this);
    }

    public long getDdwRecommendSequence() {
        return internalSnsExtJNI.FutureFriendMeta_ddwRecommendSequence_get(this.swigCPtr, this);
    }

    public long getDdwRecommendUnReadCnt() {
        return internalSnsExtJNI.FutureFriendMeta_ddwRecommendUnReadCnt_get(this.swigCPtr, this);
    }

    public long getDdwReqNum() {
        return internalSnsExtJNI.FutureFriendMeta_ddwReqNum_get(this.swigCPtr, this);
    }

    public long getDdwTimestamp() {
        return internalSnsExtJNI.FutureFriendMeta_ddwTimestamp_get(this.swigCPtr, this);
    }

    public int getIDirection() {
        return internalSnsExtJNI.FutureFriendMeta_iDirection_get(this.swigCPtr, this);
    }

    public void setDdwCurrentDecideTimestamp(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwCurrentDecideTimestamp_set(this.swigCPtr, this, j);
    }

    public void setDdwCurrentPendencyTimestamp(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwCurrentPendencyTimestamp_set(this.swigCPtr, this, j);
    }

    public void setDdwCurrentRecommendTimestamp(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwCurrentRecommendTimestamp_set(this.swigCPtr, this, j);
    }

    public void setDdwDecideSequence(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwDecideSequence_set(this.swigCPtr, this, j);
    }

    public void setDdwDecideUnreadCnt(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwDecideUnreadCnt_set(this.swigCPtr, this, j);
    }

    public void setDdwPendencySequence(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwPendencySequence_set(this.swigCPtr, this, j);
    }

    public void setDdwPendencyUnReadCnt(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwPendencyUnReadCnt_set(this.swigCPtr, this, j);
    }

    public void setDdwRecommendSequence(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwRecommendSequence_set(this.swigCPtr, this, j);
    }

    public void setDdwRecommendUnReadCnt(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwRecommendUnReadCnt_set(this.swigCPtr, this, j);
    }

    public void setDdwReqNum(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwReqNum_set(this.swigCPtr, this, j);
    }

    public void setDdwTimestamp(long j) {
        internalSnsExtJNI.FutureFriendMeta_ddwTimestamp_set(this.swigCPtr, this, j);
    }

    public void setIDirection(int i) {
        internalSnsExtJNI.FutureFriendMeta_iDirection_set(this.swigCPtr, this, i);
    }
}
