package com.salesforce.android.chat.core.model;

import java.util.Date;

public interface ChatMessage {
    String getAgentId();

    String getAgentName();

    String getText();

    Date getTimestamp();
}
