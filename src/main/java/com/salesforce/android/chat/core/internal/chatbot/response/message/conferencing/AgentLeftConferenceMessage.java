package com.salesforce.android.chat.core.internal.chatbot.response.message.conferencing;

import com.google.a.a.c;

public class AgentLeftConferenceMessage {
    public static final String TYPE = "AgentLeftConference";
    @c(a = "name")
    private String mAgentName;

    public AgentLeftConferenceMessage(String str) {
        this.mAgentName = str;
    }

    public String getAgentName() {
        return this.mAgentName;
    }
}
