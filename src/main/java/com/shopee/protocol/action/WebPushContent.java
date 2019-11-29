package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class WebPushContent extends Message {
    public static final String DEFAULT_ACTION_TITLE = "";
    public static final String DEFAULT_BODY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_IMAGE = "";
    public static final String DEFAULT_PARAMETER = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String action_title;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String body;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String image;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String parameter;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String url;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer userid;

    public WebPushContent(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, Integer num3, String str6, f fVar) {
        this.title = str;
        this.body = str2;
        this.image = str3;
        this.url = str4;
        this.action_title = str5;
        this.timestamp = num;
        this.id = num2;
        this.userid = num3;
        this.parameter = str6;
        this.deviceid = fVar;
    }

    private WebPushContent(Builder builder) {
        this(builder.title, builder.body, builder.image, builder.url, builder.action_title, builder.timestamp, builder.id, builder.userid, builder.parameter, builder.deviceid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebPushContent)) {
            return false;
        }
        WebPushContent webPushContent = (WebPushContent) obj;
        if (!equals((Object) this.title, (Object) webPushContent.title) || !equals((Object) this.body, (Object) webPushContent.body) || !equals((Object) this.image, (Object) webPushContent.image) || !equals((Object) this.url, (Object) webPushContent.url) || !equals((Object) this.action_title, (Object) webPushContent.action_title) || !equals((Object) this.timestamp, (Object) webPushContent.timestamp) || !equals((Object) this.id, (Object) webPushContent.id) || !equals((Object) this.userid, (Object) webPushContent.userid) || !equals((Object) this.parameter, (Object) webPushContent.parameter) || !equals((Object) this.deviceid, (Object) webPushContent.deviceid)) {
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
        String str2 = this.body;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.image;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.url;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.action_title;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.id;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str6 = this.parameter;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WebPushContent> {
        public String action_title;
        public String body;
        public f deviceid;
        public Integer id;
        public String image;
        public String parameter;
        public Integer timestamp;
        public String title;
        public String url;
        public Integer userid;

        public Builder() {
        }

        public Builder(WebPushContent webPushContent) {
            super(webPushContent);
            if (webPushContent != null) {
                this.title = webPushContent.title;
                this.body = webPushContent.body;
                this.image = webPushContent.image;
                this.url = webPushContent.url;
                this.action_title = webPushContent.action_title;
                this.timestamp = webPushContent.timestamp;
                this.id = webPushContent.id;
                this.userid = webPushContent.userid;
                this.parameter = webPushContent.parameter;
                this.deviceid = webPushContent.deviceid;
            }
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder body(String str) {
            this.body = str;
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

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder parameter(String str) {
            this.parameter = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public WebPushContent build() {
            return new WebPushContent(this);
        }
    }
}
