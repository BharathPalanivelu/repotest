package com.salesforce.android.chat.core.model;

import com.salesforce.android.chat.core.model.ChatEntity;
import java.util.List;

@Deprecated
public class PreChatEntity extends ChatEntity {
    PreChatEntity(String str, Builder builder) {
        super(str, builder.mChatEntityBuilder);
    }

    public String getName() {
        return getSalesforceObjectType();
    }

    @Deprecated
    public String getSaveToTranscript() {
        return getLinkedTranscriptFieldName();
    }

    @Deprecated
    public String getLinkToEntityName() {
        return getLinkedSalesforceObjectType();
    }

    @Deprecated
    public String getLinkToEntityField() {
        return getLinkedSalesforceObjectFieldName();
    }

    @Deprecated
    public List<ChatEntityField> getPreChatEntityFields() {
        return getChatEntityFields();
    }

    @Deprecated
    public static class Builder {
        /* access modifiers changed from: private */
        public ChatEntity.Builder mChatEntityBuilder = new ChatEntity.Builder();

        public Builder preChatEntityFields(List<? extends ChatEntityField> list) {
            this.mChatEntityBuilder.chatEntityFields(list);
            return this;
        }

        public Builder addPreChatEntityField(PreChatEntityField preChatEntityField) {
            this.mChatEntityBuilder.addChatEntityField(preChatEntityField);
            return this;
        }

        public Builder showOnCreate(boolean z) {
            this.mChatEntityBuilder.showOnCreate(z);
            return this;
        }

        public Builder saveToTranscript(String str) {
            this.mChatEntityBuilder.linkToTranscriptField(str);
            return this;
        }

        public Builder linkToEntityName(String str) {
            this.mChatEntityBuilder.linkToEntityName(str);
            return this;
        }

        public Builder linkToEntityField(String str) {
            this.mChatEntityBuilder.linkToEntityField(str);
            return this;
        }

        public PreChatEntity build(String str) {
            return new PreChatEntity(str, this);
        }
    }
}
