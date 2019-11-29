package com.tencent.imsdk.ext.sns;

public enum TIMFriendStatus {
    TIM_FRIEND_STATUS_UNKNOWN(-1),
    TIM_FRIEND_STATUS_SUCC(0),
    TIM_ADD_FRIEND_STATUS_IN_SELF_BLACK_LIST(30515),
    TIM_ADD_FRIEND_STATUS_FRIEND_SIDE_FORBID_ADD(30516),
    TIM_ADD_FRIEND_STATUS_SELF_FRIEND_FULL(30519),
    TIM_ADD_FRIEND_STATUS_ALREADY_FRIEND(30520),
    TIM_ADD_FRIEND_STATUS_IN_OTHER_SIDE_BLACK_LIST(30525),
    TIM_ADD_FRIEND_STATUS_PENDING(30539),
    TIM_DEL_FRIEND_STATUS_NO_FRIEND(31704),
    TIM_RESPONSE_FRIEND_STATUS_NO_REQ(30614),
    TIM_RESPONSE_FRIEND_STATUS_SELF_FRIEND_FULL(30615),
    TIM_RESPONSE_FRIEND_STATUS_FRIEND_EXIST(30617),
    TIM_RESPONSE_FRIEND_STATUS_OTHER_SIDE_FRIEND_FULL(30630),
    TIM_ADD_BLACKLIST_FRIEND_STATUS_IN_BLACK_LIST(31307),
    TIM_DEL_BLACKLIST_FRIEND_STATUS_NOT_IN_BLACK_LIST(31503),
    TIM_ADD_FRIEND_GROUP_STATUS_GET_SDKAPPID_FAILED(32207),
    TIM_ADD_FRIEND_GROUP_STATUS_NOT_FRIEND(32216),
    TIM_UPDATE_FRIEND_GROUP_STATUS_GET_SDKAPPID_FAILED(32511),
    TIM_UPDATE_FRIEND_GROUP_STATUS_ADD_NOT_FRIEND(32518),
    TIM_UPDATE_FRIEND_GROUP_STATUS_ADD_ALREADY_IN_GROUP(32519),
    TIM_UPDATE_FRIEND_GROUP_STATUS_DEL_NOT_IN_GROUP(32520),
    TIM_UPDATE_FRIEND_GROUP_STATUS_MAX_GROUPS_EXCEED(32521);
    
    private long status;

    private TIMFriendStatus(long j) {
        this.status = j;
    }

    /* access modifiers changed from: package-private */
    public final long getValue() {
        return this.status;
    }
}