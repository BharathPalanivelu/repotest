package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupSelfInfo;
import com.tencent.imsdk.TIMGroupMemberRoleType;
import com.tencent.imsdk.TIMGroupReceiveMessageOpt;

public class TIMGroupBasicSelfInfo {
    private long joinTime;
    private TIMGroupReceiveMessageOpt recvMsgOption = TIMGroupReceiveMessageOpt.ReceiveAndNotify;
    private TIMGroupMemberRoleType role = TIMGroupMemberRoleType.NotMember;

    TIMGroupBasicSelfInfo() {
    }

    TIMGroupBasicSelfInfo(GroupSelfInfo groupSelfInfo) {
        if (groupSelfInfo != null) {
            setRole(groupSelfInfo.getRole());
            setJoinTime(groupSelfInfo.getJoinTime());
            for (TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt : TIMGroupReceiveMessageOpt.values()) {
                if (tIMGroupReceiveMessageOpt.getValue() == groupSelfInfo.getDwMsgFalg()) {
                    setRecvMsgOption(tIMGroupReceiveMessageOpt);
                }
            }
        }
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public TIMGroupReceiveMessageOpt getRecvMsgOption() {
        return this.recvMsgOption;
    }

    public TIMGroupMemberRoleType getRole() {
        return this.role;
    }

    /* access modifiers changed from: package-private */
    public void setJoinTime(long j) {
        this.joinTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setRecvMsgOption(TIMGroupReceiveMessageOpt tIMGroupReceiveMessageOpt) {
        this.recvMsgOption = tIMGroupReceiveMessageOpt;
    }

    /* access modifiers changed from: package-private */
    public void setRole(long j) {
        for (TIMGroupMemberRoleType tIMGroupMemberRoleType : TIMGroupMemberRoleType.values()) {
            if (j == tIMGroupMemberRoleType.getValue()) {
                this.role = tIMGroupMemberRoleType;
                return;
            }
        }
        this.role = TIMGroupMemberRoleType.NotMember;
    }
}
