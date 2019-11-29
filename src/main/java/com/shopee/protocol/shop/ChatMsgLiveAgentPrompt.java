package com.shopee.protocol.shop;

import com.squareup.wire.Message;

public final class ChatMsgLiveAgentPrompt extends Message {
    private static final long serialVersionUID = 0;

    public int hashCode() {
        return 0;
    }

    public ChatMsgLiveAgentPrompt() {
    }

    private ChatMsgLiveAgentPrompt(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ChatMsgLiveAgentPrompt;
    }

    public static final class Builder extends Message.Builder<ChatMsgLiveAgentPrompt> {
        public Builder() {
        }

        public Builder(ChatMsgLiveAgentPrompt chatMsgLiveAgentPrompt) {
            super(chatMsgLiveAgentPrompt);
        }

        public ChatMsgLiveAgentPrompt build() {
            return new ChatMsgLiveAgentPrompt(this);
        }
    }
}
