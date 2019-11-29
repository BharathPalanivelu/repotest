package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SendVmail extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public SendVmail(String str, String str2, Integer num, String str3) {
        this.requestid = str;
        this.email = str2;
        this.type = num;
        this.country = str3;
    }

    private SendVmail(Builder builder) {
        this(builder.requestid, builder.email, builder.type, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendVmail)) {
            return false;
        }
        SendVmail sendVmail = (SendVmail) obj;
        if (!equals((Object) this.requestid, (Object) sendVmail.requestid) || !equals((Object) this.email, (Object) sendVmail.email) || !equals((Object) this.type, (Object) sendVmail.type) || !equals((Object) this.country, (Object) sendVmail.country)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SendVmail> {
        public String country;
        public String email;
        public String requestid;
        public Integer type;

        public Builder() {
        }

        public Builder(SendVmail sendVmail) {
            super(sendVmail);
            if (sendVmail != null) {
                this.requestid = sendVmail.requestid;
                this.email = sendVmail.email;
                this.type = sendVmail.type;
                this.country = sendVmail.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SendVmail build() {
            checkRequiredFields();
            return new SendVmail(this);
        }
    }
}
