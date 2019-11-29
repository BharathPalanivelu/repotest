package com.salesforce.android.chat.core.model;

public interface ChatSentMessageReceipt {
    String getOriginalText();

    String getScrubbedText();

    SensitiveDataRule[] getTriggeredSensitiveDataRules();

    boolean isScrubbed();
}
