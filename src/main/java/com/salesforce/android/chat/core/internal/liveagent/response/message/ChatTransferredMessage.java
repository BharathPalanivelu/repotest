package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;

public class ChatTransferredMessage {
    public static final String TYPE = "ChatTransferred";
    @c(a = "userId")
    private String mAgentId;
    @c(a = "name")
    private String mAgentName;
    @c(a = "chasitorIdleTimeout")
    private ChasitorIdleTimeout mChasitorIdleTimeout;
    @c(a = "sneakPeekEnabled")
    private boolean mIsSneakPeekEnabled;

    public ChatTransferredMessage(String str, String str2, boolean z) {
        this.mAgentName = str;
        this.mAgentId = str2;
        this.mIsSneakPeekEnabled = z;
    }

    public String getAgentName() {
        return this.mAgentName;
    }

    public String getAgentId() {
        return this.mAgentId;
    }

    public boolean isSneakPeekEnabled() {
        return this.mIsSneakPeekEnabled;
    }

    public ChasitorIdleTimeout getChasitorIdleTimeout() {
        return this.mChasitorIdleTimeout;
    }

    private static class ChasitorIdleTimeout {
        @c(a = "isEnabled")
        private boolean mIsEnabled;
        @c(a = "timeout")
        private int mTimeoutSec;
        @c(a = "warningTime")
        private int mWarningTimeSec;

        ChasitorIdleTimeout(boolean z) {
            this.mIsEnabled = z;
        }

        public boolean isEnabled() {
            return this.mIsEnabled;
        }

        public int getWarningTimeSec() {
            return this.mWarningTimeSec;
        }

        public int getTimeoutSec() {
            return this.mTimeoutSec;
        }
    }
}
