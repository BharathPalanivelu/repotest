package com.tencent.imcore;

public class internalJNI {
    static {
        swig_module_init();
    }

    public static final native long APNsInfo_badgeMode_get(long j, APNsInfo aPNsInfo);

    public static final native void APNsInfo_badgeMode_set(long j, APNsInfo aPNsInfo, long j2);

    public static final native byte[] APNsInfo_sound_get(long j, APNsInfo aPNsInfo);

    public static final native void APNsInfo_sound_set(long j, APNsInfo aPNsInfo, byte[] bArr);

    public static final native long AndroidOfflinePushInfo_notifyMode_get(long j, AndroidOfflinePushInfo androidOfflinePushInfo);

    public static final native void AndroidOfflinePushInfo_notifyMode_set(long j, AndroidOfflinePushInfo androidOfflinePushInfo, long j2);

    public static final native byte[] AndroidOfflinePushInfo_sound_get(long j, AndroidOfflinePushInfo androidOfflinePushInfo);

    public static final native void AndroidOfflinePushInfo_sound_set(long j, AndroidOfflinePushInfo androidOfflinePushInfo, byte[] bArr);

    public static final native byte[] AndroidOfflinePushInfo_title_get(long j, AndroidOfflinePushInfo androidOfflinePushInfo);

    public static final native void AndroidOfflinePushInfo_title_set(long j, AndroidOfflinePushInfo androidOfflinePushInfo, byte[] bArr);

    public static final native long ApplyDownloadFileReq_busiId_get(long j, ApplyDownloadFileReq applyDownloadFileReq);

    public static final native void ApplyDownloadFileReq_busiId_set(long j, ApplyDownloadFileReq applyDownloadFileReq, long j2);

    public static final native long ApplyDownloadFileReq_downloadFlag_get(long j, ApplyDownloadFileReq applyDownloadFileReq);

    public static final native void ApplyDownloadFileReq_downloadFlag_set(long j, ApplyDownloadFileReq applyDownloadFileReq, long j2);

    public static final native long ApplyDownloadFileReq_type_get(long j, ApplyDownloadFileReq applyDownloadFileReq);

    public static final native void ApplyDownloadFileReq_type_set(long j, ApplyDownloadFileReq applyDownloadFileReq, long j2);

    public static final native String ApplyDownloadFileReq_uuid_get(long j, ApplyDownloadFileReq applyDownloadFileReq);

    public static final native void ApplyDownloadFileReq_uuid_set(long j, ApplyDownloadFileReq applyDownloadFileReq, String str);

    public static final native void BytesCompatUintMap_clear(long j, BytesCompatUintMap bytesCompatUintMap);

    public static final native void BytesCompatUintMap_del(long j, BytesCompatUintMap bytesCompatUintMap, byte[] bArr);

    public static final native boolean BytesCompatUintMap_empty(long j, BytesCompatUintMap bytesCompatUintMap);

    public static final native long BytesCompatUintMap_get(long j, BytesCompatUintMap bytesCompatUintMap, byte[] bArr);

    public static final native boolean BytesCompatUintMap_hasKey(long j, BytesCompatUintMap bytesCompatUintMap, byte[] bArr);

    public static final native void BytesCompatUintMap_set(long j, BytesCompatUintMap bytesCompatUintMap, byte[] bArr, long j2, CompatUint64 compatUint64);

    public static final native long BytesCompatUintMap_size(long j, BytesCompatUintMap bytesCompatUintMap);

    public static final native void BytesMap_clear(long j, BytesMap bytesMap);

    public static final native void BytesMap_del(long j, BytesMap bytesMap, byte[] bArr);

    public static final native boolean BytesMap_empty(long j, BytesMap bytesMap);

    public static final native byte[] BytesMap_get(long j, BytesMap bytesMap, byte[] bArr);

    public static final native boolean BytesMap_hasKey(long j, BytesMap bytesMap, byte[] bArr);

    public static final native void BytesMap_set(long j, BytesMap bytesMap, byte[] bArr, byte[] bArr2);

    public static final native long BytesMap_size(long j, BytesMap bytesMap);

    public static final native void BytesVec_add(long j, BytesVec bytesVec, byte[] bArr);

    public static final native long BytesVec_capacity(long j, BytesVec bytesVec);

    public static final native void BytesVec_clear(long j, BytesVec bytesVec);

    public static final native byte[] BytesVec_get(long j, BytesVec bytesVec, int i);

    public static final native boolean BytesVec_isEmpty(long j, BytesVec bytesVec);

    public static final native void BytesVec_reserve(long j, BytesVec bytesVec, long j2);

    public static final native void BytesVec_set(long j, BytesVec bytesVec, int i, byte[] bArr);

    public static final native long BytesVec_size(long j, BytesVec bytesVec);

    public static final native long CompatUint64_value_get(long j, CompatUint64 compatUint64);

    public static final native void CompatUint64_value_set(long j, CompatUint64 compatUint64, long j2);

    public static final native byte[] Context_a2_get(long j, Context context);

    public static final native void Context_a2_set(long j, Context context, byte[] bArr);

    public static final native long Context_bid_get(long j, Context context);

    public static final native void Context_bid_set(long j, Context context, long j2);

    public static final native String Context_cache_msg_count_get(long j, Context context);

    public static final native void Context_cache_msg_count_set(long j, Context context, String str);

    public static final native String Context_data_dir_get(long j, Context context);

    public static final native void Context_data_dir_set(long j, Context context, String str);

    public static final native long Context_env_get(long j, Context context);

    public static final native void Context_env_set(long j, Context context, long j2, IEnv iEnv);

    public static final native String Context_file_cache_path_get(long j, Context context);

    public static final native void Context_file_cache_path_set(long j, Context context, String str);

    public static final native long Context_fm_guard_get(long j, Context context);

    public static final native void Context_fm_guard_set(long j, Context context, long j2);

    public static final native long Context_grp_guard_get(long j, Context context);

    public static final native void Context_grp_guard_set(long j, Context context, long j2);

    public static final native String Context_http_sso_url_get(long j, Context context);

    public static final native void Context_http_sso_url_set(long j, Context context, String str);

    public static final native String Context_ip_get(long j, Context context);

    public static final native void Context_ip_set(long j, Context context, String str);

    public static final native long Context_log_cb_get(long j, Context context);

    public static final native String Context_log_cb_lvl_get(long j, Context context);

    public static final native void Context_log_cb_lvl_set(long j, Context context, String str);

    public static final native void Context_log_cb_set(long j, Context context, long j2, ILogMsgCallback iLogMsgCallback);

    public static final native String Context_log_file_name_get(long j, Context context);

    public static final native void Context_log_file_name_set(long j, Context context, String str);

    public static final native String Context_log_lvl_get(long j, Context context);

    public static final native void Context_log_lvl_set(long j, Context context, String str);

    public static final native String Context_log_path_get(long j, Context context);

    public static final native void Context_log_path_set(long j, Context context, String str);

    public static final native String Context_major_ver_get(long j, Context context);

    public static final native void Context_major_ver_set(long j, Context context, String str);

    public static final native long Context_mm_guard_get(long j, Context context);

    public static final native void Context_mm_guard_set(long j, Context context, long j2);

    public static final native long Context_msg_dup_time_get(long j, Context context);

    public static final native void Context_msg_dup_time_set(long j, Context context, long j2);

    public static final native String Context_pic_cache_path_get(long j, Context context);

    public static final native void Context_pic_cache_path_set(long j, Context context, String str);

    public static final native long Context_platform_get(long j, Context context);

    public static final native void Context_platform_set(long j, Context context, long j2);

    public static final native boolean Context_print_log_get(long j, Context context);

    public static final native void Context_print_log_set(long j, Context context, boolean z);

    public static final native String Context_revision_ver_get(long j, Context context);

    public static final native void Context_revision_ver_set(long j, Context context, String str);

    public static final native long Context_svr_time_diff_get(long j, Context context);

    public static final native void Context_svr_time_diff_set(long j, Context context, long j2);

    public static final native long CreateGroupParams_add_option_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_add_option_set(long j, CreateGroupParams createGroupParams, long j2);

    public static final native long CreateGroupParams_custom_info_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_custom_info_set(long j, CreateGroupParams createGroupParams, long j2, BytesMap bytesMap);

    public static final native String CreateGroupParams_face_url_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_face_url_set(long j, CreateGroupParams createGroupParams, String str);

    public static final native byte[] CreateGroupParams_group_id_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_group_id_set(long j, CreateGroupParams createGroupParams, byte[] bArr);

    public static final native long CreateGroupParams_group_members_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_group_members_set(long j, CreateGroupParams createGroupParams, long j2, GroupTipsMemberInfoVec groupTipsMemberInfoVec);

    public static final native byte[] CreateGroupParams_group_name_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_group_name_set(long j, CreateGroupParams createGroupParams, byte[] bArr);

    public static final native String CreateGroupParams_group_type_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_group_type_set(long j, CreateGroupParams createGroupParams, String str);

    public static final native byte[] CreateGroupParams_introduction_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_introduction_set(long j, CreateGroupParams createGroupParams, byte[] bArr);

    public static final native long CreateGroupParams_max_member_num_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_max_member_num_set(long j, CreateGroupParams createGroupParams, long j2);

    public static final native byte[] CreateGroupParams_notification_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_notification_set(long j, CreateGroupParams createGroupParams, byte[] bArr);

    public static final native long CreateGroupParams_owner_tiny_id_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_owner_tiny_id_set(long j, CreateGroupParams createGroupParams, long j2);

    public static final native boolean CreateGroupParams_set_add_option_get(long j, CreateGroupParams createGroupParams);

    public static final native void CreateGroupParams_set_add_option_set(long j, CreateGroupParams createGroupParams, boolean z);

    public static final native byte[] CustomElem_data_get(long j, CustomElem customElem);

    public static final native void CustomElem_data_set(long j, CustomElem customElem, byte[] bArr);

    public static final native byte[] CustomElem_desc_get(long j, CustomElem customElem);

    public static final native void CustomElem_desc_set(long j, CustomElem customElem, byte[] bArr);

    public static final native byte[] CustomElem_ext_get(long j, CustomElem customElem);

    public static final native void CustomElem_ext_set(long j, CustomElem customElem, byte[] bArr);

    public static final native byte[] CustomElem_sound_get(long j, CustomElem customElem);

    public static final native void CustomElem_sound_set(long j, CustomElem customElem, byte[] bArr);

    public static final native byte[] DeviceId_android_id_get(long j, DeviceId deviceId);

    public static final native void DeviceId_android_id_set(long j, DeviceId deviceId, byte[] bArr);

    public static final native byte[] DeviceId_imei_get(long j, DeviceId deviceId);

    public static final native void DeviceId_imei_set(long j, DeviceId deviceId, byte[] bArr);

    public static final native byte[] DeviceId_mac_md5_get(long j, DeviceId deviceId);

    public static final native void DeviceId_mac_md5_set(long j, DeviceId deviceId, byte[] bArr);

    public static final native byte[] DeviceId_simulate_idfa_get(long j, DeviceId deviceId);

    public static final native void DeviceId_simulate_idfa_set(long j, DeviceId deviceId, byte[] bArr);

    public static final native void ElemVec_add(long j, ElemVec elemVec, long j2, Elem elem);

    public static final native long ElemVec_capacity(long j, ElemVec elemVec);

    public static final native void ElemVec_clear(long j, ElemVec elemVec);

    public static final native long ElemVec_get(long j, ElemVec elemVec, int i);

    public static final native boolean ElemVec_isEmpty(long j, ElemVec elemVec);

    public static final native void ElemVec_reserve(long j, ElemVec elemVec, long j2);

    public static final native void ElemVec_set(long j, ElemVec elemVec, int i, long j2, Elem elem);

    public static final native long ElemVec_size(long j, ElemVec elemVec);

    public static final native long Elem_custom_get(long j, Elem elem);

    public static final native void Elem_custom_set(long j, Elem elem, long j2, CustomElem customElem);

    public static final native long Elem_face_get(long j, Elem elem);

    public static final native void Elem_face_set(long j, Elem elem, long j2, FaceElem faceElem);

    public static final native long Elem_file_get(long j, Elem elem);

    public static final native void Elem_file_set(long j, Elem elem, long j2, FileElem fileElem);

