package com.tencent.imcore;

public class internalGroupExtJNI {
    static {
        swig_module_init();
    }

    public static final native long GetGroupBaseInfoOption_custom_info_get(long j, GetGroupBaseInfoOption getGroupBaseInfoOption);

    public static final native void GetGroupBaseInfoOption_custom_info_set(long j, GetGroupBaseInfoOption getGroupBaseInfoOption, long j2, BytesMap bytesMap);

    public static final native long GetGroupBaseInfoOption_flag_get(long j, GetGroupBaseInfoOption getGroupBaseInfoOption);

    public static final native void GetGroupBaseInfoOption_flag_set(long j, GetGroupBaseInfoOption getGroupBaseInfoOption, long j2);

    public static final native long GetGroupBaseInfoOption_groups_get(long j, GetGroupBaseInfoOption getGroupBaseInfoOption);

    public static final native void GetGroupBaseInfoOption_groups_set(long j, GetGroupBaseInfoOption getGroupBaseInfoOption, long j2, StrVec strVec);

    public static final native long GetGroupMemInfoOption_custom_info_get(long j, GetGroupMemInfoOption getGroupMemInfoOption);

    public static final native void GetGroupMemInfoOption_custom_info_set(long j, GetGroupMemInfoOption getGroupMemInfoOption, long j2, BytesMap bytesMap);

    public static final native int GetGroupMemInfoOption_filter_get(long j, GetGroupMemInfoOption getGroupMemInfoOption);

    public static final native void GetGroupMemInfoOption_filter_set(long j, GetGroupMemInfoOption getGroupMemInfoOption, int i);

    public static final native long GetGroupMemInfoOption_flag_get(long j, GetGroupMemInfoOption getGroupMemInfoOption);

    public static final native void GetGroupMemInfoOption_flag_set(long j, GetGroupMemInfoOption getGroupMemInfoOption, long j2);

    public static final native String GetGroupMemInfoOption_group_id_get(long j, GetGroupMemInfoOption getGroupMemInfoOption);

    public static final native void GetGroupMemInfoOption_group_id_set(long j, GetGroupMemInfoOption getGroupMemInfoOption, String str);

    public static final native long GetGroupMemInfoOption_members_get(long j, GetGroupMemInfoOption getGroupMemInfoOption);

    public static final native void GetGroupMemInfoOption_members_set(long j, GetGroupMemInfoOption getGroupMemInfoOption, long j2, StrVec strVec);

    public static final native long GetGroupPendencyOption_max_limited_get(long j, GetGroupPendencyOption getGroupPendencyOption);

    public static final native void GetGroupPendencyOption_max_limited_set(long j, GetGroupPendencyOption getGroupPendencyOption, long j2);

    public static final native long GetGroupPendencyOption_start_time_get(long j, GetGroupPendencyOption getGroupPendencyOption);

    public static final native void GetGroupPendencyOption_start_time_set(long j, GetGroupPendencyOption getGroupPendencyOption, long j2);

    public static final native void GroupBaseInfoVec_add(long j, GroupBaseInfoVec groupBaseInfoVec, long j2, GroupBaseInfo groupBaseInfo);

    public static final native long GroupBaseInfoVec_capacity(long j, GroupBaseInfoVec groupBaseInfoVec);

    public static final native void GroupBaseInfoVec_clear(long j, GroupBaseInfoVec groupBaseInfoVec);

    public static final native long GroupBaseInfoVec_get(long j, GroupBaseInfoVec groupBaseInfoVec, int i);

    public static final native boolean GroupBaseInfoVec_isEmpty(long j, GroupBaseInfoVec groupBaseInfoVec);

    public static final native void GroupBaseInfoVec_reserve(long j, GroupBaseInfoVec groupBaseInfoVec, long j2);

    public static final native void GroupBaseInfoVec_set(long j, GroupBaseInfoVec groupBaseInfoVec, int i, long j2, GroupBaseInfo groupBaseInfo);

    public static final native long GroupBaseInfoVec_size(long j, GroupBaseInfoVec groupBaseInfoVec);

    public static final native boolean GroupBaseInfo_bAllShutup_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_bAllShutup_set(long j, GroupBaseInfo groupBaseInfo, boolean z);

    public static final native long GroupBaseInfo_dwInfoSeq_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_dwInfoSeq_set(long j, GroupBaseInfo groupBaseInfo, long j2);

    public static final native long GroupBaseInfo_dwMsgFalg_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_dwMsgFalg_set(long j, GroupBaseInfo groupBaseInfo, long j2);

    public static final native long GroupBaseInfo_dwMsgSeq_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_dwMsgSeq_set(long j, GroupBaseInfo groupBaseInfo, long j2);

    public static final native long GroupBaseInfo_dwReadSeq_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_dwReadSeq_set(long j, GroupBaseInfo groupBaseInfo, long j2);

    public static final native byte[] GroupBaseInfo_sFaceUrl_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_sFaceUrl_set(long j, GroupBaseInfo groupBaseInfo, byte[] bArr);

    public static final native String GroupBaseInfo_sGroupId_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_sGroupId_set(long j, GroupBaseInfo groupBaseInfo, String str);

    public static final native byte[] GroupBaseInfo_sGroupName_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_sGroupName_set(long j, GroupBaseInfo groupBaseInfo, byte[] bArr);

    public static final native String GroupBaseInfo_sGroupType_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_sGroupType_set(long j, GroupBaseInfo groupBaseInfo, String str);

