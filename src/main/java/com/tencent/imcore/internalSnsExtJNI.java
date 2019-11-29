package com.tencent.imcore;

public class internalSnsExtJNI {
    static {
        swig_module_init();
    }

    public static final native void AddFriendReqVec_add(long j, AddFriendReqVec addFriendReqVec, long j2, AddFriendReq addFriendReq);

    public static final native long AddFriendReqVec_capacity(long j, AddFriendReqVec addFriendReqVec);

    public static final native void AddFriendReqVec_clear(long j, AddFriendReqVec addFriendReqVec);

    public static final native long AddFriendReqVec_get(long j, AddFriendReqVec addFriendReqVec, int i);

    public static final native boolean AddFriendReqVec_isEmpty(long j, AddFriendReqVec addFriendReqVec);

    public static final native void AddFriendReqVec_reserve(long j, AddFriendReqVec addFriendReqVec, long j2);

    public static final native void AddFriendReqVec_set(long j, AddFriendReqVec addFriendReqVec, int i, long j2, AddFriendReq addFriendReq);

    public static final native long AddFriendReqVec_size(long j, AddFriendReqVec addFriendReqVec);

    public static final native String AddFriendReq_identifier_get(long j, AddFriendReq addFriendReq);

    public static final native void AddFriendReq_identifier_set(long j, AddFriendReq addFriendReq, String str);

    public static final native byte[] AddFriendReq_nickname_get(long j, AddFriendReq addFriendReq);

    public static final native void AddFriendReq_nickname_set(long j, AddFriendReq addFriendReq, byte[] bArr);

    public static final native byte[] AddFriendReq_source_get(long j, AddFriendReq addFriendReq);

    public static final native void AddFriendReq_source_set(long j, AddFriendReq addFriendReq, byte[] bArr);

    public static final native byte[] AddFriendReq_wording_get(long j, AddFriendReq addFriendReq);

    public static final native void AddFriendReq_wording_set(long j, AddFriendReq addFriendReq, byte[] bArr);

    public static final native long FriendExtHelper_getFriendshipManagerExt__SWIG_0(String str, long j, IFriendshipNotify iFriendshipNotify);

    public static final native long FriendExtHelper_getFriendshipManagerExt__SWIG_1(String str);

    public static final native void FriendFutureItemVec_add(long j, FriendFutureItemVec friendFutureItemVec, long j2, FriendFutureItem friendFutureItem);

    public static final native long FriendFutureItemVec_capacity(long j, FriendFutureItemVec friendFutureItemVec);

    public static final native void FriendFutureItemVec_clear(long j, FriendFutureItemVec friendFutureItemVec);

    public static final native long FriendFutureItemVec_get(long j, FriendFutureItemVec friendFutureItemVec, int i);

    public static final native boolean FriendFutureItemVec_isEmpty(long j, FriendFutureItemVec friendFutureItemVec);

    public static final native void FriendFutureItemVec_reserve(long j, FriendFutureItemVec friendFutureItemVec, long j2);

    public static final native void FriendFutureItemVec_set(long j, FriendFutureItemVec friendFutureItemVec, int i, long j2, FriendFutureItem friendFutureItem);

    public static final native long FriendFutureItemVec_size(long j, FriendFutureItemVec friendFutureItemVec);

    public static final native long FriendFutureItem_ddwAddTime_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_ddwAddTime_set(long j, FriendFutureItem friendFutureItem, long j2);

    public static final native int FriendFutureItem_eType_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_eType_set(long j, FriendFutureItem friendFutureItem, int i);

    public static final native long FriendFutureItem_mpRecommendTags_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_mpRecommendTags_set(long j, FriendFutureItem friendFutureItem, long j2, BytesMap bytesMap);

    public static final native byte[] FriendFutureItem_sAddSource_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_sAddSource_set(long j, FriendFutureItem friendFutureItem, byte[] bArr);

    public static final native byte[] FriendFutureItem_sAddWording_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_sAddWording_set(long j, FriendFutureItem friendFutureItem, byte[] bArr);

    public static final native String FriendFutureItem_sIdentifier_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_sIdentifier_set(long j, FriendFutureItem friendFutureItem, String str);

