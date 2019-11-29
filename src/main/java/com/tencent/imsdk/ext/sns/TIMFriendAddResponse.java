package com.tencent.imsdk.ext.sns;

import android.text.TextUtils;

public class TIMFriendAddResponse {
    private String identifier = "";
    private String remark = "";
    private TIMFriendResponseType type;

    public TIMFriendAddResponse(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.identifier = str;
        }
    }

    /* access modifiers changed from: package-private */
    public String getIdentifier() {
        return this.identifier;
    }

    /* access modifiers changed from: package-private */
    public String getRemark() {
        return this.remark;
    }

    /* access modifiers changed from: package-private */
    public TIMFriendResponseType getType() {
        return this.type;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setType(TIMFriendResponseType tIMFriendResponseType) {
        this.type = tIMFriendResponseType;
    }
}