    public static final native long Elem_friend_change_get(long j, Elem elem);

    public static final native void Elem_friend_change_set(long j, Elem elem, long j2, FriendChangeElem friendChangeElem);

    public static final native long Elem_group_report_get(long j, Elem elem);

    public static final native void Elem_group_report_set(long j, Elem elem, long j2, GroupReportElem groupReportElem);

    public static final native long Elem_group_tips_get(long j, Elem elem);

    public static final native void Elem_group_tips_set(long j, Elem elem, long j2, GroupTipsElem groupTipsElem);

    public static final native long Elem_image_get(long j, Elem elem);

    public static final native void Elem_image_set(long j, Elem elem, long j2, ImageElem imageElem);

    public static final native long Elem_location_get(long j, Elem elem);

    public static final native void Elem_location_set(long j, Elem elem, long j2, LocationElem locationElem);

    public static final native long Elem_profile_change_get(long j, Elem elem);

    public static final native void Elem_profile_change_set(long j, Elem elem, long j2, ProfileChangeElem profileChangeElem);

    public static final native byte[] Elem_resource_get(long j, Elem elem);

    public static final native void Elem_resource_set(long j, Elem elem, byte[] bArr);

    public static final native byte[] Elem_self_identifier_get(long j, Elem elem);

    public static final native void Elem_self_identifier_set(long j, Elem elem, byte[] bArr);

    public static final native long Elem_sound_get(long j, Elem elem);

    public static final native void Elem_sound_set(long j, Elem elem, long j2, SoundElem soundElem);

    public static final native long Elem_text_get(long j, Elem elem);

    public static final native void Elem_text_set(long j, Elem elem, long j2, TextElem textElem);

    public static final native int Elem_type_get(long j, Elem elem);

    public static final native void Elem_type_set(long j, Elem elem, int i);

    public static final native long Elem_ugc_get(long j, Elem elem);

    public static final native void Elem_ugc_set(long j, Elem elem, long j2, UGCElem uGCElem);

    public static final native long Elem_video_get(long j, Elem elem);

    public static final native void Elem_video_set(long j, Elem elem, long j2, VideoElem videoElem);

    public static final native void EnvRequestClosure_done(long j, EnvRequestClosure envRequestClosure, byte[] bArr);

    public static final native void EnvRequestClosure_fail(long j, EnvRequestClosure envRequestClosure, int i, String str);

    public static final native void EnvRequestClosure_release(long j, EnvRequestClosure envRequestClosure);

    public static final native byte[] FaceElem_buf_get(long j, FaceElem faceElem);

    public static final native void FaceElem_buf_set(long j, FaceElem faceElem, byte[] bArr);

    public static final native int FaceElem_index_get(long j, FaceElem faceElem);

    public static final native void FaceElem_index_set(long j, FaceElem faceElem, int i);

    public static final native int FileElem_business_id_get(long j, FileElem fileElem);

    public static final native void FileElem_business_id_set(long j, FileElem fileElem, int i);

    public static final native int FileElem_download_flag_get(long j, FileElem fileElem);

    public static final native void FileElem_download_flag_set(long j, FileElem fileElem, int i);

    public static final native byte[] FileElem_file_name_get(long j, FileElem fileElem);

    public static final native void FileElem_file_name_set(long j, FileElem fileElem, byte[] bArr);

    public static final native byte[] FileElem_file_path_get(long j, FileElem fileElem);

    public static final native void FileElem_file_path_set(long j, FileElem fileElem, byte[] bArr);

    public static final native long FileElem_file_size_get(long j, FileElem fileElem);

    public static final native void FileElem_file_size_set(long j, FileElem fileElem, long j2);

    public static final native String FileElem_fileid_get(long j, FileElem fileElem);

    public static final native void FileElem_fileid_set(long j, FileElem fileElem, String str);

    public static final native int FileElem_taskid_get(long j, FileElem fileElem);

    public static final native void FileElem_taskid_set(long j, FileElem fileElem, int i);

    public static final native long FileElem_urls_get(long j, FileElem fileElem);

    public static final native void FileElem_urls_set(long j, FileElem fileElem, long j2, StrVec strVec);

    public static final native long FriendChangeElem_ddwDecideReportTimestamp_get(long j, FriendChangeElem friendChangeElem);

    public static final native void FriendChangeElem_ddwDecideReportTimestamp_set(long j, FriendChangeElem friendChangeElem, long j2);

    public static final native long FriendChangeElem_ddwPendencyReportTimestamp_get(long j, FriendChangeElem friendChangeElem);

    public static final native void FriendChangeElem_ddwPendencyReportTimestamp_set(long j, FriendChangeElem friendChangeElem, long j2);

    public static final native long FriendChangeElem_ddwRecommendReportTimestamp_get(long j, FriendChangeElem friendChangeElem);

    public static final native void FriendChangeElem_ddwRecommendReportTimestamp_set(long j, FriendChangeElem friendChangeElem, long j2);

    public static final native long FriendChangeElem_type_get(long j, FriendChangeElem friendChangeElem);

    public static final native void FriendChangeElem_type_set(long j, FriendChangeElem friendChangeElem, long j2);

    public static final native long FriendChangeElem_users_get(long j, FriendChangeElem friendChangeElem);

    public static final native void FriendChangeElem_users_set(long j, FriendChangeElem friendChangeElem, long j2, FriendChangeInfoVec friendChangeInfoVec);

    public static final native void FriendChangeInfoVec_add(long j, FriendChangeInfoVec friendChangeInfoVec, long j2, FriendChangeUserInfo friendChangeUserInfo);

    public static final native long FriendChangeInfoVec_capacity(long j, FriendChangeInfoVec friendChangeInfoVec);

    public static final native void FriendChangeInfoVec_clear(long j, FriendChangeInfoVec friendChangeInfoVec);

    public static final native long FriendChangeInfoVec_get(long j, FriendChangeInfoVec friendChangeInfoVec, int i);

    public static final native boolean FriendChangeInfoVec_isEmpty(long j, FriendChangeInfoVec friendChangeInfoVec);

    public static final native void FriendChangeInfoVec_reserve(long j, FriendChangeInfoVec friendChangeInfoVec, long j2);

    public static final native void FriendChangeInfoVec_set(long j, FriendChangeInfoVec friendChangeInfoVec, int i, long j2, FriendChangeUserInfo friendChangeUserInfo);

    public static final native long FriendChangeInfoVec_size(long j, FriendChangeInfoVec friendChangeInfoVec);

    public static final native byte[] FriendChangeUserInfo_add_source_get(long j, FriendChangeUserInfo friendChangeUserInfo);

    public static final native void FriendChangeUserInfo_add_source_set(long j, FriendChangeUserInfo friendChangeUserInfo, byte[] bArr);

    public static final native byte[] FriendChangeUserInfo_add_wording_get(long j, FriendChangeUserInfo friendChangeUserInfo);

    public static final native void FriendChangeUserInfo_add_wording_set(long j, FriendChangeUserInfo friendChangeUserInfo, byte[] bArr);

    public static final native byte[] FriendChangeUserInfo_group_get(long j, FriendChangeUserInfo friendChangeUserInfo);

    public static final native void FriendChangeUserInfo_group_set(long j, FriendChangeUserInfo friendChangeUserInfo, byte[] bArr);

    public static final native String FriendChangeUserInfo_identifier_get(long j, FriendChangeUserInfo friendChangeUserInfo);

    public static final native void FriendChangeUserInfo_identifier_set(long j, FriendChangeUserInfo friendChangeUserInfo, String str);

    public static final native byte[] FriendChangeUserInfo_nick_get(long j, FriendChangeUserInfo friendChangeUserInfo);

    public static final native void FriendChangeUserInfo_nick_set(long j, FriendChangeUserInfo friendChangeUserInfo, byte[] bArr);

    public static final native byte[] FriendChangeUserInfo_remark_get(long j, FriendChangeUserInfo friendChangeUserInfo);

    public static final native void FriendChangeUserInfo_remark_set(long j, FriendChangeUserInfo friendChangeUserInfo, byte[] bArr);

    public static final native long FriendProfileInfoOpt_flags_get(long j, FriendProfileInfoOpt friendProfileInfoOpt);

    public static final native void FriendProfileInfoOpt_flags_set(long j, FriendProfileInfoOpt friendProfileInfoOpt, long j2);

    public static final native long FriendProfileInfoOpt_user_custom_get(long j, FriendProfileInfoOpt friendProfileInfoOpt);

    public static final native void FriendProfileInfoOpt_user_custom_set(long j, FriendProfileInfoOpt friendProfileInfoOpt, long j2, BytesVec bytesVec);

    public static final native void FriendProfileVec_add(long j, FriendProfileVec friendProfileVec, long j2, FriendProfile friendProfile);

    public static final native long FriendProfileVec_capacity(long j, FriendProfileVec friendProfileVec);

    public static final native void FriendProfileVec_clear(long j, FriendProfileVec friendProfileVec);

    public static final native long FriendProfileVec_get(long j, FriendProfileVec friendProfileVec, int i);

    public static final native boolean FriendProfileVec_isEmpty(long j, FriendProfileVec friendProfileVec);

    public static final native void FriendProfileVec_reserve(long j, FriendProfileVec friendProfileVec, long j2);

    public static final native void FriendProfileVec_set(long j, FriendProfileVec friendProfileVec, int i, long j2, FriendProfile friendProfile);

    public static final native long FriendProfileVec_size(long j, FriendProfileVec friendProfileVec);

    public static final native long FriendProfile_custom_info_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_custom_info_set(long j, FriendProfile friendProfile, long j2, BytesMap bytesMap);

    public static final native long FriendProfile_custom_info_uint_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_custom_info_uint_set(long j, FriendProfile friendProfile, long j2, BytesCompatUintMap bytesCompatUintMap);

    public static final native long FriendProfile_ddwTinyId_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_ddwTinyId_set(long j, FriendProfile friendProfile, long j2);

    public static final native int FriendProfile_eGender_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_eGender_set(long j, FriendProfile friendProfile, int i);

    public static final native long FriendProfile_result_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_result_set(long j, FriendProfile friendProfile, long j2);

    public static final native byte[] FriendProfile_sAddSource_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sAddSource_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native byte[] FriendProfile_sAddWording_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sAddWording_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native String FriendProfile_sAllowType_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sAllowType_set(long j, FriendProfile friendProfile, String str);

    public static final native byte[] FriendProfile_sFaceURL_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sFaceURL_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native long FriendProfile_sGroupNames_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sGroupNames_set(long j, FriendProfile friendProfile, long j2, BytesVec bytesVec);

    public static final native String FriendProfile_sIdentifier_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sIdentifier_set(long j, FriendProfile friendProfile, String str);

    public static final native byte[] FriendProfile_sLocation_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sLocation_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native byte[] FriendProfile_sNickname_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sNickname_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native byte[] FriendProfile_sRemark_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sRemark_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native String FriendProfile_sResponseAction_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sResponseAction_set(long j, FriendProfile friendProfile, String str);

    public static final native byte[] FriendProfile_sSelfSignature_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_sSelfSignature_set(long j, FriendProfile friendProfile, byte[] bArr);

    public static final native long FriendProfile_set_flags_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_set_flags_set(long j, FriendProfile friendProfile, long j2);

    public static final native long FriendProfile_uBirthDay_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_uBirthDay_set(long j, FriendProfile friendProfile, long j2);

    public static final native long FriendProfile_uLanguage_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_uLanguage_set(long j, FriendProfile friendProfile, long j2);

    public static final native long FriendProfile_uLevel_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_uLevel_set(long j, FriendProfile friendProfile, long j2);

    public static final native long FriendProfile_uRole_get(long j, FriendProfile friendProfile);

    public static final native void FriendProfile_uRole_set(long j, FriendProfile friendProfile, long j2);

    public static final native long FriendshipManager_getInitTask(long j, FriendshipManager friendshipManager);

    public static final native boolean FriendshipManager_getProfile(long j, FriendshipManager friendshipManager, long j2, StrVec strVec, long j3, ICallbackWithProfileVec iCallbackWithProfileVec);

    public static final native long FriendshipManager_getSyncTask(long j, FriendshipManager friendshipManager);

    public static final native void FriendshipManager_registerMsgEvent(long j, FriendshipManager friendshipManager, long j2);

