package com.tencent.imsdk.ext.group;

import com.tencent.imcore.GroupCacheInfo;

public class TIMGroupCacheInfo {
    private TIMGroupDetailInfo groupInfo;
    private TIMGroupBasicSelfInfo selfInfo;

    TIMGroupCacheInfo() {
    }

    TIMGroupCacheInfo(GroupCacheInfo groupCacheInfo) {
        if (groupCacheInfo != null) {
            setGroupInfo(new TIMGroupDetailInfo(groupCacheInfo.getGroupInfo()));
            setSelfInfo(new TIMGroupBasicSelfInfo(groupCacheInfo.getSelfInfo()));
        }
    }

    public TIMGroupDetailInfo getGroupInfo() {
        return this.groupInfo;
    }

    public TIMGroupBasicSelfInfo getSelfInfo() {
        return this.selfInfo;
    }

    /* access modifiers changed from: package-private */
    public void setGroupInfo(TIMGroupDetailInfo tIMGroupDetailInfo) {
        this.groupInfo = tIMGroupDetailInfo;
    }

    /* access modifiers changed from: package-private */
    public void setSelfInfo(TIMGroupBasicSelfInfo tIMGroupBasicSelfInfo) {
        this.selfInfo = tIMGroupBasicSelfInfo;
    }
}
