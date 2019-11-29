package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupBaseInfo;
import java.io.UnsupportedEncodingException;

public class TIMGroupBaseInfo {
    private String faceUrl = "";
    private String groupId = "";
    private String groupName = "";
    private String groupType = "";
    private boolean isSilenceAll = false;
    private TIMGroupBasicSelfInfo selfInfo = new TIMGroupBasicSelfInfo();

    TIMGroupBaseInfo() {
    }

    TIMGroupBaseInfo(GroupBaseInfo groupBaseInfo) {
        setGroupId(groupBaseInfo.getSGroupId());
        try {
            setGroupName(new String(groupBaseInfo.getSGroupName(), "utf-8"));
            setFaceUrl(new String(groupBaseInfo.getSFaceUrl(), "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        setGroupType(groupBaseInfo.getSGroupType());
        setSilenceAll(groupBaseInfo.getBAllShutup());
        this.selfInfo = new TIMGroupBasicSelfInfo(groupBaseInfo.getStSelfInfo());
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public TIMGroupBasicSelfInfo getSelfInfo() {
        return this.selfInfo;
    }

    public boolean isSilenceAll() {
        return this.isSilenceAll;
    }

    /* access modifiers changed from: package-private */
    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupId(String str) {
        this.groupId = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupName(String str) {
        this.groupName = str;
    }

    /* access modifiers changed from: package-private */
    public void setGroupType(String str) {
        this.groupType = str;
    }

    /* access modifiers changed from: package-private */
    public void setSilenceAll(boolean z) {
        this.isSilenceAll = z;
    }
}