    public static final native boolean FriendshipManager_setProfile(long j, FriendshipManager friendshipManager, long j2, SetProfileOption setProfileOption, long j3, INotifyCallback iNotifyCallback);

    public static final native long GroupInfoOpt_custom_get(long j, GroupInfoOpt groupInfoOpt);

    public static final native void GroupInfoOpt_custom_set(long j, GroupInfoOpt groupInfoOpt, long j2, BytesVec bytesVec);

    public static final native long GroupInfoOpt_flags_get(long j, GroupInfoOpt groupInfoOpt);

    public static final native void GroupInfoOpt_flags_set(long j, GroupInfoOpt groupInfoOpt, long j2);

    public static final native boolean GroupManager_applyJoinGroup(long j, GroupManager groupManager, String str, String str2, long j2, INotifyCallback iNotifyCallback);

    public static final native boolean GroupManager_createGroup(long j, GroupManager groupManager, long j2, CreateGroupParams createGroupParams, long j3, ICallbackWithString iCallbackWithString);

    public static final native boolean GroupManager_deleteGroup(long j, GroupManager groupManager, String str, long j2, INotifyCallback iNotifyCallback);

    public static final native long GroupManager_getInitTask(long j, GroupManager groupManager);

    public static final native long GroupManager_getSyncTask(long j, GroupManager groupManager);

    public static final native void GroupManager_onGroupSystemMsgEvent(long j, GroupManager groupManager, long j2, GroupReportElem groupReportElem);

    public static final native void GroupManager_onMsgEvent(String str, long j, MsgVec msgVec);

    public static final native boolean GroupManager_quitGroup(long j, GroupManager groupManager, String str, long j2, INotifyCallback iNotifyCallback);

    public static final native void GroupManager_registerMsgEvent(long j, GroupManager groupManager, long j2);

    public static final native void GroupManager_updateGroupMsgLatestSeq(long j, GroupManager groupManager, String str, long j2, INotifyCallback iNotifyCallback);

    public static final native long GroupMemberInfoOpt_custom_get(long j, GroupMemberInfoOpt groupMemberInfoOpt);

    public static final native void GroupMemberInfoOpt_custom_set(long j, GroupMemberInfoOpt groupMemberInfoOpt, long j2, BytesVec bytesVec);

    public static final native long GroupMemberInfoOpt_flags_get(long j, GroupMemberInfoOpt groupMemberInfoOpt);

    public static final native void GroupMemberInfoOpt_flags_set(long j, GroupMemberInfoOpt groupMemberInfoOpt, long j2);

    public static final native byte[] GroupReportElem_authentication_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_authentication_set(long j, GroupReportElem groupReportElem, byte[] bArr);

    public static final native String GroupReportElem_group_get(long j, GroupReportElem groupReportElem);

    public static final native String GroupReportElem_group_name_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_group_name_set(long j, GroupReportElem groupReportElem, String str);

    public static final native void GroupReportElem_group_set(long j, GroupReportElem groupReportElem, String str);

    public static final native byte[] GroupReportElem_msg_get(long j, GroupReportElem groupReportElem);

    public static final native long GroupReportElem_msg_key_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_msg_key_set(long j, GroupReportElem groupReportElem, long j2);

    public static final native void GroupReportElem_msg_set(long j, GroupReportElem groupReportElem, byte[] bArr);