    public static final native long FriendFutureItem_stProfile_get(long j, FriendFutureItem friendFutureItem);

    public static final native void FriendFutureItem_stProfile_set(long j, FriendFutureItem friendFutureItem, long j2, FriendProfile friendProfile);

    public static final native long FriendFutureResult_futures_get(long j, FriendFutureResult friendFutureResult);

    public static final native void FriendFutureResult_futures_set(long j, FriendFutureResult friendFutureResult, long j2, FriendFutureItemVec friendFutureItemVec);

    public static final native long FriendFutureResult_meta_get(long j, FriendFutureResult friendFutureResult);

    public static final native void FriendFutureResult_meta_set(long j, FriendFutureResult friendFutureResult, long j2, FutureFriendMeta futureFriendMeta);

    public static final native long FriendGroupItem_identifiers_get(long j, FriendGroupItem friendGroupItem);

    public static final native void FriendGroupItem_identifiers_set(long j, FriendGroupItem friendGroupItem, long j2);

    public static final native byte[] FriendGroupItem_name_get(long j, FriendGroupItem friendGroupItem);

    public static final native void FriendGroupItem_name_set(long j, FriendGroupItem friendGroupItem, byte[] bArr);

    public static final native void FriendGroupVec_add(long j, FriendGroupVec friendGroupVec, long j2, FriendGroup friendGroup);

    public static final native long FriendGroupVec_capacity(long j, FriendGroupVec friendGroupVec);

    public static final native void FriendGroupVec_clear(long j, FriendGroupVec friendGroupVec);

    public static final native long FriendGroupVec_get(long j, FriendGroupVec friendGroupVec, int i);

    public static final native boolean FriendGroupVec_isEmpty(long j, FriendGroupVec friendGroupVec);

    public static final native void FriendGroupVec_reserve(long j, FriendGroupVec friendGroupVec, long j2);

    public static final native void FriendGroupVec_set(long j, FriendGroupVec friendGroupVec, int i, long j2, FriendGroup friendGroup);

    public static final native long FriendGroupVec_size(long j, FriendGroupVec friendGroupVec);

    public static final native long FriendGroup_count_get(long j, FriendGroup friendGroup);

    public static final native void FriendGroup_count_set(long j, FriendGroup friendGroup, long j2);

    public static final native long FriendGroup_identifiers_get(long j, FriendGroup friendGroup);

    public static final native void FriendGroup_identifiers_set(long j, FriendGroup friendGroup, long j2, StrVec strVec);

    public static final native byte[] FriendGroup_name_get(long j, FriendGroup friendGroup);

    public static final native void FriendGroup_name_set(long j, FriendGroup friendGroup, byte[] bArr);

    public static final native long FriendGroup_profiles_get(long j, FriendGroup friendGroup);

    public static final native void FriendGroup_profiles_set(long j, FriendGroup friendGroup, long j2, FriendProfileVec friendProfileVec);

    public static final native long FriendGroup_tinyids_get(long j, FriendGroup friendGroup);

    public static final native void FriendGroup_tinyids_set(long j, FriendGroup friendGroup, long j2);

    public static final native long FriendListMetaResult_friends_get(long j, FriendListMetaResult friendListMetaResult);

    public static final native void FriendListMetaResult_friends_set(long j, FriendListMetaResult friendListMetaResult, long j2, FriendProfileVec friendProfileVec);

    public static final native long FriendListMetaResult_info_get(long j, FriendListMetaResult friendListMetaResult);

    public static final native void FriendListMetaResult_info_set(long j, FriendListMetaResult friendListMetaResult, long j2, FriendMetaInfo friendMetaInfo);

    public static final native long FriendMetaInfo_ddwInfoSeq_get(long j, FriendMetaInfo friendMetaInfo);

    public static final native void FriendMetaInfo_ddwInfoSeq_set(long j, FriendMetaInfo friendMetaInfo, long j2);

    public static final native long FriendMetaInfo_ddwNextSeq_get(long j, FriendMetaInfo friendMetaInfo);