    public static final native long GroupBaseInfo_stSelfInfo_get(long j, GroupBaseInfo groupBaseInfo);

    public static final native void GroupBaseInfo_stSelfInfo_set(long j, GroupBaseInfo groupBaseInfo, long j2, GroupSelfInfo groupSelfInfo);

    public static final native void GroupCacheInfoVec_add(long j, GroupCacheInfoVec groupCacheInfoVec, long j2, GroupCacheInfo groupCacheInfo);

    public static final native long GroupCacheInfoVec_capacity(long j, GroupCacheInfoVec groupCacheInfoVec);

    public static final native void GroupCacheInfoVec_clear(long j, GroupCacheInfoVec groupCacheInfoVec);

    public static final native long GroupCacheInfoVec_get(long j, GroupCacheInfoVec groupCacheInfoVec, int i);

    public static final native boolean GroupCacheInfoVec_isEmpty(long j, GroupCacheInfoVec groupCacheInfoVec);

    public static final native void GroupCacheInfoVec_reserve(long j, GroupCacheInfoVec groupCacheInfoVec, long j2);

    public static final native void GroupCacheInfoVec_set(long j, GroupCacheInfoVec groupCacheInfoVec, int i, long j2, GroupCacheInfo groupCacheInfo);

    public static final native long GroupCacheInfoVec_size(long j, GroupCacheInfoVec groupCacheInfoVec);

    public static final native long GroupCacheInfo_groupInfo_get(long j, GroupCacheInfo groupCacheInfo);

    public static final native void GroupCacheInfo_groupInfo_set(long j, GroupCacheInfo groupCacheInfo, long j2, GroupDetailInfo groupDetailInfo);

    public static final native long GroupCacheInfo_selfInfo_get(long j, GroupCacheInfo groupCacheInfo);

    public static final native void GroupCacheInfo_selfInfo_set(long j, GroupCacheInfo groupCacheInfo, long j2, GroupSelfInfo groupSelfInfo);

    public static final native void GroupDetailInfoVec_add(long j, GroupDetailInfoVec groupDetailInfoVec, long j2, GroupDetailInfo groupDetailInfo);

    public static final native long GroupDetailInfoVec_capacity(long j, GroupDetailInfoVec groupDetailInfoVec);

    public static final native void GroupDetailInfoVec_clear(long j, GroupDetailInfoVec groupDetailInfoVec);

    public static final native long GroupDetailInfoVec_get(long j, GroupDetailInfoVec groupDetailInfoVec, int i);

    public static final native boolean GroupDetailInfoVec_isEmpty(long j, GroupDetailInfoVec groupDetailInfoVec);

    public static final native void GroupDetailInfoVec_reserve(long j, GroupDetailInfoVec groupDetailInfoVec, long j2);

    public static final native void GroupDetailInfoVec_set(long j, GroupDetailInfoVec groupDetailInfoVec, int i, long j2, GroupDetailInfo groupDetailInfo);

    public static final native long GroupDetailInfoVec_size(long j, GroupDetailInfoVec groupDetailInfoVec);

    public static final native boolean GroupDetailInfo_bAllShutup_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_bAllShutup_set(long j, GroupDetailInfo groupDetailInfo, boolean z);

    public static final native long GroupDetailInfo_custom_info_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_custom_info_set(long j, GroupDetailInfo groupDetailInfo, long j2, BytesMap bytesMap);

    public static final native long GroupDetailInfo_ddwOwnerTinyId_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_ddwOwnerTinyId_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwAddOption_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwAddOption_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwAppid_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwAppid_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwCreateTime_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwCreateTime_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwInfoSeq_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwInfoSeq_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwLastInfoTime_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwLastInfoTime_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwLastMsgTime_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwLastMsgTime_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwMaxMemberNum_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwMaxMemberNum_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwMemberNum_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwMemberNum_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwNextMsgSeq_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwNextMsgSeq_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native long GroupDetailInfo_dwOnlineMemberNum_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_dwOnlineMemberNum_set(long j, GroupDetailInfo groupDetailInfo, long j2);

    public static final native int GroupDetailInfo_eSearchable_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_eSearchable_set(long j, GroupDetailInfo groupDetailInfo, int i);

    public static final native int GroupDetailInfo_eVisible_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_eVisible_set(long j, GroupDetailInfo groupDetailInfo, int i);

    public static final native long GroupDetailInfo_lastMsg_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_lastMsg_set(long j, GroupDetailInfo groupDetailInfo, long j2, Msg msg);

    public static final native String GroupDetailInfo_sFaceUrl_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sFaceUrl_set(long j, GroupDetailInfo groupDetailInfo, String str);

    public static final native String GroupDetailInfo_sGroupId_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sGroupId_set(long j, GroupDetailInfo groupDetailInfo, String str);

    public static final native byte[] GroupDetailInfo_sGroupName_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sGroupName_set(long j, GroupDetailInfo groupDetailInfo, byte[] bArr);

    public static final native String GroupDetailInfo_sGroupType_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sGroupType_set(long j, GroupDetailInfo groupDetailInfo, String str);

    public static final native byte[] GroupDetailInfo_sIntroduction_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sIntroduction_set(long j, GroupDetailInfo groupDetailInfo, byte[] bArr);

    public static final native byte[] GroupDetailInfo_sNotification_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sNotification_set(long j, GroupDetailInfo groupDetailInfo, byte[] bArr);

    public static final native String GroupDetailInfo_sOwner_get(long j, GroupDetailInfo groupDetailInfo);

