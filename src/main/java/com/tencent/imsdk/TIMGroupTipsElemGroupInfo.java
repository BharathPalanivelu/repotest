package com.tencent.imsdk;

public class TIMGroupTipsElemGroupInfo {
    private String content;
    private TIMGroupTipsGroupInfoType type;

    public String getContent() {
        return this.content;
    }

    public TIMGroupTipsGroupInfoType getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public void setContent(String str) {
        this.content = str;
    }

    /* access modifiers changed from: package-private */
    public void setType(int i) {
        TIMGroupTipsGroupInfoType tIMGroupTipsGroupInfoType;
        if (i == 1) {
            tIMGroupTipsGroupInfoType = TIMGroupTipsGroupInfoType.ModifyName;
        } else if (i == 2) {
            tIMGroupTipsGroupInfoType = TIMGroupTipsGroupInfoType.ModifyIntroduction;
        } else if (i == 3) {
            tIMGroupTipsGroupInfoType = TIMGroupTipsGroupInfoType.ModifyNotification;
        } else if (i == 4) {
            tIMGroupTipsGroupInfoType = TIMGroupTipsGroupInfoType.ModifyFaceUrl;
        } else if (i == 5) {
            this.type = TIMGroupTipsGroupInfoType.ModifyOwner;
            return;
        } else {
            return;
        }
        this.type = tIMGroupTipsGroupInfoType;
    }
}