    public static final native void FriendMetaInfo_ddwNextSeq_set(long j, FriendMetaInfo friendMetaInfo, long j2);

    public static final native long FriendMetaInfo_ddwTimestamp_get(long j, FriendMetaInfo friendMetaInfo);

    public static final native void FriendMetaInfo_ddwTimestamp_set(long j, FriendMetaInfo friendMetaInfo, long j2);

    public static final native boolean FriendMetaInfo_recover_get(long j, FriendMetaInfo friendMetaInfo);

    public static final native void FriendMetaInfo_recover_set(long j, FriendMetaInfo friendMetaInfo, boolean z);

    public static final native void FriendPendencyItemVec_add(long j, FriendPendencyItemVec friendPendencyItemVec, long j2, FriendPendencyItem friendPendencyItem);

    public static final native long FriendPendencyItemVec_capacity(long j, FriendPendencyItemVec friendPendencyItemVec);

    public static final native void FriendPendencyItemVec_clear(long j, FriendPendencyItemVec friendPendencyItemVec);

    public static final native long FriendPendencyItemVec_get(long j, FriendPendencyItemVec friendPendencyItemVec, int i);

    public static final native boolean FriendPendencyItemVec_isEmpty(long j, FriendPendencyItemVec friendPendencyItemVec);

    public static final native void FriendPendencyItemVec_reserve(long j, FriendPendencyItemVec friendPendencyItemVec, long j2);

    public static final native void FriendPendencyItemVec_set(long j, FriendPendencyItemVec friendPendencyItemVec, int i, long j2, FriendPendencyItem friendPendencyItem);

    public static final native long FriendPendencyItemVec_size(long j, FriendPendencyItemVec friendPendencyItemVec);

    public static final native long FriendPendencyItem_ddwAddTime_get(long j, FriendPendencyItem friendPendencyItem);

    public static final native void FriendPendencyItem_ddwAddTime_set(long j, FriendPendencyItem friendPendencyItem, long j2);

    public static final native int FriendPendencyItem_iType_get(long j, FriendPendencyItem friendPendencyItem);

    public static final native void FriendPendencyItem_iType_set(long j, FriendPendencyItem friendPendencyItem, int i);

    public static final native byte[] FriendPendencyItem_sAddSource_get(long j, FriendPendencyItem friendPendencyItem);

    public static final native void FriendPendencyItem_sAddSource_set(long j, FriendPendencyItem friendPendencyItem, byte[] bArr);

    public static final native byte[] FriendPendencyItem_sAddWording_get(long j, FriendPendencyItem friendPendencyItem);

    public static final native void FriendPendencyItem_sAddWording_set(long j, FriendPendencyItem friendPendencyItem, byte[] bArr);

    public static final native String FriendPendencyItem_sIdentifier_get(long j, FriendPendencyItem friendPendencyItem);

    public static final native void FriendPendencyItem_sIdentifier_set(long j, FriendPendencyItem friendPendencyItem, String str);

    public static final native byte[] FriendPendencyItem_sNickname_get(long j, FriendPendencyItem friendPendencyItem);

    public static final native void FriendPendencyItem_sNickname_set(long j, FriendPendencyItem friendPendencyItem, byte[] bArr);

    public static final native long FriendPendencyMeta_ddwNumPerPage_get(long j, FriendPendencyMeta friendPendencyMeta);

    public static final native void FriendPendencyMeta_ddwNumPerPage_set(long j, FriendPendencyMeta friendPendencyMeta, long j2);

    public static final native long FriendPendencyMeta_ddwSeq_get(long j, FriendPendencyMeta friendPendencyMeta);

    public static final native void FriendPendencyMeta_ddwSeq_set(long j, FriendPendencyMeta friendPendencyMeta, long j2);

    public static final native long FriendPendencyMeta_ddwTimestamp_get(long j, FriendPendencyMeta friendPendencyMeta);

    public static final native void FriendPendencyMeta_ddwTimestamp_set(long j, FriendPendencyMeta friendPendencyMeta, long j2);

    public static final native long FriendPendencyMeta_ddwUnReadCnt_get(long j, FriendPendencyMeta friendPendencyMeta);

