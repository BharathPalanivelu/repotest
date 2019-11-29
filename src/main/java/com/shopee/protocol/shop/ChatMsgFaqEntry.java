package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatMsgFaqEntry extends Message {
    public static final Long DEFAULT_QUESTION_ID = 0L;
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long question_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String text;

    public ChatMsgFaqEntry(Long l, String str) {
        this.question_id = l;
        this.text = str;
    }

    private ChatMsgFaqEntry(Builder builder) {
        this(builder.question_id, builder.text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatMsgFaqEntry)) {
            return false;
        }
        ChatMsgFaqEntry chatMsgFaqEntry = (ChatMsgFaqEntry) obj;
        if (!equals((Object) this.question_id, (Object) chatMsgFaqEntry.question_id) || !equals((Object) this.text, (Object) chatMsgFaqEntry.text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.question_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.text;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatMsgFaqEntry> {
        public Long question_id;
        public String text;

        public Builder() {
        }

        public Builder(ChatMsgFaqEntry chatMsgFaqEntry) {
            super(chatMsgFaqEntry);
            if (chatMsgFaqEntry != null) {
                this.question_id = chatMsgFaqEntry.question_id;
                this.text = chatMsgFaqEntry.text;
            }
        }

        public Builder question_id(Long l) {
            this.question_id = l;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public ChatMsgFaqEntry build() {
            return new ChatMsgFaqEntry(this);
        }
    }
}
