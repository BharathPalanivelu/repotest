package com.tencent.imsdk.ext.sns;

import android.text.TextUtils;

public class TIMAddFriendRequest {
    private String addSource = "";
    private String addWording = "";
    private String friendGroup = "";
    private String identifier = "";
    private String remark = "";

    public TIMAddFriendRequest(String str) {
        if (str != null) {
            this.identifier = str;
        }
    }

    public String getAddSource() {
        return this.addSource;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public String getFriendGroup() {
        return this.friendGroup;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getRemark() {
        return this.remark;
    }

    public TIMAddFriendRequest setAddWording(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.addWording = str;
        return this;
    }

    public TIMAddFriendRequest setAddrSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.addSource = str;
        return this;
    }

    public TIMAddFriendRequest setFriendGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.friendGroup = str;
        return this;
    }

    public TIMAddFriendRequest setIdentifier(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.identifier = str;
        return this;
    }

    public TIMAddFriendRequest setRemark(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.remark = str;
        return this;
    }
}
