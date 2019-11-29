package com.salesforce.android.chat.core.model;

import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;

public class ChatEntityField implements Serializable {
    private final boolean mDoCreate;
    private final boolean mDoFind;
    private final boolean mIsExactMatch;
    private final ChatUserData mMappedChatUserData;
    private final String mSalesforceObjectFieldName;

    ChatEntityField(Builder builder) {
        this.mSalesforceObjectFieldName = builder.mSalesforceObjectFieldName;
        this.mMappedChatUserData = builder.mMappedChatUserData;
        this.mDoFind = builder.mDoFind;
        this.mIsExactMatch = builder.mIsExactMatch;
        this.mDoCreate = builder.mDoCreate;
    }

    @Deprecated
    ChatEntityField(String str, ChatUserData chatUserData, Builder builder) {
        this.mSalesforceObjectFieldName = str;
        this.mMappedChatUserData = chatUserData;
        this.mDoFind = builder.mDoFind;
        this.mIsExactMatch = builder.mIsExactMatch;
        this.mDoCreate = builder.mDoCreate;
    }

    public String getSalesforceObjectFieldName() {
        return this.mSalesforceObjectFieldName;
    }

    public ChatUserData getMappedChatUserData() {
        return this.mMappedChatUserData;
    }

    public boolean doFind() {
        return this.mDoFind;
    }

    public boolean doCreate() {
        return this.mDoCreate;
    }

    public boolean isExactMatch() {
        return this.mIsExactMatch;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean mDoCreate;
        /* access modifiers changed from: private */
        public boolean mDoFind;
        /* access modifiers changed from: private */
        public boolean mIsExactMatch;
        /* access modifiers changed from: private */
        public ChatUserData mMappedChatUserData;
        /* access modifiers changed from: private */
        public String mSalesforceObjectFieldName;

        public Builder doFind(boolean z) {
            this.mDoFind = z;
            return this;
        }

        public Builder doCreate(boolean z) {
            this.mDoCreate = z;
            return this;
        }

        public Builder isExactMatch(boolean z) {
            this.mIsExactMatch = z;
            return this;
        }

        public ChatEntityField build(String str, ChatUserData chatUserData) {
            Arguments.checkNotNull(str);
            Arguments.checkNotNull(chatUserData);
            this.mSalesforceObjectFieldName = str;
            this.mMappedChatUserData = chatUserData;
            return new ChatEntityField(this);
        }
    }
}
