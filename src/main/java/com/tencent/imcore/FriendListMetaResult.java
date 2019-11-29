package com.tencent.imcore;

public class FriendListMetaResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FriendListMetaResult() {
        this(internalSnsExtJNI.new_FriendListMetaResult(), true);
    }

    protected FriendListMetaResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FriendListMetaResult friendListMetaResult) {
        if (friendListMetaResult == null) {
            return 0;
        }
        return friendListMetaResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendListMetaResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendProfileVec getFriends() {
        long FriendListMetaResult_friends_get = internalSnsExtJNI.FriendListMetaResult_friends_get(this.swigCPtr, this);
        if (FriendListMetaResult_friends_get == 0) {
            return null;
        }
        return new FriendProfileVec(FriendListMetaResult_friends_get, false);
    }

    public FriendMetaInfo getInfo() {
        long FriendListMetaResult_info_get = internalSnsExtJNI.FriendListMetaResult_info_get(this.swigCPtr, this);
        if (FriendListMetaResult_info_get == 0) {
            return null;
        }
        return new FriendMetaInfo(FriendListMetaResult_info_get, false);
    }

    public void setFriends(FriendProfileVec friendProfileVec) {
        internalSnsExtJNI.FriendListMetaResult_friends_set(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public void setInfo(FriendMetaInfo friendMetaInfo) {
        internalSnsExtJNI.FriendListMetaResult_info_set(this.swigCPtr, this, FriendMetaInfo.getCPtr(friendMetaInfo), friendMetaInfo);
    }
}
