package com.salesforce.android.chat.core.internal.model;

import com.salesforce.android.chat.core.model.ChatMessage;
import java.util.Date;

class ChatMessageModel implements ChatMessage {
    private final String mAgentId;
    private final String mAgentName;
    private final String mText;
    private final Date mTimestamp;

    ChatMessageModel(String str, String str2, String str3, Date date) {
        this.mAgentName = str2;
        this.mAgentId = str;
        this.mText = str3;
        this.mTimestamp = date;
    }

    public String getAgentId() {
        return this.mAgentId;
    }

    public String getAgentName() {
        return this.mAgentName;
    }

    public String getText() {
        return this.mText;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }
}
