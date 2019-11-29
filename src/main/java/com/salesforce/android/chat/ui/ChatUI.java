package com.salesforce.android.chat.ui;

import android.content.Context;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

public class ChatUI {
    private InternalChatUIClient.Builder mChatUIClientBuilder = new InternalChatUIClient.Builder();
    private final ChatUIConfiguration mChatUIConfiguration;

    public static ChatUI configure(ChatUIConfiguration chatUIConfiguration) {
        return new ChatUI(chatUIConfiguration);
    }

    private ChatUI(ChatUIConfiguration chatUIConfiguration) {
        this.mChatUIConfiguration = chatUIConfiguration;
    }

    public Async<ChatUIClient> createClient(Context context) {
        BasicAsync create = BasicAsync.create();
        create.setResult(this.mChatUIClientBuilder.context(context).chatUIConfiguration(this.mChatUIConfiguration).build());
        return create;
    }

    /* access modifiers changed from: package-private */
    public ChatUI withChatUIClientBuilder(InternalChatUIClient.Builder builder) {
        this.mChatUIClientBuilder = builder;
        return this;
    }
}
