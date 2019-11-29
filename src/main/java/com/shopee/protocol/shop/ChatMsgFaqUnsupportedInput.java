package com.shopee.protocol.shop;

import com.squareup.wire.Message;

public final class ChatMsgFaqUnsupportedInput extends Message {
    private static final long serialVersionUID = 0;

    public int hashCode() {
        return 0;
    }

    public ChatMsgFaqUnsupportedInput() {
    }

    private ChatMsgFaqUnsupportedInput(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ChatMsgFaqUnsupportedInput;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaqUnsupportedInput> {
        public Builder() {
        }

        public Builder(ChatMsgFaqUnsupportedInput chatMsgFaqUnsupportedInput) {
            super(chatMsgFaqUnsupportedInput);
        }

        public ChatMsgFaqUnsupportedInput build() {
            return new ChatMsgFaqUnsupportedInput(this);
        }
    }
}