    public static final native long GroupReportElem_operator_group_member_info_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_operator_group_member_info_set(long j, GroupReportElem groupReportElem, long j2, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native String GroupReportElem_operator_user_get(long j, GroupReportElem groupReportElem);

    public static final native long GroupReportElem_operator_user_info_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_operator_user_info_set(long j, GroupReportElem groupReportElem, long j2, FriendProfile friendProfile);

    public static final native void GroupReportElem_operator_user_set(long j, GroupReportElem groupReportElem, String str);

    public static final native byte[] GroupReportElem_platform_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_platform_set(long j, GroupReportElem groupReportElem, byte[] bArr);

    public static final native long GroupReportElem_type_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_type_set(long j, GroupReportElem groupReportElem, long j2);

    public static final native byte[] GroupReportElem_user_data_get(long j, GroupReportElem groupReportElem);

    public static final native void GroupReportElem_user_data_set(long j, GroupReportElem groupReportElem, byte[] bArr);

    public static final native void GroupTipsElem_GroupInfoVec_add(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec, long j2, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo);

    public static final native long GroupTipsElem_GroupInfoVec_capacity(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec);

    public static final native void GroupTipsElem_GroupInfoVec_clear(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec);

    public static final native long GroupTipsElem_GroupInfoVec_get(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec, int i);

    public static final native boolean GroupTipsElem_GroupInfoVec_isEmpty(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec);

    public static final native void GroupTipsElem_GroupInfoVec_reserve(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec, long j2);

    public static final native void GroupTipsElem_GroupInfoVec_set(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec, int i, long j2, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo);

    public static final native long GroupTipsElem_GroupInfoVec_size(long j, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec);

    public static final native int GroupTipsElem_GroupInfo_type_get(long j, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo);

    public static final native void GroupTipsElem_GroupInfo_type_set(long j, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo, int i);

    public static final native byte[] GroupTipsElem_GroupInfo_value_get(long j, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo);

    public static final native void GroupTipsElem_GroupInfo_value_set(long j, GroupTipsElem_GroupInfo groupTipsElem_GroupInfo, byte[] bArr);

    public static final native void GroupTipsElem_MemberInfoVec_add(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec, long j2, GroupTipsElem_MemberInfo groupTipsElem_MemberInfo);

    public static final native long GroupTipsElem_MemberInfoVec_capacity(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec);

    public static final native void GroupTipsElem_MemberInfoVec_clear(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec);

    public static final native long GroupTipsElem_MemberInfoVec_get(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec, int i);

    public static final native boolean GroupTipsElem_MemberInfoVec_isEmpty(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec);

    public static final native void GroupTipsElem_MemberInfoVec_reserve(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec, long j2);

    public static final native void GroupTipsElem_MemberInfoVec_set(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec, int i, long j2, GroupTipsElem_MemberInfo groupTipsElem_MemberInfo);

    public static final native long GroupTipsElem_MemberInfoVec_size(long j, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec);

    public static final native String GroupTipsElem_MemberInfo_identifier_get(long j, GroupTipsElem_MemberInfo groupTipsElem_MemberInfo);

    public static final native void GroupTipsElem_MemberInfo_identifier_set(long j, GroupTipsElem_MemberInfo groupTipsElem_MemberInfo, String str);

    public static final native long GroupTipsElem_MemberInfo_shutup_time_get(long j, GroupTipsElem_MemberInfo groupTipsElem_MemberInfo);

    public static final native void GroupTipsElem_MemberInfo_shutup_time_set(long j, GroupTipsElem_MemberInfo groupTipsElem_MemberInfo, long j2);

    public static final native long GroupTipsElem_changed_group_member_info_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_changed_group_member_info_set(long j, GroupTipsElem groupTipsElem, long j2, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap);

    public static final native long GroupTipsElem_changed_user_info_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_changed_user_info_set(long j, GroupTipsElem groupTipsElem, long j2, StringProfileMap stringProfileMap);

    public static final native long GroupTipsElem_group_change_list_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_group_change_list_set(long j, GroupTipsElem groupTipsElem, long j2, GroupTipsElem_GroupInfoVec groupTipsElem_GroupInfoVec);

    public static final native byte[] GroupTipsElem_group_id_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_group_id_set(long j, GroupTipsElem groupTipsElem, byte[] bArr);

    public static final native byte[] GroupTipsElem_group_name_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_group_name_set(long j, GroupTipsElem groupTipsElem, byte[] bArr);

    public static final native long GroupTipsElem_member_change_list_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_member_change_list_set(long j, GroupTipsElem groupTipsElem, long j2, GroupTipsElem_MemberInfoVec groupTipsElem_MemberInfoVec);

    public static final native long GroupTipsElem_member_num_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_member_num_set(long j, GroupTipsElem groupTipsElem, long j2);

    public static final native long GroupTipsElem_op_group_member_info_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_op_group_member_info_set(long j, GroupTipsElem groupTipsElem, long j2, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native String GroupTipsElem_op_user_get(long j, GroupTipsElem groupTipsElem);

    public static final native long GroupTipsElem_op_user_info_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_op_user_info_set(long j, GroupTipsElem groupTipsElem, long j2, FriendProfile friendProfile);

    public static final native void GroupTipsElem_op_user_set(long j, GroupTipsElem groupTipsElem, String str);

    public static final native byte[] GroupTipsElem_platform_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_platform_set(long j, GroupTipsElem groupTipsElem, byte[] bArr);

    public static final native long GroupTipsElem_time_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_time_set(long j, GroupTipsElem groupTipsElem, long j2);

    public static final native int GroupTipsElem_type_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_type_set(long j, GroupTipsElem groupTipsElem, int i);

    public static final native long GroupTipsElem_user_list_get(long j, GroupTipsElem groupTipsElem);

    public static final native void GroupTipsElem_user_list_set(long j, GroupTipsElem groupTipsElem, long j2, StrVec strVec);

    public static final native void GroupTipsMemberInfoVec_add(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec, long j2, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native long GroupTipsMemberInfoVec_capacity(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec);

    public static final native void GroupTipsMemberInfoVec_clear(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec);

    public static final native long GroupTipsMemberInfoVec_get(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec, int i);

    public static final native boolean GroupTipsMemberInfoVec_isEmpty(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec);

    public static final native void GroupTipsMemberInfoVec_reserve(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec, long j2);

    public static final native void GroupTipsMemberInfoVec_set(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec, int i, long j2, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native long GroupTipsMemberInfoVec_size(long j, GroupTipsMemberInfoVec groupTipsMemberInfoVec);

    public static final native long GroupTipsMemberInfo_custom_info_get(long j, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native void GroupTipsMemberInfo_custom_info_set(long j, GroupTipsMemberInfo groupTipsMemberInfo, long j2, BytesMap bytesMap);

    public static final native String GroupTipsMemberInfo_identifier_get(long j, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native void GroupTipsMemberInfo_identifier_set(long j, GroupTipsMemberInfo groupTipsMemberInfo, String str);

    public static final native int GroupTipsMemberInfo_member_role_get(long j, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native void GroupTipsMemberInfo_member_role_set(long j, GroupTipsMemberInfo groupTipsMemberInfo, int i);

    public static final native int GroupTipsMemberInfo_msg_flag_get(long j, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native void GroupTipsMemberInfo_msg_flag_set(long j, GroupTipsMemberInfo groupTipsMemberInfo, int i);

    public static final native byte[] GroupTipsMemberInfo_name_card_get(long j, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native void GroupTipsMemberInfo_name_card_set(long j, GroupTipsMemberInfo groupTipsMemberInfo, byte[] bArr);

    public static final native void IApplyDownloadFileCallback_change_ownership(IApplyDownloadFileCallback iApplyDownloadFileCallback, long j, boolean z);

    public static final native void IApplyDownloadFileCallback_director_connect(IApplyDownloadFileCallback iApplyDownloadFileCallback, long j, boolean z, boolean z2);

    public static final native void IApplyDownloadFileCallback_done(long j, IApplyDownloadFileCallback iApplyDownloadFileCallback, long j2, StrVec strVec);

    public static final native void IApplyDownloadFileCallback_doneSwigExplicitIApplyDownloadFileCallback(long j, IApplyDownloadFileCallback iApplyDownloadFileCallback, long j2, StrVec strVec);

    public static final native void IApplyDownloadFileCallback_fail(long j, IApplyDownloadFileCallback iApplyDownloadFileCallback, int i, String str);

    public static final native void IApplyDownloadFileCallback_failSwigExplicitIApplyDownloadFileCallback(long j, IApplyDownloadFileCallback iApplyDownloadFileCallback, int i, String str);

    public static final native void ICallbackWithProfileVec_change_ownership(ICallbackWithProfileVec iCallbackWithProfileVec, long j, boolean z);

    public static final native void ICallbackWithProfileVec_director_connect(ICallbackWithProfileVec iCallbackWithProfileVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithProfileVec_done(long j, ICallbackWithProfileVec iCallbackWithProfileVec, long j2, FriendProfileVec friendProfileVec);

    public static final native void ICallbackWithProfileVec_doneSwigExplicitICallbackWithProfileVec(long j, ICallbackWithProfileVec iCallbackWithProfileVec, long j2, FriendProfileVec friendProfileVec);

    public static final native void ICallbackWithProfileVec_fail(long j, ICallbackWithProfileVec iCallbackWithProfileVec, int i, String str);

    public static final native void ICallbackWithProfileVec_failSwigExplicitICallbackWithProfileVec(long j, ICallbackWithProfileVec iCallbackWithProfileVec, int i, String str);

    public static final native void ICallbackWithStrVec_change_ownership(ICallbackWithStrVec iCallbackWithStrVec, long j, boolean z);

    public static final native void ICallbackWithStrVec_director_connect(ICallbackWithStrVec iCallbackWithStrVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithStrVec_done(long j, ICallbackWithStrVec iCallbackWithStrVec, long j2, StrVec strVec);

    public static final native void ICallbackWithStrVec_doneSwigExplicitICallbackWithStrVec(long j, ICallbackWithStrVec iCallbackWithStrVec, long j2, StrVec strVec);

    public static final native void ICallbackWithStrVec_fail(long j, ICallbackWithStrVec iCallbackWithStrVec, int i, String str);

    public static final native void ICallbackWithStrVec_failSwigExplicitICallbackWithStrVec(long j, ICallbackWithStrVec iCallbackWithStrVec, int i, String str);

    public static final native void ICallbackWithString_change_ownership(ICallbackWithString iCallbackWithString, long j, boolean z);

    public static final native void ICallbackWithString_director_connect(ICallbackWithString iCallbackWithString, long j, boolean z, boolean z2);

    public static final native void ICallbackWithString_done(long j, ICallbackWithString iCallbackWithString, String str);

    public static final native void ICallbackWithString_doneSwigExplicitICallbackWithString(long j, ICallbackWithString iCallbackWithString, String str);

    public static final native void ICallbackWithString_fail(long j, ICallbackWithString iCallbackWithString, int i, String str);

    public static final native void ICallbackWithString_failSwigExplicitICallbackWithString(long j, ICallbackWithString iCallbackWithString, int i, String str);

    public static final native void IEnv_change_ownership(IEnv iEnv, long j, boolean z);

    public static final native boolean IEnv_createThread(long j, IEnv iEnv, long j2, ThreadEntry threadEntry);

    public static final native boolean IEnv_createThreadSwigExplicitIEnv(long j, IEnv iEnv, long j2, ThreadEntry threadEntry);

    public static final native void IEnv_director_connect(IEnv iEnv, long j, boolean z, boolean z2);

    public static final native boolean IEnv_httpRequest(long j, IEnv iEnv, String str, int i, String str2, byte[] bArr, long j2, EnvRequestClosure envRequestClosure);

    public static final native boolean IEnv_httpRequestSwigExplicitIEnv(long j, IEnv iEnv, String str, int i, String str2, byte[] bArr, long j2, EnvRequestClosure envRequestClosure);

    public static final native boolean IEnv_runOnMainThread(long j, IEnv iEnv, long j2, RunClosure runClosure);

    public static final native boolean IEnv_runOnMainThreadSwigExplicitIEnv(long j, IEnv iEnv, long j2, RunClosure runClosure);

    public static final native boolean IEnv_sSORequestSwigExplicitIEnv__SWIG_0(long j, IEnv iEnv, String str, String str2, byte[] bArr, long j2, EnvRequestClosure envRequestClosure, long j3);

    public static final native boolean IEnv_sSORequestSwigExplicitIEnv__SWIG_1(long j, IEnv iEnv, String str, String str2, byte[] bArr, long j2, EnvRequestClosure envRequestClosure);

    public static final native boolean IEnv_sSORequest__SWIG_0(long j, IEnv iEnv, String str, String str2, byte[] bArr, long j2, EnvRequestClosure envRequestClosure, long j3);

    public static final native boolean IEnv_sSORequest__SWIG_1(long j, IEnv iEnv, String str, String str2, byte[] bArr, long j2, EnvRequestClosure envRequestClosure);

    public static final native boolean IEnv_uploadLogFile(long j, IEnv iEnv, String str, long j2, UploadLogFileOpt uploadLogFileOpt);

    public static final native boolean IEnv_uploadLogFileSwigExplicitIEnv(long j, IEnv iEnv, String str, long j2, UploadLogFileOpt uploadLogFileOpt);

    public static final native void IImageUploadCallback_change_ownership(IImageUploadCallback iImageUploadCallback, long j, boolean z);

    public static final native void IImageUploadCallback_director_connect(IImageUploadCallback iImageUploadCallback, long j, boolean z, boolean z2);

    public static final native void IImageUploadCallback_done(long j, IImageUploadCallback iImageUploadCallback, long j2, ImageElem imageElem);

    public static final native void IImageUploadCallback_doneSwigExplicitIImageUploadCallback(long j, IImageUploadCallback iImageUploadCallback, long j2, ImageElem imageElem);

    public static final native void IImageUploadCallback_fail(long j, IImageUploadCallback iImageUploadCallback, int i, String str);

    public static final native void IImageUploadCallback_failSwigExplicitIImageUploadCallback(long j, IImageUploadCallback iImageUploadCallback, int i, String str);

    public static final native void ILogMsgCallback_change_ownership(ILogMsgCallback iLogMsgCallback, long j, boolean z);

    public static final native void ILogMsgCallback_director_connect(ILogMsgCallback iLogMsgCallback, long j, boolean z, boolean z2);

    public static final native void ILogMsgCallback_onLogMsg(long j, ILogMsgCallback iLogMsgCallback, String str, int i, String str2);

    public static final native void ILogMsgCallback_onLogMsgSwigExplicitILogMsgCallback(long j, ILogMsgCallback iLogMsgCallback, String str, int i, String str2);

    public static final native int IMCoreUser_applyDownloadFile(long j, IMCoreUser iMCoreUser, long j2, ApplyDownloadFileReq applyDownloadFileReq, long j3, IApplyDownloadFileCallback iApplyDownloadFileCallback);

    public static final native int IMCoreUser_cancelAllPicupTask(long j, IMCoreUser iMCoreUser);

    public static final native void IMCoreUser_cancelTask(long j, IMCoreUser iMCoreUser, long j2);

    public static final native int IMCoreUser_compressPic(long j, IMCoreUser iMCoreUser, String str, String str2, int i);

    public static final native boolean IMCoreUser_fake(long j, IMCoreUser iMCoreUser);

    public static final native long IMCoreUser_getFriendshipMgr(long j, IMCoreUser iMCoreUser);

    public static final native long IMCoreUser_getGroupMgr(long j, IMCoreUser iMCoreUser);

    public static final native int IMCoreUser_getImageUploadProgrss(long j, IMCoreUser iMCoreUser, long j2);

    public static final native long IMCoreUser_getSelfProfile(long j, IMCoreUser iMCoreUser);

    public static final native long IMCoreUser_getSession(long j, IMCoreUser iMCoreUser, int i, String str);

    public static final native boolean IMCoreUser_httpRequest(long j, IMCoreUser iMCoreUser, int i, String str, byte[] bArr, long j2, EnvRequestClosure envRequestClosure);

    public static final native void IMCoreUser_loginSync(long j, IMCoreUser iMCoreUser);

    public static final native int IMCoreUser_manualPush(long j, IMCoreUser iMCoreUser, byte[] bArr);

    public static final native boolean IMCoreUser_runOnIOThread(long j, IMCoreUser iMCoreUser, long j2);

    public static final native boolean IMCoreUser_runOnMainThread(long j, IMCoreUser iMCoreUser, long j2);

    public static final native boolean IMCoreUser_runOnTaskThread(long j, IMCoreUser iMCoreUser, long j2);

    public static final native boolean IMCoreUser_sSORequest__SWIG_0(long j, IMCoreUser iMCoreUser, String str, byte[] bArr, long j2, EnvRequestClosure envRequestClosure, long j3);

    public static final native boolean IMCoreUser_sSORequest__SWIG_1(long j, IMCoreUser iMCoreUser, String str, byte[] bArr, long j2, EnvRequestClosure envRequestClosure);

    public static final native void IMCoreUser_saveSelfProfile(long j, IMCoreUser iMCoreUser, long j2, FriendProfile friendProfile);

    public static final native long IMCoreUser_submitUploadTask__SWIG_0(long j, IMCoreUser iMCoreUser, String str, long j2, IImageUploadCallback iImageUploadCallback, int i);

    public static final native long IMCoreUser_submitUploadTask__SWIG_1(long j, IMCoreUser iMCoreUser, String str, long j2, IImageUploadCallback iImageUploadCallback);

    public static final native void IMCore_clearLog__SWIG_0(long j, IMCore iMCore, String str, long j2, String str2, long j3, int i);

    public static final native void IMCore_clearLog__SWIG_1(long j, IMCore iMCore, String str, long j2, String str2, long j3);

    public static final native void IMCore_clearLog__SWIG_2(long j, IMCore iMCore, String str, long j2, String str2);

    public static final native void IMCore_clearLog__SWIG_3(long j, IMCore iMCore, String str, long j2);

    public static final native long IMCore_get();

    public static final native long IMCore_getContext(long j, IMCore iMCore);

    public static final native long IMCore_getTime(long j, IMCore iMCore);

    public static final native long IMCore_getUser(long j, IMCore iMCore, String str);

    public static final native String IMCore_getVersion(long j, IMCore iMCore, int i);

    public static final native boolean IMCore_initOpenIM(long j, IMCore iMCore, long j2, Context context);

    public static final native int IMCore_initUser(long j, IMCore iMCore, long j2, UserConfig userConfig, long j3, INotifyCallback iNotifyCallback);

    public static final native void IMCore_lOGGERLOG(long j, IMCore iMCore, int i, String str, int i2, String str2, String str3, String str4);

    public static final native void IMCore_qrReportDeviceId(long j, IMCore iMCore, long j2, DeviceId deviceId);

    public static final native void IMCore_qrReportEvent(long j, IMCore iMCore, long j2, SdkReportItem sdkReportItem);

    public static final native void IMCore_refreshA2(long j, IMCore iMCore, byte[] bArr);

    public static final native void IMCore_refreshSvrDiff(long j, IMCore iMCore, long j2);

    public static final native int IMCore_unInitUser(long j, IMCore iMCore, String str);

    public static final native boolean IMCore_uploadLogFile(long j, IMCore iMCore, String str, long j2, UploadLogFileOpt uploadLogFileOpt);

    public static final native void INotifyCallback_change_ownership(INotifyCallback iNotifyCallback, long j, boolean z);

    public static final native void INotifyCallback_director_connect(INotifyCallback iNotifyCallback, long j, boolean z, boolean z2);

    public static final native void INotifyCallback_done(long j, INotifyCallback iNotifyCallback);

    public static final native void INotifyCallback_doneSwigExplicitINotifyCallback(long j, INotifyCallback iNotifyCallback);

    public static final native void INotifyCallback_fail(long j, INotifyCallback iNotifyCallback, int i, String str);

    public static final native void INotifyCallback_failSwigExplicitINotifyCallback(long j, INotifyCallback iNotifyCallback, int i, String str);

    public static final native void INotify_change_ownership(INotify iNotify, long j, boolean z);

    public static final native void INotify_director_connect(INotify iNotify, long j, boolean z, boolean z2);

    public static final native void INotify_onMsgEvent(long j, INotify iNotify, long j2, MsgVec msgVec);

    public static final native void INotify_onMsgEventSwigExplicitINotify(long j, INotify iNotify, long j2, MsgVec msgVec);

    public static final native void INotify_onMsgRevoke(long j, INotify iNotify, long j2, MessageLocator messageLocator);

    public static final native void INotify_onMsgRevokeSwigExplicitINotify(long j, INotify iNotify, long j2, MessageLocator messageLocator);

    public static final native void INotify_onMsgUpdate(long j, INotify iNotify, long j2, MsgVec msgVec);

    public static final native void INotify_onMsgUpdateSwigExplicitINotify(long j, INotify iNotify, long j2, MsgVec msgVec);

    public static final native void INotify_onRecvGroupEventTips(long j, INotify iNotify, long j2, GroupTipsElem groupTipsElem);

    public static final native void INotify_onRecvGroupEventTipsSwigExplicitINotify(long j, INotify iNotify, long j2, GroupTipsElem groupTipsElem);

    public static final native void INotify_onRecvMsgReceipt(long j, INotify iNotify, long j2, MsgReceiptVec msgReceiptVec);

    public static final native void INotify_onRecvMsgReceiptSwigExplicitINotify(long j, INotify iNotify, long j2, MsgReceiptVec msgReceiptVec);

    public static final native void INotify_onRefresh(long j, INotify iNotify);

    public static final native void INotify_onRefreshConversation(long j, INotify iNotify, long j2, SessionUUIDVec sessionUUIDVec);

    public static final native void INotify_onRefreshConversationSwigExplicitINotify(long j, INotify iNotify, long j2, SessionUUIDVec sessionUUIDVec);

    public static final native void INotify_onRefreshSwigExplicitINotify(long j, INotify iNotify);

    public static final native void INotify_onUploadProgress(long j, INotify iNotify, long j2, Msg msg, int i, int i2, int i3);

    public static final native void INotify_onUploadProgressSwigExplicitINotify(long j, INotify iNotify, long j2, Msg msg, int i, int i2, int i3);

    public static final native void IUGCUploader_change_ownership(IUGCUploader iUGCUploader, long j, boolean z);

    public static final native void IUGCUploader_director_connect(IUGCUploader iUGCUploader, long j, boolean z, boolean z2);

    public static final native void IUGCUploader_upload(long j, IUGCUploader iUGCUploader, long j2, Msg msg, int i, long j3, UGCUploadClosure uGCUploadClosure);

    public static final native String ImageElem_fileid_get(long j, ImageElem imageElem);

    public static final native void ImageElem_fileid_set(long j, ImageElem imageElem, String str);

    public static final native int ImageElem_format_get(long j, ImageElem imageElem);

    public static final native void ImageElem_format_set(long j, ImageElem imageElem, int i);

    public static final native String ImageElem_large_url_get(long j, ImageElem imageElem);

    public static final native void ImageElem_large_url_set(long j, ImageElem imageElem, String str);

    public static final native int ImageElem_level_get(long j, ImageElem imageElem);

    public static final native void ImageElem_level_set(long j, ImageElem imageElem, int i);

    public static final native String ImageElem_orig_url_get(long j, ImageElem imageElem);

    public static final native void ImageElem_orig_url_set(long j, ImageElem imageElem, String str);

    public static final native int ImageElem_pic_height_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_height_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_large_height_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_large_height_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_large_size_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_large_size_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_large_width_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_large_width_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_size_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_size_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_thumb_height_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_thumb_height_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_thumb_size_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_thumb_size_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_thumb_width_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_thumb_width_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_pic_width_get(long j, ImageElem imageElem);

    public static final native void ImageElem_pic_width_set(long j, ImageElem imageElem, int i);

    public static final native int ImageElem_taskid_get(long j, ImageElem imageElem);

    public static final native void ImageElem_taskid_set(long j, ImageElem imageElem, int i);

    public static final native String ImageElem_thumb_url_get(long j, ImageElem imageElem);

    public static final native void ImageElem_thumb_url_set(long j, ImageElem imageElem, String str);

    public static final native byte[] LocationElem_desc_get(long j, LocationElem locationElem);

    public static final native void LocationElem_desc_set(long j, LocationElem locationElem, byte[] bArr);

    public static final native double LocationElem_latitude_get(long j, LocationElem locationElem);

    public static final native void LocationElem_latitude_set(long j, LocationElem locationElem, double d2);

    public static final native double LocationElem_longitude_get(long j, LocationElem locationElem);

    public static final native void LocationElem_longitude_set(long j, LocationElem locationElem, double d2);

    public static final native void MapParserBB_fetchMapKeys(long j, MapParserBB mapParserBB, long j2, BytesMap bytesMap);

    public static final native byte[] MapParserBB_getKey(long j, MapParserBB mapParserBB, int i);

    public static final native byte[] MapParserBB_getValue(long j, MapParserBB mapParserBB, long j2, BytesMap bytesMap, int i);

    public static final native long MapParserBB_keys_get(long j, MapParserBB mapParserBB);

    public static final native void MapParserBB_keys_set(long j, MapParserBB mapParserBB, long j2, BytesVec bytesVec);

    public static final native void MapParserBCompatUint_fetchMapKeys(long j, MapParserBCompatUint mapParserBCompatUint, long j2, BytesCompatUintMap bytesCompatUintMap);

    public static final native byte[] MapParserBCompatUint_getKey(long j, MapParserBCompatUint mapParserBCompatUint, int i);

    public static final native long MapParserBCompatUint_getValue(long j, MapParserBCompatUint mapParserBCompatUint, long j2, BytesCompatUintMap bytesCompatUintMap, int i);

    public static final native long MapParserBCompatUint_keys_get(long j, MapParserBCompatUint mapParserBCompatUint);

    public static final native void MapParserBCompatUint_keys_set(long j, MapParserBCompatUint mapParserBCompatUint, long j2, BytesVec bytesVec);

    public static final native void MapParserStringMemberInfo_fetchMapKeys(long j, MapParserStringMemberInfo mapParserStringMemberInfo, long j2, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap);

    public static final native long MapParserStringMemberInfo_getKey(long j, MapParserStringMemberInfo mapParserStringMemberInfo, int i);

    public static final native long MapParserStringMemberInfo_getValue(long j, MapParserStringMemberInfo mapParserStringMemberInfo, long j2, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap, int i);

    public static final native long MapParserStringMemberInfo_keys_get(long j, MapParserStringMemberInfo mapParserStringMemberInfo);

    public static final native void MapParserStringMemberInfo_keys_set(long j, MapParserStringMemberInfo mapParserStringMemberInfo, long j2, StrVec strVec);

    public static final native void MapParserStringProfile_fetchMapKeys(long j, MapParserStringProfile mapParserStringProfile, long j2, StringProfileMap stringProfileMap);

    public static final native long MapParserStringProfile_getKey(long j, MapParserStringProfile mapParserStringProfile, int i);

    public static final native long MapParserStringProfile_getValue(long j, MapParserStringProfile mapParserStringProfile, long j2, StringProfileMap stringProfileMap, int i);

    public static final native long MapParserStringProfile_keys_get(long j, MapParserStringProfile mapParserStringProfile);

    public static final native void MapParserStringProfile_keys_set(long j, MapParserStringProfile mapParserStringProfile, long j2, StrVec strVec);

    public static final native boolean MessageLocator_isRevokedMsg_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_isRevokedMsg_set(long j, MessageLocator messageLocator, boolean z);

    public static final native boolean MessageLocator_is_self_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_is_self_set(long j, MessageLocator messageLocator, boolean z);

    public static final native long MessageLocator_rand_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_rand_set(long j, MessageLocator messageLocator, long j2);

    public static final native long MessageLocator_seq_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_seq_set(long j, MessageLocator messageLocator, long j2);

    public static final native byte[] MessageLocator_sid_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_sid_set(long j, MessageLocator messageLocator, byte[] bArr);

    public static final native long MessageLocator_time_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_time_set(long j, MessageLocator messageLocator, long j2);

    public static final native int MessageLocator_type_get(long j, MessageLocator messageLocator);

    public static final native void MessageLocator_type_set(long j, MessageLocator messageLocator, int i);

    public static final native void MsgReceiptVec_add(long j, MsgReceiptVec msgReceiptVec, long j2, MsgReceipt msgReceipt);

    public static final native long MsgReceiptVec_capacity(long j, MsgReceiptVec msgReceiptVec);

    public static final native void MsgReceiptVec_clear(long j, MsgReceiptVec msgReceiptVec);

    public static final native long MsgReceiptVec_get(long j, MsgReceiptVec msgReceiptVec, int i);

    public static final native boolean MsgReceiptVec_isEmpty(long j, MsgReceiptVec msgReceiptVec);

    public static final native void MsgReceiptVec_reserve(long j, MsgReceiptVec msgReceiptVec, long j2);

    public static final native void MsgReceiptVec_set(long j, MsgReceiptVec msgReceiptVec, int i, long j2, MsgReceipt msgReceipt);

    public static final native long MsgReceiptVec_size(long j, MsgReceiptVec msgReceiptVec);

    public static final native long MsgReceipt_sess_get(long j, MsgReceipt msgReceipt);

    public static final native void MsgReceipt_sess_set(long j, MsgReceipt msgReceipt, long j2, SessionUUID sessionUUID);

    public static final native long MsgReceipt_timestamp_get(long j, MsgReceipt msgReceipt);

    public static final native void MsgReceipt_timestamp_set(long j, MsgReceipt msgReceipt, long j2);

    public static final native void MsgVec_add(long j, MsgVec msgVec, long j2, Msg msg);

    public static final native long MsgVec_capacity(long j, MsgVec msgVec);

    public static final native void MsgVec_clear(long j, MsgVec msgVec);

    public static final native long MsgVec_get(long j, MsgVec msgVec, int i);

    public static final native boolean MsgVec_isEmpty(long j, MsgVec msgVec);

    public static final native void MsgVec_reserve(long j, MsgVec msgVec, long j2);

    public static final native void MsgVec_set(long j, MsgVec msgVec, int i, long j2, Msg msg);

    public static final native long MsgVec_size(long j, MsgVec msgVec);

    public static final native void Msg_addElem(long j, Msg msg, long j2, Elem elem);

    public static final native long Msg_cloneShared(long j, Msg msg);

    public static final native boolean Msg_copyFrom(long j, Msg msg, long j2, Msg msg2);

    public static final native long Msg_elemSize(long j, Msg msg);

    public static final native int Msg_elemType(long j, Msg msg, long j2);

    public static final native long Msg_flag(long j, Msg msg);

    public static final native long Msg_getElem(long j, Msg msg, long j2);

    public static final native byte[] Msg_getGroupName(long j, Msg msg);

    public static final native long Msg_getOfflinePushInfo(long j, Msg msg);

    public static final native int Msg_getRecvFlag(long j, Msg msg);

    public static final native String Msg_getSender(long j, Msg msg);

    public static final native long Msg_getSenderGroupMemberProfile(long j, Msg msg);

    public static final native long Msg_getSenderProfile(long j, Msg msg);

    public static final native boolean Msg_isSelf(long j, Msg msg);

    public static final native boolean Msg_isValid(long j, Msg msg);

    public static final native long Msg_lifetime(long j, Msg msg);

    public static final native byte[] Msg_msgid(long j, Msg msg);

    public static final native long Msg_newMsg__SWIG_0();

    public static final native long Msg_newMsg__SWIG_1(long j, Msg msg);

    public static final native boolean Msg_parse(long j, Msg msg, byte[] bArr);

    public static final native int Msg_priority(long j, Msg msg);

    public static final native long Msg_rand(long j, Msg msg);

    public static final native long Msg_seq(long j, Msg msg);

    public static final native byte[] Msg_serialize(long j, Msg msg);

    public static final native long Msg_session(long j, Msg msg);

    public static final native boolean Msg_setBuzCmd(long j, Msg msg, long j2, StrVec strVec);

    public static final native boolean Msg_setOfflinePushInfo(long j, Msg msg, long j2, OfflinePushInfo offlinePushInfo);

    public static final native boolean Msg_setPriority(long j, Msg msg, int i);

    public static final native int Msg_status(long j, Msg msg);

    public static final native boolean Msg_storeMsg(long j, Msg msg);

    public static final native long Msg_time(long j, Msg msg);

    public static final native long Msg_uniqueid(long j, Msg msg);

    public static final native long OfflinePushInfo_androidInfo_get(long j, OfflinePushInfo offlinePushInfo);

    public static final native void OfflinePushInfo_androidInfo_set(long j, OfflinePushInfo offlinePushInfo, long j2, AndroidOfflinePushInfo androidOfflinePushInfo);

    public static final native long OfflinePushInfo_apns_get(long j, OfflinePushInfo offlinePushInfo);

    public static final native void OfflinePushInfo_apns_set(long j, OfflinePushInfo offlinePushInfo, long j2, APNsInfo aPNsInfo);

    public static final native byte[] OfflinePushInfo_desc_get(long j, OfflinePushInfo offlinePushInfo);

    public static final native void OfflinePushInfo_desc_set(long j, OfflinePushInfo offlinePushInfo, byte[] bArr);

    public static final native byte[] OfflinePushInfo_ext_get(long j, OfflinePushInfo offlinePushInfo);

    public static final native void OfflinePushInfo_ext_set(long j, OfflinePushInfo offlinePushInfo, byte[] bArr);

    public static final native long OfflinePushInfo_flag_get(long j, OfflinePushInfo offlinePushInfo);

    public static final native void OfflinePushInfo_flag_set(long j, OfflinePushInfo offlinePushInfo, long j2);

    public static final native boolean OfflinePushInfo_isValid_get(long j, OfflinePushInfo offlinePushInfo);

    public static final native void OfflinePushInfo_isValid_set(long j, OfflinePushInfo offlinePushInfo, boolean z);

    public static final native String PROFILE_ALLOWTYPE_TAG_get();

    public static final native String PROFILE_BIRTHDAY_TAG_get();

    public static final native String PROFILE_CUSTOM_TAG_PREFIX_get();

    public static final native String PROFILE_FACEURL_TAG_get();

    public static final native String PROFILE_GENDER_TAG_get();

    public static final native String PROFILE_LANGUAGE_TAG_get();

    public static final native String PROFILE_LEVEL_TAG_get();

    public static final native String PROFILE_LOCATION_TAG_get();

    public static final native String PROFILE_NICK_TAG_get();

    public static final native String PROFILE_ROLE_TAG_get();

    public static final native String PROFILE_SELFSIGNATURE_TAG_get();

    public static final native byte[] PairSession_first_get(long j, PairSession pairSession);

    public static final native void PairSession_first_set(long j, PairSession pairSession, byte[] bArr);

    public static final native int PairSession_second_get(long j, PairSession pairSession);

    public static final native void PairSession_second_set(long j, PairSession pairSession, int i);

    public static final native void PairVectorSession_add(long j, PairVectorSession pairVectorSession, long j2, PairSession pairSession);

    public static final native long PairVectorSession_capacity(long j, PairVectorSession pairVectorSession);

    public static final native void PairVectorSession_clear(long j, PairVectorSession pairVectorSession);

    public static final native long PairVectorSession_get(long j, PairVectorSession pairVectorSession, int i);

    public static final native boolean PairVectorSession_isEmpty(long j, PairVectorSession pairVectorSession);

    public static final native void PairVectorSession_reserve(long j, PairVectorSession pairVectorSession, long j2);

    public static final native void PairVectorSession_set(long j, PairVectorSession pairVectorSession, int i, long j2, PairSession pairSession);

    public static final native long PairVectorSession_size(long j, PairVectorSession pairVectorSession);

    public static final native String ProfileChangeElem_from_get(long j, ProfileChangeElem profileChangeElem);

    public static final native void ProfileChangeElem_from_set(long j, ProfileChangeElem profileChangeElem, String str);

    public static final native byte[] ProfileChangeElem_nick_get(long j, ProfileChangeElem profileChangeElem);

    public static final native void ProfileChangeElem_nick_set(long j, ProfileChangeElem profileChangeElem, byte[] bArr);

    public static final native long ProfileChangeElem_type_get(long j, ProfileChangeElem profileChangeElem);

    public static final native void ProfileChangeElem_type_set(long j, ProfileChangeElem profileChangeElem, long j2);

    public static final native void RunClosure_release(long j, RunClosure runClosure);

    public static final native void RunClosure_run(long j, RunClosure runClosure);

    public static final native String SNS_CUSTOM_TAG_PREFIX_get();

    public static final native String SNS_GROUP_TAG_get();

    public static final native String SNS_PENDENCY_ADD_SOURCE_TAG_get();

    public static final native String SNS_PENDENCY_ADD_WORDING_TAG_get();

    public static final native String SNS_RECOMMEND_1_TAG_get();

    public static final native String SNS_RECOMMEND_2_TAG_get();

    public static final native String SNS_RECOMMEND_3_TAG_get();

    public static final native String SNS_REMARK_TAG_get();

    public static final native void SdkReportItem_beginEvent(long j, SdkReportItem sdkReportItem);

    public static final native int SdkReportItem_code_get(long j, SdkReportItem sdkReportItem);

    public static final native void SdkReportItem_code_set(long j, SdkReportItem sdkReportItem, int i);

    public static final native byte[] SdkReportItem_desc_get(long j, SdkReportItem sdkReportItem);

    public static final native void SdkReportItem_desc_set(long j, SdkReportItem sdkReportItem, byte[] bArr);

    public static final native void SdkReportItem_endEvent(long j, SdkReportItem sdkReportItem);

    public static final native long SdkReportItem_end_time_ms_get(long j, SdkReportItem sdkReportItem);

    public static final native void SdkReportItem_end_time_ms_set(long j, SdkReportItem sdkReportItem, long j2);

    public static final native int SdkReportItem_event_get(long j, SdkReportItem sdkReportItem);

    public static final native void SdkReportItem_event_set(long j, SdkReportItem sdkReportItem, int i);

    public static final native long SdkReportItem_start_time_ms_get(long j, SdkReportItem sdkReportItem);

    public static final native void SdkReportItem_start_time_ms_set(long j, SdkReportItem sdkReportItem, long j2);

    public static final native void SessionUUIDVec_add(long j, SessionUUIDVec sessionUUIDVec, long j2, SessionUUID sessionUUID);

    public static final native long SessionUUIDVec_capacity(long j, SessionUUIDVec sessionUUIDVec);

    public static final native void SessionUUIDVec_clear(long j, SessionUUIDVec sessionUUIDVec);

    public static final native long SessionUUIDVec_get(long j, SessionUUIDVec sessionUUIDVec, int i);

    public static final native boolean SessionUUIDVec_isEmpty(long j, SessionUUIDVec sessionUUIDVec);

    public static final native void SessionUUIDVec_reserve(long j, SessionUUIDVec sessionUUIDVec, long j2);

    public static final native void SessionUUIDVec_set(long j, SessionUUIDVec sessionUUIDVec, int i, long j2, SessionUUID sessionUUID);

    public static final native long SessionUUIDVec_size(long j, SessionUUIDVec sessionUUIDVec);

    public static final native String SessionUUID_sid_get(long j, SessionUUID sessionUUID);

    public static final native void SessionUUID_sid_set(long j, SessionUUID sessionUUID, String str);

    public static final native int SessionUUID_type_get(long j, SessionUUID sessionUUID);

    public static final native void SessionUUID_type_set(long j, SessionUUID sessionUUID, int i);

    public static final native long Session_activeTime(long j, Session session);

    public static final native long Session_cloneShared(long j, Session session);

    public static final native String Session_iconUrl(long j, Session session);

    public static final native String Session_identifier(long j, Session session);

    public static final native boolean Session_isValid(long j, Session session);

    public static final native String Session_name(long j, Session session);

    public static final native void Session_sendCustomMsg(long j, Session session, long j2, Msg msg, long j3, INotifyCallback iNotifyCallback, long j4);

    public static final native void Session_sendMsg(long j, Session session, long j2, Msg msg, long j3, INotifyCallback iNotifyCallback);

    public static final native String Session_sid(long j, Session session);

    public static final native int Session_type(long j, Session session);

    public static final native String SetProfileOption_add_option_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_add_option_set(long j, SetProfileOption setProfileOption, String str);

    public static final native long SetProfileOption_birthday_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_birthday_set(long j, SetProfileOption setProfileOption, long j2);

    public static final native long SetProfileOption_custom_info_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_custom_info_set(long j, SetProfileOption setProfileOption, long j2, BytesMap bytesMap);

    public static final native long SetProfileOption_custom_info_uint_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_custom_info_uint_set(long j, SetProfileOption setProfileOption, long j2, BytesCompatUintMap bytesCompatUintMap);

    public static final native byte[] SetProfileOption_face_url_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_face_url_set(long j, SetProfileOption setProfileOption, byte[] bArr);

    public static final native long SetProfileOption_flag_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_flag_set(long j, SetProfileOption setProfileOption, long j2);

    public static final native int SetProfileOption_gender_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_gender_set(long j, SetProfileOption setProfileOption, int i);

    public static final native long SetProfileOption_language_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_language_set(long j, SetProfileOption setProfileOption, long j2);

    public static final native long SetProfileOption_level_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_level_set(long j, SetProfileOption setProfileOption, long j2);

    public static final native byte[] SetProfileOption_location_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_location_set(long j, SetProfileOption setProfileOption, byte[] bArr);

    public static final native byte[] SetProfileOption_nick_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_nick_set(long j, SetProfileOption setProfileOption, byte[] bArr);

    public static final native long SetProfileOption_role_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_role_set(long j, SetProfileOption setProfileOption, long j2);

    public static final native byte[] SetProfileOption_self_signature_get(long j, SetProfileOption setProfileOption);

    public static final native void SetProfileOption_self_signature_set(long j, SetProfileOption setProfileOption, byte[] bArr);

    public static final native int SoundElem_business_id_get(long j, SoundElem soundElem);

    public static final native void SoundElem_business_id_set(long j, SoundElem soundElem, int i);

    public static final native int SoundElem_download_flag_get(long j, SoundElem soundElem);

    public static final native void SoundElem_download_flag_set(long j, SoundElem soundElem, int i);

    public static final native byte[] SoundElem_file_path_get(long j, SoundElem soundElem);

    public static final native void SoundElem_file_path_set(long j, SoundElem soundElem, byte[] bArr);

    public static final native int SoundElem_file_size_get(long j, SoundElem soundElem);

    public static final native void SoundElem_file_size_set(long j, SoundElem soundElem, int i);

    public static final native int SoundElem_file_time_get(long j, SoundElem soundElem);

    public static final native void SoundElem_file_time_set(long j, SoundElem soundElem, int i);

    public static final native String SoundElem_fileid_get(long j, SoundElem soundElem);

    public static final native void SoundElem_fileid_set(long j, SoundElem soundElem, String str);

    public static final native int SoundElem_taskid_get(long j, SoundElem soundElem);

    public static final native void SoundElem_taskid_set(long j, SoundElem soundElem, int i);

    public static final native long SoundElem_urls_get(long j, SoundElem soundElem);

    public static final native void SoundElem_urls_set(long j, SoundElem soundElem, long j2, StrVec strVec);

    public static final native void StrVec_add(long j, StrVec strVec, String str);

    public static final native long StrVec_capacity(long j, StrVec strVec);

    public static final native void StrVec_clear(long j, StrVec strVec);

    public static final native String StrVec_get(long j, StrVec strVec, int i);

    public static final native boolean StrVec_isEmpty(long j, StrVec strVec);

    public static final native void StrVec_reserve(long j, StrVec strVec, long j2);

    public static final native void StrVec_set(long j, StrVec strVec, int i, String str);

    public static final native long StrVec_size(long j, StrVec strVec);

    public static final native void StringGroupTipsMemberInfoMap_clear(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap);

    public static final native void StringGroupTipsMemberInfoMap_del(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap, String str);

    public static final native boolean StringGroupTipsMemberInfoMap_empty(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap);

    public static final native long StringGroupTipsMemberInfoMap_get(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap, String str);

    public static final native boolean StringGroupTipsMemberInfoMap_hasKey(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap, String str);

    public static final native void StringGroupTipsMemberInfoMap_set(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap, String str, long j2, GroupTipsMemberInfo groupTipsMemberInfo);

    public static final native long StringGroupTipsMemberInfoMap_size(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap);

    public static final native void StringProfileMap_clear(long j, StringProfileMap stringProfileMap);

    public static final native void StringProfileMap_del(long j, StringProfileMap stringProfileMap, String str);

    public static final native boolean StringProfileMap_empty(long j, StringProfileMap stringProfileMap);

    public static final native long StringProfileMap_get(long j, StringProfileMap stringProfileMap, String str);

    public static final native boolean StringProfileMap_hasKey(long j, StringProfileMap stringProfileMap, String str);

    public static final native void StringProfileMap_set(long j, StringProfileMap stringProfileMap, String str, long j2, FriendProfile friendProfile);

    public static final native long StringProfileMap_size(long j, StringProfileMap stringProfileMap);

    public static void SwigDirector_IApplyDownloadFileCallback_done(IApplyDownloadFileCallback iApplyDownloadFileCallback, long j) {
        iApplyDownloadFileCallback.done(new StrVec(j, false));
    }

    public static void SwigDirector_IApplyDownloadFileCallback_fail(IApplyDownloadFileCallback iApplyDownloadFileCallback, int i, String str) {
        iApplyDownloadFileCallback.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithProfileVec_done(ICallbackWithProfileVec iCallbackWithProfileVec, long j) {
        iCallbackWithProfileVec.done(new FriendProfileVec(j, false));
    }

    public static void SwigDirector_ICallbackWithProfileVec_fail(ICallbackWithProfileVec iCallbackWithProfileVec, int i, String str) {
        iCallbackWithProfileVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithStrVec_done(ICallbackWithStrVec iCallbackWithStrVec, long j) {
        iCallbackWithStrVec.done(new StrVec(j, false));
    }

    public static void SwigDirector_ICallbackWithStrVec_fail(ICallbackWithStrVec iCallbackWithStrVec, int i, String str) {
        iCallbackWithStrVec.fail(i, str);
    }

    public static void SwigDirector_ICallbackWithString_done(ICallbackWithString iCallbackWithString, String str) {
        iCallbackWithString.done(str);
    }

    public static void SwigDirector_ICallbackWithString_fail(ICallbackWithString iCallbackWithString, int i, String str) {
        iCallbackWithString.fail(i, str);
    }

    public static boolean SwigDirector_IEnv_createThread(IEnv iEnv, long j) {
        return iEnv.createThread(j == 0 ? null : new ThreadEntry(j, true));
    }

    public static boolean SwigDirector_IEnv_httpRequest(IEnv iEnv, String str, int i, String str2, byte[] bArr, long j) {
        return iEnv.httpRequest(str, HttpMethod.swigToEnum(i), str2, bArr, j == 0 ? null : new EnvRequestClosure(j, false));
    }

    public static boolean SwigDirector_IEnv_runOnMainThread(IEnv iEnv, long j) {
        return iEnv.runOnMainThread(j == 0 ? null : new RunClosure(j, true));
    }

    public static boolean SwigDirector_IEnv_sSORequest__SWIG_0(IEnv iEnv, String str, String str2, byte[] bArr, long j, long j2) {
        long j3 = j;
        return iEnv.sSORequest(str, str2, bArr, j3 == 0 ? null : new EnvRequestClosure(j3, false), j2);
    }

    public static boolean SwigDirector_IEnv_sSORequest__SWIG_1(IEnv iEnv, String str, String str2, byte[] bArr, long j) {
        return iEnv.sSORequest(str, str2, bArr, j == 0 ? null : new EnvRequestClosure(j, false));
    }

    public static boolean SwigDirector_IEnv_uploadLogFile(IEnv iEnv, String str, long j) {
        return iEnv.uploadLogFile(str, new UploadLogFileOpt(j, false));
    }

    public static void SwigDirector_IImageUploadCallback_done(IImageUploadCallback iImageUploadCallback, long j) {
        iImageUploadCallback.done(new ImageElem(j, false));
    }

    public static void SwigDirector_IImageUploadCallback_fail(IImageUploadCallback iImageUploadCallback, int i, String str) {
        iImageUploadCallback.fail(i, str);
    }

    public static void SwigDirector_ILogMsgCallback_onLogMsg(ILogMsgCallback iLogMsgCallback, String str, int i, String str2) {
        iLogMsgCallback.onLogMsg(str, LogLevel.swigToEnum(i), str2);
    }

    public static void SwigDirector_INotifyCallback_done(INotifyCallback iNotifyCallback) {
        iNotifyCallback.done();
    }

    public static void SwigDirector_INotifyCallback_fail(INotifyCallback iNotifyCallback, int i, String str) {
        iNotifyCallback.fail(i, str);
    }

    public static void SwigDirector_INotify_onMsgEvent(INotify iNotify, long j) {
        iNotify.onMsgEvent(new MsgVec(j, false));
    }

    public static void SwigDirector_INotify_onMsgRevoke(INotify iNotify, long j) {
        iNotify.onMsgRevoke(new MessageLocator(j, false));
    }

    public static void SwigDirector_INotify_onMsgUpdate(INotify iNotify, long j) {
        iNotify.onMsgUpdate(new MsgVec(j, false));
    }

    public static void SwigDirector_INotify_onRecvGroupEventTips(INotify iNotify, long j) {
        iNotify.onRecvGroupEventTips(new GroupTipsElem(j, false));
    }

    public static void SwigDirector_INotify_onRecvMsgReceipt(INotify iNotify, long j) {
        iNotify.onRecvMsgReceipt(new MsgReceiptVec(j, false));
    }

    public static void SwigDirector_INotify_onRefresh(INotify iNotify) {
        iNotify.onRefresh();
    }

    public static void SwigDirector_INotify_onRefreshConversation(INotify iNotify, long j) {
        iNotify.onRefreshConversation(new SessionUUIDVec(j, false));
    }

    public static void SwigDirector_INotify_onUploadProgress(INotify iNotify, long j, int i, int i2, int i3) {
        iNotify.onUploadProgress(new Msg(j, false), i, i2, i3);
    }

    public static void SwigDirector_IUGCUploader_upload(IUGCUploader iUGCUploader, long j, int i, long j2) {
        iUGCUploader.upload(new Msg(j, false), i, j2 == 0 ? null : new UGCUploadClosure(j2, false));
    }

    public static final native byte[] TextElem_content_get(long j, TextElem textElem);

    public static final native void TextElem_content_set(long j, TextElem textElem, byte[] bArr);

    public static final native void ThreadEntry_release(long j, ThreadEntry threadEntry);

    public static final native void ThreadEntry_run(long j, ThreadEntry threadEntry);

    public static final native int UGCElem_cover_height_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_cover_height_set(long j, UGCElem uGCElem, int i);

    public static final native byte[] UGCElem_cover_path_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_cover_path_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native int UGCElem_cover_size_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_cover_size_set(long j, UGCElem uGCElem, int i);

    public static final native byte[] UGCElem_cover_type_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_cover_type_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native byte[] UGCElem_cover_url_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_cover_url_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native int UGCElem_cover_width_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_cover_width_set(long j, UGCElem uGCElem, int i);

    public static final native byte[] UGCElem_file_id_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_file_id_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native int UGCElem_video_duration_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_video_duration_set(long j, UGCElem uGCElem, int i);

    public static final native byte[] UGCElem_video_path_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_video_path_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native int UGCElem_video_size_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_video_size_set(long j, UGCElem uGCElem, int i);

    public static final native byte[] UGCElem_video_type_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_video_type_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native byte[] UGCElem_video_url_get(long j, UGCElem uGCElem);

    public static final native void UGCElem_video_url_set(long j, UGCElem uGCElem, byte[] bArr);

    public static final native void UGCUploadClosure_done(long j, UGCUploadClosure uGCUploadClosure, String str, String str2, String str3);

    public static final native void UGCUploadClosure_fail(long j, UGCUploadClosure uGCUploadClosure, int i, String str);

    public static final native void UGCUploadClosure_release(long j, UGCUploadClosure uGCUploadClosure);

    public static final native String UploadLogFileOpt_filePath_get(long j, UploadLogFileOpt uploadLogFileOpt);

    public static final native void UploadLogFileOpt_filePath_set(long j, UploadLogFileOpt uploadLogFileOpt, String str);

    public static final native byte[] UploadLogFileOpt_logId_get(long j, UploadLogFileOpt uploadLogFileOpt);

    public static final native void UploadLogFileOpt_logId_set(long j, UploadLogFileOpt uploadLogFileOpt, byte[] bArr);

    public static final native long UploadLogFileOpt_logSize_get(long j, UploadLogFileOpt uploadLogFileOpt);

    public static final native void UploadLogFileOpt_logSize_set(long j, UploadLogFileOpt uploadLogFileOpt, long j2);

    public static final native byte[] UploadLogFileOpt_relativePath_get(long j, UploadLogFileOpt uploadLogFileOpt);

    public static final native void UploadLogFileOpt_relativePath_set(long j, UploadLogFileOpt uploadLogFileOpt, byte[] bArr);

    public static final native String UploadLogFileOpt_tag_get(long j, UploadLogFileOpt uploadLogFileOpt);

    public static final native void UploadLogFileOpt_tag_set(long j, UploadLogFileOpt uploadLogFileOpt, String str);

    public static final native String UploadLogFileOpt_toString(long j, UploadLogFileOpt uploadLogFileOpt);

    public static final native String UserConfig_account_type_get(long j, UserConfig userConfig);

    public static final native void UserConfig_account_type_set(long j, UserConfig userConfig, String str);

    public static final native String UserConfig_appid3rd_get(long j, UserConfig userConfig);

    public static final native void UserConfig_appid3rd_set(long j, UserConfig userConfig, String str);

    public static final native boolean UserConfig_auto_report_get(long j, UserConfig userConfig);

    public static final native void UserConfig_auto_report_set(long j, UserConfig userConfig, boolean z);

    public static final native long UserConfig_fm_ext_get(long j, UserConfig userConfig);

    public static final native void UserConfig_fm_ext_set(long j, UserConfig userConfig, long j2);

    public static final native long UserConfig_friend_profile_opt_get(long j, UserConfig userConfig);

    public static final native void UserConfig_friend_profile_opt_set(long j, UserConfig userConfig, long j2, FriendProfileInfoOpt friendProfileInfoOpt);

    public static final native boolean UserConfig_friendship_proxy_get(long j, UserConfig userConfig);

    public static final native void UserConfig_friendship_proxy_set(long j, UserConfig userConfig, boolean z);

    public static final native boolean UserConfig_group_assistant_get(long j, UserConfig userConfig);

    public static final native void UserConfig_group_assistant_set(long j, UserConfig userConfig, boolean z);

    public static final native long UserConfig_group_info_opt_get(long j, UserConfig userConfig);

    public static final native void UserConfig_group_info_opt_set(long j, UserConfig userConfig, long j2, GroupInfoOpt groupInfoOpt);

    public static final native long UserConfig_group_member_info_opt_get(long j, UserConfig userConfig);

    public static final native void UserConfig_group_member_info_opt_set(long j, UserConfig userConfig, long j2, GroupMemberInfoOpt groupMemberInfoOpt);

    public static final native long UserConfig_grp_ext_get(long j, UserConfig userConfig);

    public static final native void UserConfig_grp_ext_set(long j, UserConfig userConfig, long j2);

    public static final native String UserConfig_identifier_get(long j, UserConfig userConfig);

    public static final native void UserConfig_identifier_set(long j, UserConfig userConfig, String str);

    public static final native long UserConfig_mm_ext_get(long j, UserConfig userConfig);

    public static final native void UserConfig_mm_ext_set(long j, UserConfig userConfig, long j2);

    public static final native long UserConfig_notify_get(long j, UserConfig userConfig);

    public static final native void UserConfig_notify_set(long j, UserConfig userConfig, long j2, INotify iNotify);

    public static final native boolean UserConfig_read_receipt_get(long j, UserConfig userConfig);

    public static final native void UserConfig_read_receipt_set(long j, UserConfig userConfig, boolean z);

    public static final native boolean UserConfig_recent_contact_get(long j, UserConfig userConfig);

    public static final native boolean UserConfig_recent_contact_notify_get(long j, UserConfig userConfig);

    public static final native void UserConfig_recent_contact_notify_set(long j, UserConfig userConfig, boolean z);

    public static final native void UserConfig_recent_contact_set(long j, UserConfig userConfig, boolean z);

    public static final native long UserConfig_sdk_appid_get(long j, UserConfig userConfig);

    public static final native void UserConfig_sdk_appid_set(long j, UserConfig userConfig, long j2);

    public static final native boolean UserConfig_storage_get(long j, UserConfig userConfig);

    public static final native void UserConfig_storage_set(long j, UserConfig userConfig, boolean z);

    public static final native String UserConfig_tinyid_get(long j, UserConfig userConfig);

    public static final native void UserConfig_tinyid_set(long j, UserConfig userConfig, String str);

    public static final native long UserConfig_ugc_uploader_get(long j, UserConfig userConfig);

    public static final native void UserConfig_ugc_uploader_set(long j, UserConfig userConfig, long j2, IUGCUploader iUGCUploader);

    public static final native long UserConfig_utinyid_get(long j, UserConfig userConfig);

    public static final native void UserConfig_utinyid_set(long j, UserConfig userConfig, long j2);

    public static final native byte[] VecParserB_get(long j, VecParserB vecParserB, int i);

    public static final native long VecParserB_values_get(long j, VecParserB vecParserB);

    public static final native void VecParserB_values_set(long j, VecParserB vecParserB, long j2, BytesVec bytesVec);

    public static final native int VideoElem_business_id_get(long j, VideoElem videoElem);

    public static final native void VideoElem_business_id_set(long j, VideoElem videoElem, int i);

    public static final native byte[] VideoElem_imageId_get(long j, VideoElem videoElem);

    public static final native void VideoElem_imageId_set(long j, VideoElem videoElem, byte[] bArr);

    public static final native int VideoElem_image_download_flag_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_download_flag_set(long j, VideoElem videoElem, int i);

    public static final native long VideoElem_image_height_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_height_set(long j, VideoElem videoElem, long j2);

    public static final native byte[] VideoElem_image_path_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_path_set(long j, VideoElem videoElem, byte[] bArr);

    public static final native long VideoElem_image_size_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_size_set(long j, VideoElem videoElem, long j2);

    public static final native byte[] VideoElem_image_type_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_type_set(long j, VideoElem videoElem, byte[] bArr);

    public static final native long VideoElem_image_urls_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_urls_set(long j, VideoElem videoElem, long j2, StrVec strVec);

    public static final native long VideoElem_image_width_get(long j, VideoElem videoElem);

    public static final native void VideoElem_image_width_set(long j, VideoElem videoElem, long j2);

    public static final native long VideoElem_taskid_get(long j, VideoElem videoElem);

    public static final native void VideoElem_taskid_set(long j, VideoElem videoElem, long j2);

    public static final native byte[] VideoElem_videoId_get(long j, VideoElem videoElem);

    public static final native void VideoElem_videoId_set(long j, VideoElem videoElem, byte[] bArr);

    public static final native int VideoElem_video_download_flag_get(long j, VideoElem videoElem);

    public static final native void VideoElem_video_download_flag_set(long j, VideoElem videoElem, int i);

    public static final native long VideoElem_video_duration_get(long j, VideoElem videoElem);

    public static final native void VideoElem_video_duration_set(long j, VideoElem videoElem, long j2);

    public static final native byte[] VideoElem_video_path_get(long j, VideoElem videoElem);

    public static final native void VideoElem_video_path_set(long j, VideoElem videoElem, byte[] bArr);

    public static final native long VideoElem_video_size_get(long j, VideoElem videoElem);

    public static final native void VideoElem_video_size_set(long j, VideoElem videoElem, long j2);

    public static final native byte[] VideoElem_video_type_get(long j, VideoElem videoElem);

    public static final native void VideoElem_video_type_set(long j, VideoElem videoElem, byte[] bArr);

    public static final native long VideoElem_video_urls_get(long j, VideoElem videoElem);

    public static final native void VideoElem_video_urls_set(long j, VideoElem videoElem, long j2, StrVec strVec);

    public static final native void delete_APNsInfo(long j);

    public static final native void delete_AndroidOfflinePushInfo(long j);

    public static final native void delete_ApplyDownloadFileReq(long j);

    public static final native void delete_BytesCompatUintMap(long j);

    public static final native void delete_BytesMap(long j);

    public static final native void delete_BytesVec(long j);

    public static final native void delete_CompatUint64(long j);

    public static final native void delete_Context(long j);

    public static final native void delete_CreateGroupParams(long j);

    public static final native void delete_CustomElem(long j);

    public static final native void delete_DeviceId(long j);

    public static final native void delete_Elem(long j);

    public static final native void delete_ElemVec(long j);

    public static final native void delete_EnvRequestClosure(long j);

    public static final native void delete_FaceElem(long j);

    public static final native void delete_FileElem(long j);

    public static final native void delete_FriendChangeElem(long j);

    public static final native void delete_FriendChangeInfoVec(long j);

    public static final native void delete_FriendChangeUserInfo(long j);

    public static final native void delete_FriendProfile(long j);

    public static final native void delete_FriendProfileInfoOpt(long j);

    public static final native void delete_FriendProfileVec(long j);

    public static final native void delete_FriendshipManager(long j);

    public static final native void delete_GroupInfoOpt(long j);

    public static final native void delete_GroupManager(long j);

    public static final native void delete_GroupMemberInfoOpt(long j);

    public static final native void delete_GroupReportElem(long j);

    public static final native void delete_GroupTipsElem(long j);

    public static final native void delete_GroupTipsElem_GroupInfo(long j);

    public static final native void delete_GroupTipsElem_GroupInfoVec(long j);

    public static final native void delete_GroupTipsElem_MemberInfo(long j);

    public static final native void delete_GroupTipsElem_MemberInfoVec(long j);

    public static final native void delete_GroupTipsMemberInfo(long j);

    public static final native void delete_GroupTipsMemberInfoVec(long j);

    public static final native void delete_IApplyDownloadFileCallback(long j);

    public static final native void delete_ICallbackWithProfileVec(long j);

    public static final native void delete_ICallbackWithStrVec(long j);

    public static final native void delete_ICallbackWithString(long j);

    public static final native void delete_IEnv(long j);

    public static final native void delete_IImageUploadCallback(long j);

    public static final native void delete_ILogMsgCallback(long j);

    public static final native void delete_IMCoreUser(long j);

    public static final native void delete_INotify(long j);

    public static final native void delete_INotifyCallback(long j);

    public static final native void delete_IUGCUploader(long j);

    public static final native void delete_ImageElem(long j);

    public static final native void delete_LocationElem(long j);

    public static final native void delete_MapParserBB(long j);

    public static final native void delete_MapParserBCompatUint(long j);

    public static final native void delete_MapParserStringMemberInfo(long j);

    public static final native void delete_MapParserStringProfile(long j);

    public static final native void delete_MessageLocator(long j);

    public static final native void delete_Msg(long j);

    public static final native void delete_MsgReceipt(long j);

    public static final native void delete_MsgReceiptVec(long j);

    public static final native void delete_MsgVec(long j);

    public static final native void delete_OfflinePushInfo(long j);

    public static final native void delete_PairSession(long j);

    public static final native void delete_PairVectorSession(long j);

    public static final native void delete_ProfileChangeElem(long j);

    public static final native void delete_RunClosure(long j);

    public static final native void delete_SdkReportItem(long j);

    public static final native void delete_Session(long j);

    public static final native void delete_SessionUUID(long j);

    public static final native void delete_SessionUUIDVec(long j);

    public static final native void delete_SetProfileOption(long j);

    public static final native void delete_SoundElem(long j);

    public static final native void delete_StrVec(long j);

    public static final native void delete_StringGroupTipsMemberInfoMap(long j);

    public static final native void delete_StringProfileMap(long j);

    public static final native void delete_TextElem(long j);

    public static final native void delete_ThreadEntry(long j);

    public static final native void delete_UGCElem(long j);

    public static final native void delete_UGCUploadClosure(long j);

    public static final native void delete_UploadLogFileOpt(long j);

    public static final native void delete_UserConfig(long j);

    public static final native void delete_VecParserB(long j);

    public static final native void delete_VideoElem(long j);

    public static final native String friendGender2str(int i);

    public static final native long getProfileCustomInfoElemUint(byte[] bArr, long j);

    public static final native long new_APNsInfo();

    public static final native long new_AndroidOfflinePushInfo();

    public static final native long new_ApplyDownloadFileReq();

    public static final native long new_BytesCompatUintMap__SWIG_0();

    public static final native long new_BytesCompatUintMap__SWIG_1(long j, BytesCompatUintMap bytesCompatUintMap);

    public static final native long new_BytesMap__SWIG_0();

    public static final native long new_BytesMap__SWIG_1(long j, BytesMap bytesMap);

    public static final native long new_BytesVec__SWIG_0();

    public static final native long new_BytesVec__SWIG_1(long j);

    public static final native long new_CompatUint64();

    public static final native long new_Context();

    public static final native long new_CreateGroupParams();

    public static final native long new_CustomElem();

    public static final native long new_DeviceId();

    public static final native long new_Elem();

    public static final native long new_ElemVec__SWIG_0();

    public static final native long new_ElemVec__SWIG_1(long j);

    public static final native long new_FaceElem();

    public static final native long new_FileElem();

    public static final native long new_FriendChangeElem();

    public static final native long new_FriendChangeInfoVec__SWIG_0();

    public static final native long new_FriendChangeInfoVec__SWIG_1(long j);

    public static final native long new_FriendChangeUserInfo();

    public static final native long new_FriendProfile();

    public static final native long new_FriendProfileInfoOpt();

    public static final native long new_FriendProfileVec__SWIG_0();

    public static final native long new_FriendProfileVec__SWIG_1(long j);

    public static final native long new_FriendshipManager(String str);

    public static final native long new_GroupInfoOpt();

    public static final native long new_GroupManager(String str);

    public static final native long new_GroupMemberInfoOpt();

    public static final native long new_GroupReportElem();

    public static final native long new_GroupTipsElem();

    public static final native long new_GroupTipsElem_GroupInfo();

    public static final native long new_GroupTipsElem_GroupInfoVec__SWIG_0();

    public static final native long new_GroupTipsElem_GroupInfoVec__SWIG_1(long j);

    public static final native long new_GroupTipsElem_MemberInfo();

    public static final native long new_GroupTipsElem_MemberInfoVec__SWIG_0();

    public static final native long new_GroupTipsElem_MemberInfoVec__SWIG_1(long j);

    public static final native long new_GroupTipsMemberInfo();

    public static final native long new_GroupTipsMemberInfoVec__SWIG_0();

    public static final native long new_GroupTipsMemberInfoVec__SWIG_1(long j);

    public static final native long new_IApplyDownloadFileCallback();

    public static final native long new_ICallbackWithProfileVec();

    public static final native long new_ICallbackWithStrVec();

    public static final native long new_ICallbackWithString();

    public static final native long new_IEnv();

    public static final native long new_IImageUploadCallback();

    public static final native long new_ILogMsgCallback();

    public static final native long new_INotify();

    public static final native long new_INotifyCallback();

    public static final native long new_IUGCUploader();

    public static final native long new_ImageElem();

    public static final native long new_LocationElem();

    public static final native long new_MapParserBB();

    public static final native long new_MapParserBCompatUint();

    public static final native long new_MapParserStringMemberInfo();

    public static final native long new_MapParserStringProfile();

    public static final native long new_MessageLocator();

    public static final native long new_MsgReceipt();

    public static final native long new_MsgReceiptVec__SWIG_0();

    public static final native long new_MsgReceiptVec__SWIG_1(long j);

    public static final native long new_MsgVec__SWIG_0();

    public static final native long new_MsgVec__SWIG_1(long j);

    public static final native long new_Msg__SWIG_0();

    public static final native long new_Msg__SWIG_1(long j);

    public static final native long new_OfflinePushInfo();

    public static final native long new_PairSession__SWIG_0();

    public static final native long new_PairSession__SWIG_1(byte[] bArr, int i);

    public static final native long new_PairSession__SWIG_2(long j, PairSession pairSession);

    public static final native long new_PairVectorSession__SWIG_0();

    public static final native long new_PairVectorSession__SWIG_1(long j);

    public static final native long new_ProfileChangeElem();

    public static final native long new_SdkReportItem();

    public static final native long new_Session();

    public static final native long new_SessionUUID();

    public static final native long new_SessionUUIDVec__SWIG_0();

    public static final native long new_SessionUUIDVec__SWIG_1(long j);

    public static final native long new_SetProfileOption();

    public static final native long new_SoundElem();

    public static final native long new_StrVec__SWIG_0();

    public static final native long new_StrVec__SWIG_1(long j);

    public static final native long new_StringGroupTipsMemberInfoMap__SWIG_0();

    public static final native long new_StringGroupTipsMemberInfoMap__SWIG_1(long j, StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap);

    public static final native long new_StringProfileMap__SWIG_0();

    public static final native long new_StringProfileMap__SWIG_1(long j, StringProfileMap stringProfileMap);

    public static final native long new_TextElem();

    public static final native long new_UGCElem();

    public static final native long new_UploadLogFileOpt();

    public static final native long new_UserConfig();

    public static final native long new_VecParserB(long j, BytesVec bytesVec);

    public static final native long new_VideoElem();

    public static final native int str2FriendGender(String str);

    private static final native void swig_module_init();
}
