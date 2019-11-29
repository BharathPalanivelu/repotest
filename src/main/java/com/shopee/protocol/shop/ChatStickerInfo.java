package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatStickerInfo extends Message {
    public static final String DEFAULT_FORMAT = "";
    public static final String DEFAULT_PACKID = "";
    public static final String DEFAULT_STICKERID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String format;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String packid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String stickerid;

    public ChatStickerInfo(String str, String str2, String str3) {
        this.stickerid = str;
        this.packid = str2;
        this.format = str3;
    }

    private ChatStickerInfo(Builder builder) {
        this(builder.stickerid, builder.packid, builder.format);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatStickerInfo)) {
            return false;
        }
        ChatStickerInfo chatStickerInfo = (ChatStickerInfo) obj;
        if (!equals((Object) this.stickerid, (Object) chatStickerInfo.stickerid) || !equals((Object) this.packid, (Object) chatStickerInfo.packid) || !equals((Object) this.format, (Object) chatStickerInfo.format)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.stickerid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.packid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.format;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatStickerInfo> {
        public String format;
        public String packid;
        public String stickerid;

        public Builder() {
        }

        public Builder(ChatStickerInfo chatStickerInfo) {
            super(chatStickerInfo);
            if (chatStickerInfo != null) {
                this.stickerid = chatStickerInfo.stickerid;
                this.packid = chatStickerInfo.packid;
                this.format = chatStickerInfo.format;
            }
        }

        public Builder stickerid(String str) {
            this.stickerid = str;
            return this;
        }

        public Builder packid(String str) {
            this.packid = str;
            return this;
        }

        public Builder format(String str) {
            this.format = str;
            return this;
        }

        public ChatStickerInfo build() {
            return new ChatStickerInfo(this);
        }
    }
}
