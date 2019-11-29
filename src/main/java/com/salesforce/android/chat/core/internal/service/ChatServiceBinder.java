package com.salesforce.android.chat.core.internal.service;

import android.os.Binder;

class ChatServiceBinder extends Binder {
    private final ChatServiceController mChatServiceController;

    private ChatServiceBinder(ChatServiceController chatServiceController) {
        this.mChatServiceController = chatServiceController;
    }

    /* access modifiers changed from: package-private */
    public ChatServiceController getChatServiceController() {
        return this.mChatServiceController;
    }

    static class Builder {
        Builder() {
        }

        /* access modifiers changed from: package-private */
        public ChatServiceBinder build(ChatServiceController chatServiceController) {
            return new ChatServiceBinder(chatServiceController);
        }
    }
}
