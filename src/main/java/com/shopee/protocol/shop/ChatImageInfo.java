package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatImageInfo extends Message {
    public static final String DEFAULT_IMAGEURL = "";
    public static final Integer DEFAULT_THUMBHEIGHT = 0;
    public static final String DEFAULT_THUMBURL = "";
    public static final Integer DEFAULT_THUMBWIDTH = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String imageUrl;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer thumbHeight;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String thumbUrl;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer thumbWidth;

    public ChatImageInfo(String str, String str2, Integer num, Integer num2) {
        this.imageUrl = str;
        this.thumbUrl = str2;
        this.thumbWidth = num;
        this.thumbHeight = num2;
    }

    private ChatImageInfo(Builder builder) {
        this(builder.imageUrl, builder.thumbUrl, builder.thumbWidth, builder.thumbHeight);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatImageInfo)) {
            return false;
        }
        ChatImageInfo chatImageInfo = (ChatImageInfo) obj;
        if (!equals((Object) this.imageUrl, (Object) chatImageInfo.imageUrl) || !equals((Object) this.thumbUrl, (Object) chatImageInfo.thumbUrl) || !equals((Object) this.thumbWidth, (Object) chatImageInfo.thumbWidth) || !equals((Object) this.thumbHeight, (Object) chatImageInfo.thumbHeight)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.imageUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.thumbUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.thumbWidth;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.thumbHeight;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatImageInfo> {
        public String imageUrl;
        public Integer thumbHeight;
        public String thumbUrl;
        public Integer thumbWidth;

        public Builder() {
        }

        public Builder(ChatImageInfo chatImageInfo) {
            super(chatImageInfo);
            if (chatImageInfo != null) {
                this.imageUrl = chatImageInfo.imageUrl;
                this.thumbUrl = chatImageInfo.thumbUrl;
                this.thumbWidth = chatImageInfo.thumbWidth;
                this.thumbHeight = chatImageInfo.thumbHeight;
            }
        }

        public Builder imageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public Builder thumbUrl(String str) {
            this.thumbUrl = str;
            return this;
        }

        public Builder thumbWidth(Integer num) {
            this.thumbWidth = num;
            return this;
        }

        public Builder thumbHeight(Integer num) {
            this.thumbHeight = num;
            return this;
        }

        public ChatImageInfo build() {
            checkRequiredFields();
            return new ChatImageInfo(this);
        }
    }
}
