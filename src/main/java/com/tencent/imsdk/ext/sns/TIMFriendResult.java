package com.tencent.imsdk.ext.sns;

import com.tencent.imcore.FriendProfile;

public class TIMFriendResult {
    private String identifer;
    private String relationType;
    private long status;

    public TIMFriendResult(FriendProfile friendProfile) {
        this.identifer = friendProfile.getSIdentifier();
        this.status = friendProfile.getResult();
        this.relationType = friendProfile.getSResponseAction();
    }

    public String getIdentifer() {
        return this.identifer;
    }

    /* access modifiers changed from: protected */
    public String getRelationType() {
        return this.relationType;
    }

    public TIMFriendStatus getStatus() {
        for (TIMFriendStatus tIMFriendStatus : TIMFriendStatus.values()) {
            if (tIMFriendStatus.getValue() == this.status) {
                return tIMFriendStatus;
            }
        }
        return TIMFriendStatus.TIM_FRIEND_STATUS_UNKNOWN;
    }
}
