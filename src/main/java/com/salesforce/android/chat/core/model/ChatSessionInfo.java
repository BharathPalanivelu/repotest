package com.salesforce.android.chat.core.model;

public interface ChatSessionInfo {
    SensitiveDataRule[] getSensitiveDataRules();

    String getVisitorId();
}
