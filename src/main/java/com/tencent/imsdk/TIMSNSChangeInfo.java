package com.tencent.imsdk;

import com.tencent.imcore.FriendChangeUserInfo;
import java.io.UnsupportedEncodingException;

public class TIMSNSChangeInfo {
    private String identifier = "";
    private String nickName = "";
    private String remark = "";
    private String source = "";
    private String wording = "";

    TIMSNSChangeInfo() {
    }

    TIMSNSChangeInfo(FriendChangeUserInfo friendChangeUserInfo) {
        if (friendChangeUserInfo != null) {
            setIdentifier(friendChangeUserInfo.getIdentifier());
            try {
                setSource(new String(friendChangeUserInfo.getAdd_source(), "utf-8"));
                setWording(new String(friendChangeUserInfo.getAdd_wording(), "utf-8"));
                setNickName(new String(friendChangeUserInfo.getNick(), "utf-8"));
                setRemark(new String(friendChangeUserInfo.getRemark(), "utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getSource() {
        return this.source;
    }

    public String getWording() {
        return this.wording;
    }

    /* access modifiers changed from: package-private */
    public void setIdentifier(String str) {
        this.identifier = str;
    }

    /* access modifiers changed from: package-private */
    public void setNickName(String str) {
        this.nickName = str;
    }

    /* access modifiers changed from: package-private */
    public void setRemark(String str) {
        this.remark = str;
    }

    /* access modifiers changed from: package-private */
    public void setSource(String str) {
        this.source = str;
    }

    /* access modifiers changed from: package-private */
    public void setWording(String str) {
        this.wording = str;
    }
}
