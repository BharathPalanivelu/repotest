package com.salesforce.android.chat.core.internal.model;

import com.salesforce.android.chat.core.model.ChatSessionInfo;
import com.salesforce.android.chat.core.model.SensitiveDataRule;

class ChatSessionInfoModel implements ChatSessionInfo {
    private final SensitiveDataRule[] mSensitiveDataRules;
    private final String mVisitorId;

    ChatSessionInfoModel(String str, SensitiveDataRule... sensitiveDataRuleArr) {
        this.mVisitorId = str;
        this.mSensitiveDataRules = sensitiveDataRuleArr;
    }

    public String getVisitorId() {
        return this.mVisitorId;
    }

    public SensitiveDataRule[] getSensitiveDataRules() {
        return this.mSensitiveDataRules;
    }
}
