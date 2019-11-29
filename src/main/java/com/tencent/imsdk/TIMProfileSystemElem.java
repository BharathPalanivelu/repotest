package com.tencent.imsdk;

public class TIMProfileSystemElem extends TIMElem {
    private String fromUser = "";
    private String nickName = "";
    private TIMProfileSystemType subType;

    public TIMProfileSystemElem() {
        this.type = TIMElemType.ProfileTips;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public String getNickName() {
        return this.nickName;
    }

    public TIMProfileSystemType getSubType() {
        return this.subType;
    }

    /* access modifiers changed from: package-private */
    public void setFromUser(String str) {
        this.fromUser = str;
    }

    /* access modifiers changed from: package-private */
    public void setNickName(String str) {
        this.nickName = str;
    }

    /* access modifiers changed from: package-private */
    public void setSubType(long j) {
        this.subType = j == ((long) TIMProfileSystemType.TIM_PROFILE_SYSTEM_FRIEND_PROFILE_CHANGE.ordinal()) ? TIMProfileSystemType.TIM_PROFILE_SYSTEM_FRIEND_PROFILE_CHANGE : TIMProfileSystemType.INVALID;
    }
}
