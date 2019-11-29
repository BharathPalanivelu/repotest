package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatEndedMessage {
    public static final String REASON_AGENT = "agent";
    public static final String REASON_AGENTS_UNAVAILABLE = "agentsUnavailable";
    public static final String REASON_AGENT_PUSH_TIMEOUT = "agentPushTimeout";
    public static final String REASON_CLIENT = "client";
    public static final String REASON_CLIENT_IDLE_TIMEOUT = "clientIdleTimeout";
    public static final String REASON_NOPOST = "NoPost";
    public static final String REASON_UNKNOWN = "unknown";
    public static final String TYPE = "ChatEnded";
    @c(a = "reason")
    private String mReason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndReason {
    }

    public ChatEndedMessage(String str) {
        this.mReason = str;
    }

    public String getReason() {
        String str = this.mReason;
        return str == null ? "unknown" : str;
    }
}
