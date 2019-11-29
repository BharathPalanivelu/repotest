package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ChatQuickReplyContent extends Message {
    public static final List<String> DEFAULT_VALUE = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> value;

    public ChatQuickReplyContent(List<String> list) {
        this.value = immutableCopyOf(list);
    }

    private ChatQuickReplyContent(Builder builder) {
        this(builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatQuickReplyContent)) {
            return false;
        }
        return equals((List<?>) this.value, (List<?>) ((ChatQuickReplyContent) obj).value);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<String> list = this.value;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ChatQuickReplyContent> {
        public List<String> value;

        public Builder() {
        }

        public Builder(ChatQuickReplyContent chatQuickReplyContent) {
            super(chatQuickReplyContent);
            if (chatQuickReplyContent != null) {
                this.value = ChatQuickReplyContent.copyOf(chatQuickReplyContent.value);
            }
        }

        public Builder value(List<String> list) {
            this.value = checkForNulls(list);
            return this;
        }

        public ChatQuickReplyContent build() {
            return new ChatQuickReplyContent(this);
        }
    }
}
