package com.salesforce.android.chat.core.internal.service;

import android.content.Intent;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.service.common.utilities.validation.Arguments;

class ChatConfigurationSerializer {
    static final String CHAT_CONFIGURATION_EXTRA = "com.salesforce.android.chat.core.ChatConfiguration";

    ChatConfigurationSerializer() {
    }

    /* access modifiers changed from: package-private */
    public ChatConfiguration parseFromIntent(Intent intent) {
        ChatConfiguration chatConfiguration = (ChatConfiguration) intent.getExtras().getSerializable(CHAT_CONFIGURATION_EXTRA);
        Arguments.checkNotNull(chatConfiguration);
        return chatConfiguration;
    }

    /* access modifiers changed from: package-private */
    public Intent addToIntent(Intent intent, ChatConfiguration chatConfiguration) {
        intent.putExtra(CHAT_CONFIGURATION_EXTRA, chatConfiguration);
        return intent;
    }
}
