package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;
import com.salesforce.android.chat.core.internal.chatbot.response.message.ChatFooterMenuMessage;

public class ChatEstablishedMessage {
    public static final String TYPE = "ChatEstablished";
    @c(a = "userId")
    private String mAgentId;
    @c(a = "name")
    private String mAgentName;
    @c(a = "chasitorIdleTimeout")
    private ChasitorIdleTimeout mChasitorIdleTimeout;
    @c(a = "items")
    private ChatFooterMenuMessage mFooterMenu;
    @c(a = "sneakPeekEnabled")
    private boolean mIsSneakPeekEnabled;

    public ChatEstablishedMessage(String str, String str2, boolean z, boolean z2, ChatFooterMenuMessage chatFooterMenuMessage) {
        this.mAgentName = str;
        this.mAgentId = str2;
        this.mChasitorIdleTimeout = new ChasitorIdleTimeout(z);
        this.mIsSneakPeekEnabled = z2;
        this.mFooterMenu = chatFooterMenuMessage;
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

    public ChatFooterMenuMessage getFooterMenu() {
        return this.mFooterMenu;
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

        /* access modifiers changed from: package-private */
        public int getWarningTimeSec() {
            return this.mWarningTimeSec;
        }

        /* access modifiers changed from: package-private */
        public int getTimeoutSec() {
            return this.mTimeoutSec;
        }
    }
}