    public static final native void FriendPendencyMeta_ddwUnReadCnt_set(long j, FriendPendencyMeta friendPendencyMeta, long j2);

    public static final native long FriendPendencyResult_meta_get(long j, FriendPendencyResult friendPendencyResult);

    public static final native void FriendPendencyResult_meta_set(long j, FriendPendencyResult friendPendencyResult, long j2, FriendPendencyMeta friendPendencyMeta);

    public static final native long FriendPendencyResult_pendencies_get(long j, FriendPendencyResult friendPendencyResult);

    public static final native void FriendPendencyResult_pendencies_set(long j, FriendPendencyResult friendPendencyResult, long j2, FriendPendencyItemVec friendPendencyItemVec);

    public static final native long FriendshipManagerExt_SWIGUpcast(long j);

    public static final native boolean FriendshipManagerExt_addBlackList(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_addFriend(long j, FriendshipManagerExt friendshipManagerExt, long j2, FriendProfileVec friendProfileVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_addFriendToMap(long j, FriendshipManagerExt friendshipManagerExt, long j2, FriendProfile friendProfile);

    public static final native boolean FriendshipManagerExt_addFriends2Group(long j, FriendshipManagerExt friendshipManagerExt, byte[] bArr, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_checkFriend(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, String str, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native void FriendshipManagerExt_clearAllData(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native boolean FriendshipManagerExt_createFriendGroup(long j, FriendshipManagerExt friendshipManagerExt, long j2, BytesVec bytesVec, long j3, StrVec strVec, long j4, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_delBlackList(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_delFriend(long j, FriendshipManagerExt friendshipManagerExt, int i, long j2, FriendProfileVec friendProfileVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_delFriendFromMap(long j, FriendshipManagerExt friendshipManagerExt, long j2, FriendProfile friendProfile);

    public static final native boolean FriendshipManagerExt_delFriendsFromGroup(long j, FriendshipManagerExt friendshipManagerExt, byte[] bArr, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_deleteDecide(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_deleteFriendGroup(long j, FriendshipManagerExt friendshipManagerExt, long j2, BytesVec bytesVec, long j3, INotifyCallback iNotifyCallback);

    public static final native boolean FriendshipManagerExt_deletePendency(long j, FriendshipManagerExt friendshipManagerExt, int i, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_deleteRecommend(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_doResponse(long j, FriendshipManagerExt friendshipManagerExt, long j2, FriendProfileVec friendProfileVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native boolean FriendshipManagerExt_getBlackList(long j, FriendshipManagerExt friendshipManagerExt, long j2, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native long FriendshipManagerExt_getFriendGroupSeq(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native boolean FriendshipManagerExt_getFriendGroup__SWIG_0(long j, FriendshipManagerExt friendshipManagerExt, long j2, BytesVec bytesVec, boolean z, long j3, ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec);

    public static final native int FriendshipManagerExt_getFriendGroup__SWIG_1(long j, FriendshipManagerExt friendshipManagerExt, long j2, BytesVec bytesVec, long j3, FriendGroupVec friendGroupVec);

    public static final native boolean FriendshipManagerExt_getFriendListV2(long j, FriendshipManagerExt friendshipManagerExt, long j2, long j3, StrVec strVec, long j4, FriendMetaInfo friendMetaInfo, long j5);

    public static final native boolean FriendshipManagerExt_getFriendList__SWIG_0(long j, FriendshipManagerExt friendshipManagerExt, long j2, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native int FriendshipManagerExt_getFriendList__SWIG_1(long j, FriendshipManagerExt friendshipManagerExt, long j2, FriendProfileVec friendProfileVec);

    public static final native boolean FriendshipManagerExt_getFriendProfile__SWIG_0(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native int FriendshipManagerExt_getFriendProfile__SWIG_1(long j, FriendshipManagerExt friendshipManagerExt, long j2, StrVec strVec, long j3, FriendProfileVec friendProfileVec);

    public static final native boolean FriendshipManagerExt_getFutureFriends(long j, FriendshipManagerExt friendshipManagerExt, long j2, long j3, long j4, StrVec strVec, long j5, FutureFriendMeta futureFriendMeta, long j6, ICallbackWithFutureResult iCallbackWithFutureResult);

    public static final native long FriendshipManagerExt_getLocalFrdList(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native boolean FriendshipManagerExt_getPendencyFromServer(long j, FriendshipManagerExt friendshipManagerExt, long j2, FriendPendencyMeta friendPendencyMeta, int i, long j3, ICallbackWithPendencyResult iCallbackWithPendencyResult);

    public static final native boolean FriendshipManagerExt_modifyFriendGroupName(long j, FriendshipManagerExt friendshipManagerExt, byte[] bArr, byte[] bArr2, long j2, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native long FriendshipManagerExt_notifyCb(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native void FriendshipManagerExt_onMsgEvent(String str, long j, MsgVec msgVec);

    public static final native boolean FriendshipManagerExt_pendencyReport(long j, FriendshipManagerExt friendshipManagerExt, long j2, long j3, INotifyCallback iNotifyCallback);

    public static final native long FriendshipManagerExt_proxy(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native boolean FriendshipManagerExt_recommendReport(long j, FriendshipManagerExt friendshipManagerExt, long j2, long j3, INotifyCallback iNotifyCallback);

    public static final native boolean FriendshipManagerExt_searchFriendsUseNickName(long j, FriendshipManagerExt friendshipManagerExt, String str, long j2, long j3, long j4, ICallbackWithSearchResult iCallbackWithSearchResult);

    public static final native void FriendshipManagerExt_setExpire(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native boolean FriendshipManagerExt_setFrdListTimestamp(long j, FriendshipManagerExt friendshipManagerExt, long j2);

    public static final native boolean FriendshipManagerExt_setFrdSeq(long j, FriendshipManagerExt friendshipManagerExt, long j2);

    public static final native boolean FriendshipManagerExt_setSnsProfile(long j, FriendshipManagerExt friendshipManagerExt, long j2, SNSProfileItemVec sNSProfileItemVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native long FriendshipManagerExt_store(long j, FriendshipManagerExt friendshipManagerExt);

    public static final native boolean FriendshipManagerExt_updateFriendGroupSeq(long j, FriendshipManagerExt friendshipManagerExt, long j2);

    public static final native long FutureFriendMeta_ddwCurrentDecideTimestamp_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwCurrentDecideTimestamp_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwCurrentPendencyTimestamp_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwCurrentPendencyTimestamp_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwCurrentRecommendTimestamp_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwCurrentRecommendTimestamp_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwDecideSequence_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwDecideSequence_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwDecideUnreadCnt_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwDecideUnreadCnt_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwPendencySequence_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwPendencySequence_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwPendencyUnReadCnt_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwPendencyUnReadCnt_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwRecommendSequence_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwRecommendSequence_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwRecommendUnReadCnt_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwRecommendUnReadCnt_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwReqNum_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwReqNum_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native long FutureFriendMeta_ddwTimestamp_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_ddwTimestamp_set(long j, FutureFriendMeta futureFriendMeta, long j2);

    public static final native int FutureFriendMeta_iDirection_get(long j, FutureFriendMeta futureFriendMeta);

    public static final native void FutureFriendMeta_iDirection_set(long j, FutureFriendMeta futureFriendMeta, int i);

    public static final native void ICallbackWithFriendGroupVec_change_ownership(ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, long j, boolean z);

    public static final native void ICallbackWithFriendGroupVec_director_connect(ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithFriendGroupVec_done(long j, ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, long j2, FriendGroupVec friendGroupVec);

    public static final native void ICallbackWithFriendGroupVec_doneSwigExplicitICallbackWithFriendGroupVec(long j, ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, long j2, FriendGroupVec friendGroupVec);

    public static final native void ICallbackWithFriendGroupVec_fail(long j, ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, int i, String str);

    public static final native void ICallbackWithFriendGroupVec_failSwigExplicitICallbackWithFriendGroupVec(long j, ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, int i, String str);

    public static final native void ICallbackWithFutureResult_change_ownership(ICallbackWithFutureResult iCallbackWithFutureResult, long j, boolean z);

    public static final native void ICallbackWithFutureResult_director_connect(ICallbackWithFutureResult iCallbackWithFutureResult, long j, boolean z, boolean z2);

    public static final native void ICallbackWithFutureResult_done(long j, ICallbackWithFutureResult iCallbackWithFutureResult, long j2, FriendFutureResult friendFutureResult);

    public static final native void ICallbackWithFutureResult_doneSwigExplicitICallbackWithFutureResult(long j, ICallbackWithFutureResult iCallbackWithFutureResult, long j2, FriendFutureResult friendFutureResult);

    public static final native void ICallbackWithFutureResult_fail(long j, ICallbackWithFutureResult iCallbackWithFutureResult, int i, String str);

    public static final native void ICallbackWithFutureResult_failSwigExplicitICallbackWithFutureResult(long j, ICallbackWithFutureResult iCallbackWithFutureResult, int i, String str);

    public static final native void ICallbackWithPendencyResult_change_ownership(ICallbackWithPendencyResult iCallbackWithPendencyResult, long j, boolean z);

    public static final native void ICallbackWithPendencyResult_director_connect(ICallbackWithPendencyResult iCallbackWithPendencyResult, long j, boolean z, boolean z2);

    public static final native void ICallbackWithPendencyResult_done(long j, ICallbackWithPendencyResult iCallbackWithPendencyResult, long j2, FriendPendencyResult friendPendencyResult);

    public static final native void ICallbackWithPendencyResult_doneSwigExplicitICallbackWithPendencyResult(long j, ICallbackWithPendencyResult iCallbackWithPendencyResult, long j2, FriendPendencyResult friendPendencyResult);

    public static final native void ICallbackWithPendencyResult_fail(long j, ICallbackWithPendencyResult iCallbackWithPendencyResult, int i, String str);

    public static final native void ICallbackWithPendencyResult_failSwigExplicitICallbackWithPendencyResult(long j, ICallbackWithPendencyResult iCallbackWithPendencyResult, int i, String str);

    public static final native void ICallbackWithSearchResult_change_ownership(ICallbackWithSearchResult iCallbackWithSearchResult, long j, boolean z);

    public static final native void ICallbackWithSearchResult_director_connect(ICallbackWithSearchResult iCallbackWithSearchResult, long j, boolean z, boolean z2);

    public static final native void ICallbackWithSearchResult_done(long j, ICallbackWithSearchResult iCallbackWithSearchResult, long j2, SearchUserResult searchUserResult);

    public static final native void ICallbackWithSearchResult_doneSwigExplicitICallbackWithSearchResult(long j, ICallbackWithSearchResult iCallbackWithSearchResult, long j2, SearchUserResult searchUserResult);

    public static final native void ICallbackWithSearchResult_fail(long j, ICallbackWithSearchResult iCallbackWithSearchResult, int i, String str);

    public static final native void ICallbackWithSearchResult_failSwigExplicitICallbackWithSearchResult(long j, ICallbackWithSearchResult iCallbackWithSearchResult, int i, String str);

    public static final native void IFriendshipNotify_change_ownership(IFriendshipNotify iFriendshipNotify, long j, boolean z);

    public static final native void IFriendshipNotify_director_connect(IFriendshipNotify iFriendshipNotify, long j, boolean z, boolean z2);

    public static final native void IFriendshipNotify_onAddFriendNotify(long j, IFriendshipNotify iFriendshipNotify, long j2, FriendProfileVec friendProfileVec);

    public static final native void IFriendshipNotify_onAddFriendReq(long j, IFriendshipNotify iFriendshipNotify, long j2, AddFriendReqVec addFriendReqVec);

    public static final native void IFriendshipNotify_onDeleteFriendNotify(long j, IFriendshipNotify iFriendshipNotify, long j2, StrVec strVec);

    public static final native void IFriendshipNotify_onFriendProfileUpdate(long j, IFriendshipNotify iFriendshipNotify, long j2, FriendProfileVec friendProfileVec);

    public static final native void SNSProfileItemVec_add(long j, SNSProfileItemVec sNSProfileItemVec, long j2, SNSProfileItem sNSProfileItem);

    public static final native long SNSProfileItemVec_capacity(long j, SNSProfileItemVec sNSProfileItemVec);

    public static final native void SNSProfileItemVec_clear(long j, SNSProfileItemVec sNSProfileItemVec);

    public static final native long SNSProfileItemVec_get(long j, SNSProfileItemVec sNSProfileItemVec, int i);

    public static final native boolean SNSProfileItemVec_isEmpty(long j, SNSProfileItemVec sNSProfileItemVec);

    public static final native void SNSProfileItemVec_reserve(long j, SNSProfileItemVec sNSProfileItemVec, long j2);

    public static final native void SNSProfileItemVec_set(long j, SNSProfileItemVec sNSProfileItemVec, int i, long j2, SNSProfileItem sNSProfileItem);

    public static final native long SNSProfileItemVec_size(long j, SNSProfileItemVec sNSProfileItemVec);

    public static final native long SNSProfileItem_mpCustomUint_get(long j, SNSProfileItem sNSProfileItem);

    public static final native void SNSProfileItem_mpCustomUint_set(long j, SNSProfileItem sNSProfileItem, long j2, BytesCompatUintMap bytesCompatUintMap);

    public static final native long SNSProfileItem_mpCustom_get(long j, SNSProfileItem sNSProfileItem);

    public static final native void SNSProfileItem_mpCustom_set(long j, SNSProfileItem sNSProfileItem, long j2, BytesMap bytesMap);

    public static final native long SNSProfileItem_mpProfiles_get(long j, SNSProfileItem sNSProfileItem);

    public static final native void SNSProfileItem_mpProfiles_set(long j, SNSProfileItem sNSProfileItem, long j2, BytesMap bytesMap);

    public static final native String SNSProfileItem_sIdentifier_get(long j, SNSProfileItem sNSProfileItem);

    public static final native void SNSProfileItem_sIdentifier_set(long j, SNSProfileItem sNSProfileItem, String str);

    public static final native long SearchUserResult_friends_get(long j, SearchUserResult searchUserResult);

    public static final native void SearchUserResult_friends_set(long j, SearchUserResult searchUserResult, long j2, FriendProfileVec friendProfileVec);

    public static final native long SearchUserResult_totalNum_get(long j, SearchUserResult searchUserResult);

    public static final native void SearchUserResult_totalNum_set(long j, SearchUserResult searchUserResult, long j2);

    public static void SwigDirector_ICallbackWithFriendGroupVec_done(ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, long j) {
        iCallbackWithFriendGroupVec.done(new FriendGroupVec(j, false));
    }

    public static void SwigDirector_ICallbackWithFriendGroupVec_fail(ICallbackWithFriendGroupVec iCallbackWithFriendGroupVec, int i, String str) {
        iCallbackWithFriendGroupVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithFutureResult_done(ICallbackWithFutureResult iCallbackWithFutureResult, long j) {
        iCallbackWithFutureResult.done(new FriendFutureResult(j, false));
    }

    public static void SwigDirector_ICallbackWithFutureResult_fail(ICallbackWithFutureResult iCallbackWithFutureResult, int i, String str) {
        iCallbackWithFutureResult.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithPendencyResult_done(ICallbackWithPendencyResult iCallbackWithPendencyResult, long j) {
        iCallbackWithPendencyResult.done(new FriendPendencyResult(j, false));
    }

    public static void SwigDirector_ICallbackWithPendencyResult_fail(ICallbackWithPendencyResult iCallbackWithPendencyResult, int i, String str) {
        iCallbackWithPendencyResult.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithSearchResult_done(ICallbackWithSearchResult iCallbackWithSearchResult, long j) {
        iCallbackWithSearchResult.done(new SearchUserResult(j, false));
    }

    public static void SwigDirector_ICallbackWithSearchResult_fail(ICallbackWithSearchResult iCallbackWithSearchResult, int i, String str) {
        iCallbackWithSearchResult.fail(i, str);
    }

    public static void SwigDirector_IFriendshipNotify_onAddFriendNotify(IFriendshipNotify iFriendshipNotify, long j) {
        iFriendshipNotify.onAddFriendNotify(new FriendProfileVec(j, false));
    }

    public static void SwigDirector_IFriendshipNotify_onAddFriendReq(IFriendshipNotify iFriendshipNotify, long j) {
        iFriendshipNotify.onAddFriendReq(new AddFriendReqVec(j, false));
    }

    public static void SwigDirector_IFriendshipNotify_onDeleteFriendNotify(IFriendshipNotify iFriendshipNotify, long j) {
        iFriendshipNotify.onDeleteFriendNotify(new StrVec(j, false));
    }

    public static void SwigDirector_IFriendshipNotify_onFriendProfileUpdate(IFriendshipNotify iFriendshipNotify, long j) {
        iFriendshipNotify.onFriendProfileUpdate(new FriendProfileVec(j, false));
    }

    public static final native void delete_AddFriendReq(long j);

    public static final native void delete_AddFriendReqVec(long j);

    public static final native void delete_FriendExtHelper(long j);

    public static final native void delete_FriendFutureItem(long j);

    public static final native void delete_FriendFutureItemVec(long j);

    public static final native void delete_FriendFutureResult(long j);

    public static final native void delete_FriendGroup(long j);

    public static final native void delete_FriendGroupItem(long j);

    public static final native void delete_FriendGroupVec(long j);

    public static final native void delete_FriendListMetaResult(long j);

    public static final native void delete_FriendMetaInfo(long j);

    public static final native void delete_FriendPendencyItem(long j);

    public static final native void delete_FriendPendencyItemVec(long j);

    public static final native void delete_FriendPendencyMeta(long j);

    public static final native void delete_FriendPendencyResult(long j);

    public static final native void delete_FriendshipManagerExt(long j);

    public static final native void delete_FutureFriendMeta(long j);

    public static final native void delete_ICallbackWithFriendGroupVec(long j);

    public static final native void delete_ICallbackWithFutureResult(long j);

    public static final native void delete_ICallbackWithPendencyResult(long j);

    public static final native void delete_ICallbackWithSearchResult(long j);

    public static final native void delete_IFriendshipNotify(long j);

    public static final native void delete_SNSProfileItem(long j);

    public static final native void delete_SNSProfileItemVec(long j);

    public static final native void delete_SearchUserResult(long j);

    public static final native long new_AddFriendReq();

    public static final native long new_AddFriendReqVec__SWIG_0();

    public static final native long new_AddFriendReqVec__SWIG_1(long j);

    public static final native long new_FriendExtHelper();

    public static final native long new_FriendFutureItem();

    public static final native long new_FriendFutureItemVec__SWIG_0();

    public static final native long new_FriendFutureItemVec__SWIG_1(long j);

    public static final native long new_FriendFutureResult();

    public static final native long new_FriendGroup();

    public static final native long new_FriendGroupItem();

    public static final native long new_FriendGroupVec__SWIG_0();

    public static final native long new_FriendGroupVec__SWIG_1(long j);

    public static final native long new_FriendListMetaResult();

    public static final native long new_FriendMetaInfo();

    public static final native long new_FriendPendencyItem();

    public static final native long new_FriendPendencyItemVec__SWIG_0();

    public static final native long new_FriendPendencyItemVec__SWIG_1(long j);

    public static final native long new_FriendPendencyMeta();

    public static final native long new_FriendPendencyResult();

    public static final native long new_FriendshipManagerExt(String str, long j, IFriendshipNotify iFriendshipNotify);

    public static final native long new_FutureFriendMeta();

    public static final native long new_ICallbackWithFriendGroupVec();

    public static final native long new_ICallbackWithFutureResult();

    public static final native long new_ICallbackWithPendencyResult();

    public static final native long new_ICallbackWithSearchResult();

    public static final native long new_IFriendshipNotify();

    public static final native long new_SNSProfileItem();

    public static final native long new_SNSProfileItemVec__SWIG_0();

    public static final native long new_SNSProfileItemVec__SWIG_1(long j);

    public static final native long new_SearchUserResult();

    private static final native void swig_module_init();
}
