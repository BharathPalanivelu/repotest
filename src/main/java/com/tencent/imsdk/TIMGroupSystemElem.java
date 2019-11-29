package com.tencent.imsdk;

import com.tencent.imcore.GroupReportElem;
import java.io.UnsupportedEncodingException;

public class TIMGroupSystemElem extends TIMElem {
    private byte[] authKey;
    private String groupId = "";
    private long msgKey;
    private TIMGroupMemberInfo opGroupMemberInfo;
    private String opReason = "";
    private String opUser = "";
    private TIMUserProfile opUserInfo;
    private String platform = "";
    private long subtype;
    private byte[] userData = null;

    public TIMGroupSystemElem() {
        this.type = TIMElemType.GroupSystem;
    }

    public TIMGroupSystemElem(GroupReportElem groupReportElem) {
        this.type = TIMElemType.GroupSystem;
        this.authKey = groupReportElem.getAuthentication();
        this.groupId = groupReportElem.getGroup();
        this.msgKey = groupReportElem.getMsg_key();
        try {
            this.opReason = new String(groupReportElem.getMsg(), "utf-8");
            this.platform = new String(groupReportElem.getPlatform(), "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.subtype = groupReportElem.getType();
        this.opUser = groupReportElem.getOperator_user();
        this.userData = groupReportElem.getUser_data();
        this.opUserInfo = new TIMUserProfile(groupReportElem.getOperator_user_info());
        this.opGroupMemberInfo = new TIMGroupMemberInfo(groupReportElem.getOperator_group_member_info());
    }

    public String getGroupId() {
        return this.groupId;
    }

    public TIMGroupMemberInfo getOpGroupMemberInfo() {
        return this.opGroupMemberInfo;
    }

    public String getOpReason() {
        return this.opReason;
    }

    public String getOpUser() {
        return this.opUser;
    }

    public TIMUserProfile getOpUserInfo() {
        return this.opUserInfo;
    }

    public String getPlatform() {
        return this.platform;
    }

    public TIMGroupSystemElemType getSubtype() {
        for (TIMGroupSystemElemType tIMGroupSystemElemType : TIMGroupSystemElemType.values()) {
            if (this.subtype == tIMGroupSystemElemType.getValue()) {
                return tIMGroupSystemElemType;
            }
        }
        return TIMGroupSystemElemType.INVALID;
    }

    public byte[] getUserData() {
        return this.userData;
    }

    /* access modifiers changed from: package-private */
    public void setPlatform(String str) {
        this.platform = str;
    }
}
