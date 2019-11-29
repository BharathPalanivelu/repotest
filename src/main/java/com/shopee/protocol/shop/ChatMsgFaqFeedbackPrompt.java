package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatMsgFaqFeedbackPrompt extends Message {
    public static final Boolean DEFAULT_FEEDBACK_SENT = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean feedback_sent;

    public ChatMsgFaqFeedbackPrompt(Boolean bool) {
        this.feedback_sent = bool;
    }

    private ChatMsgFaqFeedbackPrompt(Builder builder) {
        this(builder.feedback_sent);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgFaqFeedbackPrompt)) {
            return false;
        }
        return equals((Object) this.feedback_sent, (Object) ((ChatMsgFaqFeedbackPrompt) obj).feedback_sent);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Boolean bool = this.feedback_sent;
            i = bool != null ? bool.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaqFeedbackPrompt> {
        public Boolean feedback_sent;

        public Builder() {
        }

        public Builder(ChatMsgFaqFeedbackPrompt chatMsgFaqFeedbackPrompt) {
            super(chatMsgFaqFeedbackPrompt);
            if (chatMsgFaqFeedbackPrompt != null) {
                this.feedback_sent = chatMsgFaqFeedbackPrompt.feedback_sent;
            }
        }

        public Builder feedback_sent(Boolean bool) {
            this.feedback_sent = bool;
            return this;
        }

        public ChatMsgFaqFeedbackPrompt build() {
            return new ChatMsgFaqFeedbackPrompt(this);
        }
    }
}
