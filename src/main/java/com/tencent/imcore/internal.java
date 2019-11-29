package com.tencent.imcore;

public class internal implements internalConstants {
    public static String friendGender2str(FriendGenderType friendGenderType) {
        return internalJNI.friendGender2str(friendGenderType.swigValue());
    }

    public static String getPROFILE_ALLOWTYPE_TAG() {
        return internalJNI.PROFILE_ALLOWTYPE_TAG_get();
    }

    public static String getPROFILE_BIRTHDAY_TAG() {
        return internalJNI.PROFILE_BIRTHDAY_TAG_get();
    }

    public static String getPROFILE_CUSTOM_TAG_PREFIX() {
        return internalJNI.PROFILE_CUSTOM_TAG_PREFIX_get();
    }

    public static String getPROFILE_FACEURL_TAG() {
        return internalJNI.PROFILE_FACEURL_TAG_get();
    }

    public static String getPROFILE_GENDER_TAG() {
        return internalJNI.PROFILE_GENDER_TAG_get();
    }

    public static String getPROFILE_LANGUAGE_TAG() {
        return internalJNI.PROFILE_LANGUAGE_TAG_get();
    }

    public static String getPROFILE_LEVEL_TAG() {
        return internalJNI.PROFILE_LEVEL_TAG_get();
    }

    public static String getPROFILE_LOCATION_TAG() {
        return internalJNI.PROFILE_LOCATION_TAG_get();
    }

    public static String getPROFILE_NICK_TAG() {
        return internalJNI.PROFILE_NICK_TAG_get();
    }

    public static String getPROFILE_ROLE_TAG() {
        return internalJNI.PROFILE_ROLE_TAG_get();
    }

    public static String getPROFILE_SELFSIGNATURE_TAG() {
        return internalJNI.PROFILE_SELFSIGNATURE_TAG_get();
    }

    public static SWIGTYPE_p_std__pairT_std__string_imcore__CompatUint64_t getProfileCustomInfoElemUint(byte[] bArr, long j) {
        return new SWIGTYPE_p_std__pairT_std__string_imcore__CompatUint64_t(internalJNI.getProfileCustomInfoElemUint(bArr, j), true);
    }

    public static String getSNS_CUSTOM_TAG_PREFIX() {
        return internalJNI.SNS_CUSTOM_TAG_PREFIX_get();
    }

    public static String getSNS_GROUP_TAG() {
        return internalJNI.SNS_GROUP_TAG_get();
    }

    public static String getSNS_PENDENCY_ADD_SOURCE_TAG() {
        return internalJNI.SNS_PENDENCY_ADD_SOURCE_TAG_get();
    }

    public static String getSNS_PENDENCY_ADD_WORDING_TAG() {
        return internalJNI.SNS_PENDENCY_ADD_WORDING_TAG_get();
    }

    public static String getSNS_RECOMMEND_1_TAG() {
        return internalJNI.SNS_RECOMMEND_1_TAG_get();
    }

    public static String getSNS_RECOMMEND_2_TAG() {
        return internalJNI.SNS_RECOMMEND_2_TAG_get();
    }

    public static String getSNS_RECOMMEND_3_TAG() {
        return internalJNI.SNS_RECOMMEND_3_TAG_get();
    }

    public static String getSNS_REMARK_TAG() {
        return internalJNI.SNS_REMARK_TAG_get();
    }

    public static FriendGenderType str2FriendGender(String str) {
        return FriendGenderType.swigToEnum(internalJNI.str2FriendGender(str));
    }
}
