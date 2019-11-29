package com.tencent.imcore;

public class FriendProfileInfoOpt {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendProfileInfoOpt() {
        this(internalJNI.new_FriendProfileInfoOpt(), true);
    }

    protected FriendProfileInfoOpt(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendProfileInfoOpt friendProfileInfoOpt) {
        if (friendProfileInfoOpt == null) {
            return 0;
        }
        return friendProfileInfoOpt.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_FriendProfileInfoOpt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getFlags() {
        return internalJNI.FriendProfileInfoOpt_flags_get(this.swigCPtr, this);
    }

    public BytesVec getUser_custom() {
        long FriendProfileInfoOpt_user_custom_get = internalJNI.FriendProfileInfoOpt_user_custom_get(this.swigCPtr, this);
        if (FriendProfileInfoOpt_user_custom_get == 0) {
            return null;
        }
        return new BytesVec(FriendProfileInfoOpt_user_custom_get, false);
    }

    public void setFlags(long j) {
        internalJNI.FriendProfileInfoOpt_flags_set(this.swigCPtr, this, j);
    }

    public void setUser_custom(BytesVec bytesVec) {
        internalJNI.FriendProfileInfoOpt_user_custom_set(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec);
    }
}