    public static final native void GroupDetailInfo_sOwner_set(long j, GroupDetailInfo groupDetailInfo, String str);

    public static final native long GroupExtHelper_getGroupManagerExt__SWIG_0(String str, long j, IGroupNotify iGroupNotify);

    public static final native long GroupExtHelper_getGroupManagerExt__SWIG_1(String str);

    public static final native long GroupManagerExt_SWIGUpcast(long j);

    public static final native long GroupManagerExt_assistant(long j, GroupManagerExt groupManagerExt);

    public static final native boolean GroupManagerExt_checkGroupModifyOption(long j, GroupManagerExt groupManagerExt, long j2, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native boolean GroupManagerExt_checkMemberModifyOption(long j, GroupManagerExt groupManagerExt, long j2, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native boolean GroupManagerExt_createGroup(long j, GroupManagerExt groupManagerExt, String str, long j2, StrVec strVec, byte[] bArr, long j3, ICallbackWithString iCallbackWithString);

    public static final native boolean GroupManagerExt_deleteGroupMember(long j, GroupManagerExt groupManagerExt, String str, long j2, StrVec strVec, long j3, ICallbackWithMemberResultVec iCallbackWithMemberResultVec, byte[] bArr);

    public static final native boolean GroupManagerExt_getGroupBaseInfo(long j, GroupManagerExt groupManagerExt, long j2, StrVec strVec, long j3, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec);

    public static final native boolean GroupManagerExt_getGroupList(long j, GroupManagerExt groupManagerExt, boolean z, long j2, ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec);

    public static final native boolean GroupManagerExt_getGroupMembers(long j, GroupManagerExt groupManagerExt, String str, long j2, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec);

    public static final native boolean GroupManagerExt_getGroupMembersByFilter(long j, GroupManagerExt groupManagerExt, String str, long j2, int i, long j3, BytesVec bytesVec, long j4, long j5, ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo);

    public static final native boolean GroupManagerExt_getGroupMembersInfo(long j, GroupManagerExt groupManagerExt, String str, long j2, StrVec strVec, long j3, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec);

    public static final native boolean GroupManagerExt_getGroupPublicInfo(long j, GroupManagerExt groupManagerExt, long j2, StrVec strVec, long j3, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec);

    public static final native int GroupManagerExt_getGroups(long j, GroupManagerExt groupManagerExt, long j2, StrVec strVec, long j3, GroupCacheInfoVec groupCacheInfoVec);

    public static final native boolean GroupManagerExt_getPendency(long j, GroupManagerExt groupManagerExt, long j2, GetGroupPendencyOption getGroupPendencyOption, long j3, ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult);

    public static final native boolean GroupManagerExt_getSelfInfo(long j, GroupManagerExt groupManagerExt, String str, long j2, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec);

    public static final native boolean GroupManagerExt_handleInviteRequest(long j, GroupManagerExt groupManagerExt, String str, String str2, byte[] bArr, byte[] bArr2, long j2, long j3, byte[] bArr3, long j4, INotifyCallback iNotifyCallback);

    public static final native boolean GroupManagerExt_handleJoinRequest(long j, GroupManagerExt groupManagerExt, String str, String str2, byte[] bArr, byte[] bArr2, long j2, long j3, byte[] bArr3, long j4, INotifyCallback iNotifyCallback);

    public static final native boolean GroupManagerExt_inviteGroupMember(long j, GroupManagerExt groupManagerExt, String str, long j2, StrVec strVec, long j3, ICallbackWithMemberResultVec iCallbackWithMemberResultVec);

    public static final native boolean GroupManagerExt_modifyGroupBaseInfo(long j, GroupManagerExt groupManagerExt, long j2, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, long j3, INotifyCallback iNotifyCallback);

    public static final native boolean GroupManagerExt_modifyGroupMemberInfo(long j, GroupManagerExt groupManagerExt, long j2, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, long j3, INotifyCallback iNotifyCallback);

    public static final native boolean GroupManagerExt_modifyGroupOwner(long j, GroupManagerExt groupManagerExt, String str, String str2, long j2, INotifyCallback iNotifyCallback);

    public static final native void GroupManagerExt_onMsgEventExt(String str, long j, MsgVec msgVec);

    public static final native boolean GroupManagerExt_pendencyReport(long j, GroupManagerExt groupManagerExt, long j2, long j3, INotifyCallback iNotifyCallback);

    public static final native long GroupManagerExt_prepareDefaultGetGroupOption(long j, GroupManagerExt groupManagerExt, long j2, StrVec strVec);

    public static final native long GroupManagerExt_prepareDefaultGetMemOption(long j, GroupManagerExt groupManagerExt, String str, long j2, StrVec strVec);

    public static final native boolean GroupManagerExt_searchGroupByName(long j, GroupManagerExt groupManagerExt, String str, long j2, long j3, BytesVec bytesVec, long j4, long j5, long j6, ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail);

    public static final native void GroupPendencyItemVec_add(long j, GroupPendencyItemVec groupPendencyItemVec, long j2, GroupPendencyItem groupPendencyItem);

    public static final native long GroupPendencyItemVec_capacity(long j, GroupPendencyItemVec groupPendencyItemVec);

    public static final native void GroupPendencyItemVec_clear(long j, GroupPendencyItemVec groupPendencyItemVec);

    public static final native long GroupPendencyItemVec_get(long j, GroupPendencyItemVec groupPendencyItemVec, int i);

    public static final native boolean GroupPendencyItemVec_isEmpty(long j, GroupPendencyItemVec groupPendencyItemVec);

    public static final native void GroupPendencyItemVec_reserve(long j, GroupPendencyItemVec groupPendencyItemVec, long j2);

    public static final native void GroupPendencyItemVec_set(long j, GroupPendencyItemVec groupPendencyItemVec, int i, long j2, GroupPendencyItem groupPendencyItem);

    public static final native long GroupPendencyItemVec_size(long j, GroupPendencyItemVec groupPendencyItemVec);

    public static final native long GroupPendencyItem_add_time_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_add_time_set(long j, GroupPendencyItem groupPendencyItem, long j2);

    public static final native byte[] GroupPendencyItem_apply_invite_msg_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_apply_invite_msg_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native byte[] GroupPendencyItem_approval_msg_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_approval_msg_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native byte[] GroupPendencyItem_authentication_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_authentication_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native String GroupPendencyItem_from_id_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_from_id_set(long j, GroupPendencyItem groupPendencyItem, String str);

    public static final native byte[] GroupPendencyItem_from_user_defined_data_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_from_user_defined_data_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native String GroupPendencyItem_group_id_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_group_id_set(long j, GroupPendencyItem groupPendencyItem, String str);

    public static final native long GroupPendencyItem_handle_result_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_handle_result_set(long j, GroupPendencyItem groupPendencyItem, long j2);

    public static final native long GroupPendencyItem_handled_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_handled_set(long j, GroupPendencyItem groupPendencyItem, long j2);

    public static final native byte[] GroupPendencyItem_key_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_key_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native long GroupPendencyItem_pendency_type_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_pendency_type_set(long j, GroupPendencyItem groupPendencyItem, long j2);

    public static final native byte[] GroupPendencyItem_selfIdentifier_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_selfIdentifier_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native String GroupPendencyItem_to_id_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_to_id_set(long j, GroupPendencyItem groupPendencyItem, String str);

    public static final native byte[] GroupPendencyItem_to_user_defined_data_get(long j, GroupPendencyItem groupPendencyItem);

    public static final native void GroupPendencyItem_to_user_defined_data_set(long j, GroupPendencyItem groupPendencyItem, byte[] bArr);

    public static final native long GroupPendencyMeta_next_start_time_get(long j, GroupPendencyMeta groupPendencyMeta);

    public static final native void GroupPendencyMeta_next_start_time_set(long j, GroupPendencyMeta groupPendencyMeta, long j2);

    public static final native long GroupPendencyMeta_read_time_seq_get(long j, GroupPendencyMeta groupPendencyMeta);

    public static final native void GroupPendencyMeta_read_time_seq_set(long j, GroupPendencyMeta groupPendencyMeta, long j2);

    public static final native long GroupPendencyMeta_unread_num_get(long j, GroupPendencyMeta groupPendencyMeta);

    public static final native void GroupPendencyMeta_unread_num_set(long j, GroupPendencyMeta groupPendencyMeta, long j2);

    public static final native long GroupPendencyResult_items_get(long j, GroupPendencyResult groupPendencyResult);

    public static final native void GroupPendencyResult_items_set(long j, GroupPendencyResult groupPendencyResult, long j2, GroupPendencyItemVec groupPendencyItemVec);

    public static final native long GroupPendencyResult_meta_get(long j, GroupPendencyResult groupPendencyResult);

    public static final native void GroupPendencyResult_meta_set(long j, GroupPendencyResult groupPendencyResult, long j2, GroupPendencyMeta groupPendencyMeta);

    public static final native long GroupSelfInfo_dwMsgFalg_get(long j, GroupSelfInfo groupSelfInfo);

    public static final native void GroupSelfInfo_dwMsgFalg_set(long j, GroupSelfInfo groupSelfInfo, long j2);

    public static final native long GroupSelfInfo_joinTime_get(long j, GroupSelfInfo groupSelfInfo);

    public static final native void GroupSelfInfo_joinTime_set(long j, GroupSelfInfo groupSelfInfo, long j2);

    public static final native long GroupSelfInfo_role_get(long j, GroupSelfInfo groupSelfInfo);

    public static final native void GroupSelfInfo_role_set(long j, GroupSelfInfo groupSelfInfo, long j2);

    public static final native long GroupSelfInfo_unreadNum_get(long j, GroupSelfInfo groupSelfInfo);

    public static final native void GroupSelfInfo_unreadNum_set(long j, GroupSelfInfo groupSelfInfo, long j2);

    public static final native void ICallbackWithGroupBaseInfoVec_change_ownership(ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, long j, boolean z);

    public static final native void ICallbackWithGroupBaseInfoVec_director_connect(ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithGroupBaseInfoVec_done(long j, ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, long j2, GroupBaseInfoVec groupBaseInfoVec);

    public static final native void ICallbackWithGroupBaseInfoVec_doneSwigExplicitICallbackWithGroupBaseInfoVec(long j, ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, long j2, GroupBaseInfoVec groupBaseInfoVec);

    public static final native void ICallbackWithGroupBaseInfoVec_fail(long j, ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, int i, String str);

    public static final native void ICallbackWithGroupBaseInfoVec_failSwigExplicitICallbackWithGroupBaseInfoVec(long j, ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, int i, String str);

    public static final native void ICallbackWithGroupDetailInfoVec_change_ownership(ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, long j, boolean z);

    public static final native void ICallbackWithGroupDetailInfoVec_director_connect(ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithGroupDetailInfoVec_done(long j, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, long j2, GroupDetailInfoVec groupDetailInfoVec);

    public static final native void ICallbackWithGroupDetailInfoVec_doneSwigExplicitICallbackWithGroupDetailInfoVec(long j, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, long j2, GroupDetailInfoVec groupDetailInfoVec);

    public static final native void ICallbackWithGroupDetailInfoVec_fail(long j, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, int i, String str);

    public static final native void ICallbackWithGroupDetailInfoVec_failSwigExplicitICallbackWithGroupDetailInfoVec(long j, ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, int i, String str);

    public static final native void ICallbackWithGroupPendencyResult_change_ownership(ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, long j, boolean z);

    public static final native void ICallbackWithGroupPendencyResult_director_connect(ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, long j, boolean z, boolean z2);

    public static final native void ICallbackWithGroupPendencyResult_done(long j, ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, long j2, GroupPendencyResult groupPendencyResult);

    public static final native void ICallbackWithGroupPendencyResult_doneSwigExplicitICallbackWithGroupPendencyResult(long j, ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, long j2, GroupPendencyResult groupPendencyResult);

    public static final native void ICallbackWithGroupPendencyResult_fail(long j, ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, int i, String str);

    public static final native void ICallbackWithGroupPendencyResult_failSwigExplicitICallbackWithGroupPendencyResult(long j, ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, int i, String str);

    public static final native void ICallbackWithMemberInfoVec_change_ownership(ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, long j, boolean z);

    public static final native void ICallbackWithMemberInfoVec_director_connect(ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithMemberInfoVec_done(long j, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, long j2, MemberInfoVec memberInfoVec);

    public static final native void ICallbackWithMemberInfoVec_doneSwigExplicitICallbackWithMemberInfoVec(long j, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, long j2, MemberInfoVec memberInfoVec);

    public static final native void ICallbackWithMemberInfoVec_fail(long j, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, int i, String str);

    public static final native void ICallbackWithMemberInfoVec_failSwigExplicitICallbackWithMemberInfoVec(long j, ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, int i, String str);

    public static final native void ICallbackWithMemberResultVec_change_ownership(ICallbackWithMemberResultVec iCallbackWithMemberResultVec, long j, boolean z);

    public static final native void ICallbackWithMemberResultVec_director_connect(ICallbackWithMemberResultVec iCallbackWithMemberResultVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithMemberResultVec_done(long j, ICallbackWithMemberResultVec iCallbackWithMemberResultVec, long j2, MemberResultVec memberResultVec);

    public static final native void ICallbackWithMemberResultVec_doneSwigExplicitICallbackWithMemberResultVec(long j, ICallbackWithMemberResultVec iCallbackWithMemberResultVec, long j2, MemberResultVec memberResultVec);

    public static final native void ICallbackWithMemberResultVec_fail(long j, ICallbackWithMemberResultVec iCallbackWithMemberResultVec, int i, String str);

    public static final native void ICallbackWithMemberResultVec_failSwigExplicitICallbackWithMemberResultVec(long j, ICallbackWithMemberResultVec iCallbackWithMemberResultVec, int i, String str);

    public static final native void ICallbackWithNumberGroupsDetail_change_ownership(ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, long j, boolean z);

    public static final native void ICallbackWithNumberGroupsDetail_director_connect(ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, long j, boolean z, boolean z2);

    public static final native void ICallbackWithNumberGroupsDetail_done(long j, ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, long j2, NumberGroupsDetail numberGroupsDetail);

    public static final native void ICallbackWithNumberGroupsDetail_doneSwigExplicitICallbackWithNumberGroupsDetail(long j, ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, long j2, NumberGroupsDetail numberGroupsDetail);

    public static final native void ICallbackWithNumberGroupsDetail_fail(long j, ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, int i, String str);

    public static final native void ICallbackWithNumberGroupsDetail_failSwigExplicitICallbackWithNumberGroupsDetail(long j, ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, int i, String str);

    public static final native void ICallbackWithSeqMemberInfo_change_ownership(ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, long j, boolean z);

    public static final native void ICallbackWithSeqMemberInfo_director_connect(ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, long j, boolean z, boolean z2);

    public static final native void ICallbackWithSeqMemberInfo_done(long j, ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, long j2, SeqMemberInfo seqMemberInfo);

    public static final native void ICallbackWithSeqMemberInfo_doneSwigExplicitICallbackWithSeqMemberInfo(long j, ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, long j2, SeqMemberInfo seqMemberInfo);

    public static final native void ICallbackWithSeqMemberInfo_fail(long j, ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, int i, String str);

    public static final native void ICallbackWithSeqMemberInfo_failSwigExplicitICallbackWithSeqMemberInfo(long j, ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, int i, String str);

    public static final native void IGroupNotify_change_ownership(IGroupNotify iGroupNotify, long j, boolean z);

    public static final native void IGroupNotify_director_connect(IGroupNotify iGroupNotify, long j, boolean z, boolean z2);

    public static final native void IGroupNotify_onGroupAdd(long j, IGroupNotify iGroupNotify, long j2, GroupCacheInfo groupCacheInfo);

    public static final native void IGroupNotify_onGroupAddSwigExplicitIGroupNotify(long j, IGroupNotify iGroupNotify, long j2, GroupCacheInfo groupCacheInfo);

    public static final native void IGroupNotify_onGroupDelete(long j, IGroupNotify iGroupNotify, String str);

    public static final native void IGroupNotify_onGroupDeleteSwigExplicitIGroupNotify(long j, IGroupNotify iGroupNotify, String str);

    public static final native void IGroupNotify_onGroupUpdate(long j, IGroupNotify iGroupNotify, long j2, GroupCacheInfo groupCacheInfo);

    public static final native void IGroupNotify_onGroupUpdateSwigExplicitIGroupNotify(long j, IGroupNotify iGroupNotify, long j2, GroupCacheInfo groupCacheInfo);

    public static final native void IGroupNotify_onMemberJoin(long j, IGroupNotify iGroupNotify, String str, long j2, MemberInfoVec memberInfoVec);

    public static final native void IGroupNotify_onMemberJoinSwigExplicitIGroupNotify(long j, IGroupNotify iGroupNotify, String str, long j2, MemberInfoVec memberInfoVec);

    public static final native void IGroupNotify_onMemberQuit(long j, IGroupNotify iGroupNotify, String str, long j2, StrVec strVec);

    public static final native void IGroupNotify_onMemberQuitSwigExplicitIGroupNotify(long j, IGroupNotify iGroupNotify, String str, long j2, StrVec strVec);

    public static final native void IGroupNotify_onMemberUpdate(long j, IGroupNotify iGroupNotify, String str, long j2, MemberInfoVec memberInfoVec);

    public static final native void IGroupNotify_onMemberUpdateSwigExplicitIGroupNotify(long j, IGroupNotify iGroupNotify, String str, long j2, MemberInfoVec memberInfoVec);

    public static final native void MemberInfoVec_add(long j, MemberInfoVec memberInfoVec, long j2, MemberInfo memberInfo);

    public static final native long MemberInfoVec_capacity(long j, MemberInfoVec memberInfoVec);

    public static final native void MemberInfoVec_clear(long j, MemberInfoVec memberInfoVec);

    public static final native long MemberInfoVec_get(long j, MemberInfoVec memberInfoVec, int i);

    public static final native boolean MemberInfoVec_isEmpty(long j, MemberInfoVec memberInfoVec);

    public static final native void MemberInfoVec_reserve(long j, MemberInfoVec memberInfoVec, long j2);

    public static final native void MemberInfoVec_set(long j, MemberInfoVec memberInfoVec, int i, long j2, MemberInfo memberInfo);

    public static final native long MemberInfoVec_size(long j, MemberInfoVec memberInfoVec);

    public static final native long MemberInfo_custom_info_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_custom_info_set(long j, MemberInfo memberInfo, long j2, BytesMap bytesMap);

    public static final native long MemberInfo_join_time_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_join_time_set(long j, MemberInfo memberInfo, long j2);

    public static final native String MemberInfo_member_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_member_set(long j, MemberInfo memberInfo, String str);

    public static final native long MemberInfo_msg_flag_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_msg_flag_set(long j, MemberInfo memberInfo, long j2);

    public static final native long MemberInfo_msg_seq_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_msg_seq_set(long j, MemberInfo memberInfo, long j2);

    public static final native byte[] MemberInfo_name_card_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_name_card_set(long j, MemberInfo memberInfo, byte[] bArr);

    public static final native long MemberInfo_role_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_role_set(long j, MemberInfo memberInfo, long j2);

    public static final native long MemberInfo_shutup_time_get(long j, MemberInfo memberInfo);

    public static final native void MemberInfo_shutup_time_set(long j, MemberInfo memberInfo, long j2);

    public static final native void MemberResultVec_add(long j, MemberResultVec memberResultVec, long j2, MemberResult memberResult);

    public static final native long MemberResultVec_capacity(long j, MemberResultVec memberResultVec);

    public static final native void MemberResultVec_clear(long j, MemberResultVec memberResultVec);

    public static final native long MemberResultVec_get(long j, MemberResultVec memberResultVec, int i);

    public static final native boolean MemberResultVec_isEmpty(long j, MemberResultVec memberResultVec);

    public static final native void MemberResultVec_reserve(long j, MemberResultVec memberResultVec, long j2);

    public static final native void MemberResultVec_set(long j, MemberResultVec memberResultVec, int i, long j2, MemberResult memberResult);

    public static final native long MemberResultVec_size(long j, MemberResultVec memberResultVec);

    public static final native long MemberResult_status_get(long j, MemberResult memberResult);

    public static final native void MemberResult_status_set(long j, MemberResult memberResult, long j2);

    public static final native String MemberResult_user_get(long j, MemberResult memberResult);

    public static final native void MemberResult_user_set(long j, MemberResult memberResult, String str);

    public static final native long ModifyGroupBaseInfoOption_add_option_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_add_option_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, long j2);

    public static final native boolean ModifyGroupBaseInfoOption_all_shutup_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_all_shutup_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, boolean z);

    public static final native long ModifyGroupBaseInfoOption_custom_info_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_custom_info_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, long j2, BytesMap bytesMap);

    public static final native byte[] ModifyGroupBaseInfoOption_face_url_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_face_url_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, byte[] bArr);

    public static final native long ModifyGroupBaseInfoOption_flag_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_flag_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, long j2);

    public static final native String ModifyGroupBaseInfoOption_group_id_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_group_id_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, String str);

