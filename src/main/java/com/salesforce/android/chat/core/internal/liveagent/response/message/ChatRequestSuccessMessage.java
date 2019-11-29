package com.salesforce.android.chat.core.internal.liveagent.response.message;

import com.google.a.a.c;
import com.salesforce.android.chat.core.model.SensitiveDataRule;

public class ChatRequestSuccessMessage {
    public static final String TYPE = "ChatRequestSuccess";
    @c(a = "connectionTimeout")
    private int mConnectionTimeoutMs;
    @c(a = "queuePosition")
    private int mQueuePosition;
    @c(a = "sensitiveDataRules")
    private SensitiveDataRule[] mSensitiveDataRules;
    @c(a = "visitorId")
    private String mVisitorId;

    public ChatRequestSuccessMessage(int i, int i2, String str, SensitiveDataRule... sensitiveDataRuleArr) {
        this.mConnectionTimeoutMs = i;
        this.mQueuePosition = i2;
        this.mVisitorId = str;
        this.mSensitiveDataRules = sensitiveDataRuleArr;
    }

    public int getConnectionTimeoutMs() {
        return this.mConnectionTimeoutMs;
    }

    public int getQueuePosition() {
        return this.mQueuePosition;
    }

    public String getVisitorId() {
        return this.mVisitorId;
    }

    public SensitiveDataRule[] getSensitiveDataRules() {
        return this.mSensitiveDataRules;
    }

    public static class SensitiveDataRule {
        @SensitiveDataRule.Action
        @c(a = "actionType")
        private String mActionType;
        @c(a = "id")
        private String mId;
        @c(a = "name")
        private String mName;
        @c(a = "pattern")
        private String mPattern;
        @c(a = "replacement")
        private String mReplacement;

        public SensitiveDataRule(String str, String str2, String str3, String str4, String str5) {
            this.mId = str;
            this.mName = str2;
            this.mPattern = str3;
            this.mActionType = str4;
            this.mReplacement = str5;
        }

        public String getId() {
            return this.mId;
        }

        public String getName() {
            return this.mName;
        }

        public String getPattern() {
            return this.mPattern;
        }

        @SensitiveDataRule.Action
        public String getActionType() {
            return this.mActionType;
        }

        public String getReplacement() {
            return this.mReplacement;
        }
    }
}
