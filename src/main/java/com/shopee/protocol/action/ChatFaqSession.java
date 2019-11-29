package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ChatFaqSession extends Message {
    public static final Integer DEFAULT_ACTIVE_USER_ID = 0;
    public static final Boolean DEFAULT_FAQ_MODE = false;
    public static final Long DEFAULT_LAST_MESSAGE_TIME = 0L;
    public static final List<ChatMsg> DEFAULT_MESSAGES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer active_user_id;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean faq_mode;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long last_message_time;
    @ProtoField(label = Message.Label.REPEATED, messageType = ChatMsg.class, tag = 4)
    public final List<ChatMsg> messages;

    public ChatFaqSession(Integer num, Long l, Boolean bool, List<ChatMsg> list) {
        this.active_user_id = num;
        this.last_message_time = l;
        this.faq_mode = bool;
        this.messages = immutableCopyOf(list);
    }

    private ChatFaqSession(Builder builder) {
        this(builder.active_user_id, builder.last_message_time, builder.faq_mode, builder.messages);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatFaqSession)) {
            return false;
        }
        ChatFaqSession chatFaqSession = (ChatFaqSession) obj;
        if (!equals((Object) this.active_user_id, (Object) chatFaqSession.active_user_id) || !equals((Object) this.last_message_time, (Object) chatFaqSession.last_message_time) || !equals((Object) this.faq_mode, (Object) chatFaqSession.faq_mode) || !equals((List<?>) this.messages, (List<?>) chatFaqSession.messages)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.active_user_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.last_message_time;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.faq_mode;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<ChatMsg> list = this.messages;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ChatFaqSession> {
        public Integer active_user_id;
        public Boolean faq_mode;
        public Long last_message_time;
        public List<ChatMsg> messages;

        public Builder() {
        }

        public Builder(ChatFaqSession chatFaqSession) {
            super(chatFaqSession);
            if (chatFaqSession != null) {
                this.active_user_id = chatFaqSession.active_user_id;
                this.last_message_time = chatFaqSession.last_message_time;
                this.faq_mode = chatFaqSession.faq_mode;
                this.messages = ChatFaqSession.copyOf(chatFaqSession.messages);
            }
        }

        public Builder active_user_id(Integer num) {
            this.active_user_id = num;
            return this;
        }

        public Builder last_message_time(Long l) {
            this.last_message_time = l;
            return this;
        }

        public Builder faq_mode(Boolean bool) {
            this.faq_mode = bool;
            return this;
        }

        public Builder messages(List<ChatMsg> list) {
            this.messages = checkForNulls(list);
            return this;
        }

        public ChatFaqSession build() {
            return new ChatFaqSession(this);
        }
    }
}
