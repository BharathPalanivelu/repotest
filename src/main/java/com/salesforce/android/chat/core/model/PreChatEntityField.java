package com.salesforce.android.chat.core.model;

import com.salesforce.android.chat.core.model.ChatEntityField;

@Deprecated
public class PreChatEntityField extends ChatEntityField {
    PreChatEntityField(String str, String str2, Builder builder) {
        super(str, new ChatUserData(str2), builder.mBuilder);
    }

    @Deprecated
    public String getName() {
        return getSalesforceObjectFieldName();
    }

    @Deprecated
    public static class Builder {
        /* access modifiers changed from: private */
        public final ChatEntityField.Builder mBuilder = new ChatEntityField.Builder();

        public Builder doFind(Boolean bool) {
            this.mBuilder.doFind(bool.booleanValue());
            return this;
        }

        public Builder doCreate(boolean z) {
            this.mBuilder.doCreate(z);
            return this;
        }

        public Builder isExactMatch(Boolean bool) {
            this.mBuilder.isExactMatch(bool.booleanValue());
            return this;
        }

        public PreChatEntityField build(String str, String str2) {
            return new PreChatEntityField(str, str2, this);
        }
    }
}
