package com.tencent.imcore;

public class SearchUserResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SearchUserResult() {
        this(internalSnsExtJNI.new_SearchUserResult(), true);
    }

    protected SearchUserResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SearchUserResult searchUserResult) {
        if (searchUserResult == null) {
            return 0;
        }
        return searchUserResult.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_SearchUserResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public FriendProfileVec getFriends() {
        long SearchUserResult_friends_get = internalSnsExtJNI.SearchUserResult_friends_get(this.swigCPtr, this);
        if (SearchUserResult_friends_get == 0) {
            return null;
        }
        return new FriendProfileVec(SearchUserResult_friends_get, false);
    }

    public long getTotalNum() {
        return internalSnsExtJNI.SearchUserResult_totalNum_get(this.swigCPtr, this);
    }

    public void setFriends(FriendProfileVec friendProfileVec) {
        internalSnsExtJNI.SearchUserResult_friends_set(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public void setTotalNum(long j) {
        internalSnsExtJNI.SearchUserResult_totalNum_set(this.swigCPtr, this, j);
    }
}
