package com.tencent.imcore;

public class IFriendshipNotify {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IFriendshipNotify() {
        this(internalSnsExtJNI.new_IFriendshipNotify(), true);
        internalSnsExtJNI.IFriendshipNotify_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected IFriendshipNotify(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IFriendshipNotify iFriendshipNotify) {
        if (iFriendshipNotify == null) {
            return 0;
        }
        return iFriendshipNotify.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_IFriendshipNotify(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void onAddFriendNotify(FriendProfileVec friendProfileVec) {
        internalSnsExtJNI.IFriendshipNotify_onAddFriendNotify(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public void onAddFriendReq(AddFriendReqVec addFriendReqVec) {
        internalSnsExtJNI.IFriendshipNotify_onAddFriendReq(this.swigCPtr, this, AddFriendReqVec.getCPtr(addFriendReqVec), addFriendReqVec);
    }

    public void onDeleteFriendNotify(StrVec strVec) {
        internalSnsExtJNI.IFriendshipNotify_onDeleteFriendNotify(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }

    public void onFriendProfileUpdate(FriendProfileVec friendProfileVec) {
        internalSnsExtJNI.IFriendshipNotify_onFriendProfileUpdate(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        internalSnsExtJNI.IFriendshipNotify_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalSnsExtJNI.IFriendshipNotify_change_ownership(this, this.swigCPtr, true);
    }
}
