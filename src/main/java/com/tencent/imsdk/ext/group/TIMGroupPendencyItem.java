package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupExtHelper;
import com.tencent.imcore.GroupManagerExt;
import com.tencent.imcore.GroupPendencyItem;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;
import java.io.UnsupportedEncodingException;

public class TIMGroupPendencyItem {
    private static final String tag = "TIMGroupPendencyItem";
    private long addTime;
    private byte[] auth;
    private String fromUser;
    private String groupId;
    private String handledMsg;
    private long handledStatus;
    private String handledUserData;
    private String identifer;
    private byte[] key;
    private long operationType;
    private long pendencyType;
    private String requestMsg;
    private String requestUserData;
    private String toUser;

    TIMGroupPendencyItem(GroupPendencyItem groupPendencyItem) {
        this(IMLiteBridge.getIdentifier(TIMManager.getInstance()), groupPendencyItem);
    }

    TIMGroupPendencyItem(String str, GroupPendencyItem groupPendencyItem) {
        this.identifer = str;
        if (groupPendencyItem != null) {
            this.groupId = groupPendencyItem.getGroup_id();
            this.fromUser = groupPendencyItem.getFrom_id();
            this.toUser = groupPendencyItem.getTo_id();
            this.addTime = groupPendencyItem.getAdd_time();
            this.pendencyType = groupPendencyItem.getPendency_type();
            this.handledStatus = groupPendencyItem.getHandled();
            this.operationType = groupPendencyItem.getHandle_result();
            try {
                this.requestMsg = new String(groupPendencyItem.getApply_invite_msg(), "utf-8");
                this.requestUserData = new String(groupPendencyItem.getFrom_user_defined_data(), "utf-8");
                this.handledMsg = new String(groupPendencyItem.getApproval_msg(), "utf-8");
                this.handledUserData = new String(groupPendencyItem.getTo_user_defined_data(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            this.key = groupPendencyItem.getKey();
            this.auth = groupPendencyItem.getAuthentication();
        }
    }

    private String getHandledUserData() {
        return this.handledUserData;
    }

    private String getRequestUserData() {
        return this.requestUserData;
    }

    public void accept(String str, TIMCallBack tIMCallBack) {
        bn bnVar = new bn(this, tIMCallBack);
        if (str == null) {
            str = "";
        }
        try {
            if (getPendencyType() == TIMGroupPendencyGetType.APPLY_BY_SELF) {
                GroupManagerExt groupManagerExt = GroupExtHelper.getGroupManagerExt(this.identifer);
                String str2 = this.groupId;
                String str3 = this.fromUser;
                groupManagerExt.handleJoinRequest(str2, str3, str.getBytes("utf-8"), "".getBytes("utf-8"), 1, 0, this.auth, bnVar);
            } else if (getPendencyType() == TIMGroupPendencyGetType.INVITED_BY_OTHER) {
                GroupManagerExt groupManagerExt2 = GroupExtHelper.getGroupManagerExt(this.identifer);
                String str4 = this.groupId;
                String str5 = this.fromUser;
                groupManagerExt2.handleInviteRequest(str4, str5, str.getBytes("utf-8"), "".getBytes("utf-8"), 1, 0, this.auth, bnVar);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public long getAddTime() {
        return this.addTime / 1000;
    }

    public String getFromUser() {
        return this.fromUser;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getHandledMsg() {
        return this.handledMsg;
    }

    public TIMGroupPendencyHandledStatus getHandledStatus() {
        return this.handledStatus == ((long) TIMGroupPendencyHandledStatus.NOT_HANDLED.getValue()) ? TIMGroupPendencyHandledStatus.NOT_HANDLED : this.handledStatus == ((long) TIMGroupPendencyHandledStatus.HANDLED_BY_SELF.getValue()) ? TIMGroupPendencyHandledStatus.HANDLED_BY_SELF : this.handledStatus == ((long) TIMGroupPendencyHandledStatus.HANDLED_BY_OTHER.getValue()) ? TIMGroupPendencyHandledStatus.HANDLED_BY_OTHER : TIMGroupPendencyHandledStatus.NOT_HANDLED;
    }

    public TIMGroupPendencyOperationType getOperationType() {
        return this.operationType == ((long) TIMGroupPendencyOperationType.ACCEPT.getValue()) ? TIMGroupPendencyOperationType.ACCEPT : this.operationType == ((long) TIMGroupPendencyOperationType.REFUSE.getValue()) ? TIMGroupPendencyOperationType.REFUSE : TIMGroupPendencyOperationType.REFUSE;
    }

    public TIMGroupPendencyGetType getPendencyType() {
        return this.pendencyType == ((long) TIMGroupPendencyGetType.APPLY_BY_SELF.getValue()) ? TIMGroupPendencyGetType.APPLY_BY_SELF : this.pendencyType == ((long) TIMGroupPendencyGetType.INVITED_BY_OTHER.getValue()) ? TIMGroupPendencyGetType.INVITED_BY_OTHER : this.pendencyType == ((long) TIMGroupPendencyGetType.BOTH_SELFAPPLY_AND_INVITED.getValue()) ? TIMGroupPendencyGetType.BOTH_SELFAPPLY_AND_INVITED : TIMGroupPendencyGetType.APPLY_BY_SELF;
    }

    public String getRequestMsg() {
        return this.requestMsg;
    }

    public String getToUser() {
        return this.toUser;
    }

    public void refuse(String str, TIMCallBack tIMCallBack) {
        bo boVar = new bo(this, tIMCallBack);
        if (str == null) {
            str = "";
        }
        try {
            if (getPendencyType() == TIMGroupPendencyGetType.APPLY_BY_SELF) {
                GroupManagerExt groupManagerExt = GroupExtHelper.getGroupManagerExt(this.identifer);
                String str2 = this.groupId;
                String str3 = this.fromUser;
                groupManagerExt.handleJoinRequest(str2, str3, str.getBytes("utf-8"), "".getBytes("utf-8"), 0, 0, this.auth, boVar);
            } else if (getPendencyType() == TIMGroupPendencyGetType.INVITED_BY_OTHER) {
                GroupManagerExt groupManagerExt2 = GroupExtHelper.getGroupManagerExt(this.identifer);
                String str4 = this.groupId;
                String str5 = this.fromUser;
                groupManagerExt2.handleInviteRequest(str4, str5, str.getBytes("utf-8"), "".getBytes("utf-8"), 0, 0, this.auth, boVar);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }
}
