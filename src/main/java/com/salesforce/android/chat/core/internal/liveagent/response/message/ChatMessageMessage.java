package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;

public class ChatMessageMessage {
    public static final String TYPE = "ChatMessage";
    @c(a = "agentId")
    private String mAgentId;
    @c(a = "name")
    private String mAgentName;
    @c(a = "text")
    private String mText;

    public ChatMessageMessage(String str, String str2, String str3) {
        this.mText = str;
        this.mAgentName = str2;
        this.mAgentId = str3;
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
}
