package com.salesforce.android.chat.core.internal.model;

import com.salesforce.android.chat.core.model.ChatSentMessageReceipt;
import com.salesforce.android.chat.core.model.SensitiveDataRule;

class ChatSentMessageReceiptModel implements ChatSentMessageReceipt {
    private final String mOriginalText;
    private final String mScrubbedText;
    private final SensitiveDataRule[] mTriggeredSensitiveDataRules;

    ChatSentMessageReceiptModel(String str, String str2, SensitiveDataRule[] sensitiveDataRuleArr) {
        this.mOriginalText = str;
        this.mScrubbedText = str2;
        this.mTriggeredSensitiveDataRules = sensitiveDataRuleArr;
    }

    public String getOriginalText() {
        return this.mOriginalText;
    }

    public String getScrubbedText() {
        return this.mScrubbedText;
    }

    public boolean isScrubbed() {
        return !this.mOriginalText.equals(this.mScrubbedText);
    }

    public SensitiveDataRule[] getTriggeredSensitiveDataRules() {
        return this.mTriggeredSensitiveDataRules;
    }
}
