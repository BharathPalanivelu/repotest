package com.salesforce.android.chat.core.model;

import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ChatEntity implements Serializable {
    private final List<ChatEntityField> mChatEntityFields;
    private final String mLinkedSalesforceObjectFieldName;
    private final String mLinkedSalesforceObjectType;
    private final String mLinkedTranscriptFieldName;
    private final String mSalesforceObjectType;
    private final boolean mShowOnCreate;

    ChatEntity(Builder builder) {
        this.mSalesforceObjectType = builder.mSalesforceObjectType;
        this.mChatEntityFields = builder.mChatEntityFields;
        this.mLinkedTranscriptFieldName = builder.mLinkedTranscriptFieldName;
        this.mShowOnCreate = builder.mShowOnCreate;
        this.mLinkedSalesforceObjectType = builder.mLinkedSalesforceObjectType;
        this.mLinkedSalesforceObjectFieldName = builder.mLinkedSalesforceObjectFieldName;
    }

    @Deprecated
    ChatEntity(String str, Builder builder) {
        this.mSalesforceObjectType = str;
        this.mChatEntityFields = builder.mChatEntityFields;
        this.mLinkedTranscriptFieldName = builder.mLinkedTranscriptFieldName;
        this.mShowOnCreate = builder.mShowOnCreate;
        this.mLinkedSalesforceObjectType = builder.mLinkedSalesforceObjectType;
        this.mLinkedSalesforceObjectFieldName = builder.mLinkedSalesforceObjectFieldName;
    }

    public String getSalesforceObjectType() {
        return this.mSalesforceObjectType;
    }

    public List<ChatEntityField> getChatEntityFields() {
        return this.mChatEntityFields;
    }

    public boolean getShowOnCreate() {
        return this.mShowOnCreate;
    }

    public String getLinkedTranscriptFieldName() {
        return this.mLinkedTranscriptFieldName;
    }

    public String getLinkedSalesforceObjectType() {
        return this.mLinkedSalesforceObjectType;
    }

    public String getLinkedSalesforceObjectFieldName() {
        return this.mLinkedSalesforceObjectFieldName;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public List<ChatEntityField> mChatEntityFields = new LinkedList();
        /* access modifiers changed from: private */
        public String mLinkedSalesforceObjectFieldName;
        /* access modifiers changed from: private */
        public String mLinkedSalesforceObjectType;
        /* access modifiers changed from: private */
        public String mLinkedTranscriptFieldName;
        /* access modifiers changed from: private */
        public String mSalesforceObjectType;
        /* access modifiers changed from: private */
        public boolean mShowOnCreate;

        public Builder addChatEntityField(ChatEntityField chatEntityField) {
            this.mChatEntityFields.add(chatEntityField);
            return this;
        }

        public Builder showOnCreate(boolean z) {
            this.mShowOnCreate = z;
            return this;
        }

        public Builder linkToTranscriptField(String str) {
            this.mLinkedTranscriptFieldName = str;
            return this;
        }

        public Builder linkToAnotherSalesforceObject(String str, String str2) {
            this.mLinkedSalesforceObjectType = str;
            this.mLinkedSalesforceObjectFieldName = str2;
            return this;
        }

        public Builder linkToAnotherSalesforceObject(ChatEntity chatEntity, String str) {
            this.mLinkedSalesforceObjectType = chatEntity.getSalesforceObjectType();
            this.mLinkedSalesforceObjectFieldName = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        @Deprecated
        public Builder chatEntityFields(List<? extends ChatEntityField> list) {
            this.mChatEntityFields = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        @Deprecated
        public Builder linkToEntityName(String str) {
            this.mLinkedSalesforceObjectType = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        @Deprecated
        public Builder linkToEntityField(String str) {
            this.mLinkedSalesforceObjectFieldName = str;
            return this;
        }

        public ChatEntity build(String str) {
            Arguments.checkNotNull(str);
            this.mSalesforceObjectType = str;
            return new ChatEntity(this);
        }
    }
}
