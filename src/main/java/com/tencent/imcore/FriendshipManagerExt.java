package com.tencent.imcore;

public class FriendshipManagerExt extends FriendshipManager {
    private transient long swigCPtr;

    protected FriendshipManagerExt(long j, boolean z) {
        super(internalSnsExtJNI.FriendshipManagerExt_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public FriendshipManagerExt(String str, IFriendshipNotify iFriendshipNotify) {
        this(internalSnsExtJNI.new_FriendshipManagerExt(str, IFriendshipNotify.getCPtr(iFriendshipNotify), iFriendshipNotify), true);
    }

    protected static long getCPtr(FriendshipManagerExt friendshipManagerExt) {
        if (friendshipManagerExt == null) {
            return 0;
        }
        return friendshipManagerExt.swigCPtr;
    }

    public static void onMsgEvent(String str, MsgVec msgVec) {
        internalSnsExtJNI.FriendshipManagerExt_onMsgEvent(str, MsgVec.getCPtr(msgVec), msgVec);
    }

    public boolean addBlackList(StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_addBlackList(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean addFriend(FriendProfileVec friendProfileVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_addFriend(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean addFriendToMap(FriendProfile friendProfile) {
        return internalSnsExtJNI.FriendshipManagerExt_addFriendToMap(this.swigCPtr, this, FriendProfile.getCPtr(friendProfile), friendProfile);
    }

    public boolean addFriends2Group(byte[] bArr, StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_addFriends2Group(this.swigCPtr, this, bArr, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean checkFriend(StrVec strVec, String str, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_checkFriend(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, str, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public void clearAllData() {
        internalSnsExtJNI.FriendshipManagerExt_clearAllData(this.swigCPtr, this);
    }

    public boolean createFriendGroup(BytesVec bytesVec, StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_createFriendGroup(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean delBlackList(StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_delBlackList(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean delFriend(FriendDeleteType friendDeleteType, FriendProfileVec friendProfileVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_delFriend(this.swigCPtr, this, friendDeleteType.swigValue(), FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean delFriendFromMap(FriendProfile friendProfile) {
        return internalSnsExtJNI.FriendshipManagerExt_delFriendFromMap(this.swigCPtr, this, FriendProfile.getCPtr(friendProfile), friendProfile);
    }

    public boolean delFriendsFromGroup(byte[] bArr, StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_delFriendsFromGroup(this.swigCPtr, this, bArr, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalSnsExtJNI.delete_FriendshipManagerExt(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public boolean deleteDecide(StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_deleteDecide(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean deleteFriendGroup(BytesVec bytesVec, INotifyCallback iNotifyCallback) {
        return internalSnsExtJNI.FriendshipManagerExt_deleteFriendGroup(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean deletePendency(PendencyType pendencyType, StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_deletePendency(this.swigCPtr, this, pendencyType.swigValue(), StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean deleteRecommend(StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_deleteRecommend(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean doResponse(FriendProfileVec friendProfileVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_doResponse(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public boolean getBlackList(ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getBlackList(this.swigCPtr, this, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public int getFriendGroup(BytesVec bytesVec, FriendGroupVec friendGroupVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendGroup__SWIG_1(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec, FriendGroupVec.getCPtr(friendGroupVec), friendGroupVec);
    }

    public boolean getFriendGroup(BytesVec bytesVec, boolean z, ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendGroup__SWIG_0(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec, z, ICallbackWithFriendGroupVec.getCPtr(iCallbackWithFriendGroupVec), iCallbackWithFriendGroupVec);
    }

    public long getFriendGroupSeq() {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendGroupSeq(this.swigCPtr, this);
    }

    public int getFriendList(FriendProfileVec friendProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendList__SWIG_1(this.swigCPtr, this, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public boolean getFriendList(ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendList__SWIG_0(this.swigCPtr, this, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean getFriendListV2(long j, StrVec strVec, FriendMetaInfo friendMetaInfo, SWIGTYPE_p_imcore__ICallbackT_imcore__FriendListMetaResult_t sWIGTYPE_p_imcore__ICallbackT_imcore__FriendListMetaResult_t) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendListV2(this.swigCPtr, this, j, StrVec.getCPtr(strVec), strVec, FriendMetaInfo.getCPtr(friendMetaInfo), friendMetaInfo, SWIGTYPE_p_imcore__ICallbackT_imcore__FriendListMetaResult_t.getCPtr(sWIGTYPE_p_imcore__ICallbackT_imcore__FriendListMetaResult_t));
    }

    public int getFriendProfile(StrVec strVec, FriendProfileVec friendProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendProfile__SWIG_1(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, FriendProfileVec.getCPtr(friendProfileVec), friendProfileVec);
    }

    public boolean getFriendProfile(StrVec strVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_getFriendProfile__SWIG_0(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public boolean getFutureFriends(long j, long j2, StrVec strVec, FutureFriendMeta futureFriendMeta, ICallbackWithFutureResult iCallbackWithFutureResult) {
        return internalSnsExtJNI.FriendshipManagerExt_getFutureFriends(this.swigCPtr, this, j, j2, StrVec.getCPtr(strVec), strVec, FutureFriendMeta.getCPtr(futureFriendMeta), futureFriendMeta, ICallbackWithFutureResult.getCPtr(iCallbackWithFutureResult), iCallbackWithFutureResult);
    }

    public FriendProfileVec getLocalFrdList() {
        return new FriendProfileVec(internalSnsExtJNI.FriendshipManagerExt_getLocalFrdList(this.swigCPtr, this), true);
    }

    public boolean getPendencyFromServer(FriendPendencyMeta friendPendencyMeta, PendencyType pendencyType, ICallbackWithPendencyResult iCallbackWithPendencyResult) {
        return internalSnsExtJNI.FriendshipManagerExt_getPendencyFromServer(this.swigCPtr, this, FriendPendencyMeta.getCPtr(friendPendencyMeta), friendPendencyMeta, pendencyType.swigValue(), ICallbackWithPendencyResult.getCPtr(iCallbackWithPendencyResult), iCallbackWithPendencyResult);
    }

    public boolean modifyFriendGroupName(byte[] bArr, byte[] bArr2, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_modifyFriendGroupName(this.swigCPtr, this, bArr, bArr2, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public SWIGTYPE_p_std__shared_ptrT_imcore__IFriendshipNotify_t notifyCb() {
        return new SWIGTYPE_p_std__shared_ptrT_imcore__IFriendshipNotify_t(internalSnsExtJNI.FriendshipManagerExt_notifyCb(this.swigCPtr, this), true);
    }

    public boolean pendencyReport(long j, INotifyCallback iNotifyCallback) {
        return internalSnsExtJNI.FriendshipManagerExt_pendencyReport(this.swigCPtr, this, j, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public SWIGTYPE_p_std__shared_ptrT_imcore__FriendshipProxy_t proxy() {
        return new SWIGTYPE_p_std__shared_ptrT_imcore__FriendshipProxy_t(internalSnsExtJNI.FriendshipManagerExt_proxy(this.swigCPtr, this), true);
    }

    public boolean recommendReport(long j, INotifyCallback iNotifyCallback) {
        return internalSnsExtJNI.FriendshipManagerExt_recommendReport(this.swigCPtr, this, j, INotifyCallback.getCPtr(iNotifyCallback), iNotifyCallback);
    }

    public boolean searchFriendsUseNickName(String str, long j, long j2, ICallbackWithSearchResult iCallbackWithSearchResult) {
        return internalSnsExtJNI.FriendshipManagerExt_searchFriendsUseNickName(this.swigCPtr, this, str, j, j2, ICallbackWithSearchResult.getCPtr(iCallbackWithSearchResult), iCallbackWithSearchResult);
    }

    public void setExpire() {
        internalSnsExtJNI.FriendshipManagerExt_setExpire(this.swigCPtr, this);
    }

    public boolean setFrdListTimestamp(long j) {
        return internalSnsExtJNI.FriendshipManagerExt_setFrdListTimestamp(this.swigCPtr, this, j);
    }

    public boolean setFrdSeq(long j) {
        return internalSnsExtJNI.FriendshipManagerExt_setFrdSeq(this.swigCPtr, this, j);
    }

    public boolean setSnsProfile(SNSProfileItemVec sNSProfileItemVec, ICallbackWithProfileVec iCallbackWithProfileVec) {
        return internalSnsExtJNI.FriendshipManagerExt_setSnsProfile(this.swigCPtr, this, SNSProfileItemVec.getCPtr(sNSProfileItemVec), sNSProfileItemVec, ICallbackWithProfileVec.getCPtr(iCallbackWithProfileVec), iCallbackWithProfileVec);
    }

    public SWIGTYPE_p_std__shared_ptrT_imcore__FriendshipStore_t store() {
        return new SWIGTYPE_p_std__shared_ptrT_imcore__FriendshipStore_t(internalSnsExtJNI.FriendshipManagerExt_store(this.swigCPtr, this), true);
    }

    public boolean updateFriendGroupSeq(long j) {
        return internalSnsExtJNI.FriendshipManagerExt_updateFriendGroupSeq(this.swigCPtr, this, j);
    }
}
