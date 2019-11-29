package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WebPush extends Message {
    public static final String DEFAULT_ACTION_TITLE = "";
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_IMAGE = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String action_title;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String url;

    public WebPush(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.content = str2;
        this.image = str3;
        this.url = str4;
        this.action_title = str5;
    }

    private WebPush(Builder builder) {
        this(builder.title, builder.content, builder.image, builder.url, builder.action_title);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebPush)) {
            return false;
        }
        WebPush webPush = (WebPush) obj;
        if (!equals((Object) this.title, (Object) webPush.title) || !equals((Object) this.content, (Object) webPush.content) || !equals((Object) this.image, (Object) webPush.image) || !equals((Object) this.url, (Object) webPush.url) || !equals((Object) this.action_title, (Object) webPush.action_title)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.image;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.url;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.action_title;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WebPush> {
        public String action_title;
        public String content;
        public String image;
        public String title;
        public String url;

        public Builder() {
        }

        public Builder(WebPush webPush) {
            super(webPush);
            if (webPush != null) {
                this.title = webPush.title;
                this.content = webPush.content;
                this.image = webPush.image;
                this.url = webPush.url;
                this.action_title = webPush.action_title;
            }
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder image(String str) {
            this.image = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder action_title(String str) {
            this.action_title = str;
            return this;
        }

        public WebPush build() {
            return new WebPush(this);
        }
    }
}