    public static final native byte[] ModifyGroupBaseInfoOption_group_name_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_group_name_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, byte[] bArr);

    public static final native byte[] ModifyGroupBaseInfoOption_introduction_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_introduction_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, byte[] bArr);

    public static final native long ModifyGroupBaseInfoOption_max_member_num_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_max_member_num_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, long j2);

    public static final native byte[] ModifyGroupBaseInfoOption_notification_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_notification_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, byte[] bArr);

    public static final native int ModifyGroupBaseInfoOption_searchable_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_searchable_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, int i);

    public static final native int ModifyGroupBaseInfoOption_visible_get(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption);

    public static final native void ModifyGroupBaseInfoOption_visible_set(long j, ModifyGroupBaseInfoOption modifyGroupBaseInfoOption, int i);

    public static final native long ModifyGroupMemberInfoOption_custom_info_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_custom_info_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, long j2, BytesMap bytesMap);

    public static final native long ModifyGroupMemberInfoOption_flag_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_flag_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, long j2);

    public static final native String ModifyGroupMemberInfoOption_group_id_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_group_id_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, String str);

    public static final native String ModifyGroupMemberInfoOption_member_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_member_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, String str);

    public static final native long ModifyGroupMemberInfoOption_msg_flag_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_msg_flag_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, long j2);

    public static final native byte[] ModifyGroupMemberInfoOption_name_card_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_name_card_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, byte[] bArr);

    public static final native long ModifyGroupMemberInfoOption_role_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_role_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, long j2);

    public static final native long ModifyGroupMemberInfoOption_shutup_time_get(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption);

    public static final native void ModifyGroupMemberInfoOption_shutup_time_set(long j, ModifyGroupMemberInfoOption modifyGroupMemberInfoOption, long j2);

    public static final native long NumberGroupsDetail_infos_get(long j, NumberGroupsDetail numberGroupsDetail);

    public static final native void NumberGroupsDetail_infos_set(long j, NumberGroupsDetail numberGroupsDetail, long j2, GroupDetailInfoVec groupDetailInfoVec);

    public static final native long NumberGroupsDetail_num_get(long j, NumberGroupsDetail numberGroupsDetail);

    public static final native void NumberGroupsDetail_num_set(long j, NumberGroupsDetail numberGroupsDetail, long j2);

    public static final native long SeqMemberInfo_members_get(long j, SeqMemberInfo seqMemberInfo);

    public static final native void SeqMemberInfo_members_set(long j, SeqMemberInfo seqMemberInfo, long j2, MemberInfoVec memberInfoVec);

    public static final native long SeqMemberInfo_seq_get(long j, SeqMemberInfo seqMemberInfo);

    public static final native void SeqMemberInfo_seq_set(long j, SeqMemberInfo seqMemberInfo, long j2);

    public static void SwigDirector_ICallbackWithGroupBaseInfoVec_done(ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, long j) {
        iCallbackWithGroupBaseInfoVec.done(new GroupBaseInfoVec(j, false));
    }

    public static void SwigDirector_ICallbackWithGroupBaseInfoVec_fail(ICallbackWithGroupBaseInfoVec iCallbackWithGroupBaseInfoVec, int i, String str) {
        iCallbackWithGroupBaseInfoVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithGroupDetailInfoVec_done(ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, long j) {
        iCallbackWithGroupDetailInfoVec.done(new GroupDetailInfoVec(j, false));
    }

    public static void SwigDirector_ICallbackWithGroupDetailInfoVec_fail(ICallbackWithGroupDetailInfoVec iCallbackWithGroupDetailInfoVec, int i, String str) {
        iCallbackWithGroupDetailInfoVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithGroupPendencyResult_done(ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, long j) {
        iCallbackWithGroupPendencyResult.done(new GroupPendencyResult(j, false));
    }

    public static void SwigDirector_ICallbackWithGroupPendencyResult_fail(ICallbackWithGroupPendencyResult iCallbackWithGroupPendencyResult, int i, String str) {
        iCallbackWithGroupPendencyResult.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithMemberInfoVec_done(ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, long j) {
        iCallbackWithMemberInfoVec.done(new MemberInfoVec(j, false));
    }

    public static void SwigDirector_ICallbackWithMemberInfoVec_fail(ICallbackWithMemberInfoVec iCallbackWithMemberInfoVec, int i, String str) {
        iCallbackWithMemberInfoVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithMemberResultVec_done(ICallbackWithMemberResultVec iCallbackWithMemberResultVec, long j) {
        iCallbackWithMemberResultVec.done(new MemberResultVec(j, false));
    }

    public static void SwigDirector_ICallbackWithMemberResultVec_fail(ICallbackWithMemberResultVec iCallbackWithMemberResultVec, int i, String str) {
        iCallbackWithMemberResultVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithNumberGroupsDetail_done(ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, long j) {
        iCallbackWithNumberGroupsDetail.done(new NumberGroupsDetail(j, false));
    }

    public static void SwigDirector_ICallbackWithNumberGroupsDetail_fail(ICallbackWithNumberGroupsDetail iCallbackWithNumberGroupsDetail, int i, String str) {
        iCallbackWithNumberGroupsDetail.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithSeqMemberInfo_done(ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, long j) {
        iCallbackWithSeqMemberInfo.done(new SeqMemberInfo(j, false));
    }

    public static void SwigDirector_ICallbackWithSeqMemberInfo_fail(ICallbackWithSeqMemberInfo iCallbackWithSeqMemberInfo, int i, String str) {
        iCallbackWithSeqMemberInfo.fail(i, str);
    }

    public static void SwigDirector_IGroupNotify_onGroupAdd(IGroupNotify iGroupNotify, long j) {
        iGroupNotify.onGroupAdd(new GroupCacheInfo(j, false));
    }

    public static void SwigDirector_IGroupNotify_onGroupDelete(IGroupNotify iGroupNotify, String str) {
        iGroupNotify.onGroupDelete(str);
    }

    public static void SwigDirector_IGroupNotify_onGroupUpdate(IGroupNotify iGroupNotify, long j) {
        iGroupNotify.onGroupUpdate(new GroupCacheInfo(j, false));
    }

    public static void SwigDirector_IGroupNotify_onMemberJoin(IGroupNotify iGroupNotify, String str, long j) {
        iGroupNotify.onMemberJoin(str, new MemberInfoVec(j, false));
    }

    public static void SwigDirector_IGroupNotify_onMemberQuit(IGroupNotify iGroupNotify, String str, long j) {
        iGroupNotify.onMemberQuit(str, new StrVec(j, false));
    }

    public static void SwigDirector_IGroupNotify_onMemberUpdate(IGroupNotify iGroupNotify, String str, long j) {
        iGroupNotify.onMemberUpdate(str, new MemberInfoVec(j, false));
    }

    public static final native void delete_GetGroupBaseInfoOption(long j);

    public static final native void delete_GetGroupMemInfoOption(long j);

    public static final native void delete_GetGroupPendencyOption(long j);

    public static final native void delete_GroupBaseInfo(long j);

    public static final native void delete_GroupBaseInfoVec(long j);

    public static final native void delete_GroupCacheInfo(long j);

    public static final native void delete_GroupCacheInfoVec(long j);

    public static final native void delete_GroupDetailInfo(long j);

    public static final native void delete_GroupDetailInfoVec(long j);

    public static final native void delete_GroupExtHelper(long j);

    public static final native void delete_GroupManagerExt(long j);

    public static final native void delete_GroupPendencyItem(long j);

    public static final native void delete_GroupPendencyItemVec(long j);

    public static final native void delete_GroupPendencyMeta(long j);

    public static final native void delete_GroupPendencyResult(long j);

    public static final native void delete_GroupSelfInfo(long j);

    public static final native void delete_ICallbackWithGroupBaseInfoVec(long j);

    public static final native void delete_ICallbackWithGroupDetailInfoVec(long j);

    public static final native void delete_ICallbackWithGroupPendencyResult(long j);

    public static final native void delete_ICallbackWithMemberInfoVec(long j);

    public static final native void delete_ICallbackWithMemberResultVec(long j);

    public static final native void delete_ICallbackWithNumberGroupsDetail(long j);

    public static final native void delete_ICallbackWithSeqMemberInfo(long j);

    public static final native void delete_IGroupNotify(long j);

    public static final native void delete_MemberInfo(long j);

    public static final native void delete_MemberInfoVec(long j);

    public static final native void delete_MemberResult(long j);

    public static final native void delete_MemberResultVec(long j);

    public static final native void delete_ModifyGroupBaseInfoOption(long j);

    public static final native void delete_ModifyGroupMemberInfoOption(long j);

    public static final native void delete_NumberGroupsDetail(long j);

    public static final native void delete_SeqMemberInfo(long j);

    public static final native long new_GetGroupBaseInfoOption();

    public static final native long new_GetGroupMemInfoOption();

    public static final native long new_GetGroupPendencyOption();

    public static final native long new_GroupBaseInfo();

    public static final native long new_GroupBaseInfoVec__SWIG_0();

    public static final native long new_GroupBaseInfoVec__SWIG_1(long j);

    public static final native long new_GroupCacheInfo();

    public static final native long new_GroupCacheInfoVec__SWIG_0();

    public static final native long new_GroupCacheInfoVec__SWIG_1(long j);

    public static final native long new_GroupDetailInfo();

    public static final native long new_GroupDetailInfoVec__SWIG_0();

    public static final native long new_GroupDetailInfoVec__SWIG_1(long j);

    public static final native long new_GroupExtHelper();

    public static final native long new_GroupManagerExt(String str, long j, IGroupNotify iGroupNotify);

    public static final native long new_GroupPendencyItem();

    public static final native long new_GroupPendencyItemVec__SWIG_0();

    public static final native long new_GroupPendencyItemVec__SWIG_1(long j);

    public static final native long new_GroupPendencyMeta();

    public static final native long new_GroupPendencyResult();

    public static final native long new_GroupSelfInfo__SWIG_0();

    public static final native long new_GroupSelfInfo__SWIG_1(long j, MemberInfo memberInfo);

    public static final native long new_ICallbackWithGroupBaseInfoVec();

    public static final native long new_ICallbackWithGroupDetailInfoVec();

    public static final native long new_ICallbackWithGroupPendencyResult();

    public static final native long new_ICallbackWithMemberInfoVec();

    public static final native long new_ICallbackWithMemberResultVec();

    public static final native long new_ICallbackWithNumberGroupsDetail();

    public static final native long new_ICallbackWithSeqMemberInfo();

    public static final native long new_IGroupNotify();

    public static final native long new_MemberInfo();

    public static final native long new_MemberInfoVec__SWIG_0();

    public static final native long new_MemberInfoVec__SWIG_1(long j);

    public static final native long new_MemberResult();

    public static final native long new_MemberResultVec__SWIG_0();

    public static final native long new_MemberResultVec__SWIG_1(long j);

    public static final native long new_ModifyGroupBaseInfoOption();

    public static final native long new_ModifyGroupMemberInfoOption();

    public static final native long new_NumberGroupsDetail();

    public static final native long new_SeqMemberInfo();

    private static final native void swig_module_init();
}
