package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.TIMUserConfig;

public class TIMUserConfigGroupExt extends TIMUserConfig {
    public TIMUserConfigGroupExt(TIMUserConfig tIMUserConfig) {
        super(tIMUserConfig);
    }

    public TIMUserConfigGroupExt enableGroupStorage(boolean z) {
        this.isGroupStorageEnabled = z;
        return this;
    }

    public TIMGroupAssistantListener getGroupAssistantListener() {
        if (this.groupAssistantListener instanceof TIMGroupAssistantListener) {
            return (TIMGroupAssistantListener) this.groupAssistantListener;
        }
        return null;
    }

    public boolean isGroupStorageEnabled() {
        return this.isGroupStorageEnabled;
    }

    public TIMUserConfigGroupExt setGroupAssistantListener(TIMGroupAssistantListener tIMGroupAssistantListener) {
        this.groupAssistantListener = tIMGroupAssistantListener;
        return this;
    }
}
