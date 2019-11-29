package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ChatRequestFailMessage {
    public static final String REASON_BLOCKED = "Blocked";
    public static final String REASON_INTERNAL_FAILURE = "InternalFailure";
    public static final String REASON_NO_AGENTS_AVAILABLE = "Unavailable";
    public static final String REASON_NO_POST = "NoPost";
    public static final String REASON_UNKNOWN = "Unknown";
    public static final String TYPE = "ChatRequestFail";
    @c(a = "reason")
    private String mReason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    public ChatRequestFailMessage(String str) {
        this.mReason = str;
    }

    public String getReason() {
        String str = this.mReason;
        return str == null ? "Unknown" : str;
    }
}
