package com.tencent.imcore;

public class FriendPendencyMeta {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendPendencyMeta() {
        this(internalSnsExtJNI.new_FriendPendencyMeta(), true);
    }

    protected FriendPendencyMeta(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendPendencyMeta friendPendencyMeta) {
        if (friendPendencyMeta == null) {
            return 0;
        }
        return friendPendencyMeta.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendPendencyMeta(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getDdwNumPerPage() {
        return internalSnsExtJNI.FriendPendencyMeta_ddwNumPerPage_get(this.swigCPtr, this);
    }

    public long getDdwSeq() {
        return internalSnsExtJNI.FriendPendencyMeta_ddwSeq_get(this.swigCPtr, this);
    }

    public long getDdwTimestamp() {
        return internalSnsExtJNI.FriendPendencyMeta_ddwTimestamp_get(this.swigCPtr, this);
    }

    public long getDdwUnReadCnt() {
        return internalSnsExtJNI.FriendPendencyMeta_ddwUnReadCnt_get(this.swigCPtr, this);
    }

    public void setDdwNumPerPage(long j) {
        internalSnsExtJNI.FriendPendencyMeta_ddwNumPerPage_set(this.swigCPtr, this, j);
    }

    public void setDdwSeq(long j) {
        internalSnsExtJNI.FriendPendencyMeta_ddwSeq_set(this.swigCPtr, this, j);
    }

    public void setDdwTimestamp(long j) {
        internalSnsExtJNI.FriendPendencyMeta_ddwTimestamp_set(this.swigCPtr, this, j);
    }

    public void setDdwUnReadCnt(long j) {
        internalSnsExtJNI.FriendPendencyMeta_ddwUnReadCnt_set(this.swigCPtr, this, j);
    }
}
