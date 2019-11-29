package com.salesforce.android.chat.core.exception;

import com.salesforce.android.chat.core.model.SensitiveDataRule;

public class EmptyChatMessageException extends RuntimeException {
    private final SensitiveDataRule[] mTriggeredSensitiveDataRules;

    public EmptyChatMessageException() {
        super("Unable to send an empty message");
        this.mTriggeredSensitiveDataRules = new SensitiveDataRule[0];
    }

    public EmptyChatMessageException(SensitiveDataRule... sensitiveDataRuleArr) {
        super(String.format("Chat message has violated one or more Sensitive Data Rules which resulted in empty text.\nRules that have been triggered by this message:\n%s", new Object[]{sensitiveDataRuleArr}));
        this.mTriggeredSensitiveDataRules = sensitiveDataRuleArr;
    }

    public SensitiveDataRule[] getTriggeredSensitiveDataRules() {
        return this.mTriggeredSensitiveDataRules;
    }
}
