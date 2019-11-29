package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatNotificationInfo extends Message {
    public static final String DEFAULT_NOTIFICATION_FOR_RECEIVER = "";
    public static final String DEFAULT_NOTIFICATION_FOR_SENDER = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String notification_for_receiver;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String notification_for_sender;

    public ChatNotificationInfo(String str, String str2) {
        this.notification_for_sender = str;
        this.notification_for_receiver = str2;
    }

    private ChatNotificationInfo(Builder builder) {
        this(builder.notification_for_sender, builder.notification_for_receiver);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatNotificationInfo)) {
            return false;
        }
        ChatNotificationInfo chatNotificationInfo = (ChatNotificationInfo) obj;
        if (!equals((Object) this.notification_for_sender, (Object) chatNotificationInfo.notification_for_sender) || !equals((Object) this.notification_for_receiver, (Object) chatNotificationInfo.notification_for_receiver)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.notification_for_sender;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.notification_for_receiver;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatNotificationInfo> {
        public String notification_for_receiver;
        public String notification_for_sender;

        public Builder() {
        }

        public Builder(ChatNotificationInfo chatNotificationInfo) {
            super(chatNotificationInfo);
            if (chatNotificationInfo != null) {
                this.notification_for_sender = chatNotificationInfo.notification_for_sender;
                this.notification_for_receiver = chatNotificationInfo.notification_for_receiver;
            }
        }

        public Builder notification_for_sender(String str) {
            this.notification_for_sender = str;
            return this;
        }

        public Builder notification_for_receiver(String str) {
            this.notification_for_receiver = str;
            return this;
        }

        public ChatNotificationInfo build() {
            return new ChatNotificationInfo(this);
        }
    }
}
