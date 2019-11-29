package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import d.d.b.j;
import java.util.Date;

public final class AgentIsTypingMessage implements MultiActorMessage {
    private String agentId;
    private String agentName;
    private final Date timestamp;

    public AgentIsTypingMessage(String str, String str2, Date date) {
        j.b(str, "agentId");
        j.b(str2, "agentName");
        j.b(date, "timestamp");
        this.agentId = str;
        this.agentName = str2;
        this.timestamp = date;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final void setAgentId(String str) {
        j.b(str, "<set-?>");
        this.agentId = str;
    }

    public final void setAgentName(String str) {
        j.b(str, "<set-?>");
        this.agentName = str;
    }

    public String getId() {
        return this.agentId;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }
}
