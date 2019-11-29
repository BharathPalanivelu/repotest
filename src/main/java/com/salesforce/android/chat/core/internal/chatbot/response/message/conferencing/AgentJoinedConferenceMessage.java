package com.salesforce.android.chat.core.internal.chatbot.response.message.conferencing;

import com.google.a.a.c;

public class AgentJoinedConferenceMessage {
    public static final String TYPE = "AgentJoinedConference";
    @c(a = "name")
    private String mAgentName;

    public AgentJoinedConferenceMessage(String str) {
        this.mAgentName = str;
    }

    public String getAgentName() {
        return this.mAgentName;
    }
}
