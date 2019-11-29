package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatMsgFaqFeedback extends Message {
    public static final Long DEFAULT_FEEDBACK_MSG_ID = 0L;
    public static final Boolean DEFAULT_HELPFUL = false;
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long feedback_msg_id;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean helpful;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String text;

    public ChatMsgFaqFeedback(Long l, Boolean bool, String str) {
        this.feedback_msg_id = l;
        this.helpful = bool;
        this.text = str;
    }

    private ChatMsgFaqFeedback(Builder builder) {
        this(builder.feedback_msg_id, builder.helpful, builder.text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgFaqFeedback)) {
            return false;
        }
        ChatMsgFaqFeedback chatMsgFaqFeedback = (ChatMsgFaqFeedback) obj;
        if (!equals((Object) this.feedback_msg_id, (Object) chatMsgFaqFeedback.feedback_msg_id) || !equals((Object) this.helpful, (Object) chatMsgFaqFeedback.helpful) || !equals((Object) this.text, (Object) chatMsgFaqFeedback.text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.feedback_msg_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Boolean bool = this.helpful;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.text;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaqFeedback> {
        public Long feedback_msg_id;
        public Boolean helpful;
        public String text;

        public Builder() {
        }

        public Builder(ChatMsgFaqFeedback chatMsgFaqFeedback) {
            super(chatMsgFaqFeedback);
            if (chatMsgFaqFeedback != null) {
                this.feedback_msg_id = chatMsgFaqFeedback.feedback_msg_id;
                this.helpful = chatMsgFaqFeedback.helpful;
                this.text = chatMsgFaqFeedback.text;
            }
        }

        public Builder feedback_msg_id(Long l) {
            this.feedback_msg_id = l;
            return this;
        }

        public Builder helpful(Boolean bool) {
            this.helpful = bool;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public ChatMsgFaqFeedback build() {
            return new ChatMsgFaqFeedback(this);
        }
    }
}
